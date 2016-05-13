CREATE DATABASE  IF NOT EXISTS `dbservisoft` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dbservisoft`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dbservisoft
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombreProyecto` varchar(100) NOT NULL,
  `tipoPrograma` varchar(45) NOT NULL,
  `sector` varchar(45) NOT NULL,
  `giro` varchar(45) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `contactoEmpresa` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombreProyecto_UNIQUE` (`nombreProyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,'ORGANIZACIÓN Y APOYO DE EVENTOS ACADEMICOS DEL PROGRAMA EDUCATIVO IIS','E','INT','INT','ITSON','2210033','FCO. JAVIER SOTO VALENZUELA'),(2,'Barriendo mi colonia','E','ED','COMER','ESC. PRIMARIA MARGARITA MAZA DE JUAREZ','45455646','FCO. JAVIER SOTO VALENZUELA'),(3,'salvando cochis','E','INT','SER','rastro','3434343','con el maton de cochis u.u'),(4,'el nuevo','EA','PUBLICO','EDU','comex','557878','con el jefe'),(8,'playas		','fdfdf','PUBLICO','COMER','itson','83748374983','CON EL RECTOR'),(9,'mar azul	','popular','PUBLICO','INDU','hotel armida','34343','343443'),(10,'viendo tv','fgfg','PRIVADO','EDU','no se','45453','con el dueño'),(13,'viendo tv2','tr','PRIVADO','SERVICIO','trt','344545455','rgf');
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-18 20:49:43
