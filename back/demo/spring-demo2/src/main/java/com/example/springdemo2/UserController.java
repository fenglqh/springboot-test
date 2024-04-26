package com.example.springdemo2;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
//        参数校验
        if (userName == null || userName.length() == 0 || password == null || password.length() == 0) {
            return false;
        }
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) return false;
//        return userName.equals("zhangsan") && password.equ als("123");
        if (!"zhangsan".equals(userName) || !"123".equals(password)) return false;
        session.setAttribute("userName",userName);
        return true;
        //好习惯
    }

    @RequestMapping("/index")
    public String getUsername(@SessionAttribute("userName") String name) {
        System.out.println(name);
        return name;
    }
}
