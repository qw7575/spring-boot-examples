package com.qw.boot.examples.xxljob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/18 5:14 下午
 * <br> Copyright (c) 2021/1/18 ZiYun Tech.
 */
@SpringBootApplication
@MapperScan("com.qw.boot.examples.xxljob.mapper")
public class XxljobApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxljobApplication.class);
    }

}
