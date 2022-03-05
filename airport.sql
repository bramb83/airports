-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.7.3-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database airport
CREATE DATABASE IF NOT EXISTS `airport` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `airport`;

-- Dump della struttura di tabella airport.metar
CREATE TABLE IF NOT EXISTS `metar` (
  `icaocode` varchar(5) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp(),
  `data` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`icaocode`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dump dei dati della tabella airport.metar: ~2 rows (circa)
/*!40000 ALTER TABLE `metar` DISABLE KEYS */;
INSERT INTO `metar` (`icaocode`, `time`, `data`) VALUES
	('LBBA', '2022-03-03 19:12:54', 'METAR LDZA\r\n121200Z 0902MPS 090V150 2000 R04/P2000N R22/P2000N OVC050\r\n0/M01 Q1020='),
	('LBCC', '2022-03-03 19:17:41', 'METAR LDZA\r\n121200Z 0902MPS 090V150 2000 R04/P2000N R22/P2000N OVC050\r\n0/M01 Q1020='),
	('LBCC', '2022-03-03 20:02:35', 'METAR LBCC\r\n121200Z 0902MPS 090V150 2000 R04/P2000N R22/P2000N OVC050\r\n0/M01 Q1020='),
	('LBCC', '2022-03-03 20:02:37', 'METAR LBCC\r\n121200Z 0902MPS 090V150 2000 R04/P2000N R22/P2000N OVC050\r\n0/M01 Q1020='),
	('LBCC', '2022-03-03 20:03:21', 'METAR LBCC\r\n131300Z 0902MPS 090V150 2000 R04/P2000N R22/P2000N OVC050\r\n0/M01 Q1020='),
	('LBCC', '2022-03-03 20:04:03', 'METAR LBCC\r\n131300Z 0902MPS 090V150 2000 R04/P2000N R22/P2000N OVC050\r\n0/M01 Q1020='),
	('LDZA', '2022-03-03 14:09:29', 'METAR LDZA\r\n121200Z 0902MPS 090V150 2000 R04/P2000N R22/P2000N OVC050\r\n0/M01 Q1020=');
/*!40000 ALTER TABLE `metar` ENABLE KEYS */;

-- Dump della struttura di tabella airport.subscriptions
CREATE TABLE IF NOT EXISTS `subscriptions` (
  `icaocode` varchar(5) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `active` char(1) DEFAULT '1',
  PRIMARY KEY (`icaocode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dump dei dati della tabella airport.subscriptions: ~3 rows (circa)
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` (`icaocode`, `description`, `active`) VALUES
	('LBBA', 'Wien', '0'),
	('LDZA', 'Zagreb', '1'),
	('LIMC', 'Milano Malpensa', '0');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
