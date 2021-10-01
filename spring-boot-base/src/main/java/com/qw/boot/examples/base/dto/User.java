package com.qw.boot.examples.base.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author qiwu
 * <br> Date : 2020/12/22 7:58 下午
 * <br> Copyright (c) 2020/12/22 ZiYun Tech.
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Integer sex;

    private Integer age;

    private String dese;

    public User (){
        super();
    }


}
