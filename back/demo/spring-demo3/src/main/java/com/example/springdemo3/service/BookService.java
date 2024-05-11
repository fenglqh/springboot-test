package com.example.springdemo3.service;

import com.example.springdemo3.BookStatus;
import com.example.springdemo3.mapper.BookInfoMapper;
import com.example.springdemo3.model.BookInfo;
import com.example.springdemo3.model.PageResult;
import com.example.springdemo3.model.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookInfoMapper bookInfoMapper;
//    service层就是对数据库数据进行逻辑处理
    public List<BookInfo> getBookList() {
        List<BookInfo> bookInfos = bookInfoMapper.getBookInfo();
//        不够优雅，可以封装成枚举项
//        实现方案 1. 返回enum 2. 返回desc 3. 写一个static方法，将枚举信息存在map中通过get方法调用（效率更高）
//        方法一：
//        for (BookInfo bookInfo : bookInfos)
//        {bookInfo.setStatusCN(BookStatus.getDescBycode(bookInfo.getStatus()).getDesc());}
//        方法二：
//          for (BookInfo bookInfo : bookInfos) {BookStatus.getDesc(bookInfo.getStatus());}
//        方法三：
        for (BookInfo bookInfo : bookInfos) {BookStatus.getDestByHash(bookInfo.getStatus());}
        return bookInfos;

    }


    public List<BookInfo> queryBookListByPage(int pageNum) {
        // 查询要根据limit和offset来进行，所以需要先计算
        PageQuery pageQuery = new PageQuery(pageNum);
        List<BookInfo> bookInfos = bookInfoMapper.getBookInfoByPage(pageQuery);
        return bookInfos;
    }

    public Integer queryCount() {
        Integer count = bookInfoMapper.getCount();
        return count;
    }
}
