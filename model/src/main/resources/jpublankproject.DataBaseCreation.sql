-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 15 Juin 2016 à 09:29
-- Version du serveur :  5.7.9
-- Version de PHP :  5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jpublankproject`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `helloworldById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `helloworldById` (IN `p_id` INT)  READS SQL DATA
  SQL SECURITY INVOKER
  SELECT * FROM helloworld WHERE id = p_id$$

DROP PROCEDURE IF EXISTS `HelloworldByKey`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `HelloworldByKey` (IN `p_key` VARCHAR(2))  READS SQL DATA
  SQL SECURITY INVOKER
  SELECT * FROM jpublankproject.helloworld where `key`=p_key$$

DROP PROCEDURE IF EXISTS `loadmapById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapById` (IN `p_id` INT)  NO SQL
  SELECT * FROM map WHERE map_id = p_id$$

DROP PROCEDURE IF EXISTS `loadmapByKey`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapByKey` (IN `p_key` VARCHAR(50))  NO SQL
  SELECT * FROM jpublankproject.map where `map_name`=p_key$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `helloworld`
--

DROP TABLE IF EXISTS `helloworld`;
CREATE TABLE IF NOT EXISTS `helloworld` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(2) CHARACTER SET latin1 NOT NULL,
  `message` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_UNIQUE` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `helloworld`
--

INSERT INTO `helloworld` (`id`, `key`, `message`) VALUES
  (1, 'GB', 'Hello world'),
  (2, 'FR', 'Bonjour le monde'),
  (3, 'DE', 'Hallo Welt'),
  (4, 'ID', 'Salamat pagi dunia');

-- --------------------------------------------------------

--
-- Structure de la table `highscore`
--

DROP TABLE IF EXISTS `highscore`;
CREATE TABLE IF NOT EXISTS `highscore` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL,
  `nickname` varchar(50) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_name` varchar(50) CHARACTER SET latin1 NOT NULL,
  `map` text CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `map`
--

INSERT INTO `map` (`id`, `map_name`, `map`) VALUES
  (1, 'MAP1', 'BHHHHHHHHHHHHHHHHHHB\nV    V             V\nV    V             V\nV    V     P       V\nV  P BHHHHHB       V\nV P P1     K  L   CV\nV  P BHHHHHB       V\nV    V     P       V\nV    V             V\nV    V             V\nV    V             V\nBHHHHHHHHHHHHHHHHHHB'),
  (2, 'MAP2', '  BBHHHHHHHHHHHHHHHB\n BB                V\nBB               L V\nB C BHHHHHHHB B BHHB\nV   V    2    V    V\nV   V BHHHHHHHBHHB V\nV   V    4    V    V\nV   BHHHHHHHB V BHHB\nV   V    3    V    V\nB   V BHHHHHHBBHHB V\nVK  V    1   V     V\nBHHHBHHHHHHHHBHHHHHB'),
  (3, 'MAP3', 'BHHHHHBHHHHHHHHBHHB \nV     B       BB  VB\nV L   BB     BB   VB\nV      BB  1 B    VB\nV   BB  BB  BB    VB\nV BBB      BB     VB\nBBB   2  K  3  BB VB\nV      B        BBVB\nV    BBB  4  BB  BBB\nV   BB        BB   B\nBHHHBHHHHHHHHHHBB CB\n BBBBBBBBBBBBBBBBBBB'),
  (4, 'MAP4', '  BHHBHHHHHHHHHHHB  \n BB  B           BB \nBB     B BPBPB B  BB\nV  BBB BHBHBHBHBB  V\nV  BVV         V   V\nV   VBHB BHHHB VB  V\nV  BVV   BHB   V   V\nV   BBL  BHB  CVB  V\nV  BHHH BHHHHHHBB  V\nBB  B B B B B BB3KBB\n BB      4  1  2 BB \n  BHHHHHHHHHHHHHHB  '),
  (5, 'MAP5', ' BHHHHHBB           \nB      KBHHB        \nV BHHHB   PBHHB     \nV1       B   PBHHB  \nV BHHB B   B    PBHB\nV2       B V   L  PV\nV BHHB B   B    PBHB\nV3       B   PBHHB  \nV BHHHB   PBHHB     \nBC      BHHB        \n BHHHHHBB           '),
  (6, 'MAP6', 'BHHHHHHHHHHHHHHHHHHB\nV            1    KV\nV BHB   BHB   4    V\nV              3   V\nV   BHB P BHB   2  V\nV                P V\nV     BHB P BHB   PV\nV                  V\nV       BHB P BHB  V\nV  L               V\nVC        BHB P BHHB\nBHHHHHHHHHB BHHHB   '),
  (7, 'MAP7', 'BHHHHHHHHHHHHHHHHHHB\nV                  V\nV    L   BB   C    V\nBHB  B   VV   B  BHB\n  BB V BHBBHB V BB  \n   B V BHBBHB V B   \n  BB V   VV   V BB  \n BBPPVP PVVP PVPPBB \nBB   B   VV   B   BB\nV2   K   BB       4V\nV3                1V\nBHHHHHHHHHHHHHHHHHHB'),
  (8, 'MAP8', ' BHHB            \n BB2BHHB   BHHB  \n  V    BB  V4 V  \n BB BHBKVB VB V  \nBB  B   V  VB VB \nBC   BB BHHB  BHB\n BB   V  LB     B\n  BB  BHHB  BB  B\n   B3       BHHHB\n   BHHBBP PBV    \n      BHBBBHB    '),
  (9, 'MAP9', 'BHHBHHHBHHHHHBHHBHHB\nV  B         V  B LV\nBHB          B     V\nV  BHHHHHHHBB      V\nV          B     BVB\nV  B     C         V\nBHB    B      B    V\nV2 B B  BHB BHBBBHHB\nV  V  B    B3  B   V\nV  V1 V  K V   V   V\nV  V  V4   V   V   V\nBHHBHHBHHHHBHHHBHHHB'),
  (10, 'TEST', 'BVHPL\n1234 \nCO   '),
  (17, 'MENU', 'BHHHHHHHHHHHHHHHHHHB\nV         L        V\nV  BHBHHHHHHHHBHB  V\nV    V        V    V\nBHHB V        V BHHB\nB  B V        V B  B\nBB   V        V   BB\nBBHHHB        BHHHBB\nV    V        V    V\nBHHHHBHHHHHHHHBHHHHB\nV         1        V\nBHHHHHHHHHHHHHHHHHHB'),
  (18, 'WORKSHOP', 'BHHHHHHHHHHHHHHHHHHB\nV                  V\nV                  V\nV                  V\nO                  V\nV        L         V\nV                  V\nV                  V\nV                  V\nV                  V\nV                  V\nBHHHHHHHHHHHHHHHHHHB');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
