package org.xiaoguang.smartpropertymanagementsystemgb;

import lombok.Data;

@Data
public class FeeType {
    private Long feeTypeId;       // 费用类型ID
    private String name;          // 类型名称
    private String description;   // 描述
    private Integer status;       // 状态(1-启用 0-禁用)
}
    