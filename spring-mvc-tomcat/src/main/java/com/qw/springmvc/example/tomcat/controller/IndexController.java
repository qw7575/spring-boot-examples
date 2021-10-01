package com.qw.springmvc.example.tomcat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/test")
    public String index(){
        return "springmvc-tomcat";
    }
}
