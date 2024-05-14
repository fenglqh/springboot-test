package com.example.springdemo3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult<T> {
//    private int code;// 业务码，这个业务是处理成功还是失败
//    private String msg; // 告诉前端用户有没有登录
    private List<T> bookInfos;// 一页显示的数据
    private int count; // 一共有多少条数据
    private PageQuery pageQuery;
}
