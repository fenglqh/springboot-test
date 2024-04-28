package com.example.springdemo3.controller;

import com.example.springdemo3.model.BookInfo;
import com.example.springdemo3.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {
    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        BookService bookService = new BookService();
        List<BookInfo> bookInfos = bookService.getBookList();
        return bookInfos;
    }
}
