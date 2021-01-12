package com.qw.boot.examples.bean.config;

import com.qw.boot.examples.bean.common.ConfigBean;
import com.qw.boot.examples.bean.common.ThirdConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 代表将 configBean方法返回的 POJO 装配到 IoC 容器中, name为Bean 的名称，如果没有配置它，则会将方法名称作为 Bean 的名称保存到 Spring IoC 容器中 。
 *
 * @author qiwu
 * <br> Date : 2021/1/12 5:27 下午
 * <br> Copyright (c) 2021/1/12 ZiYun Tech.
 */
@Configuration
public class BeanConfig {
    @Bean
    public ConfigBean configBean() {
        return new ConfigBean();
    }

    @Bean
    public ThirdConfigBean thirdConfigBean() {
        return new ThirdConfigBean();
    }
}
