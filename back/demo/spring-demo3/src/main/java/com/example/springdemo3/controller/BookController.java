package com.example.springdemo3.controller;

import com.example.springdemo3.model.BookInfo;
import com.example.springdemo3.model.PageResult;
import com.example.springdemo3.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getList")
    public List<BookInfo> getList() {
//        BookService bookService = new BookService(); 控制权交给spring来创建
        List<BookInfo> bookInfos = bookService.getBookList();
        return bookInfos;
    }

    @RequestMapping("/bookInfo")
    public String addBook(BookInfo bookInfo) { // 可以试一试用json接收
        log.info("bookInfo: {}", bookInfo);
        return "";
    }

    @RequestMapping("/getBookListByPage")
    public PageResult getBookListByPage(int pageNum) {
        // 1. 参数校验
        List<BookInfo> bookInfos = bookService.queryBookListByPage(pageNum);
        Integer count = bookService.queryCount();
        PageResult pageResult = new PageResult();
        pageResult.setCount(count);
        pageResult.setBookInfos(bookInfos);
        return pageResult;
    }
}
