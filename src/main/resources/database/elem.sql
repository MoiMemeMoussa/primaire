-
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
