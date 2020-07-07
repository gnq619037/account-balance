package com.account.balance.service.impl;

import com.account.balance.bean.Balance;
import com.account.balance.common.AccountResponse;
import com.account.balance.dao.BalanceMapper;
import com.account.balance.enums.ResponseCode;
import com.account.balance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceMapper balanceMapper;

    @Override
    public AccountResponse<String> addBalance(Balance balance) {
        balanceMapper.insertBalance(balance);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("初始化余额成功");
    }

    @Override
    public AccountResponse<String> removeBalance(long id) {
        balanceMapper.deleteBalance(id);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("删除成功");
    }

    @Override
    public AccountResponse<String> modifyBalance(Balance balance) {
        balanceMapper.updateBalance(balance);
        return new AccountResponse<String>().code(ResponseCode.SUCCESS.code()).message("修改余额成功");
    }

    @Override
    public AccountResponse<Balance> getBalance(Balance balance) {
        Balance balanceData = balanceMapper.getBalanceByAccountId(balance.getAccountId());
        return new AccountResponse<Balance>().code(ResponseCode.SUCCESS.code()).message("获取余额").result(balanceData);
    }
}
