-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 26 fév. 2020 à 14:50
-- Version du serveur :  8.0.15
-- Version de PHP :  7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `elem`
--

-- --------------------------------------------------------

--
-- Structure de la table `annee`
--

DROP TABLE IF EXISTS `annee`;
CREATE TABLE IF NOT EXISTS `annee` (
  `idAnnee` int(11) NOT NULL,
  `value` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`idAnnee`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `annee_trimestre`
--

DROP TABLE IF EXISTS `annee_trimestre`;
CREATE TABLE IF NOT EXISTS `annee_trimestre` (
  `id` int(11) NOT NULL,
  `idAnnee` int(11) NOT NULL,
  `endDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  PRIMARY KEY (`idAnnee`,`id`),
  KEY `FKc4pxhylxw0acra81nhjrwqjjf` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `idClasse` int(11) NOT NULL,
  `name` varchar(4) NOT NULL,
  PRIMARY KEY (`idClasse`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `classe_annee`
--

DROP TABLE IF EXISTS `classe_annee`;
CREATE TABLE IF NOT EXISTS `classe_annee` (
  `idAnnee` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  PRIMARY KEY (`idAnnee`,`idClasse`),
  KEY `FK5gj0f14616b7r351au6pb11kd` (`idClasse`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `classe_eleve`
--

DROP TABLE IF EXISTS `classe_eleve`;
CREATE TABLE IF NOT EXISTS `classe_eleve` (
  `idAnnee` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idEleve` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAnnee`,`idClasse`,`idEleve`),
  KEY `FKiowrav8chudx14v2fv7nni8bo` (`idEleve`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `classe_enseignant`
--

DROP TABLE IF EXISTS `classe_enseignant`;
CREATE TABLE IF NOT EXISTS `classe_enseignant` (
  `idAnnee` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `matricule` varchar(10) NOT NULL,
  `endDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  PRIMARY KEY (`idAnnee`,`idClasse`,`matricule`),
  KEY `FKhetrmao9nqmt5qger1bq56kjb` (`matricule`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `classe_matiere`
--

DROP TABLE IF EXISTS `classe_matiere`;
CREATE TABLE IF NOT EXISTS `classe_matiere` (
  `idAnnee` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idMatiere` int(11) NOT NULL,
  `bareme` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAnnee`,`idClasse`,`idMatiere`),
  KEY `FK2g14280y7mdao7gubk7ega9do` (`idMatiere`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `idEleve` int(11) NOT NULL,
  `birthDate` date NOT NULL,
  `father` varchar(20) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `mother` varchar(20) NOT NULL,
  `place` varchar(20) NOT NULL,
  PRIMARY KEY (`idEleve`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`idEleve`, `birthDate`, `father`, `firstName`, `gender`, `lastName`, `mother`, `place`) VALUES
(1, '1985-02-26', 'PAPA', 'Mamadou', 'MASCULIN', 'DIOP', 'MAMAN', 'DAKAR'),
(2, '1985-02-04', 'FATHER', 'ASMA', 'FEMININ', 'FALL', 'HAFSA', 'MPL');

-- --------------------------------------------------------

--
-- Structure de la table `eleve_matricule`
--

DROP TABLE IF EXISTS `eleve_matricule`;
CREATE TABLE IF NOT EXISTS `eleve_matricule` (
  `idEleve` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idAnnee` int(11) NOT NULL,
  `idMatricule` int(11) NOT NULL,
  PRIMARY KEY (`idEleve`,`idMatricule`),
  KEY `FK8bmviioemr7qp9hsa2p72grqp` (`idMatricule`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `matricule` varchar(10) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `idMatiere` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`idMatiere`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `matricule`
--

DROP TABLE IF EXISTS `matricule`;
CREATE TABLE IF NOT EXISTS `matricule` (
  `idMatricule` int(11) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`idMatricule`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `notes`
--

DROP TABLE IF EXISTS `notes`;
CREATE TABLE IF NOT EXISTS `notes` (
  `idAnnee` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idEleve` int(11) NOT NULL,
  `idMatiere` int(11) NOT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEleve`,`idAnnee`,`idClasse`,`idMatiere`),
  KEY `FKsu9h8ja7p96toarvl07yhr99h` (`idAnnee`,`idClasse`,`idMatiere`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id` int(11) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


--
-- Déchargement des données de la table `annee`
--

INSERT INTO `annee` (`idAnnee`, `value`) VALUES
(1, '2017-2018'),
(2, '2018-2019');

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`idClasse`, `name`) VALUES
(1, 'CI'),
(2, 'CP'),
(3, 'CE1'),
(4, 'CE2'),
(5, 'CM1'),
(6, 'CM2'),
(7, '6ieme');

--
-- Déchargement des données de la table `classe_annee`
--

INSERT INTO `classe_annee` (`idClasse`, `idAnnee`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(1, 2),
(2, 2);

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`matricule`, `firstName`, `title`, `lastName`, `phone`) VALUES
('2001-A001', 'Assane', 'M.', 'FALL', 778016349),
('2010-A002', 'Fatou', 'MLLE', 'MARONE', 774102010),
('2015-A003', 'Sidi Yahya', 'M.', 'NDIAYE', 775261725),
('2015-A004', 'Mame DIBOR', 'MLLE', 'DIOUF', 771589585);

--
-- Déchargement des données de la table `classe_enseignant`
--

INSERT INTO `classe_enseignant` (`matricule`, `idClasse`, `idAnnee`, `endDate`, `startDate`) VALUES
('2001-A001', 1, '1', '2018-07-31', '2018-10-03'),
('2015-A003', 6, '2', '2018-07-31', '2018-10-03');



--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`idMatiere`, `name`) VALUES
(4, 'Redaction'),
(5, 'Resolution de problemes'),
(6, 'Production d\'écrits'),
(7, 'Fluidité');


--
-- Déchargement des données de la table `classe_matiere`
--

INSERT INTO `classe_matiere` (`idClasse`, `idMatiere`, `idAnnee`, `bareme`) VALUES
(1, 4, 1, 20),
(1, 5, 1, 30),
(1, 6, 1, 30);

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`idEleve`, `birthDate`, `father`, `firstName`, `gender`, `lastName`, `mother`, `place`) VALUES
(21, '2012-11-23', 'Moussa FALL', 'Papa Ibrahima', 'M', 'FALL', 'NDEYE FATIME DIOUF', 'DAKAR'),
(22, '2012-11-23', 'Mame Thierno DIOUM', 'Aminata', 'F', 'DIOUM', 'NDEYE FATOU', 'DAKAR'),
(23, '1990-12-03', 'Boubabacar FALL', 'Anta', 'F', 'FALL', 'AMY FALL', 'PIKINE');

--
-- Déchargement des données de la table `classe_eleve`
--

INSERT INTO `classe_eleve` (`idClasse`, `idEleve`, `idAnnee`, `status`) VALUES
(1, 22, 1, 'P'),
(1, 21, 1, 'P'),
(6, 23, 1, 'P');


--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`id`, `value`) VALUES
(18, 'Trimestre1'),
(19, 'Trimestre2'),
(20, 'Trimestre3');
