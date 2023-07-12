/*
 Navicat Premium Data Transfer

 Source Server         : connection1
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 12/07/2023 09:16:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `productid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staraddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `endaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyerid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `productid`(`productid`) USING BTREE,
  INDEX `buyerid`(`buyerid`) USING BTREE,
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`buyerid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for browsehistory
-- ----------------------------
DROP TABLE IF EXISTS `browsehistory`;
CREATE TABLE `browsehistory`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `productid`(`productid`) USING BTREE,
  CONSTRAINT `browsehistory_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `browsehistory_ibfk_2` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `productid`(`productid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `sender` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `accepter` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sender`(`sender`) USING BTREE,
  INDEX `accepter`(`accepter`) USING BTREE,
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`sender`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`accepter`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chatlist
-- ----------------------------
DROP TABLE IF EXISTS `chatlist`;
CREATE TABLE `chatlist`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `uid1` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid2` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid1`(`uid1`) USING BTREE,
  INDEX `uid2`(`uid2`) USING BTREE,
  CONSTRAINT `chatlist_ibfk_1` FOREIGN KEY (`uid1`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `chatlist_ibfk_2` FOREIGN KEY (`uid2`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for concern
-- ----------------------------
DROP TABLE IF EXISTS `concern`;
CREATE TABLE `concern`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `uid1` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid2` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid1`(`uid1`) USING BTREE,
  INDEX `uid2`(`uid2`) USING BTREE,
  CONSTRAINT `concern_ibfk_1` FOREIGN KEY (`uid1`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `concern_ibfk_2` FOREIGN KEY (`uid2`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for loginlog
-- ----------------------------
DROP TABLE IF EXISTS `loginlog`;
CREATE TABLE `loginlog`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `userid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  CONSTRAINT `loginlog_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `text` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for postcomment
-- ----------------------------
DROP TABLE IF EXISTS `postcomment`;
CREATE TABLE `postcomment`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `text` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `postid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `postid`(`postid`) USING BTREE,
  CONSTRAINT `postcomment_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `postcomment_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for postfavor
-- ----------------------------
DROP TABLE IF EXISTS `postfavor`;
CREATE TABLE `postfavor`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `postid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `postid`(`postid`) USING BTREE,
  CONSTRAINT `postfavor_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `postfavor_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for posthistory
-- ----------------------------
DROP TABLE IF EXISTS `posthistory`;
CREATE TABLE `posthistory`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `postid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `postid`(`postid`) USING BTREE,
  CONSTRAINT `posthistory_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `posthistory_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for postpicture
-- ----------------------------
DROP TABLE IF EXISTS `postpicture`;
CREATE TABLE `postpicture`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `postid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pictureurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picturegrade` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `postid`(`postid`) USING BTREE,
  CONSTRAINT `postpicture_ibfk_1` FOREIGN KEY (`postid`) REFERENCES `post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for poststar
-- ----------------------------
DROP TABLE IF EXISTS `poststar`;
CREATE TABLE `poststar`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `postid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `postid`(`postid`) USING BTREE,
  CONSTRAINT `poststar_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `poststar_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `productname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productbro` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for productcomment
-- ----------------------------
DROP TABLE IF EXISTS `productcomment`;
CREATE TABLE `productcomment`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `productid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `commenttext` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `productid`(`productid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `productcomment_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `productcomment_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for productpicture
-- ----------------------------
DROP TABLE IF EXISTS `productpicture`;
CREATE TABLE `productpicture`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `pictureurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picturegrade` int(11) NOT NULL,
  `productid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `productid`(`productid`) USING BTREE,
  CONSTRAINT `productpicture_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for productstar
-- ----------------------------
DROP TABLE IF EXISTS `productstar`;
CREATE TABLE `productstar`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `productid`(`productid`) USING BTREE,
  CONSTRAINT `productstar_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `productstar_ibfk_2` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purchasewander
-- ----------------------------
DROP TABLE IF EXISTS `purchasewander`;
CREATE TABLE `purchasewander`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `wanderbro` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `purchasewander_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for searchhistory
-- ----------------------------
DROP TABLE IF EXISTS `searchhistory`;
CREATE TABLE `searchhistory`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `searchhistory_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sysmessage
-- ----------------------------
DROP TABLE IF EXISTS `sysmessage`;
CREATE TABLE `sysmessage`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `del` tinyint(1) NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `sysmessage_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `photourl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
