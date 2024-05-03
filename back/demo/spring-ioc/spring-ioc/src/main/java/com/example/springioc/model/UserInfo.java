package com.example.springioc.model;

import lombok.Data;

import java.util.Date;


@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Date deleteFlag;
    private Date createTime;
    private Date updateTime;
}
