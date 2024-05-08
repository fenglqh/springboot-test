package com.example.springdemo2.mapper;

import com.example.springdemo2.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface MessageInfoMapper{
    @Result(column = "message", property = "say")
    @Select("select * from message_info")
    List<MessageInfo> selectAllMessageInfo();

    @Insert("insert into message_info(`from`, `to`, message) values (#{messageInfo.from}," +
            "#{messageInfo.to},#{messageInfo.say})")
    Integer insertMessageInfo(MessageInfo messageInfo);
}
