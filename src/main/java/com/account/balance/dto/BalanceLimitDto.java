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
     * 额度
     */
    private BigDecimal quota;

    /**
     * 限制
     */
    private int limitRate;

    private List<Account> accountList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    public int getLimitRate() {
        return limitRate;
    }

    public void setLimitRate(int limitRate) {
        this.limitRate = limitRate;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
