package com.qw.boot.examples.base.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体
 *
 * @author qiwu
 * <br> Date : 2020/12/22 6:39 下午
 * <br> Copyright (c) 2020/12/22 ZiYun Tech.
 */
@Data
public class Person implements Serializable {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
