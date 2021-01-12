package com.qw.boot.examples.bean.controller;

import com.alibaba.fastjson.JSON;
import com.qw.boot.examples.base.util.SpringContextUtil;
import com.qw.boot.examples.bean.common.ComponentBean;
import com.qw.boot.examples.bean.common.ConfigBean;
import com.qw.boot.examples.bean.common.ThirdComponentBean;
import com.qw.boot.examples.bean.common.ThirdConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/12 5:29 下午
 * <br> Copyright (c) 2021/1/12 ZiYun Tech.
 */
@RestController
public class BeanController {
    /**
     * 1、经典的注解引入方式 就是在@Configuration注解下生存bean
     */
    @Autowired
    private ConfigBean configBean;

    /**
     * 2、通过@Component方式注入bean 这里通过构造方法引入方式（也可和同上通过@Autowired注入）
     */
    @Autowired
    private ComponentBean componentBean;


    /**
     * 1、通过@Component方式注入bean
     */
    @Autowired
    private ThirdComponentBean thirdComponentBean;
    /**
     * 2、经典的注解引入方式 就是在@Configuration注解下生存bean
     */
    @Autowired
    private ThirdConfigBean thirdConfigBean;

    @GetMapping(path = "/bean")
    public String bean(String name) {
        Map<String, String> map = new HashMap(16);
        map.put("ComponentBean", componentBean.getName(name));
        map.put("ConfigBean", configBean.getName(name));
        return JSON.toJSONString(map);
    }

    @GetMapping(path = "/getBean")
    public String getBean() {
        ComponentBean s1 = SpringContextUtil.getBean(ComponentBean.class);
        ConfigBean s2 = SpringContextUtil.getBean(ConfigBean.class);
        System.out.println(s1);
        System.out.println(s2);
        return s1 +"----"+ s2;
    }

    @GetMapping(path = "/third-bean")
    public String third_bean(String name) {
        Map<String, String> map = new HashMap(16);
        map.put("ThirdComponentBean", thirdComponentBean.getName(name));
        map.put("ThirdConfigBean", thirdConfigBean.getName(name));
        return JSON.toJSONString(map);
    }
}