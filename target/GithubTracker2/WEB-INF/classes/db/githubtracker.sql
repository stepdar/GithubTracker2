-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Dim 20 Mai 2018 à 14:49
-- Version du serveur :  5.7.22-0ubuntu0.16.04.1
-- Version de PHP :  7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `githubtracker`
--
CREATE DATABASE IF NOT EXISTS `githubtracker` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `githubtracker`;

-- --------------------------------------------------------

--
-- Structure de la table `githuber`
--

CREATE TABLE `githuber` (
  `id` int(11) NOT NULL,
  `github_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `login` varchar(50) NOT NULL,
  `url` varchar(150) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `bio` text,
  `location` varchar(100) DEFAULT NULL,
  `avatar_url` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `githuber`
--

INSERT INTO `githuber` (`id`, `github_id`, `name`, `login`, `url`, `email`, `bio`, `location`, `avatar_url`) VALUES
(1, 38072066, NULL, 'stepdar', NULL, NULL, NULL, NULL, 'https://avatars0.githubusercontent.com/u/38072066?v=4'),
(8, 14792727, NULL, 'Gregbee', NULL, NULL, NULL, NULL, 'https://avatars3.githubusercontent.com/u/14792727?v=4'),
(13, 36511575, 'Maxime BENTEJAC', 'mbentejac', NULL, NULL, NULL, NULL, 'https://avatars1.githubusercontent.com/u/36511575?v=4'),
(15, 5736082, 'Julien Bourbonnais', 'jbourbo', NULL, NULL, NULL, NULL, 'https://avatars3.githubusercontent.com/u/5736082?v=4');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `githuber`
--
ALTER TABLE `githuber`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `githuber`
--
ALTER TABLE `githuber`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
