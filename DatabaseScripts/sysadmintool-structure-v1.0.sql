/*
SQLyog Community v12.3.2 (32 bit)
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
  `createdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `pwdvault` */

DROP TABLE IF EXISTS `pwdvault`;

CREATE TABLE `pwdvault` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `displayname` varchar(100) NOT NULL,
  `serveraddr` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `createdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT NULL,
  `createdby` int(11) DEFAULT NULL,
  `updatedby` int(11) DEFAULT NULL,
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(50) NOT NULL,
  `displayname` varchar(100) NOT NULL,
  `status` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `componentId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `status` bit(1) NOT NULL DEFAULT b'0',
  `createdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`componentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
