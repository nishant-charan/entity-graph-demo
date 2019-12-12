/*
SQLyog Ultimate v13.0.1 (64 bit)
MySQL - 5.6.40-log : Database - entitygraphdemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`entitygraphdemo` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `entitygraphdemo`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_text` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `comment_date` datetime NOT NULL,
  `post_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `post_constraint` (`post_id`),
  CONSTRAINT `post_constraint` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `comment` */

insert  into `comment`(`id`,`comment_text`,`comment_date`,`post_id`) values 
(1,'Comment 1 - Post 1','2019-11-28 14:17:19',1),
(2,'Comment 2 - Post 1','2019-11-28 14:17:40',1),
(3,'Comment 1 - Post 2','2019-11-28 16:18:10',2);

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `company` */

insert  into `company`(`id`,`name`) values 
(1,'Risesmart'),
(2,'Infosys');

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `post_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `post` */

insert  into `post`(`id`,`subject`,`post_date`) values 
(1,'Post 1','2019-11-28 14:16:34'),
(2,'Post 2','2019-11-28 16:16:48'),
(3,'Post 3','2019-11-28 16:45:04');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_company` (`company_id`),
  CONSTRAINT `FK_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`first_name`,`last_name`,`email`,`type`,`company_id`) values 
(1,'Nishant','Naveen','nishant.naveen@randstadrisesmart.com','INTERNAL',1),
(2,'Bibhakar','Prakash','bibhakar.prakash@randstadrisesmart.com','EXTERNAL',2),
(3,'Apeksha','Madan','apeksha.madan@randstadrisesmart.com','INTERNAL',1);

/*Table structure for table `user_post` */

DROP TABLE IF EXISTS `user_post`;

CREATE TABLE `user_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `post_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_contraints` (`user_id`),
  KEY `post_contraints` (`post_id`),
  CONSTRAINT `post_contraints` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT `user_contraints` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_post` */

insert  into `user_post`(`id`,`user_id`,`post_id`) values 
(1,1,1),
(2,1,2),
(3,2,1),
(4,2,3),
(5,3,1),
(6,3,2),
(7,3,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
