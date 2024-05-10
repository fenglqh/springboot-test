package com.example.springdemo4mybatis.mapper;

import com.example.springdemo4mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperXmlTest {
    @Autowired
    private UserInfoMapperXml userInfoMapperXml;
    @Test
    void updateUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(15);
        userInfo.setUsername("马马酱");
        userInfoMapperXml.updateUserInfo(userInfo);
    }

    @Test
    void deleteUserInfo() {
        userInfoMapperXml.deleteUserInfo("泰兰德");
    }

    @Test
    void insertUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("up");
        userInfo.setPassword("poom");
        userInfo.setAge(21);
        userInfo.setGender(2);
        userInfoMapperXml.insertUserInfo(userInfo);
        System.out.println(userInfo.getId());
    }

    @Test
    void getUserInfoBy() {
        List<UserInfo> up = userInfoMapperXml.getUserInfoBy("up");
        for (UserInfo userInfo : up) {
            System.out.println(userInfo);
        }
    }
}