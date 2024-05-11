package com.example.springdemo3.controller;

import com.example.springdemo3.model.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookControllerTest {
    @Autowired
    private BookController bookController;
    @Test
    void getList() {
        List<BookInfo> list = bookController.getList();
        for (BookInfo bookInfo : list) {
            System.out.println(bookInfo);
        }
    }
}