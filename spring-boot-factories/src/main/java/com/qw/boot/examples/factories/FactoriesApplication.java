package com.qw.boot.examples.factories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qiwu
 */
@SpringBootApplication
//@Import({StuConfiguration.class})
//@ComponentScan(value = "com.qw.boot.examples.base.config")
public class FactoriesApplication {
    public static void main(String[] args) {
        SpringApplication.run(FactoriesApplication.class);
    }
}
