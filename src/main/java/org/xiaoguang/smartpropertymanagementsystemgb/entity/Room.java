package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Room {
    private Long id;              // 房间ID
    private Long buildingId;      // 楼栋ID
    private String unitNo;        // 单元号
    private Integer floorNo;      // 楼层号
    private String roomNo;        // 房间号
    private BigDecimal area;      // 建筑面积
    private String roomType;      // 户型
    private Long ownerId;         // 业主ID
    private Integer status;       // 状态：0-未售出，1-已售出，2-出租
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Building building;    // 所属楼栋
    private User owner;           // 业主
}