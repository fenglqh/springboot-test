package com.example.springioc;

import com.example.springioc.mapper.UserInfoMapper;
import com.example.springioc.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringIocApplicationTests {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void contextLoads() {
        List<UserInfo> userInfo = userInfoMapper.getUserInfo();
        System.out.println(userInfo);
    }

}
