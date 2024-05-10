package com.example.springdemo2.mapper;

import com.example.springdemo2.model.MessageInfo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class MessageInfoMapperTest {
//    private static final Logger log = LoggerFactory.getLogger(MessageInfoMapperTest.class);
    @Autowired
    private MessageInfoMapper messageInfoMapper;
    @Test
    void selectAllMessageInfo() {
        List<MessageInfo> messageInfos = messageInfoMapper.selectAllMessageInfo();
        for (MessageInfo messageInfo : messageInfos) {
            System.out.println(messageInfo);
        }
    }

    @Test
    void insertMessageInfo() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setFrom("zzz");
        messageInfo.setTo("ccc");
        messageInfo.setSay("love");
        messageInfoMapper.insertMessageInfo(messageInfo);
    }
}