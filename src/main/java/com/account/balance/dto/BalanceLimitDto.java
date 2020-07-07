package com.account.balance.dto;

import com.account.balance.bean.Account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class BalanceLimitDto implements Serializable {
    private static final long serialVersionUID = -2384314268269185879L;
    /**
     * 主键
     */
    private long id;

    /**
     * 限制
     */
    private BigDecimal limitRate;

    private List<Account> accountList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getLimitRate() {
        return limitRate;
    }

    public void setLimitRate(BigDecimal limitRate) {
        this.limitRate = limitRate;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
