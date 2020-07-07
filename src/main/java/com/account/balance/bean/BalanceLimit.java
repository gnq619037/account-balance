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
     * 限制
     */
    private BigDecimal limitRate;

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
}
