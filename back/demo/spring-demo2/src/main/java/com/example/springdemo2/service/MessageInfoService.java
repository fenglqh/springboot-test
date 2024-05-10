package com.example.springdemo2.service;

import com.example.springdemo2.mapper.MessageInfoMapper;
import com.example.springdemo2.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageInfoService {
    @Autowired
    private MessageInfoMapper messageInfoMapper;

    public List<MessageInfo> findAll() {
        return messageInfoMapper.selectAllMessageInfo();
    }

    public Integer insert(MessageInfo messageInfo) {
        return messageInfoMapper.insertMessageInfo(messageInfo);
    }
}
