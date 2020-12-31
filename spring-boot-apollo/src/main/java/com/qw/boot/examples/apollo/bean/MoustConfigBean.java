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
@ConfigurationProperties
@Component
public class MoustConfigBean {
    private String timeout;

    private String test1;

    private String moust1;

    private String moust2;

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getMoust1() {
        return moust1;
    }

    public void setMoust1(String moust1) {
        this.moust1 = moust1;
    }

    public String getMoust2() {
        return moust2;
    }

    public void setMoust2(String moust2) {
        this.moust2 = moust2;
    }
}