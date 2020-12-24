package com.qw.boot.examples.base.dto;

import lombok.Data;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/22 7:58 下午
 * <br> Copyright (c) 2020/12/22 ZiYun Tech.
 */
@Data
public class User {
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
