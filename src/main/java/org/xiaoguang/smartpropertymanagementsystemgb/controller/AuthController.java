package org.xiaoguang.smartpropertymanagementsystemgb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiaoguang.smartpropertymanagementsystemgb.dto.LoginResponseDTO;
import org.xiaoguang.smartpropertymanagementsystemgb.dto.UserLoginDTO;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.Result;
import org.xiaoguang.smartpropertymanagementsystemgb.service.UserService;
import jakarta.validation.Valid;

/**
 * 认证控制器
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录接口
     *
     * @param userLoginDTO 用户登录信息
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result<LoginResponseDTO> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }
}