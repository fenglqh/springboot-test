package com.example.springdemo3;

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
        List<BookInfo> bookInfos = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setAuthor("夜神月" + i);
            bookInfo.setBookName("书" + i);
            bookInfo.setNumbers(i*2);
            bookInfo.setPrice(new BigDecimal(3*i));
            bookInfo.setPublisher("出版社" + i);
            if (i % 3 == 0) {
                bookInfo.setStatus(2);
            } else {
                bookInfo.setStatus(1);
            }
            if (bookInfo.getStatus() == 1) {
                bookInfo.setStatusCN("可借阅");
            } else {
                bookInfo.setStatusCN("不可借阅");
            }
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
