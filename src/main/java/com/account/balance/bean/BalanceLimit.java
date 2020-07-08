package com.account.balance.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class BalanceLimit implements Serializable {

    private static final long serialVersionUID = -6548547376657885595L;

    /**
     * 主键
     */
    private long id;

    /**
     * 额度
     */
    private BigDecimal quota;

    /**
     * 限制使用率
     */
    private int limitRate;

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
}
