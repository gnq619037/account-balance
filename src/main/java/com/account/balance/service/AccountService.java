package com.account.balance.service;

import com.account.balance.bean.Account;
import com.account.balance.common.AccountResponse;
import com.account.balance.dto.SceneDto;

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
     * 充值
     * @param account
     * @return
     */
    public AccountResponse<String> addBalance(Account account);

    /**
     * 消费场景模拟
     * @param sceneDto
     * @return
     */
    public AccountResponse<String>  consumerBalance(SceneDto sceneDto);

    /**
     * 获取消费场景的步骤描述-反馈前端响应
     * @return
     */
    public AccountResponse<List<String>> getConsumerMessage();

    /**
     * 获取所有账户
     * @return
     */
    public AccountResponse<List<Account>> listAllAccount();
}
