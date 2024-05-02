package com.example.springioc.controller;

import org.springframework.stereotype.Component;


@Component
public class HController {
    public HController() {
        System.out.println("HController 已创建。。。");
    }
    public void sayHi() {
        System.out.println("HController...");
    }
}
