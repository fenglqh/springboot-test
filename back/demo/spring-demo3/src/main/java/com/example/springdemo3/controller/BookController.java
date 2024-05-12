package com.example.springdemo3.controller;

import com.example.springdemo3.model.BookInfo;
import com.example.springdemo3.model.PageResult;
import com.example.springdemo3.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        // 可以试一试用json接收
        log.info("add book info-----------------------:{}", bookInfo);
        // 1. 参数校验
        if (bookInfo == null || bookInfo.getBookName() == null || bookInfo.getAuthor() == null
        || bookInfo.getCount() == null || bookInfo.getPrice() == null || bookInfo.getCount() <= 0
            || bookInfo.getPublish() == null) {
            return "未填必填项";
        }
        log.info("bookInfo: {}", bookInfo);
        Integer i = bookService.addBook(bookInfo);
        // 2. 合法性检验
        if (i == null || i <= 0) {
            return "添加失败，请联系管理员";
        }
        return "";
    }

    @RequestMapping("/getBookListByPage")
    public PageResult<BookInfo> getBookListByPage(Integer pageNum) { // 不可以是int 类型，int 类型不可以为空，在此处不会自动初始化为0
        log.info("pageNum: ----------{}", pageNum);
        // 1. 参数校验
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        // 2. 逻辑处理
        // 如果查的元素为空呢？ 需要前端来进行控制
        PageResult<BookInfo> bookInfoPageResult = bookService.queryBookListByPage(pageNum);
        return bookInfoPageResult;
    }
}
