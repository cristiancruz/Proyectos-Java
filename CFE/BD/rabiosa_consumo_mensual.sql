CREATE DATABASE  IF NOT EXISTS `rabiosa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rabiosa`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: rabiosa
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `consumo_mensual`
--

DROP TABLE IF EXISTS `consumo_mensual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumo_mensual` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `nombreCliente` varchar(45) NOT NULL,
  `kilowatts` double NOT NULL,
  `mes` int(11) NOT NULL,
  `año` int(11) NOT NULL,
  `adeudo` double NOT NULL,
  `subtotal` double NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_idx` (`idCliente`),
  CONSTRAINT `idClient` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumo_mensual`
--

LOCK TABLES `consumo_mensual` WRITE;
/*!40000 ALTER TABLE `consumo_mensual` DISABLE KEYS */;
INSERT INTO `consumo_mensual` VALUES (100,20,'Arcangel Pa De la Gueto',34,1,2014,0,102,148.92),(102,21,'Adrian Lopez',123,2,2013,0,369,538.74),(103,22,'Evelyn osuna',4,12,2010,0,12,17.52),(104,22,'Evelyn osuna',75,11,2014,0,225,328.5),(105,19,'Cristian Quijada',45,12,2014,0,135,197.1),(106,21,'Adrian Lopez',34,3,2014,0,102,148.92),(107,22,'Evelyn osuna',1,10,2013,0,3,4.38),(108,21,'Adrian Lopez',34455,12,2014,0,103365,150912.9),(109,20,'Arcangel Pa De la Gueto',4,11,2013,0,12,17.52),(110,20,'Arcangel Pa De la Gueto',45454,2,2014,0,136362,199088.52000000002),(111,21,'Adrian Lopez',3434,11,2014,0,10302,15040.92),(112,22,'Evelyn osuna',54656,5,2014,0,163968,239393.28),(113,21,'Adrian Lopez',12,8,2014,0,48,70.08),(114,22,'Evelyn osuna',5,6,2014,0,20,29.2),(115,21,'Adrian Lopez',12,12,2014,0,48,70.08),(116,21,'Adrian Lopez',43434,12,2014,0,173736,253654.56),(117,21,'',45454545,12,2014,0,181818180,265454542.8),(118,20,'Arcangel Pa De la Gueto',6565,12,2014,0,26260,38339.6),(119,21,'Adrian Lopez',45,12,2014,0,112.5,389.25);
/*!40000 ALTER TABLE `consumo_mensual` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-03 11:11:39
