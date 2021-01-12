package com.qw.boot.examples.bean.common;

import org.springframework.stereotype.Component;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/12 6:17 下午
 * <br> Copyright (c) 2021/1/12 ZiYun Tech.
 */
@Component
public class ThirdComponentBean {
    private String type = "第三方ThirdComponent注解生成bean实体";

    public String getName(String name) {
        return name + " ___ " + type;
    }
}
