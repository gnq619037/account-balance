package com.account.balance.service.impl;

import com.account.balance.bean.Account;
import com.account.balance.bean.BalanceLimit;
import com.account.balance.common.AccountResponse;
import com.account.balance.dao.AccountMapper;
import com.account.balance.dao.BalanceLimitMapper;
import com.account.balance.dao.LimitAccountMapper;
import com.account.balance.dto.ConstParams;
import com.account.balance.dto.SceneDto;
import com.account.balance.enums.AccountStatus;
import com.account.balance.enums.ResponseCode;
import com.account.balance.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    public static List<String> messageList = new ArrayList<>();

    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private BalanceLimitMapper balanceLimitMapper;

    @Autowired
    private LimitAccountMapper limitAccountMapper;

    @Override
    public AccountResponse<String> addAccount(Account account) {
        if(account.getAccountStatus() != AccountStatus.MAINTAIN.code()) {
            account.setAccountStatus(AccountStatus.NO_MAINTAIN.code());
        }
        //默认init_quota额度
        if(account.getBalance() == null) {
            account.setBalance(ConstParams.INIT_QUOTA);
        }
        Account accountData = accountMapper.getAccountByCode(account.getAccountCode());
        if(accountData != null) {
            return new AccountResponse<String>().code(ResponseCode.FAIL.code()).message("该账号已存在");
        }
        int i = accountMapper.insertAccount(account);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AccountResponse<String> removeAccount(long id) {
        limitAccountMapper.deleteLimitAccountByAccount(id);
        accountMapper.deleteAccount(id);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("");
    }

    @Override
    public AccountResponse<String> modifyAccount(Account account) {
        int i = accountMapper.updateAccount(account);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("");
    }

    @Override
    public AccountResponse<String> addBalance(Account account) {
        return null;
    }

    @Override
    public AccountResponse<String> consumerBalance(SceneDto sceneDto) {
        messageList.clear();
        List<Account> accounts = accountMapper.queryAllAccount();
        if(accounts == null || accounts.size() == 0) {
            messageList.add("无账户数据");
            return new AccountResponse<String>().code(ResponseCode.FAIL.code()).message("无账户数据");
        }
        List<Account> consumerAccount = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < sceneDto.getAccountNum(); i++) {
            int index = random.nextInt(accounts.size());
            Account account = accounts.get(index);
            consumerAccount.add(account);
            accounts.remove(index);
            if(accounts.size() == 0) {
                break;
            }
            messageList.add("账号："+ account.getAccountCode()+"加入模拟消费场景...");
            logger.info("账号："+ account.getAccountCode()+"加入模拟消费场景...");
        }

        for(Account account : consumerAccount) {
            for(int i = 0; i < sceneDto.getTouchNum(); i++) {
                if(account.getAccountStatus() == AccountStatus.MAINTAIN.code()) {
                    BalanceLimit balanceLimit = balanceLimitMapper.getBalanceByAccountId(account.getId());
                    BigDecimal limitQuota = balanceLimit.getQuota().multiply(new BigDecimal(balanceLimit.getLimitRate()));
                    if(account.getBalance().compareTo(limitQuota) < 0) {
                        account.setBalance(balanceLimit.getQuota());
                        messageList.add("维护中的账户："+account.getAccountCode()+"消费超限制，进行余额恢复...");
                        logger.info("维护中的账户："+account.getAccountCode()+"消费超限制，进行余额恢复...");
                    }
                    if(account.getBalance().compareTo(sceneDto.getMoney()) > 0) {
                        BigDecimal balance = account.getBalance().subtract(sceneDto.getMoney());
                        account.setBalance(balance);
                        accountMapper.updateAccountBalance(account);
                        messageList.add("维护中的账户："+account.getAccountCode()+"消费"+sceneDto.getMoney());
                        logger.info("维护中的账户："+account.getAccountCode()+"消费"+sceneDto.getMoney());
                    } else {
                        messageList.add("维护中的账户："+account.getAccountCode()+"余额不足");
                        logger.info("维护中的账户："+account.getAccountCode()+"余额不足");
                        break;
                    }
                } else {
                    if(account.getBalance().compareTo(sceneDto.getMoney()) > 0) {
                        BigDecimal balance = account.getBalance().subtract(sceneDto.getMoney());
                        account.setBalance(balance);
                        accountMapper.updateAccountBalance(account);
                        messageList.add("未维护的账户："+account.getAccountCode()+"消费"+sceneDto.getMoney());
                        logger.info("未维护的账户："+account.getAccountCode()+"消费"+sceneDto.getMoney());
                    } else {
                        messageList.add("未维护的账户："+account.getAccountCode()+"余额不足");
                        logger.info("未维护的账户："+account.getAccountCode()+"余额不足");
                        break;
                    }
                }
            }
        }
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("场景模拟完成");
    }

    @Override
    public AccountResponse<List<String>> getConsumerMessage() {
        return new AccountResponse<List<String>>().code(ResponseCode.SUCCESS.code()).result(messageList);
    }

    @Override
    public AccountResponse<List<Account>> listAllAccount() {
        List<Account> accounts = accountMapper.queryAllAccount();
        return new AccountResponse<List<Account>>().code(ResponseCode.SUCCESS.code()).result(accounts);
    }
}
