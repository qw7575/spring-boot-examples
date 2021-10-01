package com.qw.boot.examples.demo.controller;

import java.util.concurrent.locks.LockSupport;

public class Test {
    public static void main(String[] args) {
        Thread threadStr = new Thread(() -> {
            System.out.println("开始");

            LockSupport.park();

            System.out.println("结束");
        });
        threadStr.start();
        System.out.println("执行逻辑");

        LockSupport.unpark(threadStr);
        System.out.println("执行逻辑结束");

    }
}
