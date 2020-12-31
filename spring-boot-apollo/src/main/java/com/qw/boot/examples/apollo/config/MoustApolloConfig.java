package com.qw.boot.examples.apollo.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.qw.boot.examples.apollo.bean.MoustConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/31 12:09 下午
 * <br> Copyright (c) 2020/12/31 ZiYun Tech.
 */
@Configuration
@EnableApolloConfig({"TEST1.application", "TEST1.moustApplication"})
public class MoustApolloConfig {

    @Bean
    public MoustConfigBean moustBean() {
        return new MoustConfigBean();
    }

}
