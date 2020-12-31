package com.qw.boot.examples.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qiwu
 */
@SpringBootApplication
@EnableApolloConfig
public class ApolloApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApolloApplication.class);
    }
}
