package com.qw.boot.examples.rocketmq.producer.controller;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/5 2:21 下午
 * <br> Copyright (c) 2021/1/5 ZiYun Tech.
 */
@RestController
public class TestController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("test1")
    public String test1(){
        String name = "aaa";
        OrderPaidEvent order = new OrderPaidEvent("1111","22222");
        rocketMQTemplate.convertAndSend("test-topic-1", name);
        System.err.println("生产者给主题：test-topic-1，发送成功...。消息体："+ name);

        rocketMQTemplate.send("test-topic-2", MessageBuilder.withPayload(order).build());
        System.err.println("生产者给主题：test-topic-2，发送成功...。消息体："+ JSON.toJSONString(order));
        return "成功";
    }
}
