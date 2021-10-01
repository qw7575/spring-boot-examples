package com.qw.springmvc.example.tomcat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author qiwu
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.qw.springmvc.example.tomcat.controller")
public class SpringMvcConfig {

}
