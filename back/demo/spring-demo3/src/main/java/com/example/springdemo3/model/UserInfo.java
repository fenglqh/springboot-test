package com.example.springdemo3.model;

import lombok.Data;

import java.util.Date;
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Integer deleteFlag; // 0-未被删除 1-被删除
    private Date createTime;
    private Date updateTime;
}
