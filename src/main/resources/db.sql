CREATE DATABASE IF NOT EXISTS `db_person`;
USE `db_person`;

--
-- Table Structure for `user`
--
CREATE TABLE IF NOT EXISTS `userinformation` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`username` varchar(30) NOT NULL,
`password` varchar(128) NOT NULL,
PRIMARY KEY(`id`),
UNIQUE KEY(`username`, `password`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
--
-- Table structure for `person`
--
CREATE TABLE IF NOT EXISTS `person` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`first_name` varchar(30) NOT NULL,
`last_name` varchar(30) NOT NULL,
`birth_date` date NOT NULL,
`status` varchar(20) NOT NULL DEFAULT 'BEGINNER',
`middle_name` varchar(30),
`marital_name` varchar(30),
`id_user` int(11) unsigned,
PRIMARY KEY (`id`),
UNIQUE KEY (`first_name`, `last_name`, `birth_date`),
KEY `fk_person_userid_idx` (`id_user`),
CONSTRAINT `fk_person_userid` FOREIGN KEY (`id_user`) REFERENCES `userinformation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


--
-- Table structure for table `email`
--

CREATE TABLE IF NOT EXISTS `email` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`email_address` varchar(255) DEFAULT NULL,
`usage_type` varchar(20) DEFAULT 'PERSONAL',
`id_person` int(11) unsigned,
PRIMARY KEY(`id`),
KEY `fk_email_personid_idx` (`id_person`),
CONSTRAINT `fk_email_personid` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `telephone`
--

CREATE TABLE IF NOT EXISTS `telephone` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`telephone_number` varchar(255) DEFAULT NULL,
`usage_type` varchar(20) DEFAULT 'PERSONAL',
`id_person` int(11) unsigned,
PRIMARY KEY(`id`),
UNIQUE KEY(`telephone_number`, `id_person`),
KEY `fk_telephone_personid_idx` (`id_person`),
CONSTRAINT `fk_telephone_personid` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `fax`
--

CREATE TABLE IF NOT EXISTS `fax` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`fax_number` varchar(255) DEFAULT NULL,
`usage_type` varchar(20) DEFAULT 'PERSONAL',
`id_person` int(11) unsigned DEFAULT NULL,
PRIMARY KEY(`id`),
KEY `fk_fax_personid_idx` (`id_person`),
CONSTRAINT `fk_fax_personid` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`street_number` varchar(4) DEFAULT NULL,
`street_name` varchar(50) DEFAULT NULL,
`street_type` varchar(50) DEFAULT 'STREET',
`postal_code` varchar(10) DEFAULT NULL,
`city_name` varchar(50) DEFAULT NULL,
`country_name` varchar(50) DEFAULT NULL,
`address_completion` varchar(255) DEFAULT NULL,
`usage_type` varchar(20) DEFAULT 'HOME',
`id_person` int(11) unsigned DEFAULT NULL,
PRIMARY KEY(`id`),
KEY `fk_address_personid_idx` (`id_person`),
CONSTRAINT `fk_address_personid` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;