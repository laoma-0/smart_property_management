package org.xiaoguang.smartpropertymanagementsystemgb.dto;

import lombok.Data;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.User;

/**
 * 用户登录响应DTO
 */
@Data
public class UserLoginResponseDTO {
    /**
     * JWT访问令牌
     */
    private String token;
    
    /**
     * 用户信息
     */
    private User user;
    
    /**
     * Token过期时间（秒）
     */
    private Integer expiresIn;
}