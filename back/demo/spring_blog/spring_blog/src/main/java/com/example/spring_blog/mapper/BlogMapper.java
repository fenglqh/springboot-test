package com.example.spring_blog.mapper;

import com.example.spring_blog.model.BlogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface BlogMapper {
    /**
     * 根据作者id查询博客列表
     * delete_flag  0 表示未删除 1 表示已删除
     * @param userId
     * @return
     */
    @Select("select * from blog where user_id = #{userId} and delete_flag = 0")
    public List<BlogInfo> selectBlogListByUserId(int userId);

    /**
     * 根据博客id查询博客详情
     * @param id
     * @return
     */
    @Select("select * from blog where id = #{id} and delete_flag = 0")
    public BlogInfo selectBlogById(int id);

    /**
     * 根据博客id查询作者id
     * @param blogId
     * @return
     */
    @Select("select user_id from blog where id = #{blogId} and delete_flag = 0")
    public Integer selectUserIdByBlogId(int blogId);

    /**
     * 根据输入信息修改博客
     * @param blogInfo
     * @return
     */
    public int updateBlog(BlogInfo blogInfo);

    /**
     * 根据输入信息添加博客
     * @param blogInfo
     * @return
     */
    @Insert("insert into blog(title,content,user_id) values (#{title},#{content},#{userId})")
    public int insertBlog(BlogInfo blogInfo);
}
