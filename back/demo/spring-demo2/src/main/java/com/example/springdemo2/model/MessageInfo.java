package com.example.springdemo2.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class MessageInfo {
    /**
     * 实体类，与数据库对应
     */
    private Integer id;
    private String from;
    private String to;
    // 加个映射，与数据库里的message对应
    private String say;
    private Integer deleteFlag; // 0-正常， 1-删除
    private Date createTime;
    private Date updateTime;
}
