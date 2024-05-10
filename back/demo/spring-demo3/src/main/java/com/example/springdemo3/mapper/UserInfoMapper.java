package com.example.springdemo3.mapper;

import com.example.springdemo3.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where user_name = #{userName} and delete_flag = 0")
    UserInfo SelectUserInfoByName(String userName);
}
