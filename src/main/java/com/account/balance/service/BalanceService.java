package com.account.balance.service;

import com.account.balance.bean.Account;
import com.account.balance.bean.Balance;
import com.account.balance.common.AccountResponse;

import java.util.List;

public interface BalanceService {

    public AccountResponse<String> addBalance(Balance balance);

    public AccountResponse<String> removeBalance(long id);

    public AccountResponse<String> modifyBalance(Balance balance);

    public AccountResponse<Balance> getBalance(Balance balance);
}
