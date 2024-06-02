package com.example.spring_blog.service;

import com.example.spring_blog.mapper.UserMapper;
import com.example.spring_blog.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfo selectByUserAndPwd(String user, String pwd) {
        return userMapper.selectByUserAndPwd(user, pwd);
    }

    public Integer insertUser(String user, String pwd) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(user);
        userInfo.setPassword(pwd);
        return userMapper.insertUser(userInfo);
    }

    public UserInfo selectUserByUserName(String userName) {
        return userMapper.selectByUser(userName);
    }
}
