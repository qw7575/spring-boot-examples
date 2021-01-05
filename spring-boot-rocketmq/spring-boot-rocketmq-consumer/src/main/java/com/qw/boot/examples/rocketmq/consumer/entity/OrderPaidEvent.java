package com.qw.boot.examples.rocketmq.consumer.entity;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/5 3:26 下午
 * <br> Copyright (c) 2021/1/5 ZiYun Tech.
 */
public class OrderPaidEvent {
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
