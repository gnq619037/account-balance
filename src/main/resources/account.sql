/*
SQLyog Trial v12.3.3 (64 bit)
MySQL - 5.6.26-log : Database - account_balance_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `t_account` */

CREATE TABLE `t_account` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `account_code` varchar(10) NOT NULL COMMENT '账户号',
  `account_status` int(1) DEFAULT NULL COMMENT '账户状态',
  `balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_code` (`account_code`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `t_account` */

/*Table structure for table `t_balance_limit` */

CREATE TABLE `t_balance_limit` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `limit_rate` int(3) DEFAULT NULL COMMENT '余额限制',
  `quota` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_balance_limit` */

/*Table structure for table `t_limit_account` */

CREATE TABLE `t_limit_account` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(10) DEFAULT NULL,
  `limit_id` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`,`limit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `t_limit_account` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
