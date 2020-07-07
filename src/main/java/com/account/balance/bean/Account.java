package com.account.balance.bean;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 7296364155474903170L;

    /**
     * 主键,
     */
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
    private int balanceId;

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

    public int getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(int balanceId) {
        this.balanceId = balanceId;
    }
}
