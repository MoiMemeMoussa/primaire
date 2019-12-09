-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 09 déc. 2019 à 11:46
-- Version du serveur :  10.1.37-MariaDB
-- Version de PHP :  7.3.0

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

CREATE TABLE `annee` (
  `idAnnee` int(11) NOT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `annee`
--

INSERT INTO `annee` (`idAnnee`, `value`) VALUES
(1, '2017-2018'),
(2, '2018-2019');

-- --------------------------------------------------------

--
-- Structure de la table `annee_trimestre`
--

CREATE TABLE `annee_trimestre` (
  `idAnnee` int(11) NOT NULL,
  `idTrimestre` int(11) NOT NULL,
  `endDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `idClasse` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Structure de la table `classe_annee`
--

CREATE TABLE `classe_annee` (
  `idClasse` int(11) NOT NULL,
  `idAnnee` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Structure de la table `classe_eleve`
--

CREATE TABLE `classe_eleve` (
  `idClasse` int(11) NOT NULL,
  `idEleve` int(11) NOT NULL,
  `idAnnee` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe_eleve`
--

INSERT INTO `classe_eleve` (`idClasse`, `idEleve`, `idAnnee`, `status`) VALUES
(1, 22, 1, 'P'),
(1, 21, 1, 'P'),
(6, 23, 1, 'P');

-- --------------------------------------------------------

--
-- Structure de la table `classe_enseignant`
--

CREATE TABLE `classe_enseignant` (
  `matricule` varchar(255) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idAnnee` varchar(255) NOT NULL,
  `endDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe_enseignant`
--

INSERT INTO `classe_enseignant` (`matricule`, `idClasse`, `idAnnee`, `endDate`, `startDate`) VALUES
('2001-A001', 1, '1', '2018-07-31', '2018-10-03'),
('2015-A003', 6, '2', '2018-07-31', '2018-10-03');

-- --------------------------------------------------------

--
-- Structure de la table `classe_matiere`
--

CREATE TABLE `classe_matiere` (
  `idClasse` int(11) NOT NULL,
  `idMatiere` int(11) NOT NULL,
  `idAnnee` int(11) NOT NULL,
  `bareme` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe_matiere`
--

INSERT INTO `classe_matiere` (`idClasse`, `idMatiere`, `idAnnee`, `bareme`) VALUES
(1, 4, 1, 20),
(1, 5, 1, 30),
(1, 6, 1, 30);

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

CREATE TABLE `eleve` (
  `idEleve` int(11) NOT NULL,
  `birthDate` date NOT NULL,
  `father` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `mother` varchar(255) NOT NULL,
  `place` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`idEleve`, `birthDate`, `father`, `firstName`, `gender`, `lastName`, `mother`, `place`) VALUES
(21, '2012-11-23', 'Moussa FALL', 'Papa Ibrahima', 'M', 'FALL', 'NDEYE FATIME DIOUF', 'DAKAR'),
(22, '2012-11-23', 'Mame Thierno DIOUM', 'Aminata', 'F', 'DIOUM', 'NDEYE FATOU', 'DAKAR'),
(23, '1990-12-03', 'Boubabacar FALL', 'Anta', 'F', 'FALL', 'AMY FALL', 'PIKINE');

-- --------------------------------------------------------

--
-- Structure de la table `eleve_matricule`
--

CREATE TABLE `eleve_matricule` (
  `idEleve` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idAnnee` int(11) NOT NULL,
  `idMatricule` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `matricule` varchar(11) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `title` varchar(10) NOT NULL COMMENT 'M. ou MLLE ou MME',
  `lastName` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`matricule`, `firstName`, `title`, `lastName`, `phone`) VALUES
('2001-A001', 'Assane', 'M.', 'FALL', 778016349),
('2010-A002', 'Fatou', 'MLLE', 'MARONE', 774102010),
('2015-A003', 'Sidi Yahya', 'M.', 'NDIAYE', 775261725),
('2015-A004', 'Mame DIBOR', 'MLLE', 'DIOUF', 771589585);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(24),
(24),
(24),
(24),
(24),
(24);

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `idMatiere` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`idMatiere`, `name`) VALUES
(4, 'Redaction'),
(5, 'Resolution de problemes'),
(6, 'Production d\'écrits'),
(7, 'Fluidité');

-- --------------------------------------------------------

--
-- Structure de la table `matricule`
--

CREATE TABLE `matricule` (
  `idMatricule` int(11) NOT NULL,
  `value` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `matricule`
--

INSERT INTO `matricule` (`idMatricule`, `value`) VALUES
(9, '001-001'),
(10, '001-002'),
(11, '001-003'),
(12, '001-004'),
(13, '001-005');

-- --------------------------------------------------------

--
-- Structure de la table `notes`
--

CREATE TABLE `notes` (
  `idMatiere` int(11) NOT NULL,
  `idEleve` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idAnnee` int(11) NOT NULL,
  `value` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

CREATE TABLE `trimestre` (
  `id` bigint(20) NOT NULL,
  `value` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`id`, `value`) VALUES
(18, 'Trimestre1'),
(19, 'Trimestre2'),
(20, 'Trimestre3');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annee`
--
ALTER TABLE `annee`
  ADD PRIMARY KEY (`idAnnee`);

--
-- Index pour la table `annee_trimestre`
--
ALTER TABLE `annee_trimestre`
  ADD PRIMARY KEY (`idAnnee`,`idTrimestre`),
  ADD KEY `FK7b8f509f4q0exf1l6vmub26le` (`idTrimestre`),
  ADD KEY `FKc4pxhylxw0acra81nhjrwqjjf` (`id`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`idClasse`);

--
-- Index pour la table `classe_annee`
--
ALTER TABLE `classe_annee`
  ADD PRIMARY KEY (`idAnnee`,`idClasse`),
  ADD KEY `FK5gj0f14616b7r351au6pb11kd` (`idClasse`);

--
-- Index pour la table `classe_eleve`
--
ALTER TABLE `classe_eleve`
  ADD PRIMARY KEY (`idAnnee`,`idClasse`,`idEleve`),
  ADD KEY `FKiowrav8chudx14v2fv7nni8bo` (`idEleve`);

--
-- Index pour la table `classe_enseignant`
--
ALTER TABLE `classe_enseignant`
  ADD PRIMARY KEY (`idAnnee`,`idClasse`,`matricule`),
  ADD KEY `FKhetrmao9nqmt5qger1bq56kjb` (`matricule`);

--
-- Index pour la table `classe_matiere`
--
ALTER TABLE `classe_matiere`
  ADD PRIMARY KEY (`idAnnee`,`idClasse`,`idMatiere`),
  ADD KEY `FK2g14280y7mdao7gubk7ega9do` (`idMatiere`);

--
-- Index pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD PRIMARY KEY (`idEleve`);

--
-- Index pour la table `eleve_matricule`
--
ALTER TABLE `eleve_matricule`
  ADD PRIMARY KEY (`idEleve`,`idMatricule`),
  ADD KEY `FK8bmviioemr7qp9hsa2p72grqp` (`idMatricule`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`matricule`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`idMatiere`);

--
-- Index pour la table `matricule`
--
ALTER TABLE `matricule`
  ADD PRIMARY KEY (`idMatricule`);

--
-- Index pour la table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`idEleve`,`idAnnee`,`idClasse`,`idMatiere`),
  ADD KEY `FKsu9h8ja7p96toarvl07yhr99h` (`idAnnee`,`idClasse`,`idMatiere`);

--
-- Index pour la table `trimestre`
--
ALTER TABLE `trimestre`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `eleve`
--
ALTER TABLE `eleve`
  MODIFY `idEleve` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
