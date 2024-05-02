package com.example.springdemo3.service;

import com.example.springdemo3.dao.BookDao;
import com.example.springdemo3.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
//    service层就是对数据库数据进行逻辑处理
    public List<BookInfo> getBookList() {
//        BookDao bookDao = new BookDao();
        List<BookInfo> bookInfos = bookDao.mockData();
        for (BookInfo x : bookInfos) {
            if (x.getStatus() == 1) {
                x.setStatusCN("不可借阅");
            } else {
                x.setStatusCN("可借阅");
            }
        }
        return bookInfos;
    }
}
