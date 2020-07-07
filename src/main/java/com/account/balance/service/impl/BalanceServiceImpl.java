package com.account.balance.service.impl;

import com.account.balance.bean.Account;
import com.account.balance.bean.BalanceLimit;
import com.account.balance.bean.LimitAccount;
import com.account.balance.common.AccountResponse;
import com.account.balance.dao.AccountMapper;
import com.account.balance.dao.BalanceLimitMapper;
import com.account.balance.dao.LimitAccountMapper;
import com.account.balance.dto.BalanceLimitDto;
import com.account.balance.enums.ResponseCode;
import com.account.balance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        balanceLimitMapper.insertBalanceLimit(balanceLimit);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("初始化余额成功");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AccountResponse<String> removeBalanceLimit(long id) {
        List<LimitAccount> accountList = limitAccountMapper.queryAccountByLimit(id);
        List<Long> accountIds = accountList.stream().map(e -> e.getAccountId()).collect(Collectors.toList());
        accountMapper.updateAccounts(accountIds);
        limitAccountMapper.deleteLimitAccount(id);
        balanceLimitMapper.deleteBalanceLimit(id);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("删除成功");
    }

    @Override
    public AccountResponse<String> modifyBalanceLimit(BalanceLimit balanceLimit) {
        balanceLimitMapper.updateBalanceLimit(balanceLimit);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("修改限制成功");
    }

    @Override
    public AccountResponse<String> relationAccount(BalanceLimitDto balanceLimitDto) {

        return null;
    }

    @Override
    public AccountResponse<List<BalanceLimit>> listLimitAccounts() {
        List<BalanceLimit> balanceLimits = balanceLimitMapper.queryAllLimit();
        return new AccountResponse<List<BalanceLimit>>().code(ResponseCode.SUCCESS.code()).message("操作无异常").result(balanceLimits);
    }

//    @Override
//    public AccountResponse<BalanceLimit> getBalance(BalanceLimit balanceLimit) {
//        BalanceLimit balanceLimitData = balanceLimitMapper.getBalanceByAccountId(balanceLimit.getAccountId());
//        return new AccountResponse<BalanceLimit>().code(ResponseCode.SUCCESS.code()).message("获取余额").result(balanceLimitData);
//    }
}
