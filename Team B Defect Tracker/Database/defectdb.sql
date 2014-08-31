-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2014 at 03:09 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `defectdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `defect`
--

CREATE TABLE IF NOT EXISTS `defect` (
  `APPLICATION` varchar(32) NOT NULL,
  `DEFECT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATUS` varchar(30) NOT NULL,
  `DATE_CREATED` date NOT NULL,
  `SUMMARY` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(4000) NOT NULL,
  `ASSIGNEE` varchar(32) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `FINAL_RESOLUTION` varchar(4000) DEFAULT NULL,
  `RESOLUTION_DATE` date DEFAULT NULL,
  PRIMARY KEY (`DEFECT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `defect`
--

INSERT INTO `defect` (`APPLICATION`, `DEFECT_ID`, `STATUS`, `DATE_CREATED`, `SUMMARY`, `DESCRIPTION`, `ASSIGNEE`, `PRIORITY`, `FINAL_RESOLUTION`, `RESOLUTION_DATE`) VALUES
('FIRST APPLICATION', 1, 'OPEN', '2014-08-30', 'This is the first defect summary.', 'This is the first defect description', NULL, NULL, NULL, NULL),
('SECOND APPLICATION', 2, 'OPEN', '2014-08-31', 'This is the second defect summary.', 'This is the second defect description.', NULL, NULL, NULL, NULL),
('THIRD APPLICATION', 3, 'OPEN', '2014-08-30', 'Third defect summary', 'Third defect description', NULL, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `FIRST_NAME` varchar(35) NOT NULL,
  `LAST_NAME` varchar(35) NOT NULL,
  `EMAIL` varchar(70) NOT NULL,
  `PASSWORD` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PASSWORD`) VALUES
('Shaun', 'Adriano', 'hiro.one@gmail.com', 'admin'),
('Dennis', 'Hom', 'dnlhom11@gmail.com', 'admin'),
('Levi', 'Hsiao', 'Levi.Hsiao@gmail.com', 'admin'),
('Susan', 'Marosek', 'smarosek@gmail.com', 'admin');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
