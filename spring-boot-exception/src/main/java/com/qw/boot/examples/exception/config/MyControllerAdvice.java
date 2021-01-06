package com.qw.boot.examples.exception.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * (添加全局异常注解)
 *
 * @author qiwu
 * <br> Date : 2021/1/5 6:05 下午
 * <br> Copyright (c) 2021/1/5 ZiYun Tech.
 */
@RestControllerAdvice
public class MyControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(MyControllerAdvice.class);

    //捕获全局异常，处理所有不可知的异常
    @ExceptionHandler(value=Exception.class)
    //@ResponseBody
    public Object handleException(Exception e, HttpServletRequest request) {
        LOG.error("msg:{},url:{}", e.getMessage(), request.getRequestURL());

        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }

    //自定义异常
    //需要添加thymeleaf依赖
    //路径：src/main/resources/templates/error.html
    @ExceptionHandler(value=MyException.class)
    public Object handleMyException(MyException e, HttpServletRequest request) {
        //返回Json数据，由前端进行界面跳转
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("msg", e.getMsg());
        map.put("url", request.getRequestURL());
        return map;

        //进行页面跳转
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/error.html");
//        modelAndView.addObject("msg", e.getMsg());
//        return modelAndView;
    }
}
