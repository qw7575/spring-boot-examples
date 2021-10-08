package com.qw.boot.examples.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Future;


/**
 * 描述
 *
 * @author: 72153169--秀总
 * @date: 2021/9/30 16:10
 * @Copyright (c) 2021/9/30 vivo Tech
 */
@Service
public class ServiceF {

    Logger logger = LoggerFactory.getLogger(ServiceF.class);

    @Async("getExecutor")
    public void get01() {
        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        logger.info("执行任务1，时间{}", currentTime.toLocalDate() +" "+ currentTime.toLocalTime());
    }

    @Async("getExecutor")
    public void get02() {
        LocalDateTime currentTime = LocalDateTime.now();
        logger.info("执行任务2，时间{}", currentTime.toLocalDate() +" "+ currentTime.toLocalTime());
    }

    @Async("getExecutor")
    public Future<String> execute(String req) {

        return new AsyncResult<>(req);
    }
}
