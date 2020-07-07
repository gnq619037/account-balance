package com.account.balance.controller;

import com.account.balance.bean.Balance;
import com.account.balance.common.AccountResponse;
import com.account.balance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @PostMapping("/add")
    public AccountResponse<String> initBalance(@RequestBody Balance balance){
        return balanceService.addBalance(balance);
    }

    @PostMapping("/update")
    public AccountResponse<String> modifyBalance(@RequestBody Balance balance){
        return balanceService.modifyBalance(balance);
    }


}
