package com.example.springioc.mapper;

import com.example.springioc.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    @Select("select * from userinfo")
    public List<UserInfo> getUserInfo();
}
