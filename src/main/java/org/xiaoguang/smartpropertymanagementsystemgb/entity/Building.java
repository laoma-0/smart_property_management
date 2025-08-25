package org.xiaoguang.smartpropertymanagementsystemgb;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Building {
    private Long buildingId;      // 楼栋ID
    private Long communityId;     // 所属小区ID
    private String name;          // 楼栋名称
    private String description;   // 描述
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Community community;  // 所属小区
}
    