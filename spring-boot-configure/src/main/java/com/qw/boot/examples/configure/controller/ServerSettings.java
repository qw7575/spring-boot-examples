package com.qw.boot.examples.configure.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * (实体获取配置)
 * 这是不需要写vlaue标签，只要text.name去掉前缀test后的name和这里name相同，就会自动赋值
 *
 * @author qiwu
 * <br> Date : 2021/1/6 6:31 下午
 * <br> Copyright (c) 2021/1/6 ZiYun Tech.
 */
@Component
@PropertySource({"classpath:application.yml"})
//@ConfigurationProperties
@ConfigurationProperties(prefix="test")
@Data
public class ServerSettings {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

}

