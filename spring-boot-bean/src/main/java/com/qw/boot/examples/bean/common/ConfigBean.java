package com.qw.boot.examples.bean.common;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/12 5:27 下午
 * <br> Copyright (c) 2021/1/12 ZiYun Tech.
 */
public class ConfigBean {
    private String type = "Configuration注解生成bean实体";

    public String getName(String name) {
        return name + " ___ " + type;
    }
}
