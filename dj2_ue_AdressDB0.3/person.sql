-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 16. Jun 2015 um 11:02
-- Server Version: 5.5.36
-- PHP-Version: 5.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `java2`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nachname` varchar(50) NOT NULL DEFAULT '---',
  `vorname` varchar(50) NOT NULL DEFAULT '---',
  `plz` varchar(6) NOT NULL,
  `ort` varchar(50) NOT NULL DEFAULT '---',
  `strasse` varchar(50) NOT NULL DEFAULT '---',
  `telefon` varchar(50) NOT NULL DEFAULT '---',
  `mobil` varchar(50) NOT NULL DEFAULT '---',
  `email` varchar(50) NOT NULL DEFAULT '---',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=74 ;

--
-- Daten für Tabelle `person`
--

INSERT INTO `person` (`id`, `nachname`, `vorname`, `plz`, `ort`, `strasse`, `telefon`, `mobil`, `email`) VALUES
(25, 'Schuster', 'Hans', '13456', 'Berlin', 'Waldweg 5', '4354353', '0177-543535', 'schuste@web.de'),
(26, 'Schulz', 'Ina', '33555', 'Hamburg', 'Teststraße 3', '5555', '01882332333', 'schulz@ee.de'),
(24, 'Meier', 'Anton', '23434', 'Dresdene', 'Parkstraße 4', '3333345400', '055-3665645', 'werwer@se.de'),
(27, 'Muller', 'Max', '32444', 'Bonn', 'Dorfstraße 34', '022-5435435', '0133-43534534', '134@gmx.de'),
(28, 'Müller', 'Max', '34324', 'Berlin', 'Hauptstraße 57', '030-346566', '0166-54645645', 'test@rrr.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
