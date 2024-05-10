package com.example.springdemo2.controller;

import com.example.springdemo2.model.MessageInfo;
import com.example.springdemo2.service.MessageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
//    private List<MessageInfo> list = new ArrayList<>();
    @Autowired
    private MessageInfoService messageInfoService;
    @RequestMapping("/add")
    public Boolean add(MessageInfo messageInfo) {
//        参数校验
        if (!StringUtils.hasLength(messageInfo.getFrom()) || !StringUtils.hasLength(messageInfo.getTo() )
                || !StringUtils.hasLength(messageInfo.getSay())) return false;
        Integer insert = messageInfoService.insert(messageInfo);
        return insert > 0;

//        session.setAttribute("list",list);
    }
    @RequestMapping("/show")
    public List<MessageInfo> show() {
        return messageInfoService.findAll();
    }
}
