package com.example.springdemo2.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RequestMapping("/session")
@RestController
public class SessionController {
   // cookie是前端保存缓存的地方
    @RequestMapping("/getC")
    public String getCookie(HttpServletRequest request, HttpServletResponse response) {
        // 获取一次请求的参数
//        String name = request.getParameter("name");
        Cookie[] cookies = request.getCookies();
//        request.isRequestedSe
        if (cookies != null) {
            Arrays.stream(cookies).forEach(ck ->
                    System.out.println(ck.getName() + ":" + ck.getValue()));
        }
        return "获取cookie";
    }

    @RequestMapping("/getC2")
    public String getCookie2(@CookieValue("bite") String bite) {//可以在浏览器或者postman里伪造cookie
        return "从cookie中获取值,bite:" + bite;
    }
    @RequestMapping("/setS")
    public String setSession(HttpServletRequest request) {
//        从cookie中获取到了sessionID，根据sessionID获取session对象，如果没没有获取到，会创建一个新的session对象
        HttpSession session = request.getSession();
        session.setAttribute("name", "zhangsan");
        return "设置session成功";
    }

    @RequestMapping("/getS")
    public String getSession(HttpServletRequest request) {
//        从cookie中获取到了sessionID对象，根据session获取session对象
        HttpSession session = request.getSession();
        String ret = (String) session.getAttribute("name");
        return ret;
    }
    @RequestMapping("/getS2")
    public String getS2(HttpSession session) {
        String ret = (String) session.getAttribute("name");
        return ret;
    }
    @RequestMapping("/getS3")
    public String getS3(@SessionAttribute("name") String name) {
        return name;
    }
//    最原始的方式获取header
    @RequestMapping("/getH1")
    public String getHeader(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        return header;
    }
    @RequestMapping("/getH2")
    public String getHeader2(@RequestHeader("User-Agent") String header) {
        return header;
    }

}
