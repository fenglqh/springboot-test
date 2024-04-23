package com.example.springdemo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/res")
//@RestController
@Controller
public class ResponseController {
    public String index() {
        return "/index.html";
    }
}
