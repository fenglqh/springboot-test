package com.example.springdemo3.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    void getBookList() {
        bookService.getBookList();
    }

    @Test
    void queryBookListByPage() {
        bookService.queryBookListByPage(2);
    }
}