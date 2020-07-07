package com.account.balance.common;

import java.io.Serializable;

public class AccountResponse<T> implements Serializable {
    private static final long serialVersionUID = -4590018641470910727L;

    private int code;
    private String message;
    private T result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getResult() {
        return result;
    }

    public AccountResponse<T> code(int code) {
        this.code = code;
        return this;
    }

    public AccountResponse<T> message(String message) {
        this.message = message;
        return this;
    }

    public AccountResponse<T> result(T result) {
        this.result = result;
        return this;
    }
}
