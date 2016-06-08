-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016-06-08 15:03:34
-- 服务器版本： 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `staff`
--

-- --------------------------------------------------------

--
-- 表的结构 `dept`
--

DROP TABLE IF EXISTS `dept`;
CREATE TABLE IF NOT EXISTS `dept` (
  `dept_id` int(8) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

--
-- 转存表中的数据 `dept`
--

INSERT INTO `dept` (`dept_id`, `dept_name`) VALUES
(1, '办公室'),
(2, '组织部'),
(3, '宣传部'),
(4, '纪检部'),
(5, '网络部'),
(11, '党支部');

-- --------------------------------------------------------

--
-- 表的结构 `job`
--

DROP TABLE IF EXISTS `job`;
CREATE TABLE IF NOT EXISTS `job` (
  `job_id` int(8) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

--
-- 转存表中的数据 `job`
--

INSERT INTO `job` (`job_id`, `job_name`) VALUES
(1, '部长'),
(2, '主任'),
(3, '副部长'),
(4, '副主任'),
(5, '书记'),
(6, '副书记'),
(7, '部员');

-- --------------------------------------------------------

--
-- 表的结构 `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `staff_id` int(8) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(30) COLLATE utf8_unicode_520_ci NOT NULL,
  `staff_dept` int(8) NOT NULL,
  `staff_job` int(8) NOT NULL,
  `detail` varchar(50) COLLATE utf8_unicode_520_ci NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

--
-- 转存表中的数据 `staff`
--

INSERT INTO `staff` (`staff_id`, `staff_name`, `staff_dept`, `staff_job`, `detail`) VALUES
(19, '张三', 5, 1, ''),
(18, '李四', 4, 1, ''),
(17, '王五', 3, 1, ''),
(16, '钱六', 2, 1, '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
