/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : retail

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2013-08-02 11:36:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_acl`
-- ----------------------------
DROP TABLE IF EXISTS `t_acl`;
CREATE TABLE `t_acl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `principalType` varchar(255) DEFAULT NULL,
  `principalId` int(11) DEFAULT NULL,
  `moduleId` int(11) DEFAULT NULL,
  `aclState` int(11) DEFAULT NULL,
  `aclTriState` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_acl
-- ----------------------------
INSERT INTO `t_acl` VALUES ('169', 'Role', '1', '25', '2', '0');
INSERT INTO `t_acl` VALUES ('170', 'Role', '1', '26', '255', '0');
INSERT INTO `t_acl` VALUES ('171', 'Role', '1', '27', '143', '0');
INSERT INTO `t_acl` VALUES ('172', 'Role', '1', '83', '15', '0');
INSERT INTO `t_acl` VALUES ('173', 'Role', '1', '28', '2', '0');
INSERT INTO `t_acl` VALUES ('174', 'Role', '1', '29', '15', '0');
INSERT INTO `t_acl` VALUES ('175', 'Role', '1', '30', '15', '0');
INSERT INTO `t_acl` VALUES ('176', 'Role', '1', '31', '15', '0');
INSERT INTO `t_acl` VALUES ('177', 'Role', '2', '25', '2', '0');
INSERT INTO `t_acl` VALUES ('178', 'Role', '2', '26', '2', '0');
INSERT INTO `t_acl` VALUES ('179', 'Role', '2', '27', '2', '0');
INSERT INTO `t_acl` VALUES ('180', 'Role', '2', '28', '2', '0');
INSERT INTO `t_acl` VALUES ('181', 'Role', '2', '29', '2', '0');
INSERT INTO `t_acl` VALUES ('182', 'Role', '2', '30', '2', '0');
INSERT INTO `t_acl` VALUES ('183', 'Role', '2', '31', '2', '0');

-- ----------------------------
-- Table structure for `t_module`
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK410348D7857001E4` (`pid`),
  CONSTRAINT `FK410348D7857001E4` FOREIGN KEY (`pid`) REFERENCES `t_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('25', '基本设置', '', '10', 'basemgr', null);
INSERT INTO `t_module` VALUES ('26', '团队管理', 'searchOrg', '1010', 'groupmgr', '25');
INSERT INTO `t_module` VALUES ('27', '业务员管理', 'searchPerson', '1020', 'salesman', '25');
INSERT INTO `t_module` VALUES ('28', '系统管理', '', '20', 'auth', null);
INSERT INTO `t_module` VALUES ('29', '模块管理', 'searchModules', '2010', 'module', '28');
INSERT INTO `t_module` VALUES ('30', '角色管理', 'searchRole', '2020', 'role', '28');
INSERT INTO `t_module` VALUES ('31', '用户管理', 'serarchUser', '2030', 'user', '28');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '系统管理员');
INSERT INTO `t_role` VALUES ('2', '普通员工');
INSERT INTO `t_role` VALUES ('3', '仓管员');

-- ----------------------------
-- Table structure for `t_salesman`
-- ----------------------------
DROP TABLE IF EXISTS `t_salesman`;
CREATE TABLE `t_salesman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `duty` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `org` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK459B3DC0202B6044` (`org`),
  CONSTRAINT `FK459B3DC0202B6044` FOREIGN KEY (`org`) REFERENCES `t_tearm` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_salesman
-- ----------------------------
INSERT INTO `t_salesman` VALUES ('1', '陈十', '女', '1', '', null, '12345678912', '1');
INSERT INTO `t_salesman` VALUES ('14', '电商管理员', '女', '20', '', null, '', '29');
INSERT INTO `t_salesman` VALUES ('16', '测试', '男', '18', '', null, '1511', '29');
INSERT INTO `t_salesman` VALUES ('18', '管理员', '女', '20', '2', null, '15119276805', '32');

-- ----------------------------
-- Table structure for `t_tearm`
-- ----------------------------
DROP TABLE IF EXISTS `t_tearm`;
CREATE TABLE `t_tearm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sn` (`sn`),
  KEY `FKEF75D35E202B62EB` (`pid`),
  CONSTRAINT `FKEF75D35E202B62EB` FOREIGN KEY (`pid`) REFERENCES `t_tearm` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tearm
-- ----------------------------
INSERT INTO `t_tearm` VALUES ('1', '社区开发一队', null, null, null, '001');
INSERT INTO `t_tearm` VALUES ('29', '社区开发二队', null, null, null, '002');
INSERT INTO `t_tearm` VALUES ('31', '社区开发三队1', null, null, null, '003');
INSERT INTO `t_tearm` VALUES ('32', '第一分队', null, null, '1', '004');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `expireTime` datetime DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `person` (`person`),
  KEY `FK94BA2CF64EE9E097` (`person`),
  CONSTRAINT `FK94BA2CF64EE9E097` FOREIGN KEY (`person`) REFERENCES `t_salesman` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'cs', 'cs', '2014-04-26 09:18:28', '2014-05-01 09:18:31', '1');

-- ----------------------------
-- Table structure for `t_usersroles`
-- ----------------------------
DROP TABLE IF EXISTS `t_usersroles`;
CREATE TABLE `t_usersroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD19B0A80F8194219` (`role`),
  KEY `FKD19B0A80F81C18C3` (`user`),
  CONSTRAINT `FKD19B0A80F8194219` FOREIGN KEY (`role`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKD19B0A80F81C18C3` FOREIGN KEY (`user`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_usersroles
-- ----------------------------
INSERT INTO `t_usersroles` VALUES ('1', '1', '1', '1');
INSERT INTO `t_usersroles` VALUES ('16', '2', '1', '99');
INSERT INTO `t_usersroles` VALUES ('17', '3', '1', '99');
