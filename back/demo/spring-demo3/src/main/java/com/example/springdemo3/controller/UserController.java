package com.example.springdemo3.controller;

import javax.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public String login(String userName, String password, HttpSession session) {
//       参数校验
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength((password))) {
            return "用户名或密码为空";
        }
        if (!"cym".equals(userName) || !"123".equals(password)) {
            return "密码错误";
        }
        // 登录成功的情况下，需要将userName放到session里，以供后续使用
        session.setAttribute("userName", userName);
        return "登录成功";
    }
}
