-- animalloverssociety.`user` definition

CREATE TABLE `user` (
  `UserName` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `Type` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_usertype_FK` (`Type`),
  CONSTRAINT `user_usertype_FK` FOREIGN KEY (`Type`) REFERENCES `usertype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- animalloverssociety.usertype definition

CREATE TABLE `usertype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;