package org.xiaoguang.smartpropertymanagementsystemgb;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Repair {
    private Long repairId;        // 报修ID
    private Long roomId;          // 房间ID
    private String type;          // 报修类型
    private String description;   // 问题描述
    private String contactPhone;  // 联系电话
    private String images;        // 图片URL，多个用逗号分隔
    private Integer status;       // 状态(1-待处理 2-处理中 3-已完成 4-已取消)
    private Long handlerId;       // 处理人ID
    private BigDecimal cost;      // 维修费用
    private String remark;        // 处理备注
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Room room;            // 所属房间
    private User handler;         // 处理人
}
    