package com.qw.boot.examples.apollo.controller;

import com.qw.boot.examples.apollo.bean.DefaultConfigBean;
import com.qw.boot.examples.apollo.bean.MoustConfigBean;
import com.qw.boot.examples.apollo.bean.TestJavaConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/30 6:47 下午
 * <br> Copyright (c) 2020/12/30 ZiYun Tech.
 */
@Controller
public class TestController {

    @Value("${timeout:200}")
    private String timeout;

    @Autowired
    private TestJavaConfigBean testJavaConfigBean;

    @Autowired
    private DefaultConfigBean defaultConfigBean;

    @Autowired
    private MoustConfigBean moustConfigBean;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "获取超时时间： " + timeout;
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        return "获取超时时间：" + testJavaConfigBean.getA1() + "--" + testJavaConfigBean.getA2();
    }

    @RequestMapping("test2")
    @ResponseBody
    public String test2() {
        return "获取超时时间：" + defaultConfigBean.getTest1() + "--" + defaultConfigBean.getTimeout();
    }

    @RequestMapping("test3")
    @ResponseBody
    public String test3() {
        return "获取超时时间：" + moustConfigBean.getMoust2() + "--" + moustConfigBean.getTimeout() + "--" + moustConfigBean.getMoust1() + "--" + moustConfigBean.getTest1();
    }

}
