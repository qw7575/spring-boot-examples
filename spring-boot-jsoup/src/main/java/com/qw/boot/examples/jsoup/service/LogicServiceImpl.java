package com.qw.boot.examples.jsoup.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.util.http.HttpUtil;
import com.qw.boot.examples.jsoup.job.SchedulePressTrigger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

/**
 * (抓取金色财经快讯)
 *
 * @author qiwu
 * <br> Date : 2021/1/14 5:53 下午
 * <br> Copyright (c) 2021/1/14 ZiYun Tech.
 */
@Service
public class LogicServiceImpl implements LogicService {

    Logger logger = LoggerFactory.getLogger(LogicServiceImpl.class);


    /**
     * 定时任务运行这个方法，doTask没有被重写，所有运行父类的方法
     */
    @Override
    public void start() {
        try {
            logger.info("执行获取财经快讯");
        } catch (Exception e) {
            logger.error("抓取金色财经新闻异常", e);
        }
    }



}
