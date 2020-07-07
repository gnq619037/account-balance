package com.account.balance.service;

import com.account.balance.bean.Account;
import com.account.balance.common.AccountResponse;

import java.util.List;

public interface AccountService {
    /**
     * 增加账户
     * @param account
     * @return
     */
    public AccountResponse<String> addAccount(Account account);


    /**
     * 删除账户
     * @param id
     * @return
     */
    public AccountResponse<String> removeAccount(long id);

    /**
     * 修改账户
     * @param account
     * @return
     */
    public AccountResponse<String> modifyAccount(Account account);

    /**
     * 获取所有账户
     * @return
     */
    public AccountResponse<List<Account>> listAllAccount();
}
