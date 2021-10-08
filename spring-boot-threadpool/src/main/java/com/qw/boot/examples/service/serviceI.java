package com.qw.boot.examples.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * ÃèÊö
 *
 * @author: 72153169--Ðã×Ü
 * @date: 2021/9/30 16:15
 * @Copyright (c) 2021/9/30 vivo Tech
 */
@Service
public class serviceI {

    @Async("getExecutor")
    public Future<String> getf1() {
        return new AsyncResult<String>("1");
    }

    @Async("getExecutor")
    public Future<String> getf2() {
        return new AsyncResult<String>("1");
    }
}
