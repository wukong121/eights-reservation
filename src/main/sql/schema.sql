DROP DATABASE IF EXISTS eights;
DROP USER IF EXISTS 'eights'@'%';
# user can connect to the database from any host
# support emoji
# need mysql database parameter: character_set_server=utf8mb4
CREATE DATABASE eights DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE eights;
CREATE USER 'eights'@'%' IDENTIFIED BY 'eights';
GRANT ALL PRIVILEGES ON eights.* TO 'eights'@'%';
FLUSH PRIVILEGES;
