package org.xiaoguang.smartpropertymanagementsystemgb;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Notice {
    private Long noticeId;        // 公告ID
    private String title;         // 标题
    private String content;       // 内容
    private Integer type;         // 类型(1-全体通知 2-小区通知 3-楼栋通知)
    private Long communityId;     // 所属小区ID
    private Long buildingId;      // 所属楼栋ID
    private Long creatorId;       // 创建人ID
    private Integer isTop;        // 是否置顶(1-是 0-否)
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private User creator;         // 创建人
    private Community community;  // 所属小区
    private Building building;    // 所属楼栋
}
    