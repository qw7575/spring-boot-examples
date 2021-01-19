package com.qw.boot.examples.jsoup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author qiwu
 */
@SpringBootApplication
@EnableScheduling
public class JsoupApplication {
    public static void main(String[] args) {
        SpringApplication.run(JsoupApplication.class);
    }
}
