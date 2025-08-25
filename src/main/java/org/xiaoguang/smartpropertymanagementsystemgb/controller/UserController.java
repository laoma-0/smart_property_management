package org.xiaoguang.smartpropertymanagementsystemgb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiaoguang.smartpropertymanagementsystemgb.dto.UserRegisterDTO;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.Result;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.User;
import org.xiaoguang.smartpropertymanagementsystemgb.service.UserService;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册接口
     * @param userRegisterDTO 用户注册信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public Result<User> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        return userService.register(userRegisterDTO);
    }
}