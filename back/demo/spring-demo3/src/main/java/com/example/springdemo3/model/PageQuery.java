package com.example.springdemo3.model;

import lombok.Data;

@Data
public class PageQuery {
    private Integer offset;
    private Integer limit;
    private Integer pageSize = 2;

    public PageQuery(Integer pageNumber) {
        this.offset = (pageNumber - 1) * pageSize;
        this.limit = pageSize;
    }
}
