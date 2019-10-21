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

/*Data for the table `functioncodes` */

insert  into `functioncodes`(`componentId`,`displayname`,`functioncode`,`createdate`) values 
(1,'Dashboard','/dashboard','2019-10-20 23:25:38'),
(2,'User View / Search','/users','2019-10-20 23:26:13');

/*Data for the table `pwdvault` */

/*Data for the table `role` */

insert  into `role`(`componentId`,`rolename`,`displayname`,`status`) values 
(1,'admin','Administrator',''),
(2,'passwordmanager','Password Manager',''),
(3,'syslogmanager','System Log Manager','');

/*Data for the table `rolefunctioncodes` */

insert  into `rolefunctioncodes`(`componentId`,`roleid`,`funcid`,`createdate`,`createdby`,`updatedby`) values 
(1,1,1,'2019-10-19 00:40:28',1,1),
(2,1,2,'2019-10-21 23:17:51',NULL,NULL),
(3,2,2,'2019-10-21 23:17:58',NULL,NULL);

/*Data for the table `systemslogs` */

/*Data for the table `user` */

insert  into `user`(`componentId`,`username`,`fname`,`lname`,`email`,`password`,`status`,`createdate`,`updatedate`) values 
(1,'admin','admin','admin','admin@localhost.local','1234','','2019-10-17 20:25:19',NULL),
(2,'shobuj','mehedi hasan','shobuj','shobuj.akash1@gmail.com','1234','','2019-10-17 20:25:42',NULL),
(3,'shamim','shamim','ahmed','shamim@localhost.local','1234','','2019-10-17 20:26:05',NULL);

/*Data for the table `userrole` */

insert  into `userrole`(`componentId`,`userid`,`roleid`,`status`,`createdate`,`updatedate`) values 
(1,1,1,'','2019-10-17 20:27:15',NULL),
(2,2,2,'','2019-10-17 20:27:22',NULL),
(3,3,3,'','2019-10-17 20:27:27',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
