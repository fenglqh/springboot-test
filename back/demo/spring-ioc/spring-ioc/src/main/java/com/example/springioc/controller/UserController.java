package com.example.springioc.controller;

import com.example.springioc.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/user")
@RestController
public class UserController {
//    @Autowired
//    private UserInfo userInfo;
//    @Autowired
//    private UserInfo userInfo1;
//    @RequestMapping("/get1")
//    private void get1() {
//        System.out.println(userInfo == userInfo1);
//    }
    @Qualifier
    private UserInfo getUserInfo;
    @Qualifier
    private UserInfo getUserInfo1;
    @RequestMapping("/get1")
    private void get1() {
        System.out.println(getUserInfo1);
//        System.out.println(getUserInfo.toString());
//        System.out.println(getUserInfo1 == getUserInfo);
    }
}
