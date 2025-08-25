package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FeeType {
    private Long id;              // 费用类型ID
    private String name;          // 费用名称
    private String description;   // 费用描述
    private BigDecimal unitPrice; // 单价
    private String unit;          // 单位
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}