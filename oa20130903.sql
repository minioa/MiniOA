CREATE DATABASE  IF NOT EXISTS `oa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `oa`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: oa
-- ------------------------------------------------------
-- Server version	5.5.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `core_leftmenu_role_relation`
--

DROP TABLE IF EXISTS `core_leftmenu_role_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_leftmenu_role_relation` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `menuId` int(10) unsigned DEFAULT NULL,
  `roleId` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_leftmenu_role_relation`
--

LOCK TABLES `core_leftmenu_role_relation` WRITE;
/*!40000 ALTER TABLE `core_leftmenu_role_relation` DISABLE KEYS */;
INSERT INTO `core_leftmenu_role_relation` VALUES (1,0,'2011-09-05 19:44:27',1,1),(2,0,'2011-09-05 19:44:27',2,1),(3,0,'2011-09-05 19:44:27',3,1),(6,0,'2011-09-05 19:44:27',6,1),(7,0,'2011-09-05 19:44:27',7,1),(8,0,'2011-09-05 19:44:27',8,1),(9,0,'2011-09-05 19:44:27',9,1),(10,0,'2011-09-05 19:44:27',10,1),(11,0,'2011-09-05 19:44:27',11,1),(12,0,'2011-09-05 19:44:27',12,1),(13,0,'2011-09-05 19:44:27',13,1),(14,0,'2011-09-05 19:44:27',14,1),(15,0,'2011-09-05 19:44:27',15,1),(16,0,'2011-09-05 19:44:27',17,1),(17,0,'2011-09-05 19:44:27',16,1),(18,0,'2011-09-05 20:21:52',4,1),(21,0,'2011-10-12 19:26:59',1,2),(22,0,'2011-10-12 19:26:59',6,2),(23,0,'2011-10-12 19:26:59',7,2),(25,0,'2012-01-12 20:29:43',2,2),(26,0,'2012-01-12 20:29:43',8,2),(27,0,'2012-01-12 20:29:43',9,2),(28,0,'2012-01-12 20:29:43',10,2),(29,0,'2012-01-12 20:29:43',11,2),(30,0,'2012-01-12 21:05:49',1,4),(31,0,'2012-01-12 21:05:49',2,4),(33,0,'2012-01-12 21:05:49',6,4),(34,0,'2012-01-12 21:05:49',7,4),(35,0,'2012-01-12 21:05:49',8,4),(36,0,'2012-01-12 21:05:49',9,4),(37,0,'2012-01-12 21:05:49',10,4),(38,0,'2012-01-12 21:05:49',11,4),(39,0,'2012-03-31 21:16:35',19,1),(40,0,'2012-03-31 21:16:35',21,1),(41,0,'2012-03-31 21:16:35',20,1),(42,0,'2012-03-31 21:16:35',23,1),(43,0,'2012-03-31 21:16:35',22,1),(44,0,'2012-03-31 22:02:17',24,1),(45,0,'2012-04-02 13:51:09',25,1),(47,0,'2012-04-02 19:48:08',27,1),(48,0,'2012-04-03 14:19:48',28,1),(49,0,'2012-04-22 09:58:53',29,2),(50,0,'2012-04-22 10:01:56',29,1),(51,0,'2012-04-22 10:24:36',30,1);
/*!40000 ALTER TABLE `core_leftmenu_role_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofpubsubdefaultconf`
--

DROP TABLE IF EXISTS `ofpubsubdefaultconf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofpubsubdefaultconf` (
  `serviceID` varchar(100) NOT NULL,
  `leaf` tinyint(4) NOT NULL,
  `deliverPayloads` tinyint(4) NOT NULL,
  `maxPayloadSize` int(11) NOT NULL,
  `persistItems` tinyint(4) NOT NULL,
  `maxItems` int(11) NOT NULL,
  `notifyConfigChanges` tinyint(4) NOT NULL,
  `notifyDelete` tinyint(4) NOT NULL,
  `notifyRetract` tinyint(4) NOT NULL,
  `presenceBased` tinyint(4) NOT NULL,
  `sendItemSubscribe` tinyint(4) NOT NULL,
  `publisherModel` varchar(15) NOT NULL,
  `subscriptionEnabled` tinyint(4) NOT NULL,
  `accessModel` varchar(10) NOT NULL,
  `language` varchar(255) DEFAULT NULL,
  `replyPolicy` varchar(15) DEFAULT NULL,
  `associationPolicy` varchar(15) NOT NULL,
  `maxLeafNodes` int(11) NOT NULL,
  PRIMARY KEY (`serviceID`,`leaf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofpubsubdefaultconf`
--

LOCK TABLES `ofpubsubdefaultconf` WRITE;
/*!40000 ALTER TABLE `ofpubsubdefaultconf` DISABLE KEYS */;
INSERT INTO `ofpubsubdefaultconf` VALUES ('pubsub',0,0,0,0,0,1,1,1,0,0,'publishers',1,'open','English',NULL,'all',-1),('pubsub',1,1,5120,0,-1,1,1,1,0,1,'publishers',1,'open','English',NULL,'all',-1);
/*!40000 ALTER TABLE `ofpubsubdefaultconf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofmucmember`
--

DROP TABLE IF EXISTS `ofmucmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofmucmember` (
  `roomID` bigint(20) NOT NULL,
  `jid` text NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `faqentry` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`roomID`,`jid`(70))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofmucmember`
--

LOCK TABLES `ofmucmember` WRITE;
/*!40000 ALTER TABLE `ofmucmember` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofmucmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofpubsubnodegroups`
--

DROP TABLE IF EXISTS `ofpubsubnodegroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofpubsubnodegroups` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `rosterGroup` varchar(100) NOT NULL,
  KEY `ofPubsubNodeGroups_idx` (`serviceID`,`nodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofpubsubnodegroups`
--

LOCK TABLES `ofpubsubnodegroups` WRITE;
/*!40000 ALTER TABLE `ofpubsubnodegroups` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofpubsubnodegroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofid`
--

DROP TABLE IF EXISTS `ofid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofid` (
  `idType` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`idType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofid`
--

LOCK TABLES `ofid` WRITE;
/*!40000 ALTER TABLE `ofid` DISABLE KEYS */;
INSERT INTO `ofid` VALUES (18,6),(19,5),(23,1),(25,9),(26,2);
/*!40000 ALTER TABLE `ofid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_prop`
--

DROP TABLE IF EXISTS `core_prop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_prop` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `propName` varchar(450) DEFAULT NULL,
  `propDesc` varchar(45) DEFAULT NULL,
  `propValue` varchar(450) DEFAULT NULL,
  `inputType` varchar(45) DEFAULT 'textbox',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_prop`
--

LOCK TABLES `core_prop` WRITE;
/*!40000 ALTER TABLE `core_prop` DISABLE KEYS */;
INSERT INTO `core_prop` VALUES (1,1,NULL,1,'2012-01-07 14:02:02',NULL,'passwordKey','密码钥匙','r02851SotjG4n01','textbox'),(2,1,NULL,1,'2013-05-30 19:53:44',NULL,'validateCode','是否启用验证码','N','radio'),(4,1,NULL,1,'2012-01-12 19:53:52',NULL,'enableOpenfire','是否开启即时通讯服务','N','radio'),(5,1,NULL,1,'2012-01-12 19:53:45',NULL,'enableSMS','是否开启短信提醒服务','N','radio'),(6,1,NULL,NULL,NULL,NULL,'openfireHost','即时通讯服务器IP地址','192.168.1.3','textbox'),(7,1,NULL,NULL,NULL,NULL,'openfirePort','即时通讯服务器端口','5222','textbox'),(8,1,NULL,NULL,NULL,NULL,'openfireUsername','默认帐号','system','textbox'),(9,1,NULL,NULL,NULL,NULL,'openfirePassword','默认密码','123456','password'),(10,1,NULL,1,'2012-01-12 19:58:02',NULL,'openfireAdmin','管理员帐号','admin','textbox'),(11,1,NULL,1,'2013-06-08 10:39:21',NULL,'mail.smtp.host','SMTP邮件服务器IP地址','smtp.qq.com','textbox'),(12,1,NULL,1,'2013-06-08 10:39:42',NULL,'mail.smtp.port','SMTP邮件服务端口','25','textbox'),(13,1,NULL,1,'2013-06-08 12:41:24',NULL,'mail.smtp.auth','SMTP邮件服务器是否需要验证','Y','radio'),(14,1,NULL,1,'2013-06-08 10:40:08',NULL,'mail.smtp.user','默认邮件帐号','914261631@qq.com','textbox'),(15,1,NULL,1,'2013-06-08 10:38:53',NULL,'mail.smtp.address','默认邮件地址','914261631@qq.com','textbox'),(16,1,NULL,10,'2013-06-18 11:16:51',NULL,'mail.smtp.password','默认密码','Dai1121*#','password'),(17,1,NULL,NULL,NULL,NULL,'sms.model','短信猫型号','wmod2','textbox'),(18,1,NULL,NULL,NULL,NULL,'sms.comport','短信猫端口','COM1','textbox'),(19,1,NULL,NULL,NULL,NULL,'sms.baudrate','COM口速率','9600','textbox'),(20,1,NULL,NULL,NULL,NULL,'sms.manufacturer','短信猫制造商','wavecom','textbox'),(21,1,NULL,1,'2012-04-02 16:56:29',NULL,'mail.smtp.displayname','邮件默认帐号显示名称','minioa','textbox'),(22,1,NULL,NULL,NULL,NULL,'defaultPassword','默认密码','123456','textbox'),(23,NULL,NULL,NULL,NULL,NULL,'EnableEmailServer','N',NULL,'radio');
/*!40000 ALTER TABLE `core_prop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_form_view_field`
--

DROP TABLE IF EXISTS `core_form_view_field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_form_view_field` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `viewId` int(11) DEFAULT '0',
  `fieldId` int(11) DEFAULT '0',
  `isShow` char(1) DEFAULT 'N',
  `canEdit` char(1) DEFAULT 'N',
  `tableOrEdit` char(1) DEFAULT NULL,
  `displayWidth` varchar(45) DEFAULT NULL,
  `textAlign` varchar(45) DEFAULT NULL,
  `inputTextBoxSize` int(11) DEFAULT NULL,
  `inputType` varchar(45) DEFAULT NULL,
  `required` varchar(45) DEFAULT NULL,
  `enabledSearch` char(1) DEFAULT 'N',
  `spacer` int(11) DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_form_view_field`
--

LOCK TABLES `core_form_view_field` WRITE;
/*!40000 ALTER TABLE `core_form_view_field` DISABLE KEYS */;
INSERT INTO `core_form_view_field` VALUES (1,NULL,NULL,NULL,NULL,NULL,1,35,'Y','Y','0','10%','center',NULL,NULL,NULL,'Y',0),(2,NULL,NULL,NULL,NULL,NULL,1,39,'Y','N','0','*','left',NULL,NULL,NULL,'Y',0),(3,NULL,NULL,NULL,NULL,NULL,1,37,'Y','N','0','10%','center',NULL,NULL,NULL,'N',0),(4,NULL,NULL,NULL,NULL,NULL,1,38,'Y','Y','0','10%','center',NULL,NULL,NULL,'N',0),(5,NULL,NULL,NULL,NULL,NULL,1,40,'Y','Y','0','10%','center',NULL,NULL,NULL,'N',0),(6,NULL,NULL,NULL,NULL,NULL,1,35,'N','Y','1',NULL,NULL,60,'text','false','N',0),(7,NULL,NULL,NULL,NULL,NULL,1,39,'Y','Y','1',NULL,NULL,5,'textarea','false','N',0),(8,NULL,NULL,NULL,NULL,NULL,1,37,'N','Y','1',NULL,NULL,0,'null','false','N',0),(9,NULL,NULL,NULL,NULL,NULL,1,38,'Y','Y','1',NULL,NULL,0,'null','false','N',0),(10,NULL,NULL,NULL,NULL,NULL,1,40,'N','Y','1',NULL,NULL,12,'select','false','N',0),(11,NULL,NULL,NULL,NULL,NULL,2,35,'Y','N','0','5%','left',NULL,NULL,NULL,'N',0),(12,NULL,NULL,NULL,NULL,NULL,2,39,'Y','N','0','*','left',NULL,NULL,NULL,'N',0),(13,NULL,NULL,NULL,NULL,NULL,2,37,'Y','N','0','10%','left',NULL,NULL,NULL,'N',0),(14,NULL,NULL,NULL,NULL,NULL,2,38,'Y','N','0','10%','left',NULL,NULL,NULL,'N',0),(15,NULL,NULL,NULL,NULL,NULL,2,40,'Y','N','0','10%','left',NULL,NULL,NULL,'N',0),(16,NULL,NULL,NULL,NULL,NULL,2,35,'Y','N','1',NULL,NULL,1,'text','false','N',0),(17,NULL,NULL,NULL,NULL,NULL,2,39,'Y','N','1',NULL,NULL,0,'null','false','N',0),(18,NULL,NULL,NULL,NULL,NULL,2,37,'Y','N','1',NULL,NULL,0,'null','false','N',0),(19,NULL,NULL,NULL,NULL,NULL,2,38,'Y','N','1',NULL,NULL,0,'null','false','N',0),(20,NULL,NULL,NULL,NULL,NULL,2,40,'Y','N','1',NULL,NULL,0,'null','false','N',0),(49,NULL,NULL,NULL,NULL,NULL,5,41,'Y','N','0','20%','left',NULL,NULL,NULL,'Y',0),(50,NULL,NULL,NULL,NULL,NULL,5,42,'Y','N','0','30%','left',NULL,NULL,NULL,'Y',0),(57,NULL,NULL,NULL,NULL,NULL,5,41,'N','Y','1',NULL,NULL,30,'text','true','N',0),(58,NULL,NULL,NULL,NULL,NULL,5,42,'N','Y','1',NULL,NULL,60,'text','false','N',0),(59,NULL,NULL,NULL,NULL,NULL,6,43,'Y','N','0','*','center',NULL,NULL,NULL,'Y',0),(60,NULL,NULL,NULL,NULL,NULL,6,44,'Y','N','0','30%','right',NULL,NULL,NULL,'N',0),(61,NULL,NULL,NULL,NULL,NULL,6,45,'Y','N','0','30%','right',NULL,NULL,NULL,'N',0),(62,NULL,NULL,NULL,NULL,NULL,6,44,'N','Y','1',NULL,NULL,3,'text','true','N',0),(63,NULL,NULL,NULL,NULL,NULL,6,45,'N','Y','1',NULL,NULL,3,'text','true','N',0),(64,NULL,NULL,NULL,NULL,NULL,6,43,'N','Y','1',NULL,NULL,30,'null','true','N',0),(65,NULL,NULL,NULL,NULL,NULL,3,35,'N','N','0','5%','left',NULL,NULL,NULL,'N',0),(66,NULL,NULL,NULL,NULL,NULL,3,39,'Y','N','0','5%','left',NULL,NULL,NULL,'N',0),(67,NULL,NULL,NULL,NULL,NULL,3,37,'Y','N','0','5%','left',NULL,NULL,NULL,'N',0),(68,NULL,NULL,NULL,NULL,NULL,3,38,'Y','N','0','5%','left',NULL,NULL,NULL,'N',0),(69,NULL,NULL,NULL,NULL,NULL,3,40,'Y','N','0','5%','left',NULL,NULL,NULL,'N',0),(70,NULL,NULL,NULL,NULL,NULL,4,35,'Y','N','0','*','left',NULL,NULL,NULL,'N',0),(71,NULL,NULL,NULL,NULL,NULL,4,39,'Y','N','0','20%','left',NULL,NULL,NULL,'N',0),(72,NULL,NULL,NULL,NULL,NULL,4,37,'Y','N','0','10%','left',NULL,NULL,NULL,'N',0),(73,NULL,NULL,NULL,NULL,NULL,4,38,'Y','N','0','10%','left',NULL,NULL,NULL,'N',0),(74,NULL,NULL,NULL,NULL,NULL,4,40,'Y','N','0','5%','left',NULL,NULL,NULL,'N',0),(75,NULL,NULL,NULL,NULL,NULL,8,46,'Y','N','0','5%','left',NULL,NULL,NULL,'N',0),(76,NULL,NULL,NULL,NULL,NULL,8,46,'N','Y','1',NULL,NULL,22,'text','false','N',0),(77,NULL,NULL,NULL,NULL,NULL,9,48,'Y','N','0','10%','left',NULL,NULL,NULL,'Y',0),(78,NULL,NULL,NULL,NULL,NULL,9,50,'Y','N','0','5%','right',NULL,NULL,NULL,'N',0),(79,NULL,NULL,NULL,NULL,NULL,9,49,'Y','N','0','*','left',NULL,NULL,NULL,'N',0),(80,NULL,NULL,NULL,NULL,NULL,9,47,'Y','N','0','5%','left',NULL,NULL,NULL,'Y',0),(81,NULL,NULL,NULL,NULL,NULL,9,47,'N','Y','1',NULL,NULL,30,'text','false','N',0),(82,NULL,NULL,NULL,NULL,NULL,9,48,'N','Y','1',NULL,NULL,30,'text','false','N',0),(83,NULL,NULL,NULL,NULL,NULL,9,50,'N','Y','1',NULL,NULL,0,'text','false','N',0),(84,NULL,NULL,NULL,NULL,NULL,9,49,'N','Y','1',NULL,NULL,8,'textarea','false','N',0),(85,NULL,NULL,NULL,NULL,NULL,10,47,'N','N','1',NULL,NULL,0,'text','false','N',0),(86,NULL,NULL,NULL,NULL,NULL,10,48,'N','N','1',NULL,NULL,0,'text','false','N',0),(87,NULL,NULL,NULL,NULL,NULL,10,50,'N','N','1',NULL,NULL,0,'text','false','N',0),(88,NULL,NULL,NULL,NULL,NULL,10,49,'N','N','1',NULL,NULL,0,'text','false','N',0),(89,NULL,NULL,NULL,NULL,NULL,11,59,'N','N','1',NULL,NULL,0,'text','false','N',0),(90,NULL,NULL,NULL,NULL,NULL,11,60,'N','N','1',NULL,NULL,0,'text','false','N',0),(91,NULL,NULL,NULL,NULL,NULL,11,62,'N','N','1',NULL,NULL,0,'text','false','N',0);
/*!40000 ALTER TABLE `core_form_view_field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_processdefinition`
--

DROP TABLE IF EXISTS `core_processdefinition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_processdefinition` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `processName` varchar(45) DEFAULT NULL,
  `processImage` varchar(200) DEFAULT NULL,
  `sqlWhenCreate` varchar(200) DEFAULT NULL,
  `sqlWhenDelete` varchar(200) DEFAULT NULL,
  `sqlWhenAgree` varchar(200) DEFAULT NULL,
  `sqlWhenReject` varchar(200) DEFAULT NULL,
  `formId` int(11) DEFAULT '0',
  `processDesc` varchar(200) DEFAULT NULL,
  `isPublish` char(1) DEFAULT 'N',
  `notice` varchar(200) DEFAULT NULL,
  `processImageThum` varchar(200) DEFAULT NULL,
  `formViewId` int(10) DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_processdefinition`
--

LOCK TABLES `core_processdefinition` WRITE;
/*!40000 ALTER TABLE `core_processdefinition` DISABLE KEYS */;
INSERT INTO `core_processdefinition` VALUES (1,0,NULL,1,'2013-07-23 17:30:53',NULL,'会议室申请','upload/processImages/1b0147d9-b4b7-4fa4-b947-df8c713ad997.jpg','update core_form_main set isarc=\'r\' where id_ = :instanceid','update core_form_main set isarc=\'n\' where id_ = :instanceid','update core_form_main set isarc=\'y\' where id_ = :instanceid','update core_form_main set isarc=\'n\' where id_ = :instanceid',11,'会议名称','N','流程正在维护中，请稍后或直接联系管理员','upload/processImages/1b0147d9-b4b7-4fa4-b947-df8c713ad997_thum.jpg',3),(2,1,'2013-05-23 00:00:00',10,'2013-06-08 13:04:31',NULL,'办公家具申请','','','','','',15,'家具分类','Y','','',10),(3,17,'2013-06-19 00:00:00',1,'2013-06-23 12:19:28',NULL,'请假申请','upload/processImages/432550d5-319d-4f17-a93c-f8709e98935c.jpg','','','','',17,'请假申请','Y','请假','upload/processImages/432550d5-319d-4f17-a93c-f8709e98935c_thum.jpg',0),(4,1,'2013-06-23 11:28:08',0,NULL,NULL,'文具申请','','','','','',16,'文具申请','Y','文具申请','',0);
/*!40000 ALTER TABLE `core_processdefinition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofextcomponentconf`
--

DROP TABLE IF EXISTS `ofextcomponentconf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofextcomponentconf` (
  `subdomain` varchar(255) NOT NULL,
  `wildcard` tinyint(4) NOT NULL,
  `secret` varchar(255) DEFAULT NULL,
  `permission` varchar(10) NOT NULL,
  PRIMARY KEY (`subdomain`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofextcomponentconf`
--

LOCK TABLES `ofextcomponentconf` WRITE;
/*!40000 ALTER TABLE `ofextcomponentconf` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofextcomponentconf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofrostergroups`
--

DROP TABLE IF EXISTS `ofrostergroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofrostergroups` (
  `rosterID` bigint(20) NOT NULL,
  `rank` tinyint(4) NOT NULL,
  `groupName` varchar(255) NOT NULL,
  PRIMARY KEY (`rosterID`,`rank`),
  KEY `ofRosterGroup_rosterid_idx` (`rosterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofrostergroups`
--

LOCK TABLES `ofrostergroups` WRITE;
/*!40000 ALTER TABLE `ofrostergroups` DISABLE KEYS */;
INSERT INTO `ofrostergroups` VALUES (1,0,'精准软件-市场部-海外市场部'),(2,0,'精准软件-人事行政部'),(3,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(4,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(5,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(6,0,'精准软件-市场部-海外市场部'),(7,0,'精准软件-人事行政部'),(8,0,'西柏网络-财务部-会计部1'),(9,0,'西柏网络-财务部-会计部1'),(10,0,'西柏网络-财务部-会计部1'),(11,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(12,0,'精准软件-市场部-海外市场部'),(13,0,'西柏网络-财务部-会计部1'),(14,0,'精准软件-人事行政部'),(18,0,'精准软件-战略投资部'),(19,0,'精准软件-战略投资部'),(20,0,'精准软件-战略投资部'),(21,0,'精准软件-战略投资部'),(22,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(23,0,'精准软件-市场部-海外市场部'),(24,0,'西柏网络-财务部-会计部1'),(25,0,'精准软件-战略投资部'),(26,0,'精准软件-人事行政部'),(29,0,'精准软件-技术部'),(30,0,'精准软件-技术部'),(31,0,'精准软件-技术部'),(32,0,'精准软件-技术部'),(33,0,'精准软件-技术部'),(34,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(35,0,'精准软件-市场部-海外市场部'),(36,0,'西柏网络-财务部-会计部1'),(37,0,'精准软件-战略投资部'),(38,0,'精准软件-技术部'),(39,0,'精准软件-人事行政部'),(41,0,'精准软件-市场部-海外市场部'),(42,0,'西柏网络-质控部'),(43,0,'西柏网络-质控部'),(44,0,'西柏网络-质控部'),(45,0,'西柏网络-质控部'),(46,0,'西柏网络-质控部'),(47,0,'西柏网络-质控部'),(48,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(49,0,'精准软件-市场部-海外市场部'),(50,0,'西柏网络-财务部-会计部1'),(51,0,'精准软件-战略投资部'),(52,0,'西柏网络-质控部'),(53,0,'精准软件-技术部'),(54,0,'精准软件-人事行政部'),(55,0,'中国石油-三炮部队'),(56,0,'中国石油-三炮部队'),(57,0,'中国石油-三炮部队'),(58,0,'中国石油-三炮部队'),(59,0,'中国石油-三炮部队'),(60,0,'中国石油-三炮部队'),(61,0,'中国石油-三炮部队'),(62,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(63,0,'精准软件-市场部-海外市场部'),(64,0,'西柏网络-财务部-会计部1'),(65,0,'精准软件-战略投资部'),(66,0,'西柏网络-质控部'),(67,0,'精准软件-技术部'),(68,0,'精准软件-人事行政部'),(69,0,'中国石油-三炮部队'),(77,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(100,0,'西柏网络-生产部-交换机生产线'),(101,0,'西柏网络-生产部-交换机生产线'),(102,0,'西柏网络-生产部-交换机生产线'),(104,0,'西柏网络-生产部-交换机生产线'),(105,0,'西柏网络-生产部-交换机生产线'),(106,0,'西柏网络-生产部-交换机生产线'),(107,0,'西柏网络-生产部-交换机生产线'),(108,0,'西柏网络-生产部-交换机生产线'),(109,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(110,0,'精准软件-市场部-海外市场部'),(111,0,'西柏网络-财务部-会计部1'),(112,0,'精准软件-战略投资部'),(114,0,'西柏网络-生产部-交换机生产线'),(115,0,'西柏网络-质控部'),(116,0,'精准软件-技术部'),(117,0,'精准软件-人事行政部'),(118,0,'中国石油-三炮部队'),(119,0,'精准软件-市场部-海外市场部'),(120,0,'西柏网络-战略投资部'),(121,0,'精准软件-技术部'),(122,0,'西柏网络-技术部'),(123,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(124,0,'西柏网络-人事行政部'),(125,0,'精准软件-人事行政部'),(126,0,'西柏网络-人事行政部'),(127,0,'精准软件-人事行政部'),(128,0,'精准软件-战略投资部'),(129,0,'西柏网络-战略投资部'),(130,0,'西柏网络-生产部-交换机生产线'),(131,0,'西柏网络-生产部-交换机生产线'),(132,0,'西柏网络-质控部'),(133,0,'西柏网络-质控部'),(134,0,'西柏网络-财务部-会计部1'),(135,0,'西柏网络-财务部-会计部1'),(136,0,'中国石油-三炮部队'),(137,0,'中国石油-三炮部队'),(138,0,'西柏网络-财务部-会计部1'),(139,0,'西柏网络-财务部-会计部1'),(140,0,'西柏网络-财务部-会计部1'),(142,0,'西柏网络-财务部-会计部1'),(143,0,'西柏网络-财务部-会计部1'),(144,0,'西柏网络-财务部-会计部1'),(145,0,'西柏网络-财务部-会计部1'),(146,0,'西柏网络-财务部-会计部1'),(147,0,'西柏网络-财务部-会计部1'),(148,0,'西柏网络-财务部-会计部1'),(149,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(150,0,'精准软件-市场部-海外市场部'),(151,0,'西柏网络-财务部-会计部1'),(152,0,'精准软件-战略投资部'),(154,0,'西柏网络-生产部-交换机生产线'),(155,0,'西柏网络-质控部'),(156,0,'精准软件-技术部'),(157,0,'西柏网络-技术部'),(158,0,'西柏网络-财务部-会计部1'),(159,0,'精准软件-人事行政部'),(160,0,'中国石油-三炮部队'),(161,0,'精准软件-战略投资部'),(162,0,'精准软件-战略投资部'),(163,0,'精准软件-战略投资部'),(165,0,'精准软件-战略投资部'),(166,0,'精准软件-战略投资部'),(167,0,'精准软件-战略投资部'),(168,0,'精准软件-战略投资部'),(169,0,'精准软件-战略投资部'),(170,0,'精准软件-战略投资部'),(171,0,'精准软件-战略投资部'),(172,0,'精准软件-战略投资部'),(203,0,'精准软件-财务部'),(204,0,'精准软件-财务部'),(205,0,'精准软件-财务部'),(208,0,'精准软件-财务部'),(209,0,'精准软件-财务部'),(210,0,'精准软件-财务部'),(211,0,'精准软件-财务部'),(212,0,'精准软件-财务部'),(213,0,'精准软件-财务部'),(214,0,'精准软件-财务部'),(215,0,'精准软件-财务部'),(216,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(217,0,'精准软件-市场部-海外市场部'),(218,0,'精准软件-财务部-会计部1'),(219,0,'精准软件-战略投资部'),(221,0,'精准软件-战略投资部'),(222,0,'精准软件-财务部'),(223,0,'精准软件-生产部-交换机生产线'),(224,0,'精准软件-质控部'),(225,0,'精准软件-技术部'),(226,0,'精准软件-技术部'),(227,0,'精准软件-财务部-会计部1'),(228,0,'精准软件-人事行政部'),(229,0,'中国石油-三炮部队'),(231,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(232,0,'精准软件-市场部-海外市场部'),(233,0,'精准软件-财务部-会计部1'),(234,0,'精准软件-战略投资部'),(236,0,'精准软件-战略投资部'),(237,0,'精准软件-信息中心'),(238,0,'精准软件-生产部-交换机生产线'),(239,0,'精准软件-质控部'),(240,0,'精准软件-技术部'),(241,0,'精准软件-技术部'),(242,0,'精准软件-财务部-会计部1'),(243,0,'精准软件-人事行政部'),(244,0,'中国石油-三炮部队'),(246,0,'精准软件-市场部-人事行政部'),(247,0,'精准软件-市场部-人事行政部'),(248,0,'精准软件-市场部-人事行政部'),(249,0,'精准软件-市场部-人事行政部'),(250,0,'精准软件-市场部-人事行政部'),(251,0,'精准软件-市场部-人事行政部'),(252,0,'精准软件-市场部-人事行政部'),(253,0,'精准软件-市场部-人事行政部'),(254,0,'精准软件-市场部-人事行政部'),(255,0,'精准软件-市场部-人事行政部'),(256,0,'精准软件-市场部-人事行政部'),(257,0,'精准软件-市场部-人事行政部'),(258,0,'精准软件-市场部-人事行政部'),(259,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-财务部'),(260,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部-海外市场部'),(261,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-财务部-会计部1'),(262,0,'精准软件-战略投资部'),(263,0,'精准软件-战略投资部'),(264,0,'精准软件-战略投资部'),(265,0,'精准软件-生产部-交换机生产线'),(266,0,'精准软件-市场部-人事行政部'),(267,0,'精准软件-质控部'),(268,0,'精准软件-技术部'),(269,0,'精准软件-技术部'),(270,0,'精准软件-海外市场部-海外市场部-海外市场部-海外市场部-财务部-会计部1'),(271,0,'精准软件-市场部-人事行政部'),(272,0,'中国石油-三炮部队');
/*!40000 ALTER TABLE `ofrostergroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_form_main_attachment`
--

DROP TABLE IF EXISTS `core_form_main_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_form_main_attachment` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `filename` varchar(200) DEFAULT NULL,
  `filetype` varchar(45) DEFAULT NULL,
  `filesize` int(10) unsigned DEFAULT '0',
  `oldname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_form_main_attachment`
--

LOCK TABLES `core_form_main_attachment` WRITE;
/*!40000 ALTER TABLE `core_form_main_attachment` DISABLE KEYS */;
INSERT INTO `core_form_main_attachment` VALUES (6,1,'2012-10-21 21:42:22',NULL,NULL,'722494cd-73ce-472e-bba9-39aead49f221','upload\\formmain\\12\\d667628d-254c-4c6f-bb6a-c8c2a24fd56d.png','.png',81943,'a4jlog.png'),(7,1,'2012-11-07 20:36:20',NULL,NULL,'722494cd-73ce-472e-bba9-39aead49f221','upload\\formmain\\12\\86b03e6c-ecf9-470e-92e9-ff05bdf3b10d.pdf','.pdf',153660,'test.pdf'),(8,1,'2013-05-21 09:47:41',NULL,NULL,'845fdd86-3034-4dfc-8f96-53b2f2d367fe','upload\\formmain\\12\\759c1c52-3e62-4e11-ac30-d9d132891fc0.jpg','.jpg',503466,'c53cd3fcc9d1f068fc037f86.jpg'),(9,1,'2013-05-21 09:48:02',NULL,NULL,'845fdd86-3034-4dfc-8f96-53b2f2d367fe','upload\\formmain\\12\\020f2378-75cf-41fb-bee8-22fd091ec25a.jpg','.jpg',13895,'1339147661746.jpg'),(10,10,'2013-06-08 14:55:41',NULL,NULL,'18662357-1cc1-4b1d-a185-e0e66acdece8','upload\\formmain\\15\\73135d78-0e98-4e33-93c4-836ddd93dd93.jpg','.jpg',58423,'p5.jpg'),(12,10,'2013-07-09 21:26:18',NULL,NULL,'542dcd09-a40e-4b0d-b1c9-fc33a649c104','upload\\formmain\\12\\3d3b142d-7367-433c-aa0d-66788e55dd3f.exe','.exe',514560,'MiniOAFormCoder.exe'),(13,10,'2013-07-09 21:32:08',NULL,NULL,'542dcd09-a40e-4b0d-b1c9-fc33a649c104','upload\\formmain\\12\\8fa38a94-fce4-425d-8b60-2ec92be872e2.dll','.dll',357888,'MySql.Data.dll'),(14,10,'2013-07-09 21:32:18',NULL,NULL,'542dcd09-a40e-4b0d-b1c9-fc33a649c104','upload\\formmain\\12\\7453777d-634f-4ed0-ba17-9afe023ddc6a.dll','.dll',4812800,'DevComponents.DotNetBar2.dll'),(15,10,'2013-07-09 21:32:26',NULL,NULL,'542dcd09-a40e-4b0d-b1c9-fc33a649c104','upload\\formmain\\12\\f6983384-45a7-40a2-9dac-9137bd627a85.xml','.xml',3923263,'DevComponents.DotNetBar2.xml'),(16,1,'2013-07-13 16:23:22',NULL,NULL,'958f9323-5501-42da-ac8a-94c1d7bfeef1','upload\\formmain\\11\\78f69137-84e7-4ccc-a274-9784213446e0.properties','.properties',121,'.myeclipse.properties'),(17,1,'2013-07-21 17:42:02',NULL,NULL,'99390e69-3089-4c87-8ddb-72966f0805c9','upload\\formmain\\12\\58ad3c13-2d09-4e20-abea-e0079d08c02f.xlsx','.xlsx',29020,'发货清单.xlsx'),(19,1,'2013-07-21 17:42:44',NULL,NULL,'31d34906-cadc-4f3b-a43e-1931448a8e95','upload\\formmain\\12\\c544d6d4-4771-41a0-ae2b-a8e5a91f0f4a.xlsx','.xlsx',29020,'发货清单.xlsx'),(22,1,'2013-08-09 08:06:15',NULL,NULL,'ec74bfe9-6786-43b9-afdd-654bf49ee482','upload\\formmain\\11\\8fc455b7-ae1f-4ca9-9064-76e6815c6911.txt','.txt',20541,'minioa修改日志.txt'),(23,1,'2013-08-26 15:36:37',NULL,NULL,'d9979745-1b35-469c-af9e-8b4cf42485db','upload\\formmain\\11\\f30983fd-f904-4b88-b8ad-08acb59aa33c.jpg','.jpg',80784,'T2hmoFXi4XXXXXXXXX_!!729965834.jpg');
/*!40000 ALTER TABLE `core_form_main_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofremoteserverconf`
--

DROP TABLE IF EXISTS `ofremoteserverconf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofremoteserverconf` (
  `xmppDomain` varchar(255) NOT NULL,
  `remotePort` int(11) DEFAULT NULL,
  `permission` varchar(10) NOT NULL,
  PRIMARY KEY (`xmppDomain`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofremoteserverconf`
--

LOCK TABLES `ofremoteserverconf` WRITE;
/*!40000 ALTER TABLE `ofremoteserverconf` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofremoteserverconf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofproperty`
--

DROP TABLE IF EXISTS `ofproperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofproperty` (
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofproperty`
--

LOCK TABLES `ofproperty` WRITE;
/*!40000 ALTER TABLE `ofproperty` DISABLE KEYS */;
INSERT INTO `ofproperty` VALUES ('passwordKey','r02851SotjG4n01'),('provider.admin.className','org.jivesoftware.openfire.admin.DefaultAdminProvider'),('provider.auth.className','org.jivesoftware.openfire.auth.DefaultAuthProvider'),('provider.group.className','org.jivesoftware.openfire.group.DefaultGroupProvider'),('provider.lockout.className','org.jivesoftware.openfire.lockout.DefaultLockOutProvider'),('provider.securityAudit.className','org.jivesoftware.openfire.security.DefaultSecurityAuditProvider'),('provider.user.className','org.jivesoftware.openfire.user.DefaultUserProvider'),('provider.vcard.className','org.jivesoftware.openfire.vcard.DefaultVCardProvider'),('update.lastCheck','1323480276031'),('xmpp.auth.anonymous','true'),('xmpp.domain','minioa'),('xmpp.session.conflict-limit','0'),('xmpp.socket.ssl.active','true');
/*!40000 ALTER TABLE `ofproperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_process`
--

DROP TABLE IF EXISTS `core_process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_process` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `processDefId` int(10) unsigned DEFAULT '0',
  `instanceId` int(10) unsigned DEFAULT '0',
  `processDesc` varchar(100) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `processStatus` varchar(45) DEFAULT NULL,
  `jobId` int(10) unsigned DEFAULT '0',
  `processNote` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ID__UNIQUE` (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_process`
--

LOCK TABLES `core_process` WRITE;
/*!40000 ALTER TABLE `core_process` DISABLE KEYS */;
INSERT INTO `core_process` VALUES (24,10,'2012-02-01 20:00:06',10,'2012-10-10 21:04:16','3229f71d-c640-4fba-96c5-76f72533a7a2',1,4,'ccccc','2012-02-01 20:00:06','2012-10-10 21:04:16','agree',10,NULL),(25,1,'2012-10-12 18:54:30',1,'2012-10-12 18:54:39','908739f8-1507-483b-a252-1f2e8f86e55b',1,5,'测试附件','2012-10-12 18:54:30','2012-10-12 18:54:39','agree',14,NULL),(26,1,'2012-10-12 19:23:31',1,'2012-10-12 19:46:30','e7eca3d3-4cd1-462d-a00f-bc6f007da571',1,5,'测试附件','2012-10-12 19:23:31','2012-10-12 19:46:30','agree',14,NULL),(31,1,'2013-05-23 16:37:34',1,'2013-05-23 16:37:45','0211c5f6-1ecd-4be3-ae50-9078044d367d',1,4,'','2013-05-23 16:37:34','2013-05-23 16:37:45','reject',14,NULL),(34,10,'2013-06-05 19:43:38',10,'2013-06-05 20:05:02','be4543fc-a42e-4eae-be06-831fe3034fa3',2,18,'桌子','2013-06-05 19:43:38','2013-06-05 20:05:02','agree',8,NULL),(35,1,'2013-06-18 11:19:47',10,'2013-06-18 11:20:08','b5e56761-da90-4c2f-8093-e3d4f67705b7',2,19,'桌子','2013-06-18 11:19:47','2013-06-18 11:20:08','agree',14,NULL),(38,10,'2013-06-23 11:33:49',NULL,NULL,'afd9c10d-f085-4eec-8726-0b82a9c6723e',3,13,'','2013-06-23 11:33:49',NULL,'running',8,NULL),(43,1,'2013-07-31 11:42:57',NULL,NULL,'ced52540-2c24-4278-ada4-b627a1a67ebc',2,19,'桌子','2013-07-31 11:42:57',NULL,'running',12,'再启动'),(54,10,'2013-08-14 21:31:36',NULL,NULL,'4f134b07-6b0e-4199-9361-2f9fdca48d14',1,32,'今天开会','2013-08-14 21:31:36',NULL,'running',8,'滚滚滚滚滚fggfdg'),(56,1,'2013-08-27 15:23:40',NULL,NULL,'4f680723-61d0-43d4-94ef-bbe35eb44d04',2,20,'椅子','2013-08-27 15:23:40',NULL,'running',12,'222'),(57,1,'2013-08-27 17:15:26',NULL,NULL,'1c0e2853-c15f-4edf-8819-723536859980',1,33,'党会','2013-08-27 17:15:26',NULL,'running',12,''),(58,1,'2013-08-28 10:28:56',NULL,NULL,'8dca65cc-9d06-40dc-9f9e-1ce5ee5e232a',1,11,'2012年年终总结大会','2013-08-28 10:28:56',NULL,'running',12,''),(59,10,'2013-09-01 18:23:41',NULL,NULL,'1ff8b921-e1bc-4b9e-87de-597a4cf5154b',1,35,'test','2013-09-01 18:23:41',NULL,'running',8,'dadad'),(60,1,'2013-09-02 20:15:36',NULL,NULL,'d512a5e6-7899-48e3-99e3-d8f9d224f498',1,36,'新生会议','2013-09-02 20:15:36',NULL,'running',12,''),(61,1,'2013-09-02 20:18:27',NULL,NULL,'d17a702a-83a8-4394-b7ea-ed75d6045fc0',1,37,'2013会议','2013-09-02 20:18:27',NULL,'running',12,''),(62,1,'2013-09-03 20:56:04',NULL,NULL,'b6711cfe-bd41-4022-8394-9049d439edb1',1,38,'1','2013-09-03 20:56:04',NULL,'running',12,'');
/*!40000 ALTER TABLE `core_process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_coder_field`
--

DROP TABLE IF EXISTS `core_coder_field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_coder_field` (
  `ID_` int(11) NOT NULL AUTO_INCREMENT,
  `tableName` varchar(45) DEFAULT NULL,
  `fieldName` varchar(450) DEFAULT NULL,
  `fieldText` varchar(450) DEFAULT NULL,
  `fieldType` varchar(450) DEFAULT NULL,
  `fieldWidth` varchar(450) DEFAULT NULL,
  `fieldData` varchar(450) DEFAULT NULL,
  `fieldDataSource` varchar(450) DEFAULT NULL,
  `fieldValidation` varchar(450) DEFAULT NULL,
  `validationText` varchar(450) DEFAULT NULL,
  `fieldInputType` varchar(450) DEFAULT NULL,
  `defaultValue` varchar(450) DEFAULT NULL,
  `searchFlag` char(5) DEFAULT 'False',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_coder_field`
--

LOCK TABLES `core_coder_field` WRITE;
/*!40000 ALTER TABLE `core_coder_field` DISABLE KEYS */;
INSERT INTO `core_coder_field` VALUES (1,'eq_test','itemname','物料名称','字符型','45','','','','','','',''),(2,'eq_test','itemcode','物料编码','字符型','45','','','','','','',''),(3,'eq_test','quantity','数量','两位小数','','','','','','','','');
/*!40000 ALTER TABLE `core_coder_field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofmucroom`
--

DROP TABLE IF EXISTS `ofmucroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofmucroom` (
  `serviceID` bigint(20) NOT NULL,
  `roomID` bigint(20) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `modificationDate` char(15) NOT NULL,
  `name` varchar(50) NOT NULL,
  `naturalName` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `lockedDate` char(15) NOT NULL,
  `emptyDate` char(15) DEFAULT NULL,
  `canChangeSubject` tinyint(4) NOT NULL,
  `maxUsers` int(11) NOT NULL,
  `publicRoom` tinyint(4) NOT NULL,
  `moderated` tinyint(4) NOT NULL,
  `membersOnly` tinyint(4) NOT NULL,
  `canInvite` tinyint(4) NOT NULL,
  `roomPassword` varchar(50) DEFAULT NULL,
  `canDiscoverJID` tinyint(4) NOT NULL,
  `logEnabled` tinyint(4) NOT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `rolesToBroadcast` tinyint(4) NOT NULL,
  `useReservedNick` tinyint(4) NOT NULL,
  `canChangeNick` tinyint(4) NOT NULL,
  `canRegister` tinyint(4) NOT NULL,
  PRIMARY KEY (`serviceID`,`name`),
  KEY `ofMucRoom_roomid_idx` (`roomID`),
  KEY `ofMucRoom_serviceid_idx` (`serviceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofmucroom`
--

LOCK TABLES `ofmucroom` WRITE;
/*!40000 ALTER TABLE `ofmucroom` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofmucroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_op_role_relation`
--

DROP TABLE IF EXISTS `core_op_role_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_op_role_relation` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `opId` int(10) unsigned DEFAULT NULL,
  `roleId` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_op_role_relation`
--

LOCK TABLES `core_op_role_relation` WRITE;
/*!40000 ALTER TABLE `core_op_role_relation` DISABLE KEYS */;
INSERT INTO `core_op_role_relation` VALUES (3,0,'2011-09-04 18:28:49',3,1),(4,0,'2011-09-04 18:28:49',4,1),(5,0,'2011-09-04 18:28:49',5,1),(6,0,'2011-09-04 18:28:49',6,1),(7,0,'2011-09-04 18:28:49',7,1),(8,0,'2011-09-04 18:28:49',8,1),(9,0,'2011-09-04 18:28:49',9,1),(10,0,'2011-09-04 18:28:49',10,1),(11,0,'2011-09-04 18:28:49',11,1),(12,0,'2011-09-04 18:28:49',12,1),(13,0,'2011-09-05 21:50:39',1,1),(14,0,'2011-09-05 21:50:39',2,1),(15,0,'2011-09-09 07:47:44',13,1),(16,0,'2011-10-12 18:59:31',14,1),(17,0,'2011-10-12 18:59:31',15,1),(18,0,'2011-10-12 18:59:31',17,1),(19,0,'2011-10-12 18:59:31',16,1),(20,0,'2011-10-12 18:59:31',19,1),(21,0,'2011-10-12 18:59:31',18,1),(22,0,'2011-10-12 18:59:31',21,1),(23,0,'2011-10-12 18:59:31',20,1),(24,0,'2011-10-12 18:59:31',23,1),(25,0,'2011-10-12 18:59:31',22,1),(26,0,'2011-10-12 19:24:58',24,1),(35,0,'2011-11-04 19:15:34',25,1),(36,0,'2011-11-04 19:15:34',26,1),(40,0,'2011-12-20 20:53:43',29,1),(41,0,'2011-12-20 20:53:43',28,1),(43,0,'2011-12-20 20:53:43',32,1),(47,0,'2011-12-23 13:52:03',33,1),(48,0,'2012-01-02 19:53:26',34,1),(58,0,'2012-01-12 21:05:06',1,4),(59,0,'2012-01-12 21:05:06',2,4),(60,0,'2012-01-12 21:05:06',3,4),(61,0,'2012-01-12 21:05:06',4,4),(62,0,'2012-01-12 21:05:06',5,4),(63,0,'2012-01-12 21:05:06',6,4),(64,0,'2012-01-12 21:05:06',7,4),(65,0,'2012-01-12 21:05:06',8,4),(66,0,'2012-01-12 21:05:06',9,4),(67,0,'2012-01-12 21:05:06',10,4),(68,0,'2012-01-12 21:05:06',11,4),(69,0,'2012-01-12 21:05:06',12,4),(70,0,'2012-01-12 21:05:06',13,4),(71,0,'2012-01-12 21:05:06',14,4),(72,0,'2012-01-12 21:05:06',15,4),(73,0,'2012-01-12 21:05:06',17,4),(74,0,'2012-01-12 21:05:06',16,4),(75,0,'2012-01-12 21:05:06',19,4),(76,0,'2012-01-12 21:05:06',18,4),(77,0,'2012-01-12 21:05:06',21,4),(78,0,'2012-01-12 21:05:06',20,4),(79,0,'2012-01-12 21:05:06',23,4),(80,0,'2012-01-12 21:05:06',22,4),(81,0,'2012-01-12 21:05:06',25,4),(82,0,'2012-01-12 21:05:06',24,4),(84,0,'2012-01-12 21:05:06',26,4),(85,0,'2012-01-12 21:05:06',29,4),(86,0,'2012-01-12 21:05:06',28,4),(88,0,'2012-01-12 21:05:06',34,4),(90,0,'2012-01-12 21:05:06',32,4),(91,0,'2012-01-12 21:05:06',33,4),(92,0,'2012-01-12 21:05:06',38,4),(94,0,'2012-01-12 21:05:06',36,4),(96,0,'2012-03-05 19:42:19',38,1),(98,0,'2012-03-05 19:42:19',36,1),(100,0,'2012-03-24 21:29:23',42,1),(101,0,'2012-03-29 21:31:31',40,1),(102,0,'2012-05-10 20:16:25',43,1),(103,0,'2012-05-10 20:17:21',44,1),(104,0,'2012-05-10 20:17:21',45,1),(105,0,'2012-06-16 21:41:16',43,2),(106,0,'2012-06-16 21:41:16',44,2),(107,0,'2012-07-01 21:41:34',48,1),(108,1,'2013-06-05 15:22:17',54,1),(109,1,'2013-06-05 15:22:17',53,1),(110,1,'2013-06-05 15:22:17',52,1),(111,1,'2013-06-08 13:02:27',55,1),(112,1,'2013-06-16 14:28:04',56,2),(113,1,'2013-06-16 14:28:28',57,1),(114,1,'2013-06-16 14:28:28',56,1),(115,1,'2013-07-25 21:45:31',29,2),(116,1,'2013-07-25 21:45:31',28,2),(117,1,'2013-07-25 21:45:31',34,2),(118,1,'2013-07-25 21:45:31',32,2),(119,1,'2013-07-25 21:45:31',38,2),(120,1,'2013-07-25 21:45:31',36,2),(121,1,'2013-07-25 21:45:31',46,2),(122,1,'2013-07-25 21:45:31',47,2),(123,1,'2013-07-25 21:45:31',45,2),(124,1,'2013-07-25 21:45:31',51,2),(125,1,'2013-07-25 21:45:31',50,2),(126,1,'2013-07-25 21:45:31',49,2),(127,1,'2013-07-25 21:45:31',48,2),(128,1,'2013-07-25 21:45:31',55,2),(129,1,'2013-07-25 21:45:31',54,2),(130,1,'2013-07-25 21:45:31',53,2),(131,1,'2013-07-25 21:45:31',52,2),(132,1,'2013-07-25 21:45:31',57,2);
/*!40000 ALTER TABLE `core_op_role_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofpresence`
--

DROP TABLE IF EXISTS `ofpresence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofpresence` (
  `username` varchar(64) NOT NULL,
  `offlinePresence` text,
  `offlineDate` char(15) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofpresence`
--

LOCK TABLES `ofpresence` WRITE;
/*!40000 ALTER TABLE `ofpresence` DISABLE KEYS */;
INSERT INTO `ofpresence` VALUES ('admin',NULL,'001323484750578'),('tom',NULL,'001323484750578');
/*!40000 ALTER TABLE `ofpresence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_task_approvers`
--

DROP TABLE IF EXISTS `core_task_approvers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_task_approvers` (
  `ID_` int(11) NOT NULL AUTO_INCREMENT,
  `taskId` int(11) DEFAULT NULL,
  `approverId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_task_approvers`
--

LOCK TABLES `core_task_approvers` WRITE;
/*!40000 ALTER TABLE `core_task_approvers` DISABLE KEYS */;
/*!40000 ALTER TABLE `core_task_approvers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_role_user_relation`
--

DROP TABLE IF EXISTS `core_role_user_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_role_user_relation` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `roleId` int(10) unsigned DEFAULT NULL,
  `userId` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_role_user_relation`
--

LOCK TABLES `core_role_user_relation` WRITE;
/*!40000 ALTER TABLE `core_role_user_relation` DISABLE KEYS */;
INSERT INTO `core_role_user_relation` VALUES (2,0,'2011-09-04 07:44:41',1,1),(8,1,'2011-10-12 19:27:14',2,4),(9,1,'2011-11-04 20:15:27',2,11),(10,1,'2011-11-04 20:15:30',2,9),(11,1,'2011-11-04 20:15:35',2,4),(13,1,'2011-11-04 20:15:44',2,8),(14,1,'2011-11-04 20:15:47',2,7),(16,1,'2011-11-04 20:17:58',2,5),(18,1,'2012-01-12 20:38:05',2,3),(19,1,'2012-01-12 21:04:30',4,9),(20,1,'2012-03-01 19:49:48',2,2),(21,1,'2013-06-05 16:55:26',1,10),(23,10,'2013-06-16 16:11:32',1,17);
/*!40000 ALTER TABLE `core_role_user_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_contact`
--

DROP TABLE IF EXISTS `crm_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_contact` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `xingming` varchar(45) DEFAULT NULL,
  `chenghu` varchar(45) DEFAULT NULL,
  `zhiwei` varchar(45) DEFAULT NULL,
  `bumen` varchar(45) DEFAULT NULL,
  `gudingdh` varchar(45) DEFAULT NULL,
  `yidongdh` varchar(45) DEFAULT NULL,
  `xingqu` varchar(200) DEFAULT NULL,
  `qq` varchar(45) DEFAULT NULL,
  `msn` varchar(100) DEFAULT NULL,
  `youjian` varchar(100) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `lianxidj` varchar(100) DEFAULT NULL,
  `beizhu` varchar(450) DEFAULT NULL,
  `isarc` char(1) DEFAULT 'N',
  `birthday` datetime DEFAULT NULL,
  `zhize` varchar(45) DEFAULT NULL,
  `juesezy` varchar(45) DEFAULT NULL,
  `chuanzhen` varchar(45) DEFAULT NULL,
  `zhaidian` varchar(45) DEFAULT NULL,
  `dizhi` varchar(450) DEFAULT NULL,
  `biyeyx` varchar(45) DEFAULT NULL,
  `jiguan` varchar(45) DEFAULT NULL,
  `hunfou` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_contact`
--

LOCK TABLES `crm_contact` WRITE;
/*!40000 ALTER TABLE `crm_contact` DISABLE KEYS */;
INSERT INTO `crm_contact` VALUES (3,8,'2012-03-31 00:00:00',1,'2012-11-05 20:42:29','60a59863-be61-4b1e-86f6-7a368366f25b','李四','男','机关1','财务部','88311138','588258','58','914261631','ContactView','aguest@163.com','李四','重要','备注','N','2012-03-31 00:00:00','经理1','建议者','5869624','135245','办公地址','','武汉','是'),(9,8,'2012-04-02 00:00:00',1,'2012-04-02 20:32:54','efb389e7-154a-46ec-81a0-5a10ed0c2889','找大脚','男','','','','','','','','aguest@163.com','校长','一般','','N','2012-04-02 00:00:00','','执行者','','',NULL,'','','否'),(10,8,'2012-04-02 00:00:00',1,'2012-04-02 20:32:48','efb389e7-154a-46ec-81a0-5a10ed0c2889','嚣张','男','机关','财务部','88311138','588258','58','914261631','ContactView','aguest@163.com','李四','重要','备注','N','2012-01-11 00:00:00','经理','建议者','5869624','135245',NULL,'','武汉','是'),(12,8,'2012-04-02 00:00:00',1,'2012-04-02 20:32:37','efb389e7-154a-46ec-81a0-5a10ed0c2889','dddd','男','','','','','','','','aguest@163.com','dd','一般','','N','2012-04-11 00:00:00','','执行者','','',NULL,'','','否'),(13,8,'2012-04-02 00:00:00',1,'2012-04-03 14:37:55','efb389e7-154a-46ec-81a0-5a10ed0c2889','aaaaaa','男','','','','','','','','sclw12@yahoo.com.cn','aaaaaaaaaaaaaaaaa','一般','','N','2012-04-02 00:00:00','','执行者','','',NULL,'','','否'),(14,8,'2012-04-08 00:00:00',1,'2012-05-09 21:03:59','ed6c2c3c-37b9-4208-bc69-bf777bb73260','daiqianjie','男','','财务','','','','','','qianjie.dai@gmail.com','','一般','','N','2012-04-08 00:00:00','','执行者','','',NULL,'','','否');
/*!40000 ALTER TABLE `crm_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofpubsubnode`
--

DROP TABLE IF EXISTS `ofpubsubnode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofpubsubnode` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `leaf` tinyint(4) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `modificationDate` char(15) NOT NULL,
  `parent` varchar(100) DEFAULT NULL,
  `deliverPayloads` tinyint(4) NOT NULL,
  `maxPayloadSize` int(11) DEFAULT NULL,
  `persistItems` tinyint(4) DEFAULT NULL,
  `maxItems` int(11) DEFAULT NULL,
  `notifyConfigChanges` tinyint(4) NOT NULL,
  `notifyDelete` tinyint(4) NOT NULL,
  `notifyRetract` tinyint(4) NOT NULL,
  `presenceBased` tinyint(4) NOT NULL,
  `sendItemSubscribe` tinyint(4) NOT NULL,
  `publisherModel` varchar(15) NOT NULL,
  `subscriptionEnabled` tinyint(4) NOT NULL,
  `configSubscription` tinyint(4) NOT NULL,
  `accessModel` varchar(10) NOT NULL,
  `payloadType` varchar(100) DEFAULT NULL,
  `bodyXSLT` varchar(100) DEFAULT NULL,
  `dataformXSLT` varchar(100) DEFAULT NULL,
  `creator` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `replyPolicy` varchar(15) DEFAULT NULL,
  `associationPolicy` varchar(15) DEFAULT NULL,
  `maxLeafNodes` int(11) DEFAULT NULL,
  PRIMARY KEY (`serviceID`,`nodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofpubsubnode`
--

LOCK TABLES `ofpubsubnode` WRITE;
/*!40000 ALTER TABLE `ofpubsubnode` DISABLE KEYS */;
INSERT INTO `ofpubsubnode` VALUES ('pubsub','',0,'001319113347859','001319113347859',NULL,0,0,0,0,1,1,1,0,0,'publishers',1,0,'open','','','','minioa','','English','',NULL,'all',-1);
/*!40000 ALTER TABLE `ofpubsubnode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofmucroomprop`
--

DROP TABLE IF EXISTS `ofmucroomprop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofmucroomprop` (
  `roomID` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY (`roomID`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofmucroomprop`
--

LOCK TABLES `ofmucroomprop` WRITE;
/*!40000 ALTER TABLE `ofmucroomprop` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofmucroomprop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_job`
--

DROP TABLE IF EXISTS `core_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_job` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `orgId` int(10) unsigned DEFAULT NULL,
  `parentId` int(10) unsigned DEFAULT NULL,
  `jobName` varchar(100) DEFAULT NULL,
  `jobDesc` varchar(100) DEFAULT NULL,
  `sequence` int(10) unsigned DEFAULT '0',
  `isManager` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_job`
--

LOCK TABLES `core_job` WRITE;
/*!40000 ALTER TABLE `core_job` DISABLE KEYS */;
INSERT INTO `core_job` VALUES (1,0,'2011-08-25 20:18:59',0,'2012-01-12 20:57:15',NULL,1,0,'总经理','总经理',0,1),(2,0,'2011-08-25 20:19:20',0,'2011-08-25 21:03:10',NULL,1,1,'企业管理部经理','企业管理部经理',0,1),(3,0,'2011-08-25 20:19:42',0,'2011-08-25 20:21:07',NULL,1,1,'财务部经理','财务部经理',1,0),(4,0,'2011-08-25 20:19:59',0,'2011-08-25 20:34:39',NULL,1,1,'人事行政部经理','人事行政部经理',2,0),(5,0,'2011-08-25 20:20:14',0,'2011-08-25 20:34:49',NULL,1,1,'技术部经理','技术部经理',3,0),(6,0,'2011-08-25 20:20:25',0,'2013-05-21 15:43:46',NULL,1,1,'营销副总','公司营销负责人',4,1),(7,0,'2011-08-25 20:20:44',0,'2011-09-04 22:10:56',NULL,1,1,'生产部经理','生产部经理',5,0),(8,0,'2011-08-25 20:20:54',0,'2013-05-21 15:40:35',NULL,1,1,'研发部经理','研发部经理',6,1),(9,0,'2011-08-25 20:37:35',0,NULL,NULL,1,2,'企业管理部副经理','企业管理部副经理',0,0),(10,0,'2011-08-25 20:42:49',0,'2011-08-25 20:43:08',NULL,1,9,'企业管理部主任','企业管理部主任',0,0),(11,0,'2011-08-25 20:43:31',0,'2011-08-25 20:45:15',NULL,1,10,'项目主管','项目主管',0,0),(12,0,'2011-08-25 20:45:39',0,NULL,NULL,1,10,'成本主管','成本主管',1,0),(13,0,'2011-08-25 20:45:58',0,'2013-05-21 15:41:15',NULL,1,8,'项目组经理','项目组经理',0,0),(14,0,'2011-08-25 20:46:09',0,'2013-05-21 15:42:13',NULL,1,13,'售前工程师','售前工程师',0,0),(15,0,'2011-08-25 20:46:46',0,'2011-08-25 20:46:51',NULL,1,13,'软件工程师','软件工程师',1,0),(16,0,'2011-08-25 21:01:08',0,'2013-05-21 15:41:39',NULL,1,13,'UI设计师','UI设计师',3,0),(17,0,'2013-06-19 17:25:18',0,NULL,NULL,15,0,'总经理','总经理',1,1),(18,0,'2013-06-19 17:25:41',0,NULL,NULL,15,0,'副总经理','副总经理',2,1),(19,0,'2013-06-19 17:26:07',0,NULL,NULL,15,0,'部门主管','部门主管',3,0),(21,0,'2013-06-19 17:27:03',0,NULL,NULL,15,0,'组长','组长',4,0),(22,0,'2013-06-22 09:47:10',0,NULL,NULL,16,0,'常德分公司','',0,1),(23,0,'2013-07-19 17:07:49',0,NULL,NULL,12,0,'总经理','',0,0),(24,0,'2013-07-19 17:08:11',0,NULL,NULL,12,23,'副总经理','',0,0),(25,0,'2013-07-19 17:08:30',0,NULL,NULL,12,24,'运营总监','',0,0);
/*!40000 ALTER TABLE `core_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_basicdata`
--

DROP TABLE IF EXISTS `core_basicdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_basicdata` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  `value2` varchar(100) DEFAULT NULL,
  `sequence` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_basicdata`
--

LOCK TABLES `core_basicdata` WRITE;
/*!40000 ALTER TABLE `core_basicdata` DISABLE KEYS */;
INSERT INTO `core_basicdata` VALUES (1,1,'2011-10-08 20:33:30',1,'2011-12-19 20:49:56',NULL,'news','公司新闻','01',0),(2,1,'2011-10-08 20:35:25',1,'2011-10-14 18:43:14',NULL,'news','行业新闻','02',1),(3,1,'2011-10-14 18:43:19',NULL,NULL,NULL,'news','社会新闻','03',1),(4,1,'2013-09-03 20:20:00',1,'2013-09-03 20:55:18',NULL,'notion','同意','同意',1),(5,1,'2013-09-03 20:20:08',1,'2013-09-03 20:55:24',NULL,'notion','不同意','不同意',2),(6,1,'2013-09-03 20:20:58',1,'2013-09-03 20:55:44',NULL,'notion','同意传阅','同意传阅',3);
/*!40000 ALTER TABLE `core_basicdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_department`
--

DROP TABLE IF EXISTS `core_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_department` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `orgId` int(10) unsigned DEFAULT NULL,
  `parentId` int(10) unsigned DEFAULT NULL,
  `depaName` varchar(100) DEFAULT NULL,
  `depaDesc` varchar(100) DEFAULT NULL,
  `sequence` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_department`
--

LOCK TABLES `core_department` WRITE;
/*!40000 ALTER TABLE `core_department` DISABLE KEYS */;
INSERT INTO `core_department` VALUES (1,0,'2011-08-20 14:18:02',0,'2011-10-21 21:04:53',NULL,1,0,'战略投资部','战略投资部',0),(2,0,'2011-08-20 14:18:44',0,'2013-07-30 15:04:43',NULL,1,8,'人事行政部','人事行政部',0),(3,0,'2011-08-20 21:23:44',0,'2011-10-21 21:05:22',NULL,11,0,'三炮部队','三炮部队',0),(4,0,'2011-08-20 21:23:54',0,'2013-07-30 15:04:54',NULL,1,13,'财务部','财务部',0),(6,0,'2011-08-20 21:34:41',0,'2011-10-21 21:04:38',NULL,1,4,'财务部1','财务部1',0),(7,0,'2011-08-20 21:34:48',0,'2011-10-21 21:04:40',NULL,1,4,'会计部1','会计部',0),(8,0,'2011-08-20 21:34:54',0,'2011-10-21 21:04:59',NULL,1,0,'市场部','市场部',0),(10,0,'2011-08-20 22:14:41',0,'2011-10-21 21:05:19',NULL,1,0,'信息中心','信息中心',9),(11,0,'2011-08-20 22:14:45',0,'2011-10-21 21:05:02',NULL,1,8,'国内市场部','国内市场部',0),(13,0,'2011-08-20 22:14:57',0,'2013-07-30 15:05:08',NULL,1,13,'海外市场部','海外市场部',0),(14,0,'2011-08-20 22:15:05',0,'2011-10-21 21:05:07',NULL,1,0,'技术部','技术部',0),(15,0,'2011-08-20 22:15:08',0,'2011-10-21 21:05:16',NULL,1,0,'质控部','质控部',8),(16,0,'2011-08-20 22:15:15',0,'2011-10-21 21:05:10',NULL,1,0,'生产部','生产部',0),(17,0,'2011-08-20 22:15:22',0,'2011-10-21 21:05:12',NULL,1,16,'交换机生产线','交换机生产线',0),(18,0,'2011-08-21 12:27:35',0,'2011-10-21 21:05:25',NULL,13,0,'固定电话事业部','固定电话事业部',0),(19,0,'2011-08-21 12:27:41',0,'2011-10-21 21:05:28',NULL,13,0,'移动电话事业部','移动电话事业部',0),(20,0,'2011-08-21 12:27:47',0,'2011-10-21 21:05:32',NULL,12,0,'三炮部队','三炮部队',0),(21,0,'2011-08-21 12:47:12',0,'2011-10-21 21:05:13',NULL,1,16,'平板电脑生产线','平板电脑生产线',0),(22,0,'2013-06-19 17:24:05',0,'2013-06-19 17:24:27',NULL,15,0,'信息部','信息部',1),(23,0,'2013-06-19 17:24:13',0,'2013-06-19 17:24:53',NULL,15,0,'人事部','人事部',2),(24,0,'2013-06-22 09:41:05',0,NULL,NULL,13,18,'固定电话事业部','固定电话事业部',0),(25,0,'2013-06-22 15:45:43',0,NULL,NULL,1,21,'平板电脑生产线','平板电脑生产线',0),(26,0,'2013-07-31 09:09:09',0,NULL,NULL,1,1,'战略投资部','战略投资部',0),(27,0,'2013-07-31 09:09:23',0,NULL,NULL,11,3,'三炮部队','三炮部队',0),(28,0,'2013-07-31 11:39:18',0,NULL,NULL,11,27,'三炮部队','三炮部队',0),(29,0,'2013-07-31 11:39:37',0,NULL,NULL,11,28,'三炮部队','三炮部队',0);
/*!40000 ALTER TABLE `core_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofversion`
--

DROP TABLE IF EXISTS `ofversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofversion` (
  `name` varchar(50) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofversion`
--

LOCK TABLES `ofversion` WRITE;
/*!40000 ALTER TABLE `ofversion` DISABLE KEYS */;
INSERT INTO `ofversion` VALUES ('openfire',21);
/*!40000 ALTER TABLE `ofversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_topmenu`
--

DROP TABLE IF EXISTS `core_topmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_topmenu` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `parentId` int(10) unsigned DEFAULT NULL,
  `menuName` varchar(100) DEFAULT NULL,
  `menuUrl` varchar(100) DEFAULT NULL,
  `menuTarget` varchar(100) DEFAULT NULL,
  `sequence` int(10) unsigned DEFAULT '0',
  `templates` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_topmenu`
--

LOCK TABLES `core_topmenu` WRITE;
/*!40000 ALTER TABLE `core_topmenu` DISABLE KEYS */;
INSERT INTO `core_topmenu` VALUES (2,0,'2011-08-28 10:54:12',0,NULL,NULL,0,'新闻中心','','_self',2,'default,web'),(3,0,'2011-08-28 10:54:42',0,'2011-12-19 20:49:45',NULL,0,'部门网站','','_self',3,'default,web'),(4,0,'2011-08-28 10:54:50',0,'2011-12-21 20:30:55',NULL,0,'工作申请','','_self',4,'default,web'),(5,0,'2011-08-28 10:54:58',0,'2011-12-22 09:56:38',NULL,0,'流程管理','','_self',6,'default,web'),(6,0,'2011-08-28 10:55:14',0,'2011-12-22 09:56:33',NULL,0,'表单管理','','_self',5,'default,web'),(7,0,'2011-08-28 10:55:26',0,'2012-10-20 20:19:34',NULL,0,'系统管理','','_self',99,'defaultweb'),(8,0,'2011-08-28 10:55:51',0,'2012-04-03 15:55:59',NULL,2,'通知通告','news.jsf?cate=01','_self',1,'default,web'),(9,0,'2011-08-28 10:56:02',0,'2012-04-03 15:55:54',NULL,2,'公司新闻','news.jsf?cate=01','_self',2,'default,web'),(10,0,'2011-08-28 10:56:10',0,'2012-04-03 15:55:50',NULL,2,'集团新闻','news.jsf?cate=01','_self',3,'default,web'),(11,0,'2011-08-28 10:56:43',0,'2012-04-03 15:55:46',NULL,2,'行业新闻','news.jsf?cate=01','_self',4,'default,web'),(12,0,'2011-08-28 10:57:05',0,'2012-04-03 15:55:41',NULL,2,'社会中心','news.jsf?cate=01','_self',5,'default,web'),(13,0,'2011-08-28 10:57:24',0,NULL,NULL,3,'人事部','','_self',1,'default,web'),(14,0,'2011-08-28 10:57:30',0,NULL,NULL,3,'财务部','','_self',2,'default,web'),(15,0,'2011-08-28 10:57:38',0,NULL,NULL,3,'技术部','','_self',3,'default,web'),(16,0,'2011-08-28 10:57:46',0,NULL,NULL,3,'市场部','','_self',4,'default,web'),(17,0,'2011-08-28 10:58:08',0,'2011-12-21 20:35:13',NULL,4,'会议申请','formview1.jsf?formId=11','_self',1,'default,web'),(19,0,'2011-08-28 10:58:30',0,'2013-06-16 14:15:30',NULL,83,'报销申请','','_self',3,'default,web'),(20,0,'2011-08-28 10:58:45',0,'2011-12-22 09:35:15',NULL,5,'流程定义','processdefinition.jsf','_self',1,'default,web'),(21,0,'2011-08-28 10:58:55',0,'2011-12-23 14:54:48',NULL,5,'审批授权','taskagent.jsf','_self',2,'default,web'),(22,0,'2011-08-28 10:59:02',0,'2012-01-17 20:22:38',NULL,5,'流程统计','','_self',3,'default,web'),(23,0,'2011-08-28 10:59:11',0,'2012-01-21 17:00:43',NULL,5,'待审批','taskrunning.jsf','_self',4,'default,web'),(24,0,'2011-08-28 10:59:20',0,'2012-01-21 17:01:34',NULL,5,'已审批','taskcompleted.jsf','_self',5,'default,web'),(25,0,'2011-08-28 10:59:40',0,'2011-11-25 21:48:34',NULL,6,'表单列表','form.jsf','_self',1,'default,web'),(26,0,'2011-08-28 10:59:47',0,'2011-11-27 20:45:09',NULL,6,'系统字段管理','formfield.jsf','_self',2,'default,web'),(27,0,'2011-08-28 10:59:55',0,'2011-11-25 21:05:02',NULL,6,'表单视图','','_self',3,'default,web'),(28,0,'2011-08-29 20:21:40',0,NULL,NULL,7,'单位管理','org.jsf','_self',1,'default,web'),(29,0,'2011-08-29 20:22:14',0,NULL,NULL,7,'部门管理','department.jsf','_self',2,'default,web'),(30,0,'2011-08-29 20:22:33',0,'2011-09-03 14:49:59',NULL,7,'岗位管理','job.jsf','_self',3,'default,web'),(31,0,'2011-08-29 20:22:52',0,NULL,NULL,7,'帐号管理','user.jsf','_self',4,'default,web'),(32,0,'2011-08-29 20:23:12',0,NULL,NULL,7,'角色管理','role.jsf','_self',5,'default,web'),(33,0,'2011-08-29 20:23:34',0,NULL,NULL,7,'权限管理','op.jsf','_self',6,'default,web'),(34,0,'2011-08-29 20:24:05',0,'2012-05-08 21:03:16',NULL,7,'主菜单管理','topmenuadmin.jsf','_self',7,'default,web'),(35,0,'2011-08-29 20:24:25',0,'2012-05-08 21:03:25',NULL,7,'副菜单管理','leftmenuadmin.jsf','_self',8,'default,web'),(36,0,'2011-08-29 20:24:51',0,'2011-10-08 20:24:26',NULL,7,'基础数据','basicdata.jsf','_self',9,'default,web'),(37,0,'2011-08-29 20:25:05',0,'2011-11-05 19:50:37',NULL,7,'日志管理','log.jsf','_self',10,'default,web'),(38,0,'2011-08-29 20:25:16',0,'2011-10-10 19:44:02',NULL,7,'新闻管理','news.jsf','_self',11,'default,web'),(39,0,'2011-08-29 20:25:34',0,NULL,NULL,7,'流程管理','','_self',12,'default,web'),(40,0,'2011-08-29 20:30:10',0,NULL,NULL,39,'流程定义','','_self',1,'default,web'),(41,0,'2011-08-29 20:30:26',0,NULL,NULL,39,'节点定义','','_self',2,'default,web'),(42,0,'2011-08-29 20:30:47',0,NULL,NULL,39,'审批代理','','_self',3,'default,web'),(43,0,'2011-11-04 19:11:31',0,NULL,NULL,7,'抽签管理','ballot.jsf','_self',13,'default,web'),(44,0,'2011-11-29 19:01:11',0,NULL,NULL,7,'系统参数','prop.jsf','_self',14,'default,web'),(45,0,'2011-12-22 09:36:57',0,'2012-01-21 13:41:49',NULL,5,'待审批流程','process.jsf?status=running','_self',6,'default,web'),(46,0,'2011-12-22 09:37:21',0,'2012-01-21 13:42:06',NULL,5,'已审批流程','process.jsf?status=agree','_self',7,'default,web'),(47,0,'2012-05-07 06:14:34',0,'2012-10-20 10:41:39',NULL,0,'我的桌面','','_self',1,'default,web'),(48,0,'2012-05-07 06:14:47',0,NULL,NULL,47,'修改资料','updateprofile.jsf','_self',0,'default,web'),(49,0,'2012-05-07 06:15:03',0,'2012-05-07 06:16:20',NULL,47,'修改密码','updatepassword.jsf','_self',1,'default,web'),(50,0,'2012-05-07 06:15:18',0,'2012-05-07 06:33:49',NULL,47,'我的任务','taskrunning.jsf','_self',2,'default,web'),(51,0,'2012-05-07 06:15:38',0,'2012-05-07 06:16:26',NULL,47,'审批设置','taskagent.jsf','_self',3,'default,web'),(52,0,'2012-05-07 20:39:42',0,'2012-11-01 20:31:38',NULL,0,'客户关系管理','','_self',9,'default'),(53,0,'2012-05-07 20:40:04',0,NULL,NULL,52,'客户资料','crm/customer.jsf','_self',0,'default,web'),(54,0,'2012-05-07 20:40:17',0,NULL,NULL,52,'客户资料查询','crm/customerview.jsf','_self',1,'default,web'),(55,0,'2012-05-07 20:40:29',0,NULL,NULL,52,'A-重点客户','crm/customerview.jsf?type=A','_self',2,'default,web'),(56,0,'2012-05-07 20:40:42',0,NULL,NULL,52,'B-成交客户','crm/customerview.jsf?type=B','_self',2,'default,web'),(57,0,'2012-05-07 20:40:58',0,NULL,NULL,52,'C-有意向客户','crm/customerview.jsf?type=C','_self',5,'default,web'),(58,0,'2012-05-07 20:41:12',0,NULL,NULL,52,'D-商机客户','crm/customerview.jsf?type=D','_self',6,'default,web'),(59,0,'2012-05-07 20:41:26',0,NULL,NULL,52,'E-培养客户','crm/customerview.jsf?type=E','_self',7,'default,web'),(60,0,'2012-05-07 20:41:46',0,'2012-05-07 20:43:20',NULL,52,'联系人查询','crm/contactview_all.jsf','_self',10,'default,web'),(61,0,'2012-05-07 20:41:59',0,NULL,NULL,52,'拜访记录查询','crm/visitview_all.jsf','_self',10,'default,web'),(62,0,'2012-05-07 20:42:12',0,NULL,NULL,52,'交易记录查询','crm/recordview_all.jsf','_self',11,'default,web'),(63,0,'2012-05-07 20:42:36',0,NULL,NULL,52,'联系人批量导入','crm/contactimport.jsf','_self',12,'default,web'),(64,0,'2012-05-07 20:42:57',0,NULL,NULL,52,'已发邮件','crm/mail.jsf','_self',13,'default,web'),(65,0,'2012-05-07 20:43:11',0,NULL,NULL,52,'群发邮件','crm/contactviewmail.jsf','_self',14,'default,web'),(66,0,'2012-05-10 19:56:24',0,NULL,NULL,0,'文档管理','formview5.jsf?formId=12','_self',2,'default,web'),(68,0,'2012-10-20 10:41:31',0,'2012-10-20 20:20:58',NULL,0,'首页','index.jsf','_self',0,'web'),(69,0,'2012-11-20 19:43:03',0,'2012-11-20 19:51:51',NULL,52,'统计图表','crm/chart.jsf?ofc=../../../temp/chart/3d.txt','_self',15,'default'),(70,0,'2012-11-20 19:47:17',0,NULL,NULL,0,'图表演示','chartdemo.jsf','_self',99,'default'),(71,0,'2013-04-02 19:00:25',0,NULL,NULL,0,'网站管理','','_self',9901,'default'),(72,0,'2013-04-02 19:00:58',0,'2013-04-10 20:39:08',NULL,71,'基本资料','web/htmlproptext.jsf?xtype=text','_self',9901,'default'),(75,0,'2013-04-02 19:02:27',0,'2013-04-09 21:23:47',NULL,71,'模块管理','web/htmlprop.jsf?xtype=module','_self',9905,'default'),(78,0,'2013-04-02 19:09:33',0,'2013-04-09 21:23:55',NULL,71,'模板管理','web/htmlprop.jsf?xtype=template','_self',9910,'default'),(79,0,'2013-04-02 19:09:55',0,'2013-04-09 21:24:03',NULL,71,'网页管理','web/htmlprop.jsf?xtype=file','_self',9911,'default'),(80,0,'2013-04-09 10:39:24',0,'2013-04-10 21:09:57',NULL,71,'文件管理','web/filelist.jsf?dirName=web','_self',9912,'default'),(81,0,'2013-04-09 10:39:57',0,'2013-04-09 10:40:33',NULL,71,'文章管理','文章管理','_self',9913,'default'),(82,0,'2013-04-09 10:40:18',0,'2013-04-09 10:40:40',NULL,71,'产品管理','产品管理','_self',9915,'default'),(83,0,'2013-05-22 16:26:41',0,'2013-06-16 14:14:43',NULL,19,'请假申请','','_self',2,'defaultweb');
/*!40000 ALTER TABLE `core_topmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofpubsubnodejids`
--

DROP TABLE IF EXISTS `ofpubsubnodejids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofpubsubnodejids` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `associationType` varchar(20) NOT NULL,
  PRIMARY KEY (`serviceID`,`nodeID`,`jid`(70))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofpubsubnodejids`
--

LOCK TABLES `ofpubsubnodejids` WRITE;
/*!40000 ALTER TABLE `ofpubsubnodejids` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofpubsubnodejids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_news_attachment`
--

DROP TABLE IF EXISTS `core_news_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_news_attachment` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `filename` varchar(200) DEFAULT NULL,
  `filetype` varchar(45) DEFAULT NULL,
  `filesize` int(10) unsigned DEFAULT '0',
  `oldname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_news_attachment`
--

LOCK TABLES `core_news_attachment` WRITE;
/*!40000 ALTER TABLE `core_news_attachment` DISABLE KEYS */;
INSERT INTO `core_news_attachment` VALUES (8,1,'2011-10-10 21:48:44',NULL,NULL,'7ee68b0d-a19d-40ab-95f2-22340385e8c0','upload\\news\\39a71884-7771-4e7e-95b6-5c5a890b1ed2.jpg','.jpg',158445,'minioademo.jpg'),(9,1,'2011-10-10 21:49:09',NULL,NULL,'7ee68b0d-a19d-40ab-95f2-22340385e8c0','upload\\news\\e5d5b4a0-26bd-4373-8b57-21a93c658097.jpg','.jpg',45648,'1316760017386.jpg'),(11,1,'2011-10-11 20:51:01',NULL,NULL,'99afc9e4-1ca0-4c6a-a31d-91f713f96681','upload\\news\\766043d3-1299-4849-8a90-ed0d70f00e79.jpg','.jpg',36413,'222.jpg'),(12,1,'2011-10-11 20:59:23',NULL,NULL,'99afc9e4-1ca0-4c6a-a31d-91f713f96681','upload\\news\\e10393e7-773a-4df7-baf3-56a3c0a1c847.jpg','.jpg',45648,'1316760017386.jpg'),(14,1,'2011-10-11 21:11:16',NULL,NULL,'83c177ba-7082-4f36-8b7e-854823b7d46d','upload\\news\\d9afbacb-51d4-4bc6-941c-1e8347491b71.jpg','.jpg',16630,'rdn_4e93629fdf0f3.jpg'),(15,1,'2011-10-11 21:33:30',NULL,NULL,'83c177ba-7082-4f36-8b7e-854823b7d46d','upload\\news\\bca4deff-9e24-43f9-84b2-f29d9561a844.jpg','.jpg',36413,'222.jpg'),(16,1,'2011-10-13 20:18:03',NULL,NULL,'f8a53f16-4c8d-40a2-9c76-fdb7b2cf9fab','upload\\news\\e89920e8-5a9b-4b32-adbe-cdd529079454.jpg','.jpg',205986,'四姑娘山14名违规登山驴友获救.jpg'),(17,1,'2011-10-13 20:40:42',NULL,NULL,'1cac5b61-4648-4c7c-b675-fe7ed33061a3','upload\\news\\3ffa2d8d-e980-4da1-bf07-101e27883d7a.jpg','.jpg',29374,'利比亚当局军官称卡扎菲之子穆塔西姆未被逮捕.jpg'),(18,1,'2011-10-14 18:45:40',NULL,NULL,'9d657db4-a8e6-4d25-a29f-27c27448edee','upload\\news\\b4401729-9c4a-44aa-8130-f906486abbf5.jpg','.jpg',73631,'A380.jpg'),(19,1,'2011-10-14 19:00:54',NULL,NULL,'e28dbf61-f2d2-4153-bb5e-3943b20c0060','upload\\news\\c4746f1b-531f-4706-9a41-6c22a91ad796.jpg','.jpg',33658,'南非摄影师追逐闪电16年拍摄壮观场面(图).jpg'),(21,1,'2011-12-19 20:46:01',NULL,NULL,'f9e6bbed-9d02-4e16-b82f-902c6059d23d','upload\\news\\9d1e683b-5265-4291-8c38-939d382b94fb.jpg','.jpg',263187,'滚动图集：金正日逝世1.jpg'),(22,1,'2011-12-19 20:47:21',NULL,NULL,'f9e6bbed-9d02-4e16-b82f-902c6059d23d','upload\\news\\b28f8ce6-b6de-4a1e-bbae-c6ddd940ef36.jpg','.jpg',335210,'滚动图集：金正日逝世2.jpg'),(23,1,'2011-12-19 20:47:21',NULL,NULL,'f9e6bbed-9d02-4e16-b82f-902c6059d23d','upload\\news\\e6f78c79-b103-4629-a601-21c584726eda.jpg','.jpg',332283,'滚动图集：金正日逝世4.jpg'),(24,1,'2011-12-19 20:47:21',NULL,NULL,'f9e6bbed-9d02-4e16-b82f-902c6059d23d','upload\\news\\da95c6ce-0874-45b8-9377-9c551b862d07.jpg','.jpg',302941,'滚动图集：金正日逝世3.jpg'),(25,1,'2011-12-19 20:47:22',NULL,NULL,'f9e6bbed-9d02-4e16-b82f-902c6059d23d','upload\\news\\04c4680f-6385-4892-9571-40589336d0cb.jpg','.jpg',353191,'滚动图集：金正日逝世5.jpg'),(26,1,'2012-04-15 21:35:43',NULL,NULL,'582124bb-2d92-4a7d-94d8-a0ada13b1ce2','upload\\news\\ee6afbf2-17e2-4570-b7b3-eada956864e0.jpg','.jpg',45687,'DF21.jpg'),(27,1,'2012-04-22 11:08:51',NULL,NULL,'d81c5b14-9574-40e5-8cf2-c584c2fb2f42','upload\\news\\c2fefcbf-1600-4ece-afda-6be2eae5a7b7.jpg','.jpg',71637,'001.jpg'),(28,1,'2012-04-22 11:08:51',NULL,NULL,'d81c5b14-9574-40e5-8cf2-c584c2fb2f42','upload\\news\\861a30e8-7008-4400-a543-70f1de3ab112.jpg','.jpg',170251,'002.jpg');
/*!40000 ALTER TABLE `core_news_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofgroupprop`
--

DROP TABLE IF EXISTS `ofgroupprop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofgroupprop` (
  `groupName` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY (`groupName`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofgroupprop`
--

LOCK TABLES `ofgroupprop` WRITE;
/*!40000 ALTER TABLE `ofgroupprop` DISABLE KEYS */;
INSERT INTO `ofgroupprop` VALUES ('1','sharedRoster.displayName',''),('1','sharedRoster.groupList',''),('1','sharedRoster.showInRoster','nobody'),('10','sharedRoster.displayName',''),('10','sharedRoster.groupList',''),('10','sharedRoster.showInRoster','nobody'),('11','sharedRoster.displayName',''),('11','sharedRoster.groupList',''),('11','sharedRoster.showInRoster','nobody'),('13','sharedRoster.displayName',''),('13','sharedRoster.groupList',''),('13','sharedRoster.showInRoster','nobody'),('14','sharedRoster.displayName',''),('14','sharedRoster.groupList',''),('14','sharedRoster.showInRoster','nobody'),('15','sharedRoster.displayName',''),('15','sharedRoster.groupList',''),('15','sharedRoster.showInRoster','nobody'),('16','sharedRoster.displayName',''),('16','sharedRoster.groupList',''),('16','sharedRoster.showInRoster','nobody'),('17','sharedRoster.displayName',''),('17','sharedRoster.groupList',''),('17','sharedRoster.showInRoster','nobody'),('18','sharedRoster.displayName',''),('18','sharedRoster.groupList',''),('18','sharedRoster.showInRoster','nobody'),('19','sharedRoster.displayName',''),('19','sharedRoster.groupList',''),('19','sharedRoster.showInRoster','nobody'),('2','sharedRoster.displayName',''),('2','sharedRoster.groupList',''),('2','sharedRoster.showInRoster','nobody'),('20','sharedRoster.displayName',''),('20','sharedRoster.groupList',''),('20','sharedRoster.showInRoster','nobody'),('21','sharedRoster.displayName',''),('21','sharedRoster.groupList',''),('21','sharedRoster.showInRoster','nobody'),('22','sharedRoster.displayName',''),('22','sharedRoster.groupList',''),('22','sharedRoster.showInRoster','nobody'),('23','sharedRoster.displayName',''),('23','sharedRoster.groupList',''),('23','sharedRoster.showInRoster','nobody'),('3','sharedRoster.displayName',''),('3','sharedRoster.groupList',''),('3','sharedRoster.showInRoster','nobody'),('4','sharedRoster.displayName',''),('4','sharedRoster.groupList',''),('4','sharedRoster.showInRoster','nobody'),('6','sharedRoster.displayName',''),('6','sharedRoster.groupList',''),('6','sharedRoster.showInRoster','nobody'),('7','sharedRoster.displayName',''),('7','sharedRoster.groupList',''),('7','sharedRoster.showInRoster','nobody'),('8','sharedRoster.displayName',''),('8','sharedRoster.groupList',''),('8','sharedRoster.showInRoster','nobody');
/*!40000 ALTER TABLE `ofgroupprop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofpubsubitem`
--

DROP TABLE IF EXISTS `ofpubsubitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofpubsubitem` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `payload` mediumtext,
  PRIMARY KEY (`serviceID`,`nodeID`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofpubsubitem`
--

LOCK TABLES `ofpubsubitem` WRITE;
/*!40000 ALTER TABLE `ofpubsubitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofpubsubitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofgroup`
--

DROP TABLE IF EXISTS `ofgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofgroup` (
  `groupName` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`groupName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofgroup`
--

LOCK TABLES `ofgroup` WRITE;
/*!40000 ALTER TABLE `ofgroup` DISABLE KEYS */;
INSERT INTO `ofgroup` VALUES ('1','西柏网络-战略投资部'),('10','西柏网络-信息中心'),('11','西柏网络-市场部-国内市场部'),('13','西柏网络-市场部-海外市场部'),('14','西柏网络-技术部'),('15','西柏网络-质控部'),('16','西柏网络-生产部'),('17','西柏网络-生产部-交换机生产线'),('18','中国移动-固定电话事业部'),('19','中国移动-移动电话事业部'),('2','西柏网络-人事行政部'),('20','中国石化-三炮部队'),('21','西柏网络-生产部-平板电脑生产线'),('22','艾贝斯-信息部'),('23','艾贝斯-人事部'),('3','中国石油-三炮部队'),('4','西柏网络-财务部'),('6','西柏网络-财务部-财务部1'),('7','西柏网络-财务部-会计部1'),('8','西柏网络-市场部');
/*!40000 ALTER TABLE `ofgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_org`
--

DROP TABLE IF EXISTS `core_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_org` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `orgName` varchar(100) DEFAULT NULL,
  `orgDesc` varchar(100) DEFAULT NULL,
  `sequence` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_org`
--

LOCK TABLES `core_org` WRITE;
/*!40000 ALTER TABLE `core_org` DISABLE KEYS */;
INSERT INTO `core_org` VALUES (1,0,'2011-08-15 20:41:22',0,'2013-05-21 15:38:14',NULL,'精准软件','郑州精准软件科技有限公司',0),(11,0,'2011-08-15 21:50:50',0,'2011-12-19 20:49:01',NULL,'中国石油','中国石油股份有限公司',0),(12,0,'2011-08-15 21:50:53',0,'2011-08-21 21:24:29',NULL,'中国石化','中国石化股份有限公司',100),(13,0,'2011-08-16 20:47:59',0,'2013-08-01 11:27:02',NULL,'中国移动','中国移动股份有限公司',99),(15,0,'2013-06-19 17:23:28',0,NULL,NULL,'艾贝斯','杭州艾贝斯儿童用品有限公司',0),(16,0,'2013-06-20 11:47:43',0,'2013-06-22 09:54:57',NULL,'中国移动','中国移动股份有限公司',99),(17,0,'2013-06-22 09:48:30',0,NULL,NULL,'中国石油','中国石油股份有限公司',0);
/*!40000 ALTER TABLE `core_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_news`
--

DROP TABLE IF EXISTS `core_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_news` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `cate` varchar(45) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` text,
  `ispicnews` char(1) DEFAULT 'N',
  `status_` int(10) unsigned DEFAULT '0',
  `times` int(10) unsigned DEFAULT '0',
  `keywords` text,
  `imgurl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  FULLTEXT KEY `keywords` (`keywords`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_news`
--

LOCK TABLES `core_news` WRITE;
/*!40000 ALTER TABLE `core_news` DISABLE KEYS */;
INSERT INTO `core_news` VALUES (3,1,'2011-10-10 20:04:30',1,'2011-10-19 20:25:46','18fbec1d-369d-42ba-83f2-fe2ff18461cd','02','泰军方称缅甸贩毒集团枪杀中国船员','<p class=\"summary\">核心提示：泰国军方称，一伙由缅甸毒枭Nor Kham指挥的贩毒集团被认为是在湄公河枪杀中国船员的幕后黑手。10月5日上午，两艘搭载13名中国船员的商船在湄公河金三角水域遭劫持杀害。中国外交部称，最后确认11人遇难，2人失踪。此前有媒体报道13人全部遇难。</p>\n<p><span class=\"blank12\">&nbsp;</span></p>','N',1,0,'泰 军方 称 缅甸 贩毒集团 枪杀 中国 船员 核心 提示 泰国 国军 军方 称 一伙 由 缅甸 毒枭 指挥 贩毒集团 认为是 湄公河 枪杀 中国 船员 幕后 黑手 上午 两 艘 搭载 名 中国 船员 商船 湄公河 金三角 水域 遭劫持 杀害 中国外交 外交部 称 最后 确认 人 遇难 人 失踪 此前 前有 媒体报道 人 全部 遇难 ',NULL),(5,1,'2011-10-10 20:44:27',1,'2011-12-19 20:36:44','1cac5b61-4648-4c7c-b675-fe7ed33061a3','01','利比亚当局军官称卡扎菲之子穆塔西姆未被逮捕','<p>中新网10月13日电 据法新社报道，利比亚执政当局&ldquo;全国过渡委员会&rdquo;(以下简称&ldquo;过渡委&rdquo;)一名在苏尔特的军事高官13日指出，卡扎菲的儿子穆塔西姆目前没有被捕，而是仍然&ldquo;在逃&rdquo;。</p>\n<p>据报道，&ldquo;解放利比亚烈士旅&rdquo;的<a href=\"http://car.auto.ifeng.com/series/2006\" target=\"_blank\">指挥官</a>哈米德(Wesam Bin Hamid)表示，&ldquo;穆塔西姆被抓捕的消息不属实&rdquo;。他说，&ldquo;但一些我们抓捕的俘虏称，卡扎菲本人在苏尔特&rdquo;。</p>\n<p>13日，利比亚&ldquo;过渡委&rdquo;一名重要顾问比扎马(Abdelkarim Bizama)告诉法新社：&ldquo;穆塔西姆&middot;卡扎菲于苏尔特被捕，其后被送往(国家东部的)班加西。&rdquo;</p>\n<p>他补充说，&ldquo;我们早前并未公布逮捕的消息是为了避免他的(家人和助手)试图帮他逃脱&rdquo;。</p>\n<p>哈米德还指出，目前卡扎菲家乡苏尔特东部已完全处在执政当局控制之下，效忠卡扎菲的势力则在苏尔特西部做最后的激烈抵抗。他说，&ldquo;苏尔特东部的全部行动已经完成&rdquo;。</p>\n<p>他表示：&ldquo;那儿仍然有少许抵抗&mdash;&mdash;在一或两个地区，战斗仍在继续。&rdquo;&ldquo;我们正提供后援支持，帮助苏尔特西部的士兵&rdquo;。</p>\n<p>在前线的法新社通讯员传回消息说，13日晨，效忠卡扎菲武装占据的二处苏尔特居民区传出激烈交火声，双方使用火箭炮、机关枪以及小型武器等交火。</p>\n<p>&nbsp;</p>\n<p style=\"text-align: center;\"><img src=\"../../upload/news/3ffa2d8d-e980-4da1-bf07-101e27883d7a.jpg\" alt=\"\" width=\"506\" height=\"350\" /></p>\n<p>13日，当局武装还宣称他们抓捕了卡扎菲政权的最高级别教士坦图什(Khaled Tantoosh)，他担任卡扎菲政权的穆夫提(伊斯兰教&ldquo;教法解说人&rdquo;)，据称他是在试着逃离苏尔特的时候遭到抓捕的。当局拦截了他所乘坐的车辆，他与四名同伴被捕。</p>\n<p>当局士兵说，坦图什完全改变了他的面貌，他剃了胡须，乘车准备逃往的黎波里。</p>\n<p>目前未能确认当局是否将坦图什与卡扎菲的儿子穆塔西姆混淆。</p>','Y',1,1,'利比亚 亚当 当局 军官 官称 卡 扎 菲 之子 穆 塔 西 姆 未被 逮捕 中新网 电 据 法新社 报道 利比亚 执政 当局 全国 过渡 委员会 以下 简称 过渡 委 一名 苏 尔 特 军事 高官 指出 卡 扎 菲 儿子 穆 塔 西 姆 目前 没有 被捕 而是 仍然 在逃 据报道 解放 利比亚 烈士旅 指挥官 哈米德 表示 穆 塔 西 姆 抓捕 消息 不属 属实 他 说 一些 我们 抓捕 俘虏 称 卡 扎 菲 本人 人在 苏 尔 特 利比亚 过渡 委 一名 重要 顾问 扎 马 告诉 法新社 穆 塔 西 姆 卡 扎 菲 苏 尔 特 被捕 其后 送往 国家 东部 班 加 西 他 补充 说 我们 早前 并未 公布 逮捕 消息 是为了 避免 他 家人 人和 助手 试图 帮 他 逃脱 哈米德 还指 指出 目前 卡 扎 菲 家乡 苏 尔 特 东部 已完 完全 处在 执政 当局 控制 之下 效忠 卡 扎 菲 势力 则在 苏 尔 特 西部 做 最后 激烈 抵抗 他 说 苏 尔 特 东部 全部 行动 已经 完成 他 表示 那儿 仍然 有 少许 抵抗 一 两个 地区 战斗 仍在 继续 我们 正 提供 后援 支持 帮助 苏 尔 特 西部 的士 士兵 在前 前线 法新社 通讯员 传回 消息 说 晨 效忠 卡 扎 菲 武装 占据 二 处 苏 尔 特 居民区 传出 激烈 交火 声 双方 使用 用火 火箭炮 机关枪 以及 小型 武器 交火 当局 武装 宣称 他们 抓捕 卡 扎 菲 政权 最高级别 别教 教士 坦 图 什 他 担任 卡 扎 菲 政权 穆 夫 提 伊斯兰教 教法 解说 人 据称 他 试着 逃离 苏 尔 特 时候 遭到 抓捕 当局 拦截 他 所 乘坐 车辆 他 四名 同伴 被捕 当局 士兵 说 坦 图 什 完全 改变 变了 他 面貌 他 剃了 胡须 乘车 准备 逃往 的黎波里 目前 未能 确认 当局 是否 将 坦 图 什 卡 扎 菲 儿子 穆 塔 西 姆 混淆 ','../../upload/news/3ffa2d8d-e980-4da1-bf07-101e27883d7a.jpg'),(6,1,'2011-10-10 20:44:50',1,'2011-10-19 20:25:38','99afc9e4-1ca0-4c6a-a31d-91f713f96681','02','泰军马英九辛亥百年讲话：辛亥革命是两岸共同资产','<p>凤凰卫视10月10日《台湾新闻》节目播出&ldquo;台湾庆双十节 举行大型军事展演&rdquo;，以下为文字实录：</p>\n<p>安东：为了庆祝辛亥革命一百周年纪念日，台北在今天是有盛大的庆祝活动，其中最受瞩目的兵力展演在今天上午的11点登场了，我们也马上带您到现场去看一看。</p>\n<p>今年参与展演的就包括空中兵力还有地面部队，还有70架直升机、运输机和各式的战机，它们将会以高难度的编队飞行，展现空中战斗力，并且由AT3教 练机在领导人办公室前的天空当中喷出红、蓝、白三色的烟雾，而地面部队则是由宪兵机车连打头阵，率领台湾造的&ldquo;云豹&rdquo;装甲车、&ldquo;天弓&rdquo;防空导弹、&ldquo;雄风&rdquo; 三型超音速攻船导弹、&ldquo;雷霆2000&rdquo;多管火箭和&ldquo;中翔二号&rdquo;遥控侦察机等装备，依序的经过<a href=\"http://baike.tw.ifeng.com/doc/25307\" target=\"_blank\">凯达格兰大道</a>。</p>','N',1,2,'泰 军马 马英九 辛亥 百年 讲话 辛亥革命 两岸 共同 资产 凤凰卫视 台湾 新闻 节目 播出 台湾 庆 双十节 举行 大型 军事 展演 以下 下为 文字 实录 安东 为了 庆祝 辛亥革命 一百 周年纪念日 台北 今天是 有 盛大 庆祝 活动 其中 中最 最受 瞩目 目的 兵力 展演 今天上午 点 登场 我们 也 马上 带 您 到 现场 去看 看一看 今年 参与 展演 包括 空中 兵力 还有 地面部队 还有 架 直升机 运输机 和 各式 战机 它们 将会 高难度 编队 飞行 展现 空中 战斗力 并且 由 教 练 机 领导人 办公室 前 天空 空当 当中 喷出 红 蓝 白三色 烟雾 地面部队 则是 由 宪兵 机车 连打 打头阵 率领 台湾 造 云豹 装甲车 天弓 防空 导弹 雄风 三 型 超音速 速攻 船 导弹 雷霆 多管 火箭 和 中 翔 二号 遥控 侦察机 装备 依序 经过 凯 达 格 兰 大道 ',NULL),(7,1,'2011-10-11 21:11:22',1,'2011-12-19 20:36:37','83c177ba-7082-4f36-8b7e-854823b7d46d','01','缅甸佤邦声明未杀害中国船员','<p>核心提示：缅甸佤邦政府10月10日发表声明，回应泰国媒体&ldquo;中国船员遇袭是缅甸佤邦联合军所为&rdquo;报道。声明强调事件与佤邦联合军无关，称佤邦愿配合中国调查。佤邦建议执勤泰国警察接受中方调查。中国外交部则称泰警方已根据中方要求对现场取证，展开调查。</p>\n<p>核心提示：缅甸佤邦政府10月10日发表声明，回应泰国媒体&ldquo;中国船员遇袭是缅甸佤邦联合军所为&rdquo;报道。声明强调事件与佤邦联合军无关，称佤邦愿配合中国调查。佤邦建议执勤泰国警察接受中方调查。中国外交部则称泰警方已根据中方要求对现场取证，展开调查。</p>\n<p>&nbsp;</p>\n<p style=\"text-align: center;\"><img src=\"../../upload/news/d9afbacb-51d4-4bc6-941c-1e8347491b71.jpg\" alt=\"\" width=\"254\" height=\"200\" /></p>\n<p>核心提示：缅甸佤邦政府10月10日发表声明，回应泰国媒体&ldquo;中国船员遇袭是缅甸佤邦联合军所为&rdquo;报道。声明强调事件与佤邦联合军无关，称佤邦愿配合中国调查。佤邦建议执勤泰国警察接受中方调查。中国外交部则称泰警方已根据中方要求对现场取证，展开调查。</p>\n<p>核心提示：缅甸佤邦政府10月10日发表声明，回应泰国媒体&ldquo;中国船员遇袭是缅甸佤邦联合军所为&rdquo;报道。声明强调事件与佤邦联合军无关，称佤邦愿配合中国调查。佤邦建议执勤泰国警察接受中方调查。中国外交部则称泰警方已根据中方要求对现场取证，展开调查。</p>','Y',1,8,'缅甸 佤 邦 声明 未 杀害 中国 船员 核心 提示 缅甸 佤 邦政府 发表声明 回应 泰国 媒体 中国 船员 遇袭 缅甸 佤 邦联 联合 军 所为 报道 声明 强调 事件 佤 邦联 联合 军 无关 称 佤 邦 愿 配合 中国 调查 佤 邦 建议 执勤 泰国 警察 接受 中方 调查 中国外交 外交部 称 泰 警方 已 根据 中方 要求 现场 取证 展开 调查 核心 提示 缅甸 佤 邦政府 发表声明 回应 泰国 媒体 中国 船员 遇袭 缅甸 佤 邦联 联合 军 所为 报道 声明 强调 事件 佤 邦联 联合 军 无关 称 佤 邦 愿 配合 中国 调查 佤 邦 建议 执勤 泰国 警察 接受 中方 调查 中国外交 外交部 称 泰 警方 已 根据 中方 要求 现场 取证 展开 调查 核心 提示 缅甸 佤 邦政府 发表声明 回应 泰国 媒体 中国 船员 遇袭 缅甸 佤 邦联 联合 军 所为 报道 声明 强调 事件 佤 邦联 联合 军 无关 称 佤 邦 愿 配合 中国 调查 佤 邦 建议 执勤 泰国 警察 接受 中方 调查 中国外交 外交部 称 泰 警方 已 根据 中方 要求 现场 取证 展开 调查 核心 提示 缅甸 佤 邦政府 发表声明 回应 泰国 媒体 中国 船员 遇袭 缅甸 佤 邦联 联合 军 所为 报道 声明 强调 事件 佤 邦联 联合 军 无关 称 佤 邦 愿 配合 中国 调查 佤 邦 建议 执勤 泰国 警察 接受 中方 调查 中国外交 外交部 称 泰 警方 已 根据 中方 要求 现场 取证 展开 调查 ','../../upload/news/d9afbacb-51d4-4bc6-941c-1e8347491b71.jpg'),(8,1,'2011-10-13 20:18:30',1,'2011-10-19 20:25:31','f8a53f16-4c8d-40a2-9c76-fdb7b2cf9fab','01','四姑娘山14名违规登山驴友获救','<p>由上海、浙江、广东、湖北9名驴友、4名当地背夫和1名向导组织的队伍，于9月30日进入四川阿坝州四姑娘山景区海子沟从事露营活动后，13天内未能与外 界联系，当地亦派出多支搜救队进行营救。12日上午8时50分，搜救队发现了14名自四姑娘山向卧龙方向穿越的游客，并护送这支队伍安全下山。图为卧龙搜 寻队接驴友下山。中新社发 何晓安 摄</p>\n<p>&nbsp;</p>\n<p style=\"text-align: center;\"><img src=\"../../upload/news/e89920e8-5a9b-4b32-adbe-cdd529079454.jpg\" alt=\"\" width=\"680\" height=\"480\" /></p>','Y',1,3,'四姑娘山 名 违规 登山 驴 友 获救 由 上海 浙江 广东 湖北 名 驴 友 名 当地 背 夫 和 名 向导 组织 队伍 日进 进入 四川 阿坝州 四姑娘山 山景 景区 海子 沟 从事 露营 活动 后 天内 未能 能与 外 界 联系 当地 亦 派出 多 支 搜救 队 进行 行营 营救 上午 时 分 搜救 队 发现了 名 自 四姑娘山 向 卧龙 龙方 方向 穿越 游客 护送 这支 支队 队伍 安全 全下 下山 图为 卧龙 搜 寻 队 接 驴 友 下山 中新社 发 何 晓 安 摄 ',NULL),(9,1,'2011-10-13 20:20:52',1,'2011-10-19 20:25:27','0cb06d91-1bbd-4a93-af8c-7ce2be15d390','01','中方护航巡逻艇赴泰接应滞留船员 ','<p>新华网云南景洪10月13日电（记者李怀岩 陈杰）10月13日上午，在湄公河金三角水域遭袭船员的29名家属代表在工作人员的陪同下，从中老边境磨憨口岸出境前往泰国清盛。<strong><a href=\"http://app.travel.ifeng.com/city_detail_408\" target=\"_blank\">西双版纳</a>州公安局水上分局派出的巡逻艇也于13日从关累港出发，顺湄公河而下去接回尚滞留在泰国清盛码头的中方船只和船员。</strong></p>\n<p>据了解，目前，境外还有28艘船164名中国船员要求尽快在有安全保障的情况下回国。根据安排，除了遇袭的2艘船外，26艘船将于近日在巡逻艇的引领下通过湄公河返回中国。</p>\n<p>中国外交部发言人刘为民在12日的例行记者会上表示，外交部和云南省政府正协调泰国、缅甸、老挝政府，为中方滞留船只船员经湄公河水域回国提供安全保障，并为中方公安巡逻艇前往接应提供便利。</p>\n<p>为保证中方船员顺利回国，当地海事、边防、海关以及检验检疫部门已在关累港做好了充分的接收准备。另据了解，西双版纳州人民政府已安排外事、海事等 部门和船东一起，为继续留在云南景洪市等候消息的遇难者家属做好服务工作。景洪港专门为家属在江边指定祭奠亲人地点，还派专人负责遇难者家属的安全。</p>\n<p>据遇难者家属介绍，预计家属一行人于13日下午5时左右抵达事发地，随后将在遇难船只停靠的湄公河旁举行追思会，向死去的亲人表达哀思。泰国警方还将提取遇难者直系亲属DNA血样，之后，家属将到保存遇难者遗体的医院进行辨认。</p>\n<p>另据了解，经过协调，中国大地保险公司西双版纳中心子公司、中国人民财产保险股份有限公司景洪支公司已于12日分别在景洪市举行湄公河金三角水域遇 难商船船员保险赔款兑现会，大地保险公司对&ldquo;华平号&rdquo;遇难船员以每位13．33万元的赔付金额，向6位遇难船员家属进行赔付；人保财险有限公司对&ldquo;玉兴8 号&rdquo;遇难船员以每位10万元的赔付金额，向5位投保遇难船员的家属进行了赔付；两大保险公司共计赔付130万元。</p>\n<p>10月5日，&ldquo;华平号&rdquo;和&ldquo;玉兴8号&rdquo;两艘货船在湄公河水域遭不明身份武装人员劫持和袭击，已确认有12名中国船员遇难，1名中国船员失踪。</p>','N',1,2,'中方 护航 巡逻艇 赴 泰 接应 滞留 船员 新华网 云南 景洪 电 记者 李 怀 岩 陈 杰 上午 湄公河 金三角 水域 遭 袭 船员 名家 家属 代表 工作人员 陪同 同下 从中 老 边境 磨 憨 口岸 出境 前往 泰国 清盛 西双版纳 州 公安局 水上 分局 派出 巡逻艇 也 关 累 港 出发 顺 湄公河 而下去 去接 接回 尚 滞留 留在 泰国 清盛 码头 中方 船只 和 船员 据了解 目前 境外 还有 艘 船 名 中国 船员 要求 尽快 在有 安全 保障 情况下 下回 回国 根据 安排 除了 遇袭 艘 船 外 艘 船 将于 近日 巡逻艇 引领 下 通过 湄公河 返回 回中 中国 中国外交 外交部 部发 发言人 刘 为民 例行 记者会 会上 上表 表示 外交部 和 云南省 省政府 正 协调 泰国 缅甸 老挝 政府 为 中方 滞留 船只 船员 经 湄公河 河水 水域 回国 提供 安全 保障 并为 中方 公安 巡逻艇 前往 接应 应提 提供 便利 为 保证 中方 船员 顺利 回国 当地 海事 边防 海关 以及 检验 检疫 部门 已在 关 累 港 做好 好了 充分 接收 准备 另据 据了解 西双版纳州 人民政府 已 安排 排外 外事 海事 部门 和 船东 一起 为 继续 留在 云南 景洪市 等候 消息 遇难者 家属 做好 服务 务工 工作 景洪 港 专门 为 家属 江边 指定 祭奠 亲人 人地 地点 还派 专人 负责 遇难者 家属 安全 据 遇难者 家属 介绍 预计 家属 一行人 日下 下午 时 左右 抵达 事发 地 随后 将在 遇难 船只 停靠 湄公河 旁 举行 追思会 向 死去 亲人 表达 哀思 泰国 警方 还将 提取 遇难者 直系亲属 血样 之后 家属 将到 保存 遇难者 遗体 医院 进行 辨认 另据 据了解 经过 协调 中国 国大 大地 地保 保险公司 西双版纳 中心 心子 子公司 中国人民 财产保险 股份有限公司 景洪 支公司 已于 分别 别在 景洪市 举行 湄公河 金三角 水域 遇 难 商船 船员 保险 赔款 兑现 会 大地 地保 保险公司 华 平 号 遇难 船员 每位 万元 赔付 金额 向 位 遇难 船员 家属 进行 赔付 人保 财 险 有限公司 玉 兴 号 遇难 船员 每位 万元 赔付 金额 向 位 投保 遇难 船员 家属 进行了 赔付 两大 保险公司 共计 赔付 万元 华 平 号 和 玉 兴 号 两 艘 货船 湄公河 河水 水域 遭 不明 身份 武装人员 劫持 和 袭击 已 确认 认有 名 中国 船员 遇难 名 中国 船员 失踪 ',NULL),(10,1,'2011-10-13 20:23:41',1,'2011-10-19 20:25:20','f38661d6-1cb3-4e40-8057-de3e2a519980','01','北京至乌鲁木齐航班因疑似爆炸物迫降嘉峪关','<p>CNTV记者与嘉峪关机场取得联系，机场工作人员证实确实有一架航班迫降该处，原因是疑似有爆炸物，现在警方正在排查，但起因并不是乘客持刀，而是写了一个纸条，称货舱有爆炸物。</p>\n<p>现场网友称其他乘客都已下机，警察正在飞机上进行处置，其他乘客接受过二次安全检查后被带离现场。</p>','N',1,0,'北京 至 乌鲁木齐 航班 因 疑似 爆炸物 迫降 嘉峪关 记者 嘉峪关 关机 机场 取得联系 机场 工作人员 证实 确实有 一架 航班 迫降 该处 原因是 疑似 似有 爆炸物 现在 警方正 正在 排查 起因 并不是 乘客 持刀 而是 写了 一个 纸条 称 货舱 有 爆炸物 现场 网友 称 其他 乘客 客都 都已 下机 警察 正在 飞机 机上 上进 进行 处置 其他 乘客 接受 受过 二次 安全 检查 后 带 离 现场 ',NULL),(11,1,'2011-10-13 20:24:30',1,'2011-10-19 20:25:17','680a5b70-d367-4966-8d6f-eb976dd39f9e','01','二广高速公路襄荆段发生交通事故造成34人受伤','<p>中新网武汉10月13日电(廖琰璨)13日凌晨3时50分左右，一辆由北京开往<a href=\"http://app.travel.ifeng.com/city_detail_230\" target=\"_blank\">张家界</a>，牌号为湘G01572的大型卧铺客车行至二广高速公路二广向1738KM+800M处(荆门市沙洋县纪山镇付场村)时，由于左前胎爆胎，穿越中央隔离带，冲向对向车道后再次冲出路肩护栏，侧翻于高速公路旁排水渠边，造成34人受伤(其中重伤8人)的交通事故。</p>\n<p>凌晨4点17分，接到报警后，湖北省高警总队三支队公安大队立即启动高速公路重特大事故应急预案，并迅速向省公安厅和荆门、荆州市政府报告案情。</p>\n<p>事故车系牌号为&ldquo;湘G01572&rdquo;的大型卧铺客车，核载44人、实载49人；车属单位为湖南张家界市<a href=\"http://auto.ifeng.com/\" target=\"_blank\">汽车</a>运输公司直属第二分公司。该车于13日凌晨3点54分行驶至二广高速公路二广向1738KM+800M处时，由于左前胎爆胎，发生交通事故。上午8时左右，在各方努力下，所有受伤人员得到妥善安置，事故现场清理完毕，道路恢复畅通。</p>\n<p>事故发生后，湖北省委常委、政法委书记、公安厅厅长吴永文明确指示：&ldquo;全力抢救伤员，做好善后工作&rdquo;；湖北省副省长段轮一指示：&ldquo;要不惜一切代价抢救伤员&rdquo;。</p>\n<p>湖北省公安交管局局长马国宪迅速指派高警总队副总队长谢志华赶赴现场指导施救和善后处理工作。高警三支队、公安大队迅速启动了交通应急管理工作处置 预案，支队长韩平、大队长王国平带领民警第一时间赶至事故现场，与医疗、施救等部门一道迅速将伤者送至医疗部门进行救治、指挥事故处理工作。</p>\n<p>同时，荆门市以及沙洋县等相关部门负责人先后赶赴现场，组织指挥高警、路政、安监、消防、医疗、急救、施救等部门展开应急救援。其中，33名伤员就 近运至荆州各医院后，荆州市委、市政府高度重视，指示有关部门、医院全力救助伤员，协助开展事故处理。湖北省政府副秘书长文振富带领省安监局、省交通厅等 负责人赶赴荆州看望受伤群众</p>\n<p>截至发稿，善后处理工作正在进行。(完)</p>','N',1,1,'二 广 高速公路 襄 荆 段 发生 交通事故 造成 人 受伤 中新网 武汉 电 廖 琰 璨 凌晨 时 分 左右 一辆 由 北京 开往 张家界 牌号 号为 湘 大型 卧铺 客车 车行 行至 二 广 高速公路 二 广 向 处 荆门市 沙洋县 纪 山镇 付 场 村 时 由于 于左 左前 胎 爆 胎 穿越 中央 隔离带 冲向 向 车道 后 再次 冲出 出路 路肩 护栏 侧 翻 高速公路 路旁 排水渠 边 造成 人 受伤 其中 重伤 人 交通事故 凌晨 点 分 接到 报警 后 湖北省 高 警总 总队 三支 支队 公安 大队 立即 启动 高速公路 重特大 特大事故 应急 预案 迅速 向 省公安厅 和 荆门 荆州市 市政府 报告 案情 事故 车 系 牌号 号为 湘 大型 卧铺 客车 核 载 人 实 载 人 车 属 单位 为 湖南 张家界市 汽车 运输 公司 直属 第二 二分 分公司 该车 凌晨 点 分行 行驶 至 二 广 高速公路 二 广 向 处 时 由于 于左 左前 胎 爆 胎 发生 交通事故 上午 时 左右 各方 努力 下 所有 受伤 伤人 人员 得到 妥善安置 事故现场 清理 理完 完毕 道路 恢复 畅通 事故 发生后 湖北省 省委常委 政法委 书记 公安厅 厅长 吴 永 文明 明确 指示 全力 抢救 伤员 做好 善后工作 湖北省 副省长 段 轮 一指 指示 要不 不惜一切代价 抢救 伤员 湖北省 公安 交管局 局局长 马国 宪 迅速 指派 高 警总 总队 队副 副总 总队长 谢 志 华 赶赴现场 指导 施救 和善 善后处理 处理工作 高 警 三支 支队 公安 大队 迅速 启动 动了 交通 应急 管理工作 工作处 处置 预案 支队长 韩 平 大队长 王国平 带领 民警 第一时间 赶 至 事故现场 医疗 施救 部门 一道 迅速 速将 伤者 送至 医疗 部门 进行 救治 指挥 事故 处理工作 同时 荆门市 以及 沙洋县 相关 部门 负责人 先后 赶赴现场 组织指挥 高 警 路政 安 监 消防 医疗 急救 施救 部门 展开 应急 急救 救援 其中 名 伤员 近 运至 荆州 各 医院 后 荆州市 市委 市政府 高度重视 指示 有关部门 医院 全力 救助 伤员 协助 开展 事故 处理 湖北省 省政府 副秘书长 长文 振 富 带领 省 安监局 省 交通厅 负责人 赶赴 荆州 看望 受伤 群众 截至 发稿 善后处理 处理工作 正在进行 完 ',NULL),(12,1,'2011-10-13 20:25:10',1,'2011-10-19 20:25:13','bebe578e-09a0-4851-8ee8-46286675be2b','01','美国国防部证实在巴基斯坦采取了秘密军事行动','<p>人民网10月13日电 美国国防部长帕内特表示，美国和巴基斯坦的关系很复杂，也很困难，原因是多方面的，但其中之一是美国在巴基斯坦境内采取了秘密军事行动。</p>\n<p>中东&ldquo;门网&rdquo;今天报道说，美国政府一直否认在巴基斯坦境内采取过秘密军事行动，而美国国防部长本月11日一反过去的立场，证实美国确实在巴基斯坦境 内进行过秘密军事行动。报道引用美国国防部长帕内特的话说，&ldquo;我们和巴基斯坦的关系很复杂，也很紧张，其中一个很重要的原因是，我们在巴基斯坦境内秘密采 取了军事行动。&rdquo;</p>\n<p>报道说，上周，帕内特曾视察北约设在在意大利那不勒斯的军事基地，当时他也曾谈到了美国在巴基斯坦采取秘密军事行动问题。他表示，&ldquo;担任国防部长 后，无疑我手中掌握的武器要比我任中央情报局长时多很多。我任中央情报局长时，无人机肯定是不错的武器。&rdquo;报道评论说，帕内特实际是暗示他任中央情报局长 时曾在巴基斯坦境内秘密起降过无人机。</p>\n<p>中东&ldquo;门网&rdquo;指出，今年初以来，美国中央情报局至少使用无人机在巴基斯坦偏远部落地区进行了60次军事打击。巴基斯坦多次对美国的行动进行谴责，但一直否认美国无人机是从巴基斯坦境内起降，认为是从阿富汗起飞进入巴境内的。（安国章）</p>','N',1,4,'美国 国防部 证实 实在 巴基斯坦 采取 取了 秘密 军事行动 人民网 电 美国 国防部长 帕 内 特 表示 美国 和 巴基斯坦 关系 复杂 也 很困 困难 原因是 多方面 面的 其中之一 一是 美国 巴基斯坦 境内 采取 取了 秘密 军事行动 中东 门 网 今天 报道说 美国政府 一直 否认 巴基斯坦 境内 采取 过 秘密 军事行动 美国 国防部长 本月 一 反过 过去 立场 证实 美国 确实在 巴基斯坦 境 内 进行 过 秘密 军事行动 报道 引用 美国 国防部长 帕 内 特 的话 话说 我们 和 巴基斯坦 关系 复杂 也 很紧 紧张 其中 中一 一个 很重 重要 原因是 我们 巴基斯坦 境内 秘密 采 取了 军事行动 报道说 上周 帕 内 特 曾 视察 北约 设在 在在 在意 意大利 那不勒斯 军事基地 当时 他 也 曾 谈到 到了 美国 巴基斯坦 采取 秘密 军事行动 动问 问题 他 表示 担任 国防部长 后 无疑 我 手中 掌握 武器 要比 比我 任 中央情报局 局长 时 多 很多 我 任 中央情报局 局长 时 无人机 肯定是 不错 武器 报道 评论 论说 帕 内 特 实际 暗示 他 任 中央情报局 局长 时 曾在 巴基斯坦 境内 秘密 起降 过 无人机 中东 门 网 指出 今年初 以来 美国中央情报局 至少 使用 无人机 巴基斯坦 偏远 部落 落地 地区 进行了 次 军事 打击 巴基斯坦 多次 美国 行动 进行 谴责 一直 否认 美国 无人机 巴基斯坦 境内 起降 认为是 阿富汗 起飞 飞进 进入 巴 境内 安国 章 ',NULL),(13,1,'2011-10-14 18:40:59',1,'2011-10-19 20:25:07','81f3ffdd-cfa1-4ebf-a519-554a4426bd31','01','中国飞豹战机表演时坠毁','<p>核心提示：10月14日上午，2011中国国际通用航空大会在陕西蒲城举行飞行表演时，一架飞豹战机出现意外坠机，飞行员座舱成功弹出，未见降落伞打开，飞机坠落后起火，目前消防和救护人员已赶往现场救援，人员伤亡不详。</p>','N',1,1,'中国 飞 豹 战机 表演 时 坠毁 核心 提示 上午 中国国际 通用 航空 空大 大会 会在 陕西 蒲城 举行 飞行 表演 时 一架 飞 豹 战机 出现意外 坠机 飞行员 座舱 成功 弹出 未见 降落伞 打开 飞机 坠落 落后 后起 起火 目前 消防 和 救护 护人 人员 已 赶往 现场 救援 人员伤亡 不详 ',NULL),(14,1,'2011-10-14 18:41:28',1,'2011-10-19 20:25:04','fb5cf5af-61bb-495f-9e33-8fe96fe13b1a','01','温州警方将控制有债务危机企业主','<p>核心提示：针对当前温州因企业资金链断裂、民间非法集资引发的问题，温州警方日前推出10项措施。对有债务危机且有出逃迹象企业主，公安机关将有效控制，对已经出逃的企业主，将组织力量进行全力追逃。另查处了80多名暴力讨债不法分子，刑拘了27名非法集资者。</p>','N',1,2,'温州 警方 将 控制 有 债务 危机 企业主 核心 提示 针对 当前 温州 因 企业 资金 金链 链断裂 民间 非法 集资 引发 问题 温州 警方 日前 推出 项 措施 有 债务 危机 且有 出逃 迹象 企业主 公安机关 将有 有效 控制 已经 出逃 企业主 将 组织 力量 进行 全力 追 逃 另 查处 处了 多名 暴力 讨债 不法分子 刑拘 名 非法 集资 者 ',NULL),(15,1,'2011-10-14 18:41:51',1,'2012-05-06 22:00:14','6dbbe0ed-ebdd-412e-9652-ec7e40c0383e','01','奥巴马称将对伊朗施以最严厉制裁','<p>核心提示：美国总统奥巴马10月13日表示，伊朗必须为其策划刺杀沙特驻美大使的阴谋付出代价，美国将对伊朗实施&ldquo;最严厉&rdquo;的制裁。美司法部11日宣布挫败一起企图暗杀沙特驻美国大使的阴谋，一名伊朗伊斯兰革命卫队成员及一名拥有美国和伊朗双重国籍的美国公民遭起诉。</p>','N',1,2,'奥 巴马 称 将对 伊朗 施以 最 严厉 制裁 核心 提示 美国总统 奥 巴马 日表 表示 伊朗 必须 为 其 策划 刺杀 沙特 驻 美 大使 阴谋 付出代价 美国 将对 伊朗 实施 最 严厉 制裁 美 司法部 宣布 挫败 一起 企图 暗杀 沙特 驻 美国 国大 大使 阴谋 一名 伊朗 伊斯兰 革命 卫队 成员 一名 拥有 美国 和 伊朗 双重国籍 美国公民 遭 起诉 ',NULL),(16,1,'2011-10-14 18:46:02',1,'2011-12-19 20:36:26','9d657db4-a8e6-4d25-a29f-27c27448edee','02','空客向南航交付首架A380飞机 可搭载800人','<p>核心提示：10月14日，欧洲空客公司在法国图卢兹工厂正式向中国南方航空交付首架A380飞机。A380是目前全世界最大的远程宽体客机，最多可搭载800多名乘客。</p>\n<p>&nbsp;</p>\n<p style=\"text-align: center;\"><img src=\"../../upload/news/b4401729-9c4a-44aa-8130-f906486abbf5.jpg\" alt=\"\" width=\"550\" height=\"357\" /></p>','Y',1,0,'空客 向南 南航 交付 首架 飞机 可 搭载 人 核心 提示 欧洲 空客 公司 法国 国图 图卢 兹 工厂 正式 向 中国南方 航空 交付 首架 飞机 目前 全世界 最大 远程 宽体 客机 最多 可 搭载 多名 乘客 ','../../upload/news/b4401729-9c4a-44aa-8130-f906486abbf5.jpg'),(17,1,'2011-10-14 18:50:20',1,'2011-10-19 20:24:40','486dc60d-ad18-438c-9e46-d43b225c9726','03','9月CPI同比上涨6.1% 增速连续两月下滑','<p>核心提示：据国家统计局网站消息，2011年9月份，全国居民消费价格总水平同比上涨6.1%，增速连续两个月下滑。其中，食品价格同比上涨13.4%，鲜菜和鲜果价格环比涨幅分别为5.2%和3.1%。</p>','N',1,0,'同比 比上 上涨 增速 连续 两月 月下 下滑 核心 提示 据 国家统计局 网站 消息 月份 全国 居民消费 价格 总 水平 同比 比上 上涨 增速 连续 两个月 月下 下滑 其中 食品 价格 同比 比上 上涨 鲜菜 和 鲜果 价格 环 涨幅 分别为 和 ',NULL),(18,1,'2011-10-14 18:50:44',1,'2011-10-19 20:24:37','09a89905-bb64-4b66-a63c-d0a46bf74625','03','淘宝设购买限制对付小卖家攻击','<p>核心提示：近日，淘宝商城因提高准入门槛引发小卖家围攻大卖家事件。为此，淘宝方面已出台措施，包括调整库存、限制买家等级、锁定阿里旺旺等方式遏制小卖家的恶意购买行为。从昨天晚上开始，淘宝商城内小卖家们的&ldquo;攻击&rdquo;开始减弱。</p>','N',1,0,'淘宝 设 购买 限制 对付 小卖 卖家 攻击 核心 提示 近日 淘宝 商城 因 提高 准入 入门 门槛 引发 小卖 卖家 围攻 大 卖家 家事 事件 为此 淘宝 方面 已 出台 措施 包括 调整 库存 限制 买家 等级 锁定 阿里 旺旺 方式 遏制 小卖 卖家 恶意 购买 行为 昨天晚上 开始 淘宝 商城 城内 小卖 卖家 们 攻击 开始 减弱 ',NULL),(19,1,'2011-10-14 18:51:18',1,'2011-10-19 20:24:33','a796b5e7-361b-472c-9151-de20845ce64f','03','北京至乌鲁木齐航班因爆炸威胁备降','<p>核心提示：10月13日17时，由北京飞往乌鲁木齐的KN2273次航班上一名女子扬言飞机上有爆炸物，导致飞机在嘉峪关机场紧急备降，经检查，机上未发现可疑物品。经初步审查，该女子叫王某某，因感情因素导致情绪失常，谎称飞机有爆炸物，目前已被公安机关控制。</p>','N',1,0,'北京 至 乌鲁木齐 航班 因 爆炸 威胁 备 降 核心 提示 时 由 北京 飞往 乌鲁木齐 次 航班 班上 一名 女子 扬言 飞机 机上 上有 爆炸物 导致 飞机 嘉峪关 关机 机场 紧急 备 降 经 检查 机上 未发 发现 可疑 物品 经 初步 审查 该 女子 叫 王 某某 因 感情 因素 导致 情绪 失常 谎称 飞机 有 爆炸物 目前 已被 公安机关 控制 ',NULL),(20,1,'2011-10-14 18:51:37',1,'2011-10-19 20:24:31','fd52df65-c706-4169-9163-a1eb7ccd8d2a','03','内蒙古鄂尔多斯房产商疑因无法偿债自杀','<p>核心提示：9月24日，内蒙古鄂尔多斯一家地产公司法人王福金自杀身亡，该公司最大股东外逃，警方正在进行追捕。该公司曾向373家个人及单位举债 2.63亿元，有债权人称其给该公司的利息为3分，而王福金自杀前遭多位债权人催债。据媒体报道，王福金曾任当地法院院长，其后退休。</p>','N',1,0,'内蒙古 鄂尔多斯 房产商 疑 因 无法 偿债 自杀 核心 提示 内蒙古 鄂尔多斯 一家 地产 公司法人 王 福 金 自杀身亡 该公司 最大 大股东 外逃 警方正 正在进行 追捕 该公司 曾向 家 个人 单位 举债 亿元 有 债权人 人称 其 该公司 利息 为 分 王 福 金 自杀 前 遭 多位 债权人 催债 据 媒体报道 王 福 金 曾任 当地 法院院长 其后 后退 退休 ',NULL),(21,1,'2011-10-14 18:51:58',1,'2011-10-14 18:52:01','5f294b85-a474-4729-b8a8-dceffee3638a','03','日本拟与东盟签署“海洋安保宣言”牵制中国','<p>核心提示：据日媒报道，日本将与东盟在定于今年11月召开的首脑峰会上再次发表联合声明。声明的主要内容将包括日本与东盟就海上安全保障问题加强合作，共同戒备中国日益频繁的海洋活动。</p>','N',1,0,NULL,NULL),(22,1,'2011-10-14 18:52:19',1,'2011-10-19 20:24:25','b7e9b526-9aa8-4711-a09c-4740d7d4fdef','03','法航空难前录音曝光 驾驶员惊慌大叫','<p>核心提示：法国日前公布了2009年6月1日法航447号航班坠落大西洋前飞行员的一段录音，其中一位驾驶员大喊：&ldquo;天哪！我们要坠毁了，这不可能是真 的！&rdquo;另一位飞行员紧接着说：&ldquo;发生了什么？&rdquo;公布的录音到这里戛然而止。多方猜测认为，飞行员玩忽职守是这次空难的主因。</p>','N',1,0,'法航 航空 空难 前 录音 曝光 驾驶员 惊慌 大叫 核心 提示 法国 日前 公布 法航 号 航班 坠落 大西洋 前 飞行员 一段 录音 其中 中一 一位 驾驶员 大喊 天哪 我们 要 坠毁 毁了 这不 不可能 可能是 真 另一位 飞行员 紧接着 说 发生 生了 什么 公布 录音 到 这里 戛然而止 多方 猜测 认为 飞行员 玩忽职守 这次 空难 主因 ',NULL),(23,1,'2011-10-14 18:53:01',1,'2011-10-19 20:24:21','02e7bad4-8a59-4c68-9d00-378ebc2c6521','03','张柏芝新单曲MV20日全球首发 自称特别像女强人','<p>张柏芝新歌《曾经》的MV将在20日全球首发。这次，张柏芝不再只是演员，而是首次以导演、编剧及造型师的身份全程参与创作和拍摄。昨日，张柏芝揭秘了MV拍摄的台前幕后。她坦言，&ldquo;我很享受这次拍摄的过程，我觉得在现场的时候，自己特别像个女强人。&rdquo;</p>','N',1,0,'张柏芝 新 单曲 全球 首发 自称 特别 别像 女强人 张柏芝 新歌 曾经 将在 全球 首发 这次 张柏芝 不再 只是 演员 而是 首次 导演 编剧 造型 师 身份 全程 参与 创作 作和 拍摄 昨日 张柏芝 揭秘 拍摄 台前幕后 她 坦言 我 享受 这次 拍摄 过程 我 觉得 现场 时候 自己 特别 别像 像个 女强人 ',NULL),(24,1,'2011-10-14 18:53:34',1,'2011-10-19 20:24:18','09de0fdc-f7a0-49f7-b273-05025c3e3f24','03','黑龙江省地震局启动应急响应','<p>据国家<a title=\"地震\" href=\"http://news.163.com/special/rbdblhddz/\" target=\"_blank\">地震</a>台 网测定，北京时间2011年10月14日14时10分，在俄罗斯阿穆尔州发生6.6级地震，震中距离我国最近边境线约75公里，距漠河县城约160公里。 据了解，震中位于阿穆尔州西部地区，距离最近的城镇斯科沃罗季诺约20公里，距离州首府布拉戈维申斯克（海兰泡）约500公里，震中地区人口稀少，目前尚 无人员伤亡和财产损失的报道。</p>','N',1,1,'黑龙江省 省地 地震局 启动 应急 响应 据 国家 地震 地震 台 网 测定 北京时间 时 分 俄罗斯 阿穆尔 州 发生 级 地震 震中 中距离 离我 我国 最近 边境线 约 公里 距 漠河县 县城 约 公里 据了解 震中 位于 阿穆尔 州 西部地区 距离 最近 城镇 斯 科 沃 罗 季 诺 约 公里 距离 州 首府 布拉 戈 维 申 斯 克 海 兰 泡 约 公里 震中 地区 人口 稀少 目前 尚 无人 人员伤亡 和 财产损失 报道 ',NULL),(25,1,'2011-10-14 18:53:54',1,'2011-10-19 20:24:07','ddf200bf-c7bd-499b-bb8b-ac6c6c8b6ac4','03','失事飞豹扎入沼泽 专家称疑为飞控系统故障','<p>核心提示：有军事专家指出，飞豹战机安装两台稳定、可靠性好的斯贝仿制型发动机，之前保证了1600架次定型试飞，因此发动机技术相对稳定，尤其是单台发动机既然有故障也不至于失速坠毁，而两台发动机同时故障的几率几乎是不可能的，所以推断是飞控系统故障的可能性较大。</p>','N',1,0,'失事 飞 豹 扎入 沼泽 专家 称 疑为 飞 控 系统故障 核心 提示 有 军事 专家 指出 飞 豹 战机 安装 两台 稳定 可靠性 好 斯 贝 仿制 型 发动机 之前 保证 架次 定型 试飞 因此 发动机 技术 相对 稳定 尤其是 单 台 发动机 既然 有 故障 也 不至于 失速 坠毁 两台 发动机 同时 故障 几率 几乎是 不可能 所以 推断 飞 控 系统故障 可能性 较大 ',NULL),(26,1,'2011-10-14 18:54:17',1,'2011-10-19 20:24:11','98583fe8-2e1e-4f07-a69e-e18929d0eafa','03','美军高官表示F-35战机计划面临大幅度削减','<p>据中国国防科技信息网报道 美军军方的最高官员上周四说，F-35联合攻击机计划面临大幅削减。</p>\n<p>参谋长联席会议主席陆军参谋长马丁 登普西将军说，开发建造三个版本的高技术联合攻击机使得国防部财政紧张。</p>\n<p>登普西和国防部长利昂 帕内塔一起出席了众议院军事委员会。</p>\n<p>正在建造的F-35有三个版本，包括空军用(F-35A)、两栖舰载的短距起飞和垂直降落飞机(F-35B)和航母舰载机(F-35C)。</p>\n<p>五角大楼最大的武器计划问题一直被延误和成本超支困扰。原计划飞行16000小时，现在仅飞行1500小时后，飞机的一个版本就出现了舱壁裂缝。</p>\n<p>登普西说，他正致力于开发第五代战斗机，但质疑美国是否能负担得起所有三个版本的F-35联合攻击机。</p>','N',1,0,'美军 高官 表示 战机 计划 面临 大幅度 削减 据 中国国防 国防科技 科技信息 信息网 报道 美军 军方 最高 高官 官员 上周 周四 说 联合 攻击机 计划 面临 大幅 削减 参谋长 联席会议 主席 陆军 参谋长 马丁 登 普 西 将军 说 开发 建造 三个 版本 高技术 联合 攻击机 使得 国防部 财政 紧张 登 普 西和 国防部长 利昂 帕 内 塔 一起 出席 众议院 军事委员会 正在 在建 建造 有 三个 版本 包括 空军 军用 两栖舰 舰载 短距 起飞 和 垂直 降落 飞机 和 航母 母舰 舰载机 五角大楼 最大 武器 计划 问题 一直 延误 和 成本 超支 困扰 原计划 飞行 小时 现在 仅 飞行 小时 后 飞机 一个 版本 本就 就出 出现 舱 壁 裂缝 登 普 西 说 他 正 致力于 开发 第五代 战斗机 质疑 美国 国是 是否能 负担得起 所有 三个 版本 联合 攻击机 ',NULL),(27,1,'2011-10-14 18:54:40',1,'2011-10-19 20:26:23','22a18be2-b3ca-4263-b9ab-187a2b7200cd','03','澳报分析：中国迅速崛起 但却战略影响力有限','<p>核心提示：有趣的是，为什么一个经济如此强大的中国，却不能对地区国家产生强大的战略影响力。这只能归结于，中国令人吃惊地未能将经济规模转化成政治优势。这正是中国的GDP和出色的贸易数字造成的误导。</p>','N',1,1,'澳 报分 分析 中国 迅速 崛起 但却 战略 影响力 有限 核心 提示 有趣 为什么 一个 经济 如此 强大 中国 却不能 能对 对地 地区 国家 家产 产生 强大 战略 影响力 这只 只能 归结 中国 令人吃惊 地 未能 能将 经济 规模 转化成 政治 优势 这正是 中国 和 出色 贸易 数字 造成 误导 ',NULL),(28,1,'2011-10-14 18:55:39',1,'2011-10-19 20:26:19','2a215d80-816b-48dd-b7a5-52465f0db334','02','四川泸州吸毒男子抢佩枪致民警1死1伤被判死缓','<p>中新网成都10月14日电 14日记者从四川省高级人民法院获悉，今年5月，泸州市中院以抢夺枪支罪判处何广彬死刑，缓期2年执行。随后，何广彬以一审量刑过重提起上诉。四川省高级人民法院日前对此案做出了维持原判的终审裁定。</p>\n<p>据 了解，今年26岁的何广彬是泸县太伏镇双石村村民，事发前在成都务工。去年5月1日，何广彬从成都回到泸州，5月4日晚，一家三口住进了当地一家宾馆。其 妻罗某回忆，5月5日19时许，她听见何广彬用手机打电话叫一个&ldquo;二哥&rdquo;的人送了几百元的&ldquo;麻麻儿&rdquo;(麻古丸)来吃。罗某睡后不久听见有人敲门，打开门 后，发现房间门口站着民警问是谁报警，何广彬便对民警说是他报的警，声称有人要杀他，于是民警就将何广彬夫妇俩及儿子带到了泸州市江阳区公安分局南城派出 所。在派出所里，何广彬表现得十分异常，一直坚称有人要杀他。随后，派出所民警对其进行了强制尿检。在派出所等候处理期间，何广彬趁民警不备逃离南城派出 所。</p>\n<p>逃离派出所后，何广彬于5月6日凌晨4时许来到江阳区新二村9号楼，并不停用木棒挨家挨户敲击住户的门，声称有人要杀自己，让住户开门 让其进去。在敲击三楼住户的门时，三楼住户十分害怕，并一直劝说何广彬离开，但何广彬始终不肯离开，后三楼住户报警。泸州市公安局110指挥中心接到群众 报警，称一男子手持木棒击打房门，陈玥和杨文武前往处警，在与犯罪嫌疑人何广彬搏斗中，何广彬抢走民警的手枪，并在抢夺过程中致枪走火射向民警，致使民警 陈玥因抢救无效死亡。</p>','N',1,1,'四川 泸州 吸毒 男子 抢 佩枪 致 民警 死 伤 被判 死缓 中新网 成都 电 日记 记者 四川省 高级人民法院 获悉 今年 泸州市 中院 抢夺 枪支罪 判处 何 广 彬 死刑 缓期 执行 随后 何 广 彬 一审 量刑 过重 重提 提起 上诉 四川省 高级人民法院 日前 对此 此案 做出 出了 维持原判 终审 裁定 据 了解 今年 岁 何 广 彬 泸县 太 伏 镇 双 石 村村 村民 事发 前 成都 务工 去年 何 广 彬 成都 都回 回到 泸州 晚 一家 三口 住进 进了 了当 当地 一家 宾馆 其 妻 罗 某 回忆 时 许 她 听见 何 广 彬 用手 手机 打电话 叫 一个 二哥 的人 送了 几百元 麻 麻 儿 麻 古 丸 来吃 罗 某 睡 后 不久 听见 有人 敲门 打开门 后 发现 现房 房间 门口 站着 民警 问 谁 报警 何 广 彬 便 民警 说是 他 报 警 声称 有人 要杀 他 于是 民警 就将 何 广 彬 夫妇俩 儿子 带到 到了 泸州市 江阳区 公安分局 南城 派出 所 派出所 所里 何 广 彬 表现 得 十分 异常 一直 坚称 有人 要杀 他 随后 派出所 民警 其 进行了 强制 尿检 派出所 等候 处理 期间 何 广 彬 趁 民警 不备 逃离 南城 派出 所 逃离 派出所 后 何 广 彬 凌晨 时 许 来到 江阳区 新 二 村 号 楼 并不 不停 停用 木棒 挨家挨户 敲击 住户 门 声称 有人 要杀 自己 住户 开门 其 进去 敲击 三楼住户 门 时 三楼住户 十分 害怕 一直 劝说 何 广 彬 离开 何 广 彬 始终 不肯 离开 后 三楼住户 报警 泸州市 公安局 指挥中心 接到 群众 报警 称 一男 男子 手持 木棒 击打 房门 陈 玥 和 杨文 文武 前往 处警 犯罪嫌疑人 何 广 彬 搏斗 中 何 广 彬 抢走 民警 手枪 并在 抢夺 夺过 过程中 致 枪 走火 射向 民警 致使 民警 陈 玥 因 抢救无效 效死 死亡 ',NULL),(29,1,'2011-10-14 18:58:48',1,'2011-10-19 20:24:04','f8e5f4f8-2d76-4122-a26d-0dafd1e8e1c3','02','美国会拟削减近万亿美元军费 防长称此举愚蠢','<p>核心提示：美国国会削减预算开支可能将导致军费削减近1万亿美元。据新加坡《联合早报》报道，美国国防部长帕内塔对此强调，削减军费不能以削减军力为代价。他也提到，美军未来不可能再打传统的战役，而需要准备好应付高技术的武器装备带来的新威胁。</p>','N',1,3,'美国会 拟 削减 近 万亿 美元 军费 防 长 称 此举 愚蠢 核心 提示 美国国会 削减 预算 开支 可能 能将 导致 军费 削减 近 万亿 美元 据 新加坡 联合早报 报道 美国 国防部长 帕 内 塔 对此 强调 削减 军费 不能 能以 削减 军力 为 代价 他 也 提到 美军 未来 不可能 可能再 再打 传统 战役 需要 准备好 应付 高技术 武器装备 带来 新 威胁 ',NULL),(30,1,'2011-10-14 18:59:12',1,'2011-10-19 20:24:01','4727cab9-e432-43cf-97b6-4a4a4b430b7c','02','郑州将定向考录退役大学生士兵为公务员','<p>新华网郑州10月14日电 郑州市日前出台征兵及退役士兵安置新举措，明确将加大退役士兵安置力度，将安排一定比例的公务员、全供事业单位用人指标定向考录退役大学生士兵，以鼓励高校毕业生应征入伍。</p>\n<p>郑州市委、市政府、警备区联合下发的《关于进一步做好新形势下征兵工作的实施意见》中规定，自2013年起，对郑州市接收的大学毕业生 退役士兵，全市每年安排一定比例的公务员和全供事业单位的岗位进行定向考录；省市两级政法队伍招录干警时，安排不低于当年符合条件的退役大学生士兵人数的 5％，事业单位招聘时，安排不低于当年符合条件的退役大学生士兵人数的10％，市属国有企业招聘时，安排不低于当年符合条件的退役大学生士兵人数的 15％，定向招聘退役大学生士兵。退役大学生士兵参加公务员定向考录和企事业单位招聘时，视同普通高等学校毕业生办理手续，服役期视为工作经历，计算工 龄。非郑州籍退役大学生士兵复学完成学业且被郑州市用人单位接收的，可办理进郑州落户手续。</p>','N',1,0,'郑州 将定 定向 考 录 退役 大学生 士兵 为 公务员 新华网 郑州 电 郑州市 日前 出台 征兵 退役 士兵 安置 新举措 明确 将 加大 退役 士兵 安置 力度 将 安排 一定 比例 公务员 全 供事 事业单位 用人 指标 标定 定向 考 录 退役 大学生 士兵 鼓励 高校 毕业生 应征入伍 郑州市 市委 市政府 警备区 联合 下发 关于 进一步 做好 新形势下 征兵 兵工 工作 实施 意见 中 规定 自 起 郑州市 接收 大学毕业 毕业生 退役 士兵 全市 每年 安排 一定 比例 公务员 和 全 供事 事业单位 岗位 进行 定向 考 录 省市 市两 两级 政法队伍 招录 干警 时 安排 不低于 当年 符合 条件 退役 大学生 士兵 人数 事业单位 招聘 时 安排 不低于 当年 符合 条件 退役 大学生 士兵 人数 市属 属国 国有企业 招聘 时 安排 不低于 当年 符合 条件 退役 大学生 士兵 人数 定向 招聘 退役 大学生 士兵 退役 大学生 士兵 参加 公务员 定向 考 录 和 企事业单位 招聘 时 视同 普通 高等学校 毕业生 办理手续 服役期 视为 工作经历 计算 工 龄 非 郑州 籍 退役 大学生 士兵 复学 完成学业 且 郑州市 用人单位 接收 可 办理 进 郑州 落户 手续 ',NULL),(31,1,'2011-10-14 18:59:43',1,'2011-10-19 20:23:58','cb6ae189-5a7d-4355-8892-a4f6f15c390a','02','回良玉：汶川震区重建目标实现 生活超灾前水平','<p>中新社北京10月14日电 中央政治局委员、国务院副总理回良玉14日表示，汶川<a title=\"地震\" href=\"http://news.163.com/special/rbdblhddz/\" target=\"_blank\">地震</a>灾区基本生产<a title=\"生活\" href=\"http://tuan.163.com/?tag=%E7%94%9F%E6%B4%BB\">生活</a>条件和经济社会发展水平目前已得到全面恢复并超过灾前水平，实现了&ldquo;家家有房住、户户有就业、人人有保障、设施有提高、经济有发展、生态有改善&rdquo;的重建目标。</p>\n<p>汶川地震灾后恢复重建总结表彰大会14日在京召开，200个先进集体、295名先进个人受到表彰。</p>\n<p>回良玉在会议上指出，汶川地震灾后恢复重建，是人类救灾史上罕见的浩大工程。经过三年恢复重建，灾区生活条件实现了大变样。一个安居乐业、生态文明、安全和谐的新家园已呈现在世人眼前。</p>','N',1,1,'回良玉 汶川 震区 重建 目标 实现 生活 超 灾 前 水平 中新社 北京 电 中央政治局委员 国务院副总理 回良玉 日表 表示 汶川 地震 地震 灾区 基本生产 生活 生活 条件 和 经济社会 社会发展 发展水平 目前 已得到 全面 恢复 超过 灾 前 水平 实现 家家 家有 有房住 户户 有 就业 人人 有 保障 设施 有 提高 经济 有 发展 生态 有 改善 重建 目标 汶川 地震 震灾 后 恢复 重建 总结 表彰大会 在京 召开 个 先进集体 名 先进个人 受到 表彰 回良玉 会议 上 指出 汶川 地震 震灾 后 恢复 重建 人类 救灾 史上 罕见 浩大 大工 工程 经过 三年 恢复 重建 灾区 生活条件 实现 大变样 一个 安居乐业 生态 文明 安全 和谐 新家园 已 呈现 现在 在世 世人 眼前 ',NULL),(32,1,'2011-10-14 19:00:12',1,'2011-10-19 20:23:55','e936353c-af57-4307-a2f1-d5a025ab8063','02','美拟放宽武器出口限制 中国或重获\"黑鹰\"','<p>据美国华盛顿时报10月12日报道，奥巴马政府日前通知国会，正在计划放宽对UH-60&ldquo;黑鹰&rdquo;直升机以及其他武器(可能包括C-130运输机，甚至还包括F-16战机)的外销限制，美媒还成，&ldquo;黑鹰&rdquo;直升机一直是&ldquo;中国军队希望得到的&rdquo;。</p>\n<p>美媒称，奥巴马政府日前表示，作为出口控制努力的一部分，他们正在对归属美国国务院进出口管辖权限的美国军火清单上的数千种武器进行审查。作为审查的一部分，美国政府已经确定了多款可以移至商务部较宽松控制清单上的武器，这其中包括直升机以及军用运输机。</p>\n<p>而且，据一位国会议员助理透露，放宽对F-16战机的销售限制也在考虑之中。他们还表示，解除管制计划将会安排监视这些系统的使用情以判断它们是否被转销至伊朗等国。</p>','N',1,5,'美 拟 放宽 武器 出口 限制 中国 重获 黑鹰 据 美国 国华 华盛顿 顿时 时报 日报 报道 奥 巴马 政府 日前 通知 国会 正在 计划 放宽 黑鹰 直升机 以及 及其 其他 武器 可能 包括 运输机 甚至 包括 战机 外销 限制 美 媒 成 黑鹰 直升机 一直是 中国军队 希望 得到 美 媒 称 奥 巴马 政府 日前 表示 作为 出口 控制 努力 一部分 他们 正在 在对 归属 美国 国务院 进出口 管辖权 权限 美国 国军 军火 清单 上 数千 种 武器 进行 审查 作为 审查 一部分 美国政府 已经 确定 多款 可以 移至 商务部 较宽 宽松 控制 清单 上 武器 这 其中 包括 直升机 以及 军用 运输机 而且 据 一位 国会议员 助理 透露 放宽 战机 销售 限制 也 考虑 之中 他们 表示 解除管制 计划 将会 安排 监视 这些 系统 使用 用情 判断 它们 是否 转销 至 伊朗 国 ',NULL),(33,1,'2011-10-14 19:01:12',1,'2011-12-19 20:35:57','e28dbf61-f2d2-4153-bb5e-3943b20c0060','02','南非摄影师追逐闪电16年拍摄壮观场面(图)','<p>国际在线专稿：据英国《每日邮报》10月13日报道，南非摄影师米切尔&middot;克罗格（Mitchell  Krog）在过去16年间冒着生命危险，在荒芜的南非马加利斯堡地区（Magaliesburg）拍摄了许多闪电疾光电影的壮观场面。有时候，他甚至不顾 及自己的生命，站在致命闪电附近的区域，以抓拍大自然的狂暴一面。</p>\n<p>报道称，克罗格自孩提时代就对南非广阔平原上的雷暴现象着迷。现年39岁的他已经拍摄闪电16年。他给自己的<a title=\"照片\" href=\"http://mall.163.com/yxp.html\">照片</a>起了许多名字，包括&ldquo;火与冰&rdquo;、&ldquo;杀人雷暴&rdquo;等。一张名为&ldquo;不朽混乱&rdquo;的杰作上，他拍摄到三次闪电同时发生的场景。</p>\n<p>克罗格说：&ldquo;我不怕闪电，我会尽可能近地贴近它们，甚至会站在闪电直接通过的路径上。从小我就对闪电着迷，一到夏季就前往马加利斯堡地区看雷暴。我总是能找到新的灵感，改善我的拍摄技巧。&rdquo;</p>\n<p>&nbsp;</p>\n<p style=\"text-align: center;\"><img src=\"../../upload/news/c4746f1b-531f-4706-9a41-6c22a91ad796.jpg\" alt=\"\" width=\"550\" height=\"367\" /></p>','Y',1,4,'南非 摄影师 追逐 闪电 拍摄 壮观 场面 图 国际 在线 专稿 据 英国 每日 日邮 邮报 日报 报道 南非 摄影师 米切尔 克 罗格 在过 过去 年间 冒着 生命危险 荒芜 南非 马 加 利 斯 堡 地区 拍摄 许多 闪电 疾光电影 壮观 场面 有时候 他 甚至不 不顾 自己 生命 站在 致命 闪电 附近 区域 抓拍 大自然 狂暴 一面 报道 称 克 罗格 自 孩提时代 南非 广阔 平原 上 雷暴 现象 着迷 现年 岁 他 已经 拍摄 闪电 他 自己 照片 照片 起了 许多 多名 名字 包括 火 冰 杀人 雷暴 一张 名为 不朽 混乱 杰作 上 他 拍摄到 三次 闪电 同时发生 场景 克 罗格 说 我 不怕 闪电 我会 会尽 尽可能 近 地 贴近 它们 甚至会 会站 站在 闪电 直接 接通 通过 路径 上 从小 小我 闪电 着迷 一到 夏季 前往 马 加 利 斯 堡 地区 看 雷暴 我 总是 能 找到 新 灵感 改善 我 拍摄 技巧 ','../../upload/news/c4746f1b-531f-4706-9a41-6c22a91ad796.jpg'),(34,1,'2011-10-14 19:01:58',1,'2011-10-19 20:23:44','862112a5-f242-488d-9edb-f58b2e8192cd','02','俄罗斯地震哈尔滨震感明显 高层建筑电梯驻停','<p>核心提示：北京时间2011年10月14日14时10分在俄罗斯(北纬54.2,东经123.7)发生6.6级地震，震源深度10公里。距离震中965公里的黑龙江省哈尔滨，有市民明显感到了震感，甚至部分高层建筑的电梯出现驻停现象。</p>','N',1,6,'俄罗斯 地震 哈尔滨 震感 明显 高层建筑 电梯 驻 停 核心 提示 北京时间 时 分在 俄罗斯 北纬 东经 发生 级 地震 震源 深度 公里 距离 震中 公里 黑龙江省 哈尔滨 有 市民 明显 感到 到了 震感 甚至 部分 高层建筑 电梯 出现 驻 停 现象 ',NULL),(35,1,'2011-12-19 20:29:51',1,'2011-12-19 20:47:25','f9e6bbed-9d02-4e16-b82f-902c6059d23d','03','滚动图集：金正日逝世','<p>朝中社12月19日报道说，朝鲜最高领导人金正日17日逝世。图为平壤市民聚集悼念金正日。</p>','Y',1,1,'滚动 图集 金正日 逝世 朝中社 日报 报道说 朝鲜 最高 高领 领导人 金正日 逝世 图为 平壤 市民 聚集 悼念 金正日 ','../../upload/news/9d1e683b-5265-4291-8c38-939d382b94fb.jpg'),(36,1,'2012-04-15 21:36:15',1,'2012-04-15 21:36:41','582124bb-2d92-4a7d-94d8-a0ada13b1ce2','03','外媒：美军宣称不再忌惮中国DF-21D 已备最后杀招','<p>&nbsp;</p>\n<p style=\"text-align: center;\"><img src=\"../../upload/news/ee6afbf2-17e2-4570-b7b3-eada956864e0.jpg\" alt=\"\" width=\"500\" height=\"332\" /></p>\n<p>综合美国《连线》杂志、俄罗斯军工新闻网等媒体报道，美军宣称已经不再忌惮中国东风-21D反舰<a href=\"http://ent.ifeng.com/movie/special/dandao/\" target=\"_blank\">弹道</a>导弹，因为反制战法已&ldquo;基本成型&rdquo;。</p>\n<p>除了实施干扰和拦截，美军甚至谋划主动攻击解放军部署&ldquo;航母杀手&rdquo;的基地。不过有外媒认为，美军的这些战法实施起来难度很大。</p>\n<p>美国海军作战部长格林纳特日前透露，美军对中国&ldquo;航母杀手&rdquo;&mdash;&mdash;东风-21D反舰弹道导弹&ldquo;已经不再感到担忧&rdquo;，因为足以削弱该导弹威力的先进战法&ldquo;正在加速开发&rdquo;。</p>\n<p>他指出，东风-21D要在茫茫大海中找到并锁定美国航母，必须得到情报支持，美军可以通过电子干扰破坏这种关键情报的传输。</p>\n<p>美军投入巨资大力发展电子战系统，其中最突出的就是EA-18F&ldquo;咆哮者&rdquo;电子攻击机。</p>\n<p>这款新型战机可瘫痪敌方雷达和通信系统，破坏其数据传输。美国航母舰队还可在战时保持无线电静默，以防止中国导弹通过逆向追踪无线电信号确定美国航母的位置。</p>\n<p>还有分析称，美军为对付&ldquo;航母杀手&rdquo;采用了&ldquo;双保险&rdquo;策略。除了实施电子干扰，美国航母战斗群还编入多艘宙斯盾战舰，它们可对敌方导弹实施拦截，包括东风-21D。</p>','Y',1,0,'外 媒 美军 宣称 不再 忌惮 中国 已 备 最后 杀招 综合 美国 连线 杂志 俄罗斯 军工 新闻网 媒体报道 美军 宣称 已经 不再 忌惮 中国 东风 反 舰 弹道 导弹 因为 反制 战法 已 基本 成型 除了 实施 干扰 和 拦截 美军 甚至 谋划 主动攻击 解放军 军部 部署 航母 杀手 基地 不过 有 外 媒 认为 美军 这些 战法 实施 起来 难度很大 美国海军 作战 部长 格林 纳 特 日前 透露 美军 中国 航母 杀手 东风 反 舰 弹道导弹 已经 不再 感到 担忧 因为 足以 削弱 该 导弹 威力 先进 战法 正在 加速 开发 他指 指出 东风 要在 茫茫大海 海中 中找到 锁定 美国 国航 航母 必须 须得 得到 情报 支持 美军 可以 通过 过电 电子干扰 破坏 这种 关键 情报 传输 美军 投入 巨资 大力发展 电子战 系统 其中 中最 突出 就是 咆哮 者 电子 攻击机 这款 新型 战机 可 瘫痪 敌方 雷达 和 通信 系统 破坏 其 数据传输 美国 国航 航母 母舰 舰队 还可 可在 战时 保持 无线电 静默 以防 防止 中国 导弹 通过 逆向 追踪 无线电 电信号 确定 美国 国航 航母 位置 还有 分析 称 美军 为 对付 航母 杀手 采用 用了 双保险 策略 除了 实施 电子干扰 美国 国航 航母 战斗群 编入 多 艘 宙斯盾 战舰 它们 可对 对敌 敌方 导弹 实施 拦截 包括 东风 ','../../upload/news/ee6afbf2-17e2-4570-b7b3-eada956864e0.jpg'),(37,1,'2012-04-22 11:08:59',1,'2012-04-22 11:10:04','d81c5b14-9574-40e5-8cf2-c584c2fb2f42','03','中俄25艘军舰集结青岛 22日起开始联合演习','<p>核心提示：4月22日开始，中俄海上联合军事演习将在青岛附近海域举行。这是两国海军首次举行联演，也是两军合作框架内的一次例行演习。这次联合军事演习，中俄海军都派出了主战舰艇参加。</p>\n<p>&nbsp;</p>\n<p style=\"text-align: center;\"><img src=\"../../upload/news/c2fefcbf-1600-4ece-afda-6be2eae5a7b7.jpg\" alt=\"\" width=\"400\" height=\"260\" /></p>\n<p>中新网4月22日电 &ldquo;海上联合-2012&rdquo;中俄海上联合军事演习今日起将在中国青岛附近黄海海域举行。这是两国海军首次举行联演，也是两军合作框架内的一次例行演习。</p>\n<p>此次海上联合军事演习是由中俄两军总参谋长于2011年8月在莫斯科共同商定的。本月17日，中俄两军总长通过直通电话共同批准演习方案，宣布演习将于2012年4月22日至27日在中国青岛附近黄海海域举行。</p>\n<p>中国军方表示，此次海上联合军事演习是两军合作框架内的一次例行演习，不针对第三方，也不会对其他国家构成威胁。中俄两国军队在双边和多边框架下的 合作，对于维护地区与  世界的和平与稳定发挥着积极作用。此次海上联合军演，将两国防务安全合作提升到一个新的高度，充分展现双方共同维护地区安全的意愿。</p>\n<p style=\"text-align: center;\"><img src=\"../../upload/news/861a30e8-7008-4400-a543-70f1de3ab112.jpg\" alt=\"\" width=\"400\" height=\"483\" /></p>\n<p>据介绍，本次演习的课题是&ldquo;海上联合防御和保交作战&rdquo;，按照作战筹划、实兵演习、海上阅兵和交流研讨四个阶段组织。演习主要课目包括联合防空、海上补给、联合反潜、联合搜救、解救被劫持船舶等。</p>\n<p>这次联合军事演习，中俄海军都派出了主战舰艇参加。</p>\n<p>中方参演兵力分别来自北海舰队、东海舰队和南海舰队，包括被中央军委命名为&ldquo;海上先锋舰&rdquo;的&ldquo;哈尔滨&rdquo;舰在内的3型5艘新型导弹驱逐舰，曾执行过亚 丁湾、索马里海域护航任务的&ldquo;舟山&rdquo;舰、&ldquo;徐州&rdquo;舰在内的2型5艘新型导弹护卫舰，2艘新型常规潜艇，4艘新一代导弹快艇以及综合补给舰、&ldquo;和平方舟&rdquo;号 医院船等18艘舰艇。中国海军航空兵派出13架新型飞机和5架舰载直升机参演。</p>\n<p>参加中俄联合军演的中方官兵共计4000多名，其中包括来自海军特种作战部队的特战队员，他们将在此次联演中与俄国海军特战队员一起，进行相关课目的演练。</p>\n<p>参演的俄军舰艇均来自俄罗斯太平洋舰队，共有7艘舰艇。其中水面舰艇4艘：俄罗斯太平洋舰队旗舰&mdash;&mdash;&ldquo;瓦良格&rdquo;号导弹巡洋舰，&ldquo;沙波什尼科夫海军元 帅&rdquo;号大型反潜舰，&ldquo;维诺格拉多夫海军上将&rdquo;号大型反潜舰和&ldquo;特里布茨海军上将&rdquo;号大型反潜舰等。补给舰3艘：2艘拖船和1艘油船。</p>\n<p>太平洋舰队6艘参演舰船于15日从符拉迪沃斯托克附近海湾出发，历经6天远航。&ldquo;特里布茨海军上将号&rdquo;大型反潜舰是从亚丁湾直接赶往演习地点的。中国海军&ldquo;哈尔滨&rdquo;号、&ldquo;沈阳&rdquo;号导弹驱逐舰20日前往青岛附近海域迎接。</p>\n<p>21日，参加本次演习的俄方舰艇陆续抵达青岛某军港。同时，参演的中国海军兵力当日也已全部集结完毕。</p>\n<p>近年来，中俄两国两军关系不断发展，战略协作水平不断提升，两军联合演习日益常态化和机制化。2005年以来，中俄两国在双边和上海合作组织框架内已举行多次联合军事演习，演习规模由小到大，演习内容不断丰富，演习领域逐步拓展。</p>\n<p><strong>背景资料：中俄两国历次联合军事演习</strong></p>\n<p>从2003年开始，中俄两国曾组织和参与过6次联合军事演习，分别是：</p>\n<p>&mdash;&mdash;&ldquo;联合&mdash;2003&rdquo;上海合作组织成员国武装力量联合反恐军事演习。2003年8月6日至12日在哈萨克斯坦和中国境内举行。这是上海合作组  织框架内首次举行的多边联合反恐军事演习。中国、哈萨克斯坦、吉尔吉斯斯坦、俄罗斯、塔吉克斯坦5国的武装力量参加了演习。这是中国军队首次参加多边联合  反恐演习。</p>\n<p>&mdash;&mdash;&ldquo;和平使命－2005&rdquo;中俄联合军演。2005年8月18日至25日在俄罗斯符拉迪沃斯托克和中国山东半岛及附近海域举行。中俄双方派出陆、海、空军和空降兵、海军陆战队以及保障部(分)队近万人参加演习，其中中方参演兵力8000余人。</p>\n<p>&mdash;&mdash;&ldquo;和平使命－2007&rdquo;上海合作组织武装力量联合反恐军事演习。2007年8月9日至17日在中国乌鲁木齐和俄罗斯车里雅宾斯克举行。来自  中、哈、吉、俄、塔、乌六国武装力量参加演习，其中中方参演兵力1600人。这也是上合组织成立以来参与国家最多的一次联合反恐军事演习。</p>\n<p>&mdash;&mdash;&ldquo;和平使命－2009&rdquo;中俄联合反恐军事演习。2009年7月22日至26日在俄罗斯哈巴罗夫斯克和中国沈阳军区洮南合同战术训练基地举行，中俄双方参演兵力各1300人。</p>\n<p>&mdash;&mdash;&ldquo;和平蓝盾－2009&rdquo;海上联演。2009年9月18日在亚丁湾西部海区进行。中方&ldquo;舟山&rdquo;号和&ldquo;徐州&rdquo;号两艘导弹护卫舰及&ldquo;千岛湖&rdquo;号综合补给舰，俄方&ldquo;特里布茨海军上将&rdquo;号大型反潜舰、&ldquo;布托玛&rdquo;号综合补给舰等6艘舰船参演。</p>\n<p>&mdash;&mdash;&ldquo;和平使命－2010&rdquo;上海合作组织联合反恐军事演习。2010年9月10日至25日在哈萨克斯坦阿拉木图市奥塔尔市的马特布拉克诸兵种合成训练基地举行。中方参演兵力1000人，总兵力5000多人。</p>','Y',1,0,'中俄 艘 军舰 集结 青岛 起开 开始 联合演习 核心 提示 开始 中俄 海上 上联 联合 军事演习 将在 在青 青岛 附近 近海 海域 举行 这是 两国 海军 首次 举行 联 演 也是 两军 合作 框架 内 一次 例行 演习 这次 联合 军事演习 中俄 俄海军 都 派出 出了 主战 战舰 舰艇 参加 中新网 电 海上 上联 联合 中俄 海上 上联 联合 军事演习 今日 起 将在 中国 青岛 附近 黄海 海海 海域 举行 这是 两国 海军 首次 举行 联 演 也是 两军 合作 框架 内 一次 例行 演习 此次 海上 上联 联合 军事演习 由中 中俄 两军 军总 总参谋长 长于 莫斯科 共同商定 本月 中俄 两军 军总 总长 通过 直通 通电话 共同 批准 演习 方案 宣布 演习 将于 日至 中国 青岛 附近 黄海 海海 海域 举行 中国军方 表示 此次 海上 上联 联合 军事演习 两军 合作 框架 内 一次 例行 演习 不 针对 第三方 也 不会 会对 其他国家 构成威胁 中俄 两国 国军 军队 双边 和 多边 边框 框架 架下 合作 对于 维护 地区 世界 和平 稳定 发挥 挥着 积极作用 此次 海上 上联 联合 军 演 将 两国 国防 防务 安全 合作 提升到 一个 新 高度 充分 展现 双方 共同 维护 地区 安全 意愿 据介绍 本次 演习 课题 海上 上联 联合 防御 和 保 交 作战 按照 作战 筹划 实兵演习 海上 阅兵 和 交流 研讨 四个 阶段 组织 演习 主要 课目 包括 联合 防空 海上 补给 联合 反潜 联合 搜救 解救 被劫持 船舶 这次 联合 军事演习 中俄 俄海军 都 派出 出了 主战 战舰 舰艇 参加 中方 参演 兵力 分别 别来 来自 北海 舰队 东海 舰队 和南 南海 舰队 包括 中央军委 命名为 海上 先锋 舰 哈尔滨 舰 在内 型 艘 新型 导弹驱逐舰 曾 执行 过 亚 丁 湾 索马里 里海 海域 护航 任务 舟山 舰 徐州 舰 在内 型 艘 新型 导弹 护卫舰 艘 新型 常规 潜艇 艘 新一代 导弹 快艇 以及 综合 合补 补给舰 和平 平方 方舟 号 医院船 艘 舰艇 中国海军 海军航空 航空兵 派出 架 新型 型飞机 和 架 舰载 直升机 参演 参加 中俄 联合 军 演 中方 官兵 共计 多名 其中 包括 来自 海军 特种 作战 部队 特 战队 队员 他们 将在 在此 此次 联 演 中 俄国 海军 特 战队 队员 一起 进行 行相 相关 课目 目的 演练 参演 俄军 军舰 舰艇 均 来自 俄罗斯 太平洋 舰队 共有 艘 舰艇 其中 水面舰艇 艘 俄罗斯 太平洋 舰队 队旗 旗舰 瓦良格 号 导弹 巡洋舰 沙 波 什 尼科夫 海军 元 帅 号 大型 反潜 舰 维 诺 格拉 拉多 夫 海军上将 号 大型 反潜 舰 和 特里 里布 茨 海军上将 号 大型 反潜 舰 补给舰 艘 艘 拖船 和 艘 油船 太平洋 舰队 艘 参演 舰船 符拉迪 沃 斯托克 附近 近海 海湾 出发 历经 天 远航 特里 里布 茨 海军上将 号 大型 反潜 舰 亚丁 湾 直接 赶往 演习 地点 中国海军 哈尔滨 号 沈阳 号 导弹驱逐舰 日前 前往 青岛 附近 近海 海域 迎接 参加 本次 演习 俄方 舰艇 陆续 抵达 青岛 某军 军港 同时 参演 中国海军 兵力 当日 也 已 全部 集结 完毕 近年来 中俄 两国 两军 关系 不断发展 战略 协作 水平 不断 提升 两军 联合演习 日益 常态 化 和 机制化 以来 中俄 两国 双边 和 上海 合作 组织 框架 内 已 举行 多次 联合 军事演习 演习 规模 由小到大 演习 内容 不断丰富 演习 领域 逐步 拓展 背景 资料 中俄 两国 国历 历次 联合 军事演习 开始 中俄 两国 曾 组织 和 参与 过 次 联合 军事演习 分别 别是 联合 上海 合作 组织 织成 成员国 武装力量 联合 反恐 军事演习 日至 哈萨克斯坦 和 中国 国境 境内 举行 这是 上海 合作 组 织 框架 内 首次 举行 多边 联合 反恐 军事演习 中国 哈萨克斯坦 吉尔吉斯斯坦 俄罗斯 塔吉克斯坦 国 武装力量 参加 加了 演习 这是 中国军队 首次 参加 加多 多边 联合 反恐 演习 和平 使命 中俄 联合 军 演 日至 俄罗斯 符拉迪 沃 斯托克 和 中国 山东半岛 附近 近海 海域 举行 中俄 双方 派出 陆 海 空军 和 空降兵 海军陆战队 以及 保障部 分 队 近 万人 人参 参加 加演 演习 其中 中方 参演 兵力 余人 和平 使命 上海 合作 组织 武装力量 联合 反恐 军事演习 日至 中国 乌鲁木齐 和 俄罗斯 车里 雅 宾 斯 克 举行 来自 中 哈 吉 俄 塔 乌 六国 武装力量 参加 加演 演习 其中 中方 参演 兵力 人 这也 也是 上 合组 组织 织成 成立 以来 参与 与国 国家 最多 一次 联合 反恐 军事演习 和平 使命 中俄 联合 反恐 军事演习 日至 俄罗斯 哈 巴 罗 夫 斯 克 和 中国 沈阳军区 洮南 合同 战术 训练 基地 举行 中俄 双方 参演 兵力 各 人 和平 蓝 盾 海上 上联 演 亚丁 湾 西部 海区 进行 中方 舟山 号 和 徐州 号 两 艘 导弹 护卫舰 千岛湖 号 综合 合补 补给舰 俄方 特里 里布 茨 海军上将 号 大型 反潜 舰 布 托 玛 号 综合 合补 补给舰 艘 舰船 参演 和平 使命 上海 合作 组织 联合 反恐 军事演习 日至 哈萨克斯坦 阿拉木图 市 奥 塔 尔 市 马 特 布拉 克 诸 兵种 合成 训练 基地 举行 中方 参演 兵力 人 总兵力 多人 ','../../upload/news/c2fefcbf-1600-4ece-afda-6be2eae5a7b7.jpg'),(38,1,'2012-05-13 20:56:02',1,'2013-05-29 19:40:38','c0251977-765d-436b-81d1-b1766073b214','01','菲律宾称永不同意中方对黄岩岛要求','<p>核心提示：据菲媒报道，菲外长5月11日向媒体表示，中菲已就黄岩岛事件重新展开外交对话。报道称，中方要求中国公共服务船只在黄岩岛自由行动，中国渔船可以在黄岩岛自由捕捞，同时，菲方船只离开黄岩岛。对此，菲外长称，菲律宾将&ldquo;永远不会同意这些要求&rdquo;。</p>\n<p>环球网记者谭利娅报道，据《菲律宾每日问询者报》5月12日报道，菲律宾外长德尔罗萨里奥在11日向媒体表示，中菲已就黄岩岛事件重新展开外交对 话。他表示，尽管希望对话能够产生成果，但菲方认为，外交对话最多只会达成一种&ldquo;临时协议&rdquo;，并不会使争端得到最终解决。菲律宾最终还将会寻求&ldquo;全面的解 决方案&rdquo;，解决黄岩岛事件。</p>\n<div class=\"gg200x300\"></div>\n<p>报道称，中国外交部发言人洪磊在5月11日召开的记者会上表示，中国致力于用外交方式解决中菲黄岩岛争端。中方的要求是，中国的公共服务型船只在黄岩岛的行动应不受阻碍，中国渔船可以在黄岩岛自由进行正常的捕鱼活动，同时，菲方船只要离开黄岩岛。</p>\n<p>不过对此，罗萨里奥声称，菲律宾将&ldquo;永远不会同意这些要求&rdquo;，尽管他并没有透露菲方是如何回应中方的上述要求的。</p>\n<p>罗萨里奥表示，中菲均认为当前双方并不会就争议的解决达成&ldquo;持久方案&rdquo;。</p>\n<p>&ldquo;我们希望对话能够达成外交成果，不过外交成果对于结束当前的僵局而言，最多只会是一个临时性的方案。&rdquo;罗萨里奥称。&ldquo;最终，我们需要一种全面的解决方案。&rdquo;</p>\n<p>报道称，菲律宾已经决定通过将争议提交国际法庭，来&ldquo;迫使&rdquo;中国&ldquo;认可&rdquo;菲律宾在南海部分海域的&ldquo;主权&rdquo;。</p>','N',0,4,'菲律宾 称 永不 不同意 意中 中方 黄岩 岛 要求 核心 提示 据 菲 媒 报道 菲 外长 向 媒体 体表 表示 中菲 已就 黄岩 岛 事件 重新 展开 开外 外交 交对 对话 报道 称 中方 要求 中国 国公 公共 服务 船只 黄岩 岛 自由行动 中国 渔船 可以 黄岩 岛 自由 捕捞 同时 菲 方 船只 离开 黄岩 岛 对此 菲 外长 称 菲律宾 将 永远 不会 会同 同意 这些 要求 环球 球网 记者 谭 利 娅 报道 据 菲律宾 每日 问询 者 报 日报 报道 菲律宾 外长 德 尔 罗 萨 里 奥 向 媒体 体表 表示 中菲 已就 黄岩 岛 事件 重新 展开 开外 外交 交对 话 他 表示 尽管 希望 对话 能够 产生 生成 成果 菲 方 认为 外交 交对 对话 最多 多只 只会 达成 一种 临时 协议 并不会 会使 争端 得到 最终 解决 菲律宾 最终 还将 将会 寻求 全面 面的 解 决 方案 解决 黄岩 岛 事件 报道 称 中国外交 外交部 部发 发言人 洪 磊 召开 记者会 会上 上表 表示 中国 致力于 用 外交 方式 解决 中菲 黄岩 岛 争端 中方 要求 求是 中国 公共 服务型 船只 黄岩 岛 行动 应 不受 受阻 阻碍 中国 渔船 可以 黄岩 岛 自由 进行 正常 捕鱼 活动 同时 菲 方 船只 只要 离开 黄岩 岛 不过 对此 罗 萨 里 奥 声称 菲律宾 将 永远 不会 会同 同意 这些 要求 尽管 管他 并没有 透露 菲 方 如何 回应 中方 上述 述要 要求 罗 萨 里 奥 表示 中菲 均 认为 当前 双方 并不会 争议 解决 达成 持久 方案 我们 希望 对话 能够 达成 外交 成果 不过 外交 成果 对于 结束 当前 僵局 而言 最多 多只 只会 会是 一个 临时性 方案 罗 萨 里 奥 称 最终 我们 需要 一种 全面 面的 解决方案 报道 称 菲律宾 已经 决定 通过 将 争议 提交 国际法庭 来 迫使 中国 认可 菲律宾 南海 海部 部分 海域 主权 ',NULL);
/*!40000 ALTER TABLE `core_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_customer_attachment`
--

DROP TABLE IF EXISTS `crm_customer_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_customer_attachment` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `filename` varchar(200) DEFAULT NULL,
  `filetype` varchar(45) DEFAULT NULL,
  `filesize` int(10) unsigned DEFAULT '0',
  `oldname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_customer_attachment`
--

LOCK TABLES `crm_customer_attachment` WRITE;
/*!40000 ALTER TABLE `crm_customer_attachment` DISABLE KEYS */;
INSERT INTO `crm_customer_attachment` VALUES (1,8,'2012-03-24 16:02:48',NULL,NULL,'60a59863-be61-4b1e-86f6-7a368366f25b','upload\\customer\\1a71893b-2ad0-48cb-aab8-4adb77b623e6.docx','.docx',373323,'MiniOA工作流.docx'),(2,8,'2012-03-24 16:02:48',NULL,NULL,'60a59863-be61-4b1e-86f6-7a368366f25b','upload\\customer\\41c670c1-3721-4536-be3f-c9a74a4b2c9e.pdf','.pdf',504506,'MiniOA工作流.pdf'),(3,8,'2012-04-15 21:08:13',NULL,NULL,'efb389e7-154a-46ec-81a0-5a10ed0c2889','upload\\customer\\8ec5b3aa-9904-40c8-bcf1-1892d42d4b10.xls','.xls',25600,'副本客户资料20120402112556.xls');
/*!40000 ALTER TABLE `crm_customer_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp`
--

DROP TABLE IF EXISTS `temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temp` (
  `tmptext` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp`
--

LOCK TABLES `temp` WRITE;
/*!40000 ALTER TABLE `temp` DISABLE KEYS */;
/*!40000 ALTER TABLE `temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofroster`
--

DROP TABLE IF EXISTS `ofroster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofroster` (
  `rosterID` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `jid` varchar(1024) NOT NULL,
  `sub` tinyint(4) NOT NULL,
  `ask` tinyint(4) NOT NULL,
  `recv` tinyint(4) NOT NULL,
  `nick` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rosterID`),
  KEY `ofRoster_unameid_idx` (`username`),
  KEY `ofRoster_jid_idx` (`jid`(255))
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofroster`
--

LOCK TABLES `ofroster` WRITE;
/*!40000 ALTER TABLE `ofroster` DISABLE KEYS */;
INSERT INTO `ofroster` VALUES (1,'tom','admin@minioa',0,-1,-1,'管理员'),(2,'admin','tom@minioa',0,-1,-1,'Tom'),(3,'admin','163@minioa',3,-1,-1,'1631'),(4,'tom','163@minioa',3,-1,-1,'1631'),(5,'163','163@minioa',3,-1,-1,'1631'),(6,'163','admin@minioa',3,-1,-1,'管理员'),(7,'163','tom@minioa',3,-1,-1,'Tom'),(8,'163','Baidu@minioa',3,-1,-1,'Baidu'),(9,'admin','Baidu@minioa',3,-1,-1,'Baidu'),(10,'tom','Baidu@minioa',3,-1,-1,'Baidu'),(11,'Baidu','163@minioa',3,-1,-1,'1631'),(12,'Baidu','admin@minioa',3,-1,-1,'管理员'),(13,'Baidu','Baidu@minioa',3,-1,-1,'Baidu'),(14,'Baidu','tom@minioa',3,-1,-1,'Tom'),(18,'163','Ben@minioa',3,-1,-1,'Ben'),(19,'Baidu','Ben@minioa',3,-1,-1,'Ben'),(20,'admin','Ben@minioa',3,-1,-1,'Ben'),(21,'tom','Ben@minioa',3,-1,-1,'Ben'),(22,'Ben','163@minioa',3,-1,-1,'1631'),(23,'Ben','admin@minioa',3,-1,-1,'管理员'),(24,'Ben','Baidu@minioa',3,-1,-1,'Baidu'),(25,'Ben','Ben@minioa',3,-1,-1,'Ben'),(26,'Ben','tom@minioa',3,-1,-1,'Tom'),(29,'163','subadmin@minioa',3,-1,-1,'二级管理员'),(30,'Baidu','subadmin@minioa',3,-1,-1,'二级管理员'),(31,'Ben','subadmin@minioa',3,-1,-1,'二级管理员'),(32,'admin','subadmin@minioa',3,-1,-1,'二级管理员'),(33,'tom','subadmin@minioa',3,-1,-1,'二级管理员'),(34,'subadmin','163@minioa',3,-1,-1,'1631'),(35,'subadmin','admin@minioa',3,-1,-1,'管理员'),(36,'subadmin','Baidu@minioa',3,-1,-1,'Baidu'),(37,'subadmin','Ben@minioa',3,-1,-1,'Ben'),(38,'subadmin','subadmin@minioa',3,-1,-1,'二级管理员'),(39,'subadmin','tom@minioa',3,-1,-1,'Tom'),(41,'admin','admin@minioa',3,-1,-1,'管理员'),(42,'163','Lucy@minioa',3,-1,-1,'Lucy'),(43,'Baidu','Lucy@minioa',3,-1,-1,'Lucy'),(44,'Ben','Lucy@minioa',3,-1,-1,'Lucy'),(45,'subadmin','Lucy@minioa',3,-1,-1,'Lucy'),(46,'admin','Lucy@minioa',3,-1,-1,'Lucy'),(47,'tom','Lucy@minioa',3,-1,-1,'Lucy'),(48,'Lucy','163@minioa',3,-1,-1,'1631'),(49,'Lucy','admin@minioa',3,-1,-1,'管理员'),(50,'Lucy','Baidu@minioa',3,-1,-1,'Baidu'),(51,'Lucy','Ben@minioa',3,-1,-1,'Ben'),(52,'Lucy','Lucy@minioa',3,-1,-1,'Lucy'),(53,'Lucy','subadmin@minioa',3,-1,-1,'二级管理员'),(54,'Lucy','tom@minioa',3,-1,-1,'Tom'),(55,'163','Yahoo@minioa',3,-1,-1,'Yahoo'),(56,'Baidu','Yahoo@minioa',3,-1,-1,'Yahoo'),(57,'Ben','Yahoo@minioa',3,-1,-1,'Yahoo'),(58,'Lucy','Yahoo@minioa',3,-1,-1,'Yahoo'),(59,'subadmin','Yahoo@minioa',3,-1,-1,'Yahoo'),(60,'admin','Yahoo@minioa',3,-1,-1,'Yahoo'),(61,'tom','Yahoo@minioa',3,-1,-1,'Yahoo'),(62,'Yahoo','163@minioa',3,-1,-1,'1631'),(63,'Yahoo','admin@minioa',3,-1,-1,'管理员'),(64,'Yahoo','Baidu@minioa',3,-1,-1,'Baidu'),(65,'Yahoo','Ben@minioa',3,-1,-1,'Ben'),(66,'Yahoo','Lucy@minioa',3,-1,-1,'Lucy'),(67,'Yahoo','subadmin@minioa',3,-1,-1,'二级管理员'),(68,'Yahoo','tom@minioa',3,-1,-1,'Tom'),(69,'Yahoo','Yahoo@minioa',3,-1,-1,'Yahoo'),(77,'163','Google@minioa',3,-1,-1,'Google'),(78,'Baidu','Google@minioa',3,-1,-1,'Google'),(79,'Ben','Google@minioa',3,-1,-1,'Google'),(80,'Lucy','Google@minioa',3,-1,-1,'Google'),(81,'subadmin','Google@minioa',3,-1,-1,'Google'),(82,'Yahoo','Google@minioa',3,-1,-1,'Google'),(83,'admin','Google@minioa',3,-1,-1,'Google'),(84,'tom','Google@minioa',3,-1,-1,'Google'),(100,'163','Kate@minioa',3,-1,-1,'Kate'),(101,'Baidu','Kate@minioa',3,-1,-1,'Kate'),(102,'Ben','Kate@minioa',3,-1,-1,'Kate'),(104,'Lucy','Kate@minioa',3,-1,-1,'Kate'),(105,'subadmin','Kate@minioa',3,-1,-1,'Kate'),(106,'Yahoo','Kate@minioa',3,-1,-1,'Kate'),(107,'admin','Kate@minioa',3,-1,-1,'Kate'),(108,'tom','Kate@minioa',3,-1,-1,'Kate'),(109,'Kate','163@minioa',3,-1,-1,'1631'),(110,'Kate','admin@minioa',3,-1,-1,'管理员'),(111,'Kate','Baidu@minioa',3,-1,-1,'Baidu'),(112,'Kate','Ben@minioa',3,-1,-1,'Ben'),(113,'Kate','Google@minioa',3,-1,-1,'Google'),(114,'Kate','Kate@minioa',3,-1,-1,'Kate'),(115,'Kate','Lucy@minioa',3,-1,-1,'Lucy'),(116,'Kate','subadmin@minioa',3,-1,-1,'二级管理员'),(117,'Kate','tom@minioa',3,-1,-1,'Tom'),(118,'Kate','Yahoo@minioa',3,-1,-1,'Yahoo'),(119,'system','admin@minioa',3,-1,-1,'管理员'),(120,'admin','system@minioa',3,-1,-1,'system'),(121,'system','subadmin@minioa',3,-1,-1,'二级管理员'),(122,'subadmin','system@minioa',3,-1,-1,'system'),(123,'system','163@minioa',3,-1,-1,'1631'),(124,'163','system@minioa',3,-1,-1,'system'),(125,'system','Tom@minioa',3,-1,-1,'Tom'),(126,'Tom','system@minioa',3,-1,-1,'system'),(127,'Tom','tom@minioa',3,-1,-1,'Tom'),(128,'system','Ben@minioa',3,-1,-1,'Ben'),(129,'Ben','system@minioa',3,-1,-1,'system'),(130,'system','Kate@minioa',3,-1,-1,'Kate'),(131,'Kate','system@minioa',3,-1,-1,'system'),(132,'system','Lucy@minioa',3,-1,-1,'Lucy'),(133,'Lucy','system@minioa',3,-1,-1,'system'),(134,'system','Baidu@minioa',3,-1,-1,'Baidu'),(135,'Baidu','system@minioa',3,-1,-1,'system'),(136,'system','Yahoo@minioa',3,-1,-1,'Yahoo'),(137,'Yahoo','system@minioa',3,-1,-1,'system'),(138,'163','test2@minioa',3,-1,-1,'test2'),(139,'Baidu','test2@minioa',3,-1,-1,'test2'),(140,'Ben','test2@minioa',3,-1,-1,'test2'),(142,'Kate','test2@minioa',3,-1,-1,'test2'),(143,'Lucy','test2@minioa',3,-1,-1,'test2'),(144,'subadmin','test2@minioa',3,-1,-1,'test2'),(145,'Yahoo','test2@minioa',3,-1,-1,'test2'),(146,'admin','test2@minioa',3,-1,-1,'test2'),(147,'tom','test2@minioa',3,-1,-1,'test2'),(148,'system','test2@minioa',3,-1,-1,'test2'),(149,'test2','163@minioa',3,-1,-1,'1631'),(150,'test2','admin@minioa',3,-1,-1,'管理员'),(151,'test2','Baidu@minioa',3,-1,-1,'Baidu'),(152,'test2','Ben@minioa',3,-1,-1,'Ben'),(153,'test2','Google@minioa',3,-1,-1,'Google'),(154,'test2','Kate@minioa',3,-1,-1,'Kate'),(155,'test2','Lucy@minioa',3,-1,-1,'Lucy'),(156,'test2','subadmin@minioa',3,-1,-1,'二级管理员'),(157,'test2','system@minioa',3,-1,-1,'system'),(158,'test2','test2@minioa',3,-1,-1,'test2'),(159,'test2','tom@minioa',3,-1,-1,'Tom'),(160,'test2','Yahoo@minioa',3,-1,-1,'Yahoo'),(161,'163','jessy@minioa',3,-1,-1,'jessy'),(162,'Baidu','jessy@minioa',3,-1,-1,'jessy'),(163,'Ben','jessy@minioa',3,-1,-1,'jessy'),(165,'Kate','jessy@minioa',3,-1,-1,'jessy'),(166,'Lucy','jessy@minioa',3,-1,-1,'jessy'),(167,'subadmin','jessy@minioa',3,-1,-1,'jessy'),(168,'test2','jessy@minioa',3,-1,-1,'jessy'),(169,'Yahoo','jessy@minioa',3,-1,-1,'jessy'),(170,'admin','jessy@minioa',3,-1,-1,'jessy'),(171,'tom','jessy@minioa',3,-1,-1,'jessy'),(172,'system','jessy@minioa',3,-1,-1,'jessy'),(203,'163','jessy1@minioa',3,-1,-1,'jessy'),(204,'Baidu','jessy1@minioa',3,-1,-1,'jessy'),(205,'Ben','jessy1@minioa',3,-1,-1,'jessy'),(208,'Kate','jessy1@minioa',3,-1,-1,'jessy'),(209,'Lucy','jessy1@minioa',3,-1,-1,'jessy'),(210,'subadmin','jessy1@minioa',3,-1,-1,'jessy'),(211,'test2','jessy1@minioa',3,-1,-1,'jessy'),(212,'Yahoo','jessy1@minioa',3,-1,-1,'jessy'),(213,'admin','jessy1@minioa',3,-1,-1,'jessy'),(214,'tom','jessy1@minioa',3,-1,-1,'jessy'),(215,'system','jessy1@minioa',3,-1,-1,'jessy'),(216,'jessy1','163@minioa',3,-1,-1,'1631'),(217,'jessy1','admin@minioa',3,-1,-1,'管理员'),(218,'jessy1','Baidu@minioa',3,-1,-1,'Baidu'),(219,'jessy1','Ben@minioa',3,-1,-1,'Ben'),(220,'jessy1','Google@minioa',3,-1,-1,'Google'),(221,'jessy1','jessy@minioa',3,-1,-1,'jessy'),(222,'jessy1','jessy1@minioa',3,-1,-1,'jessy'),(223,'jessy1','Kate@minioa',3,-1,-1,'Kate'),(224,'jessy1','Lucy@minioa',3,-1,-1,'Lucy'),(225,'jessy1','subadmin@minioa',3,-1,-1,'二级管理员'),(226,'jessy1','system@minioa',3,-1,-1,'system'),(227,'jessy1','test2@minioa',3,-1,-1,'test2'),(228,'jessy1','tom@minioa',3,-1,-1,'Tom'),(229,'jessy1','Yahoo@minioa',3,-1,-1,'Yahoo'),(231,'jessy','163@minioa',3,-1,-1,'1631'),(232,'jessy','admin@minioa',3,-1,-1,'管理员'),(233,'jessy','Baidu@minioa',3,-1,-1,'Baidu'),(234,'jessy','Ben@minioa',3,-1,-1,'Ben'),(235,'jessy','Google@minioa',3,-1,-1,'Google'),(236,'jessy','jessy@minioa',3,-1,-1,'jessy'),(237,'jessy','jessy1@minioa',3,-1,-1,'jessy'),(238,'jessy','Kate@minioa',3,-1,-1,'Kate'),(239,'jessy','Lucy@minioa',3,-1,-1,'Lucy'),(240,'jessy','subadmin@minioa',3,-1,-1,'二级管理员'),(241,'jessy','system@minioa',3,-1,-1,'system'),(242,'jessy','test2@minioa',3,-1,-1,'test2'),(243,'jessy','tom@minioa',3,-1,-1,'Tom'),(244,'jessy','Yahoo@minioa',3,-1,-1,'Yahoo'),(246,'163','Li@minioa',3,-1,-1,'Li'),(247,'Baidu','Li@minioa',3,-1,-1,'Li'),(248,'Ben','Li@minioa',3,-1,-1,'Li'),(249,'jessy','Li@minioa',3,-1,-1,'Li'),(250,'jessy1','Li@minioa',3,-1,-1,'Li'),(251,'Kate','Li@minioa',3,-1,-1,'Li'),(252,'Lucy','Li@minioa',3,-1,-1,'Li'),(253,'subadmin','Li@minioa',3,-1,-1,'Li'),(254,'test2','Li@minioa',3,-1,-1,'Li'),(255,'Yahoo','Li@minioa',3,-1,-1,'Li'),(256,'admin','Li@minioa',3,-1,-1,'Li'),(257,'tom','Li@minioa',3,-1,-1,'Li'),(258,'system','Li@minioa',3,-1,-1,'Li'),(259,'Li','163@minioa',3,-1,-1,'1631'),(260,'Li','admin@minioa',3,-1,-1,'管理员'),(261,'Li','Baidu@minioa',3,-1,-1,'Baidu'),(262,'Li','Ben@minioa',3,-1,-1,'Ben'),(263,'Li','jessy@minioa',3,-1,-1,'jessy'),(264,'Li','jessy1@minioa',3,-1,-1,'jessy'),(265,'Li','Kate@minioa',3,-1,-1,'Kate'),(266,'Li','Li@minioa',3,-1,-1,'Li'),(267,'Li','Lucy@minioa',3,-1,-1,'Lucy'),(268,'Li','subadmin@minioa',3,-1,-1,'二级管理员'),(269,'Li','system@minioa',3,-1,-1,'system'),(270,'Li','test2@minioa',3,-1,-1,'test2'),(271,'Li','tom@minioa',3,-1,-1,'Tom'),(272,'Li','Yahoo@minioa',3,-1,-1,'Yahoo');
/*!40000 ALTER TABLE `ofroster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_task_agent`
--

DROP TABLE IF EXISTS `core_task_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_task_agent` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `taskDefId` int(10) unsigned DEFAULT '0',
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `agentId` int(10) unsigned DEFAULT '0',
  `taskId` int(10) DEFAULT '-1',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_task_agent`
--

LOCK TABLES `core_task_agent` WRITE;
/*!40000 ALTER TABLE `core_task_agent` DISABLE KEYS */;
INSERT INTO `core_task_agent` VALUES (4,4,'2012-01-12 20:37:00',4,'2012-01-22 16:49:22',NULL,2,'2012-01-12 12:00:00','2012-01-23 12:00:00',3,-1),(15,1,'2013-04-16 21:36:08',0,NULL,NULL,1,'2012-01-22 22:12:00','2012-01-29 22:12:00',8,-1),(16,1,'2013-06-16 13:52:00',1,'2013-06-16 14:48:28',NULL,1,'2012-01-22 22:12:00','2012-01-29 22:12:00',1,-1),(19,1,'2013-06-16 15:45:00',1,'2013-06-23 11:30:18',NULL,12,'2013-06-23 11:00:00','2013-06-23 16:00:00',1,-1),(20,17,'2013-06-19 12:54:08',0,NULL,NULL,1,'2013-06-19 12:00:00','2013-06-19 13:00:00',1,-1),(21,17,'2013-06-19 13:27:00',17,'2013-06-19 13:40:31',NULL,13,'2013-06-19 12:00:00','2013-06-19 14:00:00',10,-1),(22,10,'2013-06-23 11:33:00',10,'2013-06-23 11:34:21',NULL,12,'2013-06-23 11:33:00','2013-06-30 11:33:00',1,91);
/*!40000 ALTER TABLE `core_task_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `core_form_view_v`
--

DROP TABLE IF EXISTS `core_form_view_v`;
/*!50001 DROP VIEW IF EXISTS `core_form_view_v`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `core_form_view_v` (
  `concat('formview',ta.ID_,'.jsf')` varchar(40),
  `concat(tb.formName,'-', ta.viewName)` varchar(146)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `ofsecurityauditlog`
--

DROP TABLE IF EXISTS `ofsecurityauditlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofsecurityauditlog` (
  `msgID` bigint(20) NOT NULL,
  `username` varchar(64) NOT NULL,
  `entryStamp` bigint(20) NOT NULL,
  `summary` varchar(255) NOT NULL,
  `node` varchar(255) NOT NULL,
  `details` text,
  PRIMARY KEY (`msgID`),
  KEY `ofSecurityAuditLog_tstamp_idx` (`entryStamp`),
  KEY `ofSecurityAuditLog_uname_idx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofsecurityauditlog`
--

LOCK TABLES `ofsecurityauditlog` WRITE;
/*!40000 ALTER TABLE `ofsecurityauditlog` DISABLE KEYS */;
INSERT INTO `ofsecurityauditlog` VALUES (1,'admin',1319113414875,'created new user tom','minioa','name = Tom, email = tom@minioa.net, admin = false'),(2,'admin',1319113464171,'added roster item for tom','minioa','roster item:\njid = admin@minioa\nnickname = ADMIN\ngroupList = []'),(3,'admin',1319113481921,'created new group 市场部','minioa','description = '),(4,'admin',1319113512734,'created new group 财务部','minioa','description = '),(5,'admin',1319113544296,'added roster item for admin','minioa','roster item:\njid = tom@minioa\nnickname = Tom\ngroupList = []'),(6,'admin',1319120420578,'deleted group 市场部q','minioa',NULL),(7,'admin',1319120427562,'deleted group 财务部','minioa',NULL),(8,'admin',1319289286453,'created new user system','minioa','name = system, email = system@minioa, admin = false');
/*!40000 ALTER TABLE `ofsecurityauditlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofpubsubsubscription`
--

DROP TABLE IF EXISTS `ofpubsubsubscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofpubsubsubscription` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `state` varchar(15) NOT NULL,
  `deliver` tinyint(4) NOT NULL,
  `digest` tinyint(4) NOT NULL,
  `digest_frequency` int(11) NOT NULL,
  `expire` char(15) DEFAULT NULL,
  `includeBody` tinyint(4) NOT NULL,
  `showValues` varchar(30) DEFAULT NULL,
  `subscriptionType` varchar(10) NOT NULL,
  `subscriptionDepth` tinyint(4) NOT NULL,
  `keyword` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`serviceID`,`nodeID`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofpubsubsubscription`
--

LOCK TABLES `ofpubsubsubscription` WRITE;
/*!40000 ALTER TABLE `ofpubsubsubscription` DISABLE KEYS */;
INSERT INTO `ofpubsubsubscription` VALUES ('pubsub','','Iq33jRrd19NS9jp732Ts8HE5RnnA5R3CX30W1S93','minioa','minioa','subscribed',1,0,86400000,NULL,0,' ','nodes',1,NULL);
/*!40000 ALTER TABLE `ofpubsubsubscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_prop`
--

DROP TABLE IF EXISTS `web_prop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `web_prop` (
  `ID_` int(11) NOT NULL AUTO_INCREMENT,
  `CID_` int(11) DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(11) DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `propName` varchar(45) DEFAULT NULL,
  `propType` varchar(45) DEFAULT NULL,
  `propValue` longtext,
  `title` varchar(450) DEFAULT NULL,
  `keywords` varchar(450) DEFAULT NULL,
  `description` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_prop`
--

LOCK TABLES `web_prop` WRITE;
/*!40000 ALTER TABLE `web_prop` DISABLE KEYS */;
INSERT INTO `web_prop` VALUES (1,1,'2013-04-08 00:00:00',1,'2013-04-10 20:31:55','网站名称','text','青岛荣昌金属制造有限公司',NULL,NULL,NULL),(2,1,'2013-04-08 00:00:00',1,'2013-04-16 20:35:00','网站备案信息','text','鲁ICP备12015352号-1',NULL,NULL,NULL),(4,1,'2013-04-08 00:00:00',1,'2013-04-17 20:58:50','网站描述','text','青岛荣昌金属制造有限公司是一家特种集装箱制造企业，坐落于美丽的胶州湾。联系人：任鹏，销售热线：15725427432。',NULL,NULL,NULL),(5,1,'2013-04-08 00:00:00',1,'2013-04-10 20:31:51','网站版权信息','text','青岛荣昌金属制造有限公司版权所有。',NULL,NULL,NULL),(6,1,'2013-04-08 00:00:00',1,'2013-04-11 08:05:23','网站联系人','text','Daiqianjie',NULL,NULL,NULL),(9,1,'2013-04-09 00:00:00',1,'2013-04-17 09:59:26','default.footlink','module','<a href=\"jiaozhou.html\" target=\"_self\">胶州集装箱</a> |  <a href=\"chengyang.html\" target=\"_self\">城阳集装箱</a> | <a href=\"jimo.html\" target=\"_self\">即墨集装箱</a> | <a href=\"huangdao.html\" target=\"_self\">黄岛集装箱</a> | <a href=\"pingdu.html\" target=\"_self\">平度集装箱</a> | <a href=\"yinghai.html\" target=\"_self\">营海集装箱</a> | <a href=\"qingdao.html\" target=\"_self\">青岛集装箱</a>',NULL,NULL,NULL),(10,1,'2013-04-09 00:00:00',1,'2013-04-16 13:47:44','网站关键词','text','特种集装箱 黄岛特种集装箱 胶州特种集装箱 城阳特种集装箱',NULL,NULL,NULL),(12,1,'2013-04-10 00:00:00',1,'2013-04-18 08:07:18','index.html','file','<div style=\"float:right;width:100%;\">\n<div class=\"widget-slide widget-slide-2\">\n#{幻灯片广告}\n</div>\n</div>\n#{公司简介}\n#{工程案例}\n				\n				','#{网站名称}-首页','',''),(13,1,'2013-04-16 00:00:00',1,'2013-04-16 17:26:07','default.search','module','<div style=\"margin-top:50px;float:right;background-image:url(searchbg.gif);width:276px;height:30px;\">\n<form class=\"search\" method=\"get\" action=\"#\" style=\"margin:-2px 0 0 8px;\">\n<label for=\"search_2\" >\n<input value=\"Search\" id=\"search_2\" placeholder=\"请输入关键词\" type=\"text\" style=\"font-family:微软雅黑;font-size:10pt;height:21px;width:260px;margin-left:0px;\">\n</label>\n</form>\n</div>',NULL,NULL,NULL),(14,1,'2013-04-16 00:00:00',1,'2013-04-18 19:09:24','default.leftmenu','module','<!--Mega Menu Anchor-->\n<ul id=\"nav2\">\n	<li><a href=\"pro0.html\" id=\"megaanchor\" style=\"font-family:微软雅黑;font-weight:bold;font-size:10pt;\"><img src=\"list.png\" style=\"width:16px;height:16px;margin:0 3px 0 0\"/>特种集装箱</a></li>\n	<li><a href=\"pro1.html\" id=\"megaanchor2\" style=\"font-family:微软雅黑;font-weight:bold;font-size:10pt;\"><img src=\"list.png\" style=\"width:16px;height:16px;margin:0 3px 0 0\"/>多开门箱</a></li>\n	<li><a href=\"pro2.html\" id=\"megaanchor3\" style=\"font-family:微软雅黑;font-weight:bold;font-size:10pt;\"><img src=\"list.png\" style=\"width:16px;height:16px;margin:0 3px 0 0\"/>生活房箱</a></li>\n	<li><a href=\"pro3.html\" id=\"megaanchor4\" style=\"font-family:微软雅黑;font-weight:bold;font-size:10pt;\"><img src=\"list.png\" style=\"width:16px;height:16px;margin:0 3px 0 0\"/>设备箱</a></li>\n	<li><a href=\"pro4.html\" id=\"megaanchor5\" style=\"font-family:微软雅黑;font-weight:bold;font-size:10pt;\"><img src=\"list.png\" style=\"width:16px;height:16px;margin:0 3px 0 0\"/>多功能罐箱</a></li>\n</ul>','','',''),(15,1,'2013-04-16 00:00:00',1,'2013-04-18 19:25:18','default.menu','module','<ul id=\"nav\" style=\"margin:0;padding:0;\">\n	<li><a href=\"index.html\"><span class=\"menuli\">首页</span></a></li>\n	<li><a href=\"introduction.html\"><span class=\"menuli\">公司简介</span></a></li>\n        <li><a href=\"road.html\"><span class=\"menuli\">发展历程</span></a></li>\n	<li><a href=\"pro0.html\"><span class=\"menuli\">产品展示</span></a></li>\n	<li><a href=\"contact.html\"><span class=\"menuli\">联系我们</span></a></li>\n<li><a href=\"jizhuangxiang.html\"><span class=\"menuli\">集装箱特点</span></a></li>\n</ul>','','',''),(16,1,'2013-04-16 00:00:00',1,'2013-04-17 20:24:34','公司简介','module','<div style=\"width:100%;background-color:#F3F3F3;float:right;border:1px solid #D1D1D1;\">\n<div style=\"width:100%;background-image:url(title.gif);height:36px;border-bottom:1px solid #D1D1D1;\">\n<div style=\"width:300px;float:left;padding-top:8px;padding-left:8px;font-weight:bold;\"><img src=\"markyellow.png\" style=\"width:16px;margin-right:3px;\"/>公司简介</div>\n<div style=\"width:300px;float:right;text-align:right;\"><span class=\"more\"><a href=\"introduction.html\">More...</a></span></div>\n</div>\n<div style=\"width:100%;height:100px;font-size:10pt;padding:3px;text-indent:30px;\">\n青岛荣昌金属制造有限公司 是一家以设计、生产制造普通陆运集装箱（标准集装箱和非标准集装箱）、活动房、特种型、展翼箱、侧拉帘集装箱及彩钢板房的专业制造型企业，并销售集装箱、 帘布箱、展翼箱配件。公司产品销往华东、华北、东北等地区并出口韩国、澳大利亚、日本等国。我公司不仅拥有完善的生产设备（包括剪压、部装、总装、打砂、 喷漆、美装等一系列生产流水线），还拥有一支训练有素的专业生产队伍（公司现有一线生产工人186人，其中高级技工45人，中级技工38人）和顶尖的设计 技术人员（其中硕士研究生4人......\n</div>\n</div>',NULL,'',''),(17,1,'2013-04-16 00:00:00',1,'2013-06-25 09:44:57','联系方式','module','<div style=\"margin-top:3px;margin-bottom:3px;width:100%;background-color:#F3F3F3;float:right;border:1px solid #D1D1D1;height:210px\">\n<div style=\"width:100%;background-image:url(title.gif);height:36px;border-bottom:1px solid #D1D1D1;\">\n<div style=\"width:300px;float:left;padding-top:8px;padding-left:8px;font-weight:bold;\"><img src=\"markyellow.png\" style=\"width:16px;height:16px;margin-right:3px;\"/>联系我们</div>\n<div style=\"width:300px;float:right;text-align:right;\"><span class=\"more\"><a href=\"introduction.html\">More...</a></span></div>\n</div>\n<div style=\"width:100%;height:100px;font-size:10pt;padding:30px 0 0 80px;\">\n<span style=\"font-size:14pt;font-weight:bold;color:red;\">青岛荣昌金属制造有限公司</span><br/>\n联系人：任鹏<br/>\n手　机：15725427432<br/>\n电　话：0532-85272189<br/>\n网　址：www.qdrcjs.com<br/>\n地　址：青岛市胶州营海街道办事处<br/>\n</div>\n</div>','','',''),(18,1,'2013-04-16 00:00:00',1,'2013-06-25 09:47:30','联系我们','module','<div style=\"width:210px;background-color:#F3F3F3;padding:0;border:1px solid #D1D1D1;margin-top:3px;\">\n	<div style=\"width:100%;background-image:url(title.gif);height:36px;border-bottom:1px solid #D1D1D1;\">\n			<div style=\"width:200px;float:left;padding-top:8px;padding-left:8px;font-weight:bold;\"><img src=\"markgreen.png\" style=\"width:16px;height:16px;margin-right:3px;\"/>联系我们</div>\n	</div>\n	<div style=\"font-size:10pt;padding:3px 3px 3px 3px;\">\n<strong>青岛荣昌金属制造有限公司</strong><br/>\n联系人：任鹏<br/>\n手　机：15725427432<br/>\n电　话：0532-85272189<br/>\n网　址：<a href=\"http://www.qdrcjs.com\">www.qdrcjs.com</a><br/>\n地　址：<br/>　青岛市胶州营海街道办事处<br/>\n	</div>\n</div>','','',''),(19,1,'2013-04-16 00:00:00',1,'2013-04-18 13:13:42','幻灯片广告','module','    <div style=\"width: 100%;\" class=\"widget-slide-body\">\n        <ul style=\"width: 3360px;\" class=\"widget-slide-contents-piclist\" style=\"list-style:none;\">\n        	<li><a class=\"left\" href=\"#\"><img alt=\"青岛特种箱-崂山海边人度假村项目\" title=\"\" src=\"images/pic1.jpg\" height=\"305\" width=\"745\"></a></li>\n        	<li><a class=\"left\" href=\"#\"><img alt=\"青岛特种箱- 城阳新华制药一期工地项目\" title=\"\" src=\"images/pic2.jpg\" height=\"305\" width=\"745\"></a></li>\n        	<li><a class=\"left\" href=\"#\"><img alt=\"青岛特种箱-胶州少海花园酒店项目\" title=\"\" src=\"images/pic3.jpg\" height=\"305\" width=\"745\"></a></li>\n        	<li><a class=\"left\" href=\"#\"><img alt=\"青岛特种箱-菲律宾蓝卡酒店项目\" title=\"\" src=\"images/pic4.jpg\" height=\"305\" width=\"745\"></a></li>\n        	<li><a class=\"left\" href=\"#\"><img alt=\"青岛特种箱-日本福岛援助项目\" title=\"\" src=\"images/pic5.jpg\" height=\"305\" width=\"745\"></a></li>\n        	<li><a class=\"left\" href=\"#\"><img alt=\"青岛特种箱-德国慕尼黑援助项目\" title=\"\" src=\"images/pic6.jpg\" height=\"305\" width=\"745\"></a></li>\n        </ul>\n    </div>\n    <div class=\"widget-slide-ctrl widget-slide-1-ctrl\" >\n        <a style=\"visibility: visible;\" href=\"\" class=\"widget-slide-ctrl-prev\">&lt;</a>\n        <ul class=\"widget-slide-ctrl-nav\" style=\"list-style:none;\">\n        	<li class=\"\"></li>\n        	<li class=\"\"></li>\n        	<li class=\"\"></li>\n        	<li class=\"current\"></li>\n        	<li class=\"\"></li>\n        	<li class=\"\"></li>\n        </ul>\n        <div style=\"visibility: visible;\" class=\"widget-slide-ctrl-tabs\" id=\"widget-slide-ctrl-tabs\">\n            <ul>\n            	<li class=\"\"><a href=\"#\"><img alt=\"青岛特种箱-崂山海边人度假村项目\" title=\"\" src=\"images/pic1.jpg\" height=\"36\" width=\"53\"></a></li>\n            	<li class=\"\"><a href=\"#\"><img alt=\"青岛特种箱- 城阳新华制药一期工地项目\" title=\"\" src=\"images/pic2.jpg\" height=\"36\" width=\"53\"></a></li>\n            	<li class=\"\"><a href=\"#\"><img alt=\"青岛特种箱-胶州少海花园酒店项目\" title=\"\" src=\"images/pic3.jpg\" height=\"36\" width=\"53\"></a></li>\n            	<li class=\"current\"><a href=\"#\"><img alt=\"青岛特种箱-菲律宾蓝卡酒店项目\" title=\"\" src=\"images/pic4.jpg\" height=\"36\" width=\"53\"></a></li>\n            	<li class=\"\"><a href=\"#\"><img alt=\"青岛特种箱-日本福岛援助项目\" title=\"\" src=\"images/pic5.jpg\" height=\"36\" width=\"53\"></a></li>\n            	<li class=\"\"><a href=\"#\"><img alt=\"青岛特种箱-德国慕尼黑援助项目\" title=\"\" src=\"images/pic6.jpg\" height=\"36\" width=\"53\"></a></li>\n            </ul>\n        </div>\n        <a style=\"visibility: visible;\" href=\"\" class=\"widget-slide-ctrl-next\">&gt;</a>\n    </div>','','',''),(21,1,'2013-04-16 00:00:00',1,'2013-04-20 16:34:45','template.html','template','<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n\"http://www.w3.org/TR/html4/loose.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n<meta name=\"keywords\" content=\"#{网站关键词}\" />\n<meta name=\"description\"	content=\"#{网站描述}\" />\n<title>#{网站名称}</title>\n<style type=\"text/css\">\nbody { font-family:\"verdana\", \"arial\",\"微软雅黑\"; padding-top:1px; background:url(bg.jpg) no-repeat center top;background-color:#efefef;}\ndiv, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form, fieldset, input, textarea, blockquote, p { padding:0; margin:0; }\nimg {border-width:0px;}\n.more { float:right; margin-right:1px; margin-top:8px; color:#fff; display:inline;}\n.more a { text-decoration:nonek; color:#333;}\n\n.picbox { height:180px; overflow:hidden; width:100%; margin:10px 0;}\n.picbox  #prev { width:25px; height:180px; background:url(images/indexbg.gif) no-repeat 0 center; float:left; margin-left:5px; display:inline; cursor:pointer;}\n.picbox .pics { width:690px;float:left; margin:0 1px; display:inline; overflow:hidden;}\n.picbox .pics  img { border:#e0dcd9 1px solid; margin:0 8px; float:left; display: inline; }\n.picbox  #next { width:25px; height:180px; background:url(images/indexbg.gif) no-repeat -30px center;float:right;margin-right:5px; display:inline; cursor:pointer;}\n\n\n#container { margin:0 auto; width:960px;}\n#nav { \n	display:inline-block;\n	list-style:none;\n	margin:10px 0 20px;\n	overflow:hidden;\n	padding:0;\n	width:960px;\n	background-image:url(title.gif);\n	background-position:left top;\n	border-top:1px solid #cecece;\n}\n#nav li {float:left; border-right:1px solid #cecece; -webkit-box-shadow:inset 0 0 0 1px rgba(255,0,255,.1); -moz-box-shadow:inset 0 0 0 1px rgba(255,255,255,.1); }\n#nav li a {color:#000000; display:block; height:36px; line-height:34px; padding:0 30px; text-decoration:none; text-shadow:0 1px #cecece; }\n/*\n#nav li a:hover { background:-webkit-gradient(linear, 0 0, 0 100%, from(#929292), to(#535353)); background:-moz-linear-gradient(top, #929292, #535353); -webkit-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 0 0 1px rgba(255,255,255,.1); -moz-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 0 0 1px rgba(255,255,255,.1); color:#fff; text-shadow:0 -1px #414141; }\n#nav li a:active { -webkit-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); -moz-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); }\n#nav li .current,\n#nav li .current:hover { background:-webkit-gradient(linear, 0 0, 0 100%, from(#373737), to(#525051)); background:-moz-linear-gradient(top, #373737, #525051); -webkit-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); -moz-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); color:#fff; text-shadow:0 1px #242323; }\n*/\n#nav2 {width:210px;list-style:none;margin:0px;padding:0px;}\n#nav2 li {width:210px;background-image:url(bgblack.png);background-position:left top;height:36px;}\n#nav2 li a {color:#000000; display:block; height:36px; line-height:36px; padding:0 10px; text-decoration:none;}\n#nav2 li a:hover { background:-moz-linear-gradient(top, #929292, #535353); -webkit-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 0 0 1px rgba(255,255,255,.1); -moz-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 0 0 1px rgba(255,255,255,.1); color:#fff; text-shadow:0 -1px #414141; }\n#nav2 li .current,\n#nav2 li .current:hover { background:-webkit-gradient(linear, 0 0, 0 100%, from(#373737), to(#525051)); background:-moz-linear-gradient(top, #373737, #525051); -webkit-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); -moz-box-shadow:inset 0 -10px 20px rgba(0,0,0,.05), inset 0 2px 5px #363636, inset 0 0 0 1px rgba(255,255,255,.1); color:#fff; text-shadow:0 1px #242323; }\n\n\n.search {padding:7px 20px 8px 5px; }\n.search label { display:block; height:20px; }\n.search input { border:none; color:#a9a9a9; height:12px; margin-left:25px; -webkit-appearance:none; }\n.search input:focus { border:none; outline:none; }\n.search.focus { background-position:right -83px; padding:3px 20px 2px 5px; }\n.search.focus label { background-position:0 -26px; height:27px; padding-top:4px; }\n\nh1 { margin-bottom:0; }\n.read_article { color:#777; display:block; font-size:12px; margin-bottom:30px; }\n.menuli{font-family:微软雅黑;font-weight:bold;font-size:10pt;}\n\n\n.left { float:left; }\n.right { float:right; margin-right:60px;}\n\n\na { color:#252525; text-decoration:none; }\na:visited { text-decoration:none; }\na:hover { color:#ba2636; text-decoration:underline; }\na:active { color:#ba2636; }\n.more a:hover { color: #BA2636; }\n.more a, .more a:visited { color:#888; }\n</style>\n<style type=\"text/css\">\n.widget-slide-content-text { padding: 10px; width: 140px; }\n    .widget-slide-content-text h4 { line-height: 25px; padding-bottom: 5px; overflow: hidden; font-family: \"Microsoft YaHei\", \"微软雅黑\"; font-size: 17px; font-weight: bold; text-align: left; }\n    .widget-slide h4 a, .widget-slide h4 a:visited { color:#4E4E4E; }\n    .widget-slide h4 a:hover { color: #BA2636; }\n    .widget-slide-content-text p { color: #888888; line-height: 21px; padding-top: 12px; clear: both;font-size:10px;}\n    .widget-slide-ctrl div, .widget-slide-ctrl-tabs li { display: inline; float: left; }\n    .widget-slide-ctrl-tabs {bottom: 12px; margin: 0px 16px 0 185px; overflow: hidden; position: absolute; width: 370px; visibility: hidden; }\n    .widget-slide-ctrl-tabs ul { overflow: hidden; width: 9999px; }\n    .widget-slide-ctrl-tabs li { width: 62px; }\n    .widget-slide-ctrl-tabs img { border: 2px solid #a7a5af; opacity: 0.8; filter:alpha(opacity=80); padding: 0px; }\n    .widget-slide-ctrl-tabs .current img { border: 2px solid #2db3e9; opacity: 1; filter:alpha(opacity=100); padding: 0px; }\n    .widget-slide {overflow: hidden; position: relative; }\n    .widget-slide-body { overflow: hidden; _position: relative; }\n    .widget-slide-1 { width:270px; padding-top: 28px;}\n    .widget-slide-2 { height: 305px; width: 745px;  margin-bottom: 10px; overflow: hidden; background: none repeat scroll 0px 0px #F3F3F3; }\n    .widget-slide .widget-slide-contents-piclist { width: 9999px;}\n    .widget-slide-contents-piclist li { float: left;  width: 745px; list-style-type:none;}\n\n    .widget-slide-ctrl-prev, .widget-slide-ctrl-next {font-family:\"Arial\"; background-color: #333333; color: #FFFFFF; display: inline-block; font-weight: bold; opacity: 0.6; filter:alpha(opacity=60); position: absolute; text-align: center; text-decoration: none; visibility: hidden; }\n    .widget-slide-ctrl-prev:hover, .widget-slide-ctrl-next:hover { background-color:#000; color:#fff; opacity: 0.8; filter:alpha(opacity=80); text-decoration:none; }\n    .widget-slide-1-ctrl .widget-slide-ctrl-prev, .widget-slide-1-ctrl .widget-slide-ctrl-next { border-radius: 21px 21px 21px 21px; bottom: 112px; font-size: 36px; height: 42px; line-height: 42px; width: 42px; }\n    .widget-slide-2-ctrl .widget-slide-ctrl-prev, .widget-slide-2-ctrl .widget-slide-ctrl-next { border-radius: 15px; bottom: 70px; height: 30px; line-height: 30px; font-size: 24px; width: 30px; }\n    .widget-slide-3-ctrl .widget-slide-ctrl-prev, .widget-slide-3-ctrl .widget-slide-ctrl-next { border-radius: 20px; bottom: 150px; height: 40px; line-height: 40px; font-size: 28px; width: 40px; }\n    .widget-slide-4-ctrl .widget-slide-ctrl-prev, .widget-slide-4-ctrl .widget-slide-ctrl-next { border-radius: 20px; bottom: 130px; height: 40px; line-height: 40px; font-size: 28px; width: 40px; }\n    .widget-slide-5-ctrl .widget-slide-ctrl-prev, .widget-slide-5-ctrl .widget-slide-ctrl-next { border-radius: 15px; bottom: 65px; height: 30px; line-height: 30px; font-size: 24px; width: 30px;  }\n    .widget-slide-1-ctrl .widget-slide-ctrl-prev { left: 15px; }\n    .widget-slide-1-ctrl .widget-slide-ctrl-next { left: 690px; }\n    .widget-slide-2-ctrl .widget-slide-ctrl-prev { left: 10px; }\n    .widget-slide-2-ctrl .widget-slide-ctrl-next { left: 185px; }\n    .widget-slide-3-ctrl .widget-slide-ctrl-prev { left: 10px; }\n    .widget-slide-3-ctrl .widget-slide-ctrl-next { left: 310px; }\n    .widget-slide-4-ctrl .widget-slide-ctrl-prev { left: 0px; }\n    .widget-slide-4-ctrl .widget-slide-ctrl-next { left: 920px; }\n    .widget-slide-5-ctrl .widget-slide-ctrl-prev { left: 10px; }\n    .widget-slide-5-ctrl .widget-slide-ctrl-next { left: 185px; }\n</style>\n\n<link rel=\"stylesheet\" type=\"text/css\" href=\"include/jkmegamenu.css\" />\n\n</head>\n<body >\n	<div id=\"container\">\n	<table style=\"width:100%;padding:0;margin:0px;\" cellspacing=\"0\">\n		<tr>\n			<td style=\"width:30%;\">\n			</td>\n			<td style=\"width:70%;\">\n#{default.search}\n			</td>\n		</tr>\n		<tr>\n			<td colspan=\"2\">\n				#{default.menu}\n			</td>\n		</tr>\n	</table>\n	<table style=\"width:100%;padding:0;margin:0px;\" cellspacing=\"0\">\n		<tr>\n			<td  valign=\"top\" style=\"width:214px;padding:0 3px 0 0;\">\n				#{default.leftmenu}\n				#{联系我们}\n			</td>\n			<td  valign=\"top\" style=\"width:*;background-color:#fff;\">\n				#{body}\n			</td>\n		</tr>\n		<tr>\n			<td colspan=\"2\">\n				<div style=\"margin-top:10px;width:100%;height:8px;background-color:#01A2FF;\"></div>\n				<div style=\"margin-top:3;width:100%;text-align:center;font-size:13px;\">\n					#{default.footlink}\n				</div>\n			</td>\n		</tr>	\n		<tr>\n			<td colspan=\"2\">\n				<div style=\"margin-top:3;width:100%;text-align:center;font-size:12px;margin-top:3px;\">#{网站名称}&nbsp;<a href=\"http://sdcainfo.miitbeian.gov.cn\" target=\"_blank\">#{网站备案信息}</a><script src=\"http://s20.cnzz.com/stat.php?id=5240842&web_id=5240842&show=pic\" language=\"JavaScript\"></script></div>\n			</td>\n		</tr>	\n	</table>	\n			\n		\n\n</div>\n\n	\n\n	\n\n\n\n<script charset=\"gb2312\" src=\"include/ntes_jslib_1.js\" language=\"javascript\" type=\"text/javascript\"></script>\n\n<script type=\"text/javascript\">\n	var _gaq = _gaq || [];_gaq.push([\'_setAccount\', \'UA-1586316-16\']);_gaq.push([\'_trackPageview\']);(function() {var ga = document.createElement(\'script\'); ga.type = \'text/javascript\'; ga.async = true;ga.src = (\'https:\' == document.location.protocol ? \'https://ssl\' : \'http://www\') + \'.google-analytics.com/ga.js\';var s = document.getElementsByTagName(\'script\')[0]; s.parentNode.insertBefore(ga, s);})();\n</script>\n\n\n<script type=\"text/javascript\" language=\"javascript\" src=\"include/ntes_ui_scroll.js\" charset=\"gb2312\"></script>\n\n<script type=\"text/javascript\">\n    //Widget Slide\n    /*鼠标放上去出现切换大按钮和缩略图列表*/\n    var ctrlTabs = $(\'.widget-slide-ctrl-tabs\');\n    var ctrlPrev = $(\'.widget-slide-ctrl-prev\');\n    var ctrlNext = $(\'.widget-slide-ctrl-next\');\n    var FOCUS_DELAY;\n    $(\'.widget-slide\').addEvent(\'mouseover\',function(){\n        clearTimeout(FOCUS_DELAY);\n        $( \".widget-slide-ctrl-tabs\", $(this)).addCss(\'visibility:visible;\');\n        $( \".widget-slide-ctrl-prev\", $(this)).addCss(\'visibility:visible;\');//类似于find(),$(selector, abc)\n        $( \".widget-slide-ctrl-next\",  $(this)).addCss(\'visibility:visible;\');\n    }) .addEvent(\'mouseout\',function(){\n                //当前函数没有执行对象，就用一个变量储存当前的this\n                var t = this;\n                FOCUS_DELAY = setTimeout(function(){\n                    $( \".widget-slide-ctrl-tabs\", $(t)).addCss(\'visibility:hidden;\');\n                    $( \".widget-slide-ctrl-prev\", $(t)).addCss(\'visibility:hidden;\');\n                    $( \".widget-slide-ctrl-next\",  $(t)).addCss(\'visibility:hidden;\');\n                }, 25);\n            });\n    /*鼠标放小切换图上，出现切换图标*/\n    //Mod Scroll\n    (function(){\n        var Scrl = function(elem){\n            var axis = \"x\";\n            if ( $(elem).attr(\"class\").indexOf(\"mod-scroll-y\") != -1 ) axis = \"y\";\n            var t = this, body = NTES.one(\"> div.widget-slide-body > ul\", elem);\n            t._ctrls = $(\"> div.widget-slide-ctrl > ul.widget-slide-ctrl-nav > li\", elem);\n            t._ctrls_img = $(\"> div.widget-slide-ctrl > div.widget-slide-ctrl-tabs > ul > li\", elem);\n            t._len = t._ctrls.length;\n            t.index = 0;\n            //修复滚动图片不出来bug\n            var gsty = NTES.style.getCurrentStyle,\n                    onli = NTES.one(\"> li\", body),\n                    offWidth = onli.offsetWidth || (parseInt(gsty(onli, \"width\")) + parseInt(gsty(onli, \"padding-left\")) + parseInt(gsty(onli, \"padding-right\")));\n            this._elem = elem;\n            //\n            if (axis == \"x\"){\n                var bWidth = offWidth * body.$(\"> li\").length;\n//                var bWidth = NTES.one(\"> li\", body).offsetWidth * body.$(\"> li\").length;\n                t._step = bWidth / t._len;\n                body.addCss({ width: bWidth + \"px\"});\n                $(body.parentNode).addCss({ width: t._step + \"px\"});\n            }else{\n                t._step = NTES.one(\"> li\", body).offsetHeight;\n                var bHeight = t._step * t._len;\n                body.addCss({ height: bHeight + \"px\"});\n                $(body.parentNode).addCss({ height: t._step + \"px\"});\n            }\n            t._scrl = new NTES.ui.Scroll(body, axis);\n            if (axis == \"y\"){\n                t._scrl.speed = 50;//50\n                t._scrl.fps = 20;//20\n                t._scrl.lpf = 1;\n            }\n            /*鼠标放到切换小按钮，切换大图*/\n            t._ctrls.each(function(i){\n                $(this).addEvent(\"mouseover\", t.show.bind(t, i), i);\n            });\n            /*鼠标放到缩略图上，切换大图*/\n            t._ctrls_img.each(function(i){\n                $(this).addEvent(\"mouseover\", t.show.bind(t, i), i);\n            });\n            /*鼠标点击左右切换按钮，切换大图*/\n            NTES.one(\"> div.widget-slide-ctrl > a.widget-slide-ctrl-prev\", elem).addEvent(\"click\", function(e){\n                e.preventDefault();\n                t.show(--t.index);\n            }).addEvent(\"mouseup\", function(){ this.blur(); });\n            NTES.one(\"> div.widget-slide-ctrl > a.widget-slide-ctrl-next\", elem).addEvent(\"click\", function(e){\n                e.preventDefault();\n                t.show(++t.index);\n            }).addEvent(\"mouseup\", function(){ this.blur(); });\n            t.show(0);\n        }\n        Scrl.prototype = {\n            show: function(i){\n                var t = this;\n                t.index = i < 0 ? t._len - 1 : i > t._len - 1 ? 0 : i;\n                t._scrl.onStart = function(){\n                    t._ctrls.removeCss(\"current\");\n                    t._ctrls.$(t.index).addCss(\"current\");\n                    if(t._ctrls_img.length > 0){\n                        t._ctrls_img.removeCss(\"current\");\n                        t._ctrls_img.$(t.index).addCss(\"current\");\n                    }\n                }\n                t._scrl.scrollTo(t._step * t.index);\n            }\n        }\n        $(\"div.widget-slide\").each(function(){\n            new Scrl(this);\n        });\n    })();\n</script>\n<!-- 为防止js冲突，将此代码放在广告图片之后 -->\n<script src=\"include/jquery.js\" type=\"text/javascript\"></script>\n<script src=\"include/ga.js\" async=\"\" type=\"text/javascript\"></script>\n<script type=\"text/javascript\" src=\"include/jkmegamenu.js\"></script>\n<script type=\"text/javascript\">\njkmegamenu.definemenu(\"megaanchor\", \"megamenu1\", \"mouseover\")\n</script>\n<!-- 为防止js冲突，将此代码放在广告图片之后 -->\n<script src=\"include/jquery.js\" type=\"text/javascript\"></script>\n<script>\neval(function(p,a,c,k,e,d){e=function(c){return(c<a?\"\":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!\'\'.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return\'\\\\w+\'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp(\'\\\\b\'+e(c)+\'\\\\b\',\'g\'),k[c]);return p;}(\'$(5(){$(\\\'.g\\\').n(0).h();$(\".u t\").z(5(){9 e=$(\".u t\").y($(q));$(q).A(\\\'C\\\').o().B();$(\\\'.g\\\').n(e).h().o(\\\'.g\\\').l()});9 a=1;9 b=$(\\\'.2 w\\\').x();9 c=b-3;9 d=$(\\\'.2>4\\\').m()+J;$(\\\'.2>4\\\').8(\\\'m\\\',d);$(\"#I\").r(5(){$(\\\'.2>4\\\').8(\"7-6\",\"-f\");$(\\\'.2>4\\\').j({\\\'7-6\\\':\\\'0\\\'},\\\'k\\\',5(){$(\\\'.2>4\\\').8({\"7-6\":\"-f\"});$(\\\'.2>4\\\').p(\\\'a:v\\\').D($(\\\'.2>4 a:s\\\'))});});$(\"#F\").r(5(){$(\\\'.2>4\\\').8(\"7-6\",\"0\");$(\\\'.2>4\\\').j({\\\'7-6\\\':\\\'-f\\\'},\\\'k\\\',5(){$(\\\'.2>4\\\').8({\"7-6\":\"0\"});$(\\\'.2>4\\\').p(\\\'a:s\\\').H($(\\\'.2>4 a:v\\\'))});});$(\\\'.i\\\').G(5(){$(\\\'.E\\\').l();$(\\\'.i\\\').h()})});\',46,46,\'||pics||div|function|left|margin|css|var||||||226px|tabcon|show|share_self|animate|slow|hide|width|eq|siblings|find|this|click|last|li|tab|first|img|size|index|hover|addClass|removeClass|cur|before|loading|next|load|after|prev|226\'.split(\'|\'),0,{}))\n</script>\n<!-- 搜索框 -->\n<script>\n$(function() {\n	var $placeholder = $(\'input[placeholder]\');\n	if ($placeholder.length > 0) {\n		var attrPh = $placeholder.attr(\'placeholder\');\n		$placeholder.attr(\'value\', attrPh)\n		  .bind(\'focus\', function() {\n			var $this = $(this),\n				$form = $this.parents(\'.search\');\n			if($this.val() === attrPh)\n				$this.val(\'\').css(\'color\',\'#333\');\n			$form.addClass(\'focus\');\n		}).bind(\'blur\', function() {\n			var $this = $(this),\n				$form = $this.parents(\'.search\');\n			if($this.val() === \'\')\n				$this.val(attrPh).css(\'color\',\'#a9a9a9\');\n			$form.removeClass(\'focus\');\n		});\n	}\n});\n</script>\n</body>\n</html>','','',''),(22,1,'2013-04-16 00:00:00',1,'2013-04-18 19:14:52','pro0.html','file','<p>&nbsp;</p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro001.jpg\" alt=\"青岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro002.jpg\" alt=\"胶州集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro003.jpg\" alt=\"城阳集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro004.jpg\" alt=\"即墨集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro005.jpg\" alt=\"黄岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro006.jpg\" alt=\"营海集装箱\" /></p>\n<p style=\"text-align: left; margin: 6px;\"><span style=\"font-size: small;\"><strong>工程箱简介</strong><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 工程用集装箱，简称&ldquo;工程箱&rdquo;它是海运集装箱的又一延伸产品，工程箱一方面保持了海运的标准规格、外形特征，另一方面又能根据各类工程的需要，设计成能满足工程任务的特种集装箱。<br />工程箱的品种种类繁多，主要有：柴油机发电工程箱，压缩空气站工程箱，各类维修工程箱，变电站工程箱，程控电话机房工程箱，发电厂及破碎作业的中心控制房工程箱等。<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 各种功率的柴油机发电工程箱是一种移动的应急电站，一般作宾馆，医院。学校，舰船，工矿企业的备用电站用。柴油机发电工程箱有集装箱箱体，柴油发电机，冷却水箱，消音器及油箱等组成。其中集装箱体设隔热隔音层，工作时噪音低，符合环保要求。<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 压缩空气站工程箱简称空压站箱，常用于喷砂（丸）清理工程、油漆作业工程、砂山作业及各种建设工程中，由于其移动性能好，每台空压站箱内集成了固定空压站中相同的一切设施，在任何地方，只要接通水源电源即能正常工作。<br />&nbsp;<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 各类维修工程箱不论在海上或陆地上，该工程箱内集成了一个维修工场所需要的全部设备与工具。同样接上电源即能进行各类维修作业。</span></p>','胶州特种箱-#{网站名称}','青岛特种箱 胶州特种箱',''),(23,1,'2013-04-16 00:00:00',1,'2013-04-18 19:02:23','road.html','file','<p style=\"text-align: center;\"><img style=\"border: 0; vertical-align: middle;\" src=\"images/road.jpg\" alt=\"青岛荣昌金属制造有限公司发展历程\" width=\"400\" /></p>\n<p style=\"padding-left: 60px;\"><span style=\"font-size: small;\"><span style=\"position: relative;\"><br /><span style=\"font-family: arial black,avant garde;\">1997年1月&nbsp; 公司在青岛胶州市营海投资建成。<br /><br />1997年8月&nbsp; 开始生产复合门和冷藏集装箱用塑料挤出产品(PE&amp;PVC)。<br /><br />2006年9月&nbsp; 公司扩大规模，迁址至营海工业园内。<br /><br />2008年7月&nbsp; 正式开始生产特种集装箱和钢结构产品。<br /><br />2009年11月 获得日本钢构造生产许可&rdquo;R&rdquo;级证书。<br /><br />2010年3月&nbsp; 获得有中国船级社颁发的ISO集装箱生产质量认证证书（CCC&amp;CSC）。<br /><br />2010年11月 获得韩国船务颁发的集装箱制造证书。</span><br /></span></span></p>','发展历程-#{网站名称}','',''),(24,1,'2013-04-16 00:00:00',1,'2013-04-18 19:04:48','contact.html','file','#{公司简介}\n#{联系方式}\n<br/>\n<br/>\n<iframe src=\"http://www.specialcontainer.com/plugin/ThirdPartyPluginAspects/mapabc/mapShow.aspx?em=false&amp;w=744&amp;h=285&amp;aspectUid=d2-275455475-2a10&amp;siteId=374000\" frameborder=\"0\" height=\"285\" scrolling=\"no\" width=\"744\"></iframe>','联系我们-#{网站名称}','',''),(25,1,'2013-04-17 00:00:00',1,'2013-04-17 10:17:53','工程案例','module','<div style=\"width:100%;margin-top:3px;background-color:#F3F3F3;float:right;border:1px solid #D1D1D1;\">\n<div style=\"width:100%;background-image:url(title.gif);height:36px;border-bottom:1px solid #D1D1D1;\">\n		<div style=\"width:200px;float:left;padding-top:8px;padding-left:8px;font-weight:bold;\"><img src=\"markblue.png\" style=\"width:16px;margin-right:3px;\"/>工程案例</div>\n		<div style=\"width:200px;float:right;text-align:right;\"><span class=\"more\"><a href=\"index.html\">More...</a></span></div>\n</div>\n<div style=\"width:100%;font-size:10pt;padding:0;\">\n	<div class=\"picbox\" style=\"margin:0;padding:0;\">\n		<div id=\"prev\" style=\"margin:0;padding:0;\"></div>\n       <div class=\"pics\">\n         <div style=\"overflow: hidden; width: 650px; margin-left: 1px;\">\n					<a href=\"jiaozhou.html\" alt=\"胶州中集职工宿舍项目\"><img src=\"files/p1.jpg\"></a>\n					<a href=\"chengyang.html\" alt=\"城阳幸福里项目\"><img src=\"files/p2.jpg\"></a>\n					<a href=\"huangdao.html\" alt=\"黄岛小珠山旅游酒店\"><img src=\"files/p3.jpg\"></a>\n					<a href=\"yinghai.html\" alt=\"营海工业园项目\"><img src=\"files/p4.jpg\"></a>\n					<a href=\"jimo.html\" alt=\"胶州中集职工宿舍项目\"><img src=\"files/p5.jpg\"></a> \n					<a href=\"huangdao.html\" alt=\"黄岛大炼油职工宿舍项目\"><img src=\"files/p6.jpg\"></a> \n					<a href=\"jiaozhou.html\" alt=\"胶州中集职工宿舍项目\"><img src=\"files/p7.jpg\"></a> \n				</div>\n			</div>\n		<div id=\"next\" style=\"margin:0;padding:0;\"></div>\n	</div>\n</div>\n</div>',NULL,NULL,NULL),(26,1,'2013-04-17 00:00:00',1,'2013-04-18 19:04:11','jiaozhou.html','file','<div style=\"float:right;width:100%;\">\n<div class=\"widget-slide widget-slide-2\">\n#{幻灯片广告}\n</div>\n</div>\n#{公司简介}\n#{工程案例}\n				\n				','胶州集装箱-#{网站名称}','胶州集装箱 胶州特种箱 胶州集装箱房屋',''),(27,1,'2013-04-17 00:00:00',1,'2013-04-18 19:03:52','pingdu.html','file','<div style=\"float:right;width:100%;\">\n<div class=\"widget-slide widget-slide-2\">\n#{幻灯片广告}\n</div>\n</div>\n#{公司简介}\n#{工程案例}\n				\n				','平度特种箱-#{网站名称}','平度集装箱 平度特种箱 平度集装箱房屋',''),(28,1,'2013-04-17 00:00:00',1,'2013-04-18 19:04:31','huangdao.html','file','<div style=\"float:right;width:100%;\">\n<div class=\"widget-slide widget-slide-2\">\n#{幻灯片广告}\n</div>\n</div>\n#{公司简介}\n#{工程案例}\n				\n				','黄岛特种箱-#{网站名称}','黄岛集装箱 黄岛特种箱 黄岛集装箱房屋',''),(29,1,'2013-04-17 00:00:00',1,'2013-04-18 19:02:13','yinghai.html','file','<div style=\"float:right;width:100%;\">\n<div class=\"widget-slide widget-slide-2\">\n#{幻灯片广告}\n</div>\n</div>\n#{公司简介}\n#{工程案例}\n				\n				','胶州营海集装箱-#{网站名称}','胶州营海集装箱 胶州营海特种箱 胶州营海集装箱房屋',''),(30,1,'2013-04-17 00:00:00',1,'2013-04-18 19:04:01','jimo.html','file','<div style=\"float:right;width:100%;\">\n<div class=\"widget-slide widget-slide-2\">\n#{幻灯片广告}\n</div>\n</div>\n#{公司简介}\n#{工程案例}\n				\n				','即墨特种箱-#{网站名称}','即墨集装箱 即墨特种箱 即墨集装箱房屋',''),(32,1,'2013-04-17 00:00:00',1,'2013-04-18 19:02:35','qingdao.html','file','<div style=\"float:right;width:100%;\">\n<div class=\"widget-slide widget-slide-2\">\n#{幻灯片广告}\n</div>\n</div>\n#{公司简介}\n#{工程案例}\n				\n				','青岛集装箱-#{网站名称}','青岛集装箱 青岛特种箱 青岛集装箱房屋',''),(33,1,'2013-04-17 00:00:00',1,'2013-04-18 19:04:59','chengyang.html','file','<div style=\"float:right;width:100%;\">\n<div class=\"widget-slide widget-slide-2\">\n#{幻灯片广告}\n</div>\n</div>\n#{公司简介}\n#{工程案例}\n				\n				','城阳特种箱-#{网站名称}','城阳集装箱 城阳特种箱 城阳集装箱房屋',''),(35,1,'2013-04-17 00:00:00',1,'2013-04-18 19:04:19','introduction.html','file','<p>&nbsp;</p>\n<p style=\"text-align: center;\"><img style=\"border: 0;\" src=\"images/introduction.jpg\" alt=\"青岛荣昌金属制造有限公司\" /></p>\n<p><span style=\"font-size: small;\"><strong>&nbsp;&nbsp;&nbsp; 青岛荣昌金属制造有限公司</strong>坐落于没有的胶州湾，一厂区位于胶州湾高速胶州出口处，胶州湾跨海大桥，交通便捷，地理位置优越。</span></p>\n<p><span style=\"font-size: small;\"><br />&nbsp;&nbsp;&nbsp;  青岛荣昌金属制造有限公司是一家是一家以设计、生产特种集装箱（功能房、电气设备箱、水处理设备箱等其他设备箱）、集装箱活动房（野营房、宿舍、办公 房）、普通陆运集装箱（标准集装箱和非标准集装箱）、展翼箱及彩钢板房的专业制造型企业，并销售集装箱、帘布箱、展翼箱配件。  公司产品销往华东、华北、东北等地区并出口韩国、澳大利亚、日本等国。我公司不仅拥有完善的生产设备（包括剪压、部装、总装、打砂、喷漆、美装等一系列生 产流水线），还拥有一支训练有素的专业生产队伍（公司现有一线生产工人186人，其中高级技工45人，中级技工38人）和顶尖的设计技术人员（其中硕士研 究生4人，本科学历专业人才10人，专科学历20人），并依靠严格的科学管理为产品提供高品质的保证！众合同创集装箱有限公司经过多年努力，已获得多项质 量认证证书（ISO质量管理体系证书与中国船级社CCS工厂资质认证），客户的认可与满意是我们不断的追求！<br />青岛荣昌金属制造有限公司 经营理念：以质量求生存，以诚信求发展。</span></p>\n<p style=\"padding-left: 30px;\"><strong><span style=\"font-size: small;\"><br />服务理念：我们的发展来自于客户的满意<br />发展目标：全力打造华北地区乃至全国的集装箱专业生产基地！<br />我们坚信：我们长期真诚的付出获得客户的信任！</span></strong></p>\n<p><span style=\"font-size: small;\"><br />&nbsp;&nbsp;&nbsp; 我们将竭尽全力为广大新老客户热情服务，并本着&ldquo;互惠互利，共同发展&rdquo;的原则。一如既往的与各位新老朋友真诚合作，共创美好未来！</span></p>\n<p><span style=\"font-size: small;\"><br />&nbsp;&nbsp;&nbsp; 欢迎新老客户来厂参观指导，我们将与客户同行，共创辉煌! </span></p>','公司简介-#{网站名称}','',''),(36,1,'2013-04-17 00:00:00',1,'2013-04-18 19:03:32','pro1.html','file','<p>&nbsp;</p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro101.jpg\" alt=\"青岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro102.jpg\" alt=\"胶州集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro103.jpg\" alt=\"城阳集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro104.jpg\" alt=\"即墨集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro105.jpg\" alt=\"黄岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro106.jpg\" alt=\"营海集装箱\" /></p>','青岛多开门箱-#{网站名称}','青岛多开门箱 胶州多开门箱',''),(37,1,'2013-04-17 00:00:00',1,'2013-04-18 19:03:23','pro2.html','file','<p>&nbsp;</p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro201.jpg\" alt=\"青岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro202.jpg\" alt=\"胶州集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro203.jpg\" alt=\"城阳集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro204.jpg\" alt=\"即墨集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro205.jpg\" alt=\"黄岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro206.jpg\" alt=\"营海集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0;width:480px;height:300px;\" src=\"images/pro/pro207.jpg\" alt=\"营海集装箱\" /></p>','青岛生活房箱-#{网站名称}','胶州生活房箱 青岛生活房箱',''),(38,1,'2013-04-17 00:00:00',1,'2013-04-18 19:12:04','pro3.html','file','<p>&nbsp;</p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro301.jpg\" alt=\"青岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro302.jpg\" alt=\"胶州集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro303.jpg\" alt=\"城阳集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro304.jpg\" alt=\"即墨集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro305.jpg\" alt=\"黄岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro306.jpg\" alt=\"营海集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro307.jpg\" alt=\"营海集装箱\" /></p>\n<p style=\"text-align: left; margin: 6px; padding-left: 150px;\"><span style=\"font-size: small;\">类型：特种集装箱<br />总重：30<br />自重：6<br />容积：75<br />内部尺寸：12000*2340*2700 <br />外部尺寸：12192*2438*2896<br />材质：钢集装箱<br />结构：特种集装箱<br />载重：30吨集装箱</span></p>','青岛设备箱-#{网站名称}','胶州设备箱 青岛设备箱',''),(39,1,'2013-04-17 00:00:00',1,'2013-04-18 19:08:50','pro4.html','file','<p>&nbsp;</p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro401.jpg\" alt=\"青岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro402.jpg\" alt=\"胶州集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro403.jpg\" alt=\"城阳集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro404.jpg\" alt=\"即墨集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro405.jpg\" alt=\"黄岛集装箱\" /></p>\n<p style=\"text-align: center;margin:6px;\"><img style=\"border: 0; width: 480px; height: 300px;\" src=\"images/pro/pro406.jpg\" alt=\"营海集装箱\" /></p>\n<p style=\"text-align: left; margin: 6px;\"><span style=\"font-size: small;\"><strong>罐箱运输优点介绍：</strong><br /> 一、经济实惠<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 					       例如：一个20英尺集装罐（24000升）可比一个码满圆桶的20尺标准干货箱多装载45%的液态货物。也就是&ldquo;同等运费多出货&rdquo;从而降低了单位货物的陆 运及海运费用。此外，使用罐箱可节省圆桶的购买用丢弃处理费用。这是运输过程中两项直接节约成本之处。 </span></p>\n<p style=\"text-align: left; margin: 6px;\"><span style=\"font-size: small;\"><br /> 二、快捷<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 					      罐箱的使用，不会有昂贵而耗时的小桶冲装，小桶装卸过程。可在公路、铁路、水运之间直接转换运输方式，操作简单快捷，一步到位。可真正做到&ldquo;门到门&rdquo;运输。 </span></p>\n<p style=\"text-align: left; margin: 6px;\"><span style=\"font-size: small;\"><br /> 三、增加安全性 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 					      罐箱运输是国际公认的最安全的化工品及食品运输方式。在将化工品及食品向各地分拨运输过程中，同其它方式相比， 这是一种绝无仅有无跑，冒，漏及避免货物自身被污染的运输工具。</span></p>\n<p style=\"text-align: left; margin: 6px;\"><span style=\"font-size: small;\"> <br /> 四、更利于环保；更美观，给客户以良好印象。 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 					      欧、美、日等国有关法律规定，对于一些货物必须使用罐箱运输，并遏制使用桶装运输。由此可见罐箱这种运输工具的优越性和在国际上的普及程度。中国已加入WTO，随着与国际的逐步接轨。这种不会对环境造成污染的运输方式必将在中国流行开来。 <br /> 选择租赁罐箱运输，除了罐箱整体的外观，能为您的企业树立良好的外部形象外。请注意我们提供的是&ldquo;租赁服务&rdquo;－－国际公认的具有：&ldquo;不积压资金&rdquo;，&ldquo;灵话 多变&rdquo;等众多优点的经营方式。我们将以国际罐箱租赁领袖的管理模式和标准为中国的客户提供卓越的服务。</span></p>','青岛罐箱-#{网站名称}','胶州罐箱 青岛罐箱',''),(40,1,'2013-04-18 00:00:00',1,'2013-04-18 19:24:39','jizhuangxiang.html','file','<p><span style=\"font-size: small;\"><strong>一、集装箱运输</strong><br />利用集装箱运输货物的方式是一种方便又灵活的运输措施。现在已被众多的货主所采用，他可以在最大限度上减少运输过程中造成的货损。比如可以抵御风雨、外力等一些不可避免的因素对货物造成的损害，一直以来集装箱业务以其保障性高，运输费用低，深受广大货主的钟爱。<br /><strong>二、集装箱运输的优点</strong><br />1、由于集装箱具有抵抗风雨、避光、抗震等作用，因此用集装箱运输货物能够最大限度的减少货损。<br />2、集装箱的整箱搬运，极大的方便了运输，极大的方便装船和卸港。<br />3、集装箱的铅封由于号码唯一，所以足以保证货物所有人的货物不会发生丢失、被窃的现象。<br />4、保温冷藏箱，能够对许多鲜活物品进行长时间的保鲜，这是其它运输方式所无法实现的。<br /><strong>三、集装箱整箱流转过程</strong><br />1、发货人在自己工厂或仓库装箱地点配置集装箱。<br />2、发货人在自己工厂或仓库装箱地点配箱、装箱。<br />3、通过内陆运输，将集装箱货物运至集装箱码头。<br />4、根据堆场计划在对场内暂存集装箱货物，等待装船。<br />5、根据装船计划，将集装箱货物装上船舶。<br />6、通过海上运输，将集装箱货运至目的港卸船。<br />7、根据卸船计划，从船上卸下集装箱货物。<br />8、根据堆场计划在堆场内暂存集装箱货物，等待收货人前来提货。<br />9、通过内陆运输，将集装箱货物运至收货人工厂或仓库。<br />10、收货人在自己工厂和仓库掏箱地点掏箱。<br />11、集装箱空箱回运。</span></p>','集装箱的特点-#{网站名称}','青岛特种箱 胶州特种箱','');
/*!40000 ALTER TABLE `web_prop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_form_main`
--

DROP TABLE IF EXISTS `core_form_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_form_main` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `formId` int(11) DEFAULT '0',
  `field` varchar(45) DEFAULT NULL,
  `field2` varchar(45) DEFAULT NULL,
  `field3` varchar(45) DEFAULT NULL,
  `field4` varchar(45) DEFAULT NULL,
  `field5` varchar(45) DEFAULT NULL,
  `field6` varchar(450) DEFAULT NULL,
  `field7` varchar(450) DEFAULT NULL,
  `field8` varchar(450) DEFAULT NULL,
  `field9` varchar(450) DEFAULT NULL,
  `field10` varchar(450) DEFAULT NULL,
  `field11` int(10) unsigned DEFAULT NULL,
  `field12` int(10) unsigned DEFAULT NULL,
  `field13` int(10) unsigned DEFAULT NULL,
  `field14` int(10) unsigned DEFAULT NULL,
  `field15` int(10) unsigned DEFAULT NULL,
  `field16` double DEFAULT NULL,
  `field17` float DEFAULT NULL,
  `field18` float DEFAULT NULL,
  `field19` float DEFAULT NULL,
  `field20` float DEFAULT NULL,
  `field21` varchar(45) DEFAULT NULL,
  `field22` varchar(45) DEFAULT NULL,
  `field23` varchar(45) DEFAULT NULL,
  `field24` varchar(45) DEFAULT NULL,
  `field25` varchar(45) DEFAULT NULL,
  `field26` datetime DEFAULT NULL,
  `field27` datetime DEFAULT NULL,
  `field28` datetime DEFAULT NULL,
  `field29` datetime DEFAULT NULL,
  `field30` datetime DEFAULT NULL,
  `field31` text,
  `field32` text,
  `isArc` char(1) DEFAULT 'N',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_form_main`
--

LOCK TABLES `core_form_main` WRITE;
/*!40000 ALTER TABLE `core_form_main` DISABLE KEYS */;
INSERT INTO `core_form_main` VALUES (10,1,'2012-10-21 00:00:00',8,'2013-08-26 15:31:38','845fdd86-3034-4dfc-8f96-53b2f2d367fe',12,'a4j log 演示1','Richfaces调试模式',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),(11,1,'2012-10-22 00:00:00',1,'2012-11-13 21:10:53','',11,'2012年年终总结大会',NULL,NULL,'刘德华',NULL,'2012年年终总结暨表彰大会',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2012-10-22 00:00:00','2012-10-25 00:00:00',NULL,NULL,NULL,NULL,NULL,'r'),(12,1,'2012-11-22 19:41:14',0,NULL,'9024f076-6e71-47d8-a28a-aabbb962bb85',11,'年终总结大会',NULL,NULL,'习主席',NULL,'年终表彰大会',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2012-11-22 00:00:00','2012-11-23 00:00:00',NULL,NULL,NULL,NULL,NULL,'n'),(13,1,'2013-05-20 00:00:00',1,'2013-05-30 20:06:19','9024f076-6e71-47d8-a28a-aabbb962bb85',11,'年终总结大会',NULL,NULL,'习主席',NULL,'年终表彰大会',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2012-11-22 00:00:00','2012-11-23 00:00:00',NULL,NULL,NULL,NULL,NULL,'n'),(15,1,'2013-05-30 20:06:27',0,NULL,'9024f076-6e71-47d8-a28a-aabbb962bb85',11,'年终总结大会',NULL,NULL,'习主席',NULL,'年终表彰大会',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2012-11-22 00:00:00','2012-11-23 00:00:00',NULL,NULL,NULL,NULL,NULL,'N'),(18,1,'2013-06-05 00:00:00',10,'2013-06-05 20:04:49','fccf5320-b203-4c6d-a59e-df3435d42b79',15,'沙发','采购部',NULL,NULL,NULL,'备注',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),(19,1,'2013-06-07 20:46:33',0,NULL,'18662357-1cc1-4b1d-a185-e0e66acdece8',15,'桌子','广泛广泛',NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),(20,1,'2013-06-07 20:46:45',0,NULL,'18662357-1cc1-4b1d-a185-e0e66acdece8',15,'椅子','广泛广泛hhhh',NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),(22,17,'2013-06-23 13:32:39',0,NULL,'61091b38-546e-4b44-a0c9-05d4e5235a4c',11,'茶花会',NULL,NULL,'jessy',NULL,'111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-06-23 00:00:00','2013-06-24 00:00:00',NULL,NULL,NULL,NULL,NULL,'n'),(31,1,'2013-07-21 00:00:00',1,'2013-07-24 17:23:08','c3fd7e12-64e2-4798-98f1-a72fa63799e4',11,'sdfas',NULL,NULL,'sdf',NULL,'dfsdfyhjhkj',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-07-21 00:00:00','2013-07-22 00:00:00',NULL,NULL,NULL,NULL,NULL,'n'),(32,1,'2013-07-29 08:43:10',0,NULL,'2941ab31-1917-41af-a8d1-697e7eae6a21',11,'今天开会',NULL,NULL,'杨阳',NULL,'啦啦啦',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-07-22 00:00:00','2013-07-28 00:00:00',NULL,NULL,NULL,NULL,NULL,'r'),(33,1,'2013-07-29 00:00:00',1,'2013-07-29 21:10:29','ec74bfe9-6786-43b9-afdd-654bf49ee482',11,'党会',NULL,NULL,'杨阳',NULL,'会议流程不错',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-07-09 00:00:00','2013-07-24 00:00:00',NULL,NULL,NULL,NULL,NULL,'r'),(35,1,'2013-08-28 10:40:28',0,NULL,'0f81f458-81bc-4fac-950a-315f9c1768d4',11,'test',NULL,NULL,'test',NULL,'test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-08-28 00:00:00','2013-08-28 00:00:00',NULL,NULL,NULL,NULL,NULL,'r'),(36,8,'2013-09-02 11:51:56',0,NULL,'ac6aacd6-772f-4122-a7a0-e01773e01f7a',11,'新生会议',NULL,NULL,'admin',NULL,'开会啦',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-09-02 00:00:00','2013-09-03 00:00:00',NULL,NULL,NULL,NULL,NULL,'r'),(37,1,'2013-09-02 20:18:05',0,NULL,'9d2b5589-cd75-4c49-ba76-464e15cc55e3',11,'2013会议',NULL,NULL,'咚咚',NULL,'咚咚咚 ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-09-02 00:00:00','2013-09-03 00:00:00',NULL,NULL,NULL,NULL,NULL,'r'),(38,1,'2013-09-02 21:00:48',0,NULL,'470957de-3788-4351-bda2-2f054951c25e',11,'1',NULL,NULL,'1',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2013-09-03 00:00:00','2013-09-02 00:00:00',NULL,NULL,NULL,NULL,NULL,'r');
/*!40000 ALTER TABLE `core_form_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_ballot`
--

DROP TABLE IF EXISTS `core_ballot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_ballot` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `status_` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_ballot`
--

LOCK TABLES `core_ballot` WRITE;
/*!40000 ALTER TABLE `core_ballot` DISABLE KEYS */;
INSERT INTO `core_ballot` VALUES (1,0,NULL,1,'2011-11-13 14:29:14',NULL,'羽毛球男单初赛',0),(2,0,NULL,1,'2011-12-19 20:52:11',NULL,'羽毛球男单决赛',1);
/*!40000 ALTER TABLE `core_ballot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofuser`
--

DROP TABLE IF EXISTS `ofuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofuser` (
  `username` varchar(64) NOT NULL,
  `plainPassword` varchar(32) DEFAULT NULL,
  `encryptedPassword` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `creationDate` char(15) NOT NULL,
  `modificationDate` char(15) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `ofUser_cDate_idx` (`creationDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofuser`
--

LOCK TABLES `ofuser` WRITE;
/*!40000 ALTER TABLE `ofuser` DISABLE KEYS */;
INSERT INTO `ofuser` VALUES ('163',NULL,'4524385447d618c44b1aa141fd10f6c4316a90f35a6d5f30','1631','163@gmail.com','001300691122503','001300691122503'),('admin',NULL,'86a2f4528292137c5946570f47f69186593cfd72a6228c2f','管理员','daiqianjie@163.com','001319113340375','0'),('Baidu',NULL,'3e3a30e32e4d50ae5995fe7dc02c7e1324bc4046b00b961a','Baidu','baidu@gmail.com','001300691122503','001300691122503'),('Ben',NULL,'65b887bbafdfe58f0956d4ff7e150ca28b8d1efa694f5c00','Ben','daiqianjie@163.com','001300691122503','001300691122503'),('jessy',NULL,'4b72cc36334a683ce2cb86483b0f988710eef7e999cab4e7','jessy','1234@qq.com','001300691122503','001300691122503'),('jessy1',NULL,'4b72cc36334a683ce2cb86483b0f988710eef7e999cab4e7','jessy','1234@qq.com','001300691122503','001300691122503'),('Kate',NULL,'6ef21c7a9340bb263b991cc27c579d0fc85e35012c4fe747','Kate','kate@gmail.com','001300691122503','001300691122503'),('Li',NULL,'5b669bf6e8da145d903a930173ed9abadd7ea6aca7795a69','Li','li@gmail.com','001300691122503','001300691122503'),('Lucy',NULL,'f4f48778781eecd87dfc13c037a38593411a983f92424553','Lucy','lucy@gmail.com','001300691122503','001300691122503'),('subadmin',NULL,'69e2ff840f0f025466258072fd46d1d9e53f5b0a77d7ac1e','二级管理员','914261631@qq.com','001300691122503','001300691122503'),('system',NULL,'c902c45ef72b9b99395a90e47b3786e2f1cfe600732a797b','system','system@minioa','001319289286250','001319289286250'),('test2',NULL,'701027d592fa9d82ff53e11c86cc75c03bad9bfcdb48bb23','test2','11@163.com','001300691122503','001300691122503'),('tom',NULL,'ccd8c5a978e8775763398bda64b82e9f283c2076e8d91913','Tom','914261631@qq.com','001319113414859','001319113414859'),('Yahoo',NULL,'771d3aa6ebdfe58beba491d340418b2221bb331a2cb216d5','Yahoo','yahoo@gmail.com','001300691122503','001300691122503');
/*!40000 ALTER TABLE `ofuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofoffline`
--

DROP TABLE IF EXISTS `ofoffline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofoffline` (
  `username` varchar(64) NOT NULL,
  `messageID` bigint(20) NOT NULL,
  `creationDate` char(15) NOT NULL,
  `messageSize` int(11) NOT NULL,
  `stanza` text NOT NULL,
  PRIMARY KEY (`username`,`messageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofoffline`
--

LOCK TABLES `ofoffline` WRITE;
/*!40000 ALTER TABLE `ofoffline` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofoffline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofpubsubaffiliation`
--

DROP TABLE IF EXISTS `ofpubsubaffiliation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofpubsubaffiliation` (
  `serviceID` varchar(100) NOT NULL,
  `nodeID` varchar(100) NOT NULL,
  `jid` varchar(255) NOT NULL,
  `affiliation` varchar(10) NOT NULL,
  PRIMARY KEY (`serviceID`,`nodeID`,`jid`(70))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofpubsubaffiliation`
--

LOCK TABLES `ofpubsubaffiliation` WRITE;
/*!40000 ALTER TABLE `ofpubsubaffiliation` DISABLE KEYS */;
INSERT INTO `ofpubsubaffiliation` VALUES ('pubsub','','minioa','owner');
/*!40000 ALTER TABLE `ofpubsubaffiliation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofprivate`
--

DROP TABLE IF EXISTS `ofprivate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofprivate` (
  `username` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `namespace` varchar(200) NOT NULL,
  `privateData` text NOT NULL,
  PRIMARY KEY (`username`,`name`,`namespace`(100))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofprivate`
--

LOCK TABLES `ofprivate` WRITE;
/*!40000 ALTER TABLE `ofprivate` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofprivate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_topmenu_role_relation`
--

DROP TABLE IF EXISTS `core_topmenu_role_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_topmenu_role_relation` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `menuId` int(10) unsigned DEFAULT NULL,
  `roleId` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_topmenu_role_relation`
--

LOCK TABLES `core_topmenu_role_relation` WRITE;
/*!40000 ALTER TABLE `core_topmenu_role_relation` DISABLE KEYS */;
INSERT INTO `core_topmenu_role_relation` VALUES (1,0,'2011-09-04 22:02:38',0,2),(46,0,'2011-09-04 22:08:49',2,3),(47,0,'2011-09-04 22:08:49',3,3),(48,0,'2011-09-04 22:08:49',4,3),(49,0,'2011-09-04 22:08:49',5,3),(50,0,'2011-09-04 22:08:49',6,3),(51,0,'2011-09-04 22:08:49',7,3),(52,0,'2011-09-04 22:08:49',8,3),(53,0,'2011-09-04 22:08:49',9,3),(54,0,'2011-09-04 22:08:49',10,3),(55,0,'2011-09-04 22:08:49',11,3),(56,0,'2011-09-04 22:08:49',12,3),(57,0,'2011-09-04 22:08:49',13,3),(58,0,'2011-09-04 22:08:49',14,3),(59,0,'2011-09-04 22:08:49',15,3),(60,0,'2011-09-04 22:08:49',17,3),(61,0,'2011-09-04 22:08:49',16,3),(62,0,'2011-09-04 22:08:49',19,3),(64,0,'2011-09-04 22:08:49',21,3),(65,0,'2011-09-04 22:08:49',20,3),(66,0,'2011-09-04 22:08:49',23,3),(67,0,'2011-09-04 22:08:49',22,3),(68,0,'2011-09-04 22:08:49',25,3),(69,0,'2011-09-04 22:08:49',24,3),(70,0,'2011-09-04 22:08:49',27,3),(71,0,'2011-09-04 22:08:49',26,3),(72,0,'2011-09-04 22:08:49',29,3),(73,0,'2011-09-04 22:08:49',28,3),(74,0,'2011-09-04 22:08:49',31,3),(75,0,'2011-09-04 22:08:49',30,3),(76,0,'2011-09-04 22:08:49',34,3),(77,0,'2011-09-04 22:08:49',35,3),(78,0,'2011-09-04 22:08:49',32,3),(79,0,'2011-09-04 22:08:49',33,3),(80,0,'2011-09-04 22:08:49',38,3),(81,0,'2011-09-04 22:08:49',39,3),(82,0,'2011-09-04 22:08:49',36,3),(83,0,'2011-09-04 22:08:49',37,3),(84,0,'2011-09-04 22:08:49',42,3),(85,0,'2011-09-04 22:08:49',40,3),(86,0,'2011-09-04 22:08:49',41,3),(88,0,'2011-09-05 19:40:37',2,1),(90,0,'2011-09-05 19:40:37',4,1),(91,0,'2011-09-05 19:40:37',5,1),(92,0,'2011-09-05 19:40:37',6,1),(93,0,'2011-09-05 19:40:37',7,1),(94,0,'2011-09-05 19:40:37',8,1),(95,0,'2011-09-05 19:40:37',9,1),(96,0,'2011-09-05 19:40:37',10,1),(97,0,'2011-09-05 19:40:37',11,1),(98,0,'2011-09-05 19:40:37',12,1),(99,0,'2011-09-05 19:40:37',13,1),(100,0,'2011-09-05 19:40:37',14,1),(101,0,'2011-09-05 19:40:37',15,1),(102,0,'2011-09-05 19:40:37',17,1),(103,0,'2011-09-05 19:40:37',16,1),(106,0,'2011-09-05 19:40:37',21,1),(107,0,'2011-09-05 19:40:37',20,1),(108,0,'2011-09-05 19:40:37',23,1),(109,0,'2011-09-05 19:40:37',22,1),(110,0,'2011-09-05 19:40:37',25,1),(111,0,'2011-09-05 19:40:37',24,1),(113,0,'2011-09-05 19:40:37',26,1),(114,0,'2011-09-05 19:40:37',29,1),(115,0,'2011-09-05 19:40:37',28,1),(116,0,'2011-09-05 19:40:37',31,1),(117,0,'2011-09-05 19:40:37',30,1),(118,0,'2011-09-05 19:40:37',34,1),(119,0,'2011-09-05 19:40:37',35,1),(120,0,'2011-09-05 19:40:37',32,1),(121,0,'2011-09-05 19:40:37',33,1),(122,0,'2011-09-05 19:40:37',38,1),(124,0,'2011-09-05 19:40:37',36,1),(125,0,'2011-09-05 19:40:37',37,1),(127,0,'2011-10-12 19:26:41',7,2),(128,0,'2011-10-12 19:26:41',29,2),(129,0,'2011-10-12 19:26:41',28,2),(130,0,'2011-10-12 19:26:41',31,2),(131,0,'2011-10-12 19:26:41',30,2),(132,0,'2011-10-12 19:26:41',32,2),(133,0,'2011-10-12 19:26:41',33,2),(134,0,'2011-10-12 19:26:41',38,2),(135,0,'2011-10-12 19:26:41',36,2),(136,0,'2011-11-04 19:12:01',43,1),(137,0,'2011-11-05 20:12:52',37,2),(138,0,'2011-11-29 19:01:29',44,1),(139,0,'2011-12-22 09:37:47',46,1),(140,0,'2011-12-22 09:37:47',45,1),(141,0,'2012-01-12 20:30:59',4,2),(142,0,'2012-01-12 20:30:59',17,2),(144,0,'2012-01-12 21:05:32',4,4),(145,0,'2012-01-12 21:05:32',17,4),(146,0,'2012-05-07 06:16:05',47,1),(147,0,'2012-05-07 06:16:05',51,1),(148,0,'2012-05-07 06:16:05',50,1),(149,0,'2012-05-07 06:16:05',48,1),(150,0,'2012-05-07 06:34:12',49,1),(151,0,'2012-05-07 06:35:17',47,2),(152,0,'2012-05-07 06:35:17',51,2),(153,0,'2012-05-07 06:35:17',50,2),(154,0,'2012-05-07 06:35:17',49,2),(155,0,'2012-05-07 06:35:17',48,2),(156,0,'2012-05-07 20:43:51',55,1),(157,0,'2012-05-07 20:43:51',54,1),(158,0,'2012-05-07 20:43:51',53,1),(159,0,'2012-05-07 20:43:51',52,1),(160,0,'2012-05-07 20:43:51',59,1),(161,0,'2012-05-07 20:43:51',58,1),(162,0,'2012-05-07 20:43:51',57,1),(163,0,'2012-05-07 20:43:51',56,1),(164,0,'2012-05-07 20:43:51',63,1),(165,0,'2012-05-07 20:43:51',62,1),(166,0,'2012-05-07 20:43:51',61,1),(167,0,'2012-05-07 20:43:51',60,1),(168,0,'2012-05-07 20:43:51',64,1),(169,0,'2012-05-07 20:43:51',65,1),(170,0,'2012-05-10 19:56:59',66,2),(171,0,'2012-05-10 19:57:36',66,1),(173,0,'2012-10-12 20:37:20',54,2),(174,0,'2012-10-12 20:37:20',53,2),(175,0,'2012-10-12 20:37:20',52,2),(176,0,'2012-10-20 10:41:56',68,2),(177,0,'2012-10-20 10:42:05',68,1),(178,0,'2012-11-20 19:43:45',69,1),(179,0,'2012-11-20 19:47:31',70,1),(183,0,'2013-04-02 19:08:51',72,1),(186,0,'2013-04-02 19:08:51',75,1),(187,0,'2013-04-02 19:10:45',78,1),(188,0,'2013-04-02 19:10:45',79,1),(189,0,'2013-04-09 21:24:22',81,1),(190,0,'2013-04-09 21:24:22',80,1),(191,0,'2013-04-09 21:24:22',82,1),(192,0,'2013-06-16 15:49:16',3,1),(193,0,'2013-06-16 15:49:16',71,1);
/*!40000 ALTER TABLE `core_topmenu_role_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_processdefinition_task`
--

DROP TABLE IF EXISTS `core_processdefinition_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_processdefinition_task` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `headerId` int(10) unsigned DEFAULT NULL,
  `taskCode` varchar(45) DEFAULT NULL,
  `taskName` varchar(45) DEFAULT NULL,
  `taskType` char(1) DEFAULT '0',
  `taskApproveType` char(2) DEFAULT '0',
  `taskApproverId` int(10) DEFAULT '0',
  `taskDuation` varchar(1) DEFAULT NULL,
  `taskNextStep` varchar(2000) DEFAULT NULL,
  `sqlWhenCompleted` varchar(2000) DEFAULT NULL,
  `emailNotice` char(1) DEFAULT 'Y',
  `formViewId` int(10) DEFAULT '0',
  `taskApproverRoleId` int(10) DEFAULT '0',
  `taskApproverJobId` int(10) DEFAULT '0',
  `smsNotice` char(1) DEFAULT 'Y',
  `imNotice` char(1) DEFAULT 'Y',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_processdefinition_task`
--

LOCK TABLES `core_processdefinition_task` WRITE;
/*!40000 ALTER TABLE `core_processdefinition_task` DISABLE KEYS */;
INSERT INTO `core_processdefinition_task` VALUES (1,1,'2011-12-22 00:00:00',10,'2013-08-14 21:25:00',NULL,1,'1','会议室管理员确认','1','4',1,'1','approved=agree:2','select 1 from dual','Y',3,4,0,'Y','Y'),(2,1,'2011-12-22 00:00:00',1,'2013-08-14 16:05:23',NULL,1,'2','申请人直接上级审批','1','9',1,'1','approved=agree:4','select 2 from dual','Y',2,1,10,'N','N'),(4,1,'2013-06-05 00:00:00',1,'2013-06-05 16:52:23',NULL,2,'1','条件判断','0',NULL,0,NULL,'sql(select count(*) from core_form_main where ID_=:instanceId and field=\'桌子\')=1:11,12,13','',NULL,9,0,0,NULL,NULL),(5,1,'2013-06-05 00:00:00',1,'2013-06-08 10:58:27',NULL,2,'11','11','1','0',10,NULL,'approved=agree:19;approved=reject:1000','','Y',9,0,0,NULL,NULL),(6,1,'2013-06-05 00:00:00',1,'2013-06-08 10:58:33',NULL,2,'12','12','1','0',10,NULL,'approved=agree:19;approved=reject:1000','','Y',9,0,0,NULL,NULL),(7,1,'2013-06-05 00:00:00',1,'2013-06-08 10:58:39',NULL,2,'13','13','1','0',10,NULL,'approved=agree:19;approved=reject:1000','','Y',9,0,0,NULL,NULL),(8,1,'2013-06-05 00:00:00',1,'2013-06-05 15:54:39',NULL,2,'19','19','0','0',10,NULL,'exp(11,12,13,3)=agree:1000','',NULL,9,0,0,NULL,NULL),(12,10,'2013-06-16 00:00:00',1,'2013-06-23 11:29:05',NULL,4,'1','1-管理员审批','0','0',1,'1','','','Y',0,0,0,NULL,'Y'),(13,17,'2013-06-19 00:00:00',1,'2013-06-23 16:48:37',NULL,3,'1','管理员审批','0','2',10,'1','','','Y',0,0,0,'Y','Y'),(14,1,'2013-07-26 00:00:00',10,'2013-08-14 21:11:10',NULL,1,'30','等待全部结束','0','9',1,'1','exp(alltaskcount(1))=agree:1000','select 3 from dual','Y',1,1,10,'N','N'),(15,1,'2013-07-27 00:00:00',1,'2013-08-14 16:06:03',NULL,1,'4','总经理审批','1','9',1,'1','approved=agree:5','','Y',1,1,10,'N','N'),(16,1,'2013-07-27 00:00:00',1,'2013-08-14 16:06:19',NULL,1,'5','总经理审批2','1','9',1,'1','approved=agree:6','select 5 from dual','Y',1,1,10,'N','N'),(17,1,'2013-07-27 00:00:00',1,'2013-08-14 16:06:36',NULL,1,'6','总经理审批3','1','9',1,'1','approved=agree:30','select 6 from dual','Y',1,1,10,'N','N');
/*!40000 ALTER TABLE `core_processdefinition_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_mail_attachment`
--

DROP TABLE IF EXISTS `crm_mail_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_mail_attachment` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `filename` varchar(200) DEFAULT NULL,
  `filetype` varchar(45) DEFAULT NULL,
  `filesize` int(10) unsigned DEFAULT '0',
  `oldname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_mail_attachment`
--

LOCK TABLES `crm_mail_attachment` WRITE;
/*!40000 ALTER TABLE `crm_mail_attachment` DISABLE KEYS */;
INSERT INTO `crm_mail_attachment` VALUES (45,1,'2012-05-21 21:02:57',NULL,NULL,'8cf81c5a-a1a8-4e2b-9cf6-4d2982c572ce','upload\\mail\\7632df0b-de07-41a9-a137-95aeab47efc3.jpg','.jpg',2129895,'未标题-wabco副本.jpg'),(46,1,'2012-05-21 21:23:39',NULL,NULL,'475fc03c-cc77-428c-8a26-4872b10f72d0','upload\\mail\\a3c16d5f-3f39-4585-aa69-0e094a8173f3.psd','.psd',9425254,'未标题-wabco.psd'),(47,1,'2012-05-21 21:30:11',NULL,NULL,'c862018c-26e0-4ff3-a81f-91dcef01a61b','upload\\mail\\a2d68140-8887-44bd-9bf6-f53ae8d5a18b.docx','.docx',373323,'MiniOA工作流.docx');
/*!40000 ALTER TABLE `crm_mail_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_leftmenu`
--

DROP TABLE IF EXISTS `core_leftmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_leftmenu` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `parentId` int(10) unsigned DEFAULT NULL,
  `menuName` varchar(100) DEFAULT NULL,
  `menuUrl` varchar(100) DEFAULT NULL,
  `menuTarget` varchar(100) DEFAULT NULL,
  `sequence` int(10) unsigned DEFAULT '0',
  `templates` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_leftmenu`
--

LOCK TABLES `core_leftmenu` WRITE;
/*!40000 ALTER TABLE `core_leftmenu` DISABLE KEYS */;
INSERT INTO `core_leftmenu` VALUES (1,0,'2011-09-04 15:00:18',0,NULL,NULL,0,'我的桌面','','_self',0,'default,web'),(2,0,'2011-09-04 15:00:32',0,NULL,NULL,0,'审批中心','','_self',1,'default,web'),(3,0,'2011-09-04 15:00:41',0,'2012-03-24 14:43:43',NULL,0,'客户关系管理','','_self',2,'default,web'),(4,0,'2011-09-04 15:00:51',0,NULL,NULL,0,'我的文档','','_self',3,'default,web'),(6,0,'2011-09-04 15:01:12',0,'2011-09-22 18:49:17',NULL,1,'修改资料','updateprofile.jsf','_self',0,'default,web'),(7,0,'2011-09-04 15:01:24',0,'2011-09-29 21:33:38',NULL,1,'修改密码','updatepassword.jsf','_self',1,'default,web'),(8,0,'2011-09-04 15:01:33',0,'2012-01-06 20:34:11',NULL,1,'我的任务','taskrunning.jsf','_self',2,'default,web'),(9,0,'2011-09-04 15:02:37',0,'2012-01-03 17:40:47',NULL,1,'审批设置','taskagent.jsf','_self',3,'default,web'),(10,0,'2011-09-04 15:03:31',0,'2012-01-17 20:20:56',NULL,2,'待审批','taskrunning.jsf','_self',0,'default,web'),(11,0,'2011-09-04 15:03:37',0,'2012-01-17 20:20:53',NULL,2,'已审批','taskcompleted.jsf','_self',1,'default,web'),(12,0,'2011-09-04 15:03:43',0,'2012-01-21 13:42:14',NULL,2,'待审批流程','process.jsf?status=running','_self',2,'default,web'),(13,0,'2011-09-04 15:03:55',0,'2012-01-21 13:42:21',NULL,2,'已审批流程','process.jsf?status=agree','_self',3,'default,web'),(14,0,'2011-09-04 15:04:03',0,'2012-01-18 09:27:55',NULL,2,'审批授权','taskagent.jsf','_self',4,'default,web'),(15,0,'2011-09-04 15:04:11',0,'2012-01-17 20:22:09',NULL,2,'流程统计','','_self',5,'default,web'),(16,0,'2011-09-04 15:04:32',0,'2012-03-24 14:44:10',NULL,3,'客户资料','crm/customer.jsf','_self',0,'default,web'),(17,0,'2011-09-04 15:05:09',0,'2012-03-25 08:18:55',NULL,3,'客户资料查询','crm/customerview.jsf','_self',1,'default,web'),(19,0,'2012-03-31 21:14:02',0,'2012-03-31 21:15:40',NULL,3,'A-重点客户','crm/customerview.jsf?type=A','_self',3,'default,web'),(20,0,'2012-03-31 21:14:21',0,'2012-03-31 21:15:46',NULL,3,'B-成交客户','crm/customerview.jsf?type=B','_self',4,'default,web'),(21,0,'2012-03-31 21:14:39',0,'2012-03-31 21:15:53',NULL,3,'C-有意向客户','crm/customerview.jsf?type=C','_self',5,'default,web'),(22,0,'2012-03-31 21:14:57',0,'2012-03-31 21:15:57',NULL,3,'D-商机客户','crm/customerview.jsf?type=D','_self',6,'default,web'),(23,0,'2012-03-31 21:15:15',0,'2012-03-31 21:16:14',NULL,3,'E-培养客户','crm/customerview.jsf?type=E','_self',7,'default,web'),(24,0,'2012-03-31 22:01:39',0,NULL,NULL,3,'联系人查询','crm/contactview_all.jsf','_self',10,'default,web'),(25,0,'2012-04-02 13:50:38',0,'2012-04-02 13:50:52',NULL,3,'联系人批量导入','crm/contactimport.jsf','_self',12,'default,web'),(27,0,'2012-04-02 19:47:44',0,NULL,NULL,3,'已发邮件','crm/mail.jsf','_self',100,'default,web'),(28,0,'2012-04-03 14:19:33',0,NULL,NULL,3,'群发邮件','crm/contactviewmail.jsf','_self',102,'default,web'),(29,0,'2012-04-22 09:58:26',0,NULL,NULL,3,'拜访记录查询','crm/visitview_all.jsf','_self',11,'default,web'),(30,0,'2012-04-22 10:24:17',0,NULL,NULL,3,'交易记录查询','crm/recordview_all.jsf','_self',11,'default,web');
/*!40000 ALTER TABLE `core_leftmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofvcard`
--

DROP TABLE IF EXISTS `ofvcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofvcard` (
  `username` varchar(64) NOT NULL,
  `vcard` mediumtext NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofvcard`
--

LOCK TABLES `ofvcard` WRITE;
/*!40000 ALTER TABLE `ofvcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofvcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_form_view`
--

DROP TABLE IF EXISTS `core_form_view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_form_view` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `formId` int(11) DEFAULT '0',
  `viewName` varchar(45) DEFAULT NULL,
  `displayProcessBtn` char(1) DEFAULT 'N',
  `displayNewBtn` char(1) DEFAULT 'N',
  `displayEditBtn` char(1) DEFAULT 'N',
  `displayDelBtn` char(1) DEFAULT 'N',
  `displayAttachment` char(1) DEFAULT 'N',
  `displayDownloadBtn` char(1) DEFAULT 'N',
  `displayCInfo` char(1) DEFAULT 'N',
  `displayMInfo` char(1) DEFAULT 'N',
  `viewTemplate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_form_view`
--

LOCK TABLES `core_form_view` WRITE;
/*!40000 ALTER TABLE `core_form_view` DISABLE KEYS */;
INSERT INTO `core_form_view` VALUES (1,1,'2011-12-06 00:00:00',1,'2012-03-24 07:17:53',NULL,11,'默认视图','Y','Y','Y','Y','Y','Y','N','Y',NULL),(2,1,'2011-12-06 00:00:00',1,'2012-01-02 19:53:01',NULL,11,'只读','N','N','N','N','N','N','N','N',NULL),(3,1,'2011-12-06 00:00:00',1,'2013-08-09 08:04:40',NULL,11,'经理审批','N','N','N','N','Y','Y','N','N','formtemplate.xhtml'),(4,1,'2011-12-06 00:00:00',1,'2012-01-02 20:15:28',NULL,11,'总经理审批','N','N','N','N','N','N','N','N',NULL),(5,1,'2012-05-10 00:00:00',1,'2012-10-21 21:34:46',NULL,12,'默认视图','N','Y','Y','Y','Y','N','N','N','formtemplate.xhtml'),(6,1,'2012-07-01 00:00:00',1,'2012-07-01 21:41:24',NULL,13,'默认视图','N','Y','Y','Y','N','N','N','N',NULL),(7,1,'2013-04-16 21:56:17',NULL,NULL,NULL,12,'默认视图','N','Y','Y','Y','Y','N','N','N','formtemplate.xhtml'),(8,1,'2013-05-30 00:00:00',1,'2013-05-30 12:53:49',NULL,14,'fffffff','Y','Y','Y','Y','Y','Y','N','N','formtemplate.xhtml'),(9,1,'2013-06-05 00:00:00',1,'2013-06-05 15:20:08',NULL,15,'默认视图','Y','Y','Y','Y','Y','Y','N','N','formtemplate.xhtml'),(10,1,'2013-06-08 00:00:00',10,'2013-06-08 14:45:52',NULL,15,'ooo','Y','N','N','N','Y','Y','N','N','formtemplateprocess.xhtml'),(11,1,'2013-09-02 08:56:37',NULL,NULL,'a0d4cdb1-a6ef-4cf5-a97e-e6ba5a16f649',17,'jjjjjjj','Y','Y','Y','Y','Y','Y','Y','N','formtemplateprocess.xhtml');
/*!40000 ALTER TABLE `core_form_view` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_log`
--

DROP TABLE IF EXISTS `core_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_log` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `tag` varchar(100) DEFAULT NULL,
  `refId` int(10) unsigned DEFAULT '0',
  `summary` varchar(4000) DEFAULT NULL,
  `details` varchar(4000) DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=2653 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_log`
--

LOCK TABLES `core_log` WRITE;
/*!40000 ALTER TABLE `core_log` DISABLE KEYS */;
INSERT INTO `core_log` VALUES (241,1,'2011-12-19 20:50:30','log',1,'管理员清空了日志','','127.0.0.1'),(243,1,'2011-12-19 20:51:21','log',17,'管理员删除除了一条日志记录','delete from core_log where ID_ = :id','127.0.0.1'),(244,1,'2011-12-19 20:51:27','log',242,'管理员删除除了一条日志记录','delete from core_log where ID_ = :id','127.0.0.1'),(245,1,'2011-12-19 20:51:39','log',1,'管理员清空了日志','','127.0.0.1'),(247,1,'2011-12-19 20:51:52','log',246,'管理员删除除了一条日志记录','delete from core_log where ID_ = :id','127.0.0.1'),(1396,1,'2012-05-09 20:58:40','log',1,'管理员清空了日志','','127.0.0.1'),(1397,1,'2012-05-09 20:58:44','log',1,'管理员清空了日志','','127.0.0.1'),(1398,1,'2012-05-09 20:58:49','log',1,'管理员清空了日志','','127.0.0.1'),(1399,1,'2012-05-10 19:53:24','login',0,'管理员自动登录到系统','','127.0.0.1'),(1400,1,'2012-05-10 19:57:02','logout',0,'管理员安全退出系统','','127.0.0.1'),(1401,1,'2012-05-10 19:57:06','login',0,'管理员登录到系统','','127.0.0.1'),(1402,1,'2012-05-10 19:57:40','logout',0,'管理员安全退出系统','','127.0.0.1'),(1403,1,'2012-05-10 19:57:43','login',0,'管理员登录到系统','','127.0.0.1'),(1404,1,'2012-05-10 20:19:44','logout',0,'管理员安全退出系统','','127.0.0.1'),(1405,1,'2012-05-10 20:19:49','login',0,'管理员登录到系统','','127.0.0.1'),(1406,1,'2012-05-10 20:24:28','login',0,'管理员登录到系统','','127.0.0.1'),(1407,1,'2012-05-10 20:26:37','logout',0,'管理员安全退出系统','','127.0.0.1'),(1408,1,'2012-05-10 20:26:41','login',0,'管理员登录到系统','','127.0.0.1'),(1409,1,'2012-05-10 20:32:13','login',0,'管理员登录到系统','','127.0.0.1'),(1410,1,'2012-05-10 20:38:02','login',0,'管理员登录到系统','','127.0.0.1'),(1411,1,'2012-05-10 20:41:56','login',0,'管理员登录到系统','','127.0.0.1'),(1412,1,'2012-05-10 20:51:30','login',0,'管理员登录到系统','','127.0.0.1'),(1413,1,'2012-05-10 20:55:34','login',0,'管理员登录到系统','','127.0.0.1'),(1414,1,'2012-05-10 21:01:05','login',0,'管理员登录到系统','','127.0.0.1'),(1415,1,'2012-05-10 21:12:59','login',0,'管理员登录到系统','','127.0.0.1'),(1416,1,'2012-05-10 21:20:43','login',0,'管理员自动登录到系统','','127.0.0.1'),(1417,1,'2012-05-11 19:28:55','login',0,'管理员自动登录到系统','','127.0.0.1'),(1418,1,'2012-05-11 19:29:09','logout',0,'管理员安全退出系统','','127.0.0.1'),(1419,1,'2012-05-11 19:29:13','login',0,'管理员登录到系统','','127.0.0.1'),(1420,1,'2012-05-11 19:30:05','login',0,'管理员登录到系统','','127.0.0.1'),(1421,1,'2012-05-11 19:33:42','login',0,'管理员登录到系统','','127.0.0.1'),(1422,1,'2012-05-11 21:47:19','login',0,'管理员自动登录到系统','','127.0.0.1'),(1423,1,'2012-05-11 21:49:57','login',0,'管理员自动登录到系统','','127.0.0.1'),(1424,1,'2012-05-12 09:17:52','login',0,'管理员自动登录到系统','','127.0.0.1'),(1425,1,'2012-05-12 09:20:45','login',0,'管理员自动登录到系统','','127.0.0.1'),(1426,1,'2012-05-12 09:22:29','login',0,'管理员自动登录到系统','','127.0.0.1'),(1427,1,'2012-05-12 09:24:42','login',0,'管理员自动登录到系统','','127.0.0.1'),(1428,1,'2012-05-12 09:25:09','logout',0,'管理员安全退出系统','','127.0.0.1'),(1429,1,'2012-05-12 09:25:13','login',0,'管理员登录到系统','','127.0.0.1'),(1430,1,'2012-05-13 20:53:28','login',0,'管理员自动登录到系统','','127.0.0.1'),(1431,1,'2012-05-20 19:59:44','login',0,'管理员自动登录到系统','','127.0.0.1'),(1432,1,'2012-05-20 20:30:02','login',0,'管理员自动登录到系统','','127.0.0.1'),(1433,1,'2012-05-20 20:32:57','login',0,'管理员自动登录到系统','','127.0.0.1'),(1434,1,'2012-05-20 20:34:47','login',0,'管理员自动登录到系统','','127.0.0.1'),(1435,1,'2012-05-20 20:40:58','login',0,'管理员自动登录到系统','','127.0.0.1'),(1436,1,'2012-05-20 20:47:24','login',0,'管理员自动登录到系统','','127.0.0.1'),(1437,1,'2012-05-20 20:51:09','login',0,'管理员登录到系统','','127.0.0.1'),(1438,1,'2012-05-20 20:53:59','login',0,'管理员自动登录到系统','','127.0.0.1'),(1439,1,'2012-05-20 20:59:33','login',0,'管理员自动登录到系统','','127.0.0.1'),(1440,1,'2012-05-20 21:01:31','login',0,'管理员自动登录到系统','','127.0.0.1'),(1441,1,'2012-05-20 21:03:25','login',0,'管理员自动登录到系统','','127.0.0.1'),(1442,1,'2012-05-20 21:04:47','login',0,'管理员自动登录到系统','','127.0.0.1'),(1443,1,'2012-05-20 21:23:26','login',0,'管理员自动登录到系统','','127.0.0.1'),(1444,1,'2012-05-20 21:30:15','login',0,'管理员自动登录到系统','','127.0.0.1'),(1445,1,'2012-05-20 21:33:33','login',0,'管理员自动登录到系统','','127.0.0.1'),(1446,1,'2012-05-20 21:36:40','login',0,'管理员自动登录到系统','','127.0.0.1'),(1447,1,'2012-05-20 21:44:25','login',0,'管理员自动登录到系统','','127.0.0.1'),(1448,1,'2012-05-21 21:02:18','login',0,'管理员自动登录到系统','','127.0.0.1'),(1449,1,'2012-05-21 21:06:23','login',0,'管理员自动登录到系统','','127.0.0.1'),(1450,1,'2012-05-21 21:08:19','login',0,'管理员自动登录到系统','','127.0.0.1'),(1451,1,'2012-05-21 21:12:22','login',0,'管理员自动登录到系统','','127.0.0.1'),(1452,1,'2012-05-21 21:14:46','login',0,'管理员自动登录到系统','','127.0.0.1'),(1453,1,'2012-05-21 21:19:08','login',0,'管理员自动登录到系统','','127.0.0.1'),(1454,1,'2012-05-21 21:21:59','login',0,'管理员自动登录到系统','','127.0.0.1'),(1455,1,'2012-05-21 21:23:05','login',0,'管理员自动登录到系统','','127.0.0.1'),(1456,1,'2012-05-21 21:29:01','login',0,'管理员自动登录到系统','','127.0.0.1'),(1457,1,'2012-05-22 20:23:24','login',0,'管理员自动登录到系统','','127.0.0.1'),(1458,1,'2012-05-22 20:25:45','login',0,'管理员自动登录到系统','','127.0.0.1'),(1459,1,'2012-06-02 15:48:15','login',0,'管理员自动登录到系统','','127.0.0.1'),(1460,1,'2012-06-02 15:59:47','logout',0,'管理员安全退出系统','','127.0.0.1'),(1461,1,'2012-06-02 16:02:01','login',0,'管理员登录到系统','','127.0.0.1'),(1462,1,'2012-06-02 17:11:48','login',0,'管理员自动登录到系统','','127.0.0.1'),(1463,1,'2012-06-08 08:28:12','login',0,'管理员自动登录到系统','','127.0.0.1'),(1464,1,'2012-06-08 08:28:46','logout',0,'管理员安全退出系统','','127.0.0.1'),(1465,7,'2012-06-08 08:28:54','login',0,'Baidu登录到系统','','127.0.0.1'),(1466,7,'2012-06-08 08:28:57','logout',0,'Baidu安全退出系统','','127.0.0.1'),(1467,8,'2012-06-08 08:29:03','login',0,'163登录到系统','','127.0.0.1'),(1468,8,'2012-06-08 08:29:05','logout',0,'163安全退出系统','','127.0.0.1'),(1469,1,'2012-06-08 08:29:08','login',0,'管理员登录到系统','','127.0.0.1'),(1470,1,'2012-06-08 08:31:46','logout',0,'管理员安全退出系统','','127.0.0.1'),(1471,12,'2012-06-08 08:31:52','login',0,'test登录到系统','','127.0.0.1'),(1472,12,'2012-06-08 08:31:56','logout',0,'test安全退出系统','','127.0.0.1'),(1473,1,'2012-06-08 08:32:00','login',0,'管理员登录到系统','','127.0.0.1'),(1474,1,'2012-06-08 08:33:38','login',0,'管理员自动登录到系统','','127.0.0.1'),(1475,1,'2012-06-08 08:37:53','login',0,'管理员自动登录到系统','','127.0.0.1'),(1476,1,'2012-06-08 08:39:05','logout',0,'管理员安全退出系统','','127.0.0.1'),(1477,14,'2012-06-08 08:39:11','login',0,'test2登录到系统','','127.0.0.1'),(1478,14,'2012-06-08 08:39:15','logout',0,'test2安全退出系统','','127.0.0.1'),(1479,1,'2012-06-08 08:39:18','login',0,'管理员登录到系统','','127.0.0.1'),(1480,1,'2012-06-08 08:39:32','logout',0,'管理员安全退出系统','','127.0.0.1'),(1481,14,'2012-06-08 08:39:38','login',0,'test2登录到系统','','127.0.0.1'),(1482,14,'2012-06-08 08:39:40','logout',0,'test2安全退出系统','','127.0.0.1'),(1483,1,'2012-06-16 20:48:34','login',0,'管理员自动登录到系统','','127.0.0.1'),(1484,1,'2012-06-16 21:27:07','logout',0,'管理员安全退出系统','','127.0.0.1'),(1485,3,'2012-06-16 21:27:13','login',0,'Kate登录到系统','','127.0.0.1'),(1486,3,'2012-06-16 21:27:23','logout',0,'Kate安全退出系统','','127.0.0.1'),(1487,1,'2012-06-16 21:27:27','login',0,'管理员登录到系统','','127.0.0.1'),(1488,1,'2012-06-16 21:33:56','logout',0,'管理员安全退出系统','','127.0.0.1'),(1489,3,'2012-06-16 21:34:04','login',0,'Kate登录到系统','','127.0.0.1'),(1490,1,'2012-06-16 21:37:08','login',0,'管理员自动登录到系统','','127.0.0.1'),(1491,1,'2012-06-16 21:37:22','logout',0,'管理员安全退出系统','','127.0.0.1'),(1492,3,'2012-06-16 21:37:31','login',0,'Kate登录到系统','','127.0.0.1'),(1493,1,'2012-06-16 21:38:59','login',0,'管理员自动登录到系统','','127.0.0.1'),(1494,1,'2012-06-16 21:39:15','logout',0,'管理员安全退出系统','','127.0.0.1'),(1495,3,'2012-06-16 21:39:21','login',0,'Kate登录到系统','','127.0.0.1'),(1496,3,'2012-06-16 21:40:35','logout',0,'Kate安全退出系统','','127.0.0.1'),(1497,1,'2012-06-16 21:40:38','login',0,'管理员登录到系统','','127.0.0.1'),(1498,1,'2012-06-16 21:41:18','logout',0,'管理员安全退出系统','','127.0.0.1'),(1499,3,'2012-06-16 21:41:24','login',0,'Kate登录到系统','','127.0.0.1'),(1500,0,'2012-06-16 21:43:40','logout',0,'null安全退出系统','',NULL),(1501,1,'2012-06-16 21:43:45','login',0,'管理员登录到系统','','127.0.0.1'),(1502,1,'2012-06-16 21:46:15','logout',0,'管理员安全退出系统','','127.0.0.1'),(1503,3,'2012-06-16 21:46:22','login',0,'Kate登录到系统','','127.0.0.1'),(1504,1,'2012-06-16 21:48:19','login',0,'管理员自动登录到系统','','127.0.0.1'),(1505,1,'2012-06-16 21:50:38','logout',0,'管理员安全退出系统','','127.0.0.1'),(1506,3,'2012-06-16 21:50:45','login',0,'Kate登录到系统','','127.0.0.1'),(1507,1,'2012-06-16 21:52:02','login',0,'管理员自动登录到系统','','127.0.0.1'),(1508,1,'2012-06-28 20:12:04','login',0,'管理员自动登录到系统','','127.0.0.1'),(1509,1,'2012-06-28 20:34:27','login',0,'管理员自动登录到系统','','127.0.0.1'),(1510,1,'2012-06-28 20:34:39','logout',0,'管理员安全退出系统','','127.0.0.1'),(1511,1,'2012-06-28 20:34:43','login',0,'管理员自动登录到系统','','127.0.0.1'),(1512,1,'2012-06-28 20:35:09','logout',0,'管理员安全退出系统','','127.0.0.1'),(1513,1,'2012-06-28 20:35:15','login',0,'管理员自动登录到系统','','127.0.0.1'),(1514,1,'2012-06-28 20:58:30','login',0,'管理员自动登录到系统','','127.0.0.1'),(1515,1,'2012-06-28 21:03:24','login',0,'管理员自动登录到系统','','127.0.0.1'),(1516,1,'2012-06-28 21:12:19','login',0,'管理员自动登录到系统','','127.0.0.1'),(1517,1,'2012-06-28 21:15:33','login',0,'管理员自动登录到系统','','127.0.0.1'),(1518,1,'2012-06-28 21:17:16','login',0,'管理员自动登录到系统','','127.0.0.1'),(1519,1,'2012-07-01 20:19:55','login',0,'管理员自动登录到系统','','127.0.0.1'),(1520,1,'2012-07-01 21:02:08','login',0,'管理员自动登录到系统','','127.0.0.1'),(1521,1,'2012-07-01 21:08:05','login',0,'管理员自动登录到系统','','127.0.0.1'),(1522,1,'2012-07-01 21:09:06','logout',0,'管理员安全退出系统','','127.0.0.1'),(1523,1,'2012-07-01 21:09:10','login',0,'管理员登录到系统','','127.0.0.1'),(1524,1,'2012-07-01 21:20:26','login',0,'管理员自动登录到系统','','127.0.0.1'),(1525,1,'2012-07-01 21:37:38','login',0,'管理员自动登录到系统','','127.0.0.1'),(1526,1,'2012-07-01 21:41:36','logout',0,'管理员安全退出系统','','127.0.0.1'),(1527,1,'2012-07-01 21:41:41','login',0,'管理员登录到系统','','127.0.0.1'),(1528,1,'2012-07-01 21:43:07','login',0,'管理员自动登录到系统','','127.0.0.1'),(1529,1,'2012-08-08 21:11:39','login',0,'管理员登录到系统','','127.0.0.1'),(1530,1,'2012-08-08 21:16:58','login',0,'管理员登录到系统','','127.0.0.1'),(1531,1,'2012-08-10 20:51:53','login',0,'管理员自动登录到系统','','127.0.0.1'),(1532,1,'2012-08-10 20:52:35','logout',0,'管理员安全退出系统','','127.0.0.1'),(1533,1,'2012-08-10 20:52:38','login',0,'管理员自动登录到系统','','127.0.0.1'),(1534,1,'2012-08-10 20:56:06','login',0,'管理员自动登录到系统','','127.0.0.1'),(1535,1,'2012-08-10 21:00:04','logout',0,'管理员安全退出系统','','127.0.0.1'),(1536,1,'2012-08-10 21:00:06','login',0,'管理员自动登录到系统','','127.0.0.1'),(1537,1,'2012-08-10 21:02:10','login',0,'管理员自动登录到系统','','127.0.0.1'),(1538,1,'2012-08-10 21:07:33','login',0,'管理员自动登录到系统','','127.0.0.1'),(1539,1,'2012-08-10 21:26:54','login',0,'管理员自动登录到系统','','127.0.0.1'),(1540,1,'2012-08-16 20:04:06','login',0,'管理员登录到系统','','127.0.0.1'),(1541,1,'2012-08-16 20:18:17','login',0,'管理员登录到系统','','127.0.0.1'),(1542,1,'2012-08-16 20:18:55','login',0,'管理员登录到系统','','127.0.0.1'),(1543,1,'2012-08-16 20:19:36','login',0,'管理员登录到系统','','127.0.0.1'),(1544,1,'2012-08-22 20:11:21','login',0,'管理员登录到系统','','127.0.0.1'),(1545,8,'2012-08-22 20:11:49','login',0,'163登录到系统','','127.0.0.1'),(1546,1,'2012-08-22 20:14:27','login',0,'管理员登录到系统','','127.0.0.1'),(1547,1,'2012-08-22 20:18:33','login',0,'管理员登录到系统','','127.0.0.1'),(1548,1,'2012-08-22 20:19:13','login',0,'管理员登录到系统','','127.0.0.1'),(1549,1,'2012-08-22 20:21:38','login',0,'管理员登录到系统','','127.0.0.1'),(1550,1,'2012-08-22 20:25:42','login',0,'管理员自动登录到系统','','127.0.0.1'),(1551,1,'2012-08-22 21:35:42','login',0,'管理员自动登录到系统','','127.0.0.1'),(1552,1,'2012-08-22 21:38:14','login',0,'管理员自动登录到系统','','127.0.0.1'),(1553,8,'2012-08-22 21:49:05','login',0,'163登录到系统','','127.0.0.1'),(1554,8,'2012-08-22 21:49:10','logout',0,'163安全退出系统','','127.0.0.1'),(1555,1,'2012-08-22 21:49:23','login',0,'管理员登录到系统','','127.0.0.1'),(1556,1,'2012-08-23 21:41:15','login',0,'管理员登录到系统','','127.0.0.1'),(1557,1,'2012-08-29 19:39:26','login',0,'管理员自动登录到系统','','127.0.0.1'),(1558,1,'2012-08-29 21:15:48','login',0,'管理员自动登录到系统','','127.0.0.1'),(1559,1,'2012-08-29 21:27:49','login',0,'管理员自动登录到系统','','127.0.0.1'),(1560,1,'2012-09-27 14:53:05','login',0,'管理员登录到系统','','127.0.0.1'),(1561,1,'2012-09-27 15:00:49','login',0,'管理员登录到系统','','127.0.0.1'),(1562,1,'2012-10-04 15:18:37','login',0,'管理员自动登录到系统','','127.0.0.1'),(1563,1,'2012-10-04 15:31:35','login',0,'管理员自动登录到系统','','127.0.0.1'),(1564,1,'2012-10-07 19:18:32','login',0,'管理员自动登录到系统','','127.0.0.1'),(1565,1,'2012-10-07 19:40:17','login',0,'管理员自动登录到系统','','127.0.0.1'),(1566,1,'2012-10-07 19:41:51','login',0,'管理员自动登录到系统','','127.0.0.1'),(1567,1,'2012-10-07 19:45:27','login',0,'管理员自动登录到系统','','127.0.0.1'),(1568,1,'2012-10-07 19:48:09','login',0,'管理员自动登录到系统','','127.0.0.1'),(1569,1,'2012-10-07 19:54:55','login',0,'管理员自动登录到系统','','127.0.0.1'),(1570,1,'2012-10-07 19:58:08','login',0,'管理员自动登录到系统','','127.0.0.1'),(1571,1,'2012-10-07 20:00:49','login',0,'管理员自动登录到系统','','127.0.0.1'),(1572,1,'2012-10-07 20:02:38','login',0,'管理员自动登录到系统','','127.0.0.1'),(1573,1,'2012-10-07 20:07:49','login',0,'管理员自动登录到系统','','127.0.0.1'),(1574,1,'2012-10-07 20:08:39','login',0,'管理员自动登录到系统','','127.0.0.1'),(1575,1,'2012-10-07 20:10:15','login',0,'管理员自动登录到系统','','127.0.0.1'),(1576,1,'2012-10-07 20:19:16','login',0,'管理员自动登录到系统','','127.0.0.1'),(1577,1,'2012-10-07 20:20:04','logout',0,'管理员安全退出系统','','127.0.0.1'),(1578,9,'2012-10-07 20:20:18','login',0,'Lucy登录到系统','','127.0.0.1'),(1579,9,'2012-10-07 20:20:22','logout',0,'Lucy安全退出系统','','127.0.0.1'),(1580,1,'2012-10-07 20:20:23','login',0,'管理员自动登录到系统','','127.0.0.1'),(1581,1,'2012-10-10 20:08:14','login',0,'管理员自动登录到系统','','127.0.0.1'),(1582,1,'2012-10-10 20:29:20','login',0,'管理员自动登录到系统','','127.0.0.1'),(1583,1,'2012-10-10 20:31:45','login',0,'管理员自动登录到系统','','127.0.0.1'),(1584,1,'2012-10-10 20:38:45','login',0,'管理员登录到系统','','127.0.0.1'),(1585,1,'2012-10-10 20:43:06','login',0,'管理员自动登录到系统','','127.0.0.1'),(1586,1,'2012-10-10 20:50:31','login',0,'管理员自动登录到系统','','127.0.0.1'),(1587,1,'2012-10-10 20:58:04','login',0,'管理员自动登录到系统','','127.0.0.1'),(1588,1,'2012-10-10 21:01:43','login',0,'管理员自动登录到系统','','127.0.0.1'),(1589,1,'2012-10-10 21:03:31','logout',0,'管理员安全退出系统','','127.0.0.1'),(1590,10,'2012-10-10 21:03:43','login',0,'Ben登录到系统','','127.0.0.1'),(1591,1,'2012-10-10 21:08:48','login',0,'管理员自动登录到系统','','127.0.0.1'),(1592,1,'2012-10-10 21:14:35','login',0,'管理员自动登录到系统','','127.0.0.1'),(1593,1,'2012-10-10 21:24:35','login',0,'管理员自动登录到系统','','127.0.0.1'),(1594,1,'2012-10-10 22:01:36','login',0,'管理员自动登录到系统','','127.0.0.1'),(1595,1,'2012-10-10 22:26:28','login',0,'管理员自动登录到系统','','127.0.0.1'),(1596,1,'2012-10-11 09:35:24','login',0,'管理员自动登录到系统','','127.0.0.1'),(1597,1,'2012-10-11 09:49:21','logout',0,'管理员安全退出系统','','127.0.0.1'),(1598,1,'2012-10-12 18:42:51','login',0,'管理员自动登录到系统','','127.0.0.1'),(1599,1,'2012-10-12 19:16:27','login',0,'管理员自动登录到系统','','127.0.0.1'),(1600,1,'2012-10-12 19:42:44','login',0,'管理员自动登录到系统','','127.0.0.1'),(1601,1,'2012-10-12 19:44:57','login',0,'管理员自动登录到系统','','127.0.0.1'),(1602,1,'2012-10-12 20:15:33','login',0,'管理员自动登录到系统','','127.0.0.1'),(1603,1,'2012-10-12 20:36:24','logout',0,'管理员安全退出系统','','127.0.0.1'),(1604,8,'2012-10-12 20:36:39','login',0,'163登录到系统','','127.0.0.1'),(1605,8,'2012-10-12 20:36:44','logout',0,'163安全退出系统','','127.0.0.1'),(1606,10,'2012-10-12 20:36:57','login',0,'Ben登录到系统','','127.0.0.1'),(1607,10,'2012-10-12 20:37:02','logout',0,'Ben安全退出系统','','127.0.0.1'),(1608,1,'2012-10-12 20:37:03','login',0,'管理员自动登录到系统','','127.0.0.1'),(1609,1,'2012-10-12 20:37:23','logout',0,'管理员安全退出系统','','127.0.0.1'),(1610,8,'2012-10-12 20:37:38','login',0,'163登录到系统','','127.0.0.1'),(1611,1,'2012-10-13 19:57:59','login',0,'管理员自动登录到系统','','127.0.0.1'),(1612,1,'2012-10-14 10:57:32','login',0,'管理员自动登录到系统','','127.0.0.1'),(1613,1,'2012-10-17 20:23:03','login',0,'管理员自动登录到系统','','127.0.0.1'),(1614,1,'2012-10-17 20:56:23','logout',0,'管理员安全退出系统','','127.0.0.1'),(1615,1,'2012-10-17 20:57:15','login',0,'管理员登录到系统','','127.0.0.1'),(1616,1,'2012-10-19 21:00:15','login',0,'管理员自动登录到系统','','127.0.0.1'),(1617,1,'2012-10-19 21:07:48','logout',0,'管理员安全退出系统','','127.0.0.1'),(1618,1,'2012-10-19 21:16:58','login',0,'管理员自动登录到系统','','127.0.0.1'),(1619,1,'2012-10-19 21:17:29','logout',0,'管理员安全退出系统','','127.0.0.1'),(1620,1,'2012-10-19 21:18:10','login',0,'管理员登录到系统','','127.0.0.1'),(1621,1,'2012-10-19 21:19:49','login',0,'管理员登录到系统','','127.0.0.1'),(1622,1,'2012-10-19 21:21:54','login',0,'管理员自动登录到系统','','127.0.0.1'),(1623,1,'2012-10-19 21:21:57','logout',0,'管理员安全退出系统','','127.0.0.1'),(1624,1,'2012-10-19 21:22:12','login',0,'管理员登录到系统','','127.0.0.1'),(1625,1,'2012-10-19 21:23:51','login',0,'管理员自动登录到系统','','127.0.0.1'),(1626,1,'2012-10-19 21:24:25','logout',0,'管理员安全退出系统','','127.0.0.1'),(1627,1,'2012-10-19 21:24:39','login',0,'管理员登录到系统','','127.0.0.1'),(1628,1,'2012-10-19 21:25:58','login',0,'管理员自动登录到系统','','127.0.0.1'),(1629,1,'2012-10-19 21:26:41','logout',0,'管理员安全退出系统','','127.0.0.1'),(1630,1,'2012-10-19 21:26:55','login',0,'管理员登录到系统','','127.0.0.1'),(1631,1,'2012-10-19 21:28:32','login',0,'管理员自动登录到系统','','127.0.0.1'),(1632,1,'2012-10-19 21:28:35','logout',0,'管理员安全退出系统','','127.0.0.1'),(1633,1,'2012-10-19 21:28:48','login',0,'管理员登录到系统','','127.0.0.1'),(1634,1,'2012-10-19 21:47:27','login',0,'管理员自动登录到系统','','127.0.0.1'),(1635,1,'2012-10-19 21:47:32','logout',0,'管理员安全退出系统','','127.0.0.1'),(1636,1,'2012-10-19 21:47:44','login',0,'管理员登录到系统','','127.0.0.1'),(1637,1,'2012-10-20 10:26:09','login',0,'管理员自动登录到系统','','127.0.0.1'),(1638,1,'2012-10-20 10:26:24','logout',0,'管理员安全退出系统','','127.0.0.1'),(1639,1,'2012-10-20 10:26:40','login',0,'管理员登录到系统','','127.0.0.1'),(1640,1,'2012-10-20 10:26:56','logout',0,'管理员安全退出系统','','127.0.0.1'),(1641,1,'2012-10-20 10:27:42','login',0,'管理员登录到系统','','127.0.0.1'),(1642,1,'2012-10-20 10:32:06','logout',0,'管理员安全退出系统','','127.0.0.1'),(1643,1,'2012-10-20 10:38:57','login',0,'管理员登录到系统','','127.0.0.1'),(1644,1,'2012-10-20 10:39:02','logout',0,'管理员安全退出系统','','127.0.0.1'),(1645,1,'2012-10-20 10:40:29','login',0,'管理员登录到系统','','127.0.0.1'),(1646,1,'2012-10-20 10:40:33','logout',0,'管理员安全退出系统','','127.0.0.1'),(1647,1,'2012-10-20 10:40:46','login',0,'管理员登录到系统','','127.0.0.1'),(1648,1,'2012-10-20 10:43:54','login',0,'管理员自动登录到系统','','127.0.0.1'),(1649,1,'2012-10-20 10:44:13','logout',0,'管理员安全退出系统','','127.0.0.1'),(1650,1,'2012-10-20 10:44:29','login',0,'管理员登录到系统','','127.0.0.1'),(1651,1,'2012-10-20 10:44:50','logout',0,'管理员安全退出系统','','127.0.0.1'),(1652,1,'2012-10-20 10:45:03','login',0,'管理员登录到系统','','127.0.0.1'),(1653,1,'2012-10-20 10:45:06','logout',0,'管理员安全退出系统','','127.0.0.1'),(1654,1,'2012-10-20 10:45:08','login',0,'管理员自动登录到系统','','127.0.0.1'),(1655,1,'2012-10-20 10:45:11','logout',0,'管理员安全退出系统','','127.0.0.1'),(1656,1,'2012-10-20 10:45:26','login',0,'管理员登录到系统','','127.0.0.1'),(1657,1,'2012-10-20 11:32:39','login',0,'管理员登录到系统','','127.0.0.1'),(1658,1,'2012-10-20 11:35:01','logout',0,'管理员安全退出系统','','127.0.0.1'),(1659,1,'2012-10-20 11:35:15','login',0,'管理员登录到系统','','127.0.0.1'),(1660,1,'2012-10-20 11:38:29','login',0,'管理员登录到系统','','127.0.0.1'),(1661,1,'2012-10-20 11:39:52','login',0,'管理员登录到系统','','127.0.0.1'),(1662,1,'2012-10-20 11:40:08','logout',0,'管理员安全退出系统','','127.0.0.1'),(1663,1,'2012-10-20 11:40:20','login',0,'管理员登录到系统','','127.0.0.1'),(1664,1,'2012-10-20 11:44:15','login',0,'管理员登录到系统','','127.0.0.1'),(1665,1,'2012-10-20 11:44:26','logout',0,'管理员安全退出系统','','127.0.0.1'),(1666,1,'2012-10-20 11:44:38','login',0,'管理员登录到系统','','127.0.0.1'),(1667,1,'2012-10-20 11:44:57','logout',0,'管理员安全退出系统','','127.0.0.1'),(1668,1,'2012-10-20 11:45:17','login',0,'管理员登录到系统','','127.0.0.1'),(1669,1,'2012-10-20 11:48:20','login',0,'管理员自动登录到系统','','127.0.0.1'),(1670,1,'2012-10-20 11:50:15','login',0,'管理员自动登录到系统','','127.0.0.1'),(1671,1,'2012-10-20 11:53:51','logout',0,'管理员安全退出系统','','127.0.0.1'),(1672,1,'2012-10-20 11:54:12','login',0,'管理员登录到系统','','127.0.0.1'),(1673,1,'2012-10-20 11:54:53','logout',0,'管理员安全退出系统','','127.0.0.1'),(1674,1,'2012-10-20 11:54:57','login',0,'管理员自动登录到系统','','127.0.0.1'),(1675,1,'2012-10-20 11:55:29','logout',0,'管理员安全退出系统','','127.0.0.1'),(1676,1,'2012-10-20 11:55:30','login',0,'管理员自动登录到系统','','127.0.0.1'),(1677,1,'2012-10-20 13:24:28','login',0,'管理员自动登录到系统','','127.0.0.1'),(1678,1,'2012-10-20 13:31:05','logout',0,'管理员安全退出系统','','127.0.0.1'),(1679,1,'2012-10-20 13:31:19','login',0,'管理员登录到系统','','127.0.0.1'),(1680,1,'2012-10-20 13:35:06','logout',0,'管理员安全退出系统','','127.0.0.1'),(1681,1,'2012-10-20 13:35:08','login',0,'管理员自动登录到系统','','127.0.0.1'),(1682,1,'2012-10-20 17:35:21','login',0,'管理员自动登录到系统','','127.0.0.1'),(1683,1,'2012-10-20 17:54:19','login',0,'管理员自动登录到系统','','127.0.0.1'),(1684,1,'2012-10-20 17:56:45','login',0,'管理员自动登录到系统','','127.0.0.1'),(1685,1,'2012-10-20 20:18:33','login',0,'管理员自动登录到系统','','127.0.0.1'),(1686,1,'2012-10-20 20:19:39','logout',0,'管理员安全退出系统','','127.0.0.1'),(1687,1,'2012-10-20 20:19:54','login',0,'管理员登录到系统','','127.0.0.1'),(1688,1,'2012-10-20 20:20:37','logout',0,'管理员安全退出系统','','127.0.0.1'),(1689,1,'2012-10-20 20:20:39','login',0,'管理员自动登录到系统','','127.0.0.1'),(1690,1,'2012-10-20 20:21:06','logout',0,'管理员安全退出系统','','127.0.0.1'),(1691,1,'2012-10-20 20:21:19','login',0,'管理员登录到系统','','127.0.0.1'),(1692,1,'2012-10-20 20:23:38','logout',0,'管理员安全退出系统','','127.0.0.1'),(1693,1,'2012-10-20 20:23:40','login',0,'管理员自动登录到系统','','127.0.0.1'),(1694,1,'2012-10-20 20:50:57','login',0,'管理员自动登录到系统','','127.0.0.1'),(1695,1,'2012-10-20 20:59:42','login',0,'管理员自动登录到系统','','127.0.0.1'),(1696,1,'2012-10-20 21:11:11','login',0,'管理员自动登录到系统','','127.0.0.1'),(1697,1,'2012-10-21 21:26:49','login',0,'管理员自动登录到系统','','127.0.0.1'),(1698,1,'2012-10-21 21:35:17','logout',0,'管理员安全退出系统','','127.0.0.1'),(1699,1,'2012-10-21 21:35:29','login',0,'管理员登录到系统','','127.0.0.1'),(1700,1,'2012-10-21 21:36:22','logout',0,'管理员安全退出系统','','127.0.0.1'),(1701,1,'2012-10-21 21:36:25','login',0,'管理员自动登录到系统','','127.0.0.1'),(1702,1,'2012-10-21 21:47:53','logout',0,'管理员安全退出系统','','127.0.0.1'),(1703,1,'2012-10-21 21:50:35','login',0,'管理员自动登录到系统','','127.0.0.1'),(1704,1,'2012-10-21 21:52:47','logout',0,'管理员安全退出系统','','127.0.0.1'),(1705,1,'2012-10-21 21:53:00','login',0,'管理员登录到系统','','127.0.0.1'),(1706,1,'2012-10-21 21:54:49','logout',0,'管理员安全退出系统','','127.0.0.1'),(1707,1,'2012-10-21 21:54:52','login',0,'管理员自动登录到系统','','127.0.0.1'),(1708,1,'2012-10-22 20:12:49','login',0,'管理员自动登录到系统','','127.0.0.1'),(1709,1,'2012-10-28 19:23:04','login',0,'管理员自动登录到系统','','127.0.0.1'),(1710,1,'2012-11-01 20:25:09','login',0,'管理员自动登录到系统','','127.0.0.1'),(1711,1,'2012-11-01 20:29:51','logout',0,'管理员安全退出系统','','127.0.0.1'),(1712,1,'2012-11-01 20:30:06','login',0,'管理员登录到系统','','127.0.0.1'),(1713,1,'2012-11-01 20:30:49','logout',0,'管理员安全退出系统','','127.0.0.1'),(1714,1,'2012-11-01 20:30:52','login',0,'管理员自动登录到系统','','127.0.0.1'),(1715,1,'2012-11-01 20:31:41','logout',0,'管理员安全退出系统','','127.0.0.1'),(1716,1,'2012-11-01 20:32:02','login',0,'管理员登录到系统','','127.0.0.1'),(1717,1,'2012-11-05 19:51:04','login',0,'管理员自动登录到系统','','127.0.0.1'),(1718,1,'2012-11-05 20:12:27','login',0,'管理员自动登录到系统','','127.0.0.1'),(1719,1,'2012-11-05 20:14:45','login',0,'管理员自动登录到系统','','127.0.0.1'),(1720,1,'2012-11-05 20:31:05','login',0,'管理员自动登录到系统','','127.0.0.1'),(1721,1,'2012-11-05 20:32:25','login',0,'管理员自动登录到系统','','127.0.0.1'),(1722,1,'2012-11-05 20:55:25','login',0,'管理员自动登录到系统','','127.0.0.1'),(1723,1,'2012-11-05 20:57:36','login',0,'管理员自动登录到系统','','127.0.0.1'),(1724,1,'2012-11-05 21:02:51','login',0,'管理员自动登录到系统','','127.0.0.1'),(1725,1,'2012-11-05 21:26:43','login',0,'管理员自动登录到系统','','127.0.0.1'),(1726,1,'2012-11-06 20:42:14','login',0,'管理员自动登录到系统','','127.0.0.1'),(1727,1,'2012-11-06 20:51:04','login',0,'管理员登录到系统','','127.0.0.1'),(1728,1,'2012-11-06 20:54:52','login',0,'管理员自动登录到系统','','127.0.0.1'),(1729,1,'2012-11-06 21:38:21','login',0,'管理员自动登录到系统','','127.0.0.1'),(1730,1,'2012-11-06 21:40:46','login',0,'管理员自动登录到系统','','127.0.0.1'),(1731,1,'2012-11-06 21:43:03','login',0,'管理员自动登录到系统','','127.0.0.1'),(1732,1,'2012-11-06 21:47:01','login',0,'管理员自动登录到系统','','127.0.0.1'),(1733,1,'2012-11-06 21:53:09','login',0,'管理员自动登录到系统','','127.0.0.1'),(1734,1,'2012-11-06 21:56:23','login',0,'管理员自动登录到系统','','127.0.0.1'),(1735,1,'2012-11-07 20:35:27','login',0,'管理员自动登录到系统','','127.0.0.1'),(1736,1,'2012-11-07 21:08:21','login',0,'管理员自动登录到系统','','127.0.0.1'),(1737,1,'2012-11-07 21:09:50','login',0,'管理员自动登录到系统','','127.0.0.1'),(1738,1,'2012-11-07 21:11:20','login',0,'管理员自动登录到系统','','127.0.0.1'),(1739,1,'2012-11-07 21:12:26','login',0,'管理员自动登录到系统','','127.0.0.1'),(1740,1,'2012-11-07 21:13:16','login',0,'管理员自动登录到系统','','127.0.0.1'),(1741,1,'2012-11-07 21:13:46','login',0,'管理员自动登录到系统','','127.0.0.1'),(1742,1,'2012-11-07 21:31:48','login',0,'管理员自动登录到系统','','127.0.0.1'),(1743,1,'2012-11-11 21:38:05','login',0,'管理员登录到系统','','127.0.0.1'),(1744,1,'2012-11-11 21:44:10','login',0,'管理员自动登录到系统','','127.0.0.1'),(1745,1,'2012-11-12 21:09:29','login',0,'管理员自动登录到系统','','127.0.0.1'),(1746,1,'2012-11-12 21:19:02','login',0,'管理员自动登录到系统','','127.0.0.1'),(1747,1,'2012-11-12 21:21:53','login',0,'管理员自动登录到系统','','127.0.0.1'),(1748,1,'2012-11-12 21:30:01','login',0,'管理员自动登录到系统','','127.0.0.1'),(1749,1,'2012-11-13 20:33:14','login',0,'管理员自动登录到系统','','127.0.0.1'),(1750,1,'2012-11-19 18:54:28','login',0,'管理员自动登录到系统','','127.0.0.1'),(1751,1,'2012-11-19 19:10:19','login',0,'管理员自动登录到系统','','127.0.0.1'),(1752,1,'2012-11-19 19:21:25','login',0,'管理员自动登录到系统','','127.0.0.1'),(1753,1,'2012-11-19 19:22:23','login',0,'管理员自动登录到系统','','127.0.0.1'),(1754,1,'2012-11-19 19:26:39','login',0,'管理员自动登录到系统','','127.0.0.1'),(1755,1,'2012-11-19 19:34:45','login',0,'管理员自动登录到系统','','127.0.0.1'),(1756,1,'2012-11-19 19:38:47','login',0,'管理员自动登录到系统','','127.0.0.1'),(1757,1,'2012-11-19 19:41:03','login',0,'管理员自动登录到系统','','127.0.0.1'),(1758,1,'2012-11-20 18:50:17','login',0,'管理员自动登录到系统','','127.0.0.1'),(1759,1,'2012-11-20 19:03:01','login',0,'管理员登录到系统','','127.0.0.1'),(1760,1,'2012-11-20 19:04:46','login',0,'管理员登录到系统','','127.0.0.1'),(1761,1,'2012-11-20 19:05:52','login',0,'管理员自动登录到系统','','127.0.0.1'),(1762,1,'2012-11-20 19:06:46','login',0,'管理员登录到系统','','127.0.0.1'),(1763,1,'2012-11-20 19:21:22','login',0,'管理员自动登录到系统','','127.0.0.1'),(1764,1,'2012-11-20 19:45:30','login',0,'管理员自动登录到系统','','127.0.0.1'),(1765,1,'2012-11-20 19:45:31','login',0,'管理员自动登录到系统','','127.0.0.1'),(1766,1,'2012-11-20 19:47:33','logout',0,'管理员安全退出系统','','127.0.0.1'),(1767,1,'2012-11-20 19:47:36','login',0,'管理员自动登录到系统','','127.0.0.1'),(1768,1,'2012-11-20 19:50:12','login',0,'管理员自动登录到系统','','127.0.0.1'),(1769,1,'2012-11-20 19:51:54','logout',0,'管理员安全退出系统','','127.0.0.1'),(1770,1,'2012-11-20 19:52:02','login',0,'管理员自动登录到系统','','127.0.0.1'),(1771,1,'2012-11-20 20:10:33','login',0,'管理员自动登录到系统','','127.0.0.1'),(1772,1,'2012-11-20 20:18:43','login',0,'管理员自动登录到系统','','127.0.0.1'),(1773,1,'2012-11-20 20:29:53','login',0,'管理员自动登录到系统','','127.0.0.1'),(1774,1,'2012-11-20 20:40:31','login',0,'管理员自动登录到系统','','127.0.0.1'),(1775,1,'2012-11-20 20:53:16','login',0,'管理员自动登录到系统','','127.0.0.1'),(1776,1,'2012-11-21 19:21:43','login',0,'管理员自动登录到系统','','127.0.0.1'),(1777,1,'2012-11-22 19:33:03','login',0,'管理员自动登录到系统','','127.0.0.1'),(1778,1,'2012-11-22 19:46:33','login',0,'管理员自动登录到系统','','127.0.0.1'),(1779,1,'2012-11-22 19:52:46','login',0,'管理员自动登录到系统','','127.0.0.1'),(1780,1,'2012-11-22 19:59:09','login',0,'管理员自动登录到系统','','127.0.0.1'),(1781,1,'2013-03-27 16:17:42','login',0,'管理员登录到系统','','123.234.34.234'),(1782,1,'2013-03-27 16:39:59','login',0,'管理员登录到系统','','123.234.34.234'),(1783,1,'2013-03-29 10:15:24','login',0,'管理员登录到系统','','123.234.34.234'),(1784,1,'2013-04-02 18:58:28','login',0,'管理员登录到系统','','124.129.66.129'),(1785,1,'2013-04-02 20:20:44','login',0,'管理员登录到系统','','124.129.66.129'),(1786,1,'2013-04-02 20:32:56','login',0,'管理员登录到系统','','124.129.66.129'),(1787,1,'2013-04-02 20:41:17','login',0,'管理员登录到系统','','124.129.66.129'),(1788,1,'2013-04-02 20:49:49','login',0,'管理员登录到系统','','124.129.66.129'),(1789,1,'2013-04-02 20:51:16','login',0,'管理员登录到系统','','124.129.66.129'),(1790,1,'2013-04-02 20:52:02','login',0,'管理员登录到系统','','124.129.66.129'),(1791,1,'2013-04-02 20:56:09','login',0,'管理员登录到系统','','124.129.66.129'),(1792,1,'2013-04-02 21:00:48','login',0,'管理员登录到系统','','124.129.66.129'),(1793,1,'2013-04-02 21:06:00','login',0,'管理员登录到系统','','124.129.66.129'),(1794,1,'2013-04-02 21:09:18','login',0,'管理员登录到系统','','124.129.66.129'),(1795,1,'2013-04-02 21:10:53','login',0,'管理员登录到系统','','124.129.66.129'),(1796,1,'2013-04-02 21:30:21','login',0,'管理员登录到系统','','124.129.66.129'),(1797,1,'2013-04-02 21:38:27','login',0,'管理员登录到系统','','124.129.66.129'),(1798,1,'2013-04-03 08:31:16','login',0,'管理员登录到系统','','123.234.34.234'),(1799,1,'2013-04-08 20:42:43','login',0,'管理员登录到系统','','123.234.34.234'),(1800,1,'2013-04-08 21:32:44','login',0,'管理员登录到系统','','123.234.34.234'),(1801,1,'2013-04-08 21:33:24','logout',0,'管理员安全退出系统','','123.234.34.234'),(1802,1,'2013-04-08 21:33:35','login',0,'管理员登录到系统','','123.234.34.234'),(1803,1,'2013-04-09 10:34:52','login',0,'管理员登录到系统','','123.234.34.234'),(1804,1,'2013-04-09 21:11:31','login',0,'管理员登录到系统','','27.193.85.226'),(1805,1,'2013-04-09 21:27:42','login',0,'管理员登录到系统','','27.193.85.226'),(1806,1,'2013-04-09 21:31:40','login',0,'管理员登录到系统','','27.193.85.226'),(1807,1,'2013-04-09 21:33:16','login',0,'管理员登录到系统','','27.193.85.226'),(1808,1,'2013-04-09 21:39:50','login',0,'管理员登录到系统','','27.193.85.226'),(1809,1,'2013-04-10 20:24:55','login',0,'管理员登录到系统','','27.193.85.226'),(1810,1,'2013-04-10 21:07:03','login',0,'管理员登录到系统','','27.193.85.226'),(1811,1,'2013-04-11 08:05:03','login',0,'管理员登录到系统','','123.234.34.234'),(1812,1,'2013-04-11 08:05:50','login',0,'管理员登录到系统','','123.234.34.234'),(1813,1,'2013-04-11 08:32:08','login',0,'管理员登录到系统','','123.234.34.234'),(1814,1,'2013-04-11 08:33:57','login',0,'管理员登录到系统','','123.234.34.234'),(1815,1,'2013-04-11 08:41:05','login',0,'管理员登录到系统','','123.234.34.234'),(1816,1,'2013-04-11 08:42:11','login',0,'管理员登录到系统','','123.234.34.234'),(1817,1,'2013-04-11 09:10:02','login',0,'管理员登录到系统','','123.234.34.234'),(1818,1,'2013-04-11 09:25:18','login',0,'管理员登录到系统','','123.234.34.234'),(1819,1,'2013-04-11 09:28:19','login',0,'管理员登录到系统','','123.234.34.234'),(1820,1,'2013-04-11 09:30:11','login',0,'管理员登录到系统','','123.234.34.234'),(1821,1,'2013-04-11 09:32:17','login',0,'管理员登录到系统','','123.234.34.234'),(1822,1,'2013-04-11 10:02:21','login',0,'管理员登录到系统','','123.234.34.234'),(1823,1,'2013-04-11 10:07:59','login',0,'管理员登录到系统','','123.234.34.234'),(1824,1,'2013-04-11 10:59:15','login',0,'管理员登录到系统','','123.234.34.234'),(1825,1,'2013-04-11 11:02:51','login',0,'管理员登录到系统','','123.234.34.234'),(1826,1,'2013-04-11 11:03:59','login',0,'管理员登录到系统','','123.234.34.234'),(1827,1,'2013-04-11 11:05:24','login',0,'管理员登录到系统','','123.234.34.234'),(1828,1,'2013-04-11 11:25:47','login',0,'管理员登录到系统','','123.234.34.234'),(1829,1,'2013-04-11 11:32:06','login',0,'管理员登录到系统','','123.234.34.234'),(1830,1,'2013-04-11 11:39:54','login',0,'管理员登录到系统','','123.234.34.234'),(1831,1,'2013-04-11 11:41:05','login',0,'管理员登录到系统','','123.234.34.234'),(1832,1,'2013-04-11 11:42:06','login',0,'管理员登录到系统','','123.234.34.234'),(1833,1,'2013-04-11 11:45:47','login',0,'管理员登录到系统','','123.234.34.234'),(1834,1,'2013-04-11 20:06:03','login',0,'管理员登录到系统','','27.193.134.227'),(1835,1,'2013-04-12 20:24:59','login',0,'管理员登录到系统','','27.193.134.227'),(1836,1,'2013-04-12 20:30:49','login',0,'管理员登录到系统','','27.193.134.227'),(1837,1,'2013-04-12 20:51:10','login',0,'管理员登录到系统','','27.193.134.227'),(1838,1,'2013-04-12 20:52:51','login',0,'管理员登录到系统','','27.193.134.227'),(1839,1,'2013-04-12 20:56:04','login',0,'管理员登录到系统','','27.193.134.227'),(1840,1,'2013-04-12 20:59:46','login',0,'管理员登录到系统','','27.193.134.227'),(1841,1,'2013-04-12 21:07:32','login',0,'管理员登录到系统','','27.193.134.227'),(1842,1,'2013-04-13 20:33:05','login',0,'管理员登录到系统','','27.193.134.227'),(1843,1,'2013-04-13 20:37:25','login',0,'管理员登录到系统','','27.193.134.227'),(1844,1,'2013-04-13 20:43:59','login',0,'管理员登录到系统','','27.193.134.227'),(1845,1,'2013-04-16 12:47:24','login',0,'管理员登录到系统','','123.234.34.234'),(1846,1,'2013-04-16 13:05:55','login',0,'管理员登录到系统','','123.234.34.234'),(1847,1,'2013-04-16 13:10:06','login',0,'管理员登录到系统','','123.234.34.234'),(1848,1,'2013-04-16 13:13:05','login',0,'管理员登录到系统','','123.234.34.234'),(1849,1,'2013-04-16 13:28:38','login',0,'管理员登录到系统','','123.234.34.234'),(1850,1,'2013-04-16 13:30:10','login',0,'管理员登录到系统','','123.234.34.234'),(1851,1,'2013-04-16 16:52:08','login',0,'管理员登录到系统','','123.234.34.234'),(1852,1,'2013-04-16 17:18:31','login',0,'管理员登录到系统','','123.234.34.234'),(1853,1,'2013-04-16 18:43:43','login',0,'管理员登录到系统','','27.193.132.126'),(1854,1,'2013-04-16 20:02:23','login',0,'管理员登录到系统','','123.234.34.234'),(1855,1,'2013-04-16 20:21:05','login',0,'管理员登录到系统','','27.193.132.126'),(1856,1,'2013-04-16 21:24:33','login',0,'管理员登录到系统','','27.193.132.126'),(1857,1,'2013-04-16 21:33:33','login',0,'管理员登录到系统','','27.193.132.126'),(1858,1,'2013-04-16 21:34:50','login',0,'管理员登录到系统','','218.29.60.105'),(1859,1,'2013-04-16 21:51:17','login',0,'管理员登录到系统','','125.40.178.40'),(1860,1,'2013-04-17 09:43:33','login',0,'管理员登录到系统','','123.234.34.234'),(1861,1,'2013-04-17 09:55:55','login',0,'管理员登录到系统','','123.234.34.234'),(1862,1,'2013-04-17 17:20:56','login',0,'管理员登录到系统','','123.234.34.234'),(1863,1,'2013-04-17 17:26:39','login',0,'管理员登录到系统','','123.234.34.234'),(1864,1,'2013-04-17 20:01:16','login',0,'管理员登录到系统','','27.193.132.126'),(1865,1,'2013-04-17 20:08:28','login',0,'管理员登录到系统','','27.193.132.126'),(1866,1,'2013-04-17 20:10:30','login',0,'管理员登录到系统','','27.193.132.126'),(1867,1,'2013-04-17 20:14:55','login',0,'管理员登录到系统','','27.193.132.126'),(1868,1,'2013-04-17 20:19:34','login',0,'管理员登录到系统','','27.193.132.126'),(1869,1,'2013-04-17 20:28:51','login',0,'管理员登录到系统','','27.193.132.126'),(1870,1,'2013-04-17 20:30:43','login',0,'管理员登录到系统','','27.193.132.126'),(1871,1,'2013-04-18 08:01:42','login',0,'管理员登录到系统','','123.234.34.234'),(1872,1,'2013-04-18 08:09:27','login',0,'管理员登录到系统','','123.234.34.234'),(1873,1,'2013-04-18 08:11:30','login',0,'管理员登录到系统','','123.234.34.234'),(1874,1,'2013-04-18 08:16:37','login',0,'管理员登录到系统','','123.234.34.234'),(1875,1,'2013-04-18 13:05:39','login',0,'管理员登录到系统','','123.234.34.234'),(1876,1,'2013-04-18 19:01:51','login',0,'管理员登录到系统','','112.226.124.128'),(1877,1,'2013-04-19 20:41:39','login',0,'管理员登录到系统','','112.226.124.128'),(1878,1,'2013-04-20 16:34:05','login',0,'管理员登录到系统','','123.234.34.234'),(1879,1,'2013-04-23 12:06:27','login',0,'管理员登录到系统','','123.234.34.234'),(1880,1,'2013-04-27 10:33:01','login',0,'管理员登录到系统','','123.234.34.234'),(1881,1,'2013-04-27 10:36:32','login',0,'管理员登录到系统','','113.103.128.236'),(1882,1,'2013-04-27 10:53:31','login',0,'管理员登录到系统','','222.88.24.253'),(1883,1,'2013-04-27 10:53:56','logout',0,'管理员安全退出系统','','222.88.24.253'),(1884,1,'2013-04-27 20:59:17','login',0,'管理员登录到系统','','110.212.123.122'),(1885,1,'2013-04-28 09:08:14','login',0,'管理员登录到系统','','218.249.118.238'),(1886,1,'2013-04-28 11:21:32','login',0,'管理员登录到系统','','218.80.213.49'),(1887,1,'2013-04-28 11:23:34','logout',0,'管理员安全退出系统','','218.80.213.49'),(1888,1,'2013-04-28 11:24:12','login',0,'管理员登录到系统','','218.80.213.49'),(1889,1,'2013-04-28 14:21:59','login',0,'管理员登录到系统','','123.234.34.234'),(1890,1,'2013-05-06 09:39:42','login',0,'管理员登录到系统','','218.249.118.238'),(1891,1,'2013-05-16 09:03:23','login',0,'管理员登录到系统','','222.26.20.107'),(1892,1,'2013-05-16 10:30:14','login',0,'管理员登录到系统','','111.127.36.172'),(1893,1,'2013-05-16 15:49:05','login',0,'管理员登录到系统','','125.41.131.189'),(1894,1,'2013-05-16 15:49:26','logout',0,'管理员安全退出系统','','125.41.131.189'),(1895,1,'2013-05-16 15:49:53','login',0,'管理员登录到系统','','125.41.131.189'),(1896,1,'2013-05-16 16:35:59','logout',0,'管理员安全退出系统','','125.41.131.189'),(1897,1,'2013-05-16 16:36:29','login',0,'管理员登录到系统','','202.108.100.231'),(1898,1,'2013-05-16 16:36:50','login',0,'管理员登录到系统','','202.108.100.231'),(1899,1,'2013-05-16 16:43:56','login',0,'管理员登录到系统','','125.69.150.90'),(1900,1,'2013-05-16 16:59:19','login',0,'管理员登录到系统','','220.168.116.131'),(1901,1,'2013-05-16 16:59:25','logout',0,'管理员安全退出系统','','220.168.116.131'),(1902,1,'2013-05-16 17:00:02','login',0,'管理员登录到系统','','220.168.116.131'),(1903,1,'2013-05-16 17:00:35','logout',0,'管理员安全退出系统','','220.168.116.131'),(1904,1,'2013-05-16 17:02:33','login',0,'管理员登录到系统','','202.108.100.231'),(1905,1,'2013-05-16 17:24:39','login',0,'管理员登录到系统','','218.205.154.74'),(1906,1,'2013-05-16 17:27:43','login',0,'管理员登录到系统','','119.57.163.34'),(1907,1,'2013-05-17 22:46:13','login',0,'管理员登录到系统','','218.29.60.105'),(1908,1,'2013-05-18 10:43:57','login',0,'管理员登录到系统','','220.200.56.156'),(1909,1,'2013-05-20 10:50:40','login',0,'管理员登录到系统','','219.147.61.11'),(1910,1,'2013-05-20 14:36:41','login',0,'管理员登录到系统','','119.191.55.180'),(1911,1,'2013-05-20 15:35:41','login',0,'管理员登录到系统','','119.97.217.106'),(1912,1,'2013-05-20 15:36:38','logout',0,'管理员安全退出系统','','119.97.217.106'),(1913,1,'2013-05-21 09:43:30','login',0,'管理员登录到系统','','219.147.61.11'),(1914,1,'2013-05-21 15:34:43','login',0,'管理员登录到系统','','218.28.92.21'),(1915,1,'2013-05-21 16:33:36','logout',0,'管理员安全退出系统','','218.28.92.21'),(1916,1,'2013-05-21 17:12:39','login',0,'管理员登录到系统','','218.80.213.49'),(1917,1,'2013-05-22 14:56:03','login',0,'管理员登录到系统','','123.116.99.20'),(1918,1,'2013-05-22 14:58:29','logout',0,'管理员安全退出系统','','123.116.99.20'),(1919,1,'2013-05-22 14:58:41','login',0,'管理员登录到系统','','123.116.99.20'),(1920,1,'2013-05-22 14:59:50','logout',0,'管理员安全退出系统','','123.116.99.20'),(1921,1,'2013-05-22 15:39:38','login',0,'管理员登录到系统','','60.10.64.58'),(1922,1,'2013-05-22 20:24:10','login',0,'管理员登录到系统','','60.10.64.58'),(1923,1,'2013-05-22 21:13:31','login',0,'管理员登录到系统','','202.112.90.187'),(1924,1,'2013-05-22 21:14:57','logout',0,'管理员安全退出系统','','202.112.90.187'),(1925,1,'2013-05-22 21:15:12','login',0,'管理员登录到系统','','202.112.90.187'),(1926,1,'2013-05-22 21:40:20','logout',0,'管理员安全退出系统','','202.112.90.187'),(1927,1,'2013-05-22 21:41:40','login',0,'管理员登录到系统','','112.64.223.84'),(1928,1,'2013-05-23 08:52:04','login',0,'管理员登录到系统','','222.222.23.108'),(1929,1,'2013-05-23 08:57:00','logout',0,'管理员安全退出系统','','222.222.23.108'),(1930,10,'2013-05-23 08:57:30','login',0,'Ben登录到系统','','222.222.23.108'),(1931,1,'2013-05-23 10:53:04','login',0,'管理员登录到系统','','106.120.73.191'),(1932,1,'2013-05-23 10:53:05','login',0,'管理员登录到系统','','124.205.51.194'),(1933,10,'2013-05-23 10:53:27','login',0,'Ben登录到系统','','124.205.51.194'),(1934,10,'2013-05-23 10:54:12','logout',0,'Ben安全退出系统','','124.205.51.194'),(1935,1,'2013-05-23 10:54:24','login',0,'管理员登录到系统','','124.205.51.194'),(1936,1,'2013-05-23 11:00:49','logout',0,'管理员安全退出系统','','124.205.51.194'),(1937,1,'2013-05-23 11:01:04','login',0,'管理员登录到系统','','124.205.51.194'),(1938,1,'2013-05-23 11:01:10','logout',0,'管理员安全退出系统','','124.205.51.194'),(1939,1,'2013-05-23 11:01:19','login',0,'管理员登录到系统','','124.205.51.194'),(1940,1,'2013-05-23 14:18:58','login',0,'管理员登录到系统','','124.205.51.194'),(1941,1,'2013-05-23 16:42:44','logout',0,'管理员安全退出系统','','124.205.51.194'),(1942,1,'2013-05-23 16:42:56','login',0,'管理员登录到系统','','124.205.51.194'),(1943,1,'2013-05-24 09:39:30','login',0,'管理员登录到系统','','124.205.51.194'),(1944,1,'2013-05-24 14:40:01','login',0,'管理员登录到系统','','218.26.31.114'),(1945,1,'2013-05-26 21:03:42','login',0,'管理员登录到系统','','120.194.22.72'),(1946,1,'2013-05-26 21:38:18','login',0,'管理员登录到系统','','116.205.14.101'),(1947,1,'2013-05-27 07:27:35','login',0,'管理员登录到系统','','120.194.22.72'),(1948,1,'2013-05-27 09:50:26','login',0,'管理员登录到系统','','183.129.218.226'),(1949,1,'2013-05-27 11:27:06','login',0,'管理员登录到系统','','111.73.201.146'),(1950,1,'2013-05-27 14:43:08','login',0,'管理员登录到系统','','175.18.189.126'),(1951,1,'2013-05-27 14:50:15','logout',0,'管理员安全退出系统','','175.18.189.126'),(1952,10,'2013-05-27 14:50:28','login',0,'Ben登录到系统','','175.18.189.126'),(1953,10,'2013-05-27 14:50:56','logout',0,'Ben安全退出系统','','175.18.189.126'),(1954,1,'2013-05-27 14:51:10','login',0,'管理员登录到系统','','175.18.189.126'),(1955,1,'2013-05-28 14:06:07','login',0,'管理员登录到系统','','223.198.9.192'),(1956,1,'2013-05-28 14:21:17','login',0,'管理员登录到系统','','110.184.166.4'),(1957,1,'2013-05-28 14:22:33','login',0,'管理员登录到系统','','113.79.141.104'),(1958,1,'2013-05-28 14:57:30','login',0,'管理员登录到系统','','110.184.166.4'),(1959,1,'2013-05-28 15:35:09','logout',0,'管理员安全退出系统','','110.184.166.4'),(1960,1,'2013-05-28 15:35:28','login',0,'管理员登录到系统','','110.184.166.4'),(1961,1,'2013-05-28 15:43:11','login',0,'管理员登录到系统','','58.215.28.226'),(1962,1,'2013-05-28 16:13:32','login',0,'管理员登录到系统','','110.103.143.36'),(1963,1,'2013-05-28 16:16:15','login',0,'管理员登录到系统','','110.184.166.4'),(1964,1,'2013-05-28 18:58:32','login',0,'管理员登录到系统','','124.117.239.164'),(1965,1,'2013-05-28 20:01:01','login',0,'管理员登录到系统','','110.184.166.4'),(1966,1,'2013-05-29 11:53:53','login',0,'管理员登录到系统','','118.116.60.250'),(1967,8,'2013-05-29 15:35:51','login',0,'163登录到系统','','118.116.60.250'),(1968,1,'2013-05-29 15:47:25','login',0,'管理员登录到系统','','118.116.60.250'),(1969,1,'2013-05-29 16:04:56','login',0,'管理员登录到系统','','58.247.6.101'),(1970,8,'2013-05-29 16:05:32','login',0,'163登录到系统','','118.116.60.250'),(1971,8,'2013-05-29 16:06:32','logout',0,'163安全退出系统','','118.116.60.250'),(1972,6,'2013-05-29 16:06:57','login',0,'Google登录到系统','','118.116.60.250'),(1973,6,'2013-05-29 16:07:08','logout',0,'Google安全退出系统','','118.116.60.250'),(1974,10,'2013-05-29 16:07:24','login',0,'Ben登录到系统','','118.116.60.250'),(1975,10,'2013-05-29 16:08:19','logout',0,'Ben安全退出系统','','118.116.60.250'),(1976,1,'2013-05-29 16:12:26','login',0,'管理员登录到系统','','118.116.60.250'),(1977,1,'2013-05-29 19:39:37','login',0,'管理员登录到系统','','118.116.60.250'),(1978,1,'2013-05-30 10:30:39','login',0,'管理员登录到系统','','118.116.59.97'),(1979,1,'2013-05-30 12:50:16','login',0,'管理员登录到系统','','123.234.34.234'),(1980,1,'2013-05-30 14:12:42','login',0,'管理员登录到系统','','118.116.59.97'),(1981,1,'2013-05-30 14:21:59','login',0,'管理员登录到系统','','118.116.59.97'),(1982,1,'2013-05-30 16:38:39','login',0,'管理员登录到系统','','120.194.22.72'),(1983,1,'2013-05-30 19:53:16','login',0,'管理员登录到系统','','27.210.108.76'),(1984,1,'2013-05-30 20:00:47','logout',0,'管理员安全退出系统','','27.210.108.76'),(1985,1,'2013-05-30 20:05:55','login',0,'管理员登录到系统','','27.210.108.76'),(1986,10,'2013-05-31 13:57:35','login',0,'Ben登录到系统','','113.64.201.191'),(1987,10,'2013-05-31 13:58:58','logout',0,'Ben安全退出系统','','113.64.201.191'),(1988,1,'2013-05-31 13:59:05','login',0,'管理员登录到系统','','113.64.201.191'),(1989,1,'2013-05-31 22:44:25','login',0,'管理员登录到系统','','61.140.33.47'),(1990,1,'2013-06-03 08:51:05','login',0,'管理员登录到系统','','220.166.95.59'),(1991,1,'2013-06-03 08:55:24','logout',0,'管理员安全退出系统','','220.166.95.59'),(1992,10,'2013-06-03 08:56:32','login',0,'Ben登录到系统','','220.166.95.59'),(1993,1,'2013-06-03 09:28:23','login',0,'管理员登录到系统','','218.249.118.238'),(1994,1,'2013-06-03 10:11:39','login',0,'管理员登录到系统','','182.138.160.169'),(1995,1,'2013-06-03 20:56:13','login',0,'管理员登录到系统','','114.86.222.111'),(1996,1,'2013-06-03 21:00:58','login',0,'管理员登录到系统','','112.226.125.172'),(1997,1,'2013-06-04 08:58:41','login',0,'管理员登录到系统','','180.127.175.128'),(1998,1,'2013-06-04 08:59:35','login',0,'管理员登录到系统','','125.70.177.33'),(1999,1,'2013-06-05 15:18:00','login',0,'管理员登录到系统','','123.234.34.234'),(2000,1,'2013-06-05 15:22:45','logout',0,'管理员安全退出系统','','123.234.34.234'),(2001,1,'2013-06-05 15:22:54','login',0,'管理员登录到系统','','123.234.34.234'),(2002,1,'2013-06-05 15:33:53','login',0,'管理员登录到系统','','123.234.34.234'),(2003,1,'2013-06-05 15:55:01','logout',0,'管理员安全退出系统','','123.234.34.234'),(2004,10,'2013-06-05 15:55:07','login',0,'Ben登录到系统','','123.234.34.234'),(2005,10,'2013-06-05 15:55:31','logout',0,'Ben安全退出系统','','123.234.34.234'),(2006,1,'2013-06-05 15:55:37','login',0,'管理员登录到系统','','123.234.34.234'),(2007,1,'2013-06-05 16:20:20','login',0,'管理员登录到系统','','123.234.34.234'),(2008,1,'2013-06-05 16:24:39','login',0,'管理员登录到系统','','123.234.34.234'),(2009,1,'2013-06-05 16:26:06','login',0,'管理员登录到系统','','123.234.34.234'),(2010,1,'2013-06-05 16:27:19','login',0,'管理员登录到系统','','123.234.34.234'),(2011,1,'2013-06-05 16:53:10','logout',0,'管理员安全退出系统','','123.234.34.234'),(2012,10,'2013-06-05 16:53:17','login',0,'Ben登录到系统','','123.234.34.234'),(2013,10,'2013-06-05 16:53:46','logout',0,'Ben安全退出系统','','123.234.34.234'),(2014,1,'2013-06-05 16:53:52','login',0,'管理员登录到系统','','123.234.34.234'),(2015,1,'2013-06-05 16:55:28','logout',0,'管理员安全退出系统','','123.234.34.234'),(2016,10,'2013-06-05 16:55:39','login',0,'Ben登录到系统','','123.234.34.234'),(2017,1,'2013-06-05 19:38:06','login',0,'管理员登录到系统','','112.226.113.206'),(2018,1,'2013-06-05 19:38:22','logout',0,'管理员安全退出系统','','112.226.113.206'),(2019,10,'2013-06-05 19:38:29','login',0,'Ben登录到系统','','112.226.113.206'),(2020,1,'2013-06-06 09:03:09','login',0,'管理员登录到系统','','120.194.22.72'),(2021,8,'2013-06-06 21:38:29','login',0,'163登录到系统','','118.186.207.164'),(2022,1,'2013-06-06 22:18:06','login',0,'管理员登录到系统','','111.192.16.121'),(2023,1,'2013-06-07 11:49:36','login',0,'管理员登录到系统','','1.180.11.104'),(2024,10,'2013-06-07 14:44:41','login',0,'Ben登录到系统','','58.246.0.158'),(2025,1,'2013-06-07 14:50:47','login',0,'管理员登录到系统','','221.207.229.9'),(2026,1,'2013-06-07 14:51:51','logout',0,'管理员安全退出系统','','221.207.229.9'),(2027,1,'2013-06-07 16:10:28','login',0,'管理员登录到系统','','222.180.4.22'),(2028,10,'2013-06-07 16:45:26','login',0,'Ben登录到系统','','221.181.34.212'),(2029,1,'2013-06-07 20:16:26','login',0,'管理员登录到系统','','27.193.135.25'),(2030,1,'2013-06-07 20:47:11','logout',0,'管理员安全退出系统','','27.193.135.25'),(2031,10,'2013-06-07 20:47:19','login',0,'Ben登录到系统','','27.193.135.25'),(2032,1,'2013-06-08 10:38:09','login',0,'管理员登录到系统','','123.234.34.234'),(2033,1,'2013-06-08 10:41:21','logout',0,'管理员安全退出系统','','123.234.34.234'),(2034,1,'2013-06-08 10:44:22','login',0,'管理员登录到系统','','123.234.34.234'),(2035,1,'2013-06-08 11:06:31','login',0,'管理员登录到系统','','123.234.34.234'),(2036,1,'2013-06-08 12:41:09','login',0,'管理员登录到系统','','123.234.34.234'),(2037,1,'2013-06-08 12:45:01','login',0,'管理员登录到系统','','123.234.34.234'),(2038,1,'2013-06-08 12:59:57','login',0,'管理员登录到系统','','123.234.34.234'),(2039,1,'2013-06-08 13:03:07','logout',0,'管理员安全退出系统','','123.234.34.234'),(2040,10,'2013-06-08 13:03:20','login',0,'Ben登录到系统','','123.234.34.234'),(2041,1,'2013-06-08 13:14:38','login',0,'管理员登录到系统','','123.234.34.234'),(2042,1,'2013-06-08 13:20:39','logout',0,'管理员安全退出系统','','123.234.34.234'),(2043,10,'2013-06-08 13:20:51','login',0,'Ben登录到系统','','123.234.34.234'),(2044,1,'2013-06-08 13:27:08','login',0,'管理员登录到系统','','123.234.34.234'),(2045,1,'2013-06-08 13:27:17','logout',0,'管理员安全退出系统','','123.234.34.234'),(2046,10,'2013-06-08 13:27:24','login',0,'Ben登录到系统','','123.234.34.234'),(2047,10,'2013-06-08 13:29:41','login',0,'Ben登录到系统','','123.234.34.234'),(2048,10,'2013-06-08 13:37:17','login',0,'Ben登录到系统','','123.234.34.234'),(2049,10,'2013-06-08 13:38:43','login',0,'Ben登录到系统','','123.234.34.234'),(2050,10,'2013-06-08 13:41:10','login',0,'Ben登录到系统','','123.234.34.234'),(2051,1,'2013-06-08 13:45:42','login',0,'管理员登录到系统','','123.234.34.234'),(2052,1,'2013-06-08 13:45:48','logout',0,'管理员安全退出系统','','123.234.34.234'),(2053,10,'2013-06-08 13:45:53','login',0,'Ben登录到系统','','123.234.34.234'),(2054,1,'2013-06-08 14:39:01','login',0,'管理员登录到系统','','58.62.125.66'),(2055,1,'2013-06-08 17:40:41','login',0,'管理员登录到系统','','123.234.34.234'),(2056,1,'2013-06-09 11:06:56','login',0,'管理员登录到系统','','120.37.91.109'),(2057,1,'2013-06-13 12:30:48','login',0,'管理员登录到系统','','58.248.169.116'),(2058,1,'2013-06-13 13:23:42','login',0,'管理员登录到系统','','116.204.64.165'),(2059,1,'2013-06-13 13:38:01','login',0,'管理员登录到系统','','222.91.81.32'),(2060,1,'2013-06-13 14:39:27','login',0,'管理员登录到系统','','58.248.169.116'),(2061,6,'2013-06-13 21:35:47','login',0,'Google登录到系统','','111.17.194.57'),(2062,1,'2013-06-14 15:13:13','login',0,'管理员登录到系统','','115.195.181.114'),(2063,1,'2013-06-14 15:55:17','login',0,'管理员登录到系统','','182.141.167.27'),(2064,6,'2013-06-15 17:57:06','login',0,'Google登录到系统','','119.4.42.152'),(2065,6,'2013-06-16 00:51:14','login',0,'Google登录到系统','','111.17.194.105'),(2066,1,'2013-06-16 10:01:02','login',0,'管理员登录到系统','','183.128.153.93'),(2067,1,'2013-06-16 10:18:06','login',0,'管理员登录到系统','','125.85.111.105'),(2068,10,'2013-06-16 10:25:08','login',0,'Ben登录到系统','','183.128.153.93'),(2069,10,'2013-06-16 11:20:39','logout',0,'Ben安全退出系统','','183.128.153.93'),(2070,6,'2013-06-16 11:20:54','login',0,'Google登录到系统','','183.128.153.93'),(2071,6,'2013-06-16 11:21:39','logout',0,'Google安全退出系统','','183.128.153.93'),(2072,6,'2013-06-16 11:21:58','login',0,'Google登录到系统','','183.128.153.93'),(2073,6,'2013-06-16 11:22:52','logout',0,'Google安全退出系统','','183.128.153.93'),(2074,1,'2013-06-16 11:23:09','login',0,'管理员登录到系统','','183.128.153.93'),(2075,1,'2013-06-16 11:27:05','logout',0,'管理员安全退出系统','','183.128.153.93'),(2076,1,'2013-06-16 11:37:34','login',0,'管理员登录到系统','','183.128.153.93'),(2077,1,'2013-06-16 13:15:21','login',0,'管理员登录到系统','','183.128.153.93'),(2078,1,'2013-06-16 13:54:36','logout',0,'管理员安全退出系统','','183.128.153.93'),(2079,10,'2013-06-16 13:54:47','login',0,'Ben登录到系统','','183.128.153.93'),(2080,10,'2013-06-16 13:56:11','logout',0,'Ben安全退出系统','','183.128.153.93'),(2081,1,'2013-06-16 13:56:19','login',0,'管理员登录到系统','','183.128.153.93'),(2082,1,'2013-06-16 13:58:24','logout',0,'管理员安全退出系统','','183.128.153.93'),(2083,15,'2013-06-16 13:58:33','login',0,'财务部登录到系统','','183.128.153.93'),(2084,15,'2013-06-16 13:58:43','logout',0,'财务部安全退出系统','','183.128.153.93'),(2085,1,'2013-06-16 13:58:53','login',0,'管理员登录到系统','','183.128.153.93'),(2086,1,'2013-06-16 14:01:38','logout',0,'管理员安全退出系统','','183.128.153.93'),(2087,15,'2013-06-16 14:01:46','login',0,'财务部登录到系统','','183.128.153.93'),(2088,15,'2013-06-16 14:03:27','logout',0,'财务部安全退出系统','','183.128.153.93'),(2089,1,'2013-06-16 14:03:36','login',0,'管理员登录到系统','','183.128.153.93'),(2090,1,'2013-06-16 14:09:45','logout',0,'管理员安全退出系统','','183.128.153.93'),(2091,15,'2013-06-16 14:10:29','login',0,'财务部登录到系统','','183.128.153.93'),(2092,15,'2013-06-16 14:13:53','logout',0,'财务部安全退出系统','','183.128.153.93'),(2093,1,'2013-06-16 14:14:02','login',0,'管理员登录到系统','','183.128.153.93'),(2094,1,'2013-06-16 14:18:00','logout',0,'管理员安全退出系统','','183.128.153.93'),(2095,1,'2013-06-16 14:18:10','login',0,'管理员登录到系统','','183.128.153.93'),(2096,1,'2013-06-16 14:28:51','logout',0,'管理员安全退出系统','','183.128.153.93'),(2097,1,'2013-06-16 14:29:00','login',0,'管理员登录到系统','','183.128.153.93'),(2098,1,'2013-06-16 14:44:23','logout',0,'管理员安全退出系统','','183.128.153.93'),(2099,1,'2013-06-16 14:44:52','login',0,'管理员登录到系统','','183.128.153.93'),(2100,1,'2013-06-16 14:44:55','logout',0,'管理员安全退出系统','','183.128.153.93'),(2101,10,'2013-06-16 14:45:04','login',0,'Ben登录到系统','','183.128.153.93'),(2102,10,'2013-06-16 14:45:08','logout',0,'Ben安全退出系统','','183.128.153.93'),(2103,8,'2013-06-16 14:45:17','login',0,'163登录到系统','','183.128.153.93'),(2104,8,'2013-06-16 14:45:45','logout',0,'163安全退出系统','','183.128.153.93'),(2105,10,'2013-06-16 14:45:54','login',0,'Ben登录到系统','','183.128.153.93'),(2106,10,'2013-06-16 14:46:57','logout',0,'Ben安全退出系统','','183.128.153.93'),(2107,1,'2013-06-16 14:47:07','login',0,'管理员登录到系统','','183.128.153.93'),(2108,1,'2013-06-16 14:51:24','logout',0,'管理员安全退出系统','','183.128.153.93'),(2109,1,'2013-06-16 14:51:32','login',0,'管理员登录到系统','','183.128.153.93'),(2110,1,'2013-06-16 15:08:44','logout',0,'管理员安全退出系统','','183.128.153.93'),(2111,10,'2013-06-16 15:08:53','login',0,'Ben登录到系统','','183.128.153.93'),(2112,10,'2013-06-16 15:29:35','logout',0,'Ben安全退出系统','','183.128.153.93'),(2113,1,'2013-06-16 15:29:44','login',0,'管理员登录到系统','','183.128.153.93'),(2114,1,'2013-06-16 15:35:56','logout',0,'管理员安全退出系统','','183.128.153.93'),(2115,1,'2013-06-16 15:36:07','login',0,'管理员登录到系统','','183.128.153.93'),(2116,1,'2013-06-16 15:40:03','logout',0,'管理员安全退出系统','','183.128.153.93'),(2117,10,'2013-06-16 15:40:12','login',0,'Ben登录到系统','','183.128.153.93'),(2118,10,'2013-06-16 15:40:50','logout',0,'Ben安全退出系统','','183.128.153.93'),(2119,1,'2013-06-16 15:40:59','login',0,'管理员登录到系统','','183.128.153.93'),(2120,1,'2013-06-16 15:41:21','logout',0,'管理员安全退出系统','','183.128.153.93'),(2121,10,'2013-06-16 15:41:29','login',0,'Ben登录到系统','','183.128.153.93'),(2122,10,'2013-06-16 15:42:01','logout',0,'Ben安全退出系统','','183.128.153.93'),(2123,1,'2013-06-16 15:42:09','login',0,'管理员登录到系统','','183.128.153.93'),(2124,1,'2013-06-16 15:58:03','logout',0,'管理员安全退出系统','','183.128.153.93'),(2125,1,'2013-06-16 15:58:12','login',0,'管理员登录到系统','','183.128.153.93'),(2126,1,'2013-06-16 16:00:08','logout',0,'管理员安全退出系统','','183.128.153.93'),(2127,15,'2013-06-16 16:00:17','login',0,'财务部登录到系统','','183.128.153.93'),(2128,1,'2013-06-16 16:00:53','login',0,'管理员登录到系统','','123.123.242.86'),(2129,15,'2013-06-16 16:00:54','logout',0,'财务部安全退出系统','','183.128.153.93'),(2130,1,'2013-06-16 16:01:02','login',0,'管理员登录到系统','','183.128.153.93'),(2131,1,'2013-06-16 16:02:04','login',0,'管理员登录到系统','','123.123.242.86'),(2132,1,'2013-06-16 16:03:22','login',0,'管理员登录到系统','','183.128.153.93'),(2133,1,'2013-06-16 16:08:00','logout',0,'管理员安全退出系统','','183.128.153.93'),(2134,10,'2013-06-16 16:08:25','login',0,'Ben登录到系统','','183.128.153.93'),(2135,10,'2013-06-16 16:12:05','logout',0,'Ben安全退出系统','','183.128.153.93'),(2136,17,'2013-06-16 16:12:13','login',0,'jessy登录到系统','','183.128.153.93'),(2137,17,'2013-06-16 19:42:04','login',0,'jessy登录到系统','','183.128.153.93'),(2138,1,'2013-06-16 20:35:03','login',0,'管理员登录到系统','','112.226.112.220'),(2139,1,'2013-06-16 20:41:54','logout',0,'管理员安全退出系统','','112.226.112.220'),(2140,1,'2013-06-16 20:42:18','login',0,'管理员登录到系统','','112.226.112.220'),(2141,1,'2013-06-16 20:43:10','logout',0,'管理员安全退出系统','','112.226.112.220'),(2142,1,'2013-06-16 20:44:44','login',0,'管理员登录到系统','','112.226.112.220'),(2143,1,'2013-06-17 15:50:42','login',0,'管理员登录到系统','','123.234.34.234'),(2144,1,'2013-06-18 08:49:06','login',0,'管理员登录到系统','','222.222.23.108'),(2145,1,'2013-06-18 08:52:29','login',0,'管理员登录到系统','','222.222.23.110'),(2146,6,'2013-06-18 08:56:22','login',0,'Google登录到系统','','222.222.23.110'),(2147,1,'2013-06-18 11:00:47','login',0,'管理员登录到系统','','123.234.34.234'),(2148,1,'2013-06-18 11:14:07','login',0,'管理员登录到系统','','123.234.34.234'),(2149,1,'2013-06-18 11:14:54','logout',0,'管理员安全退出系统','','123.234.34.234'),(2150,10,'2013-06-18 11:15:02','login',0,'Ben登录到系统','','123.234.34.234'),(2151,1,'2013-06-18 11:19:33','login',0,'管理员登录到系统','','123.234.34.234'),(2152,1,'2013-06-18 11:19:48','logout',0,'管理员安全退出系统','','123.234.34.234'),(2153,10,'2013-06-18 11:19:55','login',0,'Ben登录到系统','','123.234.34.234'),(2154,1,'2013-06-19 12:34:58','login',0,'管理员登录到系统','','121.0.29.206'),(2155,1,'2013-06-19 12:35:50','logout',0,'管理员安全退出系统','','121.0.29.206'),(2156,17,'2013-06-19 12:35:59','login',0,'jessy登录到系统','','121.0.29.206'),(2157,17,'2013-06-19 13:30:48','logout',0,'jessy安全退出系统','','121.0.29.206'),(2158,10,'2013-06-19 13:30:56','login',0,'Ben登录到系统','','121.0.29.206'),(2159,10,'2013-06-19 13:31:46','logout',0,'Ben安全退出系统','','121.0.29.206'),(2160,17,'2013-06-19 13:31:57','login',0,'jessy登录到系统','','121.0.29.206'),(2161,17,'2013-06-19 13:36:05','logout',0,'jessy安全退出系统','','121.0.29.206'),(2162,10,'2013-06-19 13:36:13','login',0,'Ben登录到系统','','121.0.29.206'),(2163,10,'2013-06-19 13:36:42','logout',0,'Ben安全退出系统','','121.0.29.206'),(2164,17,'2013-06-19 13:36:50','login',0,'jessy登录到系统','','121.0.29.206'),(2165,17,'2013-06-19 13:43:03','logout',0,'jessy安全退出系统','','121.0.29.206'),(2166,10,'2013-06-19 13:43:11','login',0,'Ben登录到系统','','121.0.29.206'),(2167,10,'2013-06-19 17:21:06','logout',0,'Ben安全退出系统','','121.0.29.206'),(2168,17,'2013-06-19 17:21:16','login',0,'jessy登录到系统','','121.0.29.206'),(2169,17,'2013-06-19 17:27:35','logout',0,'jessy安全退出系统','','121.0.29.206'),(2170,17,'2013-06-19 17:27:42','login',0,'jessy登录到系统','','121.0.29.206'),(2171,1,'2013-06-20 11:42:51','login',0,'管理员登录到系统','','218.249.118.226'),(2172,1,'2013-06-20 22:31:44','login',0,'管理员登录到系统','','175.51.151.168'),(2173,1,'2013-06-22 09:39:38','login',0,'管理员登录到系统','','211.143.7.62'),(2174,1,'2013-06-22 09:58:45','login',0,'管理员登录到系统','','211.143.7.62'),(2175,1,'2013-06-22 15:35:39','login',0,'管理员登录到系统','','221.175.73.229'),(2176,1,'2013-06-22 15:46:37','login',0,'管理员登录到系统','','211.143.7.62'),(2177,8,'2013-06-22 15:47:10','login',0,'163登录到系统','','221.175.73.229'),(2178,8,'2013-06-22 15:47:42','logout',0,'163安全退出系统','','221.175.73.229'),(2179,10,'2013-06-22 15:47:52','login',0,'Ben登录到系统','','221.175.73.229'),(2180,17,'2013-06-23 08:13:29','login',0,'jessy登录到系统','','115.237.115.87'),(2181,1,'2013-06-23 08:13:55','login',0,'管理员登录到系统','','115.237.115.87'),(2182,17,'2013-06-23 08:14:57','logout',0,'jessy安全退出系统','','115.237.115.87'),(2183,10,'2013-06-23 08:15:05','login',0,'Ben登录到系统','','115.237.115.87'),(2184,10,'2013-06-23 08:16:27','logout',0,'Ben安全退出系统','','115.237.115.87'),(2185,17,'2013-06-23 08:16:34','login',0,'jessy登录到系统','','115.237.115.87'),(2186,17,'2013-06-23 08:54:34','logout',0,'jessy安全退出系统','','115.237.115.87'),(2187,1,'2013-06-23 11:17:27','login',0,'管理员登录到系统','','115.237.115.87'),(2188,1,'2013-06-23 11:32:20','logout',0,'管理员安全退出系统','','115.237.115.87'),(2189,10,'2013-06-23 11:32:30','login',0,'Ben登录到系统','','115.237.115.87'),(2190,10,'2013-06-23 11:46:40','logout',0,'Ben安全退出系统','','115.237.115.87'),(2191,1,'2013-06-23 11:46:52','login',0,'管理员登录到系统','','115.237.115.87'),(2192,1,'2013-06-23 12:17:44','login',0,'管理员登录到系统','','115.237.115.87'),(2193,17,'2013-06-23 13:08:10','login',0,'jessy登录到系统','','115.237.115.87'),(2194,17,'2013-06-23 13:14:59','logout',0,'jessy安全退出系统','','115.237.115.87'),(2195,17,'2013-06-23 13:32:02','login',0,'jessy登录到系统','','115.237.115.87'),(2196,17,'2013-06-23 13:34:30','logout',0,'jessy安全退出系统','','115.237.115.87'),(2197,17,'2013-06-23 13:34:48','login',0,'jessy登录到系统','','115.237.115.87'),(2198,17,'2013-06-23 13:58:04','logout',0,'jessy安全退出系统','','115.237.115.87'),(2199,1,'2013-06-23 16:47:21','login',0,'管理员登录到系统','','115.237.115.87'),(2200,1,'2013-06-24 15:48:40','login',0,'管理员登录到系统','','218.16.143.237'),(2201,1,'2013-06-24 15:54:21','login',0,'管理员登录到系统','','218.16.143.237'),(2202,1,'2013-06-24 15:56:56','logout',0,'管理员安全退出系统','','218.16.143.237'),(2203,8,'2013-06-24 15:57:06','login',0,'163登录到系统','','218.16.143.237'),(2204,8,'2013-06-24 15:58:17','logout',0,'163安全退出系统','','218.16.143.237'),(2205,1,'2013-06-24 20:41:42','login',0,'管理员登录到系统','','113.107.0.68'),(2206,1,'2013-06-24 20:51:21','login',0,'管理员登录到系统','','113.107.0.68'),(2207,1,'2013-06-24 20:51:37','logout',0,'管理员安全退出系统','','113.107.0.68'),(2208,1,'2013-06-25 09:43:28','login',0,'管理员登录到系统','','123.234.34.234'),(2209,1,'2013-06-26 09:50:28','login',0,'管理员登录到系统','','221.8.67.41'),(2210,1,'2013-06-26 09:56:13','logout',0,'管理员安全退出系统','','221.8.67.41'),(2211,10,'2013-06-26 09:56:22','login',0,'Ben登录到系统','','221.8.67.41'),(2212,10,'2013-06-26 09:59:01','logout',0,'Ben安全退出系统','','221.8.67.41'),(2213,6,'2013-06-26 09:59:08','login',0,'Google登录到系统','','221.8.67.41'),(2214,6,'2013-06-26 09:59:36','logout',0,'Google安全退出系统','','221.8.67.41'),(2215,8,'2013-06-26 09:59:48','login',0,'163登录到系统','','221.8.67.41'),(2216,8,'2013-06-26 10:00:52','logout',0,'163安全退出系统','','221.8.67.41'),(2217,1,'2013-06-27 08:44:23','login',0,'管理员登录到系统','','123.6.205.5'),(2218,1,'2013-06-27 10:26:29','logout',0,'管理员安全退出系统','','123.6.205.5'),(2219,1,'2013-06-28 18:11:00','login',0,'管理员登录到系统','','61.144.224.53'),(2220,10,'2013-06-28 19:17:44','login',0,'Ben登录到系统','','120.197.114.197'),(2221,10,'2013-06-28 19:19:15','logout',0,'Ben安全退出系统','','120.197.114.197'),(2222,6,'2013-06-28 19:19:28','login',0,'Google登录到系统','','219.134.240.236'),(2223,1,'2013-06-28 22:43:42','login',0,'管理员登录到系统','','163.125.147.210'),(2224,1,'2013-07-01 09:52:13','login',0,'管理员登录到系统','','183.129.218.226'),(2225,1,'2013-07-01 09:58:33','login',0,'管理员登录到系统','','183.129.218.226'),(2226,1,'2013-07-01 09:59:43','login',0,'管理员登录到系统','','183.129.218.226'),(2227,1,'2013-07-01 10:00:33','login',0,'管理员登录到系统','','183.129.218.226'),(2228,1,'2013-07-01 10:41:12','login',0,'管理员登录到系统','','183.129.218.226'),(2229,1,'2013-07-01 11:51:53','login',0,'管理员登录到系统','','221.3.133.232'),(2230,1,'2013-07-01 11:54:21','login',0,'管理员登录到系统','','183.129.218.226'),(2231,1,'2013-07-01 14:20:08','login',0,'管理员登录到系统','','183.129.218.226'),(2232,1,'2013-07-01 14:30:19','login',0,'管理员登录到系统','','221.8.67.41'),(2233,1,'2013-07-01 14:49:05','logout',0,'管理员安全退出系统','','221.8.67.41'),(2234,10,'2013-07-01 14:49:13','login',0,'Ben登录到系统','','221.8.67.41'),(2235,10,'2013-07-01 14:49:32','logout',0,'Ben安全退出系统','','221.8.67.41'),(2236,6,'2013-07-01 14:50:05','login',0,'Google登录到系统','','221.8.67.41'),(2237,1,'2013-07-01 20:35:40','login',0,'管理员登录到系统','','219.134.240.236'),(2238,1,'2013-07-02 11:24:24','login',0,'管理员登录到系统','','123.234.34.234'),(2239,1,'2013-07-02 17:32:48','login',0,'管理员登录到系统','','222.211.220.108'),(2240,1,'2013-07-02 21:14:11','login',0,'管理员登录到系统','','171.8.158.77'),(2241,1,'2013-07-02 21:16:33','logout',0,'管理员安全退出系统','','171.8.158.77'),(2242,1,'2013-07-03 14:38:51','login',0,'管理员登录到系统','','219.144.163.180'),(2243,1,'2013-07-03 15:09:50','logout',0,'管理员安全退出系统','','219.144.163.180'),(2244,1,'2013-07-03 16:11:43','login',0,'管理员登录到系统','','110.217.61.170'),(2245,10,'2013-07-04 09:06:36','login',0,'Ben登录到系统','','118.116.97.183'),(2246,1,'2013-07-04 10:02:25','login',0,'管理员登录到系统','','211.140.108.219'),(2247,1,'2013-07-04 10:54:20','login',0,'管理员登录到系统','','183.129.218.226'),(2248,1,'2013-07-04 10:56:20','logout',0,'管理员安全退出系统','','183.129.218.226'),(2249,1,'2013-07-04 10:59:31','login',0,'管理员登录到系统','','183.129.218.226'),(2250,1,'2013-07-04 10:59:46','logout',0,'管理员安全退出系统','','183.129.218.226'),(2251,10,'2013-07-04 15:12:28','login',0,'Ben登录到系统','','42.228.47.10'),(2252,10,'2013-07-05 13:25:47','login',0,'Ben登录到系统','','113.120.215.109'),(2253,10,'2013-07-06 19:03:08','login',0,'Ben登录到系统','','171.8.158.77'),(2254,10,'2013-07-09 11:15:51','login',0,'Ben登录到系统','','124.205.51.194'),(2255,10,'2013-07-09 11:16:01','login',0,'Ben登录到系统','','124.205.51.194'),(2256,4,'2013-07-09 21:24:56','login',0,'Tom登录到系统','','112.226.124.131'),(2257,4,'2013-07-09 21:25:16','logout',0,'Tom安全退出系统','','112.226.124.131'),(2258,10,'2013-07-09 21:25:27','login',0,'Ben登录到系统','','112.226.124.131'),(2259,1,'2013-07-09 21:27:09','login',0,'管理员登录到系统','','0:0:0:0:0:0:0:1'),(2260,1,'2013-07-09 21:33:27','login',0,'管理员登录到系统','','0:0:0:0:0:0:0:1'),(2261,1,'2013-07-11 10:24:22','login',0,'管理员登录到系统','','124.205.51.194'),(2262,1,'2013-07-13 16:17:31','login',0,'管理员登录到系统','','123.234.34.234'),(2263,1,'2013-07-13 16:21:55','login',0,'管理员登录到系统','','183.5.134.148'),(2264,1,'2013-07-15 10:02:38','login',0,'管理员登录到系统','','1.85.20.146'),(2265,1,'2013-07-17 09:26:52','login',0,'管理员登录到系统','','101.40.232.248'),(2266,1,'2013-07-17 10:16:49','login',0,'管理员登录到系统','','183.62.204.226'),(2267,1,'2013-07-17 10:23:30','logout',0,'管理员安全退出系统','','183.62.204.226'),(2268,1,'2013-07-17 11:37:15','login',0,'管理员登录到系统','','119.6.113.49'),(2269,1,'2013-07-17 11:49:17','login',0,'管理员登录到系统','','61.163.127.142'),(2270,1,'2013-07-17 12:59:12','login',0,'管理员登录到系统','','218.22.80.106'),(2271,1,'2013-07-17 13:01:48','logout',0,'管理员安全退出系统','','218.22.80.106'),(2272,1,'2013-07-17 13:19:47','login',0,'管理员登录到系统','','218.94.22.122'),(2273,1,'2013-07-17 15:02:06','login',0,'管理员登录到系统','','58.211.171.166'),(2274,1,'2013-07-17 16:19:05','login',0,'管理员登录到系统','','61.163.127.142'),(2275,1,'2013-07-17 16:19:06','login',0,'管理员登录到系统','','123.234.34.234'),(2276,1,'2013-07-17 16:19:14','login',0,'管理员登录到系统','','123.234.34.234'),(2277,1,'2013-07-18 09:39:16','login',0,'管理员登录到系统','','220.166.95.59'),(2278,1,'2013-07-18 10:18:27','login',0,'管理员登录到系统','','124.205.99.43'),(2279,1,'2013-07-18 10:18:38','login',0,'管理员登录到系统','','124.205.99.43'),(2280,6,'2013-07-18 10:18:52','login',0,'Google登录到系统','','180.175.21.156'),(2281,1,'2013-07-18 10:19:10','login',0,'管理员登录到系统','','122.225.24.218'),(2282,1,'2013-07-18 10:19:59','login',0,'管理员登录到系统','','124.205.99.43'),(2283,1,'2013-07-18 10:20:10','login',0,'管理员登录到系统','','106.2.162.197'),(2284,8,'2013-07-18 10:20:21','login',0,'163登录到系统','','106.2.162.197'),(2285,6,'2013-07-18 10:21:17','login',0,'Google登录到系统','','218.17.162.171'),(2286,1,'2013-07-18 10:22:07','login',0,'管理员登录到系统','','118.244.199.2'),(2287,1,'2013-07-18 10:22:21','login',0,'管理员登录到系统','','182.48.115.78'),(2288,10,'2013-07-18 10:22:34','login',0,'Ben登录到系统','','182.48.115.78'),(2289,1,'2013-07-18 10:24:02','login',0,'管理员登录到系统','','101.44.183.144'),(2290,1,'2013-07-18 10:55:11','login',0,'管理员登录到系统','','114.252.228.128'),(2291,6,'2013-07-18 11:02:14','login',0,'Google登录到系统','','123.114.63.80'),(2292,1,'2013-07-18 11:09:10','login',0,'管理员登录到系统','','113.97.83.91'),(2293,1,'2013-07-18 20:06:17','login',0,'管理员登录到系统','','27.219.73.246'),(2294,1,'2013-07-18 20:30:16','login',0,'管理员登录到系统','','27.219.73.246'),(2295,1,'2013-07-19 16:26:03','login',0,'管理员登录到系统','','123.113.149.246'),(2296,1,'2013-07-19 17:06:11','login',0,'管理员登录到系统','','123.234.34.234'),(2297,1,'2013-07-21 16:01:28','login',0,'管理员登录到系统','','123.234.34.234'),(2298,1,'2013-07-21 16:09:29','login',0,'管理员登录到系统','','123.234.34.234'),(2299,1,'2013-07-21 16:28:12','login',0,'管理员登录到系统','','123.234.34.234'),(2300,1,'2013-07-21 16:31:49','login',0,'管理员登录到系统','','123.234.34.234'),(2301,1,'2013-07-21 17:09:03','login',0,'管理员登录到系统','','123.234.34.234'),(2302,1,'2013-07-21 17:39:56','login',0,'管理员登录到系统','','123.234.34.234'),(2303,1,'2013-07-21 18:05:41','logout',0,'管理员安全退出系统','','123.234.34.234'),(2304,1,'2013-07-21 18:05:47','login',0,'管理员登录到系统','','123.234.34.234'),(2305,1,'2013-07-21 18:17:29','login',0,'管理员登录到系统','','123.234.34.234'),(2306,1,'2013-07-21 21:08:57','login',0,'管理员登录到系统','','124.129.66.199'),(2307,1,'2013-07-21 21:17:18','logout',0,'管理员安全退出系统','','124.129.66.199'),(2308,10,'2013-07-21 21:17:24','login',0,'Ben登录到系统','','124.129.66.199'),(2309,10,'2013-07-21 21:18:09','logout',0,'Ben安全退出系统','','124.129.66.199'),(2310,1,'2013-07-21 21:18:15','login',0,'管理员登录到系统','','124.129.66.199'),(2311,1,'2013-07-21 21:42:43','login',0,'管理员登录到系统','','124.129.66.199'),(2312,1,'2013-07-21 21:54:23','login',0,'管理员登录到系统','','124.129.66.199'),(2313,1,'2013-07-22 08:22:46','login',0,'管理员登录到系统','','123.234.34.234'),(2314,1,'2013-07-22 14:20:33','login',0,'管理员登录到系统','','123.234.34.234'),(2315,1,'2013-07-22 14:26:40','login',0,'管理员登录到系统','','58.250.81.110'),(2316,1,'2013-07-22 17:57:07','login',0,'管理员登录到系统','','219.159.77.44'),(2317,1,'2013-07-22 18:11:45','login',0,'管理员登录到系统','','219.159.77.44'),(2318,1,'2013-07-22 20:50:42','login',0,'管理员登录到系统','','27.219.74.10'),(2319,1,'2013-07-23 10:51:40','login',0,'管理员登录到系统','','123.234.34.234'),(2320,1,'2013-07-23 11:19:18','login',0,'管理员登录到系统','','123.234.34.234'),(2321,1,'2013-07-23 11:21:11','login',0,'管理员登录到系统','','123.234.34.234'),(2322,1,'2013-07-23 11:25:32','login',0,'管理员登录到系统','','123.234.34.234'),(2323,1,'2013-07-23 11:57:28','login',0,'管理员登录到系统','','123.234.34.234'),(2324,1,'2013-07-23 12:00:32','login',0,'管理员登录到系统','','123.234.34.234'),(2325,0,'2013-07-23 12:06:14','logout',0,'null安全退出系统','',NULL),(2326,1,'2013-07-23 12:06:23','login',0,'管理员登录到系统','','123.234.34.234'),(2327,1,'2013-07-23 15:04:42','login',0,'管理员登录到系统','','60.191.111.116'),(2328,1,'2013-07-23 17:28:07','login',0,'管理员登录到系统','','123.234.34.234'),(2329,1,'2013-07-23 18:05:28','login',0,'管理员登录到系统','','123.234.34.234'),(2330,1,'2013-07-23 18:06:47','login',0,'管理员登录到系统','','123.234.34.234'),(2331,1,'2013-07-23 20:32:48','login',0,'管理员登录到系统','','112.226.125.88'),(2332,1,'2013-07-23 20:36:29','login',0,'管理员登录到系统','','112.226.125.88'),(2333,1,'2013-07-23 20:44:38','login',0,'管理员登录到系统','','112.226.125.88'),(2334,1,'2013-07-23 20:48:37','login',0,'管理员登录到系统','','112.226.125.88'),(2335,1,'2013-07-23 20:55:30','login',0,'管理员登录到系统','','112.226.125.88'),(2336,1,'2013-07-23 20:58:46','login',0,'管理员登录到系统','','112.226.125.88'),(2337,1,'2013-07-23 21:01:05','login',0,'管理员登录到系统','','112.226.125.88'),(2338,1,'2013-07-23 21:03:52','login',0,'管理员登录到系统','','112.226.125.88'),(2339,1,'2013-07-23 21:24:41','login',0,'管理员登录到系统','','112.226.125.88'),(2340,1,'2013-07-23 21:30:55','login',0,'管理员登录到系统','','112.226.125.88'),(2341,1,'2013-07-23 21:33:32','login',0,'管理员登录到系统','','112.226.125.88'),(2342,1,'2013-07-23 21:38:26','login',0,'管理员登录到系统','','112.226.125.88'),(2343,1,'2013-07-23 21:42:51','login',0,'管理员登录到系统','','112.226.125.88'),(2344,1,'2013-07-23 21:44:34','login',0,'管理员登录到系统','','112.226.125.88'),(2345,1,'2013-07-23 21:45:50','logout',0,'管理员安全退出系统','','112.226.125.88'),(2346,10,'2013-07-23 21:45:57','login',0,'Ben登录到系统','','112.226.125.88'),(2347,1,'2013-07-23 21:49:53','login',0,'管理员登录到系统','','112.226.125.88'),(2348,1,'2013-07-23 21:50:12','logout',0,'管理员安全退出系统','','112.226.125.88'),(2349,10,'2013-07-23 21:50:22','login',0,'Ben登录到系统','','112.226.125.88'),(2350,10,'2013-07-23 21:53:25','logout',0,'Ben安全退出系统','','112.226.125.88'),(2351,4,'2013-07-23 21:53:32','login',0,'Tom登录到系统','','112.226.125.88'),(2352,4,'2013-07-23 21:54:06','logout',0,'Tom安全退出系统','','112.226.125.88'),(2353,1,'2013-07-23 21:54:12','login',0,'管理员登录到系统','','112.226.125.88'),(2354,1,'2013-07-23 21:54:19','logout',0,'管理员安全退出系统','','112.226.125.88'),(2355,10,'2013-07-23 21:54:25','login',0,'Ben登录到系统','','112.226.125.88'),(2356,1,'2013-07-23 22:02:35','login',0,'管理员登录到系统','','112.226.125.88'),(2357,1,'2013-07-23 22:05:50','login',0,'管理员登录到系统','','112.226.125.88'),(2358,1,'2013-07-23 22:15:17','login',0,'管理员登录到系统','','112.226.125.88'),(2359,10,'2013-07-23 22:20:07','login',0,'Ben登录到系统','','112.226.125.88'),(2360,10,'2013-07-23 22:20:22','logout',0,'Ben安全退出系统','','112.226.125.88'),(2361,1,'2013-07-23 22:20:29','login',0,'管理员登录到系统','','112.226.125.88'),(2362,1,'2013-07-23 22:20:41','logout',0,'管理员安全退出系统','','112.226.125.88'),(2363,4,'2013-07-23 22:20:48','login',0,'Tom登录到系统','','112.226.125.88'),(2364,4,'2013-07-23 22:21:07','logout',0,'Tom安全退出系统','','112.226.125.88'),(2365,10,'2013-07-24 10:01:28','login',0,'Ben登录到系统','','123.234.34.234'),(2366,1,'2013-07-24 10:57:05','login',0,'管理员登录到系统','','116.204.64.165'),(2367,1,'2013-07-24 10:58:13','login',0,'管理员登录到系统','','58.250.81.110'),(2368,1,'2013-07-24 10:59:42','logout',0,'管理员安全退出系统','','58.250.81.110'),(2369,10,'2013-07-24 11:00:07','login',0,'Ben登录到系统','','116.204.64.165'),(2370,1,'2013-07-24 17:22:28','login',0,'管理员登录到系统','','219.136.25.92'),(2371,1,'2013-07-24 17:30:00','login',0,'管理员登录到系统','','123.234.34.234'),(2372,1,'2013-07-24 17:30:08','login',0,'管理员登录到系统','','123.234.34.234'),(2373,1,'2013-07-24 17:39:38','login',0,'管理员登录到系统','','123.234.34.234'),(2374,1,'2013-07-25 21:43:15','login',0,'管理员登录到系统','','27.210.109.87'),(2375,1,'2013-07-25 21:44:37','logout',0,'管理员安全退出系统','','27.210.109.87'),(2376,4,'2013-07-25 21:44:45','login',0,'Tom登录到系统','','27.210.109.87'),(2377,4,'2013-07-25 21:44:55','logout',0,'Tom安全退出系统','','27.210.109.87'),(2378,1,'2013-07-25 21:45:02','login',0,'管理员登录到系统','','27.210.109.87'),(2379,1,'2013-07-25 21:45:37','logout',0,'管理员安全退出系统','','27.210.109.87'),(2380,4,'2013-07-25 21:45:46','login',0,'Tom登录到系统','','27.210.109.87'),(2381,4,'2013-07-25 21:54:52','login',0,'Tom登录到系统','','27.210.109.87'),(2382,4,'2013-07-25 21:55:22','logout',0,'Tom安全退出系统','','27.210.109.87'),(2383,1,'2013-07-25 21:55:30','login',0,'管理员登录到系统','','27.210.109.87'),(2384,1,'2013-07-25 21:57:59','logout',0,'管理员安全退出系统','','27.210.109.87'),(2385,1,'2013-07-25 21:58:07','login',0,'管理员登录到系统','','27.210.109.87'),(2386,1,'2013-07-25 22:10:24','login',0,'管理员登录到系统','','27.210.109.87'),(2387,1,'2013-07-25 22:36:25','login',0,'管理员登录到系统','','27.210.109.87'),(2388,1,'2013-07-25 22:38:37','login',0,'管理员登录到系统','','27.210.109.87'),(2389,1,'2013-07-25 22:43:28','login',0,'管理员登录到系统','','27.210.109.87'),(2390,1,'2013-07-26 13:40:13','login',0,'管理员登录到系统','','123.234.34.234'),(2391,1,'2013-07-26 14:20:51','login',0,'管理员登录到系统','','123.234.34.234'),(2392,1,'2013-07-26 14:36:10','login',0,'管理员登录到系统','','123.234.34.234'),(2393,1,'2013-07-26 14:40:20','login',0,'管理员登录到系统','','123.234.34.234'),(2394,1,'2013-07-26 14:44:01','login',0,'管理员登录到系统','','123.234.34.234'),(2395,1,'2013-07-26 15:07:11','login',0,'管理员登录到系统','','123.234.34.234'),(2396,1,'2013-07-26 15:13:40','login',0,'管理员登录到系统','','123.234.34.234'),(2397,1,'2013-07-26 15:29:59','login',0,'管理员登录到系统','','123.234.34.234'),(2398,1,'2013-07-26 15:35:45','login',0,'管理员登录到系统','','123.234.34.234'),(2399,1,'2013-07-26 16:06:28','login',0,'管理员登录到系统','','123.234.34.234'),(2400,1,'2013-07-26 16:08:04','login',0,'管理员登录到系统','','123.234.34.234'),(2401,1,'2013-07-26 16:08:16','logout',0,'管理员安全退出系统','','123.234.34.234'),(2402,4,'2013-07-26 16:08:23','login',0,'Tom登录到系统','','123.234.34.234'),(2403,4,'2013-07-26 16:08:39','logout',0,'Tom安全退出系统','','123.234.34.234'),(2404,10,'2013-07-26 16:08:45','login',0,'Ben登录到系统','','123.234.34.234'),(2405,10,'2013-07-26 16:09:06','logout',0,'Ben安全退出系统','','123.234.34.234'),(2406,1,'2013-07-26 16:09:19','login',0,'管理员登录到系统','','123.234.34.234'),(2407,1,'2013-07-26 16:09:39','logout',0,'管理员安全退出系统','','123.234.34.234'),(2408,2,'2013-07-26 16:09:46','login',0,'二级管理员登录到系统','','123.234.34.234'),(2409,2,'2013-07-26 17:34:44','logout',0,'二级管理员安全退出系统','','123.234.34.234'),(2410,1,'2013-07-27 12:31:14','login',0,'管理员登录到系统','','123.234.34.234'),(2411,1,'2013-07-27 12:38:49','logout',0,'管理员安全退出系统','','123.234.34.234'),(2412,4,'2013-07-27 12:38:56','login',0,'Tom登录到系统','','123.234.34.234'),(2413,1,'2013-07-27 13:05:33','login',0,'管理员登录到系统','','123.234.34.234'),(2414,1,'2013-07-27 13:06:53','logout',0,'管理员安全退出系统','','123.234.34.234'),(2415,2,'2013-07-27 13:07:02','login',0,'二级管理员登录到系统','','123.234.34.234'),(2416,2,'2013-07-27 13:07:18','logout',0,'二级管理员安全退出系统','','123.234.34.234'),(2417,4,'2013-07-27 13:07:27','login',0,'Tom登录到系统','','123.234.34.234'),(2418,1,'2013-07-27 13:47:10','login',0,'管理员登录到系统','','123.234.34.234'),(2419,1,'2013-07-27 13:54:05','login',0,'管理员登录到系统','','123.234.34.234'),(2420,1,'2013-07-27 13:54:49','logout',0,'管理员安全退出系统','','123.234.34.234'),(2421,4,'2013-07-27 13:54:56','login',0,'Tom登录到系统','','123.234.34.234'),(2422,4,'2013-07-27 13:57:54','logout',0,'Tom安全退出系统','','123.234.34.234'),(2423,1,'2013-07-27 13:58:05','login',0,'管理员登录到系统','','123.234.34.234'),(2424,1,'2013-07-27 14:01:30','logout',0,'管理员安全退出系统','','123.234.34.234'),(2425,4,'2013-07-27 14:01:37','login',0,'Tom登录到系统','','123.234.34.234'),(2426,4,'2013-07-27 14:01:50','logout',0,'Tom安全退出系统','','123.234.34.234'),(2427,1,'2013-07-27 14:01:57','login',0,'管理员登录到系统','','123.234.34.234'),(2428,1,'2013-07-27 14:14:29','login',0,'管理员登录到系统','','123.234.34.234'),(2429,1,'2013-07-27 14:26:14','login',0,'管理员登录到系统','','123.234.34.234'),(2430,1,'2013-07-27 14:28:08','login',0,'管理员登录到系统','','123.234.34.234'),(2431,1,'2013-07-27 14:45:24','login',0,'管理员登录到系统','','123.234.34.234'),(2432,1,'2013-07-27 15:10:40','logout',0,'管理员安全退出系统','','123.234.34.234'),(2433,4,'2013-07-27 15:10:47','login',0,'Tom登录到系统','','123.234.34.234'),(2434,4,'2013-07-27 15:11:01','logout',0,'Tom安全退出系统','','123.234.34.234'),(2435,10,'2013-07-27 15:11:09','login',0,'Ben登录到系统','','123.234.34.234'),(2436,10,'2013-07-27 15:11:20','logout',0,'Ben安全退出系统','','123.234.34.234'),(2437,1,'2013-07-28 17:41:40','login',0,'管理员登录到系统','','61.163.104.78'),(2438,1,'2013-07-28 20:41:08','login',0,'管理员登录到系统','','27.210.109.87'),(2439,1,'2013-07-29 08:42:33','login',0,'管理员登录到系统','','120.194.22.72'),(2440,1,'2013-07-29 08:53:27','login',0,'管理员登录到系统','','120.194.22.72'),(2441,1,'2013-07-29 08:54:27','logout',0,'管理员安全退出系统','','120.194.22.72'),(2442,1,'2013-07-29 08:58:08','login',0,'管理员登录到系统','','120.194.22.72'),(2443,1,'2013-07-29 09:00:49','logout',0,'管理员安全退出系统','','120.194.22.72'),(2444,2,'2013-07-29 09:01:00','login',0,'二级管理员登录到系统','','120.194.22.72'),(2445,2,'2013-07-29 09:01:14','logout',0,'二级管理员安全退出系统','','120.194.22.72'),(2446,4,'2013-07-29 09:01:23','login',0,'Tom登录到系统','','120.194.22.72'),(2447,4,'2013-07-29 09:01:49','logout',0,'Tom安全退出系统','','120.194.22.72'),(2448,1,'2013-07-29 09:01:57','login',0,'管理员登录到系统','','120.194.22.72'),(2449,1,'2013-07-29 09:20:57','login',0,'管理员登录到系统','','120.194.22.72'),(2450,1,'2013-07-29 11:18:44','login',0,'管理员登录到系统','','123.234.34.234'),(2451,1,'2013-07-29 12:03:33','login',0,'管理员登录到系统','','123.234.34.234'),(2452,1,'2013-07-29 20:51:32','login',0,'管理员登录到系统','','27.210.91.52'),(2453,1,'2013-07-29 21:15:23','login',0,'管理员登录到系统','','27.210.91.52'),(2454,1,'2013-07-29 22:16:03','login',0,'管理员登录到系统','','27.210.91.52'),(2455,10,'2013-07-30 11:16:28','login',0,'Ben登录到系统','','42.228.117.38'),(2456,10,'2013-07-30 11:16:40','logout',0,'Ben安全退出系统','','42.228.117.38'),(2457,1,'2013-07-30 11:16:48','login',0,'管理员登录到系统','','42.228.117.38'),(2458,1,'2013-07-30 14:41:29','login',0,'管理员登录到系统','','116.204.64.165'),(2459,1,'2013-07-30 18:54:36','login',0,'管理员登录到系统','','27.193.104.144'),(2460,1,'2013-07-30 18:55:02','logout',0,'管理员安全退出系统','','27.193.104.144'),(2461,10,'2013-07-30 18:55:11','login',0,'Ben登录到系统','','27.193.104.144'),(2462,10,'2013-07-30 18:55:52','logout',0,'Ben安全退出系统','','27.193.104.144'),(2463,1,'2013-07-30 18:56:05','login',0,'管理员登录到系统','','27.193.104.144'),(2464,1,'2013-07-30 19:06:42','logout',0,'管理员安全退出系统','','27.193.104.144'),(2465,4,'2013-07-30 19:06:51','login',0,'Tom登录到系统','','27.193.104.144'),(2466,4,'2013-07-30 19:07:18','logout',0,'Tom安全退出系统','','27.193.104.144'),(2467,1,'2013-07-30 19:07:25','login',0,'管理员登录到系统','','27.193.104.144'),(2468,1,'2013-07-30 19:12:04','login',0,'管理员登录到系统','','27.193.104.144'),(2469,1,'2013-07-30 20:34:16','login',0,'管理员登录到系统','','27.193.104.144'),(2470,1,'2013-07-30 20:38:01','login',0,'管理员登录到系统','','27.193.104.144'),(2471,1,'2013-07-30 20:42:03','login',0,'管理员登录到系统','','27.193.104.144'),(2472,1,'2013-07-30 20:43:17','logout',0,'管理员安全退出系统','','27.193.104.144'),(2473,10,'2013-07-30 20:43:25','login',0,'Ben登录到系统','','27.193.104.144'),(2474,10,'2013-07-30 20:43:44','logout',0,'Ben安全退出系统','','27.193.104.144'),(2475,1,'2013-07-30 20:43:55','login',0,'管理员登录到系统','','27.193.104.144'),(2476,1,'2013-07-30 20:44:24','logout',0,'管理员安全退出系统','','27.193.104.144'),(2477,4,'2013-07-30 20:44:31','login',0,'Tom登录到系统','','27.193.104.144'),(2478,4,'2013-07-30 20:44:45','logout',0,'Tom安全退出系统','','27.193.104.144'),(2479,4,'2013-07-30 20:44:51','login',0,'Tom登录到系统','','27.193.104.144'),(2480,4,'2013-07-30 20:45:02','logout',0,'Tom安全退出系统','','27.193.104.144'),(2481,11,'2013-07-30 20:45:09','login',0,'Li登录到系统','','27.193.104.144'),(2482,1,'2013-07-30 22:08:05','login',0,'管理员登录到系统','','222.89.192.165'),(2483,1,'2013-07-31 09:08:07','login',0,'管理员登录到系统','','210.73.73.225'),(2484,8,'2013-07-31 11:36:20','login',0,'1631登录到系统','','101.95.96.34'),(2485,8,'2013-07-31 11:37:03','logout',0,'1631安全退出系统','','101.95.96.34'),(2486,1,'2013-07-31 11:37:12','login',0,'管理员登录到系统','','101.95.96.34'),(2487,1,'2013-08-01 09:29:13','login',0,'管理员登录到系统','','61.150.43.46'),(2488,1,'2013-08-01 09:35:50','login',0,'管理员登录到系统','','61.150.43.46'),(2489,1,'2013-08-01 11:25:58','login',0,'管理员登录到系统','','211.136.253.181'),(2490,1,'2013-08-01 11:30:22','login',0,'管理员登录到系统','','123.234.34.234'),(2491,1,'2013-08-01 11:39:06','login',0,'管理员登录到系统','','123.234.34.234'),(2492,1,'2013-08-01 11:41:19','login',0,'管理员登录到系统','','123.234.34.234'),(2493,1,'2013-08-01 11:43:22','login',0,'管理员登录到系统','','123.234.34.234'),(2494,1,'2013-08-01 11:47:34','login',0,'管理员登录到系统','','123.234.34.234'),(2495,1,'2013-08-01 11:50:38','login',0,'管理员登录到系统','','123.234.34.234'),(2496,1,'2013-08-01 11:52:00','login',0,'管理员登录到系统','','123.234.34.234'),(2497,1,'2013-08-01 11:54:08','login',0,'管理员登录到系统','','123.234.34.234'),(2498,1,'2013-08-05 20:03:25','login',0,'管理员登录到系统','','27.219.74.117'),(2499,1,'2013-08-07 14:46:34','login',0,'管理员登录到系统','','120.10.116.81'),(2500,1,'2013-08-07 14:46:53','logout',0,'管理员安全退出系统','','120.10.116.81'),(2501,1,'2013-08-07 14:47:07','login',0,'管理员登录到系统','','120.10.116.81'),(2502,10,'2013-08-07 19:49:26','login',0,'Ben登录到系统','','112.95.103.124'),(2503,1,'2013-08-08 11:44:13','login',0,'管理员登录到系统','','123.234.34.234'),(2504,1,'2013-08-09 08:04:05','login',0,'管理员登录到系统','','123.234.34.234'),(2505,1,'2013-08-10 12:14:08','login',0,'管理员登录到系统','','140.224.91.46'),(2506,1,'2013-08-10 20:28:24','login',0,'管理员登录到系统','','60.10.64.58'),(2507,1,'2013-08-13 17:36:22','login',0,'管理员登录到系统','','123.234.34.234'),(2508,1,'2013-08-13 17:40:47','login',0,'管理员登录到系统','','123.234.34.234'),(2509,1,'2013-08-13 17:43:26','login',0,'管理员登录到系统','','123.234.34.234'),(2510,1,'2013-08-14 14:45:38','login',0,'管理员登录到系统','','123.234.34.234'),(2511,1,'2013-08-14 16:06:53','logout',0,'管理员安全退出系统','','123.234.34.234'),(2512,1,'2013-08-14 16:06:59','login',0,'管理员登录到系统','','123.234.34.234'),(2513,1,'2013-08-14 16:08:21','logout',0,'管理员安全退出系统','','123.234.34.234'),(2514,11,'2013-08-14 16:08:28','login',0,'Li登录到系统','','123.234.34.234'),(2515,11,'2013-08-14 16:08:55','logout',0,'Li安全退出系统','','123.234.34.234'),(2516,1,'2013-08-14 16:09:02','login',0,'管理员登录到系统','','123.234.34.234'),(2517,1,'2013-08-14 16:09:14','logout',0,'管理员安全退出系统','','123.234.34.234'),(2518,4,'2013-08-14 16:09:23','login',0,'Tom登录到系统','','123.234.34.234'),(2519,4,'2013-08-14 16:10:04','logout',0,'Tom安全退出系统','','123.234.34.234'),(2520,10,'2013-08-14 16:10:11','login',0,'Ben登录到系统','','123.234.34.234'),(2521,10,'2013-08-14 16:10:30','logout',0,'Ben安全退出系统','','123.234.34.234'),(2522,1,'2013-08-14 16:10:36','login',0,'管理员登录到系统','','123.234.34.234'),(2523,1,'2013-08-14 16:10:54','logout',0,'管理员安全退出系统','','123.234.34.234'),(2524,10,'2013-08-14 16:11:00','login',0,'Ben登录到系统','','123.234.34.234'),(2525,1,'2013-08-14 20:03:55','login',0,'管理员登录到系统','','27.210.192.151'),(2526,1,'2013-08-14 20:13:08','login',0,'管理员登录到系统','','27.210.192.151'),(2527,1,'2013-08-14 20:32:45','login',0,'管理员登录到系统','','27.210.192.151'),(2528,1,'2013-08-14 20:35:04','login',0,'管理员登录到系统','','27.210.192.151'),(2529,1,'2013-08-14 20:45:03','login',0,'管理员登录到系统','','27.210.192.151'),(2530,1,'2013-08-14 20:46:14','logout',0,'管理员安全退出系统','','27.210.192.151'),(2531,10,'2013-08-14 20:46:22','login',0,'Ben登录到系统','','27.210.192.151'),(2532,1,'2013-08-14 20:49:15','login',0,'管理员登录到系统','','27.210.192.151'),(2533,1,'2013-08-14 20:56:20','login',0,'管理员登录到系统','','27.210.192.151'),(2534,1,'2013-08-14 20:57:21','logout',0,'管理员安全退出系统','','27.210.192.151'),(2535,10,'2013-08-14 20:57:28','login',0,'Ben登录到系统','','27.210.192.151'),(2536,10,'2013-08-14 20:58:18','logout',0,'Ben安全退出系统','','27.210.192.151'),(2537,10,'2013-08-14 20:58:25','login',0,'Ben登录到系统','','27.210.192.151'),(2538,10,'2013-08-14 20:58:36','logout',0,'Ben安全退出系统','','27.210.192.151'),(2539,4,'2013-08-14 20:58:50','login',0,'Tom登录到系统','','27.210.192.151'),(2540,4,'2013-08-14 20:59:23','logout',0,'Tom安全退出系统','','27.210.192.151'),(2541,1,'2013-08-14 20:59:36','login',0,'管理员登录到系统','','27.210.192.151'),(2542,1,'2013-08-14 21:01:12','login',0,'管理员登录到系统','','27.210.192.151'),(2543,1,'2013-08-14 21:02:14','logout',0,'管理员安全退出系统','','27.210.192.151'),(2544,4,'2013-08-14 21:02:25','login',0,'Tom登录到系统','','27.210.192.151'),(2545,4,'2013-08-14 21:03:03','logout',0,'Tom安全退出系统','','27.210.192.151'),(2546,4,'2013-08-14 21:03:11','login',0,'Tom登录到系统','','27.210.192.151'),(2547,4,'2013-08-14 21:03:19','logout',0,'Tom安全退出系统','','27.210.192.151'),(2548,1,'2013-08-14 21:03:29','login',0,'管理员登录到系统','','27.210.192.151'),(2549,1,'2013-08-14 21:03:45','logout',0,'管理员安全退出系统','','27.210.192.151'),(2550,10,'2013-08-14 21:03:53','login',0,'Ben登录到系统','','27.210.192.151'),(2551,10,'2013-08-14 21:11:44','logout',0,'Ben安全退出系统','','27.210.192.151'),(2552,1,'2013-08-14 21:11:52','login',0,'管理员登录到系统','','27.210.192.151'),(2553,1,'2013-08-14 21:13:15','login',0,'管理员登录到系统','','120.194.22.72'),(2554,1,'2013-08-14 21:13:46','logout',0,'管理员安全退出系统','','120.194.22.72'),(2555,10,'2013-08-14 21:13:53','login',0,'Ben登录到系统','','120.194.22.72'),(2556,10,'2013-08-14 21:21:48','logout',0,'Ben安全退出系统','','120.194.22.72'),(2557,4,'2013-08-14 21:24:32','login',0,'Tom登录到系统','','27.210.192.151'),(2558,4,'2013-08-14 21:24:39','logout',0,'Tom安全退出系统','','27.210.192.151'),(2559,10,'2013-08-14 21:24:47','login',0,'Ben登录到系统','','27.210.192.151'),(2560,10,'2013-08-14 21:26:06','login',0,'Ben登录到系统','','120.194.22.72'),(2561,10,'2013-08-14 21:26:14','login',0,'Ben登录到系统','','120.194.22.72'),(2562,10,'2013-08-14 21:27:14','logout',0,'Ben安全退出系统','','120.194.22.72'),(2563,4,'2013-08-14 21:27:21','login',0,'Tom登录到系统','','120.194.22.72'),(2564,1,'2013-08-14 21:27:52','login',0,'管理员登录到系统','','27.210.192.151'),(2565,4,'2013-08-14 21:28:00','logout',0,'Tom安全退出系统','','120.194.22.72'),(2566,9,'2013-08-14 21:28:07','login',0,'Lucy登录到系统','','120.194.22.72'),(2567,9,'2013-08-14 21:28:42','logout',0,'Lucy安全退出系统','','120.194.22.72'),(2568,7,'2013-08-14 21:28:49','login',0,'Baidu登录到系统','','120.194.22.72'),(2569,7,'2013-08-14 21:29:49','logout',0,'Baidu安全退出系统','','120.194.22.72'),(2570,14,'2013-08-14 21:29:56','login',0,'test2登录到系统','','120.194.22.72'),(2571,14,'2013-08-14 21:30:47','logout',0,'test2安全退出系统','','120.194.22.72'),(2572,1,'2013-08-14 21:30:53','login',0,'管理员登录到系统','','120.194.22.72'),(2573,10,'2013-08-14 21:31:03','login',0,'Ben登录到系统','','27.210.192.151'),(2574,1,'2013-08-14 21:31:24','logout',0,'管理员安全退出系统','','120.194.22.72'),(2575,1,'2013-08-14 21:33:38','login',0,'管理员登录到系统','','27.210.192.151'),(2576,1,'2013-08-15 07:57:52','login',0,'管理员登录到系统','','123.234.34.234'),(2577,1,'2013-08-15 08:04:41','login',0,'管理员登录到系统','','123.234.34.234'),(2578,1,'2013-08-15 08:12:08','login',0,'管理员登录到系统','','123.234.34.234'),(2579,1,'2013-08-15 10:29:22','login',0,'管理员登录到系统','','123.234.34.234'),(2580,1,'2013-08-18 10:56:39','login',0,'管理员登录到系统','','27.184.72.149'),(2581,1,'2013-08-19 08:33:37','login',0,'管理员登录到系统','','123.234.34.234'),(2582,1,'2013-08-19 16:16:32','login',0,'管理员登录到系统','','123.234.34.234'),(2583,1,'2013-08-20 09:12:57','login',0,'管理员登录到系统','','115.236.188.226'),(2584,1,'2013-08-20 15:49:07','login',0,'管理员登录到系统','','113.16.25.89'),(2585,8,'2013-08-24 20:21:00','login',0,'1631登录到系统','','123.123.107.212'),(2586,1,'2013-08-25 00:43:42','login',0,'管理员登录到系统','','171.217.186.166'),(2587,1,'2013-08-25 00:46:37','login',0,'管理员登录到系统','','171.217.186.166'),(2588,1,'2013-08-25 00:49:36','login',0,'管理员登录到系统','','119.4.13.24'),(2589,1,'2013-08-25 00:51:30','login',0,'管理员登录到系统','','119.4.13.24'),(2590,8,'2013-08-26 15:30:08','login',0,'1631登录到系统','','223.166.166.208'),(2591,8,'2013-08-26 15:32:34','logout',0,'1631安全退出系统','','223.166.166.208'),(2592,1,'2013-08-26 15:32:42','login',0,'管理员登录到系统','','223.166.166.208'),(2593,10,'2013-08-27 15:08:41','login',0,'Ben登录到系统','','180.173.20.200'),(2594,1,'2013-08-27 15:19:10','login',0,'管理员登录到系统','','180.127.12.110'),(2595,10,'2013-08-27 15:54:24','logout',0,'Ben安全退出系统','','180.173.20.200'),(2596,8,'2013-08-27 15:54:32','login',0,'1631登录到系统','','180.173.20.200'),(2597,8,'2013-08-27 16:01:13','login',0,'1631登录到系统','','180.173.20.200'),(2598,1,'2013-08-27 17:01:46','login',0,'管理员登录到系统','','222.212.244.74'),(2599,1,'2013-08-27 17:11:32','login',0,'管理员登录到系统','','120.192.27.2'),(2600,1,'2013-08-27 17:14:44','login',0,'管理员登录到系统','','123.234.34.234'),(2601,10,'2013-08-28 09:32:00','login',0,'Ben登录到系统','','180.173.20.200'),(2602,10,'2013-08-28 09:51:23','login',0,'Ben登录到系统','','180.173.20.200'),(2603,1,'2013-08-28 09:52:30','login',0,'管理员登录到系统','','180.173.20.200'),(2604,1,'2013-08-28 10:01:55','logout',0,'管理员安全退出系统','','180.173.20.200'),(2605,8,'2013-08-28 10:02:02','login',0,'1631登录到系统','','180.173.20.200'),(2606,1,'2013-08-28 10:27:35','login',0,'管理员登录到系统','','125.70.11.136'),(2607,1,'2013-08-28 11:04:16','login',0,'管理员登录到系统','','222.90.170.190'),(2608,1,'2013-08-28 11:09:03','login',0,'管理员登录到系统','','10.130.160.54'),(2609,1,'2013-08-28 11:35:43','login',0,'管理员登录到系统','','106.120.35.246'),(2610,1,'2013-08-28 13:24:39','login',0,'管理员登录到系统','','10.130.160.54'),(2611,1,'2013-08-28 15:48:43','login',0,'管理员登录到系统','','125.70.11.136'),(2612,1,'2013-08-28 16:21:32','login',0,'管理员登录到系统','','125.70.11.136'),(2613,1,'2013-08-28 16:43:24','login',0,'管理员登录到系统','','123.234.34.234'),(2614,1,'2013-08-28 18:11:56','login',0,'管理员登录到系统','','125.70.11.136'),(2615,1,'2013-08-28 20:36:39','login',0,'管理员登录到系统','','180.91.81.136'),(2616,1,'2013-08-29 10:44:55','login',0,'管理员登录到系统','','124.64.245.4'),(2617,8,'2013-08-29 14:52:56','login',0,'1631登录到系统','','180.173.20.200'),(2618,1,'2013-08-29 16:25:45','login',0,'管理员登录到系统','','58.211.24.206'),(2619,1,'2013-08-29 16:36:55','login',0,'管理员登录到系统','','124.207.174.85'),(2620,1,'2013-08-29 16:39:34','logout',0,'管理员安全退出系统','','124.207.174.85'),(2621,8,'2013-08-29 16:40:45','login',0,'1631登录到系统','','124.207.174.85'),(2622,10,'2013-08-29 16:51:18','login',0,'Ben登录到系统','','180.173.20.200'),(2623,10,'2013-08-30 09:59:07','login',0,'Ben登录到系统','','42.228.32.18'),(2624,1,'2013-09-01 15:35:36','login',0,'管理员登录到系统','','27.193.106.250'),(2625,1,'2013-09-01 17:07:46','login',0,'管理员登录到系统','','27.193.106.250'),(2626,1,'2013-09-01 17:09:24','login',0,'管理员登录到系统','','27.193.106.250'),(2627,1,'2013-09-01 17:12:55','login',0,'管理员登录到系统','','27.193.106.250'),(2628,1,'2013-09-01 17:24:26','login',0,'管理员登录到系统','','27.193.106.250'),(2629,1,'2013-09-01 17:43:02','login',0,'管理员登录到系统','','27.193.106.250'),(2630,1,'2013-09-01 18:17:20','login',0,'管理员登录到系统','','27.193.106.250'),(2631,1,'2013-09-01 18:21:17','login',0,'管理员登录到系统','','27.193.106.250'),(2632,1,'2013-09-01 18:22:31','logout',0,'管理员安全退出系统','','27.193.106.250'),(2633,10,'2013-09-01 18:22:38','login',0,'Ben登录到系统','','27.193.106.250'),(2634,10,'2013-09-01 18:24:04','logout',0,'Ben安全退出系统','','27.193.106.250'),(2635,1,'2013-09-01 18:24:11','login',0,'管理员登录到系统','','27.193.106.250'),(2636,1,'2013-09-01 18:24:36','logout',0,'管理员安全退出系统','','27.193.106.250'),(2637,10,'2013-09-01 18:24:43','login',0,'Ben登录到系统','','27.193.106.250'),(2638,1,'2013-09-02 08:53:01','login',0,'管理员登录到系统','','58.215.28.226'),(2639,8,'2013-09-02 11:48:12','login',0,'1631登录到系统','','120.192.27.117'),(2640,1,'2013-09-02 20:14:44','login',0,'管理员登录到系统','','120.192.27.117'),(2641,1,'2013-09-02 21:00:26','login',0,'管理员登录到系统','','120.194.22.72'),(2642,1,'2013-09-02 21:01:48','logout',0,'管理员安全退出系统','','120.194.22.72'),(2643,10,'2013-09-02 21:01:56','login',0,'Ben登录到系统','','120.194.22.72'),(2644,1,'2013-09-02 21:02:44','login',0,'管理员登录到系统','','123.234.34.234'),(2645,1,'2013-09-02 21:02:54','login',0,'管理员登录到系统','','123.234.34.234'),(2646,1,'2013-09-03 20:16:06','login',0,'管理员登录到系统','','27.210.110.62'),(2647,1,'2013-09-03 20:28:56','login',0,'管理员登录到系统','','27.210.110.62'),(2648,1,'2013-09-03 20:31:02','logout',0,'管理员安全退出系统','','27.210.110.62'),(2649,10,'2013-09-03 20:31:10','login',0,'Ben登录到系统','','27.210.110.62'),(2650,1,'2013-09-03 20:54:52','login',0,'管理员登录到系统','','27.210.110.62'),(2651,1,'2013-09-03 21:03:30','login',0,'管理员登录到系统','','27.210.110.62'),(2652,1,'2013-09-03 21:09:37','login',0,'管理员登录到系统','','27.210.110.62');
/*!40000 ALTER TABLE `core_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_ballot_items`
--

DROP TABLE IF EXISTS `core_ballot_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_ballot_items` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `headerId` int(10) unsigned DEFAULT '0',
  `title` varchar(100) DEFAULT NULL,
  `orderNum` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_ballot_items`
--

LOCK TABLES `core_ballot_items` WRITE;
/*!40000 ALTER TABLE `core_ballot_items` DISABLE KEYS */;
INSERT INTO `core_ballot_items` VALUES (6,1,'2011-10-31 20:17:03',1,'2011-11-03 21:49:02',NULL,1,'张三',0),(7,1,'2011-10-31 20:17:23',1,'2011-11-03 21:49:07',NULL,1,'李四',0),(8,1,'2011-10-31 20:17:29',1,'2011-11-03 21:49:09',NULL,1,'王五',0),(9,1,'2011-10-31 20:17:36',1,'2011-11-03 21:49:10',NULL,1,'小马子',0),(10,1,'2011-11-03 21:35:20',5,'2011-11-04 20:20:47',NULL,2,'财务部',5),(11,1,'2011-11-03 21:35:28',9,'2011-11-04 20:20:27',NULL,2,'企管部',4),(12,1,'2011-11-03 21:35:35',1,'2011-11-04 20:29:52',NULL,2,'技术部',6),(13,1,'2011-11-03 21:35:42',10,'2011-11-04 20:20:35',NULL,2,'人事部',1),(14,1,'2011-11-03 21:35:49',6,'2011-11-04 20:20:56',NULL,2,'市场部',2),(15,1,'2011-11-04 19:07:13',11,'2011-11-04 20:21:11',NULL,2,'质控部',3);
/*!40000 ALTER TABLE `core_ballot_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofmucconversationlog`
--

DROP TABLE IF EXISTS `ofmucconversationlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofmucconversationlog` (
  `roomID` bigint(20) NOT NULL,
  `sender` text NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `logTime` char(15) NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `body` text,
  KEY `ofMucConversationLog_time_idx` (`logTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofmucconversationlog`
--

LOCK TABLES `ofmucconversationlog` WRITE;
/*!40000 ALTER TABLE `ofmucconversationlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofmucconversationlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_form`
--

DROP TABLE IF EXISTS `core_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_form` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `formName` varchar(100) DEFAULT NULL,
  `tableName` varchar(45) DEFAULT NULL,
  `opRead` varchar(1) DEFAULT '0',
  `enabledLog` varchar(1) DEFAULT 'N',
  `enabledAtt` varchar(1) DEFAULT 'N',
  `isPublish` varchar(1) DEFAULT 'N',
  `notice` varchar(450) DEFAULT NULL,
  `opEdit` varchar(45) DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_form`
--

LOCK TABLES `core_form` WRITE;
/*!40000 ALTER TABLE `core_form` DISABLE KEYS */;
INSERT INTO `core_form` VALUES (11,0,NULL,1,'2012-04-03 15:47:58',NULL,'会议室申请','core_form_main','5','Y','Y','N','会议申请表单正在维护……','1'),(12,1,'2012-05-10 00:00:00',1,'2012-06-16 21:29:26',NULL,'文件管理','core_form_main','6','N','Y','Y','','6'),(13,1,'2012-07-01 00:00:00',1,'2012-11-13 20:34:28',NULL,'机房温湿度记录表2','core_form_main','3','N','N','Y','','0'),(15,1,'2013-06-05 00:00:00',1,'2013-06-05 15:18:53',NULL,'办公家具申请','core_form_main','6','N','Y','Y','','6'),(16,1,'2013-06-23 11:23:47',0,NULL,NULL,'文具申请','core_form_main','3','Y','Y','Y','文具申请','3'),(17,1,'2013-09-02 08:55:29',0,NULL,'74ab2335-ee3f-4d85-9e10-62f3df0621fd','hjjjjjjj','core_form_main','3','N','N','Y','','0');
/*!40000 ALTER TABLE `core_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_task`
--

DROP TABLE IF EXISTS `core_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_task` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `processId` int(10) unsigned DEFAULT '0',
  `taskDefId` int(10) unsigned DEFAULT '0',
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `taskStatus` varchar(45) DEFAULT NULL,
  `note` varchar(400) DEFAULT NULL,
  `approverId` int(10) DEFAULT '0',
  `taskFrom` int(10) DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_task`
--

LOCK TABLES `core_task` WRITE;
/*!40000 ALTER TABLE `core_task` DISABLE KEYS */;
INSERT INTO `core_task` VALUES (44,10,'2012-02-01 20:00:06',1,'2012-02-08 19:51:10','7dd07a43-bca2-4ce5-917a-75776bdc1adb',24,1,'2012-02-01 20:00:06','2012-02-08 19:51:10','agree','',1,0),(45,1,'2012-02-08 19:51:10',10,'2012-10-10 21:04:16','eda902c5-4e68-4b25-84ee-3007334f9039',24,2,'2012-02-08 19:51:10','2012-10-10 21:04:16','agree','ok',10,0),(52,1,'2012-10-12 18:54:30',1,'2012-10-12 18:54:34','a2efb220-f369-4f26-b50b-c49aa7c3d26e',25,1,'2012-10-12 18:54:30','2012-10-12 18:54:34','agree','',1,0),(53,1,'2012-10-12 18:54:34',1,'2012-10-12 18:54:39','4065e3bb-4607-4323-ab41-8f3bfcdff762',25,2,'2012-10-12 18:54:34','2012-10-12 18:54:39','agree','',1,0),(54,1,'2012-10-12 19:23:31',1,'2012-10-12 19:28:22','b722f25c-b0ac-4f5f-b9db-0afd68220199',26,1,'2012-10-12 19:23:31','2012-10-12 19:28:22','agree','fff',1,0),(55,1,'2012-10-12 19:28:22',1,'2012-10-12 19:46:30','f3da39ea-6aff-4652-82bd-f5bdfa38f79f',26,2,'2012-10-12 19:28:22','2012-10-12 19:46:30','agree','',1,0),(61,1,'2013-05-23 16:37:34',1,'2013-05-23 16:37:45','ef6efc0c-d04d-45d4-9046-11a0cc6668ca',31,1,'2013-05-23 16:37:34','2013-05-23 16:37:45','reject','不OK',1,0),(76,10,'2013-06-05 19:43:38',0,NULL,'0402f1dc-294e-418a-8014-547c2eafcd56',34,4,'2013-06-05 19:43:38',NULL,'auto','',NULL,0),(77,10,'2013-06-05 19:43:38',10,'2013-06-05 20:04:57','450436c7-5906-4f3d-a28f-bd819a383fcb',34,5,'2013-06-05 19:43:38','2013-06-05 20:04:57','agree','',10,0),(78,10,'2013-06-05 19:43:38',10,'2013-06-05 20:05:00','1eb20b19-bf56-4bce-b222-7cb29c76994e',34,6,'2013-06-05 19:43:38','2013-06-05 20:05:00','agree','',10,0),(79,10,'2013-06-05 19:43:38',10,'2013-06-05 20:05:02','62fc21ef-efb0-4f91-a710-e8846b517fff',34,7,'2013-06-05 19:43:38','2013-06-05 20:05:02','agree','',10,0),(80,10,'2013-06-05 20:04:57',0,NULL,'1ba7858f-f41c-476e-b8ac-2d462f4cc05c',34,8,'2013-06-05 20:04:57',NULL,'auto','',NULL,0),(81,10,'2013-06-05 20:05:00',0,NULL,'bf9987c6-9d0d-4e9f-b968-e5129d459834',34,8,'2013-06-05 20:05:00',NULL,'auto','',NULL,0),(82,10,'2013-06-05 20:05:02',0,NULL,'0aefaa4e-9b73-4e39-b0e5-723d98006fe3',34,8,'2013-06-05 20:05:02',NULL,'auto','',NULL,0),(83,1,'2013-06-18 11:19:47',0,NULL,'ee1d3cf8-1859-4f37-94a1-caf951917f36',35,4,'2013-06-18 11:19:47',NULL,'auto','',NULL,0),(84,1,'2013-06-18 11:19:47',10,'2013-06-18 11:20:03','ea3cb7c7-8f71-4b8f-95cc-ac791cd20218',35,5,'2013-06-18 11:19:47','2013-06-18 11:20:03','agree','',10,0),(85,1,'2013-06-18 11:19:47',10,'2013-06-18 11:20:05','7e31d6d2-a5ff-40e5-b4c6-1edfc103b366',35,6,'2013-06-18 11:19:47','2013-06-18 11:20:05','agree','',10,0),(86,1,'2013-06-18 11:19:47',10,'2013-06-18 11:20:08','30be9379-966f-472f-80a8-b3b5699b4728',35,7,'2013-06-18 11:19:47','2013-06-18 11:20:08','agree','',10,0),(87,10,'2013-06-18 11:20:03',0,NULL,'7b9b55d9-0c19-4412-8da0-6fe63cbb400f',35,8,'2013-06-18 11:20:03',NULL,'auto','',NULL,0),(88,10,'2013-06-18 11:20:05',0,NULL,'86be8b24-03dd-4e03-8dbc-e376ef973ba9',35,8,'2013-06-18 11:20:05',NULL,'auto','',NULL,0),(89,10,'2013-06-18 11:20:08',0,NULL,'fed1e593-fcbf-43c0-8429-122de833fb38',35,8,'2013-06-18 11:20:08',NULL,'auto','',NULL,0),(92,10,'2013-06-23 11:33:49',0,'2013-07-23 00:00:34','2d17386a-e679-4aa9-9a57-7eb44e8d9864',38,13,'2013-06-23 11:33:49',NULL,'running','',4,0),(112,1,'2013-07-31 11:42:57',0,NULL,'00b5e058-a51c-4f30-8877-ccdf75704c1c',43,4,'2013-07-31 11:42:57',NULL,'auto',NULL,1,0),(113,1,'2013-07-31 11:42:57',0,NULL,'5ac6ac19-41a1-4058-b3f2-2bb211e67f04',43,5,'2013-07-31 11:42:57',NULL,'running',NULL,1,112),(114,1,'2013-07-31 11:42:57',0,NULL,'9198c954-713f-4996-918b-6595dbc9e150',43,6,'2013-07-31 11:42:57',NULL,'running',NULL,1,112),(115,1,'2013-07-31 11:42:57',0,NULL,'d47766fa-bbea-4289-a4f6-19cd66641c4c',43,7,'2013-07-31 11:42:57',NULL,'running',NULL,1,112),(135,10,'2013-08-14 21:31:36',0,'2013-08-14 21:31:47','381420ef-cf1b-4008-9dec-bc52da46e4dd',54,1,'2013-08-14 21:31:36','2013-08-14 21:31:47','agree','agree',10,0),(136,0,'2013-08-14 21:31:47',0,NULL,'fb0c6248-38be-4608-87a7-c92ab766bf1f',54,2,'2013-08-14 21:31:47',NULL,'running',NULL,10,135),(139,1,'2013-08-27 15:23:40',0,NULL,'b79e6006-0cac-451b-891c-804ac1c74e1b',56,4,'2013-08-27 15:23:40',NULL,'running',NULL,1,0),(140,1,'2013-08-27 17:15:27',0,NULL,'a67538ad-d7ff-4ec3-8407-8c6ef92f028f',57,1,'2013-08-27 17:15:27',NULL,'running',NULL,1,0),(141,1,'2013-08-28 10:28:57',0,NULL,'34a28252-342f-4bcb-a876-f519ca7ad705',58,1,'2013-08-28 10:28:57',NULL,'running',NULL,1,0),(142,10,'2013-09-01 18:23:41',0,'2013-09-01 18:23:59','6af2ac14-76de-4409-91f9-90cf58753b7c',59,1,'2013-09-01 18:23:41','2013-09-01 18:23:59','agree','ook',10,0),(143,1,'2013-09-01 18:23:59',0,'2013-09-01 18:24:28','715d1fc8-eea1-450b-a742-247cd4808640',59,2,'2013-09-01 18:23:59','2013-09-01 18:24:28','agree','ook',1,142),(144,10,'2013-09-01 18:24:28',0,'2013-09-01 18:25:13','9772d99c-d0ac-4ecf-80f5-ba3e4d9f3ac6',59,15,'2013-09-01 18:24:28','2013-09-01 18:25:13','agree','',10,143),(145,1,'2013-09-01 18:25:13',0,NULL,'f34e019f-5dff-4739-a926-c1c73b2bb4fa',59,16,'2013-09-01 18:25:13',NULL,'running',NULL,0,144),(146,1,'2013-09-02 20:15:36',0,NULL,'38dc42ab-0e3f-4436-b1f9-3f7c9ed6b143',60,1,'2013-09-02 20:15:36',NULL,'running',NULL,0,0),(147,1,'2013-09-02 20:18:27',0,NULL,'5d62814d-b63c-4fae-b750-04c500d0c063',61,1,'2013-09-02 20:18:27',NULL,'running',NULL,0,0),(148,1,'2013-09-03 20:56:04',0,NULL,'d566a5ca-019f-4d2a-b958-576b94a6c71a',62,1,'2013-09-03 20:56:04',NULL,'running',NULL,0,0);
/*!40000 ALTER TABLE `core_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofsaslauthorized`
--

DROP TABLE IF EXISTS `ofsaslauthorized`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofsaslauthorized` (
  `username` varchar(64) NOT NULL,
  `principal` text NOT NULL,
  PRIMARY KEY (`username`,`principal`(200))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofsaslauthorized`
--

LOCK TABLES `ofsaslauthorized` WRITE;
/*!40000 ALTER TABLE `ofsaslauthorized` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofsaslauthorized` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofgroupuser`
--

DROP TABLE IF EXISTS `ofgroupuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofgroupuser` (
  `groupName` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `administrator` tinyint(4) NOT NULL,
  PRIMARY KEY (`groupName`,`username`,`administrator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofgroupuser`
--

LOCK TABLES `ofgroupuser` WRITE;
/*!40000 ALTER TABLE `ofgroupuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofgroupuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_customer`
--

DROP TABLE IF EXISTS `crm_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_customer` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `gongsimc` varchar(45) DEFAULT NULL,
  `shengfen` varchar(45) DEFAULT NULL,
  `hangye` varchar(45) DEFAULT NULL,
  `guimo` varchar(45) DEFAULT NULL,
  `kehubm` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `dizhi` varchar(200) DEFAULT NULL,
  `youbian` varchar(45) DEFAULT NULL,
  `dianhua` varchar(45) DEFAULT NULL,
  `chuanzhen` varchar(45) DEFAULT NULL,
  `youjian` varchar(45) DEFAULT NULL,
  `wangzhi` varchar(100) DEFAULT NULL,
  `beizhu` varchar(450) DEFAULT NULL,
  `isarc` char(1) DEFAULT 'N',
  `nianyingye` decimal(10,2) DEFAULT '0.00',
  `dizhi2` varchar(200) DEFAULT NULL,
  `zidingyi` varchar(450) DEFAULT NULL,
  `zidingyi2` varchar(450) DEFAULT NULL,
  `kehulb` varchar(45) DEFAULT NULL,
  `kehuly` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_customer`
--

LOCK TABLES `crm_customer` WRITE;
/*!40000 ALTER TABLE `crm_customer` DISABLE KEYS */;
INSERT INTO `crm_customer` VALUES (1,8,'2012-03-24 00:00:00',1,'2012-11-19 19:15:30','60a59863-be61-4b1e-86f6-7a368366f25b','青岛中集集装箱制造有限公司','山东','银行','1-50人','QD-001','武汉','地址1','邮编邮编','电话','传真','传真','传真传真','备注','Y',NULL,'地址地址地址111','自定义','自定义','B','广告'),(2,8,'2012-03-31 00:00:00',1,'2012-04-08 20:27:31','efb389e7-154a-46ec-81a0-5a10ed0c2889','青岛正大','山东','保险','1-50人','QD-002','青岛','地址','邮编邮编','电话','传真','li@yahoo.comc.cn','传真传真','备注','N',NULL,'地址地址地址','自定义','自定义','A',NULL),(3,8,'2012-03-31 00:00:00',1,'2012-03-31 21:11:53','c9bcd7ed-a38f-4c96-b839-29a956605884','中国银行','山东','银行','1-50人','QD-003','青岛','地址','邮编邮编','电话','传真','传真','传真传真','备注','N',NULL,'地址地址地址','自定义','自定义','A',NULL),(4,8,'2012-03-31 00:00:00',1,'2012-04-08 20:28:19','ed6c2c3c-37b9-4208-bc69-bf777bb73260','北京银行','山东','证券','1-50人','QD-004','青岛','地址','邮编邮编','电话','传真','传真','传真传真','备注','Y',NULL,'地址地址地址','自定义','自定义','C',NULL),(5,8,'2012-03-31 00:00:00',1,'2012-05-11 20:52:34','33829018-6857-4353-b80d-bfca98a83de8','上海银行','山东','银行','1-50人','QD-005','青岛','地址','邮编邮编','电话','传真','传真','传真传真','备注','Y',NULL,'地址地址地址','自定义','自定义','A',NULL),(6,8,'2012-03-31 21:11:27',0,NULL,'48ea73dd-9635-4457-9075-9a9aec7fc273','中信证券','山东','银行','1-50人','QD-005','青岛','地址','邮编邮编','电话','传真','传真','传真传真','备注','Y',NULL,'地址地址地址','自定义','自定义','E',NULL),(7,8,'2012-04-02 13:16:53',0,NULL,'91114040-510d-4cf5-91d1-574174ee2f22','客户名称','湖北','银行','1-50人','WU-001','武汉','地址','邮编邮编','电话','传真','daiqianjie@sina.com','传真传真',NULL,'N',NULL,'地址地址地址','自定义','自定义','B',NULL),(8,8,'2012-04-02 13:16:53',0,NULL,'fd2bfb4a-53eb-4140-ba91-cd1559e379ba','青岛正大','湖北','银行','1-50人','WU-002','武汉','地址','邮编邮编','电话','传真','daiqianjie@sina.com','传真传真',NULL,'N',NULL,'地址地址地址','自定义','自定义','D',NULL),(9,8,'2012-04-02 13:16:53',0,NULL,'e8540aea-0f3d-4bae-9066-903732bff9e2','中国银行','湖北','银行','1-50人','WU-003','武汉','地址','邮编邮编','电话','传真','daiqianjie@sina.com','传真传真',NULL,'N',NULL,'地址地址地址','自定义','自定义','D',NULL),(11,8,'2012-04-02 00:00:00',1,'2012-04-08 20:22:49','9120c966-8dba-4f8a-8343-43e5d1aed699','上海银行','湖北','保险','1-50人','WU-005','武汉','地址','邮编邮编','电话','传真','daiqianjie@sina.com','传真传真','','N',NULL,'地址地址地址','自定义','自定义','E',NULL);
/*!40000 ALTER TABLE `crm_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_mail`
--

DROP TABLE IF EXISTS `crm_mail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_mail` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `recipient` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `subject` varchar(200) DEFAULT NULL,
  `message` text,
  `att` char(1) DEFAULT 'N',
  `sended` char(1) DEFAULT 'N',
  `gongsimc` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_mail`
--

LOCK TABLES `crm_mail` WRITE;
/*!40000 ALTER TABLE `crm_mail` DISABLE KEYS */;
INSERT INTO `crm_mail` VALUES (1,1,'2012-05-21 21:03:09',0,NULL,'8cf81c5a-a1a8-4e2b-9cf6-4d2982c572ce','dddd','aguest@163.com','Hello baby','<p>Hello babyHello babyHello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello baby</p>\n<p>Hello baby</p>',NULL,'Y','青岛正大'),(2,1,'2012-05-21 21:03:09',0,NULL,'8cf81c5a-a1a8-4e2b-9cf6-4d2982c572ce','李四','aguest@163.com','Hello baby','<p>Hello babyHello babyHello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello baby</p>\n<p>Hello baby</p>',NULL,'Y','客户名称'),(3,1,'2012-05-21 21:03:09',0,NULL,'8cf81c5a-a1a8-4e2b-9cf6-4d2982c572ce','嚣张','aguest@163.com','Hello baby','<p>Hello babyHello babyHello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello baby</p>\n<p>Hello baby</p>',NULL,'Y','青岛正大'),(4,1,'2012-05-21 21:03:09',0,NULL,'8cf81c5a-a1a8-4e2b-9cf6-4d2982c572ce','代前杰1','aguest@163.com','Hello baby','<p>Hello babyHello babyHello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello baby</p>\n<p>Hello baby</p>',NULL,'Y','客户名称'),(5,1,'2012-05-21 21:03:09',0,NULL,'8cf81c5a-a1a8-4e2b-9cf6-4d2982c572ce','找大脚','aguest@163.com','Hello baby','<p>Hello babyHello babyHello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello babyHello baby</p>\n<p>Hello babyHello babyHello baby</p>\n<p>Hello baby</p>',NULL,'Y','青岛正大'),(7,1,'2012-05-21 21:23:53',0,NULL,'475fc03c-cc77-428c-8a26-4872b10f72d0','李四','aguest@163.com','oooooooooooooooooo','<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>',NULL,'Y','客户名称'),(8,1,'2012-05-21 21:23:53',0,NULL,'475fc03c-cc77-428c-8a26-4872b10f72d0','嚣张','aguest@163.com','oooooooooooooooooo','<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>',NULL,'Y','青岛正大'),(9,1,'2012-05-21 21:23:53',0,NULL,'475fc03c-cc77-428c-8a26-4872b10f72d0','代前杰1','aguest@163.com','oooooooooooooooooo','<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>',NULL,'Y','客户名称'),(10,1,'2012-05-21 21:23:53',0,NULL,'475fc03c-cc77-428c-8a26-4872b10f72d0','找大脚','aguest@163.com','oooooooooooooooooo','<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>\n<p>oooooooooooooooooo</p>',NULL,'Y','青岛正大'),(11,1,'2012-05-21 21:30:13',0,NULL,'c862018c-26e0-4ff3-a81f-91dcef01a61b','嚣张','aguest@163.com','这个功能真是不错','<p>尊敬的username，</p>\n<p>这个功能真是不错这个功能真是不错这个功能真是不错这个功能真是不错</p>\n<p>强烈推荐的</p>',NULL,'Y','青岛正大'),(12,1,'2012-05-21 21:30:13',0,NULL,'c862018c-26e0-4ff3-a81f-91dcef01a61b','代前杰1','aguest@163.com','这个功能真是不错','<p>尊敬的username，</p>\n<p>这个功能真是不错这个功能真是不错这个功能真是不错这个功能真是不错</p>\n<p>强烈推荐的</p>',NULL,'Y','客户名称');
/*!40000 ALTER TABLE `crm_mail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_user`
--

DROP TABLE IF EXISTS `core_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_user` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `depaId` int(10) unsigned DEFAULT NULL,
  `jobId` int(10) unsigned DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `mobilePhone` varchar(100) DEFAULT NULL,
  `gender` char(1) DEFAULT 'N',
  `displayName` varchar(100) DEFAULT NULL,
  `isLock` char(1) DEFAULT 'N',
  `jobId2` int(10) DEFAULT NULL,
  `signameImage` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_user`
--

LOCK TABLES `core_user` WRITE;
/*!40000 ALTER TABLE `core_user` DISABLE KEYS */;
INSERT INTO `core_user` VALUES (1,0,'2011-08-23 21:43:02',0,'2013-07-21 18:05:20',NULL,'admin',13,12,'daiqianjie@163.com','86a2f4528292137c5946570f47f69186593cfd72a6228c2f','','13589310033','1','管理员','N',15,'upload\\signame\\66b7d18c-c707-471d-9a82-3291e3287deb.jpg'),(2,0,'2011-08-24 21:18:36',0,'2013-07-26 16:09:36',NULL,'subadmin',14,6,'914261631@qq.com','69e2ff840f0f025466258072fd46d1d9e53f5b0a77d7ac1e','123456','13589310033','Y','二级管理员','N',3,NULL),(3,0,'2011-09-09 09:21:13',0,'2012-01-12 20:38:30',NULL,'Kate',17,14,'kate@gmail.com','6ef21c7a9340bb263b991cc27c579d0fc85e35012c4fe747','','','0','Kate','N',0,NULL),(4,0,'2011-09-09 09:21:23',0,'2013-07-25 21:46:05',NULL,'Tom',2,1,'914261631@qq.com','ccd8c5a978e8775763398bda64b82e9f283c2076e8d91913','','','1','Tom','N',0,NULL),(5,0,'2011-09-09 09:21:37',0,'2012-01-22 22:20:39',NULL,'Yahoo',3,10,'yahoo@gmail.com','771d3aa6ebdfe58beba491d340418b2221bb331a2cb216d5','','',NULL,'Yahoo','N',0,NULL),(7,0,'2011-09-09 09:22:02',1,'2012-06-08 08:28:43',NULL,'Baidu',7,13,'baidu@gmail.com','3e3a30e32e4d50ae5995fe7dc02c7e1324bc4046b00b961a','','',NULL,'Baidu','N',0,NULL),(8,0,'2011-09-09 09:22:14',0,'2013-08-26 15:30:40',NULL,'163',4,9,'163@gmail.com','4524385447d618c44b1aa141fd10f6c4316a90f35a6d5f30','','',NULL,'1631','N',0,'upload\\signame\\faaa3ab7-8381-479d-a68f-b5ca250329c7.jpg'),(9,0,'2011-09-09 09:22:27',0,'2012-01-12 21:17:21',NULL,'Lucy',15,12,'lucy@gmail.com','f4f48778781eecd87dfc13c037a38593411a983f92424553','','',NULL,'Lucy','N',0,NULL),(10,0,'2011-09-09 09:22:51',0,'2013-06-08 10:41:02',NULL,'Ben',1,8,'daiqianjie@163.com','65b887bbafdfe58f0956d4ff7e150ca28b8d1efa694f5c00','','',NULL,'Ben','N',0,'upload\\signame\\f9655e43-303c-45ce-9147-aef09a7de1f3.jpg'),(11,0,'2011-09-09 09:22:59',0,'2013-08-14 16:08:53',NULL,'Li',2,3,'li@gmail.com','5b669bf6e8da145d903a930173ed9abadd7ea6aca7795a69','','',NULL,'Li','N',0,NULL),(12,0,'2012-06-08 08:29:29',NULL,NULL,NULL,'test',11,14,'914261631@qq.com','383928fd52f99d1d3f871d8e609cf25d9191df5e6c8441cb','','13589310033',NULL,'test','N',15,NULL),(13,0,'2012-06-08 08:32:29',NULL,NULL,NULL,'test1',11,14,'914261631@qq.com','d0aa6cf1c3f3e46f22c429320c0e9c45f5b740116df3a4aa','','13589310033',NULL,'test','N',15,NULL),(14,0,'2012-06-08 08:39:01',1,'2012-06-08 08:39:28',NULL,'test2',7,13,'11@163.com','701027d592fa9d82ff53e11c86cc75c03bad9bfcdb48bb23','','','N','test2','N',0,NULL),(17,0,'2013-06-16 16:09:43',0,'2013-06-19 13:06:07',NULL,'jessy',1,11,'1234@qq.com','4b72cc36334a683ce2cb86483b0f988710eef7e999cab4e7','','','Y','jessy','N',0,NULL);
/*!40000 ALTER TABLE `core_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_record`
--

DROP TABLE IF EXISTS `crm_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_record` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `xiangmumc` varchar(45) DEFAULT NULL,
  `jiaoyije` decimal(10,2) DEFAULT NULL,
  `jiaoyisj` datetime DEFAULT NULL,
  `kehufk` varchar(450) DEFAULT NULL,
  `beizhu` varchar(450) DEFAULT NULL,
  `isarc` char(1) DEFAULT 'N',
  `jieshusj` datetime DEFAULT NULL,
  `peixundx` varchar(450) DEFAULT NULL,
  `xueyuanrs` int(11) DEFAULT '0',
  `zengzhifw` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_record`
--

LOCK TABLES `crm_record` WRITE;
/*!40000 ALTER TABLE `crm_record` DISABLE KEYS */;
INSERT INTO `crm_record` VALUES (5,8,'2012-04-15 21:07:25',0,NULL,'efb389e7-154a-46ec-81a0-5a10ed0c2889','经理培训',300000.00,'2012-04-15 00:00:00','客户反馈客户反馈客户反馈','','N','2012-04-18 00:00:00','培训对象',100,'否');
/*!40000 ALTER TABLE `crm_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_user_session`
--

DROP TABLE IF EXISTS `core_user_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_user_session` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) DEFAULT NULL,
  `CDATE_` char(15) DEFAULT NULL,
  `MDATE_` char(15) DEFAULT NULL,
  `sessionId` varchar(100) DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `kickedout` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=1715 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_user_session`
--

LOCK TABLES `core_user_session` WRITE;
/*!40000 ALTER TABLE `core_user_session` DISABLE KEYS */;
INSERT INTO `core_user_session` VALUES (49,1,'1318939807765','1318939951812','370625A41A3255D7912D5931999E15A3','127.0.0.1',1),(51,0,'1318939937937','1318939938312','3E916F2EDAFE664DEA5A85574335A3CC',NULL,1),(52,0,'1318940872531',NULL,'9AFA46A0C3305DCE830DE9EE571EBA08',NULL,1),(53,1,'1319022499953','1319022507187','F6364420E75E958B828679564121BEEE','127.0.0.1',1),(54,1,'1319022528125','1319022545437','2262129877902E67332DE71203382A6E','127.0.0.1',1),(56,1,'1319022751562','1319022758515','576CDC13F05C8FF7E8CE9F6841FFFBA4','127.0.0.1',1),(60,0,'1319023073218','1319023283687','8A555EE92B3D64D71A05DB1D2CC522FD',NULL,1),(63,0,'1319023578250',NULL,'4F838605FEB681CF105C1C2EF9779D33',NULL,1),(64,1,'1319023689890','1319023877937','69E8D6E44001DCCB69A65D00899E0D8D','127.0.0.1',1),(65,0,'1319023736968','1319023917093','27341B340AEF793599B9F63717498E0C',NULL,1),(69,0,'1319024433890',NULL,'9D87B664999ED887E892C561869F3B26',NULL,1),(70,1,'1319024966312','1319025154656','81BDB45E4BFF0E852C81698BB9CCB456','127.0.0.1',1),(71,0,'1319025011843','1319025191968','F7CB73F2905355BBF9770F0A9B7FD1CB',NULL,1),(72,1,'1319025856890','1319031213031','4AA393644816439E84C5F294766658B7','127.0.0.1',1),(73,1,'1319112595937','1319120484375','174F55E6F13FD13BC6D992917BF571D6','127.0.0.1',1),(74,1,'1319200372906','1319202637250','AED6BECC70842FDC2E50C440C2076E37','127.0.0.1',1),(87,1,'1319292156230','1319292172333','5295388ED7558083E8410A705E59BBB7','127.0.0.1',1),(90,1,'1319342789437','1319343213156','183810916380ADD170D4609962041010','127.0.0.1',1),(91,1,'1319368146781','1319372776656','6E0E38773069048F57B35C78C63770FD','127.0.0.1',1),(92,1,'1319376301609','1319376445312','DC8A8DABD3B96F679772E6DCA20AEF1A','127.0.0.1',1),(93,1,'1319456550593','1319459094000','BDC75C119A133B5423696113AF9F575B','127.0.0.1',1),(95,0,'1319721233890',NULL,'411D852248A951FE42AC55E13F132F27',NULL,1),(96,1,'1319721380046','1319721552484','6966B55C8DF5A740E111EF7494331CD6','192.168.1.100',1),(100,1,'1319981569187','1319981634062','8F1D9B48023ACA83F9FE446C661859D8','127.0.0.1',1),(101,1,'1319981617187','1319981786093','1232F3838640F4798B33641A2BF8322B','127.0.0.1',1),(105,0,'1320062989843','1320063049968','53665D008D5C1BEF4468200FAC4493BF',NULL,1),(106,1,'1320063492937','1320068639234','6E28C355C6BBD08B6288D4B8F5C2E5C3','127.0.0.1',1),(107,1,'1320068745703','1320070232703','0B010C7AA7E9D329B618E48DADB74CB8','127.0.0.1',1),(108,1,'1320070361156','1320070443859','715E192F3A6A8D9596AE98198ED0F4D9','127.0.0.1',1),(121,1,'1320327639218','1320328152921','4909D74F36E00BCCE2BB139BE8FDEAAA','127.0.0.1',1),(144,1,'1320410892437','1320412725531','E1C707D1255A2EF312B963DCB212A068','127.0.0.1',1),(145,1,'1320414591125',NULL,'24B6B66CB6C3B8FE6CC04FD3C2410714','127.0.0.1',1),(146,0,'1320469346468',NULL,'03A5DDD9351B8C1836592E8109471813',NULL,1),(154,10,'1320497980687','1320503298953','F904D1BEBA86B947AD97EA2852536041','127.0.0.1',1),(155,1,'1320536175625','1320537390656','12B4560FD577F82A209DD36C80DF9BFA','127.0.0.1',1),(157,1,'1320751997984','1320754069796','6440AB7C19A6A878C716F8D47AEAB6FD','127.0.0.1',1),(158,1,'1320925588703','1320932991421','F2E9FA273A413AF21DEAE4079D6301F6','127.0.0.1',1),(159,1,'1320933072281','1320933099921','1C1943F9B415DF5926C91034F7852996','127.0.0.1',1),(160,1,'1321103195265','1321103896093','F89471029663C7167DD3CCE643E37343','127.0.0.1',1),(161,1,'1321165705745','1321165929557','A48E5062C665F2329A2BDDDE51FE1FC7','127.0.0.1',1),(162,1,'1321169229432','1321169413979','F5875F925FFDACB8A657C779749E3742','127.0.0.1',1),(163,1,'1321190869234','1321191422640','76CA3E47FF56D7569DF67FDD389EE4CA','127.0.0.1',1),(164,1,'1321271462953','1321274016812','D5D5ABEB7A01A1BBC00D5ABA9CE82415','127.0.0.1',1),(165,1,'1321449063796',NULL,'08C9902259E145FE4E794FA580123CCC','127.0.0.1',1),(166,1,'1321537289937','1321537333703','7CA6EC43D697B98557C1E0B9ECE4CA1F','127.0.0.1',1),(167,1,'1321687410828',NULL,'F1B983CE046D52EFFA99C72EB758BD9B','127.0.0.1',1),(168,1,'1321687583843',NULL,'62489DA66F39E4C3C6C8E7E8D1B77398','127.0.0.1',1),(169,1,'1321687640187','1321687642640','FA89F3D2718DD451B397639F77ED7DCE','127.0.0.1',1),(170,1,'1321706648796','1321707195906','68FDFAFEC5CB7B06C632BE7F245B6B65','127.0.0.1',1),(171,1,'1321748480765','1321756313593','C3E096121D6CF542FFD89FCF6429CDF6','127.0.0.1',1),(172,0,'1321967546156',NULL,'2EBFBADFDE434F80D16811559F3F9559',NULL,1),(173,0,'1321967801953',NULL,'9DD49FD04583D81B835FB34E1806513E',NULL,1),(174,1,'1322050853812','1322051413000','FE6999E052C90817A908C8052B5F3EEB','127.0.0.1',1),(176,1,'1322054924031','1322055214656','AABBA147CE8CD33F50DEA42A24158129','127.0.0.1',1),(177,0,'1322223863062',NULL,'86D418A723FBE3EA44A45A997C853242',NULL,1),(180,1,'1322228916921','1322230794781','E607930B83DE8332ED2A55345B0722BD','127.0.0.1',1),(181,1,'1322268873718','1322273321203','06C1C33A9D5D3BC5141701BBDD96187E','127.0.0.1',1),(182,1,'1322275356968','1322280028875','3F8A79F9B9680404798BD03F8EA81B9A','127.0.0.1',1),(183,1,'1322283111828','1322284310484','8DA9A7629626278719556240D88FC12E','127.0.0.1',1),(184,1,'1322370607906','1322370614968','8EFD1CFF507AA5994F83C01FD2BB908B','127.0.0.1',1),(186,1,'1322397913352','1322400182227','07DF268F6907CCE4F26405E1A4EB17F5','127.0.0.1',1),(187,1,'1322400202477','1322400717664','D19173AF2D79B74BACDD61A67B37240C','127.0.0.1',1),(188,0,'1322478357984',NULL,'A022A8F01EEF18D9DF58EACD97B072A1',NULL,1),(189,1,'1322478359187','1322479260984','F6CBCAFD57680451CE351F6F3D455C68','127.0.0.1',1),(190,1,'1322482970281','1322484875156','31D0BBFEAF754A15AD9CB91234678A8C','127.0.0.1',1),(191,1,'1322486898203','1322487509843','C58D5BDBBC43D897D868CD860088CF35','127.0.0.1',1),(195,0,'1322567192609',NULL,'A87806F19F070CF8CB11A17105217689',NULL,1),(197,0,'1322569083437',NULL,'CBADB4141D70DCB94B5837993B61B752',NULL,1),(200,0,'1322569422703',NULL,'B078CB45C984834A9E680F9C1A6E0612',NULL,1),(202,0,'1322569436828',NULL,'16872C520187F77AEB6F5502E1222F93',NULL,1),(204,0,'1322569959562',NULL,'4D5462ED401F7175FD729DA2D777D695',NULL,1),(206,0,'1322650260250',NULL,'2B6F61962F408BAD3800CF1551B3D854',NULL,1),(208,0,'1322650296390',NULL,'9BBAD48DB2D7CBA10591085F5B7E63B7',NULL,1),(209,1,'1322650296484','1322657165281','C8501BC13DCA3201E5137F8F049DDC75','127.0.0.1',1),(210,0,'1322660126937',NULL,'A32CCFC93E0C637656BF59B5CE131F90',NULL,1),(211,1,'1322660232578','1322660396484','C287CCE0093BD1A1515F7577909A8949','127.0.0.1',1),(213,0,'1322903738109',NULL,'FA9C73A7AC3158D2C3A53105956A5F1D',NULL,1),(215,0,'1322912530640',NULL,'DEA9ADF9C458C4176D43A173DDF38AA1',NULL,1),(216,1,'1322991502531','1322993175750','D16461268F6F6D54EE36D89FD2C0E204','127.0.0.1',1),(217,0,'1322995806984',NULL,'0DEAEB41AB0CB1B054895E32E5C7C83E',NULL,1),(218,1,'1322995807218','1322996783937','7E4474208CA0436A863B295B4164BE9F','127.0.0.1',1),(219,1,'1322996911421','1323003026409','B9682020740E9B938433BD6092854542','127.0.0.1',1),(220,1,'1323005441597','1323006785713','2A36BD6E474AA8D4E27162859FFFFAAC','127.0.0.1',1),(221,1,'1323081479953','1323089188781','0F427FEA83C0B8183F97ED1A9732ED1F','127.0.0.1',1),(222,1,'1323170776250','1323172674546','DAD641391314991538557DB126CD7E7C','127.0.0.1',1),(224,1,'1323177844921','1323177954593','FEBD88B589F70C905278A29D3518A93C','127.0.0.1',1),(225,1,'1323178016406','1323179662843','B3F0CD54F8EBF4ACB8FB950449A2DF72','127.0.0.1',1),(226,1,'1323254695093','1323257179187','FF6D6A171211168463E08915610FD2C6','127.0.0.1',1),(227,1,'1323259505234','1323266203703','5E211FE2DF8ADAD8FAC4C1F1CC1A2BA7','127.0.0.1',1),(228,1,'1323441361843','1323442190906','37D7D9164C048D37106D0AB6A23C471C','192.168.1.5',1),(230,1,'1324297574750','1324297610453','A3891FEF4F61FE65D70F3D11445C34B0','127.0.0.1',1),(231,1,'1324297662078','1324301948062','B6236C1A8E20B19AE6842FCD10C726C7','127.0.0.1',1),(232,1,'1324380785406','1324380862609','E2F11845753EEEC9518527CADA18205A','127.0.0.1',1),(233,0,'1324385237546',NULL,'BA0EEF63C6072761398F33F1CF5C112C',NULL,1),(235,0,'1324385634343',NULL,'2B5FAAFCC610EBED2FE4474E4F7FE5C4',NULL,1),(236,1,'1324385634484','1324389689322','C56BE8D28F46206335D7A68402274690','127.0.0.1',1),(241,0,'1324469387937',NULL,'50CC126C0171C49D8048495E21D2E0DD',NULL,1),(244,1,'1324470918359','1324470920109','62002650097E3610F5E32B9CC1FA4E7A','127.0.0.1',1),(248,1,'1324519000582','1324519023215','9A945521FA86F2A622DC83AA40087925','10.130.198.8',1),(249,1,'1324523271427','1324524224182','6C8AE0451DA1B860EF8AAC3343BBFB46','10.130.198.8',1),(250,1,'1324524268772','1324524438699','72A3F46E0E744C82346CDFE01659C077','10.130.198.8',1),(251,1,'1324531400346','1324536390998','C52E304E076CA14E44A7E780FB16D9CC','10.130.198.8',1),(252,1,'1324536501938','1324536513124','BC365122828F6D41D94EB15C151C39C6','10.130.198.8',1),(253,1,'1324537055244','1324541934057','DC7921BE7EAE89D3113F8A62E0FDF705','10.130.198.8',1),(254,1,'1324600514069','1324601821120','D17141B51C5B2D19A6C60BC875BCA788','10.130.198.8',1),(255,1,'1324603761077','1324604678070','DADE3728590C51B6AA5EE2E07C458322','10.130.198.8',1),(256,1,'1324607987854','1324609670948','D1C612424433F980945DD40767C748CE','10.130.198.8',1),(257,0,'1324612640810','1324612975590','31CB7648F07FB6B5E77EF28A603D4F75',NULL,1),(259,1,'1324617041970','1324617047873','F554834F89AE6EE7D2F707114A06EBA4','10.130.198.8',1),(261,1,'1324619528186','1324620863072','0E31956BF9CD0234FC5019384D7FB270','10.130.198.8',1),(262,1,'1324620959618','1324626346063','AE630C47F10C75ADF5F77E282C64E4D0','10.130.198.8',1),(267,1,'1324629196448','1324629464862','DD238EB34102E39397BB6A6A34397833','10.130.198.8',1),(268,1,'1324638365187','1324639365609','0E35F301CF1C5AD2F1AD5479676451B2','127.0.0.1',1),(270,1,'1324643771578','1324643774578','6FAD9985A60AB277D39361D29F5C4096','127.0.0.1',1),(271,1,'1324644134015','1324644166734','EE0A092A0DF4BAF55F4036EFA7CE1A35','127.0.0.1',1),(272,1,'1324688072843','1324690113375','27848D08C3E0622D56EFEFA298016F4D','127.0.0.1',1),(273,1,'1324705469796','1324708511984','37ACE3BE32910A469A6B5DD3733E3D38','127.0.0.1',1),(274,1,'1324708937265','1324709266000','51E1AEC4828CA1A79967E7EA1FA35978','127.0.0.1',1),(276,1,'1324710909359','1324711019203','62D84821ED493C1E88E83DAED6B5F562','127.0.0.1',1),(278,1,'1324716143171','1324718160375','A6C9BA23E39E10FD1A2C47135ABCFF06','127.0.0.1',1),(279,1,'1324720050625','1324720095390','DF3ED8D05478B9A77FA4B89D7D5395C2','127.0.0.1',1),(280,1,'1324720141140','1324720189359','CA5D592B82B6AC70CB03EDCF6A458D61','127.0.0.1',1),(281,1,'1324720365796','1324720721421','7963B803B772A0C64E47C0DC89D5833E','127.0.0.1',1),(283,0,'1324728077765',NULL,'087E8E37EA55EA75BFE48A77228FD503',NULL,1),(289,0,'1324728733531',NULL,'C1608F6B69B404898BC2D52DB5BA5413',NULL,1),(291,0,'1324731809703',NULL,'72383291A8CF79CC2AAEEAF6728DFA62',NULL,1),(293,0,'1324731830187',NULL,'AC5DE22EB960E02C7848F0B4EDD485F8',NULL,1),(296,0,'1324732243406',NULL,'E25DA0868FB14C66286154DC8DD78C20',NULL,1),(299,4,'1324732440875','1324732450359','279E51EB1C493107F569FF5DE0E040D6','127.0.0.1',1),(301,0,'1324732780531',NULL,'B5CA5AA9394A17FB35CBA390A41D7535',NULL,1),(303,0,'1324734802328',NULL,'02CEAC3435D2DA051EB3630C986B5327',NULL,1),(305,0,'1324734823968',NULL,'21933BF2C388D6D417E664D5BB08EBD9',NULL,1),(306,1,'1324734824109','1324734835359','598C257CE397B0A03CD232B6D4D7411D','127.0.0.1',1),(307,1,'1324784644875','1324785394828','DF28DC328EF3EE99C0C1D9D9FC370B46','127.0.0.1',1),(308,1,'1325077109406','1325080271843','5B039D3E420217808966531F2B41FC53','127.0.0.1',1),(309,1,'1325159266390','1325166443093','2671EC72D5D3698D9257AB9689E6BFAD','127.0.0.1',1),(310,1,'1325166499312','1325166568421','0528A74FFC554E059C32D46846EC5FBC','127.0.0.1',1),(311,1,'1325246842468','1325252394500','4CDDB153A44A5880B1C66B451D8D21FE','127.0.0.1',1),(312,1,'1325461560718','1325464829015','706D990F1ED44F2D76F89613D5D71639','127.0.0.1',1),(314,1,'1325475016031','1325475750937','63CF97A0C3491032826CA5926684FB54','127.0.0.1',1),(315,1,'1325480476484','1325480881062','99F8191C00EA23F3DE39110E955DD66C','127.0.0.1',1),(316,1,'1325488371625','1325494101203','2F1412FBD3D041BEAD4869BC397EBC1B','127.0.0.1',1),(318,1,'1325505226531','1325508742484','AC8BCAEDC2ED90F9F4543325F9194A99','127.0.0.1',1),(320,1,'1325583695468','1325583697281','35D2AEA2B515F611361AF34F2CAC7A92','127.0.0.1',1),(321,1,'1325681608343','1325681618906','D793A3B98BDBA136D1FD9F5714028B39','127.0.0.1',1),(322,1,'1325766106843','1325768336828','3086E4575542CA7DF59D02C65E745FBF','127.0.0.1',1),(337,1,'1325856138750','1325856151937','6AB32F957E1282698B3E8227551F49A9','127.0.0.1',1),(338,1,'1325898114562','1325898180765','C6A746D4B6E1ABD4775C8A73F4C23D4C','127.0.0.1',1),(340,1,'1325916723000','1325916968281','2F3A888B48873120EDBE0AB17D4927D9','127.0.0.1',1),(343,1,'1325922299515','1325922303265','FB176DBB4089943CD593FEC104F8DFC8','127.0.0.1',1),(344,1,'1325925951640','1325926139578','EBAEAD84A7AA43C2667937CE37C5D76A','127.0.0.1',1),(345,1,'1325941049484','1325943262453','0DCCA2D0CF54C8044444B3D2A1D29FAC','127.0.0.1',1),(347,0,'1325985277156',NULL,'BE45E0E1CB320F1E2C4E930B20E6456D',NULL,1),(348,1,'1325985277312','1325985438421','B9D46D15CEB94BD19829B4DC3B9042D4','127.0.0.1',1),(349,1,'1325985492046','1325990013812','CF5DE1125ABACFD681E2F7B9B2432AC5','127.0.0.1',1),(350,0,'1326110838859','1326111183062','9D5ACFC3313215C46E56366C4CBF63AA',NULL,1),(351,1,'1326111549296',NULL,'1AF440A4BAC9398D77CC4FF52C7E139A','127.0.0.1',1),(352,1,'1326283035281','1326286125171','7B49259DD5B3DA510E5AB1606BD1B7F1','127.0.0.1',1),(354,0,'1326289068531',NULL,'686D6C05FF83D9BF600F0E0814CD0B6B',NULL,1),(355,0,'1326367179234',NULL,'CE9B000CB029E2D46EDDD043700735A3',NULL,1),(401,1,'1326374512984','1326375234218','A7700DE497874C8A0C4AA5BDF0B3A16C','127.0.0.1',1),(402,1,'1326588777078','1326591364187','02424017ADEA5710E3F8218B1F6D9C5F','127.0.0.1',1),(404,1,'1326802984812','1326802986656','1E1BB74DC4ACED1CEA2BA419B8D42D14','127.0.0.1',1),(405,1,'1326804271281','1326805275920','B062536CB48B41B6AB58C16EE46EF206','127.0.0.1',1),(406,0,'1326807166435',NULL,'1ECA592D94D72126B7413DE2FE4FADF5',NULL,1),(408,11,'1326809490748','1326809496701','E982A29C2FF27BCA0AB7232EDA75B6CB','127.0.0.1',1),(409,1,'1326848903484','1326850066734','ACAD0A17CB31BAB43F7FAF9990E4A54E','127.0.0.1',1),(410,1,'1327122469234','1327122551906','319A6AED4E83E6DB6CB525107EB9633C','127.0.0.1',1),(412,1,'1327124543171','1327126363843','8D9332066C9D727050CB367D716AB1EC','127.0.0.1',1),(415,1,'1327136497421','1327136502640','03BD85C89BC4A26F56C56937BD467AA6','127.0.0.1',1),(421,1,'1327152998484','1327153031125','E7A26A925CF4178EDE6B74C73B5521FA','127.0.0.1',1),(426,1,'1327202755343','1327202852578','856265E0D8B7AB593E36A601C1B6AF58','127.0.0.1',1),(435,0,'1327222575031',NULL,'874453603292DEAED78632FE42AAB3A4',NULL,1),(439,1,'1327222653890','1327223344281','110217B73CD1E0EE8CFD7687232BDBDD','127.0.0.1',1),(442,0,'1327241582437',NULL,'A9999CF826677A417BC9EB5774B75D24',NULL,1),(444,0,'1327241655578',NULL,'2571A2E6851C34A8F92473A893EDF6BF',NULL,1),(447,0,'1327242014812',NULL,'582F993968B8201CDBCAB6AD7FDDCC7F',NULL,1),(451,1,'1327242080968','1327244269250','6DC09A623271089C5B9FF03C1CFDF968','127.0.0.1',1),(452,1,'1327319540968','1327319913453','2C9FE68C1A24A898F5366338C5E15181','127.0.0.1',1),(453,1,'1327403284468','1327403322609','F336B68CD1FA73147CD878970770D6F4','127.0.0.1',1),(454,1,'1327408517843',NULL,'5F862B50F03E56D298A51621053508A9','127.0.0.1',1),(455,1,'1327408524187','1327408544171','A9CE55BCBBA31C3FE6D0EB543148E4AB','127.0.0.1',1),(456,1,'1327842211843','1327842257484','BD8DD2A1CDE3E00CE8934ABD845C55CA','127.0.0.1',1),(457,1,'1328010857234','1328012800875','D492148E3D447A72C95FF1E417BA0ABC','127.0.0.1',1),(458,1,'1328093667625','1328094039703','1BE7AE2E48C2AAD89AFD562FD857FCFF','192.168.1.11',1),(459,1,'1328094079265','1328094183093','4B29F38834A2CB3BCA1AD03EDC99EDF5','192.168.1.11',1),(460,1,'1328094251578','1328094295671','9AE5B2BD556E574D8D748A370B63779C','192.168.1.11',1),(465,10,'1328097362046','1328097614656','38466A3370AFCF8828D3B59C6F7FFCC1','192.168.1.11',1),(467,1,'1328097937859','1328097953218','B4435C811E7CD035031DEA388E6E5823','127.0.0.1',1),(477,8,'1328098859093','1328098875812','6E659A85F35D289969F32C7DF4DF0D47','127.0.0.1',1),(478,1,'1328321441468','1328321582609','8318A4EF17A89BC86F43F0D624E47ABF','127.0.0.1',1),(479,1,'1328701247437','1328702680765','6DA894DE6A9683B3731D54CDECAF7F91','127.0.0.1',1),(480,1,'1328705198125','1328705210140','673DCDAFA13EB38ACF668A968114895F','127.0.0.1',1),(481,1,'1329012238531','1329012701375','7ACE4E3202798ABD37A7C496F19008CE','127.0.0.1',1),(482,1,'1329012977765',NULL,'03CFE5E45608585F5A64B6A0BB1DF788','127.0.0.1',1),(483,1,'1329550376171','1329550783468','9C061438375CF095A1FD83DDE2B06AF9','127.0.0.1',1),(484,1,'1329550796937',NULL,'36D20247407B8BDF865676D6021099E0','127.0.0.1',1),(485,1,'1330517371921','1330518015953','5F417F8F89B32767539D90668F2C398A','127.0.0.1',1),(486,1,'1330600257718','1330600280500','B263145DC055A6E65FD6A7E16BC5064D','127.0.0.1',1),(488,1,'1330601911453','1330601927109','CAB559E2E2828F48BA3F0B93BDBF2095','127.0.0.1',1),(489,1,'1330601999484','1330602330078','3A17F1C45FC9CA62C544F6BE44089E35','127.0.0.1',1),(490,1,'1330602450546','1330602839562','6BC88D3E7749CE8F0170D3C582D35D95','127.0.0.1',1),(494,1,'1330696703312','1330696710203','EA569624AEED0DD096896B61191B51FE','127.0.0.1',1),(495,1,'1330696814218','1330697072859','A21D27ED0A0E46EF492AEC864DC7D16C','127.0.0.1',1),(496,1,'1330737354531','1330737374031','C18AC5DDDDD5EFA9AFC7BA8F97C4E02A','127.0.0.1',1),(497,1,'1330754994828','1330755218718','92055A3A4D59C762DBD9F709113A0ED4','127.0.0.1',1),(499,1,'1330847750937','1330848152968','493AC8BD7D87664F766092A5326C6887','127.0.0.1',1),(500,1,'1330847833078','1330848496187','C854D4911C72CF2CA593C6AB48430E5A','127.0.0.1',1),(501,1,'1330854892687','1330854989796','7800930FEF54969AEA7609A18EBD92D3','127.0.0.1',1),(502,1,'1330864463453','1330865943046','B8EF5A43CB4C24DFAC3B13B60A4489D9','127.0.0.1',1),(507,8,'1330869509109','1330869514875','7D1AA90E6518A231C8EA025315B0A334','127.0.0.1',1),(510,8,'1330870042203','1330870047031','FDD702AEC72191B1390A36906AD53A15','127.0.0.1',1),(511,1,'1330946132609','1330947774015','A10425D2E701DD762652458C98AFE4B7','127.0.0.1',1),(512,1,'1331040327484','1331040333453','C34930D689676A28BF7D20E5E56ADDB1','127.0.0.1',1),(513,1,'1331041028187','1331041039093','F37706184CCACC7C7FFD5D117FD6271A','127.0.0.1',1),(514,1,'1331041214750','1331041293375','973F9CDB3196E1F88AFFCC67B0360EE7','127.0.0.1',1),(515,1,'1331041442906','1331041451421','A28A4B1FBC3B66A4263F57BBD539EE0C','127.0.0.1',1),(516,1,'1331041586046','1331041827578','BEE94E5C102B1821B7E41DC8240EA793','127.0.0.1',1),(517,1,'1331041897156','1331041904375','870D15C2EC752C975A3555D7B84311B2','127.0.0.1',1),(518,1,'1331041960468','1331041972593','9CB239B5E3BF5DBA3F0CB5698F4011D2','127.0.0.1',1),(519,1,'1331042055703','1331042061921','24B98F17718141089A1D74CCEC947F02','127.0.0.1',1),(520,1,'1331042128796','1331042135296','E6FEB184236E4409AB111528A2D405B1','127.0.0.1',1),(521,1,'1331042286515','1331042293312','7763D5EF1B980D26AAF1D5C699FEE5FC','127.0.0.1',1),(522,1,'1331042357375','1331042374000','81FF4998A6C2BB2F417C4A69DC67B33A','127.0.0.1',1),(523,1,'1331042433015','1331042439187','7186627841237EB06279F0B6EAB9B7A0','127.0.0.1',1),(524,1,'1331042546250','1331042552625','E9901F8C09420A771E886E388685ED2C','127.0.0.1',1),(525,1,'1331042706984','1331042716734','C6579BB5ACD10119801F730895168D7B','127.0.0.1',1),(526,1,'1331122018515','1331122070234','A1A91AC76C6C488232DB848433A9ADE6','127.0.0.1',1),(527,1,'1331123309360','1331123518203','E1A569E08FFAA2DC367AF5630971E85E','127.0.0.1',1),(528,1,'1331123819610','1331125896735','3DBE14FC97C466113D7D1B393ECBA1C0','127.0.0.1',1),(529,1,'1331125981547','1331126261047','1B997DADD782BB25178638BE64963F4D','127.0.0.1',1),(530,1,'1331127075297','1331127078282','213BC409531CEC5CD16A901565236928','127.0.0.1',1),(532,1,'1331127357625','1331127375703','DF3B2EC229CC9730971D278B4847BD8D','127.0.0.1',1),(533,1,'1331127422938','1331127430563','CC72F450FB94B246BB066B23C005FCD3','127.0.0.1',1),(534,1,'1331127493907','1331128097453','1E3CAB5916B557377B064B2B5E9F6983','127.0.0.1',1),(535,1,'1331206560250','1331206721218','C2EF4EC02721DD734E303991B6248294','127.0.0.1',1),(536,1,'1331206938421','1331207207312','8EF6C2BFB09864B0971EC81613CF38E6','127.0.0.1',1),(537,1,'1331207353875','1331207356734','65EDE45FF9888E09A0DA8F7508AE2299','127.0.0.1',1),(538,1,'1331207820546','1331208099437','6F8E9F7250B3D67CA8B8B6168623A4BA','127.0.0.1',1),(539,1,'1331208188625','1331208493578','52C28035407D6489375544DC23951367','127.0.0.1',1),(540,1,'1331208611640','1331208794875','447EB081E708CC61E2BC0B5764DBC6B7','127.0.0.1',1),(541,1,'1331208900531','1331209063140','D62880BDC4C0AA72309B96DB572C2C58','127.0.0.1',1),(542,1,'1331209309453','1331211754187','1F849FA80FDAB990EA8CF4CD089C8E32','127.0.0.1',1),(543,1,'1331213892375','1331213894812','78E08C30C3FF918542CB673AA4128758','127.0.0.1',1),(544,1,'1331214108984','1331214240953','0A2A24750C95AC8E118EC194B4B38D70','127.0.0.1',1),(545,1,'1331214374578','1331214510453','407D9315C609B16A8F8BDDBB64210D0F','127.0.0.1',1),(546,1,'1331214681187','1331215080421','CE4784246102ECC60E9976037ADDA2A1','127.0.0.1',1),(547,1,'1331292768062','1331293069109','DD5F597BE8C83EA67DF4536BD13CB16F','127.0.0.1',1),(548,1,'1331293341078','1331293830421','2B0D23D79B5D8CCCA51100054C130BFA','127.0.0.1',1),(549,1,'1331294047156','1331294831234','C7F9ED6D23D135A44AC4745722F958A3','127.0.0.1',1),(550,1,'1331378842937',NULL,'57AD432A8F79F851B42CA8450AAC75EF','127.0.0.1',1),(552,1,'1331470081156','1331470276812','80022F5FE4C89EB83AC8DA02DA349062','127.0.0.1',1),(553,1,'1331552598046','1331553254406','28DB67DB0F8CDA73EF4554FF1639A962','127.0.0.1',1),(554,1,'1331555885421','1331556159421','A2109049EECE835A98A4B1FAD83FE004','127.0.0.1',1),(555,1,'1331556322312','1331556493562','3F2B445C2A9361336CDAF314229ADBC4','127.0.0.1',1),(556,1,'1331556550796','1331556739656','18E152749A5D2984D2F02C26A0A55082','127.0.0.1',1),(557,1,'1331557054390','1331557066375','DB8DA6FA846021E229EA31A42A5F7098','127.0.0.1',1),(558,1,'1331557214328','1331557581921','677887306F7708C4A639C4CABC6F128A','127.0.0.1',1),(559,1,'1331557668093','1331558260468','F2BE334F3B7CD81482C29E37677D88F1','127.0.0.1',1),(560,1,'1332544437343','1332544934828','FE1F2664F313949589DD5D390A9D4743','127.0.0.1',1),(561,1,'1332547625093','1332547736578','A8EA470765A138E2849FA2F62417CF76','127.0.0.1',1),(563,1,'1332571469578','1332576420546','3BC549767CD51CA5D23CC030D24C6D26','127.0.0.1',1),(564,1,'1332589270281','1332593299500','5A38803D50E7AF32C95B710ED63658DB','127.0.0.1',1),(567,1,'1332595824484','1332595845109','F406DD2099F43A2A06ABD14B27E7FFA1','127.0.0.1',1),(569,1,'1332634987500','1332635220500','9E22BCA2C2F1BFC11D88DCAB2A581BE0','127.0.0.1',1),(570,1,'1332645204531','1332646249171','1F01A0F5CDFAD68E3498D97602B81441','127.0.0.1',1),(571,1,'1332768119109','1332768577125','E292C9802B50A05D00EFFE0BF5D3EB49','127.0.0.1',1),(573,1,'1333027894517','1333028041787','D1CF22A9FC88449EA8B27350C112E6A5','127.0.0.1',1),(574,1,'1333107617703','1333108486562','7C33DB04E24202E7577AFF42B25328A9','127.0.0.1',1),(575,1,'1333111412703','1333111784625','E88EEC005E9CBBA053CE6AEC19871BFC','127.0.0.1',1),(577,1,'1333114863875','1333114976687','F2AB62DB099DCC5D54A544AD18C383A2','127.0.0.1',1),(578,1,'1333114983875','1333115680656','5DDBA1CB215AFD8EFD63BDF48167E970','127.0.0.1',1),(579,1,'1333195157578','1333197120062','359115405867DF5B79BD9E409AF47C5A','127.0.0.1',1),(580,1,'1333197474437','1333202869968','DBE627EA92741CBF4BFCA54D60B4A8C1','127.0.0.1',1),(581,1,'1333332615953','1333333349046','6DA69D4BB19DE4FD74EB5653FF64E309','127.0.0.1',1),(582,1,'1333335585187','1333339694859','6887B4442885928772E6726E14BBF0F7','127.0.0.1',1),(584,1,'1333347713218','1333348674453','1DE8551E97E6CD62B8F66842B80B67B6','127.0.0.1',1),(585,1,'1333354206656','1333354291500','C882866BCE95A3AD6B7E0DB73AA334C2','127.0.0.1',1),(588,1,'1333362074093','1333362365015','E0F964BDBADA0E26C4FB208DE8BBAB83','127.0.0.1',1),(589,1,'1333362205328','1333363005875','BA124E65538C1EDF722BA758557A1071','127.0.0.1',1),(592,1,'1333368498578','1333368611937','253301D1B14F95F845125155229A6A80','127.0.0.1',1),(594,1,'1333372159703','1333372181171','24705FBD7FB68BB8FCE6C342340E95F8','127.0.0.1',1),(595,1,'1333372307781','1333373089578','BFC428548ED70E43A18229BC58619043','127.0.0.1',1),(599,1,'1333439761828','1333439770437','205159D4AEE94AEA73BB3AC94A536C5F','127.0.0.1',1),(600,1,'1333543661906','1333543791546','E4E320833DEE6C2A450A506F39C4EE70','127.0.0.1',1),(601,1,'1333886869843','1333888170468','F7F43761F237497C48F902C47AD7DD0B','127.0.0.1',1),(602,1,'1334063267500','1334063277453','FFAFE2EE603CE42B54C5426DCB7AA502','127.0.0.1',1),(603,1,'1334064857875','1334065241187','75D647DF2E1E5774A05048CB99EDB1C6','127.0.0.1',1),(604,1,'1334453383500','1334455672953','2D57FE09A5925C614DF54F445A2DA131','127.0.0.1',1),(607,1,'1334495811109','1334497001984','F1676AE70BAB1C67CF7B121073B64199','127.0.0.1',1),(608,1,'1334497018968','1334497031609','41644CD327F9B060BC3DFBE323A1E09A','127.0.0.1',1),(609,1,'1334833204828','1334834173265','D82DCBECB0983EC391AAA3368B652E95','127.0.0.1',1),(610,1,'1334837256656','1334837657468','018B8C41EBDF8466CBCC38FE1FAAFEFF','127.0.0.1',1),(611,1,'1334837709281','1334840156515','4EA51F0D8F443C0A403D63096CB36B18','127.0.0.1',1),(612,1,'1334841115687','1334842786031','DB39006BF0408672662815D26A6AAE5B','127.0.0.1',1),(613,1,'1335011210297','1335013477938','ED8EE238764D7934FB2E0077ADCD94E9','127.0.0.1',1),(617,0,'1335062107140','1335062465468','580767B70435A43B815F3227D58D2260',NULL,1),(618,0,'1335062501625','1335062501750','DD24CA8D5AC312F1FBF7C36E97E149A7',NULL,1),(619,0,'1335062520968','1335062521265','D7AC3D23AED6199F840E6C38C56EE65F',NULL,1),(620,0,'1335062680578',NULL,'9C4216753308B9F55C1FCA98B4D5228A',NULL,1),(621,0,'1335062680734',NULL,'63044310D57EF7FD3C7DF288F8373388',NULL,1),(622,0,'1335062802578','1335062802671','5D7C82E0E78D301EEFA1B59A65C690A2',NULL,1),(623,0,'1335062951343','1335062952484','803F5D01F0E6EA18127D5E3F9A09D620',NULL,1),(624,1,'1335064270984','1335064291453','F86D5FBFCD61855A8F09E3321AA8B309','127.0.0.1',1),(625,1,'1335064309921','1335065166937','A304F410E40BA1EAA2B72525F6612A1B','127.0.0.1',1),(626,1,'1335704648019','1335704793878','13BC65FFD19283AEDB6969B942B51B05','127.0.0.1',1),(628,0,'1336049520937',NULL,'108D1C162DF2FB09D8D4AD7EC2BAFEDC',NULL,1),(630,1,'1336134245093','1336134276515','57B0218C9E2F0FBEFD59D0A67517ACF1','127.0.0.1',1),(640,0,'1336140013468',NULL,'9B7814A354BF23DC2AA4F7807DD336BF',NULL,1),(642,0,'1336140194906',NULL,'803275D00ADB8DBFEE5FF678099BFE16',NULL,1),(646,3,'1336299738156','1336301036875','B1DF51D0A3B7706122E1EC393B90627D','127.0.0.1',1),(648,1,'1336312848714','1336313576120','6ACA6F7FAF4EBA055FAAEAB5D4714098','127.0.0.1',1),(652,3,'1336342640312','1336342650171','AC5550790066CB3DD813CFCA5648228D','127.0.0.1',1),(657,1,'1336343734843','1336343739796','770A458270B09224D3804E57FD3DB583','127.0.0.1',1),(660,0,'1336395701359',NULL,'3D7C00662B1D636D649A2EF80F8F8E41',NULL,1),(661,1,'1336395702109','1336397188140','A06F243F849AF9F683A734F55A12F7C2','127.0.0.1',1),(670,1,'1336482462437','1336482466921','C8C58B2394E2BB97D0A2C2A8121B7817','127.0.0.1',1),(671,1,'1336483931500',NULL,'79244C5AB562BE9DB43AD5F3F0901F16','127.0.0.1',1),(673,1,'1336484065140','1336484071953','CC86261B4487CDD2F124F93FE7B2FE74','127.0.0.1',1),(674,1,'1336484352421',NULL,'E79D75C12CA7EAB07715364D1853B116','127.0.0.1',1),(675,1,'1336515413687',NULL,'F835B1355A5004E4C518D3F1D34EAE26','127.0.0.1',1),(677,1,'1336515705625','1336515710359','5F85F10049391C456DCC0B45CDB3B0B6','127.0.0.1',1),(678,1,'1336565517250','1336568895343','84E0E03B61A3F11044DC990E4D73D729','127.0.0.1',1),(684,1,'1336653115953','1336653643078','588CABB40AB53994256161522A7C04DE','127.0.0.1',1),(685,1,'1336653162812','1336656229000','A17B0B88989CF26BB51221E2BE87FB6A','127.0.0.1',1),(689,1,'1336735815140','1336744210203','84BE904CFECEFB648AB0FC7418F8AFF7','127.0.0.1',1),(691,1,'1336785909390','1336785974640','2E9EAA346B3B72AAB09E99ED1F07903A','127.0.0.1',1),(692,1,'1336913606296','1336913851062','5131B02DD5AF065DDAD86626A6A64975','127.0.0.1',1),(694,0,'1337518257046',NULL,'5C4F6A3DFA5B0C29B54F4E8860627A91',NULL,1),(695,1,'1337518257031','1337518377531','F958897F5579C2D7F01D74F0B58A7DAF','127.0.0.1',1),(696,1,'1337518316968','1337521647240','9E57F37B7C57BEAEFB889343A17FAD97','127.0.0.1',1),(697,1,'1337605336687','1337605585890','492DC5458FA1D0A11B5C58858B715286','127.0.0.1',1),(698,1,'1337605698625','1337606348906','EC7D7504C2B5A28773893EFAD4761B12','127.0.0.1',1),(699,1,'1337606518031','1337607037656','145E9B18642811AA2963FBCEBE5300AA','127.0.0.1',1),(700,1,'1337689399828','1337689847390','6B4B94F32B1E94E75E2E792574A4591E','127.0.0.1',1),(702,1,'1338623987593','1338629376390','AFC46339D762FDB2513772E55C641617','127.0.0.1',1),(712,0,'1339115980656',NULL,'C15FF2FBA4404837934FB5C04DC088DD',NULL,1),(723,1,'1339854638515','1339854843671','9BACF49EF4D341CD1F6B065B90213DEB','127.0.0.1',1),(726,1,'1340886909343','1340889334453','00D3A4013051DD844A50DB7E9BF53CF2','127.0.0.1',1),(727,1,'1340889436093','1340889620140','B137E1771A1C13B4192D73495F9F1F07','127.0.0.1',1),(728,0,'1341145193250','1341145805359','1CE3DCC0B112825116C6DFC9F01496CE',NULL,1),(731,1,'1341150096890','1341150604171','C9D2081B71720E855B7A5E9B3FAD3823','127.0.0.1',1),(732,1,'1344431409029','1344431879406','B8825BE57749E40A3EEB7B9555FFDAB5','127.0.0.1',1),(735,1,'1344603604890','1344604594718','010B1CED39468F45DB79FAA1CD3054E2','127.0.0.1',1),(736,1,'1344605213750',NULL,'56F161A68A62DB99BBFE35A3AE70FA5E','127.0.0.1',1),(739,1,'1345119527140','1345119551312','307577EDD612FD55CD5B52FEF375CF85','127.0.0.1',1),(740,1,'1345119565890','1345120988968','FD234857FBD541760E50CA018D8211A4','127.0.0.1',1),(741,1,'1345637399531','1345637823968','515E34CED488A56D499E95F580CDFDBF','127.0.0.1',1),(742,8,'1345637494859','1345637509578','9D59E3218E1F3C09EE9212025AD9D39A','127.0.0.1',1),(745,1,'1345637975171','1345638159453','A84B807B76F0DD5CE73985691670C0CA','127.0.0.1',1),(748,1,'1345643350953','1345643422781','203318CC02EDD763060AA11B4578AB9D','127.0.0.1',1),(749,1,'1345729257093','1345729275484','84A06BC6400910A677F8948D99A9C776','127.0.0.1',1),(750,1,'1346240364171','1346246931000','17EA511E7710CF3499A02FB9E0E18E7E','127.0.0.1',1),(751,1,'1348728758843','1348728786250','BA4F0923C09916BBF1822E7B8810AB42','127.0.0.1',1),(752,1,'1348729236312','1348729310578','61F53DB9015C926828CBF6AA69656515','127.0.0.1',1),(753,1,'1349335115656','1349336960125','D3F49A08159F5B747AA43C261E0E64D2','127.0.0.1',1),(754,1,'1349608710600','1349609924584','36FE50AD408E5AACC825003076659F48','127.0.0.1',1),(757,1,'1349612422459','1349612452475','5967F3BFC7D1FA5EB423A5839445AEC3','127.0.0.1',1),(758,0,'1349870892578','1349872068140','08F8F56AC0E916A23063342B47973562',NULL,1),(760,0,'1349872701921',NULL,'B1D805BAD512FE780E0A22A5450DA293',NULL,1),(761,1,'1349872701953','1349872742484','85B5449D25085286CA9F0B7C03379551','127.0.0.1',1),(762,1,'1349872728156','1349873228515','4DAA829969D964B729DC0BD652EDFC39','127.0.0.1',1),(763,0,'1349873426984',NULL,'4DEA944A988C818E47B069E73390CB69',NULL,1),(765,1,'1349874211640','1349877362437','CD81DE17C2CD99FD65C3136B365D69DA','127.0.0.1',1),(766,1,'1349877690187','1349879490296','6FAD8E673FD578ABA64952118586313A','127.0.0.1',1),(768,0,'1349920161671',NULL,'9B6E328CDFCF80A6E51733D892CCD92F',NULL,1),(773,8,'1350045443234','1350046148828','070D85E7F9D0644022D5A1D401E3E1E9','127.0.0.1',1),(774,1,'1350129477093','1350130445453','9006D69D83F6D9141C8B508E7A062223','127.0.0.1',1),(775,1,'1350183450812','1350190557000','31C826D217D26F03102BABE239205F31','127.0.0.1',1),(777,1,'1350478584125','1350481044312','AA8DEAD0D1928734535EE0B1B43474B0','127.0.0.1',1),(783,1,'1350653201765','1350653301312','5A4A29A57687DACECAD385A0FF5DDD8A','127.0.0.1',1),(786,1,'1350654452078','1350654464343','E42373EEA6CF4B44E6CFA16733A1D62C','127.0.0.1',1),(805,1,'1350705329796','1350705720812','8B2F5FF7CAC655C2AE07ED5F2FA68A35','127.0.0.1',1),(808,1,'1350711306562','1350711752359','2598081A91887D4DC90363526FEB09DC','127.0.0.1',1),(809,1,'1350725717281','1350727006062','4ABCA40A9B86B4D57EF427C255AC4760','127.0.0.1',1),(814,1,'1350735818796','1350739982531','B23C56D9880D00D24FBA32027DA00A03','127.0.0.1',1),(820,1,'1350827689968','1350828414812','892759C3335AB76C1F941B8E37D05C1B','127.0.0.1',1),(821,1,'1350907967812','1350910919890','6CC62825D36B0C0D1BED70DA63B0AE52','127.0.0.1',1),(822,1,'1351423382468','1351424230406','0EE69EB0AEB4DC9B6F872455F4A3A1C6','127.0.0.1',1),(826,1,'1351773101640','1351773130953','EC9AA2CFDC3188B2F0C7B40FFBEA337D','127.0.0.1',1),(827,1,'1352116262187','1352117437437','DB1B30F851033D828A30C24677BC0E70','127.0.0.1',1),(828,1,'1352117547156','1352120966859','226ACE9F888CAD15122C325F739DE629','127.0.0.1',1),(829,1,'1352122002718','1352122642453','16DABD39A796752CF0E16B3281853654','127.0.0.1',1),(831,1,'1352206191316','1352206390003','6403102A2A73931003078DE33EA6EF15','127.0.0.1',1),(832,1,'1352206267503','1352210184847','CC1318E017523FD15F790F3F4F0AB8BB','127.0.0.1',1),(833,1,'1352291725234','1352295614781','90696C4043272A430BEF7C7C963FB2F4','127.0.0.1',1),(834,1,'1352641066500','1352641752781','720358914EF2448AEF8B74246D2CE8D6','127.0.0.1',1),(835,1,'1352725766796','1352727186078','87708DE730AFCDC3CB066E9620E1520E','127.0.0.1',1),(836,1,'1352809992671','1352813796139','DF6D5CCBF59AF5894C25B6ACD43E9B34','127.0.0.1',1),(837,1,'1353322466875','1353325264218','6F1E1A40EC5C40FEECC71447CF4CA39E','127.0.0.1',1),(839,0,'1353409347906',NULL,'B728ABF6B85B18C3A49A93811D943DE5',NULL,1),(840,1,'1353409347953','1353409454234','B687BD6B9C6DF1D829A7E721D34AB0FF','127.0.0.1',1),(841,1,'1353409473265','1353409486937','B03A2090C43E7FDEC983A1478275037F','127.0.0.1',1),(843,1,'1353409583312','1353410444828','CCB0B346626CDD86A9860BECB9065960','127.0.0.1',1),(844,1,'1353410475843','1353411807156','56002CF9B3001AC2A3029B9C12F75F86','127.0.0.1',1),(847,1,'1353412314609','1353416057876','E53A216A376089BF7FB65BEDC0F25845','127.0.0.1',1),(848,1,'1353496901703','1353501480046','5C83D785F53F4C31DF4E5E1FBD4F0BAA','127.0.0.1',1),(849,0,'1353583981234','1353585722281','E466C20A96ADFFAF6E8A0F864D1C1E6C',NULL,1),(850,1,'1364372233091','1364373637852','103291F9C6835684904B984A84158864','123.234.34.234',1),(851,0,'1364454430314',NULL,'C6825F6EDCE55662E0A5771FA98E3C92',NULL,1),(852,0,'1364518818620',NULL,'6CD980B0E42D0EA647690B9B995A116C',NULL,1),(853,1,'1364523132725','1364525309229','F9C9BB5C67E87573D90FE0C342936108','123.234.34.234',1),(854,1,'1364900065172','1364901722520','E3C2C3868BAF72604DF43DC2D248BF20','124.129.66.129',1),(855,0,'1364905231024',NULL,'0F74B7767322DC5714D38A8F6636EF98',NULL,1),(856,1,'1364905230993','1364905594030','5182176853CB6B821B88247683F7382A','124.129.66.129',1),(857,1,'1364905958818','1364907492075','A6E3C1F4219059ED28116F867879DCD2','124.129.66.129',1),(858,0,'1364907633119',NULL,'D37AE4F27EA44CACC17F571BC0DAFF4B',NULL,1),(859,1,'1364907633462','1364907769287','E6D88CAF9DE8F3E77254BD88C7DFA420','124.129.66.129',1),(860,0,'1364907939939',NULL,'D8AE46F6312DA3072F50F68F6757C7A3',NULL,1),(861,1,'1364907939673','1364909160658','B64538387E70A37F95FC09C51E8D694A','124.129.66.129',1),(862,1,'1364909271920','1364910199303','E138323B7C6D67161C00ECA614C50D6D','124.129.66.129',1),(863,1,'1364948933149','1364951661102','60B2B84487677975A33A4F5562D930C7','123.234.34.234',1),(865,1,'1365428004159','1365429277986','DE56BFC3CC0053E6511DB7FDAE58AE05','123.234.34.234',1),(866,1,'1365474706333','1365476036374','EBC0ADDF0358DC6FA72BE155A5AF4A4D','123.234.34.234',1),(868,1,'1365514279708','1365514351175','FD84E6FCF0BDF4B89E0AF322DC56EDB5','27.193.85.226',1),(869,1,'1365514375846','1365514772352','473931D9F874B9834311407F3C8B2A77','27.193.85.226',1),(870,1,'1365514303832','1365515113046','873B9C4476EE5D70C256AAAB8862B278','27.193.85.226',1),(871,0,'1365595893295',NULL,'2106AD7DAB29CDD5EA0050B6FC4B7625',NULL,1),(872,1,'1365596683806','1365598360748','C038C30EA263DAB8601EA7B334EF101A','27.193.85.226',1),(873,1,'1365599206570','1365600605565','3BED209BAFF707B4950E4D31C4203032','27.193.85.226',1),(874,0,'1365638684236',NULL,'3D118FB95ABC6139B15A22D63965CCA1',NULL,1),(875,1,'1365638684221','1365638713282','5C1E5D6F7D2BD0EB14E3CAAE9FF74D47','123.234.34.234',1),(876,1,'1365638737812','1365640328918','697D474D5CACD055DE8A3B6B90E9194C','123.234.34.234',1),(877,0,'1365640422210',NULL,'3259E0E879F6D5576F6653AC29CF6028',NULL,1),(878,1,'1365640422053','1365640760052','9DFD7F65FF5B12211918E020907EE52C','123.234.34.234',1),(879,0,'1365640853625',NULL,'75D66EBD2952233A6F31915C40E574AE',NULL,1),(880,1,'1365640853375',NULL,'A17347D37613FFB7D6F587DA6574459F','123.234.34.234',1),(881,1,'1365640916434','1365642516190','E7DFAB443BCB4DD1106200236AFF6377','123.234.34.234',1),(882,1,'1365642588157','1365643275213','5E3F72CCBA0269838F55E18CEC57DA1D','123.234.34.234',1),(883,0,'1365643506658',NULL,'EE3AF2699B9235B325139F4537120263',NULL,1),(884,1,'1365643506627',NULL,'F3B0978940407C163FFB19A661EEE728','123.234.34.234',1),(885,0,'1365643685700',NULL,'A6B991E8DA738BACC791607F6C385491',NULL,1),(886,1,'1365643685653',NULL,'4D541EBA0A3670340D2F1CF5196C61AB','123.234.34.234',1),(887,0,'1365643794149',NULL,'0D1C5C4533F6D5DD47B561908AEF768F',NULL,1),(888,1,'1365643794102','1365643838148','C1A77228A38C4AED70ECCD5305BFC73A','123.234.34.234',1),(889,0,'1365643926754',NULL,'FCAA02EAE55CED256BB63662713EA338',NULL,1),(890,1,'1365643926739','1365643999065','6108AB9A492C8B69444E460701D2552D','123.234.34.234',1),(891,1,'1365644089202','1365645983001','D58E28D834E2B4140DF2DEBC02CFC37F','123.234.34.234',1),(892,0,'1365646065045',NULL,'8F69C5F7A43CFEB47931231E89C815F1',NULL,1),(893,1,'1365646065061',NULL,'E1FDE3620D97F98C4654C755EAA5DBFC','123.234.34.234',1),(894,1,'1365648334379','1365650650538','8C9D47810A2E15E4E4FEC90B384F384A','123.234.34.234',1),(895,0,'1365650735426',NULL,'C84573CD622A4DAF2FEC01E258849D50',NULL,1),(896,1,'1365650735239','1365651364613','AB960EA53A1AD87898D15080006BF660','123.234.34.234',1),(897,0,'1365651580436',NULL,'2C21618BD4931E8B8AE87B1E7C1CE013',NULL,1),(898,1,'1365651580420','1365651665731','90195B5DB82D4578F7C51E12866BF7F9','123.234.34.234',1),(899,0,'1365651713417',NULL,'B93AD1FED8AB8CE0FFA12F3DBF416EB3',NULL,1),(900,1,'1365651713276','1365652663940','9E04F618CA35B8CE5A8B9AF32ED209C9','123.234.34.234',1),(901,1,'1365681941809','1365686698672','26A3EB1C6F87F4518B736BCCEFB0C4FC','27.193.134.227',1),(902,1,'1365768126904','1365772052467','BB117F3418E1D270B11BF06E766E5B17','27.193.134.227',1),(903,1,'1365856364925','1365857088078','A28038A09E14CB001193886F924D966A','27.193.134.227',1),(904,0,'1366087580356',NULL,'24FB77001A1BC10325225ED95E86B0E9',NULL,1),(905,1,'1366087580356','1366102014204','FE365A8AD2CD1D74E835D20783B1F268','123.234.34.234',1),(906,1,'1366102042562','1366102391892','E08DC874FBA2D729CC7B0D4A211A23E1','123.234.34.234',1),(912,1,'1366120218515','1366120706049','13D2A882446A94174F7829EA63EA84F2','125.40.178.40',1),(913,0,'1366121090383',NULL,'C0A4795F6DEEB2BF29DC944E91828E9D',NULL,1),(914,0,'1366121090680',NULL,'75920EF7A0F01FE72C58657C07EA6A61',NULL,1),(915,0,'1366163001830',NULL,'DE7823EA04B28BA56B2FEE77B7704B38',NULL,1),(916,1,'1366163001815','1366165078318','80E4F20A0B70B4EC78D767C23C35E53F','123.234.34.234',1),(917,1,'1366190425471','1366190813118','C7106F831F234BAE0C9DD543B26D777A','123.234.34.234',1),(918,1,'1366200058363','1366200895649','268284FE2C3052EA4F1DE7E1FB13CFD4','27.193.132.126',1),(919,1,'1366201163734','1366205788408','4301E172CB7E896BA36D4954D75B2B99','27.193.132.126',1),(920,0,'1366243279333',NULL,'4A33942607BC041A26D494C31D695C2F',NULL,1),(921,1,'1366243279364','1366243825960','05CF49AF3D2500CCD210A39992E76CE8','123.234.34.234',1),(922,1,'1366243877083','1366244550160','71093CA70BCB221A259EFB102B5F05FA','123.234.34.234',1),(923,0,'1366261521504',NULL,'B733DB1FD9A82426D42312156C20DF68',NULL,1),(924,1,'1366261521488','1366263390283','4A7D39C552613739720ECB55FB2C284F','123.234.34.234',1),(925,1,'1366282900133','1366284338862','2A527CF257C392FCC834B49EC131BE0B','112.226.124.128',1),(926,1,'1366375279392','1366377943495','C881407A86F576F822D1CAD0C31123BB','112.226.124.128',1),(927,1,'1366446813877','1366446957904','A00FA4FD5CD9453DBAB8945109A79CB9','123.234.34.234',1),(928,0,'1366621068837',NULL,'03A3D2EB26006101C7124087CE2AFCA6',NULL,1),(929,0,'1366633810125',NULL,'6B2102A9BAABE5AD4EFBB833D53F3BEB',NULL,1),(930,0,'1366676191933',NULL,'05EDB1A27E65CAAC6A7149CB6B57E1C8',NULL,1),(931,0,'1366689895059',NULL,'4893D21DFB3F78D26B1FE9F740ADF849',NULL,1),(932,1,'1366689895075','1366691852231','AFE602CCA7D7DBD9F6098FAC7EDAEE24','123.234.34.234',1),(933,0,'1367029957009',NULL,'A4A002ECA0B0AEF17C0CCE2037693E1B',NULL,1),(936,0,'1367030148708',NULL,'B3D587D87ABD66B77F555526BFD12DDD',NULL,1),(937,0,'1367030624008',NULL,'253749DE6A85F006E9A474E4A3441D93',NULL,1),(939,0,'1367031236680',NULL,'01FBEBFEDAE96ABF0D6EBFEDDDC08C9B',NULL,1),(940,0,'1367031877163',NULL,'CD5A58EFB4F7008B46BF5F5933982571',NULL,1),(941,0,'1367031976567',NULL,'6DD0B0DFEAD092D322200D14F6B87D94',NULL,1),(942,0,'1367031992270',NULL,'3DF78D829BEC1700D3B836D66649710A',NULL,1),(943,0,'1367032171718',NULL,'45623EA55474CBF8CB6C440C76079C58',NULL,1),(944,0,'1367039654106',NULL,'880987FBF23341A1D2BEF743A41EDC5A',NULL,1),(945,0,'1367048254878',NULL,'9BF3E8CDDF017AA0D8C1AF18B147F265',NULL,1),(946,0,'1367048462890',NULL,'AF6E0B2C22E9B997E4DAFADC5D3BA6BB',NULL,1),(947,0,'1367067411290',NULL,'DCCF5405CA184A7D6100D9B6FDB932D3',NULL,1),(948,0,'1367067417165',NULL,'531445FF91DD757846B9BC66266BA4BA',NULL,1),(949,0,'1367067501960',NULL,'C6257C506E3DE91E38DC736772316E21',NULL,1),(950,1,'1367067530569','1367067716361','5C70E1BCDE16E76C05E481D688E8B396','110.212.123.122',1),(951,0,'1367070244026',NULL,'B100D21B8230270D2B168836D37753C0',NULL,1),(952,0,'1367073458401',NULL,'E6BB6A342E20C5E86327086F13FA92A4',NULL,1),(953,0,'1367074248543',NULL,'6F84DA9D3B486FADEB52BC3BAC57141C',NULL,1),(954,0,'1367075099026',NULL,'8FAE90602327B01DBE35D9A364E14BAD',NULL,1),(955,0,'1367108716871',NULL,'29B08F2AD2FE14435CC0DA252F9EE1BB',NULL,1),(956,0,'1367110183655',NULL,'888E53A803AB8742D8197D501AFE5C25',NULL,1),(957,1,'1367111240025','1367111401913','95CCF4C48E5BDC00AAAE1F05B1C3E4D4','218.249.118.238',1),(958,0,'1367111743813',NULL,'CB1973D7BE1D78FBC435B46755CE39F6',NULL,1),(959,0,'1367117491390','1367117882242','A4C32AF41CC06D649D536D467D89B6A0',NULL,1),(961,1,'1367119414853','1367119452258','9C1508C12D896C52CE9AB6EA66F57B33','218.80.213.49',1),(962,1,'1367130108600','1367132484743','80B4BE72C94B56DB3C203B7FE242C7A1','123.234.34.234',1),(963,0,'1367143801999','1367143801999','57A3F6D29878ABAF0DEA03FDD312BA47',NULL,1),(964,0,'1367143802249',NULL,'4967079A1F21D9C9B828BABBC08CFEA7',NULL,1),(965,0,'1367145601356',NULL,'77C2A76D613B62E98D4DABE5E1E16879',NULL,1),(966,0,'1367198763679',NULL,'B31111F1CAC99E711756600C64B24FDD',NULL,1),(967,0,'1367485619184',NULL,'7D1EAD4E7A00830ADC2F2E114B1D744A',NULL,1),(968,0,'1367545500709',NULL,'EC54CC25C601E5B635DDA3816A1B835F',NULL,1),(969,0,'1367741066721',NULL,'1D986DA275A58B200B200908EEACA7D4',NULL,1),(970,1,'1367804319669','1367804416776','ABFE98796D879A71C84EEF9B9C9F75FC','218.249.118.238',1),(971,0,'1367859418330',NULL,'8E69322C7D0A0BBA7CDC3A7B77FF8B68',NULL,1),(972,0,'1367905274933',NULL,'D3F0117D0A158301D63C05F636F7E20D',NULL,1),(973,0,'1368501074456',NULL,'4CBB49CDC08F2301CCCCF22B230FE8B0',NULL,1),(974,1,'1368665849013','1368666217659','43A2AD010F7F2554799F0339EE0486AB','222.26.20.107',1),(975,0,'1368667650045',NULL,'AF4E1495935FC1BBA23AB0A6559F185A',NULL,1),(976,0,'1368667652388',NULL,'B798392E19D9CF64DC8328316AE91DFA',NULL,1),(977,0,'1368667653685',NULL,'EBB2A895010BDEB27501448E3108E871',NULL,1),(978,0,'1368668003035',NULL,'84759C9F5FD4E1EA8CB93BDB803030A4',NULL,1),(979,0,'1368668012988',NULL,'D865031409B66C5E8A602E3A47E624B1',NULL,1),(980,0,'1368668017316','1368668017316','6A5F71BAED905441D646E4BBC2564BED',NULL,1),(981,1,'1368671383902','1368675928973','B5C7F083EB8E790172237BB2BC291D10','111.127.36.172',1),(983,0,'1368690566756',NULL,'F0994305951BE314F3CD48F0B9C31E38',NULL,1),(986,0,'1368693359997',NULL,'81B28392DEA15B0A6A392FEBF0948157',NULL,1),(987,1,'1368693390122',NULL,'8E01A18E87A70520E74085249D2BB99B','202.108.100.231',1),(988,1,'1368693721879','1368693896671','B58EA6B427406DF8AEB9F496A4A99D93','125.69.150.90',1),(991,0,'1368694836272',NULL,'9CD42D0946E5FA810C8AEDB0DE08224D',NULL,1),(992,1,'1368694897270','1368695014017','5F6032834BC795B82DF7BBDA54CC6570','202.108.100.231',1),(993,1,'1368696240439','1368696313578','54C0B7C620A2D5C8A887C576E4A49298','218.205.154.74',1),(994,0,'1368696381436',NULL,'714498943536FD76E152AE7C16236D31',NULL,1),(995,1,'1368696433153','1368696463777','FEEC8AE6DF3987687574864AE8FD16CC','119.57.163.34',1),(996,0,'1368749529808',NULL,'8000988FCFB546CC976C17497367E4CF',NULL,1),(997,1,'1368800505205','1368801973964','20D8032DD5631867A7DCC079DB353FE0','218.29.60.105',1),(998,0,'1368802442733',NULL,'45FB0D32F285AAB24FD527D890FFCF51',NULL,1),(999,0,'1368802577667',NULL,'1514AF0A2F08074E956B41F1DF40D25C',NULL,1),(1000,0,'1368803773559',NULL,'B337E280D356779F202FA230DA422C62',NULL,1),(1001,1,'1368845018153','1368892746693','044E675653A6029C97217B6192E91868','220.200.56.156',1),(1002,1,'1369018217441','1369018394046','D61E7837607EAC54592BDE91EFAFDDC6','219.147.61.11',1),(1003,1,'1369031772938','1369031962698','61C7E979D7DA17F12B26B07386F06089','119.191.55.180',1),(1004,0,'1369033040093',NULL,'F58AE2BC6D5A9574D9A4C4B29AD1717B',NULL,1),(1006,0,'1369035398063',NULL,'685273448FABB7069CDA821887665D97',NULL,1),(1007,0,'1369036958204',NULL,'9AC96E6C856651AD4C7A7F930B139785',NULL,1),(1008,0,'1369096878204',NULL,'D904E96629381BF3FB299DFBCAE0EDE7',NULL,1),(1009,0,'1369096915656',NULL,'29B0C40048735B6EC751061A84B0F78D',NULL,1),(1010,0,'1369100274586',NULL,'25AB52ADB9C40D7D46E02515BE4F1A84',NULL,1),(1011,1,'1369100593343','1369100852805','99D2D7602A4252DE596D1D3C18F3BA6B','219.147.61.11',1),(1012,0,'1369100751355',NULL,'91F89A1E334246A369A1E03305A88472',NULL,1),(1014,0,'1369125216777',NULL,'731181745CC99979BCE02694FB4B3307',NULL,1),(1016,0,'1369127433267',NULL,'A2BB088B5C8EA889BC888F6A9B16531D',NULL,1),(1017,1,'1369127518437','1369127598482','C3763AEDC7E0B7EB493FEBBA4CFE1DC1','218.80.213.49',1),(1018,0,'1369129485199',NULL,'BE86F1973A1107AEE84D658A215C4194',NULL,1),(1019,0,'1369129805206',NULL,'C40B7B230FC00EEDCA12ADA389DF53F2',NULL,1),(1022,0,'1369205990795',NULL,'EEA99F57DFA2B6E7653532964DD12820',NULL,1),(1023,0,'1369207563761',NULL,'02A722C787CA5845194C696ED6C23C72',NULL,1),(1024,0,'1369207579354',NULL,'CCFB0478CCD6B4E31A33EEA2E5163F63',NULL,1),(1025,0,'1369207582510',NULL,'55147BC832411719475015FE844DBD7E',NULL,1),(1026,0,'1369207584432',NULL,'94A205B990A520F802FFC82E934E78AF',NULL,1),(1027,0,'1369207587135',NULL,'A8D9CF79666F275259DFAF8329EF34F1',NULL,1),(1028,0,'1369207587572',NULL,'6730F97BAD13BDEA142AECE7CBD145C4',NULL,1),(1029,0,'1369207588354',NULL,'1B94FE56E454B58816A761FF61B166F2',NULL,1),(1030,0,'1369207589088',NULL,'483B1FF5BB0CDC78AB42704BB94475B0',NULL,1),(1031,0,'1369207593494',NULL,'085696D35F53148A1DFDF8AC0D8A61B0',NULL,1),(1032,0,'1369207594369',NULL,'41A4EE3CCEB333E500D8190100149BA9',NULL,1),(1033,0,'1369207596135',NULL,'6A24D3D6EA3B640577383996E157ED7B',NULL,1),(1034,0,'1369207598166',NULL,'2C2902EC20EADB445AAF9A214C8E4648',NULL,1),(1035,0,'1369207607572',NULL,'495AF5E8825B83CE978CD20306039B2A',NULL,1),(1036,0,'1369207616415',NULL,'207FE1C4477EBA1994A898597ECE5F0C',NULL,1),(1037,0,'1369207622493',NULL,'6ADD1A7C512E91EE6DD33D52B05718E2',NULL,1),(1038,0,'1369207633383','1369207633383','3321EE334FB9C05F57D183CE6C4FB6CB',NULL,1),(1039,0,'1369207638633',NULL,'9FD58DF960734DF9C829E5B2037E3A92',NULL,1),(1040,0,'1369207651336',NULL,'7AE867F3EF423752B5FC5364B9DED023',NULL,1),(1041,0,'1369207661382',NULL,'87062B7167B4F384825066B54DE447C3',NULL,1),(1042,0,'1369207676226',NULL,'197FAB6509A7183F748CD949E00274F8',NULL,1),(1043,0,'1369207692616',NULL,'6148CBAF6EB9AE097EE137241EF9EFDC',NULL,1),(1044,0,'1369207696303',NULL,'8F40D24206BC8D45A45885779488CA26',NULL,1),(1045,0,'1369207699053',NULL,'B91279B0A5425559CF4270CDE8DB4214',NULL,1),(1046,0,'1369207834566',NULL,'2ACC399426D22CBEEFAB1AC2FD76CAE3',NULL,1),(1047,1,'1369208299116','1369224847567','21E26D96ADC10F03DC106E91115234FE','60.10.64.58',1),(1048,0,'1369224914503',NULL,'D14E601D2D20E6DA2E05F96B48A57AB2',NULL,1),(1049,0,'1369225471786',NULL,'AE564A8B644F48CB99882839D8D89DA1',NULL,1),(1052,0,'1369230020107',NULL,'98560F9A8DD6C347A3D2D85938886710',NULL,1),(1053,1,'1369230069184','1369230149979','6AC148D5CCCA47699DD08CFB15DADC99','112.64.223.84',1),(1055,10,'1369270620502','1369270716030','00440411385D531FA1BDAE27EEAA710F','222.222.23.108',1),(1056,0,'1369277523183',NULL,'777ED81581CA41F76075B5563040A967',NULL,1),(1058,1,'1369277536777','1369277639040','4E01380773E3DC7E7D0165BDA9575000','106.120.73.191',1),(1062,1,'1369278070435','1369278843822','C3468E3C742F00A799E30D6AD8E29FA7','124.205.51.194',1),(1063,0,'1369279331559',NULL,'3F58C8BDCAC495F013A3535D06CAEBF7',NULL,1),(1064,0,'1369279707018',NULL,'44EE78D5CBC5EFEFBBBFCFD44AC866ED',NULL,1),(1065,0,'1369280411297',NULL,'635E4110B99E183EC6D2E1A30ABF2042',NULL,1),(1067,1,'1369298564239','1369301185187','835705406B5F20D8F7E285D962FB26A5','124.205.51.194',1),(1069,1,'1369377565784','1369377782638','B260884A19AF1DEFB5D0DB2B89FBD911','218.26.31.114',1),(1070,1,'1369573378797','1369574267962','162D00084D251DD27E6C1DBF38F41E47','120.194.22.72',1),(1071,1,'1369575418526','1369575552835','0F301B729F105D0A42F1BA7036A9D9AE','116.205.14.101',1),(1072,1,'1369610830574','1369610916713','44FA73BF8EB7393489733A60111A26BE','120.194.22.72',1),(1073,1,'1369619409527','1369619426667','59B4BA8B0CF0915815F0831A27B95037','183.129.218.226',1),(1074,1,'1369625175691','1369625399358','4D884D7258C560B0D8ED38698EE395EC','111.73.201.146',1),(1077,1,'1369637456871','1369637586446','E3CC6B4AEDB205758AD95743F5BBE395','175.18.189.126',1),(1078,0,'1369638744744',NULL,'4C469BEC8A905624A0ADF3027A5085D8',NULL,1),(1079,0,'1369639027784',NULL,'2AD9857DF9DF5BF9023631AA6ED410E6',NULL,1),(1080,0,'1369639228716',NULL,'6F3BF13E9180656F2848A34B5AEED2A3',NULL,1),(1081,0,'1369639231451',NULL,'2248123D22232E5BD35E93292ABC3D2A',NULL,1),(1082,0,'1369639234044',NULL,'6C8C5A1E92BB9EC757E307277106991F',NULL,1),(1083,0,'1369639238310',NULL,'D5DD11F6365F948AB3A9FB23E350A251',NULL,1),(1084,0,'1369639239466',NULL,'CEA0942CD2FE2E2E0CCE0EA8D1DFA864',NULL,1),(1085,0,'1369639240685',NULL,'3271F952507DA840685AE177CF05D2AA',NULL,1),(1086,0,'1369639494475',NULL,'CEEB89CE570B8E717E48A91637061FB9',NULL,1),(1087,1,'1369721144935','1369721167981','A75F6AE32F4BFEC4816D6A352B3C7C60','223.198.9.192',1),(1089,1,'1369722091661','1369722218048','17DB8A4C4C137DB87EAA6E490312E961','113.79.141.104',1),(1092,1,'1369726784017','1369727145032','C858335E93911B81D3C3C7D243A67DA8','58.215.28.226',1),(1094,1,'1369728960662','1369735511124','FCBFF661E86D0E17723F4A33231968EF','110.184.166.4',1),(1095,1,'1369738658418','1369738712667','54C973FBC469873D901A00010DC98F6E','124.117.239.164',1),(1096,1,'1369742428494','1369759227171','BB150AF129943A117A482B926E3C4638','110.184.166.4',1),(1097,1,'1369799617941','1369799653190','0F9FC216901CDF0DBFD802BCF84826E4','118.116.60.250',1),(1098,8,'1369812917685','1369813435547','B0B8940B6FA89780BE6ADB8CBB0187FF','118.116.60.250',1),(1100,0,'1369813740836',NULL,'1367992FAE2ABF35A7496252C0AAE15B',NULL,1),(1101,1,'1369814591033','1369814875900','1AB361A38D5E15D776E53855843AD9A3','58.247.6.101',1),(1105,1,'1369814899181','1369815155487','0087715F6C043DADB5EBB327ADE10F3F','118.116.60.250',1),(1106,0,'1369819171853',NULL,'A643A7EC2F611BB9BDADE259CA152FA1',NULL,1),(1107,1,'1369827527502','1369837995732','5440CA30EC2C8C5F993362305EAF4345','118.116.60.250',1),(1108,0,'1369871837992',NULL,'C23E6473800219EA6D2B07CCADDBB3DB',NULL,1),(1109,1,'1369880970314','1369882430636','9267B90CE60A6244DC117AF6E00A835D','118.116.59.97',1),(1110,0,'1369889174785',NULL,'9E630BFFCF0BE2AFCB5000973AC0216C',NULL,1),(1112,1,'1369894332754','1369894793202','C2B29B98933293AB584A496495BCF777','118.116.59.97',1),(1114,0,'1369902976912',NULL,'FABDC5D021FA168703000EB750572461',NULL,1),(1115,1,'1369902989568','1369903421351','9370E4B0445BB1E2540BD8F2BA776E42','120.194.22.72',1),(1116,0,'1369909731665','1369910032376','FCBE202321393A163138A2835DACF483',NULL,1),(1118,1,'1369915247564','1369916097808','5A1FB877A58E67519C285A0C260B9BB3','27.210.108.76',1),(1119,0,'1369916262335',NULL,'75976B4F85826B927A07DDC4D01D6B70',NULL,1),(1120,0,'1369976163097',NULL,'2B2EF7B24CF9AE43D661E5F18854A663',NULL,1),(1122,1,'1369979938512','1369984083953','A3576CF064100CBB5CD62DD0681D5B55','113.64.201.191',1),(1123,0,'1369981547924',NULL,'9DF9CF7D3F266AAC84DBCE9E809D4E3B',NULL,1),(1124,0,'1369981616173',NULL,'2D2339C4A698D1C07FB067035E304EC1',NULL,1),(1125,0,'1369981626579',NULL,'A1E186B68A7A7B56F90F21AD0B7D63A3',NULL,1),(1126,0,'1369981667468',NULL,'0855EC1C1B9E4CABB3DD9FF163312770',NULL,1),(1127,1,'1370011445187','1370011628572','179D5EEA4F43DBE552994EAC9DB3CEE8','61.140.33.47',1),(1129,10,'1370220924205','1370221098326','0442B520C5F9E0440C460EFC02B7E02F','220.166.95.59',1),(1130,1,'1370222749456','1370222904530','B513D4EA4A3EE3773C9FEE416D26C3E8','218.249.118.238',1),(1131,1,'1370225208830','1370225765722','3B2BF79354CB75924D6238342D9F4E6D','182.138.160.169',1),(1132,1,'1370264156757','1370264272629','049E857E274D3AFD247797977D7FF9AE','114.86.222.111',1),(1133,1,'1370264439202','1370266082801','E207512F5E906681A0F53771F20204A7','112.226.125.172',1),(1134,0,'1370306616732',NULL,'B63F9A32442E71FF677E33F23D306D9E',NULL,1),(1136,1,'1370307563448','1370341562658','1CECFFB2D01892A15FCC1A77E6BDB06F','125.70.177.33',1),(1137,0,'1370324253886',NULL,'84B88F942B25E02954B2940A88CF13AD',NULL,1),(1141,1,'1370418931053','1370420260769','8D8DDBBD67F1F515A9B27A10E818C820','123.234.34.234',1),(1145,0,'1370422528945','1370424706358','2C4546F1C10847DD000857CCE359FC7D',NULL,1),(1147,10,'1370432302851','1370433880561','8AB4E612F9CFD5FE8F92D6385407B7FC','112.226.113.206',1),(1148,0,'1370480546510',NULL,'922A1DB2B10FCC0B10A81F392C48CBF5',NULL,1),(1149,1,'1370480563556','1370481865351','5941AC2EA17CEAE90E27E6D9565D4E1E','120.194.22.72',1),(1150,8,'1370525830579','1370526641949','D05DBAF1A32E70376A0DEE4A9D44C287','118.186.207.164',1),(1151,1,'1370528272548','1370528286907','9ED895750960627737F10CE401A87935','111.192.16.121',1),(1152,1,'1370576933883','1370577438308','147C0E662819980745B948D263EB9349','1.180.11.104',1),(1153,10,'1370587304087','1370587728170','4B786CDE09C521E2FCC16A1B5138803F','58.246.0.158',1),(1155,0,'1370587911806',NULL,'4DAFD105D5CB07B7160CE8EAC9C25A32',NULL,1),(1156,1,'1370592610279','1370599106689','D68C2C2FBEB1D21C51C28D2CDC001AF5','222.180.4.22',1),(1157,10,'1370594701788','1370595056154','5947CC8DCFACDA9C27FA46A739A88C15','221.181.34.212',1),(1159,10,'1370609231902','1370609240183','457F223EBE8CBE36476360E0393F14D4','27.193.135.25',1),(1160,0,'1370649558746',NULL,'4A105C12A0A4BA9CC5BF50C467B17724',NULL,1),(1162,1,'1370659281903','1370660667649','F0640993B872A095C5D72D1120269F7E','123.234.34.234',1),(1163,0,'1370660776381',NULL,'4D956D5D278C86E3ADC1444CEC184792',NULL,1),(1164,0,'1370660776381','1370661093498','9257A84AC41F70F206AD11212A01D6FC',NULL,1),(1165,1,'1370666460667','1370666469948','67FF4004BA0070612DD6A2800501FC6D','123.234.34.234',1),(1167,10,'1370667787161','1370668299363','1D26F45133633BBB660873400A8A8C46','123.234.34.234',1),(1169,10,'1370668839299','1370669093759','C4E20DA054E02632C1E37C80CAA41EDB','123.234.34.234',1),(1170,0,'1370669219474',NULL,'7F8E7B8AF3EF90D9094F136E8EBF481E',NULL,1),(1172,10,'1370669237864','1370669244583','FFB7EC3DD2BD652135B3EB72023FFCBE','123.234.34.234',1),(1173,10,'1370669365985','1370669837970','449844E1828B19E536D17865CA1477FD','123.234.34.234',1),(1174,0,'1370669915749',NULL,'4BF573ABF6D1DC1A2AADFB89662E44C5',NULL,1),(1175,10,'1370669915749','1370669927951','81CCCD87286A713B8471E925AA88AB4A','123.234.34.234',1),(1176,0,'1370670057088',NULL,'0FAEB45AB4265696C789C2D832A38E66',NULL,1),(1178,10,'1370670348141','1370675424922','90F67A4EF8CAD8A9C0D9F3508B84AB50','123.234.34.234',1),(1179,1,'1370673514837','1370673601912','82AF7029F705932785CB113A49032D9B','58.62.125.66',1),(1180,0,'1370684426363',NULL,'4C168813DCE369F9350A313CAB67620D',NULL,1),(1181,1,'1370684426348',NULL,'B7C6ED20DB4F0923E8F640B803D6EE5D','123.234.34.234',1),(1182,1,'1370747197900','1370747359724','9514F590856F6320A9D35F1FCEADFBB6','120.37.91.109',1),(1183,0,'1371078140406',NULL,'61FEDCA10FD276DDBB5A07BD4EB7D927',NULL,1),(1184,1,'1371097798805','1371097908692','90DA2C2098A98DEC999CCF1DD5650763','58.248.169.116',1),(1185,0,'1371099966829',NULL,'697F35051AE2908011141106464B7B01',NULL,1),(1186,1,'1371101007127','1371101144139','A354C7CD0FCEBE10B6AE01E3F0F4B529','116.204.64.165',1),(1187,1,'1371101866230','1371102062584','548BD02DEF0EF2FAEC19B90CA5F2EF69','222.91.81.32',1),(1188,1,'1371105550792','1371120073108','CFB88E13B8DC2E706619572AD7214617','58.248.169.116',1),(1189,6,'1371130504155','1371133560592','332D4CA046F1DA984DBDF3EA2F2F6FFF','111.17.194.57',1),(1190,0,'1371168295017',NULL,'7118C13476F15BF72EEDE81DB43E154B',NULL,1),(1191,1,'1371193944667','1371194234658','7EB775301385224C590B5B9C794928FC','115.195.181.114',1),(1192,1,'1371196486007','1371196517850','B139E7F1881C1DF709184C38B087AA12','182.141.167.27',1),(1193,6,'1371290194307','1371290226869','A4624B774EF354391A4640495CF0FE82','119.4.42.152',1),(1194,6,'1371314966605','1371315123960','D5AE4A1C57E4A5F5749C22ABB6A9F5CF','111.17.194.105',1),(1195,0,'1371347979871',NULL,'F9C30AFC8E652EEE1B790A8BA869CB03',NULL,1),(1197,1,'1371349063890','1371349207808','0DC6A5C37F3204F137BD2BDC7E0F565C','125.85.111.105',1),(1202,1,'1371353225772','1371357248193','7EC21462A0562B1C226D7D6BFE73C734','183.128.153.93',1),(1234,17,'1371370325605','1371371357798','979472392082889B963689EC50211434','183.128.153.93',1),(1235,17,'1371382909627','1371384487665','10E2882291EEDD2490C210270B852126','183.128.153.93',1),(1237,0,'1371386221421','1371386244718','BEC0A9C11094237D02E0D282C706728E',NULL,1),(1239,1,'1371386590533','1371386751143','6D56AD80BD3AFA3DBF13FF35AEA01CBD','112.226.112.220',1),(1240,0,'1371455373640',NULL,'49A5711E04A1EC60F378594D8CECC7C9',NULL,1),(1241,1,'1371455373640','1371461687959','26411D0B928821B2061FCDFBA5F5E633','123.234.34.234',1),(1243,1,'1371516721235','1371516810371','894383626D629A87D893542D52B01E54','222.222.23.110',1),(1244,6,'1371516964739','1371516982926','A4B41B0A7C9ADEFDAA9B6F8F5B984525','222.222.23.110',1),(1245,0,'1371524429340',NULL,'B1C88BC0392B61FC41C884DE0C9074DC',NULL,1),(1246,1,'1371524429340','1371525051761','D0C050A5B3655988FA6D14D87BA547E4','123.234.34.234',1),(1247,0,'1371525235819',NULL,'5C48B9CAD504383C0569A3B931B3D1AA',NULL,1),(1249,10,'1371525294833','1371525322520','32FF31AD54E9595E174CC65FD28B1877','123.234.34.234',1),(1250,0,'1371525558108',NULL,'82CF2E16F279D4F11E1AA63C70A1C6B5',NULL,1),(1252,10,'1371525588513','1371525608419','4D6F50E3EB412386A346B55DFF5F3F90','123.234.34.234',1),(1253,0,'1371545748357',NULL,'B076F05D9CFD4FF69788A118A12C490B',NULL,1),(1262,17,'1371634055031','1371634123998','D3EC285473E0E794875267E8E91F8AB2','121.0.29.206',1),(1263,1,'1371699746782','1371700063618','6EC89FA74085F160C11AFB0203EE6DFA','218.249.118.226',1),(1264,1,'1371738678100','1371738883485','7347A1090502E05F738D0287F11E58EE','175.51.151.168',1),(1265,1,'1371865154486','1371866144632','6C824B00FC94CA1C1C27619321C5F7D7','211.143.7.62',1),(1266,1,'1371866299175','1371866673134','CA69120A0D0B96AC0A70793B89FF2738','211.143.7.62',1),(1268,0,'1371887126753',NULL,'5D69430CCD394165CF1CC4626EC2CEB9',NULL,1),(1269,1,'1371887154065','1371891587998','CE21F44C3AB4473733DD136B6FA28E42','211.143.7.62',1),(1271,10,'1371887262781','1371887511306','8D65376F3ECFDE6C099EBB8913C7C6E8','221.175.73.229',1),(1273,0,'1371946381654',NULL,'49BF533AE1D0C957BF26BB4708DB1D53',NULL,1),(1277,0,'1371948874559',NULL,'ED549F509D1D71399C617FB715EF46BA',NULL,1),(1281,0,'1371961026654',NULL,'F2DD773D3F46D3356B95C914FE865342',NULL,1),(1282,1,'1371961034419','1371961238711','28B47F8F6199FF72E9F1AAF53219039B','115.237.115.87',1),(1286,0,'1371967084952',NULL,'68F4D809A7D83807E13726FA00D5643A',NULL,1),(1287,1,'1371977177141','1371977283652','773F5D2BA8E11FE1880DA22F1FD1E010','115.237.115.87',1),(1291,0,'1372060697717',NULL,'03B21A3EDC15448AD82FC9C59F03617B',NULL,1),(1292,1,'1372077657783','1372078184813','98AD5FECAF4052F144EFD4E615357D91','113.107.0.68',1),(1294,0,'1372078297654',NULL,'0BF10C96550B829A0F3570B45BFEEE46',NULL,1),(1295,1,'1372124594279','1372130927695','5B441EC709F450C8CA117B22BD592F95','123.234.34.234',1),(1300,0,'1372212052334',NULL,'A740FE425918EE4F4E9178F7282E7B6C',NULL,1),(1302,0,'1372295635315',NULL,'F299D758C27BF696F51A25E3A1B203EE',NULL,1),(1303,0,'1372295635706',NULL,'9CD960C17CCD87E8C4CC9C8C892CD6D9',NULL,1),(1304,0,'1372295637815',NULL,'843F19DB325399EE6EB90045896FF065',NULL,1),(1305,0,'1372299989376',NULL,'4C0E5C9CFA41A1F3448E7074D9DF5C67',NULL,1),(1306,0,'1372311622986',NULL,'6CCD5AE0640CDEEFE2ED9A60960ACDDB',NULL,1),(1307,1,'1372414245956','1372414261252','E10B08BE06E7E583BA986D73B00F6E02','61.144.224.53',1),(1309,6,'1372418355725','1372418368334','8FB591F30BF18A7765E770554F948243','219.134.240.236',1),(1310,1,'1372430599084','1372431890113','ECDC1EF9D6D3BCBA5BBA90C6511ADF61','163.125.147.210',1),(1311,0,'1372496673960',NULL,'9B9DAF0C6CF5C6C4A3C9C6F29D8BDDD6',NULL,1),(1312,1,'1372643508380','1372643777264','C14B7F5E87596AFFAC6A79C06C4689CF','183.129.218.226',1),(1313,0,'1372643859496',NULL,'4194B24B8A629A8884199874F4D3FF78',NULL,1),(1314,0,'1372643859512',NULL,'A6D6C8030BF8F21A05F6568FE13D072C',NULL,1),(1317,1,'1372643998321','1372644235799','E1AF33A8C646B24F77238BCC0C85661B','183.129.218.226',1),(1319,1,'1372650688618','1372650713133','4EB23B0656F9BF71E91B1E7E0269C9DF','221.3.133.232',1),(1320,1,'1372650806490','1372652246875','FAC82840A3BBE317EBE4C61276B12CF5','183.129.218.226',1),(1324,6,'1372661372470','1372667589248','7954DDB2B236C8948BFC0C3C3B796A03','221.8.67.41',1),(1325,1,'1372682128424','1372682692566','77D5B642EA020A8804677AEC5CDED1F8','219.134.240.236',1),(1326,0,'1372735455859',NULL,'DEB6B544616063B0A14C6BC9089EB1D1',NULL,1),(1327,1,'1372735455859','1372747975945','BBC31011934433ECD97226525ADBA236','123.234.34.234',1),(1328,1,'1372757523513','1372757748226','ED895ED7F478EE55949E85753488637A','222.211.220.108',1),(1330,0,'1372770993514',NULL,'5B36D82D8B9825C8818F94896CC0BCC7',NULL,1),(1331,0,'1372772626456',NULL,'4E86E1E9AFAC19B07FD0B7E8578F5153',NULL,1),(1332,0,'1372772627597',NULL,'B690D66DE26E0EDE921EC812E4DFA113',NULL,1),(1333,0,'1372772685986',NULL,'88086AFAE7312BDCA57BFC4DF1501424',NULL,1),(1334,0,'1372820649791',NULL,'429BB95BCBBA00087D69606B64453B1B',NULL,1),(1336,0,'1372833579930',NULL,'9CC4F59BF8E2F1CB804DECB8B857D67D',NULL,1),(1337,0,'1372835390634',NULL,'8A51222AF49ABC12B795E78BD68DACB4',NULL,1),(1338,0,'1372839020385',NULL,'044460D3342EAB5E4AB766A9060A71F4',NULL,1),(1339,1,'1372839077336','1372839149772','6FC7EEF3FEDD09BDCA51C67982726C4F','110.217.61.170',1),(1340,10,'1372899904290','1372900894233','A625361575204CE5A94D3682824D6226','118.116.97.183',1),(1341,1,'1372903325718','1372903406762','9358190628F21229170C06202CFBB802','211.140.108.219',1),(1342,0,'1372903503151',NULL,'05CA9A63819F9AA60FCF78E7F915F007',NULL,1),(1343,0,'1372904258444',NULL,'ADDB1A406F663A60C0D92E9E4DDABF40',NULL,1),(1346,0,'1372906786035',NULL,'FC8E4FA37720CCAC80C87D20C15E8BBE',NULL,1),(1347,10,'1372921885227','1372932191682','8E174FCCB1D11E53166C1991BAC9A66A','42.228.47.10',1),(1348,0,'1372923685650',NULL,'331D9410244BC5EC1C71254F1E2273E7',NULL,1),(1349,0,'1372923988079',NULL,'B8AC2054B1E1EFB6F1D2E2720349E1A4',NULL,1),(1350,0,'1372924035484',NULL,'9F6902D6F88081F3D1340FDB8577025B',NULL,1),(1351,0,'1372982226170',NULL,'549D32ADDF13C35E9E0903308FF565D7',NULL,1),(1352,10,'1373001863606','1373002105569','C51A300B339018A955C42F9752056239','113.120.215.109',1),(1353,10,'1373108574473','1373108671673','C216A2DD4AAC9A888D28BCB76A4E1BD6','171.8.158.77',1),(1354,0,'1373259803687',NULL,'057620BE14C954746A1495687BB810A3',NULL,1),(1356,0,'1373339677052',NULL,'F35EFC7D6F21CD856ADE2CE83F8FD55D',NULL,1),(1357,0,'1373339726301',NULL,'1B4B29981CE5A69A5404D43BAC81D340',NULL,1),(1358,10,'1373339751862',NULL,'84D1C73A85F6E2AD5E1012697D4503ED','124.205.51.194',1),(1359,0,'1373341614815',NULL,'8DF0DAC5AD588706247F450E13609A4D',NULL,1),(1360,0,'1373341723359',NULL,'3C9A2071E75B48C441743B9D43D2AA35',NULL,1),(1361,0,'1373353015978',NULL,'A4EE796BEF7E447FCF9BCDC71542FF50',NULL,1),(1363,10,'1373376316990','1373377168984','5269A7E98E20C8680B7D820FE9B69091','112.226.124.131',1),(1364,0,'1373376393613',NULL,'F2F1C6C85A10FACF06E2148255EF7F8C',NULL,1),(1365,1,'1373376419081','1373376429956','8254B342BDE701B666FEC9934A1EBAFF','0:0:0:0:0:0:0:1',1),(1366,0,'1373376752776',NULL,'917BB467398C8A2E181E0153D68771C4',NULL,1),(1367,1,'1373376800275','1373376807743','0DDD4D1A7EF4F7176DA8551910F6F982','0:0:0:0:0:0:0:1',1),(1368,1,'1373509445221','1373511570213','E8EF355F84FB4BF2D3C6D7FF56E7C572','124.205.51.194',1),(1370,0,'1373703500263',NULL,'D48F7DCAFB35E769CE7960585348B798',NULL,1),(1371,0,'1373703500294',NULL,'05E1B2E5AC3DFE6837A840551EEBEA97',NULL,1),(1372,0,'1373703695117',NULL,'D1FC002A69AFB5FFB2BABF36F5A83C98',NULL,1),(1373,1,'1373703695086','1373703775755','52B865020AEB2558F4895F1B52691FD0','183.5.134.148',1),(1374,0,'1373711593310',NULL,'C37165C5806B15C94536B3EA0A08E40D',NULL,1),(1375,0,'1373722082633',NULL,'F4A8B9FA149A38BB851BBFF8D82B482E',NULL,1),(1376,0,'1373734848041',NULL,'2E03C4B31DDA239E186AFFA8068D02EB',NULL,1),(1377,0,'1373759413662',NULL,'C576B88E83B15E153BC1730A1824E3F9',NULL,1),(1378,0,'1373768710299',NULL,'F09D027B93163E8D05DEB36E8674DA03',NULL,1),(1379,0,'1373792464802',NULL,'8D04201F1B2966565B2A08BFF10C507F',NULL,1),(1380,0,'1373800129700',NULL,'B5F87077A00F71BAC86BBD62FDCD7157',NULL,1),(1381,0,'1373807845627',NULL,'373E9C7280067C63C89037883D4F8285',NULL,1),(1382,0,'1373847237792',NULL,'D50BB11A8DE26A2AC288B7814D5BD17C',NULL,1),(1383,0,'1373847237839',NULL,'3DC9B12B1EDF52D4D506B513D76249DE',NULL,1),(1384,0,'1373847237823',NULL,'BBB38B2E9B52AFBBA813225AE90103B7',NULL,1),(1385,0,'1373847237870',NULL,'F39BAD1CE0CC73C5A82EAC476F0CD3F9',NULL,1),(1386,0,'1373853010896',NULL,'55DE0F07B760B834A424F25990302730',NULL,1),(1387,1,'1373853743705','1373853884655','1AF3F52703EA0F6956D77498CADEF96E','1.85.20.146',1),(1388,1,'1374024394595','1374024775085','A07A0E7F05748259C46DF35FBE1EFA61','101.40.232.248',1),(1390,0,'1374027810023',NULL,'2FBC7A7D9E32E9917A66D995BD2D7AC7',NULL,1),(1391,1,'1374032161552','1374032262253','4721096CB4A7BCF2BB817E32330C3ACC','119.6.113.49',1),(1392,1,'1374032934298','1374032957157','CCA5BC65326C25DB2AB5DCF2A12F154C','61.163.127.142',1),(1394,0,'1374037308030',NULL,'5E4D8081BD441D930A7848174CB80C51',NULL,1),(1395,0,'1374038144805',NULL,'C158F6109FA92417798C1F4B611A67A1',NULL,1),(1396,1,'1374038240412','1374038448563','7811A3AF7159A60F5726376B112423D5','218.94.22.122',1),(1397,0,'1374040041093',NULL,'4B79AB32C6C48D4E56A20AADC7E4A340',NULL,1),(1398,0,'1374040045546',NULL,'6008F1F02CB2D687D21C9DED40BB345A',NULL,1),(1399,1,'1374044507716','1374044889766','F9139A7D3647CED4324DBB75D7CE827B','58.211.171.166',1),(1400,0,'1374046638714',NULL,'B5A435DBE1617E697FDB73A809C251F3',NULL,1),(1401,0,'1374047401679',NULL,'6847184ED3BADF0097F02C66DA08F18D',NULL,1),(1404,1,'1374049146947','1374049176305','E3AB743710003B145725D6F322123A05','123.234.34.234',1),(1405,1,'1374111538063','1374112150032','4A55E707F7249051AB6ADFD22A54F549','220.166.95.59',1),(1406,0,'1374113840692',NULL,'099B448D4DC36877FE963D8352CCDA4E',NULL,1),(1413,6,'1374113996657','1374114078076','7DD2DC2E99FB97FE3359A43FE15FF772','218.17.162.171',1),(1414,1,'1374113979907',NULL,'A90197AD9FBCA44256A4E69D26615168','124.205.99.43',1),(1415,8,'1374114010891','1374114045124','71635ECA6D4B3E5FFC486CD80A930D37','106.2.162.197',1),(1417,1,'1374114105388','1374114128028','574BE17ECA34241E86FE1775A59BAE7C','118.244.199.2',1),(1418,10,'1374114144543','1374114156184','031E9107D3EDFBAC0105D06A623CE0B0','182.48.115.78',1),(1419,1,'1374114218604','1374114300461','38063BAD1ABB58A70383D76478863B76','101.44.183.144',1),(1420,1,'1374116090337','1374116142539','672ECC981675666021A90380E1D84733','114.252.228.128',1),(1421,6,'1374116476749','1374116535654','9A31DD68AFE69512A5068CBB5E91CCEB','123.114.63.80',0),(1422,1,'1374116928378','1374116951143','E081B2B737E98BC433C0781899820B76','113.97.83.91',1),(1423,0,'1374118607992',NULL,'FB568BF127F4D61AEE5A27706FBBFB6F',NULL,1),(1424,0,'1374123008926',NULL,'D0F8D842C77795E20C87F346C1867313',NULL,1),(1425,0,'1374135685461',NULL,'2B544AC81093E431DCFA79F81ED427F9',NULL,1),(1426,1,'1374149051417',NULL,'844DA0E442EFD9FC57AAAE8701CF0718','27.219.73.246',1),(1427,1,'1374149531702','1374151721724','E58B9FA510A2E61E36904363E283F59C','27.219.73.246',1),(1428,1,'1374222347888','1374222364028','16394EA5D9CEBEB615FCDBCA9161D7DA','123.113.149.246',1),(1429,0,'1374224085249',NULL,'59A771F8B6911AC83FD38AF5B85D70E0',NULL,1),(1430,0,'1374224096390',NULL,'19770C9D9DF0D65BBBBF94F56AAF7846',NULL,1),(1431,1,'1374224745326','1374228694022','26B60E3F9EFBD2015D586CC30DFBA03A','123.234.34.234',1),(1432,0,'1374226144993',NULL,'F3399FF098BD15E45420B3D928DEEC9B',NULL,1),(1433,0,'1374232228463',NULL,'07D96200B011E6AC003710C7419F098E',NULL,1),(1434,0,'1374232233494',NULL,'AC8AEA7C36C4A3E692B5F0A8D7F23DCF',NULL,1),(1435,0,'1374235889066',NULL,'47259E37EB904D024D1D8D30E3763CBE',NULL,1),(1436,0,'1374240364028',NULL,'290A403FDACFF445286776DD93786953',NULL,1),(1437,0,'1374246556058',NULL,'F9C3136EFE4DF8E212E9D0177F0FC2D3',NULL,1),(1438,0,'1374286633807',NULL,'0A3940CACBE63FE4996AE846793A4A23',NULL,1),(1439,0,'1374289507890',NULL,'2620A74DE96376A484B19F710C763001',NULL,1),(1440,0,'1374303553590',NULL,'692C6B064B317517318A299A95F0FA89',NULL,1),(1441,0,'1374335053122',NULL,'D334140E4BD2AF1B4D1EDA52B28937D8',NULL,1),(1442,0,'1374365110067',NULL,'F87582008BC0BAB95568017705C488DD',NULL,1),(1443,0,'1374375686399',NULL,'C0B51E318BD13504D884A3CF1FDBA4D6',NULL,1),(1445,0,'1374399757899',NULL,'C9211B357788A8B11D5696D5ADEC4985',NULL,1),(1446,1,'1374401141884','1374411824679','FC8F3827B95FAE19A4CFDA7073324879','123.234.34.234',1),(1447,0,'1374411809304',NULL,'438D36B303FA55FFE8DCAEDB5D25F9C3',NULL,1),(1450,1,'1374412689063','1374415285731','298287CD0AC1BE9CEF98E143C600BDC4','124.129.66.199',1),(1451,0,'1374421427808',NULL,'0FF3A4485B6A3D3AFC35C4725E047C44',NULL,1),(1452,0,'1374452549794',NULL,'58FB244D5CD8C135603AC02A1158F682',NULL,1),(1453,1,'1374452549794','1374456479318','ECCF6E9469B66D7B11EAE728EF1CF3A9','123.234.34.234',1),(1454,0,'1374457580665',NULL,'C27BFC25D5792A2444D7D1C5DA5B7F24',NULL,1),(1455,0,'1374461613765',NULL,'154CBB2FFE3C4BD5899EE88D2B914DE2',NULL,1),(1458,0,'1374475744795',NULL,'8A0084E2537E4EE96DD0697AF2C5C2C1',NULL,1),(1459,1,'1374486947493','1374487268719','E8206CF0AEF2DF1013D3500C491CDA52','219.159.77.44',1),(1460,1,'1374487875313','1374488002950','01AB74B88E5437130E2E44A646CDBDC1','219.159.77.44',1),(1461,0,'1374495882139','1374497041578','812D32526F6A7BBE81B952C87FB6C533',NULL,1),(1462,1,'1374495895592','1374501258776','45DB2575842A335776EB5E96FC9EABF8','27.219.74.10',1),(1463,0,'1374537756375',NULL,'B05BC2C76526D0FF044AC19E56B6316B',NULL,1),(1466,1,'1374562643019','1374563199956','F91690DD1E2AC93B64A96F14B688B93C','60.191.111.116',1),(1467,1,'1374571372016','1374571989625','804ADE451565134BEAE30C0006BE28DA','123.234.34.234',1),(1468,0,'1374573918388',NULL,'0EBB884010A07F4E27751F1F7A615E6E',NULL,1),(1469,1,'1374573918357','1374574369002','EFC464915128A76D1E4FC7B3C9F40A45','123.234.34.234',1),(1471,10,'1374587150784','1374587279515','797FB6FCCA587B00D6798D2AAA720134','112.226.125.88',1),(1472,0,'1374587383450',NULL,'19CA1191A2CAFB167DFBB8B5F3F8AA1D',NULL,1),(1477,10,'1374587659396','1374587896921','5A01121052C77453B9AC380AC9BE7338','112.226.125.88',1),(1478,0,'1374588145555',NULL,'0396853CC40356B8BC99C8F3A75A0D68',NULL,1),(1482,0,'1374589267901',NULL,'31A815039360C0D40E71ECF1D1EBF217',NULL,1),(1483,10,'1374631274519','1374632317192','9CD1AA407FF585AD24C48C0DA79C5366','123.234.34.234',1),(1484,0,'1374634569385',NULL,'A90F5C0A8C3542C1E739129D355F1DEC',NULL,1),(1487,0,'1374634782676',NULL,'0DDDF7A1C65514B212C1BB2107E3B7A2',NULL,1),(1488,10,'1374634792910','1374634807425','73D090F3E0FD6D19122C913A9EC6F3DA','116.204.64.165',1),(1491,1,'1374658200749','1374658513960','15941C9DC11625D5874E7DC2DFAAE24A','123.234.34.234',1),(1492,1,'1374658770703','1374658778688','97609F25688A0030F005245941C58085','123.234.34.234',1),(1496,4,'1374759937194','1374759996988','864D9B3BAEF65E98BCEAF9D14E7D7E5C','27.210.109.87',1),(1499,1,'1374760679368','1374763590368','9E98F69081D6213412B2C42326275BD0','27.210.109.87',1),(1500,0,'1374813665769',NULL,'CBE18C205D43FF721F6CDC551930F5F7',NULL,1),(1501,0,'1374817184320',NULL,'5DC9C1CB73F8518F25980C261415C7DC',NULL,1),(1507,0,'1374831284374',NULL,'2581E70FF16066B537C687CB2DDA16FA',NULL,1),(1518,0,'1374909080378',NULL,'B4EAC555FC750F867C5D500788452321',NULL,1),(1519,1,'1375004479838','1375004802643','30DAE1B151246AEE18B15324F5299880','61.163.104.78',1),(1520,1,'1375015249016','1375015268500','D383C7FAE2EB952AB99E9924979CCB58','27.210.109.87',1),(1521,0,'1375058510214',NULL,'25348A8160A4878E0428F9FA300FE767',NULL,1),(1522,1,'1375058536869','1375059037557','E820B2E5A2D4016B78A52AE378E299FD','120.194.22.72',1),(1524,0,'1375059267502',NULL,'09D3A21283ADF10ABFBD753F52681940',NULL,1),(1528,1,'1375059709598','1375059938934','2346A7C0C71E5EC52EBDF521E96DFCCA','120.194.22.72',1),(1529,1,'1375060850999','1375061099069','6E34C815127020894A3E1E0A03F740D6','120.194.22.72',1),(1530,1,'1375067917249','1375069732609','3609BE60D2019018F24782704B9AB1A7','123.234.34.234',1),(1531,0,'1375070598758',NULL,'223AAD6ED129AE801DB39681582A7B05',NULL,1),(1532,1,'1375070598758','1375076225505','D1ACE9AC2C5F66BEAAD4AEE82DD4949B','123.234.34.234',1),(1533,0,'1375102265128',NULL,'4307EE983C592456B94193884058B4EE',NULL,1),(1535,1,'1375107337467','1375107422356','24DAAA742C9A3A463CF1530C2292AF3E','27.210.91.52',1),(1536,0,'1375142004816',NULL,'80D2734F9E8CC333E54D9636551ED3E6',NULL,1),(1537,0,'1375142004831',NULL,'65789630A505FE298E1B109D9A2FF93A',NULL,1),(1539,1,'1375154200714','1375154871965','11F4A0E8032B996624B8EAA32630F293','42.228.117.38',1),(1540,1,'1375166454918','1375171619474','C83D586F00D3E220647DFABA1B5AF59D','116.204.64.165',1),(1545,1,'1375182438853','1375187717927','148FB784B97BA67B6CEF70E906F9652A','27.193.104.144',1),(1551,11,'1375188302420','1375188490866','AFCE9F3E3523667F5DDB2D7DA980F367','27.193.104.144',1),(1552,1,'1375193249741','1375193369332','CC468D1CD7502661B016A249E7542A5C','222.89.192.165',1),(1553,1,'1375232841995','1375234934770','203CB7A2F078E20EDC222D02683ED6C6','210.73.73.225',1),(1554,0,'1375235717734',NULL,'1D3BD56EBCD5BAF66F432CA6B46110BE',NULL,1),(1556,1,'1375241823796','1375248708870','31D798C6CE6EBAEFA1B746ED16E788E5','101.95.96.34',1),(1557,0,'1375253238232',NULL,'BE806654CE68B1B9FA197B15A99ACCAB',NULL,1),(1558,0,'1375263563023',NULL,'ED6DF9F7E1CF7485371832905E958BDE',NULL,1),(1559,0,'1375320510715',NULL,'EE468BF2C98C0FA3919FCB51D66E20B7',NULL,1),(1560,1,'1375320517809','1375320604884','B2D2B566A20E0940EF07B6547A59C619','61.150.43.46',1),(1561,1,'1375320840830','1375323090320','0B8A126811187B70A125B8B403DADE82','61.150.43.46',1),(1562,0,'1375324409156',NULL,'E3A5097E6D311485A4263D7E72769859',NULL,1),(1563,1,'1375327543560','1375327612949','FB614B552AA571984C10F8EC4BCFB2EF','211.136.253.181',1),(1564,1,'1375327816209','1375327845474','8D8C37626CEDF37F739E538FEBD2757E','123.234.34.234',1),(1565,0,'1375328335790',NULL,'F69474DB8DFCDEF857F08A64A62A1E71',NULL,1),(1566,1,'1375328335805','1375329259828','FB8E7A5ECF67C8962F2526B8CCC2AA86','123.234.34.234',1),(1567,1,'1375704001198','1375705651615','87BF1B3C378EC258D702A7E3D55E6F64','27.219.74.117',1),(1568,0,'1375761421642',NULL,'3C86FB1B5B43A845DFFBEBFA802FF531',NULL,1),(1570,1,'1375858013267','1375858075485','9E038BBA40B823B4A0D921E8DB6108DF','120.10.116.81',1),(1571,0,'1375859775175',NULL,'1968FBBBD798E98CDF952C3D0EF1A4F7',NULL,1),(1572,0,'1375860014279',NULL,'DAE60784848F1D7673A48FD38C651A7C',NULL,1),(1573,10,'1375876139431','1375876166789','353C3611B2836AD4D2F78A2637A6D38C','112.95.103.124',1),(1574,0,'1375933445237',NULL,'F612BA29CC0CFB04085537B4D55198E7',NULL,1),(1575,1,'1375933445253',NULL,'B7F433D01C3AE8151D2259FAEB780F7E','123.234.34.234',1),(1576,1,'1376006624491','1376018270180','78EC6533FAB3765423141B756D361E62','123.234.34.234',1),(1577,1,'1376108021465','1376108964278','6F7435A37E0DA54CC2BFEDFD29F6CBD7','140.224.91.46',1),(1578,0,'1376119924817',NULL,'C52DA212E4E8E6471039A0228BEF0454',NULL,1),(1579,1,'1376137660076','1376137946127','9AD10E1AAA63547F3298B6680BBF5DA0','60.10.64.58',1),(1580,0,'1376386573706',NULL,'0B66223F7646B7815FDD0093E7894FFC',NULL,1),(1581,1,'1376386573706','1376395487509','33B6558FFB710331E10929C9669AD144','123.234.34.234',1),(1582,0,'1376462513562',NULL,'844334777E402C2332F16CBEDE698FF6',NULL,1),(1590,10,'1376467854227','1376481639121','072693BD85AF5DE44CEB7221C24A5695','123.234.34.234',1),(1591,1,'1376481782180','1376483588712','292F3CCF72113C056B1D99CD4BF1A42D','27.210.192.151',1),(1603,0,'1376485958932',NULL,'A94DDAA851C9B4F7098E6EB6869536D7',NULL,1),(1616,1,'1376487054107','1376487218244','0D937764DE2933310FA913C2E2386F2A','27.210.192.151',1),(1617,0,'1376487084982',NULL,'728F423A9F56F8E163030EFF9A733CE7',NULL,1),(1618,0,'1376524635523',NULL,'4F75134DDCB15CE5CF8338239E4782E1',NULL,1),(1619,1,'1376524635491','1376525586983','1F940FEF29E485DA3C7EA043D7760540','123.234.34.234',1),(1620,1,'1376533388190','1376534124437','110BBF8CC33AD4A94EC7EC8F20937F50','123.234.34.234',1),(1621,0,'1376744542216',NULL,'49CAB401D6981E7982A28F030F451D22',NULL,1),(1622,1,'1376794575207','1376794721967','47E7610DBB6C51CCCFBA3F5F62AD7E23','27.184.72.149',1),(1623,0,'1376872369707',NULL,'13A5F81C2D4526B5DE6C06B1B8EC7C3E',NULL,1),(1624,1,'1376872369707','1376879709550','D4B356854CADF68EE66D9EF7FCB5A976','123.234.34.234',1),(1625,0,'1376900165317',NULL,'49437F18929DB237938624C1E8C170FF',NULL,1),(1626,1,'1376900165317','1376905985808','1D6EF615975F240D29C80A96D41F9298','123.234.34.234',1),(1627,1,'1376961146853','1376961658649','8EB2C43E2E6DFFF2902DA71B76AB102C','115.236.188.226',1),(1628,1,'1376984927190','1376984996953','B5F54F8D8FDFBA8DFA075256D78F0274','113.16.25.89',1),(1629,0,'1377264106072',NULL,'1261265CEAFC6CF25304E389AF4DA3DA',NULL,1),(1630,8,'1377346847020','1377346980423','4020F7F8AAC14BFFAD70C2F3B9F0C491','123.123.107.212',1),(1631,1,'1377362605422','1377362683795','B6F3349780D6EAA0068F38EF5A11C60D','171.217.186.166',1),(1633,0,'1377362885509',NULL,'A66A61A0698E3F75FA8938A094A06456',NULL,1),(1635,1,'1377363067051','1377363134502','D32F4ACAFF48B12BC00AE8DE11E8B161','119.4.13.24',1),(1636,0,'1377383348677',NULL,'1445E9936A9B4E8D65F646293407CB40',NULL,1),(1638,1,'1377502354264','1377502809940','1C5F8207E577B4738E0900504227F39A','223.166.166.208',1),(1639,0,'1377503991050',NULL,'2E8019AEBB580F2EDCB7D66957B3F4C8',NULL,1),(1640,0,'1377504211076',NULL,'7A7A4470C17FA64DF751B489E4167CB4',NULL,1),(1641,0,'1377504213951',NULL,'35A2DCBAC15EF3BA44CEBC06E0A77763',NULL,1),(1642,0,'1377520687444',NULL,'BE8306A1B06ED3C53B5130204A1A2F52',NULL,1),(1643,0,'1377564747591',NULL,'B356C05BC9E666D19C5413147F2E95D9',NULL,1),(1645,1,'1377587932639','1377588229429','5824D5E8C3AF84CB2D6F5AB673BB2369','180.127.12.110',1),(1646,0,'1377588007841',NULL,'24E1E4B461B69626921BCFE3E2FAFB87',NULL,1),(1647,0,'1377588316114',NULL,'DC0AC4815E268FD538166973DC30862C',NULL,1),(1648,0,'1377589974431',NULL,'FAED134FD6F56718D26F3CBD6021765E',NULL,1),(1649,8,'1377590065054','1377590314344','F284FD7ED6E1097F28E141B06FD734DB','180.173.20.200',1),(1650,8,'1377590437825','1377596631120','B0EC90B76541134577378A5B230B144B','180.173.20.200',1),(1651,0,'1377592442196',NULL,'A3CDE648E636580AD2909221455D3393',NULL,1),(1652,1,'1377594080810','1377594106419','4E1DFC897914FB2032141474610A1A01','222.212.244.74',1),(1654,1,'1377594855353','1377595625255','C018EB810A5A52A7C5AA995039D16DCB','123.234.34.234',1),(1656,0,'1377654573779',NULL,'4AFDEFE50DFCD3323BFE769EDF6AF02D',NULL,1),(1657,10,'1377654601966','1377655125328','03BC992899D79FCF5924A545C56F9DBD','180.173.20.200',1),(1659,8,'1377655315307','1377660471269','4E9269B7AC04A478E7C0DB49D4838400','180.173.20.200',1),(1661,0,'1377658994010',NULL,'80B0683966DAA4E18153A36652131AFC',NULL,1),(1662,1,'1377659039181','1377659057243','CCAD100D19312E99B4BCB8A1922B8012','222.90.170.190',1),(1664,1,'1377660899711','1377660944319','0F8C08541676D484793713A531D68D91','106.120.35.246',1),(1665,1,'1377666799545',NULL,'D1A39A3AD348CF45DC8E6998BA910E98','10.130.160.54',1),(1666,0,'1377675239657',NULL,'19F3BAFAE71C01A3ECD669911DE98899',NULL,1),(1667,1,'1377676117290','1377678817827','CE983AF552BD7BACE7B4C0D21EBA9D24','125.70.11.136',1),(1668,0,'1377678864325',NULL,'1CB499ED460945FC88DF31DE980EE517',NULL,1),(1669,0,'1377679103300',NULL,'77ED1B339255022EB3D0D017E8E32D41',NULL,1),(1670,1,'1377679103269','1377679404476','56850262F51BD81E8CD0B92DFE8A7F89','123.234.34.234',1),(1671,0,'1377679955019',NULL,'A9FFA5E5E481552AA235200E0B57D0A1',NULL,1),(1672,0,'1377680261556',NULL,'BAAF01E827BB1FB337A7FC1845C503E2',NULL,1),(1673,0,'1377680572328',NULL,'88AC232A3AF0CEF2D2359009A4263812',NULL,1),(1674,0,'1377680572328',NULL,'68434BB915A762C89179D7F33901DF88',NULL,1),(1675,1,'1377684691283','1377685198942','59EE496F2CD7E34134FDB6756F123D7E','125.70.11.136',1),(1676,1,'1377693386310','1377693641663','DECC4BF27845598991EE71D75F596542','180.91.81.136',1),(1677,1,'1377744266615','1377744964084','1F0FF9F42363131F91B6D5ADA7946D79','124.64.245.4',1),(1679,1,'1377764728933','1377765224733','655BFD51442E2E9FD2ABBAD92418BB06','58.211.24.206',1),(1681,8,'1377765574458','1377765646081','50C7DC2CDF258E35C1840BCDD6F22B56','124.207.174.85',1),(1682,10,'1377765655769','1377768806375','7C2211DAAC7459299238950FB9642849','180.173.20.200',1),(1683,0,'1377780717781',NULL,'C212A951084C30C7E5BBA71CE9628AE5',NULL,1),(1684,10,'1377827928576','1377833636133','B983231FC9A6E87C0EFB997DBF06E964','42.228.32.18',1),(1685,0,'1377830154784',NULL,'1BAD9C9F26225E64C1178C11D6EAD703',NULL,1),(1686,0,'1377835436477',NULL,'696074D2C76AFF581D94670BCDF138F2',NULL,1),(1687,1,'1378020070838','1378026597624','B5AB54FA4739748160763354D294A703','27.193.106.250',1),(1688,0,'1378026766463',NULL,'B74CB11582638A8C6F3042EA37276CE3',NULL,1),(1689,1,'1378026766479','1378026997598','9BCE1C36727ABE8FCDA3CB1D406EF754','27.193.106.250',1),(1690,0,'1378027293169',NULL,'753F3187ABB0BD82268365717E57F5A4',NULL,1),(1691,1,'1378027292809','1378028489326','C2F7A44EA139A5279561239F72471600','27.193.106.250',1),(1692,0,'1378028573667',NULL,'AA5205FF9A5276E1DCD805334C5B30EC',NULL,1),(1693,1,'1378028573652','1378030086644','8BA8C293C18A6B5075F47D4CE6E168A0','27.193.106.250',1),(1694,1,'1378030630521','1378030640708','B39D470D8D465F0F55ECCA3DA5C80113','27.193.106.250',1),(1698,10,'1378031076650','1378031625886','FDD36447582F560DD2EAA58BE2501145','27.193.106.250',1),(1699,0,'1378031360486',NULL,'9BFFEAE98666FB7CE58E4957BEBEEE90',NULL,1),(1700,0,'1378031360486',NULL,'BCF9515DB24C59C5FA1151B0AC06BF8C',NULL,1),(1701,1,'1378083093876','1378083526865','6FE91B12CA86C00C286673F56CD718BF','58.215.28.226',1),(1702,8,'1378093653980','1378094272996','4886E99851A31B803267EE40E116E987','120.192.27.117',0),(1705,0,'1378126651497',NULL,'4CD474E1C6FC13D9D4282135C4E9F166',NULL,1),(1706,0,'1378126729823',NULL,'D495597C66E465DFF55781AE6689C7A0',NULL,1),(1708,10,'1378126908881','1378127422774','AA6FA14EBCAC8033CE10B8BC93C60283','120.194.22.72',1),(1709,1,'1378126965192','1378130161141','FFD4F00A3FFB3EE68756F5A838822D76','123.234.34.234',1),(1711,10,'1378211462690','1378212735626','271CBB06A821DE835D67D976EA544BE6','27.210.110.62',0),(1712,1,'1378212881919','1378213654399','52C0774BB7F7155965534CB8AB24554E','27.210.110.62',1),(1713,0,'1378213767662',NULL,'37261ADDC10F41E14888ED4A4F845CEC',NULL,0),(1714,1,'1378213767615','1378214079060','DA0DFFC4A2E3877CB780EC099BB449EC','27.210.110.62',0);
/*!40000 ALTER TABLE `core_user_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_pinyin`
--

DROP TABLE IF EXISTS `core_pinyin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_pinyin` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `pinyin` varchar(100) DEFAULT NULL,
  `hanzi` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_pinyin`
--

LOCK TABLES `core_pinyin` WRITE;
/*!40000 ALTER TABLE `core_pinyin` DISABLE KEYS */;
INSERT INTO `core_pinyin` VALUES (2,0,'2011-09-16 19:49:36',0,NULL,NULL,'li','李');
/*!40000 ALTER TABLE `core_pinyin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_visit`
--

DROP TABLE IF EXISTS `crm_visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_visit` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `lianxirq` datetime DEFAULT NULL,
  `jiluren` varchar(45) DEFAULT NULL,
  `lianxinr` varchar(800) DEFAULT NULL,
  `xingdongjh` varchar(800) DEFAULT NULL,
  `xingdongrq` datetime DEFAULT NULL,
  `zhuguanpf` varchar(800) DEFAULT NULL,
  `isArc` char(1) DEFAULT 'N',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_visit`
--

LOCK TABLES `crm_visit` WRITE;
/*!40000 ALTER TABLE `crm_visit` DISABLE KEYS */;
INSERT INTO `crm_visit` VALUES (3,8,'2012-04-15 21:06:59',0,NULL,'efb389e7-154a-46ec-81a0-5a10ed0c2889','2012-04-16 00:00:00','代前杰','代前杰代前杰代前杰','下一步行动计划下一步行动计划','2012-04-16 00:00:00','主管批复主管批复主管批复','N'),(22,0,'2012-04-29 00:00:00',1,'2012-08-22 21:31:46','','2012-03-23 00:00:00','张大江','结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错','','2012-03-29 00:00:00','','N'),(24,8,'2012-10-20 20:55:43',0,NULL,'c9bcd7ed-a38f-4c96-b839-29a956605884','2012-10-22 00:00:00','代前杰','下一步行动计划下一步行动计划','',NULL,'','N'),(25,8,'2012-10-20 21:00:54',0,NULL,'ed6c2c3c-37b9-4208-bc69-bf777bb73260','2012-10-23 00:00:00','刘德华','首次打电话','再次打电话','2012-10-28 00:00:00','','N'),(26,8,'2012-10-20 21:00:54',0,NULL,'ed6c2c3c-37b9-4208-bc69-bf777bb73260','2012-10-28 00:00:00',NULL,'再次打电话','',NULL,NULL,'N'),(27,8,'2012-10-20 21:07:22',0,NULL,'33829018-6857-4353-b80d-bfca98a83de8','2012-09-23 00:00:00','张大江','结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错结果不错','继续跟踪','2012-09-29 00:00:00','要抓紧时间','N'),(28,8,'2012-10-20 00:00:00',1,'2012-11-05 20:03:12','33829018-6857-4353-b80d-bfca98a83de8','2012-09-29 00:00:00','刘德华','继续跟踪啊啊','继续打电话','2012-11-06 00:00:00','重点跟踪','N'),(29,8,'2012-11-05 00:00:00',1,'2013-06-22 15:43:03','60a59863-be61-4b1e-86f6-7a368366f25b','2012-11-03 00:00:00','代前杰','电话联系范总，预约除尘项目','给范总发方案','2012-11-05 00:00:00','要重点关注','Y'),(30,8,'2012-11-05 00:00:00',1,'2012-11-05 20:34:38','60a59863-be61-4b1e-86f6-7a368366f25b','2012-11-05 00:00:00','代前杰','给范总发方案','电话范总，方案审查情况','2012-11-06 00:00:00','','N'),(31,8,'2012-11-05 00:00:00',1,'2012-11-06 21:15:15','60a59863-be61-4b1e-86f6-7a368366f25b','2012-11-06 00:00:00','代前杰','电话范总，方案审查情况','',NULL,'','N');
/*!40000 ALTER TABLE `crm_visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_form_field`
--

DROP TABLE IF EXISTS `core_form_field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_form_field` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `formId` int(11) DEFAULT '0',
  `fieldName` varchar(45) DEFAULT NULL,
  `fieldText` varchar(45) DEFAULT NULL,
  `fieldType` varchar(45) DEFAULT NULL,
  `fieldWidth` int(11) DEFAULT '0',
  `dataSource` varchar(450) DEFAULT NULL,
  `textItems` varchar(450) DEFAULT NULL,
  `checkText` varchar(450) DEFAULT NULL,
  `formatString` varchar(45) DEFAULT NULL,
  `checkRule` varchar(45) DEFAULT NULL,
  `checkType` varchar(45) DEFAULT NULL,
  `inputType` varchar(45) DEFAULT NULL,
  `autoIncrease` varchar(1) DEFAULT NULL,
  `orderNum` int(11) DEFAULT '0',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_form_field`
--

LOCK TABLES `core_form_field` WRITE;
/*!40000 ALTER TABLE `core_form_field` DISABLE KEYS */;
INSERT INTO `core_form_field` VALUES (1,1,NULL,1,'2011-12-05 19:13:13',NULL,0,'field','短文本','varchar45',45,'自定义列表','北京;上海;深圳;广州;青岛;武汉;南京','','','',NULL,NULL,NULL,NULL),(2,1,NULL,NULL,NULL,NULL,0,'field2','短文本2','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,1,NULL,1,'2011-11-27 20:52:20',NULL,0,'field3','短文本3','varchar45',45,'','','','',NULL,NULL,NULL,NULL,NULL),(4,1,NULL,NULL,NULL,NULL,0,'field4','短文本4','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,1,NULL,NULL,NULL,NULL,0,'field5','短文本5','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,1,NULL,NULL,NULL,NULL,0,'field6','长文本','varchar450',450,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,1,NULL,1,'2011-11-30 19:46:39',NULL,0,'field7','长文本2','varchar450',450,NULL,'','','','',NULL,NULL,'Y',NULL),(8,1,NULL,1,'2011-12-19 20:52:49',NULL,0,'field8','长文本3','varchar450',450,NULL,'','','','',NULL,NULL,NULL,NULL),(9,1,NULL,1,'2011-11-27 20:52:13',NULL,0,'field9','长文本4','varchar450',450,'','','','',NULL,NULL,NULL,NULL,NULL),(10,1,NULL,NULL,NULL,NULL,0,'field10','长文本5','varchar450',450,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,1,NULL,NULL,NULL,NULL,0,'field11','整数型','int',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,1,NULL,NULL,NULL,NULL,0,'field12','整数型2','int',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,1,NULL,NULL,NULL,NULL,0,'field13','整数型3','int',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,1,NULL,NULL,NULL,NULL,0,'field14','整数型4','int',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,1,NULL,NULL,NULL,NULL,0,'field15','整数型5','int',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,1,NULL,NULL,NULL,NULL,0,'field16','浮点型','float',0,NULL,NULL,NULL,'0.0',NULL,NULL,NULL,NULL,NULL),(17,1,NULL,NULL,NULL,NULL,0,'field17','浮点型2','float',0,NULL,NULL,NULL,'0.00',NULL,NULL,NULL,NULL,NULL),(18,1,NULL,NULL,NULL,NULL,0,'field18','浮点型3','float',0,NULL,NULL,NULL,'0.000',NULL,NULL,NULL,NULL,NULL),(19,1,NULL,NULL,NULL,NULL,0,'field19','浮点型4','float',0,NULL,NULL,NULL,'0.0000',NULL,NULL,NULL,NULL,NULL),(20,1,NULL,NULL,NULL,NULL,0,'field20','浮点型5','float',0,NULL,NULL,NULL,'0.00000',NULL,NULL,NULL,NULL,NULL),(21,1,NULL,1,'2012-01-15 09:19:43',NULL,0,'field21','布尔型','char',1,NULL,'','','','','Reg','text','N',NULL),(22,1,NULL,NULL,NULL,NULL,0,'field22','布尔型2','char',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,1,NULL,NULL,NULL,NULL,0,'field23','布尔型3','char',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,1,NULL,NULL,NULL,NULL,0,'field24','布尔型4','char',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,1,NULL,NULL,NULL,NULL,0,'field25','布尔型5','char',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,1,NULL,NULL,NULL,NULL,0,'field26','日期型','datetime',0,NULL,NULL,NULL,'yyyy-MM-dd',NULL,NULL,NULL,NULL,NULL),(27,1,NULL,NULL,NULL,NULL,0,'field27','日期型2','datetime',0,NULL,NULL,NULL,'yyyy-MM-dd',NULL,NULL,NULL,NULL,NULL),(28,1,NULL,NULL,NULL,NULL,0,'field28','日期型3','datetime',0,NULL,NULL,NULL,'yyyy-MM-dd',NULL,NULL,NULL,NULL,NULL),(29,1,NULL,NULL,NULL,NULL,0,'field29','日期型4','datetime',0,NULL,NULL,NULL,'yyyy-MM-dd HH:mm:ss',NULL,NULL,NULL,NULL,NULL),(30,1,NULL,1,'2011-11-28 21:35:02',NULL,0,'field30','日期型5','datetime',0,NULL,'','','yyyy-MM-dd HH:mm:ss',NULL,NULL,NULL,NULL,NULL),(31,1,NULL,NULL,NULL,NULL,0,'field31','超长文本','text',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,1,NULL,NULL,NULL,NULL,0,'field32','超长文本2','text',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,1,'2011-12-05 00:00:00',1,'2012-02-01 18:58:58',NULL,11,'field','会议名称','varchar45',45,NULL,'','','','',NULL,'text','N',1),(37,1,'2011-12-05 00:00:00',1,'2011-12-19 21:18:57',NULL,11,'field26','开始时间','datetime',0,NULL,'','','yyyy-MM-dd','',NULL,NULL,NULL,4),(38,1,'2011-12-05 00:00:00',1,'2012-03-08 20:28:56',NULL,11,'field27','结束时间','datetime',0,NULL,'','','yyyy-MM-dd','',NULL,NULL,NULL,5),(39,1,'2011-12-05 00:00:00',1,'2011-12-19 20:53:51',NULL,11,'field6','会议内容','varchar450',450,NULL,'','','','',NULL,'textarea',NULL,3),(40,1,'2011-12-05 00:00:00',1,'2012-03-08 20:47:53',NULL,11,'field4','会议主持','varchar45',45,'员工列表','','','','',NULL,NULL,NULL,99),(41,1,'2012-05-10 19:55:20',NULL,NULL,NULL,12,'field','文档名称','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(42,1,'2012-05-10 19:55:28',NULL,NULL,NULL,12,'field2','描述','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2),(43,1,'2012-07-01 00:00:00',1,'2012-07-01 21:13:01',NULL,13,'field26','登记日期','datetime',0,NULL,'','','yyyy-MM-dd','',NULL,NULL,NULL,1),(44,1,'2012-07-01 00:00:00',1,'2012-07-01 21:12:54',NULL,13,'field11','温度','int',0,NULL,'','温度必须是整数','','',NULL,NULL,NULL,2),(45,1,'2012-07-01 00:00:00',1,'2012-07-01 21:12:46',NULL,13,'field12','湿度','int',0,NULL,'','湿度必须是整数','','',NULL,NULL,NULL,3),(46,1,'2013-05-30 12:52:06',NULL,NULL,NULL,14,'field','aaa','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(47,1,'2013-06-05 15:19:17',NULL,NULL,NULL,15,'field','家具分类','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(48,1,'2013-06-05 15:19:28',NULL,NULL,NULL,15,'field2','申请部门','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2),(49,1,'2013-06-05 15:19:36',NULL,NULL,NULL,15,'field6','备注','varchar450',450,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,20),(50,1,'2013-06-05 15:19:46',NULL,NULL,NULL,15,'field16','合同金额','float',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10),(59,1,'2013-06-16 14:53:53',NULL,NULL,NULL,17,'field','请假人','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(60,1,'2013-06-16 14:54:09',NULL,NULL,NULL,17,'field26','请假开始时间','datetime',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2),(62,1,'2013-06-16 14:55:09',NULL,NULL,NULL,17,'field27','请假结束时间','datetime',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3),(63,1,'2013-06-23 11:25:51',NULL,NULL,NULL,16,'field','申请人','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(64,1,'2013-06-23 11:26:24',NULL,NULL,NULL,16,'field2','文具名','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(65,1,'2013-06-23 00:00:00',1,'2013-06-23 11:26:51',NULL,16,'field11','数量','int',0,NULL,'','','','',NULL,NULL,NULL,2),(66,1,'2013-07-21 16:02:24',NULL,NULL,NULL,19,'field','姓名','varchar45',45,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `core_form_field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofmucaffiliation`
--

DROP TABLE IF EXISTS `ofmucaffiliation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofmucaffiliation` (
  `roomID` bigint(20) NOT NULL,
  `jid` text NOT NULL,
  `affiliation` tinyint(4) NOT NULL,
  PRIMARY KEY (`roomID`,`jid`(70))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofmucaffiliation`
--

LOCK TABLES `ofmucaffiliation` WRITE;
/*!40000 ALTER TABLE `ofmucaffiliation` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofmucaffiliation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofmucservice`
--

DROP TABLE IF EXISTS `ofmucservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofmucservice` (
  `serviceID` bigint(20) NOT NULL,
  `subdomain` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isHidden` tinyint(4) NOT NULL,
  PRIMARY KEY (`subdomain`),
  KEY `ofMucService_serviceid_idx` (`serviceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofmucservice`
--

LOCK TABLES `ofmucservice` WRITE;
/*!40000 ALTER TABLE `ofmucservice` DISABLE KEYS */;
INSERT INTO `ofmucservice` VALUES (1,'conference',NULL,0);
/*!40000 ALTER TABLE `ofmucservice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eq_test`
--

DROP TABLE IF EXISTS `eq_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eq_test` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `quantity` float DEFAULT '0',
  `itemcode` varchar(45) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eq_test`
--

LOCK TABLES `eq_test` WRITE;
/*!40000 ALTER TABLE `eq_test` DISABLE KEYS */;
INSERT INTO `eq_test` VALUES (2,0,NULL,10,'2013-07-09 21:40:34',NULL,101,'itemcode1','itemname1'),(3,10,'2013-07-09 21:40:52',0,NULL,NULL,1231,'itemcode2','itemname2');
/*!40000 ALTER TABLE `eq_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofprivacylist`
--

DROP TABLE IF EXISTS `ofprivacylist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofprivacylist` (
  `username` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `isDefault` tinyint(4) NOT NULL,
  `list` text NOT NULL,
  PRIMARY KEY (`username`,`name`),
  KEY `ofPrivacyList_default_idx` (`username`,`isDefault`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofprivacylist`
--

LOCK TABLES `ofprivacylist` WRITE;
/*!40000 ALTER TABLE `ofprivacylist` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofprivacylist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_role`
--

DROP TABLE IF EXISTS `core_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_role` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `roleName` varchar(100) DEFAULT NULL,
  `roleDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_role`
--

LOCK TABLES `core_role` WRITE;
/*!40000 ALTER TABLE `core_role` DISABLE KEYS */;
INSERT INTO `core_role` VALUES (1,0,'2011-08-27 21:03:24',0,'2011-08-27 21:03:33',NULL,'admin','管理员'),(2,0,'2011-08-27 21:03:49',0,'2012-08-23 21:41:39',NULL,'user','普通用户1'),(3,0,'2011-08-27 21:03:58',NULL,NULL,NULL,'manager','经理'),(4,0,'2012-01-12 21:03:56',NULL,NULL,NULL,'depamanager','部门经理');
/*!40000 ALTER TABLE `core_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofuserflag`
--

DROP TABLE IF EXISTS `ofuserflag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofuserflag` (
  `username` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `startTime` char(15) DEFAULT NULL,
  `endTime` char(15) DEFAULT NULL,
  PRIMARY KEY (`username`,`name`),
  KEY `ofUserFlag_sTime_idx` (`startTime`),
  KEY `ofUserFlag_eTime_idx` (`endTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofuserflag`
--

LOCK TABLES `ofuserflag` WRITE;
/*!40000 ALTER TABLE `ofuserflag` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofuserflag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_op`
--

DROP TABLE IF EXISTS `core_op`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_op` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `opName` varchar(100) DEFAULT NULL,
  `opDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_op`
--

LOCK TABLES `core_op` WRITE;
/*!40000 ALTER TABLE `core_op` DISABLE KEYS */;
INSERT INTO `core_op` VALUES (1,0,'2011-08-27 21:38:52',0,'2011-08-27 21:39:12',NULL,'core.org.edit','单位管理-增删改'),(2,0,'2011-08-27 21:39:06',NULL,NULL,NULL,'core.org.read','单位管理-浏览'),(3,0,'2011-08-27 21:39:28',NULL,NULL,NULL,'core.depa.edit','部门管理-增删改'),(4,0,'2011-08-27 21:39:36',NULL,NULL,NULL,'core.depa.read','部门管理-浏览'),(5,0,'2011-08-27 21:40:10',NULL,NULL,NULL,'core.job.edit','岗位管理-增删改'),(6,0,'2011-08-27 21:40:28',NULL,NULL,NULL,'core.job.read','岗位管理-浏览'),(7,0,'2011-08-27 21:40:47',0,'2011-09-18 21:22:49',NULL,'core.user.edit','帐号管理-增删改'),(8,0,'2011-08-27 21:40:54',NULL,NULL,NULL,'core.user.read','帐号管理-浏览'),(9,0,'2011-08-27 21:41:06',NULL,NULL,NULL,'core.role.edit','角色管理-增删改'),(10,0,'2011-08-27 21:41:14',NULL,NULL,NULL,'core.role.read','角色管理-浏览'),(11,0,'2011-08-27 21:41:44',NULL,NULL,NULL,'core.op.edit','权限管理-增删改'),(12,0,'2011-08-27 21:41:50',NULL,NULL,NULL,'core.op.read','权限管理-浏览'),(13,0,'2011-09-08 19:25:01',0,'2011-12-19 20:49:38',NULL,'helloworld',''),(14,0,'2011-10-12 18:56:51',NULL,NULL,NULL,'core.topmenu.edit','顶部菜单管理-增删改'),(15,0,'2011-10-12 18:56:59',NULL,NULL,NULL,'core.topmenu.read','顶部菜单管理-浏览'),(16,0,'2011-10-12 18:57:09',0,'2011-10-12 18:59:16',NULL,'core.leftmenu.edit','左侧菜单管理-增删改'),(17,0,'2011-10-12 18:57:22',NULL,NULL,NULL,'core.leftmenu.read','左侧菜单管理-浏览'),(18,0,'2011-10-12 18:57:46',NULL,NULL,NULL,'core.basicdata.edit','基础数据-增删改'),(19,0,'2011-10-12 18:57:53',NULL,NULL,NULL,'core.basicdata.read','基础数据-浏览'),(20,0,'2011-10-12 18:58:24',NULL,NULL,NULL,'core.log.edit','日志管理-增删改'),(21,0,'2011-10-12 18:58:31',NULL,NULL,NULL,'core.log.read','日志管理-浏览'),(22,0,'2011-10-12 18:58:52',NULL,NULL,NULL,'core.news.edit','新闻管理-增删改'),(23,0,'2011-10-12 18:58:59',NULL,NULL,NULL,'core.news.read','新闻管理-浏览'),(24,0,'2011-10-12 19:10:23',NULL,NULL,NULL,'core.op.admin','权限管理-权限设置'),(25,0,'2011-11-04 19:13:52',NULL,NULL,NULL,'core.ballot.edit','抽签管理-增删改'),(26,0,'2011-11-04 19:14:08',NULL,NULL,NULL,'core.ballot.read','比赛抽签-浏览'),(28,0,'2011-12-20 19:33:34',0,'2012-04-03 15:47:58',NULL,'form.11.user','会议室申请-表单记录创建者'),(29,0,'2011-12-20 19:33:34',0,'2012-04-03 15:47:58',NULL,'form.11.admin','会议室申请-表单管理员'),(32,0,'2011-12-20 19:34:15',0,'2012-03-24 07:17:53',NULL,'form.11.view.1.read','会议室申请-默认视图-浏览'),(33,0,'2011-12-23 13:49:53',NULL,NULL,NULL,'isAdmin','系统管理员'),(34,0,'2012-01-02 19:53:01',NULL,NULL,NULL,'form.11.view.2.read','会议室申请-只读-浏览'),(36,0,'2012-01-02 20:15:25',0,'2012-10-12 20:16:05',NULL,'form.11.view.3.read','会议室申请-经理审批-浏览'),(38,0,'2012-01-02 20:15:28',NULL,NULL,NULL,'form.11.view.4.read','会议室申请-总经理审批-浏览'),(40,0,'2012-03-24 20:48:39',NULL,NULL,NULL,'crm.admin','客户关系管理员'),(41,0,'2012-03-24 20:48:49',NULL,NULL,NULL,'crm.user','客户关系一般用户'),(42,0,'2012-03-24 21:17:03',NULL,NULL,NULL,'crm.data.all','客户关系管理-浏览全部信息'),(43,0,'2012-05-10 20:16:02',0,'2012-10-21 21:34:46',NULL,'form.12.view.5.read','文件管理-默认视图-浏览'),(44,0,'2012-05-10 20:17:05',0,'2012-06-16 21:29:26',NULL,'form.12.user','文件管理-表单记录创建者'),(45,0,'2012-05-10 20:17:05',0,'2012-06-16 21:29:26',NULL,'form.12.admin','文件管理-表单管理员'),(46,0,'2012-07-01 20:22:27',0,'2012-11-13 20:34:28',NULL,'form.13.user','机房温湿度记录表2-表单记录创建者'),(47,0,'2012-07-01 20:22:27',0,'2012-11-13 20:34:28',NULL,'form.13.admin','机房温湿度记录表2-表单管理员'),(48,0,'2012-07-01 21:41:24',NULL,NULL,NULL,'form.13.view.6.read','机房温湿度记录表-默认视图-浏览'),(49,0,'2013-05-30 12:51:07',NULL,NULL,NULL,'form.14.user','ffff-表单记录创建者'),(50,0,'2013-05-30 12:51:07',NULL,NULL,NULL,'form.14.admin','ffff-表单管理员'),(51,0,'2013-05-30 12:53:49',NULL,NULL,NULL,'form.14.view.8.read','ffff-fffffff-浏览'),(52,0,'2013-06-05 15:18:46',0,'2013-06-05 15:18:53',NULL,'form.15.user','办公家具申请-表单记录创建者'),(53,0,'2013-06-05 15:18:46',0,'2013-06-05 15:18:53',NULL,'form.15.admin','办公家具申请-表单管理员'),(54,0,'2013-06-05 15:20:08',NULL,NULL,NULL,'form.15.view.9.read','办公家具申请-默认视图-浏览'),(55,0,'2013-06-08 13:00:57',0,'2013-06-08 14:45:52',NULL,'form.15.view.10.read','办公家具申请-ooo-浏览'),(56,0,'2013-06-16 13:42:15',0,'2013-06-16 13:44:02',NULL,'form.16.user','请假-表单记录创建者'),(57,0,'2013-06-16 13:42:15',0,'2013-06-16 13:44:02',NULL,'form.16.admin','请假-表单管理员'),(70,0,'2013-09-02 08:55:29',NULL,NULL,NULL,'form.17.user','hjjjjjjj-表单记录创建者'),(71,0,'2013-09-02 08:55:29',NULL,NULL,NULL,'form.17.admin','hjjjjjjj-表单管理员'),(72,0,'2013-09-02 08:56:37',NULL,NULL,NULL,'form.17.view.11.read','hjjjjjjj-jjjjjjj-浏览');
/*!40000 ALTER TABLE `core_op` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofuserprop`
--

DROP TABLE IF EXISTS `ofuserprop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofuserprop` (
  `username` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY (`username`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofuserprop`
--

LOCK TABLES `ofuserprop` WRITE;
/*!40000 ALTER TABLE `ofuserprop` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofuserprop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_message_list`
--

DROP TABLE IF EXISTS `core_message_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_message_list` (
  `ID_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CID_` int(10) unsigned DEFAULT NULL,
  `CDATE_` datetime DEFAULT NULL,
  `MID_` int(10) unsigned DEFAULT NULL,
  `MDATE_` datetime DEFAULT NULL,
  `UUID_` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `displayName` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobilePhone` varchar(45) DEFAULT NULL,
  `subject` varchar(450) DEFAULT NULL,
  `htmlContent` varchar(2000) DEFAULT NULL,
  `textContent` varchar(2000) DEFAULT NULL,
  `sended` char(1) DEFAULT 'N',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_message_list`
--

LOCK TABLES `core_message_list` WRITE;
/*!40000 ALTER TABLE `core_message_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `core_message_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofmucserviceprop`
--

DROP TABLE IF EXISTS `ofmucserviceprop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ofmucserviceprop` (
  `serviceID` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
  PRIMARY KEY (`serviceID`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofmucserviceprop`
--

LOCK TABLES `ofmucserviceprop` WRITE;
/*!40000 ALTER TABLE `ofmucserviceprop` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofmucserviceprop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_coder`
--

DROP TABLE IF EXISTS `core_coder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_coder` (
  `ID_` int(11) NOT NULL AUTO_INCREMENT,
  `formName` varchar(45) DEFAULT NULL,
  `formText` varchar(45) DEFAULT NULL,
  `tableName` varchar(45) DEFAULT NULL,
  `className` varchar(45) DEFAULT NULL,
  `package` varchar(45) DEFAULT NULL,
  `page` varchar(450) DEFAULT NULL,
  `processDefId` varchar(45) DEFAULT NULL,
  `attachment` char(1) DEFAULT 'N',
  `dataReadOp` varchar(45) DEFAULT NULL,
  `dataWriteOp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_coder`
--

LOCK TABLES `core_coder` WRITE;
/*!40000 ALTER TABLE `core_coder` DISABLE KEYS */;
INSERT INTO `core_coder` VALUES (3,'eqTest','开发测试','eq_test','EqTest','org.minioa.core','Y','0','N','1','1');
/*!40000 ALTER TABLE `core_coder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `core_form_view_v`
--

/*!50001 DROP TABLE IF EXISTS `core_form_view_v`*/;
/*!50001 DROP VIEW IF EXISTS `core_form_view_v`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `core_form_view_v` AS select concat('formview',`ta`.`ID_`,'.jsf?formId=',`tb`.`ID_`) AS `concat('formview',ta.ID_,'.jsf')`,concat(`tb`.`formName`,'-',`ta`.`viewName`) AS `concat(tb.formName,'-', ta.viewName)` from (`core_form_view` `ta` left join `core_form` `tb` on((`tb`.`ID_` = `ta`.`formId`))) order by convert(`tb`.`formName` using gbk),convert(`ta`.`viewName` using gbk) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Dumping events for database 'oa'
--

--
-- Dumping routines for database 'oa'
--
/*!50003 DROP FUNCTION IF EXISTS `core_department_fullname` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_department_fullname`(id int) RETURNS varchar(255) CHARSET utf8
BEGIN
    declare tId int;
    declare tName varchar(300) charset 'utf8';
    declare tStr varchar(300) charset 'utf8';
   
    set tName = '';
    -- 6 level
    SELECT parentId, depaName into tId, tStr FROM `oa`.`core_department` where ID_ = id;
    set tName = tStr;
    if tId > 0 then 
        SELECT parentId, depaName into tId, tStr FROM `oa`.`core_department` where ID_ = tId;
        set tName = concat(tStr,'-',tName);
        if tId > 0 then
            SELECT parentId, depaName into tId, tStr FROM `oa`.`core_department` where ID_ = tId;
            set tName = concat(tStr,'-',tName);
            if tId > 0 then
                SELECT parentId, depaName into tId, tStr FROM `oa`.`core_department` where ID_ = tId;
                set tName = concat(tStr,'-',tName);
                if tId > 0 then
                    SELECT parentId, depaName into tId, tStr FROM `oa`.`core_department` where ID_ = tId;
                    set tName = concat(tStr,'-',tName);
                    if tId > 0 then
                        SELECT parentId, depaName into tId, tStr FROM `oa`.`core_department` where ID_ = tId;
                        set tName = concat(tStr,'-',tName);
                    end if;
                end if;
            end if;
        end if;
    end if;
    SELECT orgId into tId FROM `oa`.`core_department` where ID_ = id;
    SELECT orgName into tStr FROM `oa`.`core_org` where ID_ = tId;
    set tName = concat(tStr,'-',tName);
    return tName;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_getmanager_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_getmanager_f`(processId int) RETURNS int(11)
BEGIN
  -- Get the immediate superior
  DECLARE jobId int;
  DECLARE managerJobId int;
  DECLARE userId int;
  
  select ifnull((select pro.jobId from core_process pro where pro.ID_ = processId),0) into jobId from dual;
  IF jobId > 0 THEN
  	 set userId = core_getparentjob_f(jobId,1,1);
  END IF;
  return(userId);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_getparentjob_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_getparentjob_f`(jobId int, xtype int, userId int) RETURNS int(11)
begin
    DECLARE parentJobId int;
    DECLARE tc int;
    SET @@max_sp_recursion_depth = 25; 
    set parentJobId = 0;
    -- Get the parent job id
    select parentId into parentJobId from core_job ta where ta.ID_ = jobId;
    -- Get the manager
    if xtype = 1 then
        set tc = 0;
        select count(*) into tc from core_job ta where ta.ID_ = parentJobId and ta.isManager = 1;
        -- No.1
        if tc = 0 and parentJobId > 0 then
            select parentId into parentJobId from core_job ta where ta.ID_ = parentJobId;
            select count(*) into tc from core_job ta where ta.ID_ = parentJobId and ta.isManager = 1;
            -- No.2
            if tc = 0 and parentJobId > 0 then
                select parentId into parentJobId from core_job ta where ta.ID_ = parentJobId;
                select count(*) into tc from core_job ta where ta.ID_ = parentJobId and ta.isManager = 1;
                -- No.3
                if tc = 0 and parentJobId > 0 then
                    select parentId into parentJobId from core_job ta where ta.ID_ = parentJobId;
                    select count(*) into tc from core_job ta where ta.ID_ = parentJobId and ta.isManager = 1;
                    -- No.4
                    if tc = 0 and parentJobId > 0 then
                        select parentId into parentJobId from core_job ta where ta.ID_ = parentJobId;
                        select count(*) into tc from core_job ta where ta.ID_ = parentJobId and ta.isManager = 1;
                        -- No.5
                        if tc = 0 and parentJobId > 0 then
                            select parentId into parentJobId from core_job ta where ta.ID_ = parentJobId;
                            select count(*) into tc from core_job ta where ta.ID_ = parentJobId and ta.isManager = 1;
                            -- No.6
                            if tc = 0 and parentJobId > 0 then
                                select parentId into parentJobId from core_job ta where ta.ID_ = parentJobId;
                                select count(*) into tc from core_job ta where ta.ID_ = parentJobId and ta.isManager = 1;
                                -- No.7
                                if tc = 0 and parentJobId > 0 then
                                    select parentId into parentJobId from core_job ta where ta.ID_ = parentJobId;
                                    select count(*) into tc from core_job ta where ta.ID_ = parentJobId and ta.isManager = 1;
                                    -- No.8
                                    if tc = 0 and parentJobId > 0 then
                                        select parentId into parentJobId from core_job ta where ta.ID_ = parentJobId;
                                    end if; 
                                end if; 
                            end if; 
                        end if; 
                    end if; 
                end if; 
            end if; 
        end if;
    end if;
    if userId = 1 then
        -- return the job user id
        select ifnull((SELECT tb.ID_ from core_user tb where tb.jobId = parentJobId or tb.jobId2 = parentJobId limit 1),0) into parentJobId from dual;
    end if;
    RETURN(parentJobId);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_getsuperior_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_getsuperior_f`(processId int) RETURNS int(11)
BEGIN
  -- Get the immediate superior
  DECLARE jobId int;
  DECLARE superiorJobId int;
  DECLARE userId int;
  
  select ifnull((select pro.jobId from core_process pro where pro.ID_ = processId),0) into jobId from dual;
  IF jobId > 0 THEN
  	 set userId = core_getparentjob_f(jobId,0,1);
  END IF;
  return(userId);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_gettaskagentid_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_gettaskagentid_f`(taskId int, xtype int) RETURNS varchar(100) CHARSET utf8
BEGIN
    /*
    xtype 0 表示 返回ids, 返回names
    */
    declare ids varchar(45);
    declare displaynames varchar(100);
    declare taskDefId int;
    
    declare agentId int;
		set agentId = 0;
    
    set ids = '0';
    if taskId = 0 then 
        return ids;
    end if;

    select ta.agentId into agentId from core_task_agent ta
        where ta.taskId = taskId and sysDate() between ta.startDate and ta.endDate limit 1;
    if agentId = 0 then
        select ta.taskDefId into taskDefId from core_task ta where ta.ID_ = taskId;
        select ta.agentId into agentId from core_task_agent ta
            where ta.taskDefId = taskDefId and sysDate() between ta.startDate and ta.endDate limit 1;
    end if;
    
    if agentId > 0 then
        set ids = cast(agentId as char(45));
        select displayName into displaynames from core_user where ID_ = agentId;
    end if;

    if xtype = 0 then
        return(ids);
    end if;
    return(displaynames);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_gettaskapproverids_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_gettaskapproverids_f`(taskId int, xtype int) RETURNS varchar(100) CHARSET utf8
BEGIN
    /**
    0 指派给人
    1 指派给角色
    2 申请人上级
    3 申请人经理
    4 申请人本人
    5 指派给岗位
    9 自由审批
    xtype 0 表示 返回ids, 返回names
    */
    declare ids varchar(45);
    declare displaynames varchar(100);
    declare tempId int;
    
		declare processId int;
    declare taskDefId int;
    declare processDefId int;
    declare taskDefCode varchar(45);
    declare taskApproveType int;
    declare taskApproverId int;
    declare taskApproverRoleId int;
    
    declare tc int;
    
    set ids = '';
    set displaynames = '';

    select ta.processId, ta.taskDefId into processId, taskDefId from core_task ta where ta.ID_ = taskId;
    select ta.headerId,ta.taskApproveType,ta.taskApproverId,ta.taskApproverRoleId,ta.taskCode into
        processDefId, taskApproveType, taskApproverId, taskApproverRoleId, taskDefCode
    from core_processdefinition_task ta where ta.ID_ = taskDefId;
    
    select count(*) into tc from core_task where ID_ = taskId and taskStatus = 'agree';
    if tc = 1 then
        select approverId into taskApproverId from core_task where ID_ = taskId;
        set ids = cast(taskApproverId as char(45));
        select displayName into displaynames from core_user where ID_ = taskApproverId;
    end if;
    if tc = 0 then
        if taskApproveType = 0 then
            set ids = cast(taskApproverId as char(45));
            select displayName into displaynames from core_user where ID_ = taskApproverId;
        end if;
        if taskApproveType = 1 then
            set ids = core_getuseridsbyroleid_f(taskApproverRoleId,0);
            set displaynames = core_getuseridsbyroleid_f(taskApproverRoleId,1);
        end if;
        -- 申请人上级
        if taskApproveType = 2 then
            select core_getsuperior_f(ta.ID_) into tempId from core_process ta where ta.ID_ = processId;
            set ids = cast(tempId as char(45));
            select displayName into displaynames from core_user where ID_ = tempId;
        end if;
        -- 申请人经理
        if taskApproveType = 3 then
            select core_getmanager_f(ta.ID_) into tempId from core_process ta where ta.ID_ = processId;
            set ids = cast(tempId as char(45));
            select displayName into displaynames from core_user where ID_ = tempId;
        end if;
        -- 申请人本人
        if taskApproveType = 4 then
            SELECT ta.CID_ into tempId FROM core_process ta where ta.ID_ = processId;
            set ids = cast(tempId as char(45));
            select displayName into displaynames from core_user where ID_ = tempId;
        end if;
    
        -- 指派给岗位
        if taskApproveType = 5 then
            SELECT ta.jobId into tempId FROM core_process ta where ta.ID_ = processId;
            set ids = core_getuseridsbyjobid_f(tempId, 0);
            set displaynames = core_getuseridsbyjobid_f(tempId, 1);
        end if;
        -- 自由审批
        if taskApproveType = 9 then
            SELECT ifnull(ta.CID_,0) into tempId FROM core_task ta where ta.ID_ = taskId;
            set ids = cast(tempId as char(45));
            select displayName into displaynames from core_user where ID_ = tempId;
        end if;
    end if;

    if xtype = 0 then
        return(concat(',',ids,','));
    end if;
    return(concat(',',displaynames,','));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_getuseridsbyjobid_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_getuseridsbyjobid_f`(jId int, xtype int) RETURNS varchar(100) CHARSET utf8
BEGIN
    declare ids varchar(100);
    declare displaynames varchar(100);
    declare str varchar(45);
    declare uId int;
    declare stop int default 0;
    declare cur cursor for(SELECT ID_ FROM core_user where jobId = jId or jobId2 = jId);
    declare CONTINUE HANDLER FOR SQLSTATE '02000' SET stop=1;
    set ids = '';
    set displaynames = '';
    OPEN cur;
    FETCH cur INTO uId;
    WHILE stop <> 1 DO
        set ids = concat(ids,',',cast(uId as char(10)));
        select displayName into str from core_user where ID_ = uId;
        set displaynames = concat(displaynames,',',str);
        FETCH cur INTO uId;
    END WHILE;
    CLOSE cur;
    if xtype = 0 then
        return(ids);
    end if;
    return(displaynames);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_getuseridsbyroleid_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_getuseridsbyroleid_f`(rId int, xtype int) RETURNS varchar(100) CHARSET utf8
BEGIN
    declare ids varchar(100);
    declare displaynames varchar(100);
    declare str varchar(45);
    declare uId int;
    declare stop int default 0;
    declare cur cursor for(SELECT userId FROM core_role_user_relation where roleId = rId);
    declare CONTINUE HANDLER FOR SQLSTATE '02000' SET stop=1;
    set ids = '';
    set displaynames = '';
    OPEN cur;
    FETCH cur INTO uId;
    WHILE stop <> 1 DO
        set ids = concat(ids,',',cast(uId as char(10)));
        select displayName into str from core_user where ID_ = uId;
        set displaynames = concat(displaynames,',',str);
        FETCH cur INTO uId;
    END WHILE;
    CLOSE cur;
    if xtype = 0 then
        return(ids);
    end if;
    return(displaynames);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_iscolleague` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_iscolleague`(userid int, userid2 int, level int) RETURNS int(11)
BEGIN
		DECLARE result int;
    DECLARE depaId int;
    DECLARE parentId int;
    DECLARE i int;
    set result = 0;

    select ta.depaId into depaId from core_user ta where ta.ID_ = userid;
    select count(*) into result from core_user ta where ta.ID_ = userid2 and (ta.depaId = depaId);
    IF result > 0 THEN
    	return result;
    END IF;
    IF result = 0 AND depaId > 0 THEN
    	set i = level-1;
    	label1: LOOP
        IF i < 0 THEN
    			leave label1;
    		END IF;
    		select ta.parentId into parentId from core_department ta where ta.ID_ = depaId;
    		select count(*) into result from core_user ta where ta.ID_ = userid2 and (ta.depaId = depaId);
    		IF result > 0 THEN
    			leave label1;
    		END IF;
    		set depaId = parentId;
    		IF depaId = 0 THEN
    			leave label1;
    		END IF;
    		set i = i - 1;
    	END LOOP;
    END IF;
    return result;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_iscolleague_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_iscolleague_f`(userid int, userid2 int) RETURNS int(11)
BEGIN
		DECLARE tc int;
    DECLARE depaId int;
    DECLARE parentDepaId int;
    set tc = 0;

    select ta.depaId into depaId from core_user ta where ta.ID_ = userid;
    select count(*) into tc from core_user ta where ta.ID_ = userid2 and ta.depaId = depaId;
    if tc = 0 and depaId > 0 then
        -- No.2
        select tb.parentId into parentDepaId from core_department tb where ID_ = depaId;
        select count(*) into tc from core_user ta where ta.ID_ = userid2 and ta.depaId = parentDepaId;
        if tc = 0 and parentDepaId > 0 then
            -- No.3
            select tb.parentId into parentDepaId from core_department tb where ID_ = parentDepaId;
            select count(*) into tc from core_user ta where ta.ID_ = userid2 and ta.depaId = parentDepaId;
            if tc = 0 and parentDepaId > 0 then
                -- No.4
                select tb.parentId into parentDepaId from core_department tb where ID_ = parentDepaId;
                select count(*) into tc from core_user ta where ta.ID_ = userid2 and ta.depaId = parentDepaId;
                if tc = 0 and parentDepaId > 0 then
                    -- No.5
                    select tb.parentId into parentDepaId from core_department tb where ID_ = parentDepaId;
                    select count(*) into tc from core_user ta where ta.ID_ = userid2 and ta.depaId = parentDepaId;
                    if tc = 0 and parentDepaId > 0 then
                        -- No.6
                        select tb.parentId into parentDepaId from core_department tb where ID_ = parentDepaId;
                        select count(*) into tc from core_user ta where ta.ID_ = userid2 and ta.depaId = parentDepaId;
                        if tc = 0 and parentDepaId > 0 then
                            -- No.7
                            select tb.parentId into parentDepaId from core_department tb where ID_ = parentDepaId;
                            select count(*) into tc from core_user ta where ta.ID_ = userid2 and ta.depaId = parentDepaId;
                            if tc = 0 and parentDepaId > 0 then
                                -- No.8
                                select tb.parentId into parentDepaId from core_department tb where ID_ = parentDepaId;
                                select count(*) into tc from core_user ta where ta.ID_ = userid2 and ta.depaId = parentDepaId;
                            end if;
                        end if;
                    end if;
                end if;
            end if;
        end if;
    end if;
    return tc;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_issuperior` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_issuperior`(userid int, userid2 int, level int) RETURNS int(11)
BEGIN
		DECLARE result int;
    DECLARE jobId int;
    DECLARE jobId2 int;
    DECLARE parentId int;
    DECLARE i int;
    set result = 0;

    select ta.jobId,ta.jobId2 into jobId,jobId2 from core_user ta where ta.ID_ = userid;
    IF jobId > 0 THEN
    	set i = level-1;
    	label1: LOOP
    		select tb.parentId into parentId from core_job tb where tb.ID_ = jobId;
    		select count(*) into result from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentId or ta.jobId2 = parentId);
    		IF result > 0 THEN
    			leave label1;
    		END IF;
    		set jobId = parentId;
    		IF jobId = 0 or i < 1 THEN
    			leave label1;
    		END IF;
    		set i = i - 1;
    	END LOOP;
    END IF;
    IF result=0 AND jobId2 > 0 THEN
    	set i = level-1;
    	label1: LOOP
    		select tb.parentId into parentId from core_job tb where tb.ID_ = jobId2;
    		select count(*) into result from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentId or ta.jobId2 = parentId);
    		IF result > 0 THEN
    			leave label1;
    		END IF;
    		set jobId2 = parentId;
    		IF jobId2 = 0 or i < 1 THEN
    			leave label1;
    		END IF;
    		set i = i - 1;
    	END LOOP;
    END IF;
    return result;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_issuperior_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_issuperior_f`(userid int, userid2 int) RETURNS int(11)
BEGIN
		DECLARE tc int;
    DECLARE jobId int;
    DECLARE jobId2 int;
    DECLARE parentJobId int;
    set tc = 0;

    select ta.jobId,ta.jobId2 into jobId,jobId2 from core_user ta where ta.ID_ = userid;
    IF jobId > 0 THEN
        -- No.1
        select tb.parentId into parentJobId from core_job tb where tb.ID_ = jobId;
        select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
        if tc = 0  and parentJobId > 0 then
            -- No.2
            select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
            select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
            if tc = 0  and parentJobId > 0 then
                -- No.3
                select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                if tc = 0  and parentJobId > 0 then
                    -- No.4
                    select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                    select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                    if tc = 0  and parentJobId > 0 then
                        -- No.5
                        select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                        select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                        if tc = 0  and parentJobId > 0 then
                            -- No.6
                            select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                            select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = paparentJobIdrentId);
                            if tc = 0  and parentJobId > 0 then
                                -- No.7
                                select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                                select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                                if tc = 0  and parentJobId > 0 then
                                    -- No.7
                                    select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                                    select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                                end if;
                            end if;
                        end if;
                    end if;
                end if;
            end if;
        end if;
    END IF;
    IF tc=0 AND jobId2 > 0 THEN
        select tb.parentId into parentJobId from core_job tb where tb.ID_ = jobId2;
        select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
        if tc = 0  and parentJobId > 0 then
            -- No.2
            select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
            select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
            if tc = 0  and parentJobId > 0 then
                -- No.3
                select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                if tc = 0  and parentJobId > 0 then
                    -- No.4
                    select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                    select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                    if tc = 0  and parentJobId > 0 then
                        -- No.5
                        select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                        select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                        if tc = 0  and parentJobId > 0 then
                            -- No.6
                            select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                            select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = paparentJobIdrentId);
                            if tc = 0  and parentJobId > 0 then
                                -- No.7
                                select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                                select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                                if tc = 0  and parentJobId > 0 then
                                    -- No.8
                                    select tb.parentId into parentJobId from core_job tb where tb.ID_ = parentJobId;
                                    select count(*) into tc from core_user ta where ta.ID_ = userid2 and (ta.jobId = parentJobId or ta.jobId2 = parentJobId);
                                end if;
                            end if;
                        end if;
                    end if;
                end if;
            end if;
        end if;
    END IF;
    return tc;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_task_getalltaskcount_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_task_getalltaskcount_f`(pDefId int, pId int) RETURNS int(11)
BEGIN
    DECLARE tId int;
    DECLARE tc int;
    select count(*) into tc from core_task ta
    left join core_processdefinition_task tb on tb.ID_ =ta.taskDefId 
    where tb.headerId = pDefId and processId  = pId and ta.taskStatus = 'running' and tb.taskType = 1;
return tc;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `core_task_getsubtaskcount_f` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `core_task_getsubtaskcount_f`(pDefId int,taskDefCode varchar(10),pId int) RETURNS int(11)
BEGIN
    DECLARE tId int;
    DECLARE tc int;
    select max(ta.ID_) into tId from core_task ta
    left join core_processdefinition_task tb on tb.ID_ =ta.taskDefId 
    where tb.taskCode =taskDefCode and tb.headerId = pDefId and processId  = pId;
    select count(*) into tc from core_task where taskFrom = tId and taskStatus = 'running';
return tc;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `crm_customer_hassubitems` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `crm_customer_hassubitems`(uuid char(255)) RETURNS int(11)
BEGIN
    declare tc int;
    declare result int;
    set result = 1;
    select count(*) into tc from crm_visit where UUID_ = uuid;
    if tc = 0 then
    	select count(*) into tc from crm_record where UUID_ = uuid;
    	if tc = 0 then
    		select count(*) into tc from crm_customer_attachment where UUID_ = uuid;
    		if tc = 0 then
    			select count(*) into tc from crm_contact where UUID_ = uuid;
    			if tc = 0 then
    				set result = 0;
    			end if;
    		end if;
    	end if;
    end if;
    return result;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_ballot_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_ballot_update`(in hId int)
BEGIN
	declare tc int;
	declare tc2 int;
	select count(*) into tc from core_ballot_items where headerId = hId;
	select count(*) into tc2 from core_ballot_items where headerId = hId and orderNum > 0;
  if tc = tc2 then
  	update core_ballot set status_ = 2 where ID_ = hId;
  end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_delete_form_p` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_delete_form_p`(in id int)
BEGIN
	delete from core_form_view_field
	where viewId in (select ID_ from core_form_view where formId = id);
	delete from core_form_view where formId = id;
	delete from core_op_role_relation
	where opId in (select ID_ from core_op where opName like concat('form.', cast(id as char(10)), '.%'));
	delete from core_op where opName like concat('form.', cast(id as char(10)), '.%');
	delete from core_form where ID_ = id;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_delete_form_view_p` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_delete_form_view_p`(in id int)
BEGIN
	delete from core_op_role_relation	where opId in (select ID_ from core_op where opName like concat('%view.',CAST(id as char(10)),'.%'));
	delete from core_op where opName like concat('%view.',CAST(id as char(10)),'.%');
	delete from core_form_view_field where viewId = id;
	delete from core_form_view where ID_ = id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_delete_leftmenu_p` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_delete_leftmenu_p`(in id int)
BEGIN
	delete from core_leftmenu_role_relation where menuId = id;
  delete from core_leftmenu where ID_ = id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_delete_op_p` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_delete_op_p`(in id int)
BEGIN
	delete from core_op_role_relation where opId = id;
  delete from core_op where ID_ = id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_delete_process_p` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_delete_process_p`(in pId int)
BEGIN
	delete from core_task_approvers where taskId in (select ID_ from core_task where processId = pId);
	delete from core_task_agent where taskId in (select ID_ from core_task where processId = pId);
	
	delete from core_task where processId = pId;
  delete from core_process where ID_ = pId;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_delete_role_p` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_delete_role_p`(in id int)
BEGIN
	delete from core_op_role_relation where roleId = id;
	delete from core_leftmenu_role_relation where roleId = id;
	delete from core_topmenu_role_relation where roleId = id;
	delete from core_role_user_relation where roleId = id;
  delete from core_role where ID_ = id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_delete_topmenu_p` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_delete_topmenu_p`(in id int)
BEGIN
	delete from core_topmenu_role_relation where menuId = id;
  delete from core_topmenu where ID_ = id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_delete_user_p` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_delete_user_p`(in id int)
BEGIN
	delete from core_role_user_relation where userId = id;
  delete from core_user where ID_ = id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_getlasttaskstatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_getlasttaskstatus`(in processdefid int,in taskdefcode varchar(10),in processid int)
BEGIN
  DECLARE taskdefid int;
  select taskdef.id_ into taskdefid from core_processdefinition_task taskdef where taskdef.headerId = processdefid and taskdef.taskcode = taskdefcode;
  select ifnull((SELECT task.taskstatus FROM core_task task where task.processid = processid and task.taskdefid= taskdefid order by task.id_ desc limit 1),'') from dual;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_getmanager` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_getmanager`(in processId int)
BEGIN
  DECLARE jobId int;
  DECLARE isManager int;
  DECLARE superiorJobId int;
  DECLARE userId int;
  select ifnull((select pro.jobId from core_process pro where pro.ID_ = processId),0) into jobId from dual;
  IF jobId > 0 THEN
  	 select ifnull((select ta.parentId from core_job ta where ta.ID_ = jobId),0) into superiorJobId from dual;
  	 IF superiorJobId > 0 THEN
  	 	select ta.isManager into isManager from core_job ta where ta.ID_ = superiorJobId;
  	 	IF isManager=0 THEN
  	 		select ifnull((select ta.parentId from core_job ta where ta.ID_ = superiorJobId),0) into superiorJobId from dual;
  	 		IF superiorJobId > 0 THEN
  	 			select ta.isManager into isManager from core_job ta where ta.ID_ = superiorJobId;
  	 			if isManager=0 then
  	 		    select ifnull((select ta.parentId from core_job ta where ta.ID_ = superiorJobId),0) into superiorJobId from dual;
  	 		    IF superiorJobId > 0 THEN
  	 			    select ta.isManager into isManager from core_job ta where ta.ID_ = superiorJobId;
  	 			    if isManager=0 then
  	 		        select ifnull((select ta.parentId from core_job ta where ta.ID_ = superiorJobId),0) into superiorJobId from dual;
  	 		        IF superiorJobId > 0 THEN
  	 			        select ta.isManager into isManager from core_job ta where ta.ID_ = superiorJobId;
  	 			        if isManager=0 then
                    set superiorJobId = 0;
  	 			        end if;
  	 		        end if;
  	 		  	  end if;
  	 		    end if;
  	 			end if;
  	 		end if;
  	 	END IF;
  	 	select ifnull((SELECT tb.ID_ from core_user tb where tb.jobId = superiorJobId or tb.jobId2 = superiorJobId limit 1),'') into userId from dual;
  	 	select userId;
  	 END IF;
  else
    select 0;
  END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_getsuperior` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_getsuperior`(in processId int)
BEGIN
  DECLARE jobId int;
  DECLARE superiorJobId int;
  DECLARE userId int;
  select ifnull((select pro.jobId from core_process pro where pro.ID_ = processId),0) into jobId from dual;
  IF jobId > 0 THEN
  	 select ifnull((select ta.parentId from core_job ta where ta.ID_ = jobId),0) into superiorJobId from dual;
  	 IF superiorJobId > 0 THEN
  	 	select ifnull((SELECT tb.ID_ from core_user tb where tb.jobId = superiorJobId or tb.jobId2 = superiorJobId limit 1),'') into userId from dual;
  	 END IF;
else

select "";
  END IF;
select userId;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_of_delete_group` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_of_delete_group`(in dId int)
BEGIN
    delete from ofgroupuser where groupName = dId;
    delete from ofgroupprop where groupName = dId;
    delete from ofgroup where groupName = dId;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_of_delete_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_of_delete_user`(in id int)
BEGIN
    DECLARE uname varchar(30);
    DECLARE hostname varchar(30);
    SELECT concat('@',propValue) into hostname FROM ofproperty where name='xmpp.domain';
    select username into uname from core_user where ID_ = id;
    delete from ofgroupuser where username = uname;
    delete from ofrostergroups where rosterId in (select rosterId from ofroster where username = uname or jid = concat(uname,hostname));
    delete from ofroster where username = uname;
    delete from ofuser where username = uname;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_of_update_group` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_of_update_group`(in dId int)
BEGIN
    DECLARE i int;
    DECLARE id int;
    DECLARE tc int;
    DECLARE tc2 int;
    -- 错误类型标记
    DECLARE flag int;
    -- 部门全称
    DECLARE dname varchar(255) charset 'utf8';
    -- 主机名
    DECLARE hostname varchar(30);
    -- 取得当前部门所有rosterId
    DECLARE cur1 CURSOR FOR SELECT ta.rosterId FROM ofroster ta left join core_user tb on concat(tb.userName,hostname) = ta.jid where tb.depaId =dId;
    -- 错误处理
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET flag = 3;
    -- 主机名
    SELECT concat('@',propValue) into hostname FROM ofproperty where name='xmpp.domain';
    -- 检测部门是否存在
    select count(*) into tc from ofgroup where groupName= dId;
    -- 取得当前部门所有rosterId的总数
    SELECT count(*) into tc2 FROM ofroster ta left join core_user tb on concat(tb.userName,hostname) = ta.jid where tb.depaId =dId;
    -- 部门全称
    select core_department_fullname(dId)  into dname from dual;
    IF tc > 0 THEN
        -- 如果部门已经存在就直接更新部门名称
        update ofgroup set description = dname where groupName = dId;
    ELSE
        -- 如果部门不存在，就创建部门
        insert into ofgroup (groupName,description) values(dId,dname);
        delete from ofgroupprop where groupName=dId;
        insert into ofgroupprop(groupName,name,propValue) values(dId,'sharedRoster.showInRoster','nobody');
        insert into ofgroupprop(groupName,name,propValue) values(dId,'sharedRoster.displayName','');
        insert into ofgroupprop(groupName,name,propValue) values(dId,'sharedRoster.groupList','');
    END IF;
    -- 循环更新roster组的名称
    SET i=1;
    OPEN cur1;
    read_loop: LOOP
        -- 取得rosterId
        FETCH cur1 INTO id;
        -- 更新一个空记录
        update temp set tmptext='1';
        -- 退出循环
        IF i > tc2 THEN
            LEAVE read_loop;
        ELSE
            update ofrostergroups set groupName=dname where rosterId= id;
        END IF;
        SET i=i+1;
    END LOOP;
    CLOSE cur1;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_of_update_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_of_update_user`(in uname varchar(300), in passwd varchar(300))
BEGIN
DECLARE i int;
    DECLARE id int;
    DECLARE tc int;
    DECLARE tc2 int;
    -- 错误处理
    DECLARE flag int;
    DECLARE hostname varchar(30);
    DECLARE nickname varchar(255) charset 'utf8';
    DECLARE dId int;
    DECLARE mail varchar(30);
    DECLARE dname varchar(255) charset 'utf8';
    DECLARE str varchar(30);
    DECLARE cur1 CURSOR FOR SELECT username FROM ofuser WHERE username != uname;
    DECLARE cur2 CURSOR FOR SELECT ta.jid,ta.rosterId FROM ofroster ta,ofrostergroups tb WHERE ta.rosterId = tb.rosterId and tb.groupName = 'Friend';
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET flag = 3;
    
    SELECT count(*) into tc FROM ofuser where username=uname;
    SELECT concat('@',propValue) into hostname FROM ofproperty where name='xmpp.domain';
    SELECT displayName,email,depaId into nickname,mail,dId FROM core_user where username=uname;
    -- 部门全称
    select core_department_fullname(dId) into dname from dual;
    IF tc > 0 THEN
        -- 如果用户存在就更新
        update ofuser set encryptedPassword=passwd, name=nickname, email=mail WHERE username = uname;
        update ofroster set nick=nickname where jid=concat(uname,hostname);
    ELSE
        -- 新增帐号
        insert into ofuser(username,encryptedPassword,name,email,creationDate,modificationDate) values(uname,passwd,nickname,mail,'001300691122503','001300691122503');
    END IF;
    -- 提取其他帐号，把当前帐号加成其他帐号的好友
    SELECT count(*) into tc FROM ofuser WHERE username != uname;
    SET i=1;
    OPEN cur1;
    read_loop: LOOP
    FETCH cur1 INTO str;
        update temp set tmptext=str;
        IF i > tc THEN
            LEAVE read_loop;
        ELSE
            insert into ofroster(username,jid,nick,sub,ask,recv) SELECT str,concat(uname,hostname),ta.name,3,-1,-1 FROM ofuser ta where ta.username=uname and not exists (select 1 from ofroster tb where tb.username=str and tb.jid=concat(uname,hostname));
        END IF;
        SET i=i+1;
    END LOOP;
    CLOSE cur1;
    -- 把其他帐号加成当前帐号的好友
    insert into ofroster(username,jid,nick,sub,ask,recv) SELECT uname,concat(ta.username,hostname),ta.name,3,-1,-1 FROM ofuser ta where not exists (select 1 from ofroster tb where tb.username = uname and tb.jid = concat(ta.username,hostname));
    insert into ofrostergroups(rosterId,rank,groupName) select ta.rosterID,0,'Friend' from ofroster ta where (ta.username=uname or ta.jid=concat(uname,hostname)) and ta.rosterID not in (select tb.rosterID from ofrostergroups tb);
    update ofrostergroups set groupName=dname where rosterId in (select rosterId from ofroster where jid=concat(uname,hostname));
    -- 更新组名为Friend的组名称
    SELECT count(*) into tc FROM ofroster ta,ofrostergroups tb WHERE ta.rosterId = tb.rosterId and tb.groupName = 'Friend';
    SET i=1;
    OPEN cur2;
    read_loop: LOOP
        FETCH cur2 INTO str,id;
        update temp set tmptext=str;
        IF i > tc THEN
            LEAVE read_loop;
        ELSE
            select depaId into dId from core_user where concat(userName,hostname) = str;
            select core_department_fullname(dId) into dname from dual;
            update ofrostergroups set groupName=dname where rosterId = id and dname is not null;
        END IF;
        SET i=i+1;
    END LOOP;
    CLOSE cur2;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_online` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_online`(in cId int, in sId varchar(45),in cTime char(15),in mTime char(15), in ipAddress varchar(30))
BEGIN
 DECLARE isexists int;
 DECLARE iskickedout int;
  SELECT count(*) into isexists FROM core_user_session where sessionId=sId;
  IF isexists > 0 THEN
  	update core_user_session set MDATE_ = mTime, CID_ = cId, ip = ipAddress where sessionId=sId and kickedout = 0;
  ELSE
    insert into core_user_session(CID_,CDATE_, sessionId, ip) values(cId, cTime, sId, ipAddress);
  END IF;

  SELECT kickedout into iskickedout FROM core_user_session where sessionId=sId;
  if iskickedout = 1 then
    select -1 from dual;
  else
    update core_user_session set kickedout = 1 where CID_ = cId and sessionId!=sId;
    select ifnull((select count(*) FROM core_user_session where kickedout = 0 and (MDATE_ + '300000') > mTime),0) from dual;
  end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_task_autocomplete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_task_autocomplete`(in processdefid varchar(10),in taskdefcode varchar(10),in processid varchar(10))
BEGIN
  DECLARE taskdefid int;
  select taskdef.id_ into taskdefid 
  from core_processdefinition_task taskdef 
  where taskdef.headerId = processdefid 
  and taskdef.taskcode = taskdefcode;
  update core_task task set task.taskStatus='auto' 
  where task.processid = processid 
  and task.taskdefid= taskdefid;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `core_task_getsubtaskcount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `core_task_getsubtaskcount`(in pDefId int,in taskDefCode varchar(10),in pId int)
BEGIN
  DECLARE tDefId int;
  DECLARE tId int;
  select ID_ into tDefId from core_processdefinition_task where processDefId = pDefId and taskCode = taskDefCode;
  select ID_ into tId from core_task where processId = pId and taskDefId = tDefId;
  if tId > 0 then
  	select count(*) from core_task where taskFrom = tId;
  else
  	select 0 from dual;
  end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-09-03 21:37:15
