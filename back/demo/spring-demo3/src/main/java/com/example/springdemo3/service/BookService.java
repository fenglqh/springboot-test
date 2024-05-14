package com.example.springdemo3.service;

import com.example.springdemo3.enums.BookStatus;
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


    /**
     * 查询具体某一页的数据
     * @param pageNum
     * @return
     */
    public PageResult<BookInfo> queryBookListByPage(int pageNum) {
        // 查询要根据limit和offset来进行，所以需要先计算
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNum(pageNum);
        List<BookInfo> bookInfos = bookInfoMapper.getBookInfoByPage(pageQuery.getOffset(),pageQuery.getPageSize());
        // 对数据库数据进行处理
        for (BookInfo bookInfo : bookInfos) {
            bookInfo.setStatusCN(BookStatus.getDestByHash(bookInfo.getStatus()));
        }
        Integer count = bookInfoMapper.getCount();
        return new PageResult (bookInfos, count, pageQuery);
    }

    public Integer addBook(BookInfo bookInfo) {
        // 参数校验 前端处理好了后端就不要处理了
//        if (bookInfo.getStatusCN() == null) bookInfo.setStatus(1);
//        else bookInfo.setStatus(BookStatus.getCode(bookInfo.getStatusCN()));
        return bookInfoMapper.insertBookInfo(bookInfo);
    }

    public BookInfo queryBookListById(Integer id) {
        BookInfo bookInfo = bookInfoMapper.selectBookInfoById(id);
        bookInfo.setStatusCN(BookStatus.getDestByHash(bookInfo.getStatus()));
        return bookInfo;
    }

    public Integer updateBook(BookInfo bookInfo) {
        return bookInfoMapper.updateBookById(bookInfo);
    }

    public Integer deleteBook(Integer id) {
        return bookInfoMapper.deleteBookById(id);
    }

    public Integer batchDeleteBook(List<Integer> ids) {
        return bookInfoMapper.batchDeleteBook(ids);
    }
}
