package com.account.balance.controller;

import com.account.balance.bean.Account;
import com.account.balance.common.AccountResponse;
import com.account.balance.dto.SceneDto;
import com.account.balance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public AccountResponse<String> addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    @PostMapping("/delete")
    public AccountResponse<String> removeAccount(@RequestParam("id") long id){
        return accountService.removeAccount(id);
    }

    @PostMapping("/update")
    public AccountResponse<String> modifyAccount(@RequestBody Account account) {
        return accountService.modifyAccount(account);
    }

    @GetMapping("/list")
    public AccountResponse<List<Account>> listAllAccount() {
        return accountService.listAllAccount();
    }

    /**
     * 触发消费场景，随机挑选账户，进行消费场景模拟
     * @return
     */
    @PostMapping("/consumer/touch")
    public AccountResponse<String> touchConsumer(@RequestBody SceneDto sceneDto){
        return accountService.consumerBalance(sceneDto);
    }

    @GetMapping("/consumer/message")
    public AccountResponse<List<String>> consumerMessage(){
        return accountService.getConsumerMessage();
    }
}
