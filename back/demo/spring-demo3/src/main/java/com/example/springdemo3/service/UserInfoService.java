package com.example.springdemo3.service;

import com.example.springdemo3.mapper.UserInfoMapper;
import com.example.springdemo3.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public UserInfo getUserInfoByName(String userName) {
        return userInfoMapper.SelectUserInfoByName(userName);
    }
}
