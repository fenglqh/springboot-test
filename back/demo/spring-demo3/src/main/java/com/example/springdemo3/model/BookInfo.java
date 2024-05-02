package com.example.springdemo3.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
//@Repository
@Data
public class BookInfo {
    private Integer id;
    private String author;
    private String bookName;
    private Integer numbers;
    private BigDecimal price;
    private String publisher;
    private Integer status;// 1表示可借阅 2表示不可借阅
    private String statusCN;
}
