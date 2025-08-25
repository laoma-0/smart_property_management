package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserRole {
    private Long id;              // 主键ID
    private Long userId;          // 用户ID
    private Long roleId;          // 角色ID
    private LocalDateTime createTime; // 创建时间
}