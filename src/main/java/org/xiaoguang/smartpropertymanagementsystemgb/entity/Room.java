package org.xiaoguang.smartpropertymanagementsystemgb;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Room {
    private Long roomId;          // 房间ID
    private Long buildingId;      // 所属楼栋ID
    private String roomNumber;    // 房间号
    private BigDecimal area;      // 面积(平方米)
    private Integer floor;        // 楼层
    private Integer status;       // 状态(1-已入住 2-未入住)
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Building building;    // 所属楼栋
}
    