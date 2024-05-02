package com.example.springioc.controller;

import org.springframework.stereotype.Component;


@Component
public class HelloController {
    public HelloController() {
        System.out.println("HelloController 已创建。。。");
    }
    public void sayHi() {
        System.out.println("hellocontroller...");
    }
}
