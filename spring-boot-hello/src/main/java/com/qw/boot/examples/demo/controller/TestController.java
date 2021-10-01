package com.qw.boot.examples.demo.controller;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/24 10:24 上午
 * <br> Copyright (c) 2020/12/24 ZiYun Tech.
 */
@Controller
public class TestController {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/hello")
    @ResponseBody
    public String test(){
        return "hello word";
    }


    @GetMapping("set")
    public String set(){
        RBucket<Object> bucket = redissonClient.getBucket("name");
        if(bucket.get() == null){
            bucket.set("wf.com");
        }
        return bucket.get().toString();
    }

}
