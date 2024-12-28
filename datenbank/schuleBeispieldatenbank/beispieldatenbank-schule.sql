-- phpMyAdmin SQL Dump
-- version 3.2.0
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 03. Februar 2014 um 17:07
-- Server Version: 5.0.45
-- PHP-Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Datenbank: `usr_web5_1`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ag`
--

CREATE TABLE IF NOT EXISTS `ag` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(40) character set utf8 collate utf8_unicode_ci NOT NULL,
  `lehrer_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Daten für Tabelle `ag`
--

INSERT INTO `ag` (`id`, `name`, `lehrer_id`) VALUES
(3, 'Theater', 2),
(4, 'Orchester', 1),
(5, 'Homepage', 3),
(6, 'Bigband', 1),
(7, 'Holzwerken', 3),
(8, 'Fotografie', 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `klasse`
--

CREATE TABLE IF NOT EXISTS `klasse` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(10) collate utf8_unicode_ci NOT NULL,
  `klassenlehrer_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=13 ;

--
-- Daten für Tabelle `klasse`
--

INSERT INTO `klasse` (`id`, `name`, `klassenlehrer_id`) VALUES
(1, '8A', 2),
(2, '8B', 4),
(3, '8C', 1),
(4, '8D', 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `lehrer`
--

CREATE TABLE IF NOT EXISTS `lehrer` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) collate utf8_unicode_ci NOT NULL,
  `vorname` varchar(20) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Daten für Tabelle `lehrer`
--

INSERT INTO `lehrer` (`id`, `name`, `vorname`) VALUES
(1, 'Buttenmüller', 'Georg'),
(2, 'Zimmermann', 'Josef'),
(3, 'Amann', 'Brigitte'),
(4, 'Huber', 'Erika'),
(5, 'Rees', 'Günter');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `raum`
--

CREATE TABLE IF NOT EXISTS `raum` (
  `id` int(11) NOT NULL auto_increment,
  `nummer` varchar(10) collate utf8_unicode_ci NOT NULL,
  `plaetze` int(11) NOT NULL,
  `etage` varchar(10) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Daten für Tabelle `raum`
--

INSERT INTO `raum` (`id`, `nummer`, `plaetze`, `etage`) VALUES
(1, 'R110', 12, 'unten'),
(2, 'R112', 14, 'unten'),
(3, 'R203', 30, 'Mitte'),
(4, 'R205', 16, 'Mitte'),
(5, 'R306', 18, 'oben'),
(6, 'Sporthalle', 100, 'unten'),
(7, 'R208', 32, 'oben'),
(8, 'R101', 32, 'unten');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `schueler`
--

CREATE TABLE IF NOT EXISTS `schueler` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) collate utf8_unicode_ci NOT NULL,
  `vorname` varchar(20) collate utf8_unicode_ci NOT NULL,
  `klasse_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=123 ;

--
-- Daten für Tabelle `schueler`
--

INSERT INTO `schueler` (`id`, `name`, `vorname`, `klasse_id`) VALUES
(1, 'Meier', 'Johannes', 2),
(2, 'Schwarzmüller', 'Maria', 3),
(3, 'Schmidt', 'Michael', 1),
(4, 'Ebert', 'Anne', 2),
(8, 'Zimmermann', 'Anne', 0),
(9, 'Wiesenhoff', 'Christian', 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `teilnahme`
--

CREATE TABLE IF NOT EXISTS `teilnahme` (
  `schueler_id` int(11) NOT NULL,
  `ag_id` int(11) NOT NULL,
  PRIMARY KEY  (`schueler_id`,`ag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `teilnahme`
--

INSERT INTO `teilnahme` (`schueler_id`, `ag_id`) VALUES
(1, 7),
(1, 8),
(2, 4),
(2, 6),
(3, 3),
(3, 4),
(3, 7),
(4, 5),
(4, 8);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `unterricht`
--

CREATE TABLE IF NOT EXISTS `unterricht` (
  `id` int(11) NOT NULL auto_increment,
  `klasse_id` int(11) NOT NULL,
  `lehrer_id` int(11) NOT NULL,
  `raum_id` int(11) NOT NULL,
  `fach` varchar(20) collate utf8_unicode_ci NOT NULL,
  `stunden` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

--
-- Daten für Tabelle `unterricht`
--

INSERT INTO `unterricht` (`id`, `klasse_id`, `lehrer_id`, `raum_id`, `fach`, `stunden`) VALUES
(1, 1, 2, 2, 'Deutsch', 4),
(2, 1, 3, 4, 'Mathe', 4),
(3, 1, 4, 6, 'Sport', 3),
(4, 2, 2, 4, 'Deutsch', 4),
(5, 2, 4, 1, 'Sport', 3),
(6, 3, 4, 3, 'Deutsch', 4),
(7, 3, 1, 2, 'Englisch', 4),
(8, 3, 2, 5, 'Geschichte', 2),
(9, 3, 4, 6, 'Sport', 3);
