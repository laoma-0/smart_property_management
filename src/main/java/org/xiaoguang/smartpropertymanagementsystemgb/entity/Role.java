package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Role {
    private Long id;              // 角色ID
    private String roleName;      // 角色名称
    private String roleDesc;      // 角色描述
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}