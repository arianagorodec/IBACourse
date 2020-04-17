CREATE DATABASE `dd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;CREATE TABLE `organization_structure` (
  `id_post` bigint(20) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`id_post`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `product` (
  `id_product` bigint(20) NOT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `query` (
  `id_query` bigint(20) NOT NULL,
  `query` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_query`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `user` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `dd`.`user` (`id_user`, `password`, `role`, `username`) VALUES ('1', '$2a$10$ReB6ePAdU8hQAcsehubIJeVX3sd9R/qQUpwXzCuDzVtfRLJdoHVwW', '2', 'admin');
INSERT INTO `dd`.`user` (`id_user`, `password`, `role`, `username`) VALUES ('2', '$2a$10$vDk4n5yFrUNVfliCmUpE9.z2yTQwv33y6W.M85ATcMVm9s5hdlnQC', '1', 'arianagorodec');

INSERT INTO `dd`.`query` (`id_query`, `query`, `user`) VALUES ('1', 'INSERT INTO `dd`.`` (`id_product`,`manufacturer`, `name`, `price`) VALUES (\'2\',\'2\', \'2\', \'2\');', 'arianagorodec');
INSERT INTO `dd`.`query` (`id_query`, `query`, `user`) VALUES ('2', 'SELECT * FROM dd.product;', 'admin');

INSERT INTO `dd`.`organization_structure` (`id_post`, `department`, `post`, `salary`) VALUES ('1', 'sales department', 'director', '3000');
INSERT INTO `dd`.`organization_structure` (`id_post`, `department`, `post`, `salary`) VALUES ('2', 'sales departmen', 'commercial director', '2700');
INSERT INTO `dd`.`organization_structure` (`id_post`, `department`, `post`, `salary`) VALUES ('3', 'sales departmen', 'chief', '2000');
INSERT INTO `dd`.`organization_structure` (`id_post`, `department`, `post`, `salary`) VALUES ('4', 'sales departmen', 'sales manager', '1000');
INSERT INTO `dd`.`organization_structure` (`id_post`, `department`, `post`, `salary`) VALUES ('5', 'sales departmen', 'development manager', '1200');
INSERT INTO `dd`.`organization_structure` (`id_post`, `department`, `post`, `salary`) VALUES ('6', 'accounting', 'chief accountant', '2200');
INSERT INTO `dd`.`organization_structure` (`id_post`, `department`, `post`, `salary`) VALUES ('7', 'accounting', 'senior accountant', '1800');
INSERT INTO `dd`.`organization_structure` (`id_post`, `department`, `post`, `salary`) VALUES ('8', 'accounting', 'accountant', '1000');

INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('1', 'Sunrise', 'apple', '3');
INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('2', 'Sunrise', 'orange', '4');
INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('3', 'Sunrise', 'kiwi', '4');
INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('4', 'Sunrise', 'banana', '3');
INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('5', 'Space', 'chocolate', '2');
INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('6', 'Space', 'lollipop', '0.3');
INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('7', 'Space', 'roll', '0.5');
INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('8', 'Akon', 'red wine', '20');
INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('9', 'Akon', 'white wine', '24');
INSERT INTO `dd`.`product` (`id_product`, `manufacturer`, `name`, `price`) VALUES ('10', 'Akon', 'rose wine', '22');
