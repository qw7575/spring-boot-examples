package com.qw.boot.examples.exception.config;

/**
 * (自定义异常类)
 *
 * @author qiwu
 * <br> Date : 2021/1/5 6:08 下午
 * <br> Copyright (c) 2021/1/5 ZiYun Tech.
 */
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
