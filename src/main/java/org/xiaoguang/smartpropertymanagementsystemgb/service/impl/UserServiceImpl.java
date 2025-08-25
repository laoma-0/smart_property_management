package org.xiaoguang.smartpropertymanagementsystemgb.service.impl;

import org.springframework.stereotype.Service;
import org.xiaoguang.smartpropertymanagementsystemgb.dto.UserRegisterDTO;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.Result;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.User;
import org.xiaoguang.smartpropertymanagementsystemgb.mapper.UserMapper;
import org.xiaoguang.smartpropertymanagementsystemgb.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    
    
    private final UserMapper userMapper;
    
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Result<User> register(UserRegisterDTO userRegisterDTO) {
        // 检查用户名是否已存在
        if (existsByUsername(userRegisterDTO.getUsername())) {
            return Result.errorWithGeneric(400, "用户名已存在");
        }
        
        // 创建用户对象
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        // 使用BCryptPasswordEncoder对密码进行加密
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setRealName(userRegisterDTO.getRealName());
        user.setPhone(userRegisterDTO.getPhone());
        user.setEmail(userRegisterDTO.getEmail());
        user.setStatus(1); // 默认启用状态
        
        // 插入数据库
        userMapper.insert(user);
        
        // 清除密码避免返回给前端
        user.setPassword(null);
        
        return Result.success(user, "注册成功");
    }
    
    @Override
    public boolean existsByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user != null;
    }
}