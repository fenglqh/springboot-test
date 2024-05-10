package com.example.springdemo3.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

//@Repository
@Data
public class BookInfo {
    private Integer id;
    private String author;
    private String bookName;
    private Integer count;
    private BigDecimal price;
    private String publish;
    private Integer status;// 1表示可借阅 2表示不可借阅
    private String statusCN;
    private Date createTime;
    private Date updateTime;
}
