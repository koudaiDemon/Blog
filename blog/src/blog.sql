/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-09-10 12:14:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tannouncement
-- ----------------------------
DROP TABLE IF EXISTS `tannouncement`;
CREATE TABLE `tannouncement` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `imgsrc` varchar(255) DEFAULT NULL,
  `submitTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `mid` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_Tannouncement_Timage_1` (`imgsrc`),
  KEY `fk_Tannouncement_Tmanager_1` (`mid`),
  CONSTRAINT `fk_Tannouncement_Tmanager_1` FOREIGN KEY (`mid`) REFERENCES `tmanager` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tannouncement
-- ----------------------------
INSERT INTO `tannouncement` VALUES ('2', '劳资明天不上班，爽翻！', '<p>&lt;p&gt;&amp;lt;p&amp;gt;&amp;amp;lt;p&amp;amp;gt;test againtest againtest againtest again&amp;amp;lt;br&amp;amp;gt;&amp;amp;lt;/p&amp;amp;gt;&amp;lt;br&amp;gt;&amp;lt;/p&amp;gt;&lt;br&gt;&lt;/p&gt;<br></p>', '66cd97f6-f4a5-42a8-bfc9-ecf798080793.jpg', '2017-09-10 10:02:38', '2');
INSERT INTO `tannouncement` VALUES ('3', 'hellohellohello', '<p>ellohellohelloellohellohelloellohellohello<br></p>', 'fb4822da-77c8-4998-b715-f340ee2cc0de.jpg', '2017-09-07 18:36:10', '2');

-- ----------------------------
-- Table structure for tarticle
-- ----------------------------
DROP TABLE IF EXISTS `tarticle`;
CREATE TABLE `tarticle` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `cid` int(11) DEFAULT NULL,
  `submitTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `lastTime` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `readTimes` int(11) DEFAULT '0',
  `feedbackNum` int(11) DEFAULT '0',
  `imagesrc` varchar(255) DEFAULT NULL,
  `isHide` int(11) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_Tartical_Tuser_1` (`uid`),
  KEY `fk_Tartical_Timage_1` (`imagesrc`),
  KEY `fk_Tartical_Tcategory_1` (`cid`),
  CONSTRAINT `fk_Tartical_Tcategory_1` FOREIGN KEY (`cid`) REFERENCES `tcategory` (`_id`),
  CONSTRAINT `fk_Tartical_Tuser_1` FOREIGN KEY (`uid`) REFERENCES `tuser` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tarticle
-- ----------------------------
INSERT INTO `tarticle` VALUES ('1', 'titleee', 'helloooooooooooooo worldddddddddddddddddd', '3', '2017-09-06 09:30:05', null, '1', '2333', '27', null, '0', null);
INSERT INTO `tarticle` VALUES ('3', 'test', 'just for test', '4', '2017-09-06 10:55:59', null, '1', '0', '3', null, '0', null);
INSERT INTO `tarticle` VALUES ('46', '123', '123', '3', '2017-09-08 19:27:12', '2017-09-08 19:26:12', '2', '0', '0', null, '0', '123');
INSERT INTO `tarticle` VALUES ('47', '有文章吗', '<p>有文章吗 有东西吗</p>', '6', '2017-09-09 14:02:28', '2017-09-09 14:01:28', '2', '0', '0', null, '0', '有东西吗');

-- ----------------------------
-- Table structure for tcategory
-- ----------------------------
DROP TABLE IF EXISTS `tcategory`;
CREATE TABLE `tcategory` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `acount` int(255) DEFAULT '0',
  `keywords` varchar(255) DEFAULT NULL,
  `vname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_id` (`pid`),
  CONSTRAINT `fk_id` FOREIGN KEY (`pid`) REFERENCES `tcategory` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcategory
-- ----------------------------
INSERT INTO `tcategory` VALUES ('2', '前端技术', '关于前端技术的文章', null, '10', 'CSS,HTML,JavaScript,Vue', 'web');
INSERT INTO `tcategory` VALUES ('3', '后端程序', '各种各样的后端程序', null, '20', 'Tomcat,架构', '后端');
INSERT INTO `tcategory` VALUES ('4', '管理系统', '让人感受到恐惧的管理系统', null, '50', '酒店管理,商品管理', 'manager');
INSERT INTO `tcategory` VALUES ('6', '程序人生', '当程序做到一定的地步了，就开始养生了', null, '0', '禅与技术,修身养性', 'life');

-- ----------------------------
-- Table structure for tcomm
-- ----------------------------
DROP TABLE IF EXISTS `tcomm`;
CREATE TABLE `tcomm` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `commTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `aid` int(11) DEFAULT NULL,
  `parentcommid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_Tcomm_Tartical_1` (`aid`),
  KEY `fk_Tcomm_Tcomm_1` (`parentcommid`),
  KEY `fk_comm_uid` (`uid`),
  CONSTRAINT `fk_comm_uid` FOREIGN KEY (`uid`) REFERENCES `tuser` (`_id`),
  CONSTRAINT `fk_Tcomm_Tartical_1` FOREIGN KEY (`aid`) REFERENCES `tarticle` (`_id`),
  CONSTRAINT `fk_Tcomm_Tcomm_1` FOREIGN KEY (`parentcommid`) REFERENCES `tcomm` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcomm
-- ----------------------------
INSERT INTO `tcomm` VALUES ('1', '测试1号', '2017-09-06 13:43:42', '1', null, '1');
INSERT INTO `tcomm` VALUES ('2', '测试2号', '2017-09-06 13:44:57', '3', null, '1');
INSERT INTO `tcomm` VALUES ('3', 'test test', '2017-09-06 13:45:15', '3', null, '2');
INSERT INTO `tcomm` VALUES ('4', '还是想测试', '2017-09-06 13:45:34', '1', null, '2');

-- ----------------------------
-- Table structure for thead
-- ----------------------------
DROP TABLE IF EXISTS `thead`;
CREATE TABLE `thead` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of thead
-- ----------------------------
INSERT INTO `thead` VALUES ('1', '1c9dcf29-2df3-4ee3-b41a-359f6aed72dd.jpg');
INSERT INTO `thead` VALUES ('2', '0cd4a9df-076c-43b1-8c7c-732de1f8e03f.jpg');
INSERT INTO `thead` VALUES ('3', '6999a79c-dfa3-4ad9-b3c2-914035c1f211.jpg');
INSERT INTO `thead` VALUES ('4', '976e72d2-165a-45d4-b7ad-b6f0abdf7ec8.jpg');
INSERT INTO `thead` VALUES ('5', '0eb22218-83a1-41be-bafc-5318ede51546.jpg');
INSERT INTO `thead` VALUES ('6', '9639c045-aca4-4e57-8dca-94497f920074.jpg');
INSERT INTO `thead` VALUES ('7', 'c2cabff0-3e8a-463e-8875-d857e69ce71b.jpg');
INSERT INTO `thead` VALUES ('8', 'd82b5df2-d03a-4532-b4a1-dec82e32ff40.jpg');
INSERT INTO `thead` VALUES ('9', '710f7d92-d07c-44f1-888c-5014d0aeade7.jpg');
INSERT INTO `thead` VALUES ('10', '8a5bc842-08bc-4187-a8f7-ef848856cfa7.jpg');
INSERT INTO `thead` VALUES ('11', 'f6f13f49-5175-4178-afdf-6a40833d00e0.jpg');
INSERT INTO `thead` VALUES ('12', '5b63bd0c-7ce2-479b-a40a-6221f7694d2a.jpg');
INSERT INTO `thead` VALUES ('13', '59db0bf2-4ccb-4833-b45d-ddc272be825e.jpg');

-- ----------------------------
-- Table structure for tlink
-- ----------------------------
DROP TABLE IF EXISTS `tlink`;
CREATE TABLE `tlink` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `linkimgSrc` varchar(255) DEFAULT NULL,
  `information` varchar(255) DEFAULT NULL,
  `target` int(11) DEFAULT NULL,
  `rel` int(11) DEFAULT NULL,
  `addTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_Tlink_Timage_1` (`linkimgSrc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tlink
-- ----------------------------
INSERT INTO `tlink` VALUES ('1', '测试网站', 'https://www.baidu.com', 'https://', '这是一个百度赞助的页面', '1', '1', '2017-09-05 17:54:42', '2017-09-05 17:54:15');
INSERT INTO `tlink` VALUES ('2', '凯腾公司', 'htttp://www.kaiteng.com', 'http://cdn:192.168.46.13/touxiang.img', '由凯腾公司赞助', '1', '1', '2017-09-05 16:29:57', null);

-- ----------------------------
-- Table structure for tlogin
-- ----------------------------
DROP TABLE IF EXISTS `tlogin`;
CREATE TABLE `tlogin` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `loadIp` varchar(255) DEFAULT NULL,
  `loadTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `isSuccess` int(11) DEFAULT '1',
  PRIMARY KEY (`_id`),
  KEY `fk_mid` (`mid`),
  KEY `fk_uid` (`uid`),
  CONSTRAINT `fk_mid` FOREIGN KEY (`mid`) REFERENCES `tmanager` (`_id`),
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `tuser` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tlogin
-- ----------------------------
INSERT INTO `tlogin` VALUES ('6', '192.168.46.13', '2017-09-08 10:39:32', '2', null, '1');
INSERT INTO `tlogin` VALUES ('12', '192.168.46.13', '2017-09-08 14:25:00', '2', null, '1');
INSERT INTO `tlogin` VALUES ('13', '192.168.46.13', '2017-09-08 14:27:57', '2', null, '1');
INSERT INTO `tlogin` VALUES ('14', '192.168.46.13', '2017-09-08 14:34:32', '2', null, '1');
INSERT INTO `tlogin` VALUES ('15', '192.168.46.13', '2017-09-08 14:37:58', '2', null, '1');
INSERT INTO `tlogin` VALUES ('18', '192.168.46.40', '2017-09-08 15:06:01', '2', null, '1');
INSERT INTO `tlogin` VALUES ('20', '127.0.0.1', '2017-09-08 15:28:48', null, null, '1');
INSERT INTO `tlogin` VALUES ('21', '127.0.0.1', '2017-09-08 15:38:11', null, null, '1');
INSERT INTO `tlogin` VALUES ('22', '192.168.46.13', '2017-09-08 15:44:59', null, null, '1');
INSERT INTO `tlogin` VALUES ('23', '192.168.46.13', '2017-09-08 15:48:44', null, null, '1');
INSERT INTO `tlogin` VALUES ('25', '192.168.46.13', '2017-09-08 15:51:50', null, null, '1');
INSERT INTO `tlogin` VALUES ('26', '192.168.46.13', '2017-09-08 15:53:50', null, null, '1');
INSERT INTO `tlogin` VALUES ('27', '192.168.46.13', '2017-09-08 15:55:13', null, null, '1');
INSERT INTO `tlogin` VALUES ('28', '127.0.0.1', '2017-09-08 15:56:29', null, null, '1');
INSERT INTO `tlogin` VALUES ('29', '127.0.0.1', '2017-09-08 15:56:29', null, null, '1');
INSERT INTO `tlogin` VALUES ('30', '192.168.46.13', '2017-09-08 15:56:49', null, null, '1');
INSERT INTO `tlogin` VALUES ('31', '192.168.46.13', '2017-09-08 15:58:05', null, null, '1');
INSERT INTO `tlogin` VALUES ('32', '192.168.46.13', '2017-09-08 16:15:14', null, null, '1');
INSERT INTO `tlogin` VALUES ('33', '192.168.46.13', '2017-09-08 16:20:45', '2', null, '1');
INSERT INTO `tlogin` VALUES ('34', '192.168.46.13', '2017-09-08 16:31:33', '2', null, '1');
INSERT INTO `tlogin` VALUES ('35', '192.168.46.13', '2017-09-08 16:39:20', '2', null, '1');
INSERT INTO `tlogin` VALUES ('36', '127.0.0.1', '2017-09-08 17:25:55', null, null, '1');
INSERT INTO `tlogin` VALUES ('37', '127.0.0.1', '2017-09-08 17:36:38', null, null, '1');
INSERT INTO `tlogin` VALUES ('38', '192.168.46.13', '2017-09-08 18:41:06', '2', null, '1');
INSERT INTO `tlogin` VALUES ('40', '127.0.0.1', '2017-09-08 18:46:43', null, null, '1');
INSERT INTO `tlogin` VALUES ('41', '192.168.46.13', '2017-09-08 18:48:08', null, null, '1');
INSERT INTO `tlogin` VALUES ('43', '127.0.0.1', '2017-09-08 19:04:03', '2', null, '1');
INSERT INTO `tlogin` VALUES ('44', '192.168.46.13', '2017-09-08 19:07:45', '2', null, '1');
INSERT INTO `tlogin` VALUES ('45', '192.168.46.13', '2017-09-08 19:10:31', '2', null, '1');
INSERT INTO `tlogin` VALUES ('46', '192.168.46.13', '2017-09-08 19:12:08', '2', null, '1');
INSERT INTO `tlogin` VALUES ('47', '192.168.46.13', '2017-09-08 19:13:30', '2', null, '1');
INSERT INTO `tlogin` VALUES ('48', '192.168.46.13', '2017-09-08 19:26:20', '2', null, '1');
INSERT INTO `tlogin` VALUES ('49', '192.168.46.13', '2017-09-08 19:30:27', '2', null, '1');
INSERT INTO `tlogin` VALUES ('50', '127.0.0.1', '2017-09-08 19:33:21', null, null, '1');
INSERT INTO `tlogin` VALUES ('51', '192.168.46.13', '2017-09-08 19:37:10', '2', null, '1');
INSERT INTO `tlogin` VALUES ('52', '127.0.0.1', '2017-09-08 19:55:39', null, null, '1');
INSERT INTO `tlogin` VALUES ('53', '192.168.46.13', '2017-09-09 08:37:32', null, null, '1');
INSERT INTO `tlogin` VALUES ('54', '127.0.0.1', '2017-09-09 08:45:38', null, null, '1');
INSERT INTO `tlogin` VALUES ('55', '127.0.0.1', '2017-09-09 09:03:22', null, null, '1');
INSERT INTO `tlogin` VALUES ('56', '192.168.46.13', '2017-09-09 09:11:46', null, null, '1');
INSERT INTO `tlogin` VALUES ('57', '127.0.0.1', '2017-09-09 09:14:01', null, null, '1');
INSERT INTO `tlogin` VALUES ('58', '127.0.0.1', '2017-09-09 09:31:41', null, null, '1');
INSERT INTO `tlogin` VALUES ('59', '127.0.0.1', '2017-09-09 09:42:38', null, null, '1');
INSERT INTO `tlogin` VALUES ('60', '127.0.0.1', '2017-09-09 09:56:06', null, null, '1');
INSERT INTO `tlogin` VALUES ('61', '127.0.0.1', '2017-09-09 09:59:18', null, null, '1');
INSERT INTO `tlogin` VALUES ('62', '127.0.0.1', '2017-09-09 10:04:42', null, null, '1');
INSERT INTO `tlogin` VALUES ('63', '127.0.0.1', '2017-09-09 10:17:34', null, null, '1');
INSERT INTO `tlogin` VALUES ('64', '127.0.0.1', '2017-09-09 10:22:54', null, null, '1');
INSERT INTO `tlogin` VALUES ('65', '127.0.0.1', '2017-09-09 10:26:45', null, null, '1');
INSERT INTO `tlogin` VALUES ('66', '127.0.0.1', '2017-09-09 10:31:11', null, null, '1');
INSERT INTO `tlogin` VALUES ('67', '192.168.46.13', '2017-09-09 10:31:25', null, null, '1');
INSERT INTO `tlogin` VALUES ('68', '192.168.46.13', '2017-09-09 10:32:56', null, null, '1');
INSERT INTO `tlogin` VALUES ('69', '192.168.46.13', '2017-09-09 10:36:15', null, null, '1');
INSERT INTO `tlogin` VALUES ('70', '192.168.46.13', '2017-09-09 10:40:04', null, null, '1');
INSERT INTO `tlogin` VALUES ('71', '192.168.46.13', '2017-09-09 10:41:15', null, null, '1');
INSERT INTO `tlogin` VALUES ('72', '192.168.46.13', '2017-09-09 10:42:33', null, null, '1');
INSERT INTO `tlogin` VALUES ('73', '192.168.46.13', '2017-09-09 10:43:24', null, null, '1');
INSERT INTO `tlogin` VALUES ('74', '192.168.46.13', '2017-09-09 10:45:27', null, null, '1');
INSERT INTO `tlogin` VALUES ('75', '192.168.46.13', '2017-09-09 10:46:34', null, null, '1');
INSERT INTO `tlogin` VALUES ('76', '192.168.46.13', '2017-09-09 10:54:08', '2', null, '1');
INSERT INTO `tlogin` VALUES ('77', '192.168.46.13', '2017-09-09 11:05:26', null, null, '1');
INSERT INTO `tlogin` VALUES ('78', '192.168.46.13', '2017-09-09 11:08:08', null, null, '1');
INSERT INTO `tlogin` VALUES ('79', '192.168.46.13', '2017-09-09 11:12:03', null, null, '1');
INSERT INTO `tlogin` VALUES ('80', '192.168.46.13', '2017-09-09 11:15:10', '2', null, '1');
INSERT INTO `tlogin` VALUES ('81', '192.168.46.13', '2017-09-09 11:20:29', null, null, '1');
INSERT INTO `tlogin` VALUES ('82', '192.168.46.13', '2017-09-09 11:39:15', null, null, '1');
INSERT INTO `tlogin` VALUES ('83', '192.168.46.13', '2017-09-09 11:41:06', null, null, '1');
INSERT INTO `tlogin` VALUES ('84', '192.168.46.13', '2017-09-09 11:43:01', null, null, '1');
INSERT INTO `tlogin` VALUES ('85', '127.0.0.1', '2017-09-09 14:01:09', null, null, '1');
INSERT INTO `tlogin` VALUES ('86', '127.0.0.1', '2017-09-09 15:14:03', null, null, '1');
INSERT INTO `tlogin` VALUES ('87', '127.0.0.1', '2017-09-09 15:24:33', null, null, '1');
INSERT INTO `tlogin` VALUES ('88', '127.0.0.1', '2017-09-09 15:27:08', null, null, '1');
INSERT INTO `tlogin` VALUES ('89', '127.0.0.1', '2017-09-09 15:28:25', null, null, '1');
INSERT INTO `tlogin` VALUES ('90', '127.0.0.1', '2017-09-09 15:30:01', null, null, '1');
INSERT INTO `tlogin` VALUES ('91', '127.0.0.1', '2017-09-09 15:32:21', '2', null, '1');
INSERT INTO `tlogin` VALUES ('92', '127.0.0.1', '2017-09-09 17:22:12', null, null, '1');
INSERT INTO `tlogin` VALUES ('93', '127.0.0.1', '2017-09-09 17:29:24', '2', null, '1');
INSERT INTO `tlogin` VALUES ('94', '127.0.0.1', '2017-09-09 17:33:38', null, null, '1');
INSERT INTO `tlogin` VALUES ('95', '127.0.0.1', '2017-09-09 17:37:01', '2', null, '1');
INSERT INTO `tlogin` VALUES ('96', '127.0.0.1', '2017-09-09 17:40:53', null, null, '1');
INSERT INTO `tlogin` VALUES ('97', '127.0.0.1', '2017-09-09 17:48:24', null, null, '1');
INSERT INTO `tlogin` VALUES ('98', '127.0.0.1', '2017-09-09 17:53:45', null, null, '1');
INSERT INTO `tlogin` VALUES ('99', '127.0.0.1', '2017-09-10 09:26:53', '2', null, '1');
INSERT INTO `tlogin` VALUES ('100', '127.0.0.1', '2017-09-10 09:53:22', null, null, '1');
INSERT INTO `tlogin` VALUES ('101', '127.0.0.1', '2017-09-10 09:53:22', null, null, '1');
INSERT INTO `tlogin` VALUES ('102', '127.0.0.1', '2017-09-10 09:58:26', '2', null, '1');
INSERT INTO `tlogin` VALUES ('103', '127.0.0.1', '2017-09-10 09:59:20', '2', null, '1');
INSERT INTO `tlogin` VALUES ('104', '127.0.0.1', '2017-09-10 10:14:33', '2', null, '1');
INSERT INTO `tlogin` VALUES ('105', '127.0.0.1', '2017-09-10 10:41:52', '2', null, '1');
INSERT INTO `tlogin` VALUES ('106', '127.0.0.1', '2017-09-10 10:49:23', '2', null, '1');
INSERT INTO `tlogin` VALUES ('107', '192.168.46.13', '2017-09-10 10:51:24', '2', null, '1');
INSERT INTO `tlogin` VALUES ('108', '127.0.0.1', '2017-09-10 10:54:08', '2', null, '1');
INSERT INTO `tlogin` VALUES ('109', '127.0.0.1', '2017-09-10 10:56:21', '2', null, '1');
INSERT INTO `tlogin` VALUES ('110', '127.0.0.1', '2017-09-10 11:12:45', '2', null, '1');
INSERT INTO `tlogin` VALUES ('111', '127.0.0.1', '2017-09-10 11:34:53', null, null, '1');

-- ----------------------------
-- Table structure for tmanager
-- ----------------------------
DROP TABLE IF EXISTS `tmanager`;
CREATE TABLE `tmanager` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `hid` int(11) DEFAULT NULL,
  `regTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `lastloadTime` datetime DEFAULT NULL,
  `loadcount` int(255) DEFAULT NULL,
  `lastloadIp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_Tmanager_Thead_1` (`hid`),
  CONSTRAINT `fk_Tmanager_Thead_1` FOREIGN KEY (`hid`) REFERENCES `thead` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmanager
-- ----------------------------
INSERT INTO `tmanager` VALUES ('2', 'cwww', '123456', '15527165793', null, '2017-09-01 14:05:12', '2017-09-10 11:12:45', '34', '127.0.0.1');

-- ----------------------------
-- Table structure for tmessage
-- ----------------------------
DROP TABLE IF EXISTS `tmessage`;
CREATE TABLE `tmessage` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `submitTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_Tmessage_Tuser_1` (`uid`),
  CONSTRAINT `fk_Tmessage_Tuser_1` FOREIGN KEY (`uid`) REFERENCES `tuser` (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmessage
-- ----------------------------

-- ----------------------------
-- Table structure for tread
-- ----------------------------
DROP TABLE IF EXISTS `tread`;
CREATE TABLE `tread` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `readTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`_id`),
  KEY `fk_Tread_Tartical_1` (`aid`),
  KEY `fk_Tread_Tuser_1` (`uid`),
  CONSTRAINT `fk_Tread_Tartical_1` FOREIGN KEY (`aid`) REFERENCES `tarticle` (`_id`),
  CONSTRAINT `fk_Tread_Tuser_1` FOREIGN KEY (`uid`) REFERENCES `tuser` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tread
-- ----------------------------
INSERT INTO `tread` VALUES ('1', '1', '192.168.46.13', '1', '2017-09-06 10:50:11');

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `NickName` varchar(255) DEFAULT NULL,
  `Desciption` text,
  `Email` varchar(255) DEFAULT NULL,
  `RegisterTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `lastloadTime` datetime DEFAULT NULL,
  `hid` int(11) DEFAULT NULL,
  `acount` int(11) DEFAULT '0',
  `loadCount` int(11) DEFAULT '0',
  PRIMARY KEY (`_id`),
  UNIQUE KEY `NickName` (`NickName`),
  KEY `fk_Tuser_Thead_1` (`hid`),
  CONSTRAINT `fk_Tuser_Thead_1` FOREIGN KEY (`hid`) REFERENCES `thead` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('1', '蔡大为', '123456', 'koudai', '真的帅呀，我还是帅的', 'koudai520@qq.com', '2017-09-01 10:50:35', '2017-09-06 09:37:56', null, '1', null);
INSERT INTO `tuser` VALUES ('2', 'cm', '123456', 'cmmm', 'sss', '898989@qq.com', '2017-09-01 11:49:06', '2017-09-06 07:38:00', null, '48', null);
INSERT INTO `tuser` VALUES ('7', '古尔丹', '123456', '古尔丹', '测试用户', '456464874@qq.com', '2017-09-07 13:40:10', '2017-09-07 13:40:10', '11', '0', null);
DROP TRIGGER IF EXISTS `trg_update_article`;
DELIMITER ;;
CREATE TRIGGER `trg_update_article` AFTER INSERT ON `tarticle` FOR EACH ROW BEGIN
	UPDATE tuser SET acount = acount + 1 WHERE tuser._id = new.uid;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trg_update_comm`;
DELIMITER ;;
CREATE TRIGGER `trg_update_comm` AFTER INSERT ON `tcomm` FOR EACH ROW BEGIN
	UPDATE tarticle SET feedbackNum = feedbackNum + 1 WHERE tarticle._id = new.aid;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trg_update_manager`;
DELIMITER ;;
CREATE TRIGGER `trg_update_manager` AFTER INSERT ON `tlogin` FOR EACH ROW BEGIN
	IF new.uid is NULL THEN
		UPDATE tmanager SET loadcount = loadcount + 1 WHERE tmanager._id = new.mid;
	ELSEIF new.mid IS NULL THEN
		UPDATE tuser SET loadcount = loadcount + 1 WHERE tuser._id = new.uid;
	END IF;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trg_update_read`;
DELIMITER ;;
CREATE TRIGGER `trg_update_read` AFTER INSERT ON `tread` FOR EACH ROW BEGIN
	UPDATE tarticle SET readTimes = readTimes + 1 WHERE tarticle._id = new.aid;
END
;;
DELIMITER ;
