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
  `time` varchar(50) NOT NULL,
  `data` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`icaocode`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dump dei dati della tabella airport.metar: ~12 rows (circa)
/*!40000 ALTER TABLE `metar` DISABLE KEYS */;
INSERT INTO `metar` (`icaocode`, `time`, `data`) VALUES
	('LDZA', '2022/03/05 16:30', 'LDZA 051630Z 05010KT 010V110 9999 FEW045 05/M05 Q1018 NOSIG\n'),
	('LDZA', '2022/03/05 17:00', 'LDZA 051700Z 06007KT 020V100 CAVOK 05/M05 Q1018 NOSIG\n'),
	('LDZA', '2022/03/05 19:00', 'LDZA 051900Z 04006KT CAVOK 03/M04 Q1019 NOSIG\n'),
	('LDZA', '2022/03/05 19:30', 'LDZA 051930Z 05006KT 010V070 CAVOK 04/M05 Q101'),
	('LIMC', '2022/03/05 16:20', 'LIMC 051620Z 17005KT 120V190 CAVOK 09/M04 Q1014 NOSIG\n'),
	('LIMC', '2022/03/05 16:50', 'LIMC 051650Z 15007KT CAVOK 08/M04 Q1014 NOSIG\n'),
	('LIMC', '2022/03/05 18:50', 'LIMC 051850Z 14004KT 120V180 CAVOK 05/M04 Q1015 NOSIG\n'),
	('LIMC', '2022/03/05 19:20', 'LIMC 051920Z 13004KT 100V170 CAVOK 04/M04 Q1016 NOSIG\n'),
	('LIMC', '2022/03/05 19:50', 'LIMC 051950Z 12004KT 070V150 CAVOK 03/M05 Q1016 NOSIG\n'),
	('LIME', '2022/03/05 18:50', 'LIME 051850Z VRB01KT CAVOK 03/M04 Q1016 NOSIG\n'),
	('LIME', '2022/03/05 19:20', 'LIME 051920Z 02004KT CAVOK 04/M04 Q1016 NOSIG\n'),
	('LIME', '2022/03/05 19:50', 'LIME 051950Z 02004KT 9999 SCT050 03/M03 Q1016 ');
/*!40000 ALTER TABLE `metar` ENABLE KEYS */;

-- Dump della struttura di tabella airport.subscriptions
CREATE TABLE IF NOT EXISTS `subscriptions` (
  `icaocode` varchar(5) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`icaocode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dump dei dati della tabella airport.subscriptions: ~3 rows (circa)
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` (`icaocode`, `description`) VALUES
	('LDZA', 'Zagreb'),
	('LIMC', 'Milano Malpensa'),
	('LIME', 'Bergamo');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
