package com.qw.boot.examples.mybatis.controller;

import com.qw.boot.examples.base.dto.Person;
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


    @RequestMapping("/test")
    @ResponseBody
    public Person test(){

        return new Person("小明",18);
    }

}
