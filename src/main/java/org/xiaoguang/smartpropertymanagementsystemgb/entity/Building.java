package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Building {
    private Long id;              // 楼栋ID
    private Long communityId;     // 小区ID
    private String buildingNo;    // 楼栋编号
    private Integer totalFloors;  // 总楼层
    private Integer unitCount;    // 单元数
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Community community;  // 所属小区
}