-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.5-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 me.home_entry 구조 내보내기
CREATE TABLE IF NOT EXISTS `home_entry` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '출입번호',
  `in_time` datetime NOT NULL COMMENT '입실시간',
  `out_time` datetime DEFAULT NULL COMMENT '퇴실시간',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 me.home_entry:~16 rows (대략적) 내보내기
/*!40000 ALTER TABLE `home_entry` DISABLE KEYS */;
REPLACE INTO `home_entry` (`id`, `in_time`, `out_time`) VALUES
	(1, '2020-11-01 07:57:07', NULL);
/*!40000 ALTER TABLE `home_entry` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
