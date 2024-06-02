package com.example.spring_blog.mapper;

import com.example.spring_blog.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /**
     * 根据用户名和密码查询
     * @param user
     * @param pwd
     * @return
     */
    @Select("select id,user_name,password,github_url,delete_flag,create_time,update_time " +
            "from user where user_name = #{user} and password = #{pwd} and delete_flag = 0")
    public UserInfo selectByUserAndPwd(String user, String pwd);

    /**
     * 根据用户id返回信息
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id} and delete_flag = 0")
    public UserInfo selectById(Integer id);

    /**
     * 查询用户名是否存在
     * @param user
     * @return
     */
    @Select("select * from user where user_name = #{user} and delete_flag = 0")
    public UserInfo selectByUser(String user);

    /**
     * 增加用户信息
     * @param userInfo
     * @return
     */
    @Insert("insert into user(user_name,password) values (#{userName}, #{password})")
    public int insertUser(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    public int updateUser(UserInfo userInfo);
}
