package com.example.springdemo3.mapper;

import com.example.springdemo3.model.BookInfo;
import com.example.springdemo3.model.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Select("select * from book_info where ")
    List<BookInfo> getBookInfo();

    @Select("select * from book_info limit #{offset},#{limit}")
    List<BookInfo> getBookInfoByPage(PageQuery pageQuery);

    @Select("select count(1) from book_info")
    Integer getCount();

    @Select("insert into book_info(book_name, author, count, price, publish, status) " +
            "values(#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer insertBookInfo(BookInfo bookInfo);
}
