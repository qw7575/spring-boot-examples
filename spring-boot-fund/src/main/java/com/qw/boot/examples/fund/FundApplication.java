package com.qw.boot.examples.fund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author qiwu
 */
@SpringBootApplication
@ServletComponentScan
public class FundApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundApplication.class);
    }
}
