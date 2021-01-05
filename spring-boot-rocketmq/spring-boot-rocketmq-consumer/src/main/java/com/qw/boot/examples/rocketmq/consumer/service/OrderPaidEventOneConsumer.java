package com.qw.boot.examples.rocketmq.consumer.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/5 3:26 下午
 * <br> Copyright (c) 2021/1/5 ZiYun Tech.
 */
@Service
@RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-1")
public class OrderPaidEventOneConsumer implements RocketMQListener<String> {

    Logger logger = LoggerFactory.getLogger(OrderPaidEventOneConsumer.class);

    @Override
    public void onMessage(String message) {
        logger.error("------- 消费者，主题：test-topic-1 received:{}", message);
    }

}

