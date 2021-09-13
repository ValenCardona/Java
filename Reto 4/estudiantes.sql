-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-08-2021 a las 17:39:22
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `estudiantes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `infoestudiantes`
--

CREATE TABLE `infoestudiantes` (
  `Nombres` varchar(60) NOT NULL,
  `Apellidos` varchar(60) NOT NULL,
  `FechaNacimiento` varchar(60) NOT NULL,
  `CorreoInstitucional` varchar(60) NOT NULL,
  `CorreoPersonal` varchar(60) NOT NULL,
  `NumeroCelular` bigint(60) NOT NULL,
  `NumeroFijo` bigint(60) NOT NULL,
  `ProgramaAcademico` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `infoestudiantes`
--

INSERT INTO `infoestudiantes` (`Nombres`, `Apellidos`, `FechaNacimiento`, `CorreoInstitucional`, `CorreoPersonal`, `NumeroCelular`, `NumeroFijo`, `ProgramaAcademico`) VALUES
('Luis Ernesto', 'Poveda Garcés', '1980-05-29', 'lpovedag@lafloresta.edu.co', 'luispov@hotmail.com', 3167556688, 2916565, 'Contaduría'),
('Mariana', 'Casas', '1984-02-12', 'mcasasp@lafloretsa.edu.co', 'mariana12@hotmail.com', 3125674488, 2654878, 'Medicina');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `infoestudiantes`
--
ALTER TABLE `infoestudiantes`
  ADD PRIMARY KEY (`CorreoInstitucional`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
