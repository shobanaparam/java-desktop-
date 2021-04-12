-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 29, 2018 at 02:46 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `addscanning`
--

DROP TABLE IF EXISTS `addscanning`;
CREATE TABLE IF NOT EXISTS `addscanning` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `PhysicianName` varchar(20) NOT NULL,
  `ScannedDate` date NOT NULL,
  `ReportStatus` varchar(20) NOT NULL,
  `TypeOfScan` varchar(20) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Age` int(20) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `addscanning`
--

INSERT INTO `addscanning` (`ID`, `PhysicianName`, `ScannedDate`, `ReportStatus`, `TypeOfScan`, `Name`, `Age`, `Gender`) VALUES
(1, 'shobi', '2001-02-20', 'Delivered', 'ULTRA SOUND', 'shoba', 21, 'Female'),
(15, 'shobi', '2015-07-29', 'Delivered', 'ULTRA SOUND', 'sh', 15, 'Male'),
(16, 'shobana', '2018-09-05', 'Delivered', 'ULTRA SOUND', 'shana', 20, 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `addtesting`
--

DROP TABLE IF EXISTS `addtesting`;
CREATE TABLE IF NOT EXISTS `addtesting` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `SpecimenNo` int(20) NOT NULL,
  `PhysicianName` varchar(20) NOT NULL,
  `SampleCollectedDate` date NOT NULL,
  `ReportStatus` varchar(20) NOT NULL,
  `Specimen` varchar(20) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Age` int(100) NOT NULL,
  `Gender` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `addtesting`
--

INSERT INTO `addtesting` (`ID`, `SpecimenNo`, `PhysicianName`, `SampleCollectedDate`, `ReportStatus`, `Specimen`, `Name`, `Age`, `Gender`) VALUES
(2, 2, 's', '2001-02-20', 'Not Delivered', 'Urine Full Report', 're', 2, 'Male'),
(3, 2, 's', '2001-02-20', 'Not Delivered', 'Urine Full Report', 'resy', 2, 'Male'),
(4, 2, 's', '2001-02-20', 'Not Delivered', 'Urine Full Report', 'reka', 2, 'Male'),
(5, 2, 's', '2001-02-20', 'Not Delivered', 'Random Cholesterol', 're', 2, 'Male'),
(6, 2, 's', '2001-02-20', 'Delivered', 'Random Cholesterol', 're', 2, 'Male'),
(7, 2, 'shobi', '2002-02-20', 'Not Delivered', 'Random Cholesterol', 'renu', 20, 'Female'),
(14, 2, 'hema', '2001-02-20', 'Delivered', 'Urine Full Report', 'aswi', 20, 'Female'),
(15, 2, 's', '2001-02-20', 'Not Delivered', 'Urine Full Report', 're', 2, 'Male'),
(12, 2, 'ham', '2001-02-20', 'Not Delivered', 'Urine Full Report', 'aswi', 20, 'Female'),
(20, 2, 's', '2001-02-20', 'Not Delivered', 'Urine Full Report', 're', 20, 'Female'),
(23, 2, 'sho', '2008-02-14', 'Not Delivered', 'Random Cholesterol', 're', 2, 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE IF NOT EXISTS `inventory` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `ItemName` varchar(20) NOT NULL,
  `Catogory` varchar(20) NOT NULL,
  `PurchasedDate` date NOT NULL,
  `Quantity` int(20) NOT NULL,
  `Price` int(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`ID`, `ItemName`, `Catogory`, `PurchasedDate`, `Quantity`, `Price`) VALUES
(1, 'chair112', 'Furniture', '2002-05-20', 5, 2000),
(2, 'bed', 'Furniture', '2002-05-20', 5, 20000),
(3, 'chair', 'Machinary', '2020-05-20', 4, 20000),
(4, 'l', 'Machinary', '2022-05-20', 5, 2500),
(15, 'hh', 'Machinary', '2004-04-20', 44, 2000),
(16, 'c', 'Machinary', '2000-04-05', 44, 2000),
(29, 'table', 'Machinary', '2002-12-20', 1, 10000),
(32, 'chair', 'Machinary', '2002-05-20', 6, 252000),
(37, 'table', 'Machinary', '2002-10-20', 6, 25200),
(45, 'chair', 'Machinary', '2017-12-31', 5, 7000),
(46, 'chair', 'Machinary', '2017-12-31', 5, 7000),
(47, 'chair', 'Machinary', '2017-01-01', 5, 7000),
(48, 'chair', 'Machinary', '2017-01-01', 5, 7000),
(49, 'c', 'Machinary', '2017-12-31', 44, 2000),
(50, 'aqasdfghjk', 'Machinary', '2021-12-26', 8, 210),
(51, 'hh', 'Machinary', '2018-09-14', 44, 2000),
(52, 'aqasdfghjk', 'Machinary', '2021-12-26', 8, 2100),
(54, 'hh', 'Machinary', '2022-09-20', 44, 2000),
(56, 'hh', 'Machinary', '2013-09-06', 44, 2000),
(57, 'table', 'Machinary', '2018-09-06', 5, 500);

-- --------------------------------------------------------

--
-- Table structure for table `scanpayment`
--

DROP TABLE IF EXISTS `scanpayment`;
CREATE TABLE IF NOT EXISTS `scanpayment` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `PatientName` varchar(30) NOT NULL,
  `ScanName` varchar(20) NOT NULL,
  `ScanFee` int(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `scanpayment`
--

INSERT INTO `scanpayment` (`ID`, `PatientName`, `ScanName`, `ScanFee`) VALUES
(7, 'shoba', 'UltraSound', 500);

-- --------------------------------------------------------

--
-- Table structure for table `testpayment`
--

DROP TABLE IF EXISTS `testpayment`;
CREATE TABLE IF NOT EXISTS `testpayment` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `PatientName` varchar(30) NOT NULL,
  `TestName` varchar(50) NOT NULL,
  `TestFee` int(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `testpayment`
--

INSERT INTO `testpayment` (`ID`, `PatientName`, `TestName`, `TestFee`) VALUES
(1, '', 'shana', 1000),
(14, '', 'urine', 5000),
(3, '', 'ss', 10000),
(4, '', 'l', 2500),
(5, '', 'l', 3000),
(6, '', 'ki', 2300),
(7, '', 'l', 2000),
(17, '', 'hff', 2200),
(10, 'gg', 'dd', 2000),
(20, 'renu', 'ssho', 200);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
