package com.qw.boot.examples.thymeleaf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author qiwu
 * <br> Date : 2021/1/23 12:29 上午
 * <br> Copyright (c) 2021/1/23 ZiYun Tech.
 */
@Configuration
public class ErrorInterceptor implements HandlerInterceptor {
    /**
     * Controller方法调用之前调用，用于接收请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    /**
     * 请求拦截
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if(httpServletResponse.getStatus() == 500){
            modelAndView.setViewName("/error/500");
        }
        else if(httpServletResponse.getStatus() == 404){
            modelAndView.setViewName("/error/404");
        }
    }

    /**
     * 清理资源，当preHandle方法返回true调用
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

