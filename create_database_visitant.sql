-- MySQL dump 10.17  Distrib 10.3.15-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: visitant
-- ------------------------------------------------------
-- Server version	10.3.15-MariaDB

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
-- Table structure for table `vst_log_action`
--

DROP TABLE IF EXISTS `vst_log_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vst_log_action` (
  `action_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `hash` varchar(176) NOT NULL,
  `type` tinyint(3) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`action_id`),
  UNIQUE KEY `unq_hash_type` (`hash`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vst_log_action`
--

LOCK TABLES `vst_log_action` WRITE;
/*!40000 ALTER TABLE `vst_log_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `vst_log_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vst_log_view`
--

DROP TABLE IF EXISTS `vst_log_view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vst_log_view` (
  `view_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `visit_id` int(11) unsigned NOT NULL,
  `title_action_id` int(11) unsigned NOT NULL,
  `url_action_id` int(11) unsigned NOT NULL,
  `server_time` datetime NOT NULL,
  `local_time` datetime NOT NULL,
  PRIMARY KEY (`view_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vst_log_view`
--

LOCK TABLES `vst_log_view` WRITE;
/*!40000 ALTER TABLE `vst_log_view` DISABLE KEYS */;
/*!40000 ALTER TABLE `vst_log_view` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vst_log_visit`
--

DROP TABLE IF EXISTS `vst_log_visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vst_log_visit` (
  `visit_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `visitant_id` int(11) unsigned NOT NULL,
  `visit_date` date NOT NULL,
  PRIMARY KEY (`visit_id`),
  UNIQUE KEY `unq_visitant_id_visit_date` (`visitant_id`,`visit_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vst_log_visit`
--

LOCK TABLES `vst_log_visit` WRITE;
/*!40000 ALTER TABLE `vst_log_visit` DISABLE KEYS */;
/*!40000 ALTER TABLE `vst_log_visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vst_visitant`
--

DROP TABLE IF EXISTS `vst_visitant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vst_visitant` (
  `visitant_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hash` varchar(64) NOT NULL,
  `user_agent` text NOT NULL,
  `browser` varchar(32) DEFAULT '',
  `browser_version` varchar(32) DEFAULT '',
  `engine` varchar(32) DEFAULT '',
  `engine_version` varchar(32) DEFAULT '',
  `os` varchar(32) DEFAULT '',
  `os_version` varchar(16) DEFAULT '',
  `device_vendor` varchar(128) DEFAULT '',
  `device_model` varchar(128) DEFAULT '',
  `device_type` tinyint(3) unsigned DEFAULT 0,
  `language` varchar(16) DEFAULT '',
  `timezone` varchar(32) DEFAULT '',
  `timezone_offset` smallint(5) DEFAULT 0,
  `platform` varchar(128) DEFAULT '',
  `screen_resolution_x` smallint(5) unsigned DEFAULT 0,
  `screen_resolution_y` smallint(5) unsigned DEFAULT 0,
  `webgl_vendor_and_renderer` text DEFAULT NULL,
  `remote_addr_hash` varchar(80) DEFAULT '',
  PRIMARY KEY (`visitant_id`),
  UNIQUE KEY `unq_hash` (`hash`,`remote_addr_hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vst_visitant`
--

LOCK TABLES `vst_visitant` WRITE;
/*!40000 ALTER TABLE `vst_visitant` DISABLE KEYS */;
/*!40000 ALTER TABLE `vst_visitant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-12 13:08:13
