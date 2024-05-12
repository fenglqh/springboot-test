package com.example.springdemo3.mapper;

import com.example.springdemo3.model.BookInfo;
import com.example.springdemo3.model.PageQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    @Select("select * from book_info where status != 0")
    List<BookInfo> getBookInfo();

    /**
     * 查询指定页的数据
     * @param
     * @return
     */
    @Select("select * from book_info where status != 0 limit #{offset},#{limit}")
    List<BookInfo> getBookInfoByPage(Integer offset, Integer limit);

    @Select("select count(1) from book_info where status != 0")
    Integer getCount();

    /**
     * 添加数据
     * @param bookInfo
     * @return
     */
    @Insert("insert into book_info(book_name, author, count, price, publish, status) " +
            "values(#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer insertBookInfo(BookInfo bookInfo);
}
