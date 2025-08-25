package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Repair {
    private Long id;              // 报修ID
    private Long roomId;          // 房间ID
    private Long userId;          // 报修人ID
    private String repairType;    // 报修类型
    private String description;   // 问题描述
    private Integer status;       // 状态：0-待处理，1-处理中，2-已完成，3-已取消
    private Long handlerId;       // 处理人ID
    private LocalDateTime handleTime; // 处理时间
    private String handleNotes;   // 处理备注
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Room room;            // 所属房间
    private User user;            // 报修人
    private User handler;         // 处理人
}