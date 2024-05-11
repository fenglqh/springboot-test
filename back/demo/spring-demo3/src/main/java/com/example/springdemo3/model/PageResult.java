package com.example.springdemo3.model;

import lombok.Data;

import java.util.List;
@Data
public class PageResult {
    private List<BookInfo> bookInfos;// 一页显示的数据
    private int count; // 一共有多少条数据
}
