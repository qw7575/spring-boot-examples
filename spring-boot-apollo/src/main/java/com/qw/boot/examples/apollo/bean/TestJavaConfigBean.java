package com.qw.boot.examples.apollo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/30 12:51 下午
 * <br> Copyright (c) 2020/12/30 ZiYun Tech.
 */
@ConfigurationProperties(prefix = "config")
@Component
public class TestJavaConfigBean {
    private String a1;

    private String a2;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }
}