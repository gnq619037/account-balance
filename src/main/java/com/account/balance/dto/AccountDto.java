package com.account.balance.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountDto implements Serializable {
    private static final long serialVersionUID = -659679116000533574L;
    private long id;
    /**
     * 账户号
     */
    private String accountCode;

    /**
     * 账户状态 1-正常， 2-维护中，3-不限定额度
     */
    private int accountStatus;

    /**
     * 对应额度id
     */
    private BigDecimal balance;

    private long limitId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getLimitId() {
        return limitId;
    }

    public void setLimitId(long limitId) {
        this.limitId = limitId;
    }
}
