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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `matricula` varchar(15) NOT NULL,
  `carrera` varchar(45) NOT NULL,
  `semestre` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `plan` varchar(45) NOT NULL,
  `campus` varchar(45) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `horas` int(11) NOT NULL,
  `papelera` tinyint(2) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Cristian ','Quijada','00000108316','ISW','8','vencees.dlp@hotmail.com','CP1995','Guaymas','6221459303',55656,0,'11/03/2015'),(2,'Evelyn Suggey','Osuna Rodriguez','00000108317','Psicologia','5','eve@hotmai.com','344cc-43','Guaymas','6221348737',783,0,'8/03/15'),(3,'Jorge     ','Rodriguez Juarez','111111','psicologia','7','loco@hotmail.com','CP19953','Guaymas','28741454',0,0,'12/03/2015'),(4,'maria  aldai','Gonzales ferre','22222','LPSIC3','9','asd@hotmail.com','LPS20042','Guaymas','12254',450,0,'12/03/2015'),(5,'niña wow            ','Quijada sepa ','33','Ilae','5','asd@hotmail.com','4','Guaymas','221-10964',600,1,'12/03/2015'),(6,'Miguel quechitos          ','Olivera Vicencio ','444','nose','46','asd@hotmail.com','ISO2009','Guaymas','2445455',0,0,'12/03/2015'),(17,'Adrian','Gonzales Juarez','45545','diseño','2','adria@','CP19953','Guaymas','123456',0,0,'18/03/2015');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-18 20:49:44
