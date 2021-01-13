package com.qw.boot.examples.demo.controller;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String test(){
        return "hello word";
    }

}
