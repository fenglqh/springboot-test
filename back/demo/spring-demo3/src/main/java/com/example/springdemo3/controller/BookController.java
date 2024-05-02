package com.example.springdemo3.controller;

import com.example.springdemo3.model.BookInfo;
import com.example.springdemo3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
}
