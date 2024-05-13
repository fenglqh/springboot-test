package com.example.springdemo3.model;

import lombok.Data;

@Data
public class PageQuery {
    private Integer offset; // 从哪里开始显示
    private Integer pageNum = 1;// 第几页
    private Integer pageSize = 2; // 一页显示几条数据

    public Integer getOffset() {
        return (pageNum - 1) * pageSize ;
    }
}
