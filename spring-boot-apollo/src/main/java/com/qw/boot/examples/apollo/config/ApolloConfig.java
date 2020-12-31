package com.qw.boot.examples.apollo.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.qw.boot.examples.apollo.bean.DefaultConfigBean;
import com.qw.boot.examples.apollo.bean.TestJavaConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/30 12:50 下午
 * <br> Copyright (c) 2020/12/30 ZiYun Tech.
 */
@Configuration
@EnableApolloConfig
public class ApolloConfig {

    /**
     * 默认namespace获取
     * @return 默认配置
     */
    @Bean
    public TestJavaConfigBean testBean() {
        return new TestJavaConfigBean();
    }

    @Bean
    public DefaultConfigBean defaultBean() {
        return new DefaultConfigBean();
    }


}
