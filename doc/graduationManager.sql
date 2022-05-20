/*
 Navicat MySQL Data Transfer

 Source Server         : ten
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 124.223.184.251:3306
 Source Schema         : graduationManager

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 20/05/2022 20:19:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键,管理员id',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,用户id',
  PRIMARY KEY (`admin_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表，\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '30001');

-- ----------------------------
-- Table structure for classi
-- ----------------------------
DROP TABLE IF EXISTS `classi`;
CREATE TABLE `classi`  (
  `class_id` int NOT NULL,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subject_id` int NOT NULL,
  PRIMARY KEY (`class_id`) USING BTREE,
  INDEX `class_ibfk_1`(`subject_id`) USING BTREE,
  CONSTRAINT `classi_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of classi
-- ----------------------------
INSERT INTO `classi` VALUES (1, '2020级计算机科学技术', 1);
INSERT INTO `classi` VALUES (2, '2020级电子信息', 2);
INSERT INTO `classi` VALUES (3, '2020级人工智能', 3);
INSERT INTO `classi` VALUES (4, '2020级数据分析', 4);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,部门id',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门科室名',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '计算机科学教研室');
INSERT INTO `dept` VALUES (2, '大数据教研室');
INSERT INTO `dept` VALUES (3, '数字媒体技术教研室');
INSERT INTO `dept` VALUES (4, '广播电视工程教研室');

-- ----------------------------
-- Table structure for down
-- ----------------------------
DROP TABLE IF EXISTS `down`;
CREATE TABLE `down`  (
  `down_id` int NOT NULL AUTO_INCREMENT COMMENT '公共资源下载',
  `down_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源标题',
  `down_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源下载地址',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `admin_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,管理员id',
  PRIMARY KEY (`down_id`) USING BTREE,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  CONSTRAINT `down_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件下载' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of down
-- ----------------------------
INSERT INTO `down` VALUES (1, '免答辩申请表.docx', '免答辩申请表.docx', '2018-03-24 21:23:15', '1');
INSERT INTO `down` VALUES (2, '中期检查表', '中期检查表.docx', '2018-03-25 17:15:39', '1');
INSERT INTO `down` VALUES (3, '开题报告表', '开题报告.docx', '2018-03-25 17:16:10', '1');
INSERT INTO `down` VALUES (4, '论文要求说明', '', '2018-03-25 17:16:47', '1');
INSERT INTO `down` VALUES (5, '2018届毕业设计（论文）完成情况评价表（新）.doc', '', '2018-03-25 17:17:19', '1');
INSERT INTO `down` VALUES (6, '2018届毕业设计开题报告完成情况统计.xlsx', '', '2018-03-25 17:17:42', '1');
INSERT INTO `down` VALUES (7, 'Javascript参考手册.chm', '', '2018-03-25 17:18:09', '1');
INSERT INTO `down` VALUES (8, 'J2EE_1.6_API.chm', '', '2018-03-25 17:18:30', '1');

-- ----------------------------
-- Table structure for inform
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform`  (
  `inform_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,通知公告id',
  `inform_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知公告标题',
  `inform_body` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知公告主体',
  `is_attachment` int NULL DEFAULT 0 COMMENT '是否有附件(0否1有)',
  `attachment_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件地址',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `admin_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,管理员id',
  PRIMARY KEY (`inform_id`) USING BTREE,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  CONSTRAINT `inform_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inform
-- ----------------------------
INSERT INTO `inform` VALUES (1, '信息技术学院2018届本科毕业设计答辩工作安排说明', '通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----', 0, NULL, '2018-04-26 21:25:13', '1');
INSERT INTO `inform` VALUES (2, '关于对2018届本科毕业设计(论文)进行系统验收的通知', '通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----', 0, NULL, '2018-04-06 15:45:28', '1');
INSERT INTO `inform` VALUES (3, '关于对2018届本科毕业设计(论文)进行中期检查的通知', '通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----', 0, NULL, '2018-03-25 15:46:00', '1');
INSERT INTO `inform` VALUES (4, '关于对2018届本科毕业设计(论文)进行开题报告检查的通知', '通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----', 0, NULL, '2018-02-23 15:46:25', '1');
INSERT INTO `inform` VALUES (5, '信息技术学院2018届本科毕业设计工作安排', '通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----', 0, NULL, '2018-01-18 15:47:27', '1');
INSERT INTO `inform` VALUES (6, '关于开展2018届毕业设计(论文)工作的通知', '通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----', 0, NULL, '2017-12-31 15:48:37', '1');
INSERT INTO `inform` VALUES (7, '关于开展2018届毕业设计(论文)工作的通知', '通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----', 0, NULL, '2017-12-31 15:48:58', '1');
INSERT INTO `inform` VALUES (8, '关于发布《2018届本科生毕业设计（论文）工作规定》的通知', '通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----通知内容信息----', 0, NULL, '2017-12-01 15:50:16', '1');

-- ----------------------------
-- Table structure for inform_message
-- ----------------------------
DROP TABLE IF EXISTS `inform_message`;
CREATE TABLE `inform_message`  (
  `message_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,消息id',
  `message_body` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `message_type` int NOT NULL COMMENT '消息类型(0留言1通知)',
  `teacher_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,导师id',
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,学生id',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `response_date` datetime NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`message_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inform_message
-- ----------------------------

-- ----------------------------
-- Table structure for ktbg
-- ----------------------------
DROP TABLE IF EXISTS `ktbg`;
CREATE TABLE `ktbg`  (
  `ktbg_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,id',
  `column1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '综述',
  `column2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '思路及方法',
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,学生id',
  `ktbg_status` int NULL DEFAULT NULL COMMENT '教师评审意见（0未通过，1通过）',
  PRIMARY KEY (`ktbg_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `ktbg_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ktbg
-- ----------------------------
INSERT INTO `ktbg` VALUES (1, '信息', '111111111111111111', '210001', 0);

-- ----------------------------
-- Table structure for lunwen
-- ----------------------------
DROP TABLE IF EXISTS `lunwen`;
CREATE TABLE `lunwen`  (
  `lunwen_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,id',
  `lunwen_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '论文名',
  `lunwen_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '论文上传路径',
  `lunwen_date` datetime NULL DEFAULT NULL COMMENT '论文上传时间',
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,学生id',
  `lunwen_status` int NULL DEFAULT NULL COMMENT '论文被审核之后的状态(0退回修改1评审打分)',
  PRIMARY KEY (`lunwen_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `lunwen_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of lunwen
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,消息id',
  `message_body` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `message_type` int(2) UNSIGNED ZEROFILL NULL DEFAULT 00 COMMENT '消息类型(0留言1通知)',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,发送者的用户ID\r\n',
  `to_user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,接收者的用户ID',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `state` int(2) UNSIGNED ZEROFILL NULL DEFAULT 00 COMMENT '是否已读，0未读   1已读',
  PRIMARY KEY (`message_id`) USING BTREE,
  INDEX `wj_1`(`user_id`) USING BTREE,
  INDEX `wj_2`(`to_user_id`) USING BTREE,
  CONSTRAINT `wj_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wj_2` FOREIGN KEY (`to_user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 'hello', NULL, '10001', '20001', '2022-03-02 20:46:04', 01);
INSERT INTO `message` VALUES (2, 'hello', NULL, '10001', '20001', '2022-03-02 20:47:07', 01);
INSERT INTO `message` VALUES (3, 'hello', NULL, '10001', '20001', '2022-03-02 20:47:07', 01);
INSERT INTO `message` VALUES (4, 'hello', NULL, '10001', '20001', '2022-03-02 20:47:07', 01);
INSERT INTO `message` VALUES (5, 'hello1', 00, '10001', '20002', '2022-03-02 21:11:04', 01);
INSERT INTO `message` VALUES (6, 'hello1', 00, '10001', '20002', '2022-03-02 21:11:04', 01);
INSERT INTO `message` VALUES (7, 'hello1', 00, '10001', '20002', '2022-03-02 21:11:04', 01);
INSERT INTO `message` VALUES (8, 'hello3', 00, '10001', '20003', '2022-03-06 16:07:20', 01);
INSERT INTO `message` VALUES (9, '\nhello3', 00, '10001', '20003', '2022-03-06 16:07:22', 01);
INSERT INTO `message` VALUES (10, '\n', 00, '10001', '20003', '2022-03-06 16:07:22', 01);
INSERT INTO `message` VALUES (11, 'hello3', 00, '10001', '20003', '2022-03-06 16:13:33', 01);
INSERT INTO `message` VALUES (12, '\nhello3', 00, '10001', '20003', '2022-03-06 16:13:35', 01);
INSERT INTO `message` VALUES (13, 'dsfdsfds\n\n\n', 00, '10001', '20001', '2022-03-06 17:11:49', 01);
INSERT INTO `message` VALUES (14, '\ndfdsf', 00, '10001', '10002', '2022-03-06 17:12:06', 01);
INSERT INTO `message` VALUES (15, '\ndsfdsf', 00, '10001', '10003', '2022-03-06 17:12:21', 01);
INSERT INTO `message` VALUES (16, '\ndfdsf', 00, '10001', '10003', '2022-03-06 17:12:26', 01);
INSERT INTO `message` VALUES (17, '\ndsfdsf', 00, '10001', '10004', '2022-03-06 17:12:32', 01);
INSERT INTO `message` VALUES (18, '11', 00, '10002', '10001', '2022-03-06 17:34:36', 01);
INSERT INTO `message` VALUES (19, '\n1', 00, '10002', '10001', '2022-03-06 17:34:37', 01);
INSERT INTO `message` VALUES (20, '\n1', 00, '10002', '10001', '2022-03-06 17:34:37', 01);
INSERT INTO `message` VALUES (21, '\n1', 00, '10002', '10001', '2022-03-06 17:34:37', 01);
INSERT INTO `message` VALUES (22, '34234324', 00, '10002', '10001', '2022-03-06 17:50:02', 01);
INSERT INTO `message` VALUES (23, '\nsdfasf', 00, '10002', '10001', '2022-03-06 17:50:03', 01);
INSERT INTO `message` VALUES (24, '神鼎飞丹砂、\\s\\', 00, '10001', '10002', '2022-03-06 17:52:53', 01);
INSERT INTO `message` VALUES (25, '\nsdfsd', 00, '10001', '10002', '2022-03-06 17:52:54', 01);
INSERT INTO `message` VALUES (26, '11', 00, '10001', '10002', '2022-03-08 21:30:35', 01);
INSERT INTO `message` VALUES (27, '\n11111', 00, '10001', '10002', '2022-03-08 21:30:59', 01);
INSERT INTO `message` VALUES (28, '1111', 00, '10002', '10001', '2022-03-08 21:31:29', 01);
INSERT INTO `message` VALUES (29, '111', 00, '10001', '20001', '2022-03-09 20:03:16', 01);
INSERT INTO `message` VALUES (30, '\n11', 00, '10001', '20001', '2022-03-09 20:03:17', 01);
INSERT INTO `message` VALUES (31, '\n111', 00, '10001', '10002', '2022-03-09 20:03:32', 01);
INSERT INTO `message` VALUES (32, '\n11', 00, '10001', '10002', '2022-03-09 20:03:33', 01);
INSERT INTO `message` VALUES (33, '\nhello', 00, '10001', '10002', '2022-03-09 20:04:07', 01);
INSERT INTO `message` VALUES (34, '111', 00, '10001', '10002', '2022-03-09 20:45:49', 01);
INSERT INTO `message` VALUES (35, '\nhello', 00, '10001', '10002', '2022-03-09 20:45:55', 01);
INSERT INTO `message` VALUES (36, 'hello222', 00, '10002', '10001', '2022-03-09 20:46:05', 01);
INSERT INTO `message` VALUES (37, '\nhello123456', 00, '10001', '10002', '2022-03-09 20:46:15', 01);
INSERT INTO `message` VALUES (38, '111', 00, '10001', '20002', '2022-03-09 21:01:43', 01);
INSERT INTO `message` VALUES (39, '111', 00, '10002', '10001', '2022-03-15 11:11:32', 00);
INSERT INTO `message` VALUES (40, '\n11', 00, '10002', '10001', '2022-03-15 11:11:34', 00);
INSERT INTO `message` VALUES (41, '\n1111\n\n\n', 00, '10001', '10002', '2022-03-15 11:11:58', 00);
INSERT INTO `message` VALUES (42, '1312312', 00, '10001', '10003', '2022-03-15 11:36:33', 01);
INSERT INTO `message` VALUES (43, '\nhello3', 00, '10001', '10003', '2022-03-15 11:36:35', 01);
INSERT INTO `message` VALUES (44, '\nhello3', 00, '10001', '10003', '2022-03-15 11:36:37', 01);
INSERT INTO `message` VALUES (45, '\nhello', 00, '10001', '10003', '2022-03-15 11:38:04', 01);
INSERT INTO `message` VALUES (46, '\nhello2', 00, '10001', '10003', '2022-03-15 11:38:06', 01);
INSERT INTO `message` VALUES (47, '1111\n', 00, '20001', '10001', '2022-04-26 13:36:35', 01);
INSERT INTO `message` VALUES (48, '\nhello teacher1', 00, '20001', '10001', '2022-04-26 13:36:39', 01);
INSERT INTO `message` VALUES (49, 'qwewqe', 00, '20001', '10001', '2022-04-26 14:05:09', 01);
INSERT INTO `message` VALUES (50, '\nwq', 00, '20001', '10001', '2022-04-26 14:05:09', 01);
INSERT INTO `message` VALUES (51, '\neqw', 00, '20001', '10001', '2022-04-26 14:05:09', 01);
INSERT INTO `message` VALUES (52, '\neqw', 00, '20001', '10001', '2022-04-26 14:05:10', 01);
INSERT INTO `message` VALUES (53, '\newq', 00, '20001', '10001', '2022-04-26 14:05:10', 01);
INSERT INTO `message` VALUES (54, '\ne', 00, '20001', '10001', '2022-04-26 14:05:10', 01);
INSERT INTO `message` VALUES (55, '11', 00, '20001', '10001', '2022-04-28 10:18:58', 01);
INSERT INTO `message` VALUES (56, '11', 00, '20001', '10001', '2022-04-28 10:20:30', 01);
INSERT INTO `message` VALUES (57, '\nsssssssssssssssssssaaaaaaaaaaaaaaaa', 00, '20001', '10001', '2022-04-28 10:20:37', 01);
INSERT INTO `message` VALUES (58, '\n111', 00, '20001', '10001', '2022-04-28 10:21:40', 01);
INSERT INTO `message` VALUES (59, '\n111', 00, '20001', '10001', '2022-04-28 10:21:40', 01);
INSERT INTO `message` VALUES (60, '1', 00, '20001', '10001', '2022-05-01 23:34:57', 01);
INSERT INTO `message` VALUES (61, '\n1', 00, '20001', '10001', '2022-05-01 23:34:58', 01);
INSERT INTO `message` VALUES (62, '111', 00, '20001', '10001', '2022-05-04 15:57:28', 01);
INSERT INTO `message` VALUES (63, '\n', 00, '20001', '10001', '2022-05-04 15:57:29', 01);
INSERT INTO `message` VALUES (64, '\n1', 00, '20001', '10001', '2022-05-04 15:57:29', 01);
INSERT INTO `message` VALUES (65, 'hello', 00, '20001', '10001', '2022-05-13 21:37:01', 01);
INSERT INTO `message` VALUES (66, '\nhelllo', 00, '20001', '10001', '2022-05-13 21:37:03', 01);
INSERT INTO `message` VALUES (67, '\nhello', 00, '20001', '10001', '2022-05-13 21:37:04', 01);
INSERT INTO `message` VALUES (68, 'edfsdasfsdf', 00, '20001', '10001', '2022-05-20 09:12:54', 00);

-- ----------------------------
-- Table structure for paperlib
-- ----------------------------
DROP TABLE IF EXISTS `paperlib`;
CREATE TABLE `paperlib`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课题名称',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '摘要',
  `file` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '附件链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of paperlib
-- ----------------------------
INSERT INTO `paperlib` VALUES (1, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);
INSERT INTO `paperlib` VALUES (2, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);
INSERT INTO `paperlib` VALUES (3, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);
INSERT INTO `paperlib` VALUES (4, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);
INSERT INTO `paperlib` VALUES (5, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);
INSERT INTO `paperlib` VALUES (6, '名字名字名字名字名字', '内容内容内容内容内内容内容内容内容内容内容内容容名字名字名字名字内容内容内容内容内容内容', NULL);
INSERT INTO `paperlib` VALUES (7, '名字名字名字名字名字', '内容内容内容内容内内容内容内容内容内容内容内容容名字名字名字名字内容内容内容内容内容内容', NULL);
INSERT INTO `paperlib` VALUES (8, '名字名字名字名字名字', '内容内容内容内容内内容内容内容内容内容内容内容容名字名字名字名字内容内容内容内容内容内容', NULL);
INSERT INTO `paperlib` VALUES (9, '名字名字名字名字名字', '内容内容内容内容内内容内容内容内容内容内容内容容名字名字名字名字内容内容内容内容内容内容', NULL);
INSERT INTO `paperlib` VALUES (10, '名字名字名字名字名字', '内容内容内容内容内内容内容内容内容内容内容内容容名字名字名字名字内容内容内容内容内容内容', NULL);
INSERT INTO `paperlib` VALUES (11, '名字名字名字名字名字', '内容内容内容内容内内容内容内容内容内容内容内容容名字名字名字名字内容内容内容内容内容内容', NULL);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `project_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,课题id',
  `project_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课题名',
  `project_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课题表述',
  `project_from_id` int NULL DEFAULT NULL COMMENT '外键,课题来源',
  `teacher_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,导师id',
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,学生id',
  `project_state` int NULL DEFAULT NULL COMMENT '该选题的状态，默认状态为0,该课题可选；为1时，待审核，不可选；选题状态2，已被选择，不可选。',
  PRIMARY KEY (`project_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  INDEX `project_from_id`(`project_from_id`) USING BTREE,
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `project_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `project_ibfk_3` FOREIGN KEY (`project_from_id`) REFERENCES `project_from` (`project_from_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (2, '选题111', '选题简介选题简介选题简介选题简介选题简介选题简介选题简介选题简介选题简介', 1, '11001', '210001', 2);
INSERT INTO `project` VALUES (3, '选题222', '选题简介选题简介选题简介选题简介选题简介选题简介选题简介选题简介选题简介', 2, '11001', '210002', 2);
INSERT INTO `project` VALUES (4, '选题3', 'string详情详情详情详情详情详情详情', NULL, '11001', NULL, 0);
INSERT INTO `project` VALUES (5, '选题3', 'string详情详情详情详情详情详情详情', NULL, '11001', NULL, 0);
INSERT INTO `project` VALUES (6, '选题3', 'string详情详情详情详情详情详情详情', NULL, '11001', NULL, 0);
INSERT INTO `project` VALUES (7, '选题3', 'string详情详情详情详情详情详情详情', NULL, '11001', NULL, 0);
INSERT INTO `project` VALUES (8, '选题3', 'string详情详情详情详情详情详情详情', NULL, '11001', NULL, 0);
INSERT INTO `project` VALUES (9, '3rewrwe', '12r3f', 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for project_from
-- ----------------------------
DROP TABLE IF EXISTS `project_from`;
CREATE TABLE `project_from`  (
  `project_from_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,id',
  `project_from_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课题来源(教师建议 学生拟定 企业和社会征集 科研单位提供)',
  PRIMARY KEY (`project_from_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of project_from
-- ----------------------------
INSERT INTO `project_from` VALUES (1, '自定选题');
INSERT INTO `project_from` VALUES (2, '社会实践来源');

-- ----------------------------
-- Table structure for qzxj
-- ----------------------------
DROP TABLE IF EXISTS `qzxj`;
CREATE TABLE `qzxj`  (
  `qzxj_id` int NOT NULL,
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`qzxj_id`) USING BTREE,
  INDEX `qzxj_ikbj_1`(`student_id`) USING BTREE,
  CONSTRAINT `qzxj_ikbj_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qzxj
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `roles_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,角色id',
  `roles_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名（导师，学生，管理员，超级管理员）',
  PRIMARY KEY (`roles_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, 'teacher');
INSERT INTO `roles` VALUES (2, 'student');
INSERT INTO `roles` VALUES (3, 'admin');

-- ----------------------------
-- Table structure for sessionList
-- ----------------------------
DROP TABLE IF EXISTS `sessionList`;
CREATE TABLE `sessionList`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者的id',
  `to_user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接受者的ID',
  `list_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `un_read_count` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '未读消息个数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `wk_1`(`user_id`) USING BTREE,
  INDEX `wk_2`(`to_user_id`) USING BTREE,
  CONSTRAINT `wk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wk_2` FOREIGN KEY (`to_user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sessionList
-- ----------------------------
INSERT INTO `sessionList` VALUES (46, '10001', '10003', '教师3', 0000000000);
INSERT INTO `sessionList` VALUES (47, '10003', '10001', '教师1', 0000000005);
INSERT INTO `sessionList` VALUES (48, '10001', '20002', '学生2', 0000000000);
INSERT INTO `sessionList` VALUES (49, '20002', '10001', '教师1', 0000000000);
INSERT INTO `sessionList` VALUES (50, '20001', '30001', '管理员', 0000000000);
INSERT INTO `sessionList` VALUES (51, '20001', '10002', '教师2', 0000000000);
INSERT INTO `sessionList` VALUES (52, '10002', '20001', '学生1', 0000000000);
INSERT INTO `sessionList` VALUES (53, '20001', '10001', '教师1', 0000000000);
INSERT INTO `sessionList` VALUES (54, '10001', '20001', '学生1', 0000000000);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键,学生id',
  `project_num` int NULL DEFAULT 0 COMMENT '课题数,只能选择一个课题',
  `project_id` int NULL DEFAULT NULL COMMENT '外键,课题',
  `teacher_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,导师id',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,用户id',
  `class_id` int NULL DEFAULT NULL COMMENT '外键,班级id',
  `student_score` int NULL DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  INDEX `project_id`(`project_id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_3` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_4` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_5` FOREIGN KEY (`class_id`) REFERENCES `classi` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('210001', 1, 2, '11001', '20001', 1, NULL);
INSERT INTO `student` VALUES ('210002', 1, 3, '11001', '20002', 2, NULL);
INSERT INTO `student` VALUES ('210003', 0, NULL, NULL, '20003', 3, NULL);
INSERT INTO `student` VALUES ('210004', 0, NULL, NULL, '20004', 1, NULL);
INSERT INTO `student` VALUES ('210005', 0, NULL, NULL, '20005', 2, NULL);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `subject_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,id',
  `subject_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业名',
  PRIMARY KEY (`subject_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专业名表\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '计算机科学技术');
INSERT INTO `subject` VALUES (2, '电子信息');
INSERT INTO `subject` VALUES (3, '人工智能');
INSERT INTO `subject` VALUES (4, '数据分析');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键,导师id',
  `teacher_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '导师描述',
  `teacher_project_num` int(10) UNSIGNED ZEROFILL NULL DEFAULT 0000000000 COMMENT '导师出题数,限制在8个',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,用户id',
  `dept_id` int NULL DEFAULT NULL COMMENT '外键,部门id',
  `zhicheng` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`teacher_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('11001', '计算机科学方向', 0000000007, '10001', 1, '副教授');
INSERT INTO `teacher` VALUES ('110010', '大数据方向', 0000000000, '100010', 3, '副教授');
INSERT INTO `teacher` VALUES ('110011', '大数据方向', 0000000000, '100011', 2, '副教授');
INSERT INTO `teacher` VALUES ('110012', '大数据方向', 0000000000, '100012', 1, '副教授');
INSERT INTO `teacher` VALUES ('11002', '大数据方向', 0000000000, '10002', 2, '副教授');
INSERT INTO `teacher` VALUES ('11003', 'Java方向', 0000000000, '10003', 1, '副教授');
INSERT INTO `teacher` VALUES ('11004', 'Java方向', 0000000000, '10004', 1, '副教授');
INSERT INTO `teacher` VALUES ('11005', '自然语言处理方向(NLP)', 0000000000, '10005', 3, '教授');
INSERT INTO `teacher` VALUES ('11006', 'Java方向', 0000000000, '10006', 2, '教授');
INSERT INTO `teacher` VALUES ('11007', 'Java方向', 0000000000, '10007', 3, '教授');
INSERT INTO `teacher` VALUES ('11008', '大数据方向', 0000000000, '10008', 1, '副教授');
INSERT INTO `teacher` VALUES ('11009', '大数据方向', 0000000000, '10009', 2, '副教授');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录账号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_tel` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `user_sex` int NULL DEFAULT NULL COMMENT '用户性别',
  `user_roles` int NULL DEFAULT 3 COMMENT '用户角色',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_ibfk_1`(`user_roles`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_roles`) REFERENCES `roles` (`roles_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10001', '教师1', '教师1', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('100010', '教师10', '教师10', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('100011', '教师11', '教师11', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('100012', '教师12', '教师12', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10002', '教师2', '教师2', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10003', '教师3', '教师3', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10004', '教师4', '教师4', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10005', '教师5', '教师5', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10006', '教师6', '教师6', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10007', '教师7', '教师7', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10008', '教师8', '教师8', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10009', '教师9', '教师9', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('20001', '学生1', '学生1', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('20002', '学生2', '学生2', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('20003', '学生3', '学生3', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('20004', '学生4', '学生4', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('20005', '学生5', '学生5', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('30001', '管理员', '管理员', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 3);

SET FOREIGN_KEY_CHECKS = 1;
