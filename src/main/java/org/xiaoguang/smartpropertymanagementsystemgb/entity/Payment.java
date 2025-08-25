package org.xiaoguang.smartpropertymanagementsystemgb;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Payment {
    private Long paymentId;       // 缴费ID
    private Long roomId;          // 房间ID
    private Long feeTypeId;       // 费用类型ID
    private BigDecimal amount;    // 金额
    private LocalDate startDate;  // 费用起始日期
    private LocalDate endDate;    // 费用截止日期
    private LocalDate dueDate;    // 缴费截止日期
    private Integer status;       // 状态(1-未缴费 2-已缴费 3-已逾期 4-已取消)
    private String payType;       // 支付方式
    private String transactionNo; // 交易单号
    private BigDecimal payAmount; // 实际支付金额
    private LocalDateTime payTime; // 支付时间
    private String remark;        // 备注
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private Room room;            // 所属房间
    private FeeType feeType;      // 费用类型
}
    