package com.example.spring_blog.controller;


import com.example.spring_blog.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    public Result login(String username, String password) {
        log.info();
        Result result = new Result();
    }
}
