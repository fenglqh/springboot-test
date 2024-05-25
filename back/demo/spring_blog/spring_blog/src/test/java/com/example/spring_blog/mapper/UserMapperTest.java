package com.example.spring_blog.mapper;
import com.example.spring_blog.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void selectByUserAndPwd() {
        System.out.println(userMapper.selectByUserAndPwd("hhh", "123456"));
    }

    @Test
    void selectById() {
        System.out.println(userMapper.selectById(1));
    }

    @Test
    void insertUser() {
        UserInfo u = new UserInfo();
        u.setUserName("eee");
        u.setPassword("123456");
        userMapper.insertUser(u);
    }

    @Test
    void updateUser() {
        UserInfo u = new UserInfo();
        u.setId(1);
        u.setUserName("hhh");
        u.setPassword("123456");
        userMapper.updateUser(u);
    }
}