package com.example.springdemo4mybatis.mapper;

import com.example.springdemo4mybatis.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleInfoMapper {
//    单表查询
    @Select("select * from articleinfo")
    ArticleInfo selectArticleInfoById(Integer id);

//    多表查询 还有其他方式 但是企业中通常情况不使用多表关联， 可以拆分成java实现
    @Select("select * from articleinfo a left join userinfo b on a.uid = b.id " +
            "where b.id = #{id}")
    ArticleInfo selectArticleAndUserById(Integer id);
}
