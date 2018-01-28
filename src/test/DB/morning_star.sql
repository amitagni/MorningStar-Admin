-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: morningstar
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `fee_slip`
--

DROP TABLE IF EXISTS `fee_slip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_slip` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` int(8) NOT NULL,
  `fee_structure_id` int(8) NOT NULL,
  `payment_id` int(8) DEFAULT NULL,
  `month` tinyint(4) NOT NULL,
  `amount` varchar(20) NOT NULL,
  `discount` varchar(10) DEFAULT NULL,
  `created_by` int(8) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_slip`
--

LOCK TABLES `fee_slip` WRITE;
/*!40000 ALTER TABLE `fee_slip` DISABLE KEYS */;
INSERT INTO `fee_slip` VALUES (1,8,1,NULL,1,'200','0',1,'2017-03-23 08:15:07'),(2,8,2,NULL,1,'300','0',1,'2017-03-23 08:15:07'),(3,8,3,NULL,1,'400','0',1,'2017-03-23 08:15:07'),(4,1,4,NULL,1,'500','0',1,'2017-03-23 08:15:07'),(5,8,1,NULL,1,'200','0',1,'2017-03-25 07:21:37'),(6,8,2,NULL,1,'300','0',1,'2017-03-25 07:21:41'),(7,8,3,NULL,1,'400','0',1,'2017-03-25 07:21:41'),(8,1,4,NULL,1,'500','0',1,'2017-03-25 07:21:41'),(9,8,1,NULL,2,'200','0',1,'2017-03-25 07:22:53'),(10,8,2,NULL,2,'300','0',1,'2017-03-25 07:22:57'),(11,8,3,NULL,2,'400','0',1,'2017-03-25 07:22:58'),(12,1,4,NULL,2,'500','0',1,'2017-03-25 07:22:59'),(13,8,1,NULL,1,'200','0',1,'2017-03-25 07:39:39'),(14,8,2,NULL,1,'300','0',1,'2017-03-25 07:39:57'),(15,8,3,NULL,1,'400','0',1,'2017-03-25 07:40:14'),(16,1,4,NULL,1,'500','0',1,'2017-03-25 07:40:19'),(17,8,1,5,6,'200','0',1,'2017-03-26 09:55:36'),(18,8,2,5,6,'300','0',1,'2017-03-26 09:55:36'),(19,8,3,5,6,'400','0',1,'2017-03-26 09:55:36'),(20,1,4,5,6,'500','0',1,'2017-03-26 09:55:37'),(21,8,1,NULL,9,'200','0',1,'2017-03-28 07:44:46'),(22,8,2,NULL,9,'300','0',1,'2017-03-28 07:44:51'),(23,8,3,NULL,9,'400','0',1,'2017-03-28 07:44:51'),(24,8,4,NULL,9,'500','0',1,'2017-03-28 07:44:51'),(25,8,1,NULL,10,'200','0',1,'2017-03-28 07:46:14'),(26,8,2,NULL,10,'300','0',1,'2017-03-28 07:46:14'),(27,8,3,NULL,10,'400','0',1,'2017-03-28 07:46:14'),(28,8,5,NULL,10,'500','0',1,'2017-03-28 07:46:14'),(29,8,8,NULL,10,'250','0',1,'2017-03-28 07:46:14'),(30,8,1,NULL,1,'200','0',1,'2017-03-29 17:57:40'),(31,8,2,NULL,1,'300','0',1,'2017-03-29 17:57:40'),(32,8,3,NULL,1,'390','10',1,'2017-03-29 17:57:40'),(33,8,6,NULL,1,'450','10%',1,'2017-03-29 17:57:40'),(34,8,1,6,1,'200','0',1,'2017-03-29 18:00:23'),(35,8,2,6,1,'300','0',1,'2017-03-29 18:00:23'),(36,8,3,6,1,'390','10',1,'2017-03-29 18:00:23'),(37,8,6,6,1,'450','10%',1,'2017-03-29 18:00:23'),(38,8,1,NULL,2,'200','0',1,'2017-03-31 07:14:57'),(39,8,2,NULL,2,'300','0',1,'2017-03-31 07:14:57'),(40,8,3,NULL,2,'400','0',1,'2017-03-31 07:14:57'),(41,8,1,NULL,2,'200','0',1,'2017-03-31 11:13:09'),(42,8,2,NULL,2,'300','0',1,'2017-03-31 11:13:09'),(43,8,3,NULL,2,'400','0',1,'2017-03-31 11:13:09'),(44,8,1,NULL,3,'200','0',1,'2017-03-31 11:36:04'),(45,8,2,NULL,3,'300','0',1,'2017-03-31 11:36:04'),(46,8,3,NULL,3,'400','0',1,'2017-03-31 11:36:04'),(47,26,1,NULL,1,'190','10%',1,'2017-03-31 16:13:23'),(48,26,2,NULL,1,'300','0',1,'2017-03-31 16:13:23'),(49,26,3,NULL,1,'400','0',1,'2017-03-31 16:13:23'),(50,8,1,7,2,'200','0',1,'2017-03-31 16:14:52'),(51,8,2,7,2,'300','0',1,'2017-03-31 16:14:53'),(52,8,3,7,2,'400','0',1,'2017-03-31 16:14:53'),(53,15,1,NULL,1,'200','0',1,'2017-03-31 16:16:28'),(54,15,2,NULL,1,'300','0',1,'2017-03-31 16:16:28'),(55,15,3,NULL,1,'400','0',1,'2017-03-31 16:16:28'),(56,15,1,NULL,1,'200','0',1,'2017-03-31 16:16:35'),(57,15,2,NULL,1,'300','0',1,'2017-03-31 16:16:35'),(58,15,3,NULL,1,'400','0',1,'2017-03-31 16:16:35'),(59,8,1,10,3,'200','0',1,'2017-03-31 16:22:52'),(60,8,2,10,3,'300','0',1,'2017-03-31 16:22:52'),(61,8,3,10,3,'400','0',1,'2017-03-31 16:22:52'),(62,26,1,NULL,1,'200','0',1,'2017-03-31 16:34:49'),(63,26,2,NULL,1,'300','0',1,'2017-03-31 16:34:49'),(64,26,3,NULL,1,'400','0',1,'2017-03-31 16:34:49'),(65,26,1,NULL,1,'200','0',1,'2017-03-31 16:37:40'),(66,26,2,NULL,1,'300','0',1,'2017-03-31 16:37:40'),(67,26,3,NULL,1,'400','0',1,'2017-03-31 16:37:40');
/*!40000 ALTER TABLE `fee_slip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_structure`
--

DROP TABLE IF EXISTS `fee_structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_structure` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `fee_freq_type` tinyint(3) NOT NULL,
  `abbr_name` varchar(20) NOT NULL,
  `class` tinyint(3) NOT NULL,
  `session` tinyint(3) DEFAULT NULL,
  `amount` varchar(10) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_fee_struct_1` (`created_by`),
  CONSTRAINT `fk_fee_struct_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_structure`
--

LOCK TABLES `fee_structure` WRITE;
/*!40000 ALTER TABLE `fee_structure` DISABLE KEYS */;
INSERT INTO `fee_structure` VALUES (1,4,'C.F',2,1,'200',NULL,'2017-03-14 16:01:50'),(2,4,'M.F',2,1,'300',NULL,'2017-03-14 16:02:27'),(3,4,'Tution Fee',2,1,'400',NULL,'2017-03-14 16:02:50'),(4,3,'APR',2,1,'500',NULL,'2017-03-14 16:04:44'),(5,3,'AUG',2,1,'500',NULL,'2017-03-14 16:05:05'),(6,3,'OCT',2,1,'500',NULL,'2017-03-14 16:05:59'),(7,3,'DEC',2,1,'500',NULL,'2017-03-14 16:06:16'),(8,2,'DEC',2,1,'250',NULL,'2017-03-14 16:07:17'),(9,2,'FEB',2,1,'250',NULL,'2017-03-14 16:07:37'),(10,1,'FAREWELL FEE',1,1,'1000',NULL,'2017-03-14 16:09:11'),(11,1,'PRACTICAL FEE',1,1,'500',NULL,'2017-03-14 16:09:53'),(12,1,'T.C FEE',1,1,'200',NULL,'2017-03-14 16:10:20'),(13,1,'MISC',1,1,'2000',NULL,'2017-03-14 16:10:52');
/*!40000 ALTER TABLE `fee_structure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paid_fee_summary`
--

DROP TABLE IF EXISTS `paid_fee_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paid_fee_summary` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` int(8) NOT NULL,
  `session` tinyint(3) NOT NULL,
  `monthly_freq` varchar(30) DEFAULT NULL,
  `quaterly_freq` varchar(20) DEFAULT NULL,
  `halfyearly_freq` varchar(20) DEFAULT NULL,
  `annually_freq` varchar(20) DEFAULT NULL,
  `updated_by` int(8) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paid_fee_summary`
--

LOCK TABLES `paid_fee_summary` WRITE;
/*!40000 ALTER TABLE `paid_fee_summary` DISABLE KEYS */;
INSERT INTO `paid_fee_summary` VALUES (1,8,1,'9,10,1,2,3,3,3,','4,5,6,','8,','',1,'2017-03-31 16:26:19');
/*!40000 ALTER TABLE `paid_fee_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` int(8) DEFAULT NULL,
  `fee_type` tinyint(4) NOT NULL,
  `amount` varchar(20) DEFAULT NULL,
  `discount_amt` varchar(20) DEFAULT NULL,
  `payment_type` tinyint(4) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,1,1,'200',NULL,NULL,'2017-03-13 15:47:54',NULL),(2,1,1,'250',NULL,NULL,'2017-03-19 16:36:07',NULL),(3,8,1,'1400',NULL,NULL,'2017-03-26 10:01:58',NULL),(4,8,1,'1400',NULL,NULL,'2017-03-26 10:14:50',NULL),(5,8,1,'1400',NULL,NULL,'2017-03-26 10:24:49',NULL),(6,8,1,'',NULL,NULL,'2017-03-29 18:01:05',NULL),(7,8,1,'900',NULL,NULL,'2017-03-31 16:15:25',NULL),(8,8,1,'1800',NULL,NULL,'2017-03-31 16:26:18',NULL),(9,8,1,'1800',NULL,NULL,'2017-03-31 16:26:19',NULL),(10,8,1,'1800',NULL,NULL,'2017-03-31 16:26:19',NULL),(11,1,1,'',NULL,NULL,'2017-03-31 17:03:55',NULL);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_contact_info`
--

DROP TABLE IF EXISTS `student_contact_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_contact_info` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` int(8) NOT NULL,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `area` varchar(100) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `pincode` varchar(6) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_contact_info`
--

LOCK TABLES `student_contact_info` WRITE;
/*!40000 ALTER TABLE `student_contact_info` DISABLE KEYS */;
INSERT INTO `student_contact_info` VALUES (1,3,'Prateek','Nagar','Sadar','Shah',NULL,'242001','','','','2017-03-13 15:32:56',NULL),(2,4,'Prateek','Wisteria','Sec 77 ','Noida',NULL,'201301','9871286278','9871286278','arnav@gmail.com','2017-03-14 13:42:08',NULL),(3,5,'Prateek','SDAD','DSADSA','lko',NULL,'242001','9871286278','9871286278','ALOK@gmail.com','2017-03-19 16:35:26',NULL),(5,8,'I 904','Prateek Wisteria','Sec 77 ','Noida',NULL,'201301','01204974397','9871286278','arnav.agni@gmail.com','2017-03-23 07:22:19',NULL),(6,9,'Prateek','Nagar','Sec 77 ','Noida',NULL,'242001','01204974397','9871286278','ALOK@gmail.com','2017-03-29 18:53:58',NULL),(7,10,'Prateek Wisteria','Sec 77','Noida','GB Nagar',NULL,'201301','01204974397','9871286278','arnav.agni@gmail.com','2017-03-30 08:25:47',NULL),(8,11,'','','','',NULL,'','','','','2017-03-30 15:10:10',NULL),(9,12,'','','','',NULL,'','','','','2017-03-30 17:26:28',NULL),(10,13,'','','','',NULL,'','','','','2017-03-30 17:29:32',NULL),(11,14,'Prateek','Nagar','Sec 77 ','Shah',NULL,'242001','01204974397','9871286278','arnav111@gmail.com','2017-03-30 17:48:53',NULL),(12,15,'Prateek','Nagar','Sec 77 ','Shah',NULL,'242001','01204974397','666656','arnav1@gmail.com','2017-03-30 17:57:59',NULL),(13,16,'','','','',NULL,'','','','','2017-03-31 08:13:47',NULL),(14,17,'','','','',NULL,'','','','','2017-03-31 08:22:00',NULL),(15,18,'','','','',NULL,'','','','','2017-03-31 08:23:17',NULL),(16,19,'','','','',NULL,'','','','','2017-03-31 08:24:45',NULL),(17,20,'','','','',NULL,'','','','','2017-03-31 08:25:41',NULL),(18,21,'','','','',NULL,'','','','','2017-03-31 08:30:27',NULL),(19,22,'','','','',NULL,'','','','','2017-03-31 08:32:49',NULL),(20,23,'','','','',NULL,'','','','','2017-03-31 08:37:10',NULL),(21,24,'','','','',NULL,'','','','','2017-03-31 08:39:30',NULL),(22,25,'Prateek','Nagar','Sec 77 ','Shah',NULL,'242001','','','','2017-03-31 08:41:50',NULL),(23,26,'E-1204','Express Zenith','Sec 77 ','Noida',NULL,'201301','01204974397','9958107778','raghav@gmail.com','2017-03-31 16:11:23',NULL),(24,27,'','','','',NULL,'','','','','2017-03-31 17:03:03',NULL),(25,28,'','','','',NULL,'','','','','2017-03-31 17:03:40',NULL),(26,29,'','','','',NULL,'','','','','2017-03-31 17:05:25',NULL),(27,30,'','','','',NULL,'','','','','2017-03-31 17:05:41',NULL),(28,31,'','','','',NULL,'','','','','2017-03-31 17:06:26',NULL),(29,32,'','','','',NULL,'','','','','2017-03-31 17:07:09',NULL),(30,33,'','','','',NULL,'','','','','2017-03-31 17:07:59',NULL),(31,34,'','','','',NULL,'','','','','2017-03-31 17:08:27',NULL);
/*!40000 ALTER TABLE `student_contact_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_info` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `reg_id` int(8) DEFAULT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `dob` varchar(20) NOT NULL,
  `father_name` varchar(50) NOT NULL,
  `mother_name` varchar(50) NOT NULL,
  `admission_class` tinyint(3) NOT NULL,
  `current_class` tinyint(3) NOT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(8) DEFAULT NULL,
  `category` tinyint(3) DEFAULT NULL,
  `section` tinyint(3) DEFAULT NULL,
  `house` tinyint(3) DEFAULT NULL,
  `photo` varchar(500) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `religion` varchar(20) DEFAULT NULL,
  `caste` varchar(30) DEFAULT NULL,
  `tc_path` varchar(300) DEFAULT NULL,
  `dob_proof_path` varchar(300) DEFAULT NULL,
  `transport_taken` tinyint(3) DEFAULT NULL,
  `sibling_study` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` VALUES (3,8,'Amit,Agni',NULL,'3 March, 2011','B K','pushpa',0,0,NULL,'2017-03-13 15:32:56',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,'Amit','Agnihotri','1 March, 2011','Bk Agni','Pushpa Devi',0,0,NULL,'2017-03-14 13:42:07',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,9,'Alok,Bajpai,Alok,Bajpai',NULL,'1 March, 2010','aaD','SDSADF',0,0,NULL,'2017-03-19 16:35:26',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,NULL,'Arnav','Agnihotri','3 March, 2010','Amit Agnihotri','Rachna',2,2,NULL,'2017-03-23 07:22:19',1,NULL,2,2,NULL,'Indian','Hindu','Brahmin',NULL,NULL,NULL,NULL),(9,10,'Arpit,Gupta',NULL,'4 March, 2010','Aaaaa','BBBB',0,0,'M','2017-03-29 18:53:58',1,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,NULL,'Aanvi','Agni','3 March, 2010','Amit','Rachna',2,2,NULL,'2017-03-30 08:25:47',1,NULL,1,2,NULL,'Indian','Hindu','Brahmin',NULL,NULL,NULL,NULL),(11,NULL,'','','','','',1,1,NULL,'2017-03-30 15:10:10',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(12,NULL,'','','','','',1,1,NULL,'2017-03-30 17:26:28',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(13,NULL,'','','','','',1,1,NULL,'2017-03-30 17:29:32',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(14,NULL,'Aashu','Singh','','','',1,1,NULL,'2017-03-30 17:48:53',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(15,NULL,'ashutosh','Singh','','','',2,2,NULL,'2017-03-31 07:47:49',1,NULL,1,1,'15\\BTM_Logo.jpg','','','','15\\BTM_Logo.jpg',NULL,NULL,NULL),(16,NULL,'','','','','',1,1,NULL,'2017-03-31 08:13:47',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(17,NULL,'','','','','',1,1,NULL,'2017-03-31 08:22:00',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(18,NULL,'','','','','',0,0,NULL,'2017-03-31 08:23:17',1,NULL,0,0,NULL,'','','',NULL,NULL,NULL,NULL),(19,NULL,'','','','','',0,0,NULL,'2017-03-31 08:24:45',1,NULL,0,0,NULL,'','','',NULL,NULL,NULL,NULL),(20,NULL,'','','','','',1,1,NULL,'2017-03-31 08:25:41',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(21,NULL,'','','','','',1,1,NULL,'2017-03-31 08:30:27',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(22,NULL,'','','','','',1,1,NULL,'2017-03-31 08:32:49',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(23,NULL,'','','','','',1,1,NULL,'2017-03-31 08:37:19',1,NULL,1,1,'23\\BTM_Logo.jpg','','','',NULL,NULL,NULL,NULL),(24,NULL,'','','','','',1,1,NULL,'2017-03-31 08:39:30',1,NULL,1,1,'24\\BTM_Logo.jpg','','','',NULL,NULL,NULL,NULL),(25,NULL,'Abhay','Singh','26 March, 2010','BBBB','AAAAA',2,2,NULL,'2017-03-31 08:41:50',1,NULL,2,2,'25\\BTM_Logo.jpg','','Hindu','Brahmin',NULL,NULL,NULL,NULL),(26,NULL,'Raghav','Bajpai','3 March, 2015','Alok','Shilpi',2,2,'M','2017-03-31 16:11:23',1,NULL,2,2,NULL,'Indian','Hindu','Brahmin',NULL,NULL,NULL,NULL),(27,11,',',NULL,'','','',0,0,NULL,'2017-03-31 17:03:03',1,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,12,',',NULL,'','','',0,0,NULL,'2017-03-31 17:03:40',1,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,NULL,'','','','','',1,1,NULL,'2017-03-31 17:05:25',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(30,NULL,'','','','','',1,1,NULL,'2017-03-31 17:05:41',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(31,NULL,'','','','','',1,1,NULL,'2017-03-31 17:06:26',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(32,NULL,'','','','','',1,1,NULL,'2017-03-31 17:07:09',1,NULL,1,1,NULL,'','','',NULL,NULL,NULL,NULL),(33,NULL,'','','','','',1,1,NULL,'2017-03-31 17:07:59',1,NULL,1,3,NULL,'','','',NULL,NULL,NULL,NULL),(34,NULL,'','','','','',2,2,NULL,'2017-03-31 17:08:28',1,NULL,1,3,NULL,'','','',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_reg`
--

DROP TABLE IF EXISTS `student_reg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_reg` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `form_num` varchar(20) NOT NULL,
  `reg_date` varchar(20) DEFAULT NULL,
  `last_class` tinyint(3) DEFAULT NULL,
  `last_school` varchar(100) DEFAULT NULL,
  `result` varchar(2) DEFAULT NULL,
  `created_by` int(8) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reg_num` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_reg`
--

LOCK TABLES `student_reg` WRITE;
/*!40000 ALTER TABLE `student_reg` DISABLE KEYS */;
INSERT INTO `student_reg` VALUES (8,'213','1 March, 2017',NULL,',','',1,'2017-03-13 15:32:56','232'),(9,'1212','1 March, 2017',NULL,'DASDSA,,DASDSA,','P',1,'2017-03-19 16:35:26','54354'),(10,'123213','23 March, 2017',NULL,'erewrewrewrew,Amit','',1,'2017-03-29 18:53:58','4214214'),(11,'','',NULL,',','',1,'2017-03-31 17:03:03',''),(12,'','',NULL,',','',1,'2017-03-31 17:03:40','');
/*!40000 ALTER TABLE `student_reg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `dept_id` int(8) DEFAULT NULL,
  `role_id` int(8) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(8) NOT NULL,
  `updated_by` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Amit Agnihotri','amit@gmail.com','a49f35f82bb2b208479c1449f7092cc4','9871286278',NULL,NULL,1,'2017-02-28 18:30:00','2017-03-23 05:38:24',1,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-31 22:46:48


CREATE TABLE `abacusreg` (
  `id` int(10) NOT NULL,
  `formnum` varchar(20) DEFAULT NULL,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `nickName` varchar(20) DEFAULT NULL,
  `dateOfBirth` varchar(20) DEFAULT NULL,
  `fatherName` varchar(20) DEFAULT NULL,
  `MotherName` varchar(20) DEFAULT NULL,
  `SchoolName` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `feeAmount` varchar(20) DEFAULT NULL,
  `selMonth` tinyint(4) DEFAULT NULL,
  `address1` varchar(20) DEFAULT NULL,
  `address2` varchar(20) DEFAULT NULL,
  `area` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `pincode` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

