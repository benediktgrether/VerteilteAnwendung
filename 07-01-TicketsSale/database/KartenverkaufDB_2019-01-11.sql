# ************************************************************
# Sequel Pro SQL dump
# Version 5426
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 8.0.13)
# Database: KartenverkaufDB
# Generation Time: 2019-01-11 12:35:54 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tickets
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tickets`;

CREATE TABLE `tickets` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `seat_number` int(11) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `reservation_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;

INSERT INTO `tickets` (`id`, `seat_number`, `status`, `reservation_name`)
VALUES
	(1,0,'F',NULL),
	(2,1,'F',NULL),
	(3,2,'S','Grether'),
	(4,3,'S','Grether'),
	(5,4,'R','Müller'),
	(6,5,'R','Müller'),
	(7,6,'F',NULL),
	(8,7,'F',NULL),
	(25,24,'S','Grether'),
	(26,25,'S','Grether'),
	(79,78,'R','Müller'),
	(80,79,'R','Müller');

/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ticketSales
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ticketSales`;

CREATE TABLE `ticketSales` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `accept_reservation` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `ticketSales` WRITE;
/*!40000 ALTER TABLE `ticketSales` DISABLE KEYS */;

INSERT INTO `ticketSales` (`id`, `accept_reservation`)
VALUES
	(1,b'1');

/*!40000 ALTER TABLE `ticketSales` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
