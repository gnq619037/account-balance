package com.account.balance.service.impl;

import com.account.balance.bean.Account;
import com.account.balance.common.AccountResponse;
import com.account.balance.dao.AccountMapper;
import com.account.balance.dao.BalanceLimitMapper;
import com.account.balance.enums.AccountStatus;
import com.account.balance.enums.ResponseCode;
import com.account.balance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private BalanceLimitMapper balanceLimitMapper;

    @Override
    public AccountResponse<String> addAccount(Account account) {
        if(account.getAccountStatus() != AccountStatus.MAINTAIN.code()) {
            account.setAccountStatus(AccountStatus.NO_MAINTAIN.code());
        }
        accountMapper.insertAccount(account);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("新增成功");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AccountResponse<String> removeAccount(long id) {
        accountMapper.deleteAccount(id);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("删除成功");
    }

    @Override
    public AccountResponse<String> modifyAccount(Account account) {
        accountMapper.updateAccount(account);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("修改成功");
    }

    @Override
    public AccountResponse<List<Account>> listAllAccount() {
        List<Account> accounts = accountMapper.queryAllAccount();
        return new AccountResponse<List<Account>>().code(ResponseCode.SUCCESS.code()).message("查询成功").result(accounts);
    }
}
