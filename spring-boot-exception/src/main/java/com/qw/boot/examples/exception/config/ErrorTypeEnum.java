package com.qw.boot.examples.exception.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/6 10:05 上午
 * <br> Copyright (c) 2021/1/6 ZiYun Tech.
 */
@Getter
@AllArgsConstructor
public enum  ErrorTypeEnum {
    /**
     * 错误类型
     */
    OBJECT_NOT_FOUND(0,"对象不存在"),

    INVALID_PARAMS(1,"参数不正确"),

    result_not_exist(2,"记录不存在");

    /**
     * 错误码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;
}
