CREATE DATABASE IF NOT EXISTS `eights_reservation`;

use eights_reservation;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id` varchar(36) NOT NULL,
    `userName` varchar(36) NOT NULL,
    `email` varchar(100) NOT NULL,
    `password` varchar(100) NOT NULL,
    `createTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;