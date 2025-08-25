package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Payment {
    private Long id;              // 缴费ID
    private Long roomId;          // 房间ID
    private Long userId;          // 缴费人ID
    private Long feeTypeId;       // 费用类型ID
    private BigDecimal amount;    // 缴费金额
    private String paymentNo;     // 缴费单号
    private LocalDateTime paymentTime; // 缴费时间
    private String paymentMethod; // 缴费方式
    private Integer status;       // 状态：0-未缴费，1-已缴费，2-已取消
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Room room;            // 所属房间
    private User user;            // 缴费人
    private FeeType feeType;      // 费用类型
}
    