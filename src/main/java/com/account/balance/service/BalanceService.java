package com.account.balance.service;

import com.account.balance.bean.BalanceLimit;
import com.account.balance.bean.LimitAccount;
import com.account.balance.common.AccountResponse;
import com.account.balance.dto.BalanceLimitDto;

import java.util.List;

public interface BalanceService {

    public AccountResponse<String> addBalanceLimit(BalanceLimit balanceLimit);

    public AccountResponse<String> removeBalanceLimit(long id);

    public AccountResponse<String> modifyBalanceLimit(BalanceLimit balanceLimit);


    public AccountResponse<String> relationAccount(BalanceLimitDto balanceLimitDto);

    public AccountResponse<List<BalanceLimit>> listLimitAccounts();

//    public AccountResponse<BalanceLimit> getBalance(BalanceLimit balanceLimit);
}
