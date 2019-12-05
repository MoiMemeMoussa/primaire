-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 05 déc. 2019 à 11:25
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

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `idClasse` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `classe_annee`
--

CREATE TABLE `classe_annee` (
  `idClasse` int(11) NOT NULL,
  `idAnnee` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `classe_eleve`
--

CREATE TABLE `classe_eleve` (
  `idClasse` int(11) NOT NULL,
  `idEleve` int(11) NOT NULL,
  `idAnnee` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

CREATE TABLE `eleve` (
  `idEleve` int(11) NOT NULL,
  `birthDate` date NOT NULL,
  `father` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `gender` char(1) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `mother` varchar(255) NOT NULL,
  `place` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  `matricule` int(11) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `gender` char(1) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `phone` char(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

CREATE TABLE `matiere` (
  `idMatiere` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `matricule`
--

CREATE TABLE `matricule` (
  `idMatricule` int(11) NOT NULL,
  `value` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
-- Index pour les tables déchargées
--

--
-- Index pour la table `annee`
--
ALTER TABLE `annee`
  ADD PRIMARY KEY (`idAnnee`);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
