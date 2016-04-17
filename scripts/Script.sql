-- MySQL dump 10.10
--
-- Host: localhost    Database: relatorios
-- ------------------------------------------------------
-- Server version	5.0.18-nt

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

DROP DATABASE IF EXISTS `DBBICICLETA`;

CREATE DATABASE `dbBicicleta`;

USE dbBicicleta;



DROP TABLE IF EXISTS `tb_bicicleta`;
CREATE TABLE `tb_bicicleta` (
  `cd_bicicleta` int(11) NOT NULL auto_increment,
  `qt_disponivel` int(11) NOT NULL,
  `ds_marca` varchar(30) default NULL,
  PRIMARY KEY  (`cd_bicicleta`),
  KEY `qt_disponivel` (`qt_disponivel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*!40000 ALTER TABLE `tb_bicicleta` DISABLE KEYS */;
LOCK TABLES `tb_bicicleta` WRITE;
INSERT INTO `tb_bicicleta` VALUES (1,12,'Oxer'),(2,2,'Caloi');
UNLOCK TABLES;
/*!40000 ALTER TABLE `tb_bicicleta` ENABLE KEYS */;




DROP TABLE IF EXISTS `tb_cliente`;
CREATE TABLE `tb_cliente` (
  `cd_cliente` int(11) NOT NULL auto_increment,
  `nm_cliente` varchar(30) default NULL,
  `ds_endereco` varchar(30) default NULL,
  `ds_cidade` varchar(15) default NULL,
  `ds_cep` varchar(10) default NULL,
  `ds_pais` varchar(15) default NULL,
  `ds_telefone` varchar(24) default NULL,
  PRIMARY KEY  (`cd_cliente`),
  KEY `ds_cidade` (`ds_cidade`),
  KEY `ds_cep` (`ds_cep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
LOCK TABLES `tb_cliente` WRITE;
INSERT INTO `tb_cliente` VALUES (1,'Maria Anders','Obere Str. 57','Berlin','12209','Germany','030-0074321'),
(2,'Ana Trujillo','Avda. de la Constitución 2222','México D.F.','05021','Mexico','(5) 555-4729');
UNLOCK TABLES;
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;


DROP TABLE IF EXISTS `tb_aluguel`;
CREATE TABLE `tb_aluguel` (
  `cd_aluguel` int(11) NOT NULL auto_increment,
  `cd_bicicleta` int(11) default NULL,
  `vl_diario` int(11) default NULL,
  `vl_mensal` int(11) default NULL,
  `vl_anual` int(11) default NULL,
  PRIMARY KEY  (`cd_aluguel`),
  KEY `CustomerID` (`cd_bicicleta`),
  CONSTRAINT `fk_clientes` FOREIGN KEY (`cd_bicicleta`) REFERENCES `tb_bicicleta` (`cd_bicicleta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



/*!40000 ALTER TABLE `tb_aluguel` DISABLE KEYS */;
LOCK TABLES `tb_aluguel` WRITE;
INSERT INTO `tb_aluguel` VALUES (1,1,2,10,50),(1,2,2,10,50);
UNLOCK TABLES;
/*!40000 ALTER TABLE `tb_aluguel` ENABLE KEYS */;

select * from tb_cliente;
select * from tb_bicicleta;
select * from tb_aluguel;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;