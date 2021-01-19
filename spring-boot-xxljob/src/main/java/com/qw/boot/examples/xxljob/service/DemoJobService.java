package com.qw.boot.examples.xxljob.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/18 6:32 下午
 * <br> Copyright (c) 2021/1/18 ZiYun Tech.
 */
@Service
@Slf4j
public class DemoJobService {
    public void demoTest(String s1) {
        log.info("====逻辑处理中==========参数：{}", s1);
    }
}
