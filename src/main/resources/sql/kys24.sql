/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.19 : Database - kys24
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kys24` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kys24`;

/*Table structure for table `tb_bank` */

DROP TABLE IF EXISTS `tb_bank`;

CREATE TABLE `tb_bank` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(8) DEFAULT NULL COMMENT '姓名',
  `cardid` int(11) DEFAULT NULL COMMENT '银行卡',
  `is_success` bit(1) DEFAULT NULL COMMENT '付款是否成功',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_bank` */

/*Table structure for table `tb_brand` */

DROP TABLE IF EXISTS `tb_brand`;

CREATE TABLE `tb_brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌编号',
  `variety_id` int(11) DEFAULT NULL COMMENT '商品种类编号',
  `brand_name` varchar(8) DEFAULT NULL COMMENT '品牌名字',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  'brand_picture' VARCHAR(200) NOT NULL DEFAULT '' COMMENT '品牌图片地址',
  PRIMARY KEY (`brand_id`),
  KEY `brandName` (`brand_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_brand` */

/*Table structure for table `tb_commodity` */

DROP TABLE IF EXISTS `tb_commodity`;

CREATE TABLE `tb_commodity` (
  `commodity_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `commodity_name` varchar(8) DEFAULT NULL COMMENT '商品名称',
  `commodity_brand` int(11) DEFAULT NULL COMMENT '品牌ID',
  `commodity_variety` int(11) DEFAULT NULL COMMENT '种类ID',
  `commodity_depict` varchar(200) DEFAULT NULL COMMENT '商品标签',
  `commodity_price` float(7,2) DEFAULT NULL COMMENT '商品价格(单价)',
  `commodity_amount` int(11) DEFAULT NULL COMMENT '库存',
  `commodity_leavenum` int(11) DEFAULT NULL COMMENT '商品剩余数量',
  `commodity_standard` float(5,2) DEFAULT NULL COMMENT '商品规格',
  `operator` int(11) DEFAULT NULL COMMENT '操作人编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `commodity_picture` varchar(40) DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`commodity_id`),
  KEY `commidityname` (`commodity_name`),
  KEY `commidity_brand` (`commodity_brand`),
  KEY `commidity_variety` (`commodity_variety`),
  KEY `commoditydepict` (`commodity_depict`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_commodity` */

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `order_address` varchar(100) DEFAULT NULL COMMENT '收货地址',
  `ispayoff` bit(1) DEFAULT NULL COMMENT '买家是否付款',
  `amount` float(9,2) DEFAULT NULL COMMENT '商品数量(购买数量)',
  `total_price` float(9,2) DEFAULT NULL COMMENT '总金额',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单提交时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '订单更新时间',
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_order` */

/*Table structure for table `tb_orderlist` */

DROP TABLE IF EXISTS `tb_orderlist`;

CREATE TABLE `tb_orderlist` (
  `orderlist_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单列表编号',
  `order_id` int(11) DEFAULT NULL COMMENT '订单编号',
  `commdity_id` int(11) DEFAULT NULL COMMENT '商品编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`orderlist_id`),
  KEY `order_id` (`order_id`),
  KEY `commdity_id` (`commdity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_orderlist` */

/*Table structure for table `tb_orderstate` */

DROP TABLE IF EXISTS `tb_orderstate`;

CREATE TABLE `tb_orderstate` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `consignmenttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发货时间',
  `isconsignment` bit(1) DEFAULT NULL COMMENT '是否发货',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_orderstate` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `user_address` varchar(100) DEFAULT NULL COMMENT '用户地址',
  `token` varchar(20) DEFAULT NULL COMMENT '密钥',
  `type` varchar(10) DEFAULT NULL COMMENT '类型',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  KEY `user_id` (`user_id`),
  KEY `user_name` (`user_name`),
  KEY `user_phone` (`user_phone`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

/*Table structure for table `tb_variety` */

DROP TABLE IF EXISTS `tb_variety`;

CREATE TABLE `tb_variety` (
  `variety_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品种类ID',
  `variety_name` varchar(8) DEFAULT NULL COMMENT '品种名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点ID',
  `type` varchar(10) DEFAULT NULL COMMENT '品种编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`variety_id`),
  KEY `varirtyname` (`variety_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_variety` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
