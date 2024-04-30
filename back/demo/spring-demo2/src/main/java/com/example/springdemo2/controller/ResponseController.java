package com.example.springdemo2.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/res")
//@RestController
@Controller
public class ResponseController {
//    @ResponseBody
//    只有@Controller才会识别返回的是文件
    @RequestMapping("/index")
    public String index() {
        return "/index.html";
    }
//    @ResponseBody+@Controller才表示返回的是普通数据，不然的话，就会报错
    @ResponseBody
    @RequestMapping("/data")
    public String indexData() {
        return "返回数据";
    }
    @ResponseBody
    @RequestMapping("/data2")
    public String indexData2() {
        return "<p>我是地球人</p>";
    }
    @ResponseBody
    @RequestMapping("/getMap")
    public HashMap<String,String> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        return map;
    }
    @ResponseBody
    @RequestMapping("/setstatus")
    public String setStatus(HttpServletResponse response) {
        response.setStatus(418);
        return "设置状态码";
    }
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping("/setstatus")
//    public String setStatus2() {
//        return "设置状态码2";
//    }
    @ResponseBody
    @RequestMapping(value = "setType", produces = "application/josn")
    public String setContextType() {
        return "{\"ok\":1}";
    }
    @ResponseBody
    @RequestMapping(value = "setType2")
    public List<String> setContextType2() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("cccc");
        return list;
    }
}
