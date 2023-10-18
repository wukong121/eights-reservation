CREATE DATABASE IF NOT EXISTS `eights_reservation`;

use eights_reservation;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id` varchar(36) NOT NULL,
    `username` varchar(36) NOT NULL,
    `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8user COLLATE=utf8_general_ci;
