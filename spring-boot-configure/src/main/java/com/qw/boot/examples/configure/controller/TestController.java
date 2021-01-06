package com.qw.boot.examples.configure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PropertySource代表读取哪个文件，@Value获取值
 *
 * @author qiwu
 * <br> Date : 2021/1/6 6:22 下午
 * <br> Copyright (c) 2021/1/6 ZiYun Tech.
 */
@RestController
@PropertySource({"classpath:application.yml"})
public class TestController {

    @Autowired
    private ServerSettings serverSettings;

    @Value("${test.name}")
    private String name;

    @Value("${test.age}")
    private String age;

    @RequestMapping("/test1")
    public String test1() {
        return "服务名字：" + name + "，年龄是：" + age;
    }

    @RequestMapping("/test2")
    public Object test2(){
        return serverSettings;
    }

}
