-- --------------------------------------------------------
-- 호스트:                          localhost
-- 서버 버전:                        10.5.7-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- me 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `me` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `me`;

-- 테이블 me.job_apply 구조 내보내기
CREATE TABLE IF NOT EXISTS `job_apply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '입사지원 번호',
  `apply_date` date NOT NULL DEFAULT current_timestamp() COMMENT '지원일자',
  `company_name` varchar(20) NOT NULL COMMENT '회사명',
  `announcement_name` tinytext NOT NULL COMMENT '공고명',
  `read_yn` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '열람여부',
  `pass_yn` tinyint(3) unsigned DEFAULT NULL COMMENT '합격여부',
  `status` int(1) unsigned NOT NULL COMMENT '진행상태',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 me.job_apply:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `job_apply` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_apply` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
