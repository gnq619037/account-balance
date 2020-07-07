package com.account.balance.bean;

import java.io.Serializable;

public class LimitAccount implements Serializable {
    private static final long serialVersionUID = 5080870465987513122L;

    private long id;

    private long accountId;

    private long limitId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getLimitId() {
        return limitId;
    }

    public void setLimitId(long limitId) {
        this.limitId = limitId;
    }
}
