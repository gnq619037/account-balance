package com.account.balance.service.impl;

import com.account.balance.bean.Account;
import com.account.balance.bean.BalanceLimit;
import com.account.balance.bean.LimitAccount;
import com.account.balance.common.AccountResponse;
import com.account.balance.dao.AccountMapper;
import com.account.balance.dao.BalanceLimitMapper;
import com.account.balance.dao.LimitAccountMapper;
import com.account.balance.dto.BalanceLimitDto;
import com.account.balance.enums.AccountStatus;
import com.account.balance.enums.ResponseCode;
import com.account.balance.service.BalanceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceLimitMapper balanceLimitMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private LimitAccountMapper limitAccountMapper;

    @Override
    public AccountResponse<String> addBalanceLimit(BalanceLimit balanceLimit) {
        int i = balanceLimitMapper.insertBalanceLimit(balanceLimit);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AccountResponse<String> removeBalanceLimit(long id) {
        BalanceLimitDto balanceLimitDto = balanceLimitMapper.getBalanceAccountsById(id);
        //删除策略后将账户设置为“未维护状态”
        for(Account account : balanceLimitDto.getAccountList()) {
            account.setAccountStatus(AccountStatus.NO_MAINTAIN.code());
        }
        accountMapper.updateAccounts(balanceLimitDto.getAccountList());
        //删除关系
        limitAccountMapper.deleteLimitAccount(id);
        balanceLimitMapper.deleteBalanceLimit(id);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("");
    }

    @Override
    public AccountResponse<String> modifyBalanceLimit(BalanceLimitDto balanceLimitDto) {
        List<Account> accountsData = accountMapper.queryAllAccount();
        List<LimitAccount> insertAccounts = new ArrayList<>();
        List<Account> updateAccounts = new ArrayList<>();
        balanceLimitDto.getAccountList().stream().forEach(e -> {
            boolean isExits = false;
            for(Account account : accountsData) {
                if(e.getId() == account.getId()) {
                    isExits = true;
                    updateAccounts.add(e);
                    break;
                }
            }
            if(!isExits) {
                LimitAccount limitAccount = new LimitAccount();
                limitAccount.setAccountId(e.getId());
                limitAccount.setLimitId(balanceLimitDto.getId());
                insertAccounts.add(limitAccount);
            }
        });
        //对账户入进来的账户进行余额重置，
        if(updateAccounts.size() > 0) {
            accountMapper.updateAccounts(updateAccounts);
        }

        //对未维护的账户，新建一个关系
        if(insertAccounts.size() > 0) {
            limitAccountMapper.insertLimitAccount(insertAccounts);
        }

        BalanceLimit balanceLimit = new BalanceLimit();
        BeanUtils.copyProperties(balanceLimitDto, balanceLimit);
        balanceLimitMapper.updateBalanceLimit(balanceLimit);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AccountResponse<String> relationAccount(BalanceLimitDto balanceLimitDto) {
        //对比账户，维护中的更新，未维护的新增
        List<Account> accounts = accountMapper.queryAllAccount();
        List<Account> updateAccounts = new ArrayList<>();
        List<Account> insertAccounts = new ArrayList<>();
        for(Account account : balanceLimitDto.getAccountList()) {
            for(Account accountData : accounts) {
                if(account.getId() == accountData.getId() && accountData.getAccountStatus() == AccountStatus.MAINTAIN.code()) {
                    return new AccountResponse<String>().code(ResponseCode.FAIL.code()).message("存在维护中的账户，无法发放，请直接修改");
                }
            }
            insertAccounts.add(account);
        }
        List<LimitAccount> insertLimitAccounts = new ArrayList<>();
        List<LimitAccount> updateLimitAccounts = new ArrayList<>();
        for(Account account : insertAccounts) {
            LimitAccount limitAccount = new LimitAccount();
            limitAccount.setAccountId(account.getId());
            limitAccount.setLimitId(balanceLimitDto.getId());
            insertLimitAccounts.add(limitAccount);
        }
        if(updateLimitAccounts.size() > 0) {
            limitAccountMapper.updateLimitAccounts(updateLimitAccounts);
        }
        if(insertLimitAccounts.size() > 0) {
            limitAccountMapper.insertLimitAccount(insertLimitAccounts);
        }
        //将发放对象的余额加满.
        accountMapper.updateAccounts(balanceLimitDto.getAccountList());
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("发放成功");
    }

    @Override
    public AccountResponse<List<BalanceLimit>> listLimitAccounts() {
        List<BalanceLimit> balanceLimits = balanceLimitMapper.queryAllLimit();
        return new AccountResponse<List<BalanceLimit>>().code(ResponseCode.SUCCESS.code()).message("操作无异常").result(balanceLimits);
    }
}
