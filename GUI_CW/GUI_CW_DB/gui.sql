-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 13, 2022 at 01:35 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gui`
--

-- --------------------------------------------------------

--
-- Table structure for table `chemistry`
--

DROP TABLE IF EXISTS `chemistry`;
CREATE TABLE IF NOT EXISTS `chemistry` (
  `RegistrationNumber` varchar(200) NOT NULL,
  `mark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RegistrationNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `english`
--

DROP TABLE IF EXISTS `english`;
CREATE TABLE IF NOT EXISTS `english` (
  `RegistrationNumber` varchar(200) NOT NULL,
  `mark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RegistrationNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `english`
--

INSERT INTO `english` (`RegistrationNumber`, `mark`) VALUES
('180021127', '60');

-- --------------------------------------------------------

--
-- Table structure for table `math`
--

DROP TABLE IF EXISTS `math`;
CREATE TABLE IF NOT EXISTS `math` (
  `RegistrationNumber` varchar(200) NOT NULL,
  `mark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RegistrationNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `physics`
--

DROP TABLE IF EXISTS `physics`;
CREATE TABLE IF NOT EXISTS `physics` (
  `RegistrationNumber` varchar(200) NOT NULL,
  `mark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RegistrationNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `RegistrationNumber` varchar(200) NOT NULL,
  `age` varchar(100) DEFAULT NULL,
  `ClassLevel` varchar(100) DEFAULT NULL,
  `Gender` varchar(100) DEFAULT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `FirstName` varchar(200) DEFAULT NULL,
  `LastName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RegistrationNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`RegistrationNumber`, `age`, `ClassLevel`, `Gender`, `Subject`, `FirstName`, `LastName`) VALUES
('180021127', '29', 'six', 'Female', 'leo', 'stella', 'alice'),
('12345678', '24', '7', 'female', 'leo', 'kom', 'sja');

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
CREATE TABLE IF NOT EXISTS `teachers` (
  `Username` varchar(200) NOT NULL,
  `Password` varchar(30) DEFAULT NULL,
  `Subject` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`Username`, `Password`, `Subject`) VALUES
('leo', 'opiosolo', 'english'),
('pilate', 'jerome', 'math'),
('alice', 'alicia', 'physics'),
('cheron', 'flowers', 'chemistry');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
