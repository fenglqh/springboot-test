package com.example.springdemo3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult<T> {
    private List<T> bookInfos;// 一页显示的数据
    private int count; // 一共有多少条数据
    private PageQuery pageQuery;
}
