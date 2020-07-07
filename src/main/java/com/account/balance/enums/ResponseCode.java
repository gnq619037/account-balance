package com.account.balance.enums;

/**
 * @author guonanqing
 * @date 2020/6/18 17:10
 * @version 1.0
 */
public enum ResponseCode {
    SUCCESS(0, "成功"),
    FAIL(1,"失败"),
    NOT_LOGIN(2, "未登录"),
    NO_PERMISSION(3, "无对应权限");

    private int code;
    private String desc;

    private ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String desc(){
        return this.desc;
    }

    public int code(){
        return this.code;
    }
}
