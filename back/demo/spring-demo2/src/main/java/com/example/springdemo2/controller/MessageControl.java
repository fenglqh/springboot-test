package com.example.springdemo2.controller;

import com.example.springdemo2.model.MessageInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageControl {
    private List<MessageInfo> list = new ArrayList<>();
    @RequestMapping("/add")
    public Boolean add(MessageInfo messageInfo) {
//        参数校验
        if (!StringUtils.hasLength(messageInfo.getFrom()) || !StringUtils.hasLength(messageInfo.getTo() )
                || !StringUtils.hasLength(messageInfo.getSay())) return false;
        list.add(messageInfo);
//        session.setAttribute("list",list);
        return true;
    }
    @RequestMapping("/show")
    public List<MessageInfo> show() {
        for (MessageInfo m:
             list
        ) {
            System.out.println(m);
        }
        return list;
    }
}
