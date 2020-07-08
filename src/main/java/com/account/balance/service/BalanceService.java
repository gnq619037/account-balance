package com.account.balance.service;

import com.account.balance.bean.BalanceLimit;
import com.account.balance.common.AccountResponse;
import com.account.balance.dto.BalanceLimitDto;

import java.util.List;

public interface BalanceService {
    /**
     * 新增额度维护配置
     * @param balanceLimit
     * @return
     */
    public AccountResponse<String> addBalanceLimit(BalanceLimit balanceLimit);

    /**
     * 删除对应额度配置
     * @param id
     * @return
     */
    public AccountResponse<String> removeBalanceLimit(long id);

    /**
     * 修改额度配置
     * @param balanceLimitDto
     * @return
     */
    public AccountResponse<String> modifyBalanceLimit(BalanceLimitDto balanceLimitDto);

    /**
     * 将额度下发给对应的用户
     * @param balanceLimitDto
     * @return
     */
    public AccountResponse<String> relationAccount(BalanceLimitDto balanceLimitDto);

    /**
     * 获取额度配置列表
     * @return
     */
    public AccountResponse<List<BalanceLimit>> listLimitAccounts();
}
