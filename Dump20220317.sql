CREATE DATABASE  IF NOT EXISTS `room-management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `room-management`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: room-management
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bed_room` int(11) DEFAULT NULL,
  `hash_ac` bit(1) DEFAULT NULL,
  `has_gizer` bit(1) DEFAULT NULL,
  `hash_lift` bit(1) DEFAULT NULL,
  `has_phone` bit(1) DEFAULT NULL,
  `has_tv` bit(1) DEFAULT NULL,
  `has_wifi` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES (1,NULL,'','','','\0','','\0'),(2,NULL,'','','','','',''),(3,NULL,'','\0','','','','\0'),(4,NULL,'','\0','','','',''),(5,NULL,'','','','','','');
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resident`
--

DROP TABLE IF EXISTS `resident`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resident` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resident_address` varchar(255) DEFAULT NULL,
  `resident_id_proof` varchar(255) DEFAULT NULL,
  `resident_name` varchar(255) DEFAULT NULL,
  `resident_phone_number` varchar(255) DEFAULT NULL,
  `booked_date` datetime(6) DEFAULT NULL,
  `check_in_time` datetime(6) DEFAULT NULL,
  `check_out_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resident`
--

LOCK TABLES `resident` WRITE;
/*!40000 ALTER TABLE `resident` DISABLE KEYS */;
INSERT INTO `resident` VALUES (3,'patna bihar','SDF323SFD','Prince Kumar','7896541236','2022-03-14 17:35:51.767000','2022-03-14 00:00:00.000000',NULL);
/*!40000 ALTER TABLE `resident` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resident_room`
--

DROP TABLE IF EXISTS `resident_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resident_room` (
  `resident_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  KEY `FKjjmbub8qe5mmvfvontcy2mt5t` (`room_id`),
  KEY `FK2mtbx4hf1g2l8n58ciaanv8tg` (`resident_id`),
  CONSTRAINT `FK2mtbx4hf1g2l8n58ciaanv8tg` FOREIGN KEY (`resident_id`) REFERENCES `resident` (`id`),
  CONSTRAINT `FKjjmbub8qe5mmvfvontcy2mt5t` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resident_room`
--

LOCK TABLES `resident_room` WRITE;
/*!40000 ALTER TABLE `resident_room` DISABLE KEYS */;
INSERT INTO `resident_room` VALUES (3,2);
/*!40000 ALTER TABLE `resident_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `floor_number` int(11) DEFAULT NULL,
  `is_booked` bit(1) DEFAULT NULL,
  `room_fare` decimal(19,2) DEFAULT NULL,
  `room_number` int(11) DEFAULT NULL,
  `room_type` varchar(255) DEFAULT NULL,
  `facility_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl25uqog8bljvpaeltumdv07sh` (`facility_id`),
  CONSTRAINT `FKl25uqog8bljvpaeltumdv07sh` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,1,'',2000.00,101,'AC',1),(2,2,'',1000.00,202,'NON-AC',3),(3,3,'\0',1500.00,302,'AC',2),(4,4,'\0',1500.00,405,'AC',4),(5,2,'\0',1500.00,203,'NON-AC',5),(6,2,'\0',1000.00,210,'AC',NULL);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-17 23:07:54
