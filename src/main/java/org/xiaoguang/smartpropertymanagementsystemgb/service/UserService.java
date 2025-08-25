package org.xiaoguang.smartpropertymanagementsystemgb.service;

import org.xiaoguang.smartpropertymanagementsystemgb.dto.LoginResponseDTO;
import org.xiaoguang.smartpropertymanagementsystemgb.dto.UserLoginDTO;
import org.xiaoguang.smartpropertymanagementsystemgb.dto.UserRegisterDTO;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.Result;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.User;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 用户注册
     * @param userRegisterDTO 用户注册信息
     * @return 注册结果
     */
    Result<User> register(UserRegisterDTO userRegisterDTO);
    
    /**
     * 用户登录
     * @param userLoginDTO 用户登录信息
     * @return 登录结果
     */
    Result<LoginResponseDTO> login(UserLoginDTO userLoginDTO);
    
    /**
     * 检查用户名是否已存在
     * @param username 用户名
     * @return 是否存在
     */
    boolean existsByUsername(String username);
    
    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 用户对象
     */
    User findByUsername(String username);
}