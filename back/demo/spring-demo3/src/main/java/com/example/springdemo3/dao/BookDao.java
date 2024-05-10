package com.example.springdemo3.dao;

import com.example.springdemo3.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class BookDao {
//    @Autowired
//    private BookInfo bookInfo; 这里不能用这个，因为设置的对象在变化
//    dao层存放直接从数据库中取数据的操作
    public List<BookInfo> mockData() {
        List<BookInfo> bookInfos = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setAuthor("夜神月" + i);
            bookInfo.setBookName("书" + i);
//            bookInfo.setNumbers(i*2);
            bookInfo.setPrice(new BigDecimal(3*i));
//            bookInfo.setPublisher("出版社" + i);
            if (i % 3 == 0) {
                bookInfo.setStatus(2);
            } else {
                bookInfo.setStatus(1);
            }
//            if (bookInfo.getStatus() == 1) {
//                bookInfo.setStatusCN("可借阅");
//            } else {
//                bookInfo.setStatusCN("不可借阅");
//            }
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
