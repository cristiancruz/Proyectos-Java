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
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `semestreRealizacion` varchar(100) NOT NULL,
  `duracion` varchar(100) NOT NULL,
  `horario` varchar(100) NOT NULL,
  `totalHoras` int(11) NOT NULL,
  `status` tinyint(2) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idProyecto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `traasdf_idx` (`idAlumno`),
  KEY `one2_idx` (`idProyecto`),
  CONSTRAINT `one1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `one2` FOREIGN KEY (`idProyecto`) REFERENCES `proyecto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (3,'Enero-Mayo 2012','tyhy','hyh',300,1,2,3),(4,'Enero-Mayo 2012','hytrgf','jmnhg',250,1,2,9),(5,'Enero-Mayo 2014','olikujyt','ujtyr',200,1,4,9),(6,'Enero-Mayo 2015','olikujytolikuytre','ujtyrthgrfef',600,1,5,10),(7,'Enero-Mayo 2016','olikujytolikuytre','ujtyrthgrfef',250,1,4,4),(8,'Enero-Mayo 2012','hfkugf','kjyhg',233,1,2,4),(9,'Enero-Mayo 2012','565','565656',23,1,1,1),(10,'Enero-Mayo 2017','uyt','yty',54,1,1,1),(11,'Enero-Mayo 2017','tyty','454544hth',55545,1,1,2),(12,'Enero-Mayo 2012','gf','hgf',34,1,1,13);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
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
