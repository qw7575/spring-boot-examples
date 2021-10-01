package com.qw.boot.examples.jvm.controller;

import com.google.common.collect.Lists;
import com.qw.boot.examples.jvm.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class JstatController {

    List<User> userList = Lists.newArrayList();

    /**
     * -Xms32M -Xmx32M -XX:+HeapDumpOnOutOfMemoryError
     */
    @GetMapping("/heap")
    public void heap(){
        int i = 0;
        while (true) {
            userList.add(new User(i++, UUID.randomUUID().toString()));
        }
    }

    public Object lock1 = new Object();
    public Object lock2 = new Object();

    /**
     * 死锁
     */
    @GetMapping("/deadlock")
    public String deadlock(){
        new Thread(()-> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("锁1成功获取");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("锁2成功获取");
                }
            }
        }).start();

        return "返回结果，线程继续";
    }

}
