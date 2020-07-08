package com.account.balance.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/7/8 11:49
 */
public class SceneDto implements Serializable {
    private static final long serialVersionUID = 6465373348275236311L;

    private BigDecimal money;

    private int touchNum;

    private int accountNum;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getTouchNum() {
        return touchNum;
    }

    public void setTouchNum(int touchNum) {
        this.touchNum = touchNum;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }
}
