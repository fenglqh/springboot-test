package com.example.springdemo3.model;

import lombok.Data;

@Data
public class PageQuery {
    private Integer offset;
    private Integer pageNum = 1;
    private Integer pageSize = 2;

    public Integer getOffset() {
        return (pageNum - 1) * pageSize ;
    }
}
