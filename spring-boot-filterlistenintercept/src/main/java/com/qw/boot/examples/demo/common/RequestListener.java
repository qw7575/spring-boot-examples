package com.qw.boot.examples.demo.common;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2021/1/13 10:13 下午
 * <br> Copyright (c) 2021/1/13 ZiYun Tech.
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("======销毁监听器========");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) 				{
        System.out.println("======进入监听器========");
    }
}
