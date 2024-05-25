package com.example.spring_blog.mapper;

import com.example.spring_blog.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BlogMapperTest {

    @Autowired
    private BlogMapper blogMapper;
    @Test
    void selectBlogListByUserId() {
        System.out.println(blogMapper.selectBlogListByUserId(1));
    }

    @Test
    void selectBlogById() {
        System.out.println(blogMapper.selectBlogById(2));
    }

    @Test
    void selectUserIdByBlogId() {
        System.out.println(blogMapper.selectUserIdByBlogId(2));
    }

    @Test
    void updateBlog() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(2);
        blogInfo.setContent("电视剧狐妖比扑街");
        blogInfo.setUserId(1);
        blogMapper.updateBlog(blogInfo);
    }

    @Test
    void insertBlog() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setContent("hhh");
        blogInfo.setUserId(1);
        blogInfo.setTitle("第4篇博客");
        blogMapper.insertBlog(blogInfo);
    }
}