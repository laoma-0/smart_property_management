package org.xiaoguang.smartpropertymanagementsystemgb.dto;

import lombok.Data;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.User;

/**
 * 登录响应DTO
 */
@Data
public class LoginResponseDTO {
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