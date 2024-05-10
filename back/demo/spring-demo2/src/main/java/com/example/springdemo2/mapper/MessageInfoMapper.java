package com.example.springdemo2.mapper;

import com.example.springdemo2.model.MessageInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface MessageInfoMapper{
    @Result(column = "message", property = "say")
    @Select("select * from message_info")
    List<MessageInfo> selectAllMessageInfo();

    @Insert("insert into message_info(`from`, `to`, message) values (#{messageInfo.from}," +
            "#{messageInfo.to}, #{messageInfo.say})")
    Integer insertMessageInfo(@Param("messageInfo") MessageInfo messageInfo);
}
