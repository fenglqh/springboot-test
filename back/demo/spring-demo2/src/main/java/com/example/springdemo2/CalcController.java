package com.example.springdemo2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/calc")
@RestController
public class CalcController {
    @RequestMapping("/sum")
    public String sum(Integer num1, Integer num2) {
        return "数字和为：" + (num1 + num2);
    }
}
