package com.qw.boot.examples.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author qiwu
 */
@SpringBootApplication
@ServletComponentScan
public class FilterlisteninterceptApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterlisteninterceptApplication.class);
    }
}
