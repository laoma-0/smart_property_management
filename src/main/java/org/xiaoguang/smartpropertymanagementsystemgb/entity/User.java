package org.xiaoguang.smartpropertymanagementsystemgb;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private Long userId;          // 用户ID
    private String username;      // 用户名
    private String password;      // 密码
    private String realName;      // 真实姓名
    private String phone;         // 手机号
    private String email;         // 邮箱
    private Long communityId;     // 所属小区ID
    private Long buildingId;      // 所属楼栋ID
    private Long roomId;          // 所属房间ID
    private Integer status;       // 状态(1-正常 0-禁用)
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Role role;            // 角色
    private Community community;  // 所属小区
    private Building building;    // 所属楼栋
    private Room room;            // 所属房间
}
    