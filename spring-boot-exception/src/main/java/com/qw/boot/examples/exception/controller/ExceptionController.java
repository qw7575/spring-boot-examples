package com.qw.boot.examples.exception.controller;

import com.qw.boot.examples.exception.config.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/5 6:01 下午
 * <br> Copyright (c) 2021/1/5 ZiYun Tech.
 */
@RestController
@RequestMapping("/exce")
public class ExceptionController {

    @RequestMapping("/api/v1/exce")
    public Object testException() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ytheng");
        map.put("pwd", 123456);

        int data = 1/0;
        return map;
    }

    @RequestMapping("/api/v1/myexce")
    public Object testMyException() {

        throw new MyException("500", "my ext异常");

    }
}
