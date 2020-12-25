package com.qw.boot.examples.multienvironment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/22 6:40 下午
 * <br> Copyright (c) 2020/12/22 ZiYun Tech.
 */
@Controller
public class TestController {

    @Value("${environment}")
    private String environment;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "当前环境："+environment;
    }

}
