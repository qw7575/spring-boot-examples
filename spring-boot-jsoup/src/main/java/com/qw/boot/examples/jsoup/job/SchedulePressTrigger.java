package com.qw.boot.examples.jsoup.job;

import com.qw.boot.examples.jsoup.service.LogicService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/14 5:52 下午
 * <br> Copyright (c) 2021/1/14 ZiYun Tech.
 */
@Component
public class SchedulePressTrigger {

    Logger logger = LoggerFactory.getLogger(SchedulePressTrigger.class);


    @Autowired
    private LogicService logicService;

    /**
     * 定时抓取金色财经的新闻
     */
    @Scheduled(initialDelay = 1000, fixedRate = 10 * 1000)
    public void doCrawlJinSeLivePress() {
        logger.info("开始抓取金色财经新闻, time:" + new Date());
        try {
            logicService.start();
        } catch (Exception e) {
            logger.error("本次抓取金色财经新闻异常", e);
        }
        logger.info("结束抓取金色财经新闻, time:" + new Date());
    }
}
