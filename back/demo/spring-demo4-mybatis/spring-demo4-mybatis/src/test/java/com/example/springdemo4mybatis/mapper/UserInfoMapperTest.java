package com.example.springdemo4mybatis.mapper;

import com.example.springdemo4mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void getUserInfoAll() {
//        查所有数据
        List<UserInfo> userInfoAll = userInfoMapper.getUserInfoAll();
        for (UserInfo userInfo : userInfoAll) {
            System.out.println(userInfo);
        }
//        可以观察到虽然数据库结果都正确返回了，但是java对应属性并没有拿到相关的值
    }
    @Test
    void getUserInfoById() {
        int id = 1;
        UserInfo userInfoById = userInfoMapper.getUserInfoById(id);
        System.out.println(userInfoById);
    }

    @Test
    void getUserInfoBy1Id() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        UserInfo userInfoBy1Id = userInfoMapper.getUserInfoBy1Id(userInfo);
        System.out.println(userInfoBy1Id);
    }
    @Test
    void insertUserInfo() {
        // 这里数据库设置了主键递增
//        Integer i = userInfoMapper.insertUserInfo("ming", "joe", 13);
//        System.out.println(i);
        // 试一试数据库没设置主键递增会怎么样 好了结果会报错
        String userName = "泰兰德";
        Integer i = userInfoMapper.insertUserInfo(userName, "yy", 18);
        System.out.println(i);
        System.out.println(userName);

    }

    @Test
    void insertUserInfo1() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("joe");
        userInfo.setPassword("ming");
        userInfo.setAge(15);
        userInfoMapper.insertUserInfo1(userInfo);
    }

    @Test
    void insertUserInfo2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("rr");
        userInfo.setPassword("mmj");
        userInfo.setAge(15);
        userInfoMapper.insertUserInfo2(userInfo);
        System.out.println(userInfo.getAge());
    }



    @Test
    void getUserInfoBy2Id() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfoMapper.getUserInfoBy2Id(userInfo);
    }

    @Test
    void getUserInfoByDeleteFlag() {
        List<UserInfo> userInfoByDeleteFlag = userInfoMapper.getUserInfoByDeleteFlag(1);
        System.out.println(userInfoByDeleteFlag);
    }

    @Test
    void deleteUserInfoById() {
        userInfoMapper.deleteUserInfoById(10);
    }

    @Test
    void getUserInfoAll1() {
        List<UserInfo> userInfoAll1 = userInfoMapper.getUserInfoAll1();
        for (UserInfo userInfo : userInfoAll1) {
            System.out.println(userInfo);
        }
    }

    @Test
    void updateUserInfo() {
        userInfoMapper.updateUserInfo("xixi",16);
    }
}