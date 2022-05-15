-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 09:01 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `powereg`
--

-- --------------------------------------------------------

--
-- Table structure for table `interruption`
--

CREATE TABLE `interruption` (
  `notificationId` int(5) NOT NULL,
  `notificationCode` varchar(5) NOT NULL,
  `message` varchar(200) NOT NULL,
  `date` varchar(20) NOT NULL,
  `timePeriod` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  `establishedBy` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `interruption`
--

INSERT INTO `interruption` (`notificationId`, `notificationCode`, `message`, `date`, `timePeriod`, `area`, `establishedBy`) VALUES
(5, 'N004', 'Power Cut due to constractions', '11/02/2022', '7-11 a.m', 'Piliyandala', 'Mr.Pam Perera'),
(6, 'N005', 'Power Cut', '09/03/2022', '7-9 p.m', 'Gampaha', 'Mr.Pam Perera'),
(10, 'N017', 'Power cut', '12/02/2022', '7-11 a.m', 'Kaluatara', 'Mr. Sam Silva'),
(13, 'N008', 'Power Cut', '20/02/2022', '10 - 11 a.m', 'Colombo 4', 'Mr. Sam Silva'),
(20, 'N008', 'Power Cut', '20/02/2022', '10 - 11 a.m', 'Colombo 4', 'Mr. Sam Silva');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `interruption`
--
ALTER TABLE `interruption`
  ADD PRIMARY KEY (`notificationId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `interruption`
--
ALTER TABLE `interruption`
  MODIFY `notificationId` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
