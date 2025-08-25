package org.xiaoguang.smartpropertymanagementsystemgb;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Community {
    private Long communityId;     // 小区ID
    private String name;          // 小区名称
    private String address;       // 地址
    private String description;   // 描述
    private String propertyCompany; // 物业公司
    private String contactPhone;  // 联系电话
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
    