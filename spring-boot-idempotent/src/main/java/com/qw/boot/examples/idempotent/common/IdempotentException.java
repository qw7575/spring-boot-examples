package com.qw.boot.examples.idempotent.common;


/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/23 6:17 下午
 * <br> Copyright (c) 2020/12/23 ZiYun Tech.
 */
public class IdempotentException extends RuntimeException {

    public IdempotentException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
