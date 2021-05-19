package com.qw.boot.examples.starter.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 标识此类是配置类
@ConditionalOnClass(Redisson.class) // 表示只有指定的class在classpath上时才能被注册
@EnableConfigurationProperties(RedissonProperties.class) // 激活@ConfigurationProperties
public class RedissonAutoConfiguration {
    /**
    这里通过@EnableConfigurationProperties(RedissonProperties.class)配置类自动装配
    这里传参RedissonProperties实例，是要求这个bean自动装配到spring中的。如果未注入，是会报错的。
    */
    @Bean
    public RedissonClient redissonClient(RedissonProperties redissonProperties) {
        Config config = new Config();
        String prefix = "redis://";
        //是否加密判断

        if (redissonProperties.isSsl()) {
            prefix = "rediss://";
        }
        String address = prefix + redissonProperties.getHost() + ":" + redissonProperties.getPort();
        SingleServerConfig singleServerConfig = config.useSingleServer().setAddress(address)
                .setConnectTimeout(redissonProperties.getTimeout());
        return Redisson.create(config);
    }
}
