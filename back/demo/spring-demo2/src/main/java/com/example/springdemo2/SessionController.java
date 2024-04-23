package com.example.springdemo2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;

public class SessionController {
    // 获取session

//    最原始的方式获取header
    @RequestMapping("/getheader")
    public String getHeader(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String header = request.getHeader("");
        return header;

    }
}
