-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2021 at 05:12 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_crud_java_mvc_vebri`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_pelanggan`
--

CREATE TABLE `tb_pelanggan` (
  `id` int(11) NOT NULL,
  `nama_pelanggan` varchar(255) NOT NULL,
  `telpon_pelanggan` varchar(255) NOT NULL,
  `alamat_pelanggan` varchar(255) NOT NULL,
  `status_pelanggan` varchar(255) NOT NULL,
  `paket_pelanggan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pelanggan`
--

INSERT INTO `tb_pelanggan` (`id`, `nama_pelanggan`, `telpon_pelanggan`, `alamat_pelanggan`, `status_pelanggan`, `paket_pelanggan`) VALUES
(7, 'VEBRI YUSDI', '0895', 'PUSKOPAD', 'Kontrak Selamanya', 'PLATINUM (App,Hosting Max 5000 User/Day,Teknisi,Support 7x24) Rp.300.000'),
(8, 'JIWO', '0867', 'MALANG', 'Kontrak 3x (3 Pemilihan)', 'SILVER (App,Hosting Max 1000 User/Day) Rp.100.000'),
(9, 'REYHAN', '0885', 'KACHUK', 'Kontrak 1x (1 Pemilihan)', 'BRONZE (App,Hosting Max 500 User/Day) Rp.50.000'),
(10, 'MAUL', '0865', 'ARJOSARI', 'Kontrak 5x (5 Pemilihan)', 'GOLD (App,Hosting Max 2000 User/Day, Teknisi) Rp.200.000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
