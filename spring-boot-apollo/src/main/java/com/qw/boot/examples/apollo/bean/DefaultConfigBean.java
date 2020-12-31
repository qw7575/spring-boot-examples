package com.qw.boot.examples.apollo.bean;

import lombok.ToString;
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
public class DefaultConfigBean {
    private String timeout;

    private String test1;

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
}