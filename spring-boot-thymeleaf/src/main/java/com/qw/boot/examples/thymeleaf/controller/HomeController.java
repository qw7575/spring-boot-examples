package com.qw.boot.examples.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 路径访问
 * 注意：
 * 配置里面不设置mvc.static-path-pattern: 的话并且不指定@RequestMapping("/")会默认访问static里面index文件
 * 配置里面设置mvc.static-path-pattern: /**会默认访问static里面index文件
 * 设置的话就会默认访问templates目录里面的inde文件，不需要设置@RequestMapping("/")来达到访问inde文件
 * 目录访问错误会跳到404或者500页面，ErrorInterceptor文件进行拦截
 *
 * @author qiwu
 * <br> Date : 2021/1/23 12:16 上午
 * <br> Copyright (c) 2021/1/23 ZiYun Tech.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String greeting(ModelMap modelMap){
        modelMap.addAttribute("name","其实我是个新手");
        modelMap.addAttribute("host","https://www.baidu.com");
        return "hello";
    }

}