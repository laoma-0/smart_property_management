package org.xiaoguang.smartpropertymanagementsystemgb.mapper;

import org.apache.ibatis.annotations.*;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    
    /**
     * 插入新用户
     * @param user 用户对象
     * @return 影响行数
     */
    @Insert("INSERT INTO tb_user(username, password, real_name, phone, email, status) " +
            "VALUES(#{username}, #{password}, #{realName}, #{phone}, #{email}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
    
    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户对象
     */
    @Select("SELECT * FROM tb_user WHERE username = #{username}")
    User findByUsername(String username);
    
    /**
     * 根据用户ID查询用户
     * @param id 用户ID
     * @return 用户对象
     */
    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    User findById(Long id);
    
    /**
     * 查询所有用户
     * @return 用户列表
     */
    @Select("SELECT * FROM tb_user")
    List<User> findAll();
}