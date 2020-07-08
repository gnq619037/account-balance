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

    @PostMapping("/delete")
    public AccountResponse<String> deleteBalanceLimit(@RequestBody BalanceLimit balanceLimit){
        return balanceService.removeBalanceLimit(balanceLimit.getId());
    }

    @PostMapping("/update")
    public AccountResponse<String> modifyBalanceLimit(@RequestBody BalanceLimitDto balanceLimitDto){
        return balanceService.modifyBalanceLimit(balanceLimitDto);
    }

    @PostMapping("/publish")
    public AccountResponse<String> relationAccount(@RequestBody BalanceLimitDto balanceLimit){
        return balanceService.relationAccount(balanceLimit);
    }

    @GetMapping("/list")
    public AccountResponse<List<BalanceLimit>> relationAccount(){
        return balanceService.listLimitAccounts();
    }
}
