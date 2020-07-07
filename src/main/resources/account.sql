/*
SQLyog Trial v12.3.3 (64 bit)
MySQL - 5.7.24 : Database - account_balance_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`account_balance_management` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `account_balance_management`;

/*Table structure for table `t_account` */

DROP TABLE IF EXISTS `t_account`;

CREATE TABLE `t_account` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `account_code` varchar(10) NOT NULL COMMENT '账户号',
  `account_status` int(1) DEFAULT NULL COMMENT '账户状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_account` */

insert  into `t_account`(`id`,`account_code`,`account_status`) values
(1,'A',2);

/*Table structure for table `t_balance` */

DROP TABLE IF EXISTS `t_balance`;

CREATE TABLE `t_balance` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `balanceLimit` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `limit_rate` decimal(10,2) DEFAULT NULL COMMENT '余额限制',
  `account_id` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_balance` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
