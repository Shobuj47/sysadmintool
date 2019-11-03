/*
SQLyog Community
MySQL - 10.1.37-MariaDB : Database - sysadmintool
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sysadmintool` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sysadmintool`;

/*Table structure for table `functioncodes` */

DROP TABLE IF EXISTS `functioncodes`;

CREATE TABLE `functioncodes` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `displayname` varchar(100) NOT NULL,
  `functioncode` varchar(250) NOT NULL,
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `ismenubar` bit(1) DEFAULT b'1',
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `functioncodes` */

insert  into `functioncodes`(`componentId`,`displayname`,`functioncode`,`createdate`,`ismenubar`) values 
(1,'Dashboard','dashboard','2019-10-20 23:25:38',''),
(2,'User View / Search','users','2019-10-20 23:26:13',''),
(3,'User Add/Modify','useraddmodify','2019-10-23 23:04:06','\0'),
(4,'Role View / Search','roles','2019-10-26 15:50:30',''),
(5,'Roles Add / Modify','rolesaddmodify','2019-10-26 15:51:02','\0'),
(6,'LMS Servers','lmsservers','2019-10-26 15:54:00','\0'),
(7,'LMS Servers Add / Modify','lmsserversaddmodify','2019-10-26 15:55:56','\0'),
(8,'PAM Servers','pwdvaultsearch','2019-10-26 15:56:09',''),
(9,'PAM Servers Add / Modify','pamserversaddmodify','2019-10-26 15:58:50',''),
(10,'User Delete','userdelete','2019-11-02 03:28:06','\0'),
(11,'Role Delete','rolesdelete','2019-11-02 12:19:48','\0'),
(13,'PAM Server Delete','pamserversdelete','2019-11-02 15:56:49','\0'),
(14,'Role Functions Mapping','rolefunctions','2019-11-03 23:41:49',''),
(15,'User Role Mapping','userroles','2019-11-03 23:42:04','');

/*Table structure for table `pwdvault` */

DROP TABLE IF EXISTS `pwdvault`;

CREATE TABLE `pwdvault` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `displayname` varchar(100) NOT NULL,
  `serveraddr` varchar(50) NOT NULL,
  `port` int(11) NOT NULL DEFAULT '22',
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT NULL,
  `updatedby` int(11) DEFAULT NULL,
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `pwdvault` */

insert  into `pwdvault`(`componentId`,`displayname`,`serveraddr`,`port`,`username`,`password`,`createdate`,`updatedate`,`updatedby`) values 
(1,'Virtual HTTP Server','192.168.142.130',22,'root','toor','2019-10-26 15:23:39',NULL,NULL),
(2,'Bakup Server','192.168.0.6',22,'root','root','2019-10-28 00:22:25',NULL,NULL);

/*Table structure for table `pwdvaultusers` */

DROP TABLE IF EXISTS `pwdvaultusers`;

CREATE TABLE `pwdvaultusers` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `pwdvaultid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `status` bit(1) DEFAULT b'0',
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `pwdvaultusers` */

insert  into `pwdvaultusers`(`componentId`,`pwdvaultid`,`userid`,`status`) values 
(1,1,1,''),
(2,2,1,''),
(3,4,1,'');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(50) NOT NULL,
  `displayname` varchar(100) NOT NULL,
  `status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`componentId`,`rolename`,`displayname`,`status`) values 
(1,'admin','Administrator',NULL),
(2,'passwordmanager','Password Manager',NULL),
(3,'syslogmanager','System Log Manager','');

/*Table structure for table `rolefunctioncodes` */

DROP TABLE IF EXISTS `rolefunctioncodes`;

CREATE TABLE `rolefunctioncodes` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NOT NULL,
  `funcid` int(11) NOT NULL,
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` int(11) DEFAULT NULL,
  `updatedby` int(11) DEFAULT NULL,
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `rolefunctioncodes` */

insert  into `rolefunctioncodes`(`componentId`,`roleid`,`funcid`,`createdate`,`createdby`,`updatedby`) values 
(1,1,1,'2019-10-19 00:40:28',1,1),
(2,1,2,'2019-10-21 23:17:51',1,1),
(3,1,3,'2019-10-21 23:17:58',1,1),
(4,1,4,'2019-10-23 23:06:49',1,1),
(5,1,5,'2019-10-23 23:07:03',1,1),
(6,1,6,'2019-10-23 23:09:02',1,1),
(7,1,7,'2019-10-23 23:09:06',1,1),
(8,1,8,'2019-10-26 15:56:33',NULL,NULL),
(9,2,8,'2019-11-01 14:54:00',NULL,NULL),
(10,2,1,'2019-11-01 14:54:25',NULL,NULL),
(11,1,10,'2019-11-02 03:28:28',NULL,NULL),
(12,1,11,'2019-11-02 12:20:08',NULL,NULL),
(13,1,9,'2019-11-02 14:22:33',NULL,NULL),
(14,1,13,'2019-11-02 15:57:37',NULL,NULL),
(15,1,14,'2019-11-03 23:43:30',NULL,NULL),
(16,1,15,'2019-11-03 23:43:34',NULL,NULL);

/*Table structure for table `systemslogs` */

DROP TABLE IF EXISTS `systemslogs`;

CREATE TABLE `systemslogs` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `displayname` varchar(100) NOT NULL,
  `serveraddr` varchar(100) NOT NULL,
  `loglevel` varchar(100) NOT NULL,
  `logdetail` varchar(250) NOT NULL,
  `createdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `systemslogs` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `status` bit(1) DEFAULT b'1',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`componentId`,`username`,`fname`,`lname`,`email`,`password`,`status`,`createdate`,`updatedate`) values 
(1,'admin','admin','admin','admin@localhost.local','1234','',NULL,'2019-11-02 02:41:11'),
(2,'shobuj','Mehedi Hasan','Sabuz','shobuj.akash1@gmail.com','12345','','2019-10-17 20:25:42','2019-11-02 02:31:26'),
(3,'shamim','shamim','ahmed','shamim@localhost.local','1234','','2019-10-17 20:26:05','2019-02-20 01:49:03');

/*Table structure for table `userrole` */

DROP TABLE IF EXISTS `userrole`;

CREATE TABLE `userrole` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `status` bit(1) DEFAULT b'0',
  `createdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `userrole` */

insert  into `userrole`(`componentId`,`userid`,`roleid`,`status`,`createdate`,`updatedate`) values 
(1,1,1,'','2019-10-17 20:27:15',NULL),
(2,2,2,'','2019-10-17 20:27:22',NULL),
(3,3,3,'','2019-10-17 20:27:27',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
