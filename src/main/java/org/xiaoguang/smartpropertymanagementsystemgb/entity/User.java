package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private Long id;              // 用户ID
    private String username;      // 用户名
    private String password;      // 密码
    private String realName;      // 真实姓名
    private String phone;         // 联系电话
    private String email;         // 邮箱
    private Integer status;       // 状态：0-禁用，1-正常
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Role role;            // 角色
    private Community community;  // 所属小区
    private Building building;    // 所属楼栋
    private Room room;            // 所属房间
}