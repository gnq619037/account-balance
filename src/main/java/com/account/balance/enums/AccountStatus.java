package com.account.balance.enums;

public enum AccountStatus {

    MAINTAIN(1, "维护中"),
    NO_MAINTAIN(2,"未维护");

    private int code;
    private String desc;

    private AccountStatus(int code, String desc){
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
