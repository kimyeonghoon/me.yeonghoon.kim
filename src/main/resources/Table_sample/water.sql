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

-- 테이블 me.water 구조 내보내기
CREATE TABLE IF NOT EXISTS `water` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '필터 고유 번호',
  `startdate` datetime NOT NULL DEFAULT current_timestamp() COMMENT '필터 사용 시작 일자',
  `enddate` datetime DEFAULT NULL COMMENT '필터 사용 종료 일자',
  `used` int(3) NOT NULL DEFAULT 1 COMMENT '필터 사용 횟수',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='브리타 정수기 필터 현황';

-- 테이블 데이터 me.water:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `water` DISABLE KEYS */;
REPLACE INTO `water` (`id`, `startdate`, `enddate`, `used`) VALUES
	(1, '2020-10-03 02:19:00', NULL, 100);
/*!40000 ALTER TABLE `water` ENABLE KEYS */;

-- 테이블 me.water_status 구조 내보내기
CREATE TABLE IF NOT EXISTS `water_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '카운트 고유 번호',
  `filter_no` int(11) NOT NULL COMMENT '필터 번호',
  `regtime` datetime NOT NULL DEFAULT current_timestamp() COMMENT '등록시간',
  PRIMARY KEY (`id`),
  KEY `water_no.FK` (`filter_no`),
  CONSTRAINT `water_no.FK` FOREIGN KEY (`filter_no`) REFERENCES `water` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='정수 필터 상태';

-- 테이블 데이터 me.water_status:~13 rows (대략적) 내보내기
/*!40000 ALTER TABLE `water_status` DISABLE KEYS */;
REPLACE INTO `water_status` (`id`, `filter_no`, `regtime`) VALUES
	(1, 1, '2020-10-13 02:19:00');
/*!40000 ALTER TABLE `water_status` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
