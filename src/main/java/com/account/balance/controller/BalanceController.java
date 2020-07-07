package com.account.balance.controller;

import com.account.balance.bean.BalanceLimit;
import com.account.balance.common.AccountResponse;
import com.account.balance.dto.BalanceLimitDto;
import com.account.balance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balanceLimit")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @PostMapping("/add")
    public AccountResponse<String> addBalanceLimit(@RequestBody BalanceLimit balanceLimit){
        return balanceService.addBalanceLimit(balanceLimit);
    }

    @PostMapping("/update")
    public AccountResponse<String> modifyBalanceLimit(@RequestBody BalanceLimit balanceLimit){
        return balanceService.modifyBalanceLimit(balanceLimit);
    }

    @PostMapping("/relation")
    public AccountResponse<String> relationAccount(@RequestBody BalanceLimitDto balanceLimit){
        return balanceService.relationAccount(balanceLimit);
    }

    @GetMapping("/list")
    public AccountResponse<List<BalanceLimit>> relationAccount(){
        return balanceService.listLimitAccounts();
    }
}
