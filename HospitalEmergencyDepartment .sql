-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 15, 2021 at 11:46 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `HospitalEmergencyDepartment`
--

-- --------------------------------------------------------

--
-- Table structure for table `Administrative staff`
--

CREATE TABLE `Administrative staff` (
  `PID` int(11) NOT NULL,
  `First_Name` varchar(30) NOT NULL,
  `Last_Name` varchar(30) NOT NULL,
  `Address` text NOT NULL,
  `Birthdate` date NOT NULL,
  `Phone` varchar(13) NOT NULL,
  `Sex` varchar(10) NOT NULL,
  `Years_of_service` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Administrative staff`
--

INSERT INTO `Administrative staff` (`PID`, `First_Name`, `Last_Name`, `Address`, `Birthdate`, `Phone`, `Sex`, `Years_of_service`) VALUES
(1, 'Vasilis', 'Mpaxlis', 'marousi Attikh', '2021-01-03', '45554686', 'male', 12),
(2, 'Vagelio', 'Athanasaki', 'Amoudara Heraklion', '2021-01-07', '698354587', 'female', 6),
(3, 'Evageli', 'Patsouri', 'Souidia', '2021-01-12', '5487856578', 'female', 9),
(6, 'kausas', 'kioriou', '1123', '2222-02-22', '454244', 'Female', 32),
(7, 'kausas', 'kausopoulos', 'sfigos 154', '1111-11-11', '345123', 'Female', 213);

-- --------------------------------------------------------

--
-- Table structure for table `ChronicCondition`
--

CREATE TABLE `ChronicCondition` (
  `AMKA` int(11) NOT NULL,
  `Diagnosis_date` date NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ChronicCondition`
--

INSERT INTO `ChronicCondition` (`AMKA`, `Diagnosis_date`, `Name`) VALUES
(6234523, '0001-01-01', '-'),
(1242144, '2021-01-12', 'sadsdasad'),
(12323, '2021-01-13', 'polumelitida'),
(123123, '2332-12-31', '123123');

-- --------------------------------------------------------

--
-- Table structure for table `Diagnosis`
--

CREATE TABLE `Diagnosis` (
  `Diagnosis_ID` int(11) NOT NULL,
  `AMKA` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Examination_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Diagnosis`
--

INSERT INTO `Diagnosis` (`Diagnosis_ID`, `AMKA`, `Name`, `Examination_ID`) VALUES
(48, 6234523, 'null', 25),
(49, 232454842, 'null', 26),
(50, 232454842, 'null', 27),
(51, 421313124, 'Fracture', 28),
(52, 232454842, 'null', 29),
(53, 421313124, 'Fracture', 30),
(54, 421313124, 'Fracture', 31),
(55, 421313124, 'Fracture', 32),
(56, 12323, 'Gastrenteritida', 33),
(57, 421313124, 'Fracture', 34),
(58, 111111, 'kardiaki aneparkeia', 35),
(59, 111111, 'kardiaki aneparkeia', 36),
(60, 232454842, 'kardiaki aneparkeia', 37),
(61, 232454842, 'kardiaki aneparkeia', 38),
(62, 111111, 'kardiaki aneparkeia', 39),
(63, 12323, 'Gastrenteritida', 40),
(64, 232454842, 'kardiaki aneparkeia', 41),
(65, 12323, 'Gastrenteritida', 42),
(66, 12323, 'Gastrenteritida', 43),
(67, 12323, 'Gastrenteritida', 44),
(68, 111111, 'kardiaki aneparkeia', 45),
(69, 232454842, 'kardiaki aneparkeia', 46),
(70, 111111, 'kardiaki aneparkeia', 47),
(71, 232454842, 'kardiaki aneparkeia', 48),
(72, 12323, 'Gastrenteritida', 49),
(73, 6234523, 'null', 50),
(74, 6234523, 'null', 51),
(75, 232454842, 'kardiaki aneparkeia', 52),
(76, 123123, 'Gastrenteritida', 53),
(77, 12323, 'Gastrenteritida', 54),
(78, 111111, 'kardiaki aneparkeia', 55),
(79, 6234523, 'null', 56),
(80, 6234523, 'null', 57),
(81, 6234523, 'null', 58),
(82, 232454842, 'kardiaki aneparkeia', 59),
(83, 6234523, 'null', 60),
(84, 232454842, 'kardiaki aneparkeia', 61),
(85, 12323, 'Gastrenteritida', 62);

-- --------------------------------------------------------

--
-- Table structure for table `Disease`
--

CREATE TABLE `Disease` (
  `Diagnosis_ID` int(11) NOT NULL,
  `Disease` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Disease`
--

INSERT INTO `Disease` (`Diagnosis_ID`, `Disease`) VALUES
(31, 'Fracture'),
(32, 'Migraine'),
(34, 'null');

-- --------------------------------------------------------

--
-- Table structure for table `Doctor`
--

CREATE TABLE `Doctor` (
  `PID` int(11) NOT NULL,
  `First_Name` varchar(30) NOT NULL,
  `Last_Name` varchar(30) NOT NULL,
  `Address` text NOT NULL,
  `Birthdate` date NOT NULL,
  `Sex` varchar(13) NOT NULL,
  `Phone` varchar(13) NOT NULL,
  `Specialization` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Doctor`
--

INSERT INTO `Doctor` (`PID`, `First_Name`, `Last_Name`, `Address`, `Birthdate`, `Sex`, `Phone`, `Specialization`) VALUES
(29, 'Loukas', 'Merkouris', 'Vagia sfigos', '2021-01-19', 'male', '6983656908', 'kardiologos'),
(30, 'Manos', 'Lourakis', 'kritovoulidou Heraklion', '2021-01-04', 'male', '6548481', 'covid'),
(38, 'Andreas ', 'Falelakis', 'Koudoura', '2021-01-14', 'male', '6985645123', 'arthrologos'),
(39, 'Panos', 'Doulis', 'kritovoulidou 1 Heraklion', '2021-01-21', 'male', '6943658525', 'kardiologos'),
(40, 'Dionisis', 'Xristogiannis', 'who knows', '2021-01-30', 'female', '6985625625', 'pathologos'),
(44, 'Zhnovia', 'Xouridi', 'Gorgoloaini 17', '2021-01-30', 'female', '85625625', 'pneumatologos'),
(46, 'kausas', 'kausopoulos', 'sfigos 154', '0011-11-11', 'Male', '12344123', 'kardiologos'),
(48, 'asdasdsafg', 'kioriou', '123421421', '4221-11-23', 'Female', '55555', 'covid'),
(49, 'kausas', 'kioriou', 'idi 231', '1234-11-11', 'Female', '12442332', 'arthrologos');

-- --------------------------------------------------------

--
-- Table structure for table `Examination`
--

CREATE TABLE `Examination` (
  `Examination_ID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `type` varchar(50) NOT NULL,
  `PID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Examination`
--

INSERT INTO `Examination` (`Examination_ID`, `Date`, `type`, `PID`) VALUES
(1, '1111-11-11', 'Blood test', 14),
(2, '2332-11-11', 'Covid test', 13),
(3, '1244-12-31', 'Covid test', 13),
(4, '1244-12-31', 'Covid test', 13),
(5, '1244-12-31', 'Covid test', 13),
(6, '1244-12-31', 'Covid test', 13),
(7, '1244-12-31', 'Covid test', 13),
(8, '1244-12-31', 'Covid test', 13),
(9, '2233-12-31', 'Covid test', 13),
(10, '3333-11-12', 'Physical examination', 15),
(11, '1111-11-11', 'Blood test', 14),
(12, '1111-11-11', 'Blood test', 14),
(13, '0111-11-11', 'Covid test', 13),
(14, '1123-11-11', 'Covid test', 13),
(15, '0332-11-12', 'Covid test', 13),
(16, '0332-11-12', 'Physical examination', 15),
(17, '4433-12-31', 'Covid test', 13),
(18, '3221-11-23', 'X-Ray', 9),
(19, '2112-12-31', 'Blood test', 14),
(20, '2123-12-31', 'Blood test', 14),
(21, '2123-12-31', 'Blood test', 14),
(26, '1111-11-11', 'Blood test', 14),
(27, '1111-11-11', 'Blood test', 14),
(28, '2121-02-12', 'Physical examination', 15),
(29, '1212-12-12', 'Covid test', 13),
(30, '0111-11-11', 'Physical examination', 15),
(31, '0111-11-11', 'Covid test', 13),
(32, '0111-11-11', 'Covid test', 13),
(33, '0111-11-11', 'X-Ray', 9),
(34, '1111-11-11', 'Blood test', 14),
(35, '1111-11-11', 'Physical examination', 15),
(36, '0132-11-12', 'X-Ray', 9),
(37, '7656-11-23', 'Blood test', 14),
(38, '2212-12-31', 'Blood test', 14),
(39, '1112-12-31', 'Blood test', 14),
(40, '1233-12-31', 'Blood test', 14),
(41, '2123-12-31', 'X-Ray', 9),
(42, '2212-11-23', 'Covid test', 13),
(43, '2212-11-23', 'Covid test', 13),
(44, '2212-11-23', 'Covid test', 13),
(45, '3123-11-11', 'Blood test', 14),
(46, '1997-04-21', 'X-Ray', 9),
(47, '1111-11-11', 'Physical examination', 15),
(48, '1111-11-11', 'Physical examination', 15),
(49, '0111-11-11', 'Physical examination', 15),
(50, '1233-11-23', 'Blood test', 14),
(51, '1233-11-23', 'Blood test', 14),
(52, '1343-11-22', 'Covid test', 13),
(53, '2123-12-31', 'Physical examination', 15),
(54, '3323-11-12', 'Covid test', 13),
(55, '2123-12-31', 'Covid test', 13),
(56, '1221-02-12', 'Covid test', 13),
(57, '1221-02-12', 'Covid test', 13),
(58, '1221-02-12', 'Covid test', 13),
(59, '1221-02-12', 'Covid test', 13),
(60, '2123-12-31', 'X-Ray', 9),
(61, '2123-12-31', 'X-Ray', 9),
(62, '2123-12-31', 'X-Ray', 9);

-- --------------------------------------------------------

--
-- Table structure for table `Examines`
--

CREATE TABLE `Examines` (
  `PID` int(11) NOT NULL,
  `Diagnosis_ID` int(11) NOT NULL,
  `Code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Medicine`
--

CREATE TABLE `Medicine` (
  `Code` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Inclusiveness` double NOT NULL,
  `Disease_med` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Medicine`
--

INSERT INTO `Medicine` (`Code`, `Name`, `Inclusiveness`, `Disease_med`, `Type`) VALUES
(12, 'Nurofen', 500, 'Migraine', 'Pill'),
(13, 'Lexotanil', 1000, 'Fracture', 'Pill'),
(69, 'Covid Vacine', 100, 'Covid', 'Enjectable'),
(420, 'Imodium', 1000, 'Gastrenteritida', 'pill'),
(666, 'Perfan', 400, 'kardiaki aneparkeia', 'Paste');

-- --------------------------------------------------------

--
-- Table structure for table `Nurse`
--

CREATE TABLE `Nurse` (
  `PID` int(11) NOT NULL,
  `First_Name` varchar(30) NOT NULL,
  `Last_Name` varchar(30) NOT NULL,
  `Address` text NOT NULL,
  `Birthdate` date NOT NULL,
  `Phone` varchar(13) NOT NULL,
  `Sex` varchar(10) NOT NULL,
  `Expertise` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Nurse`
--

INSERT INTO `Nurse` (`PID`, `First_Name`, `Last_Name`, `Address`, `Birthdate`, `Phone`, `Sex`, `Expertise`) VALUES
(9, 'Panos', 'Papavasiliou', 'madoudi evias', '2021-01-12', '6986365897', 'male', 'X-Ray'),
(13, 'kalisperas', 'kalispero', 'idi 23', '1233-11-23', '124422341', 'Female', 'Covid test'),
(14, 'Kwstas', 'Lamprou', 'Athens plapounta 2', '2020-10-07', '698365312', 'male', 'Blood test'),
(15, 'Dimitris', 'Zerkoulis', 'Romania', '2021-01-15', '44745632', 'male', 'Physical examination');

-- --------------------------------------------------------

--
-- Table structure for table `OnShift`
--

CREATE TABLE `OnShift` (
  `ID` int(11) NOT NULL,
  `PPID` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `OnShift`
--

INSERT INTO `OnShift` (`ID`, `PPID`, `Date`) VALUES
(4, 46, '0000-00-00'),
(4, 49, '0000-00-00'),
(2, 44, '1111-02-12'),
(2, 40, '1111-02-12'),
(2, 29, '1111-02-12'),
(2, 9, '1111-02-12'),
(2, 13, '1111-02-12'),
(2, 14, '1111-02-12'),
(2, 1, '1111-02-12'),
(2, 2, '1111-02-12'),
(2, 3, '1111-02-12'),
(2, 7, '1111-02-12'),
(3, 44, '2021-01-14'),
(3, 9, '2021-01-14'),
(3, 3, '2021-01-14'),
(4, 44, '2021-01-15'),
(4, 40, '2021-01-15'),
(4, 29, '2021-01-15'),
(4, 9, '2021-01-15'),
(4, 13, '2021-01-15'),
(4, 15, '2021-01-15'),
(4, 7, '2021-01-15'),
(4, 1, '2021-01-15'),
(4, 3, '2021-01-15'),
(4, 12323, '2021-01-15'),
(4, 421313125, '2021-01-15'),
(4, 12323, '2021-01-15'),
(4, 421313125, '2021-01-15'),
(4, 123123, '2021-01-15');

-- --------------------------------------------------------

--
-- Table structure for table `Patient`
--

CREATE TABLE `Patient` (
  `AMKA` int(11) NOT NULL,
  `First_Name` varchar(30) NOT NULL,
  `Last_Name` varchar(30) NOT NULL,
  `Address` text NOT NULL,
  `Insurance` varchar(50) NOT NULL,
  `Phone` varchar(13) NOT NULL,
  `PID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Patient`
--

INSERT INTO `Patient` (`AMKA`, `First_Name`, `Last_Name`, `Address`, `Insurance`, `Phone`, `PID`) VALUES
(12323, 'ANDRONIKO', 'NIKOLO', 'IOANNINA', 'Agrotiki', '6984', 29),
(111111, 'ANDRONIKO', 'NIKOLO', 'IOANNINA', 'Agrotiki', '6984', 30),
(123123, 'ANDRONIKO', 'NIKOLO', 'IOANNINA', 'Agrotiki', '6984', 38),
(1242144, 'kausas', 'kausopoulos', 'mandilara 2', 'delewdelew', '15424201', 21),
(6234523, 'loukas', 'merkouris', 'sfigos 18', 'idiwtikh', '6982565327', 44),
(232454842, 'Stratos', 'Lekas', 'athina', 'Idiotikh', '75856253', 44),
(421313124, 'Vasilis', 'Mpaxlis', 'Athina', 'Agrotiki', '698752584', 38),
(421313125, 'VISI', 'ZERKOULIS', 'MIXAIL ARVANITAKI', 'GUMNASTIRIAKH', '698754123', 44);

-- --------------------------------------------------------

--
-- Table structure for table `Personnel`
--

CREATE TABLE `Personnel` (
  `PID` int(11) NOT NULL,
  `First_Name` varchar(30) NOT NULL,
  `Last_Name` varchar(30) NOT NULL,
  `Address` text NOT NULL,
  `Birthdate` date NOT NULL,
  `Phone` varchar(13) NOT NULL,
  `Sex` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Prescribes`
--

CREATE TABLE `Prescribes` (
  `Diagnosis_ID` int(11) NOT NULL,
  `Code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Prescribes`
--

INSERT INTO `Prescribes` (`Diagnosis_ID`, `Code`) VALUES
(55, 13),
(56, 666),
(57, 13),
(58, 666),
(59, 666),
(60, 666),
(61, 666),
(62, 666),
(63, 666),
(64, 666),
(65, 666),
(66, 666),
(67, 666),
(68, 666),
(69, 666),
(70, 666),
(71, 666),
(72, 666),
(75, 666),
(76, 666),
(77, 666),
(78, 666),
(82, 666),
(84, 666),
(85, 666);

-- --------------------------------------------------------

--
-- Table structure for table `Previous visit`
--

CREATE TABLE `Previous visit` (
  `AMKA` int(11) NOT NULL,
  `ExaminationID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Diagnosis` varchar(50) NOT NULL,
  `Examination` text NOT NULL,
  `Cure` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Previous visit`
--

INSERT INTO `Previous visit` (`AMKA`, `ExaminationID`, `Date`, `Diagnosis`, `Examination`, `Cure`) VALUES
(421313124, 45, '2021-01-15', 'Egauma', 'Epese me thn mhxanh kai gdarthike to aristero tou podari', 'Bebanthol'),
(232454842, 31, '2021-01-14', 'Covid', 'Eixe kourasi , pureto kai kataroh', 'Covid Vacine'),
(111111, 12, '2021-01-02', 'Imikrania', 'Polu ponokefalo', 'Depon'),
(232454842, 61, '2123-12-31', 'kardiaki aneparkeia', 'X-Ray', 'Perfan'),
(12323, 62, '2123-12-31', 'Gastrenteritida', 'X-Ray', 'Perfan'),
(12323, 62, '2123-12-31', 'Gastrenteritida', 'X-Ray', 'Perfan');

-- --------------------------------------------------------

--
-- Table structure for table `Shift`
--

CREATE TABLE `Shift` (
  `Shift_ID` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Shift`
--

INSERT INTO `Shift` (`Shift_ID`, `Date`) VALUES
(1, '2009-10-07'),
(2, '1111-02-12'),
(3, '2021-01-14'),
(4, '2021-01-15');

-- --------------------------------------------------------

--
-- Table structure for table `Symptoms`
--

CREATE TABLE `Symptoms` (
  `AMKA` int(11) NOT NULL,
  `Symptoms` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Symptoms`
--

INSERT INTO `Symptoms` (`AMKA`, `Symptoms`) VALUES
(123123, 'Headache'),
(232454842, 'Stomachache'),
(123123, 'Abdominal pain'),
(123123, 'Abdominal pain'),
(232454842, 'Choose...'),
(232454842, 'Choose...'),
(232454842, 'Abdominal pain'),
(232454842, 'Abdominal pain'),
(421313124, 'Wound'),
(421313124, 'Wound'),
(421313125, 'Wound'),
(421313125, 'Wound'),
(421313125, 'Stomachache'),
(421313125, 'Stomachache'),
(12323, 'Abdominal pain'),
(12323, 'Abdominal pain'),
(12323, 'Weariness'),
(123123, 'Weariness'),
(123123, 'Weariness'),
(123123, 'Headache'),
(123123, 'Headache'),
(123123, 'Weariness'),
(123123, 'Weariness'),
(123123, 'Abdominal pain'),
(123123, 'Abdominal pain'),
(123123, 'Weariness'),
(123123, 'Weariness'),
(123123, 'Wound'),
(123123, 'Wound'),
(123123, 'Stomachache'),
(123123, 'Stomachache'),
(12323, 'Stomachache'),
(12323, 'Stomachache'),
(421313125, 'Abdominal pain'),
(421313125, 'Abdominal pain'),
(421313125, 'Abdominal pain'),
(421313125, 'Abdominal pain'),
(111111, 'Abdominal pain'),
(111111, 'Abdominal pain'),
(421313124, 'Stomachache'),
(421313124, 'Stomachache'),
(421313124, 'Wound'),
(421313124, 'Wound'),
(12323, 'Abdominal pain'),
(12323, 'Abdominal pain'),
(12323, 'Stomachache'),
(12323, 'Stomachache'),
(123123, 'Abdominal pain'),
(123123, 'Abdominal pain'),
(123123, 'Wound'),
(123123, 'Wound'),
(12323, 'Weariness'),
(12323, 'Weariness'),
(421313125, 'Abdominal pain'),
(421313125, 'Abdominal pain'),
(12323, 'Abdominal pain'),
(12323, 'Abdominal pain'),
(421313125, 'Stomachache'),
(421313125, 'Stomachache'),
(123123, 'Wound'),
(123123, 'Wound');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Administrative staff`
--
ALTER TABLE `Administrative staff`
  ADD PRIMARY KEY (`PID`),
  ADD UNIQUE KEY `phone_number` (`Phone`);

--
-- Indexes for table `ChronicCondition`
--
ALTER TABLE `ChronicCondition`
  ADD UNIQUE KEY `chronic_condition_diagnosis_date` (`Diagnosis_date`),
  ADD KEY `diagnosis_data_chronic` (`AMKA`);

--
-- Indexes for table `Diagnosis`
--
ALTER TABLE `Diagnosis`
  ADD PRIMARY KEY (`Diagnosis_ID`),
  ADD UNIQUE KEY `examination` (`Examination_ID`);

--
-- Indexes for table `Disease`
--
ALTER TABLE `Disease`
  ADD PRIMARY KEY (`Diagnosis_ID`);

--
-- Indexes for table `Doctor`
--
ALTER TABLE `Doctor`
  ADD PRIMARY KEY (`PID`),
  ADD UNIQUE KEY `phone_number` (`Phone`);

--
-- Indexes for table `Examination`
--
ALTER TABLE `Examination`
  ADD PRIMARY KEY (`Examination_ID`),
  ADD KEY `PID` (`PID`);

--
-- Indexes for table `Examines`
--
ALTER TABLE `Examines`
  ADD KEY `PID` (`PID`),
  ADD KEY `Diagnosis_ID` (`Diagnosis_ID`),
  ADD KEY `Code` (`Code`);

--
-- Indexes for table `Medicine`
--
ALTER TABLE `Medicine`
  ADD PRIMARY KEY (`Code`),
  ADD UNIQUE KEY `medicine_name` (`Name`);

--
-- Indexes for table `Nurse`
--
ALTER TABLE `Nurse`
  ADD PRIMARY KEY (`PID`),
  ADD UNIQUE KEY `phone_number` (`Phone`);

--
-- Indexes for table `Patient`
--
ALTER TABLE `Patient`
  ADD PRIMARY KEY (`AMKA`);

--
-- Indexes for table `Personnel`
--
ALTER TABLE `Personnel`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `Prescribes`
--
ALTER TABLE `Prescribes`
  ADD UNIQUE KEY `diagnosis id` (`Diagnosis_ID`);

--
-- Indexes for table `Shift`
--
ALTER TABLE `Shift`
  ADD PRIMARY KEY (`Shift_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Administrative staff`
--
ALTER TABLE `Administrative staff`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `Diagnosis`
--
ALTER TABLE `Diagnosis`
  MODIFY `Diagnosis_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- AUTO_INCREMENT for table `Disease`
--
ALTER TABLE `Disease`
  MODIFY `Diagnosis_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `Doctor`
--
ALTER TABLE `Doctor`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `Examination`
--
ALTER TABLE `Examination`
  MODIFY `Examination_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `Medicine`
--
ALTER TABLE `Medicine`
  MODIFY `Code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=667;

--
-- AUTO_INCREMENT for table `Nurse`
--
ALTER TABLE `Nurse`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `Patient`
--
ALTER TABLE `Patient`
  MODIFY `AMKA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=421313130;

--
-- AUTO_INCREMENT for table `Personnel`
--
ALTER TABLE `Personnel`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Shift`
--
ALTER TABLE `Shift`
  MODIFY `Shift_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ChronicCondition`
--
ALTER TABLE `ChronicCondition`
  ADD CONSTRAINT `diagnosis_data_chronic` FOREIGN KEY (`AMKA`) REFERENCES `Patient` (`AMKA`);

--
-- Constraints for table `Examination`
--
ALTER TABLE `Examination`
  ADD CONSTRAINT `Examination_ibfk_1` FOREIGN KEY (`PID`) REFERENCES `Nurse` (`PID`);

--
-- Constraints for table `Examines`
--
ALTER TABLE `Examines`
  ADD CONSTRAINT `Examines_ibfk_1` FOREIGN KEY (`PID`) REFERENCES `Doctor` (`PID`),
  ADD CONSTRAINT `Examines_ibfk_2` FOREIGN KEY (`Diagnosis_ID`) REFERENCES `Diagnosis` (`Diagnosis_ID`),
  ADD CONSTRAINT `Examines_ibfk_3` FOREIGN KEY (`Code`) REFERENCES `Medicine` (`Code`);

--
-- Constraints for table `OnShift`
--
ALTER TABLE `OnShift`
  ADD CONSTRAINT `shift` FOREIGN KEY (`ID`) REFERENCES `Shift` (`Shift_ID`);

--
-- Constraints for table `Prescribes`
--
ALTER TABLE `Prescribes`
  ADD CONSTRAINT `Prescribes_ibfk_2` FOREIGN KEY (`Diagnosis_ID`) REFERENCES `Diagnosis` (`Diagnosis_ID`);

--
-- Constraints for table `Previous visit`
--
ALTER TABLE `Previous visit`
  ADD CONSTRAINT `patient's Previous visit` FOREIGN KEY (`AMKA`) REFERENCES `Patient` (`AMKA`);

--
-- Constraints for table `Symptoms`
--
ALTER TABLE `Symptoms`
  ADD CONSTRAINT `Symptoms_ibfk_1` FOREIGN KEY (`AMKA`) REFERENCES `Patient` (`AMKA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
