package com.example.springdemo4mybatis.mapper;

import com.example.springdemo4mybatis.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 查所有 但是会发现List中有的值是获取不到的 这是因为字段名映射不一致
    // 有三种解决方法，起别名，注解Result ，还有在全局配置里配置驼峰自动转换
//    @Result(column = "delete_flag", property = "deleteFlag")  单个需要对应的映射用Result
    @Results(id = "resultMap", value = {
            @Result(column = "delete_flag", property = "deleteFlag"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from userinfo")
    List<UserInfo> getUserInfoAll();

    // 起别名的方式进行映射
    @Select("SELECT id, username, `password`,age, gender, phone, delete_flag AS " +
            "deleteFlag, create_time as createTime, update_time as UpdateTime FROM " +
            "userinfo")
    List<UserInfo> getUserInfoAll1();
    // 根据具体条件查单个
    @ResultMap("resultMap")
    @Select("select * from userinfo where id = #{id}")
    UserInfo getUserInfoById(Integer id);

    // 传入的是对象，根据具体条件进行查找
    @Select("select * from userinfo where id = #{id}")
    UserInfo getUserInfoBy1Id(UserInfo userInfo);

    @Select("select * from userinfo where id = #{userInfo.id}")
    UserInfo getUserInfoBy2Id(@Param("userInfo") UserInfo userInfo);

    // 试一试如果安装条件查多了怎么办
    // 会报错
    @Select("select * from userinfo where delete_flag = #{deleteFlag}")
    UserInfo getUserInfoByDeleteFlag(Integer deleteFlag);

    // 添加数据  当数据库主键没有设置自动递增的时候会报错
    // keyProperty = "id": 这个选项指定了一个 Java 对象的属性名，用于存储生成的主键值。
    // 在这个例子中，表示将生成的主键值设置到对象的 id 属性中。
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // 标识主键属性，并且递增
    @Insert("insert into userinfo(username, password, age) values (" +
            "#{userName}, #{password}, #{age})")
    Integer insertUserInfo(String userName, String password, Integer age);


    @Insert("insert into userinfo (username, password, age) values (" +
            "#{userInfo.username}, #{userInfo.password}, #{userInfo.age})")
    Integer insertUserInfo1(@Param("userInfo") UserInfo userInfo);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username, password, age) values (" +
            "#{username}, #{password}, #{age})")
    Integer insertUserInfo2(UserInfo userInfo);

    @Delete("delete from userinfo where id = #{id}")
    Integer deleteUserInfoById(Integer id);
}
