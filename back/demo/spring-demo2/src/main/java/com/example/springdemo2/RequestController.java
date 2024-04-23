package com.example.springdemo2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

//RequestMapping 进行路由映射，/可以写可以不写但建议写
@RequestMapping("/req")
@RestController
public class RequestController {
    @RequestMapping("/r1")
    public String r1 (Integer age) {//传入一个整型
        return "age:" + age;
    }
    @RequestMapping("/r2")
    public String r2 (Integer age1, Integer age2) {
        return "age1:" + age1 + " age2:" + age2;//传入多个整型
    }
    @RequestMapping("/rr3")
    public String r3(String name) {
        return "name:" + name;// 传入一个字符串
    }
    @RequestMapping("/r4")
    public String r4 (int age) {//传入一个基础类型
        return "age:" + age;
    }
    @RequestMapping("/r5")
    public String r5 (Student student) {
        return student.toString();
    }
    @RequestMapping("/r6")
    public String r6 (String[] s) {
        return Arrays.toString(s);
    }
    @RequestMapping("/r7")
    public String r7 (@RequestParam("name") String username) {
        return "username:" + username;
    }

    @RequestMapping("r1/{articleId}")
    public String r8(@PathVariable("articleId") Integer articleId) {
        return "接收到参数，articleId：" + articleId;
    }
}
