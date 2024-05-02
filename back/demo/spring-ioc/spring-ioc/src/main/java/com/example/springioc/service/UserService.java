package com.example.springioc.service;

import com.example.springioc.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Bean
    public UserInfo getUserInfo1() {
        return new UserInfo();
    }
    @Bean
    public UserInfo getUserInfo2() {
        return new UserInfo();
    }
    @Bean
    public UserInfo getUserInfo3() {
        return new UserInfo();
    }
    public void doService() {
        System.out.println("do service...");
    }
}
