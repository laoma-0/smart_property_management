package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Community {
    private Long id;              // 小区ID
    private String name;          // 小区名称
    private String address;       // 小区地址
    private String developer;     // 开发商
    private String propertyCompany; // 物业公司
    private Integer buildYear;    // 建成年份
    private Integer totalBuildings; // 总楼栋数
    private Integer totalHouses;  // 总户数
    private String description;   // 小区描述
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}