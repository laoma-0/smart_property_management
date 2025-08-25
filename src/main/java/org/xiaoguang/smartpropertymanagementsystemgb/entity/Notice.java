package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Notice {
    private Long id;              // 公告ID
    private String title;         // 公告标题
    private String content;       // 公告内容
    private Long publisherId;     // 发布人ID
    private Long communityId;     // 所属小区ID，null表示全局公告
    private Integer isTop;        // 是否置顶：0-否，1-是
    private Integer status;       // 状态：0-草稿，1-发布，2-撤回
    private LocalDateTime publishTime; // 发布时间
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    
    // 关联属性
    private User publisher;       // 发布人
    private Community community;  // 所属小区
}
    