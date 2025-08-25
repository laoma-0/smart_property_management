-- 创建数据库
CREATE DATABASE IF NOT EXISTS db_smart_property_management CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
USE db_smart_property_management;

-- 创建角色表
CREATE TABLE IF NOT EXISTS tb_role (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '角色ID',
    role_name VARCHAR(50) NOT NULL COMMENT '角色名称',
    role_desc VARCHAR(200) COMMENT '角色描述',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_role_name (role_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- 创建用户表
CREATE TABLE IF NOT EXISTS tb_user (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    username VARCHAR(50) NOT NULL COMMENT '用户名',
    password VARCHAR(100) NOT NULL COMMENT '密码',
    real_name VARCHAR(50) COMMENT '真实姓名',
    phone VARCHAR(20) COMMENT '联系电话',
    email VARCHAR(100) COMMENT '邮箱',
    status TINYINT DEFAULT 1 COMMENT '状态：0-禁用，1-正常',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 创建用户角色关联表
CREATE TABLE IF NOT EXISTS tb_user_role (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    user_id INT NOT NULL COMMENT '用户ID',
    role_id INT NOT NULL COMMENT '角色ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES tb_role(id) ON DELETE CASCADE,
    UNIQUE KEY uk_user_role (user_id, role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';

-- 创建小区表
CREATE TABLE IF NOT EXISTS tb_community (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '小区ID',
    name VARCHAR(100) NOT NULL COMMENT '小区名称',
    address VARCHAR(200) COMMENT '小区地址',
    developer VARCHAR(100) COMMENT '开发商',
    property_company VARCHAR(100) COMMENT '物业公司',
    build_year INT COMMENT '建成年份',
    total_buildings INT COMMENT '总楼栋数',
    total_houses INT COMMENT '总户数',
    description TEXT COMMENT '小区描述',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_community_name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='小区表';

-- 创建楼栋表
CREATE TABLE IF NOT EXISTS tb_building (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '楼栋ID',
    community_id INT NOT NULL COMMENT '小区ID',
    building_no VARCHAR(20) NOT NULL COMMENT '楼栋编号',
    total_floors INT COMMENT '总楼层',
    unit_count INT COMMENT '单元数',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (community_id) REFERENCES tb_community(id) ON DELETE CASCADE,
    UNIQUE KEY uk_building_no (community_id, building_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼栋表';

-- 创建房间表
CREATE TABLE IF NOT EXISTS tb_room (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '房间ID',
    building_id INT NOT NULL COMMENT '楼栋ID',
    unit_no VARCHAR(10) NOT NULL COMMENT '单元号',
    floor_no INT NOT NULL COMMENT '楼层号',
    room_no VARCHAR(10) NOT NULL COMMENT '房间号',
    area DECIMAL(10,2) COMMENT '建筑面积',
    room_type VARCHAR(20) COMMENT '户型',
    owner_id INT COMMENT '业主ID',
    status TINYINT DEFAULT 1 COMMENT '状态：0-未售出，1-已售出，2-出租',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (building_id) REFERENCES tb_building(id) ON DELETE CASCADE,
    FOREIGN KEY (owner_id) REFERENCES tb_user(id) ON DELETE SET NULL,
    UNIQUE KEY uk_room_no (building_id, unit_no, floor_no, room_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='房间表';

-- 创建报修表
CREATE TABLE IF NOT EXISTS tb_repair (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '报修ID',
    room_id INT NOT NULL COMMENT '房间ID',
    user_id INT NOT NULL COMMENT '报修人ID',
    repair_type VARCHAR(50) NOT NULL COMMENT '报修类型',
    description TEXT COMMENT '问题描述',
    status TINYINT DEFAULT 0 COMMENT '状态：0-待处理，1-处理中，2-已完成，3-已取消',
    handler_id INT COMMENT '处理人ID',
    handle_time DATETIME COMMENT '处理时间',
    handle_notes TEXT COMMENT '处理备注',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (room_id) REFERENCES tb_room(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (handler_id) REFERENCES tb_user(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报修表';

-- 创建费用类型表
CREATE TABLE IF NOT EXISTS tb_fee_type (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '费用类型ID',
    name VARCHAR(50) NOT NULL COMMENT '费用名称',
    description VARCHAR(200) COMMENT '费用描述',
    unit_price DECIMAL(10,2) COMMENT '单价',
    unit VARCHAR(20) COMMENT '单位',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_fee_name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='费用类型表';

-- 创建缴费记录表
CREATE TABLE IF NOT EXISTS tb_payment (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '缴费ID',
    room_id INT NOT NULL COMMENT '房间ID',
    user_id INT NOT NULL COMMENT '缴费人ID',
    fee_type_id INT NOT NULL COMMENT '费用类型ID',
    amount DECIMAL(10,2) NOT NULL COMMENT '缴费金额',
    payment_no VARCHAR(50) NOT NULL COMMENT '缴费单号',
    payment_time DATETIME COMMENT '缴费时间',
    payment_method VARCHAR(20) COMMENT '缴费方式',
    status TINYINT DEFAULT 0 COMMENT '状态：0-未缴费，1-已缴费，2-已取消',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (room_id) REFERENCES tb_room(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (fee_type_id) REFERENCES tb_fee_type(id) ON DELETE CASCADE,
    UNIQUE KEY uk_payment_no (payment_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='缴费记录表';

-- 创建公告表
CREATE TABLE IF NOT EXISTS tb_notice (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '公告ID',
    title VARCHAR(200) NOT NULL COMMENT '公告标题',
    content TEXT NOT NULL COMMENT '公告内容',
    publisher_id INT NOT NULL COMMENT '发布人ID',
    community_id INT COMMENT '所属小区ID，null表示全局公告',
    is_top TINYINT DEFAULT 0 COMMENT '是否置顶：0-否，1-是',
    status TINYINT DEFAULT 1 COMMENT '状态：0-草稿，1-发布，2-撤回',
    publish_time DATETIME COMMENT '发布时间',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (publisher_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (community_id) REFERENCES tb_community(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公告表';

-- 初始化角色数据
INSERT INTO tb_role (role_name, role_desc) VALUES 
('admin', '系统管理员'),
('property_manager', '物业管理员'),
('owner', '业主');

-- 初始化用户数据（密码：123456，已加密）
INSERT INTO tb_user (username, password, real_name, phone, email, status) VALUES 
('admin', '$2a$10$G0e6bZ5y5mXl6Y5D5h5j5u5i5k5l5m5n5o5p5q5r5s5t5u5v5w5x5y5z', '系统管理员', '13800138000', 'admin@example.com', 1),
('manager1', '$2a$10$G0e6bZ5y5mXl6Y5D5h5j5u5i5k5l5m5n5o5p5q5r5s5t5u5v5w5x5y5z', '物业经理', '13800138001', 'manager1@example.com', 1),
('owner1', '$2a$10$G0e6bZ5y5mXl6Y5D5h5j5u5i5k5l5m5n5o5p5q5r5s5t5u5v5w5x5y5z', '张三', '13800138002', 'owner1@example.com', 1),
('owner2', '$2a$10$G0e6bZ5y5mXl6Y5D5h5j5u5i5k5l5m5n5o5p5q5r5s5t5u5v5w5x5y5z', '李四', '13800138003', 'owner2@example.com', 1);

-- 初始化用户角色关联数据
INSERT INTO tb_user_role (user_id, role_id) VALUES 
(1, 1),  -- admin拥有管理员角色
(2, 2),  -- manager1拥有物业管理员角色
(3, 3),  -- owner1拥有业主角色
(4, 3);  -- owner2拥有业主角色

-- 初始化小区数据
INSERT INTO tb_community (name, address, developer, property_company, build_year, total_buildings, total_houses, description) VALUES 
('阳光花园', '北京市海淀区阳光路88号', '阳光地产', '智慧物业有限公司', 2015, 10, 500, '阳光花园小区环境优美，配套设施齐全'),
('幸福家园', '上海市浦东新区幸福路66号', '幸福地产', '智慧物业有限公司', 2018, 8, 320, '幸福家园是现代化精品小区');

-- 初始化楼栋数据
INSERT INTO tb_building (community_id, building_no, total_floors, unit_count) VALUES 
(1, '1号楼', 18, 2),
(1, '2号楼', 18, 2),
(2, '1号楼', 24, 3),
(2, '2号楼', 24, 3);

-- 初始化房间数据
INSERT INTO tb_room (building_id, unit_no, floor_no, room_no, area, room_type, owner_id, status) VALUES 
(1, '1单元', 5, '101', 89.50, '两室一厅', 3, 1),
(1, '1单元', 5, '102', 95.30, '三室一厅', NULL, 0),
(1, '2单元', 8, '201', 78.80, '两室一厅', NULL, 0),
(2, '1单元', 12, '101', 110.20, '三室两厅', 4, 1),
(2, '2单元', 6, '202', 92.50, '两室两厅', NULL, 0);

-- 初始化费用类型数据
INSERT INTO tb_fee_type (name, description, unit_price, unit) VALUES 
('物业费', '物业管理服务费', 1.80, '元/平方米/月'),
('水费', '居民用水费用', 5.00, '元/吨'),
('电费', '居民用电费用', 0.58, '元/度'),
('燃气费', '居民燃气费用', 2.63, '元/立方米'),
('停车费', '小区停车费用', 150.00, '元/月');

-- 初始化报修数据
INSERT INTO tb_repair (room_id, user_id, repair_type, description, status, handler_id, handle_time, handle_notes) VALUES 
(1, 3, '水电维修', '厨房水龙头漏水', 2, 2, '2023-06-15 14:30:00', '已更换新的水龙头'),
(4, 4, '家电维修', '空调不制冷', 1, 2, NULL, NULL),
(1, 3, '房屋维修', '墙壁出现裂缝', 0, NULL, NULL, NULL);

-- 初始化缴费记录数据
INSERT INTO tb_payment (room_id, user_id, fee_type_id, amount, payment_no, payment_time, payment_method, status) VALUES 
(1, 3, 1, 161.10, '20230601001', '2023-06-01 09:30:00', '微信支付', 1),
(1, 3, 2, 85.50, '20230605001', '2023-06-05 15:20:00', '支付宝', 1),
(4, 4, 1, 198.36, '20230601002', NULL, NULL, 0),
(4, 4, 3, 120.50, '20230603001', '2023-06-03 10:15:00', '银行卡', 1);

-- 初始化公告数据
INSERT INTO tb_notice (title, content, publisher_id, community_id, is_top, status, publish_time) VALUES 
('小区停电通知', '因线路检修，本小区将于2023年6月20日上午8:00-12:00停电，请各位业主提前做好准备。', 2, 1, 1, 1, '2023-06-10 08:30:00'),
('物业费缴费通知', '2023年第二季度物业费开始缴纳，请各位业主及时缴纳。', 2, NULL, 1, 1, '2023-06-01 09:00:00'),
('小区绿化改造通知', '本小区将于7月份进行绿化改造，期间可能会对部分区域通行造成影响，敬请谅解。', 2, 2, 0, 1, '2023-06-12 14:00:00');
