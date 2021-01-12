package com.qw.boot.examples.bean.common;

import org.springframework.stereotype.Component;

/**
 * Component方式bean
 * 注解＠Component 表明这个类将被Spring IoC容器扫描装配，bean的名称为componentBean。 如果不配置这个值 ，那IoC 容器就会把类名第一个字母作为小写，其他的不变作为 Bean 名称放入到 IoC 容器中。
 *
 * @author qiwu
 * <br> Date : 2021/1/12 5:25 下午
 * <br> Copyright (c) 2021/1/12 ZiYun Tech.
 */
@Component("componentBean")
public class ComponentBean {
    private String type = "@Component实例化bean";

    public String getName(String name) {
        return name + " ___ " + type;
    }
}
