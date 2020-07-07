package com.account.balance.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Balance implements Serializable {

    private static final long serialVersionUID = -6548547376657885595L;

    /**
     * 主键
     */
    private long id;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 限制
     */
    private BigDecimal limitRate;

    /**
     * 账户id
     */
    private long accountId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimitRate() {
        return limitRate;
    }

    public void setLimitRate(BigDecimal limitRate) {
        this.limitRate = limitRate;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
