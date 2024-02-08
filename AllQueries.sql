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

-- animalloverssociety.donations definition - AP

CREATE TABLE `donations` (
  `idDonor` int NOT NULL,
  `Amount` double DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`idDonor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO animalloverssociety.donations
(idDonor, Amount, `Date`)
VALUES(1, 10.0, '2024-02-05');
INSERT INTO animalloverssociety.donations
(idDonor, Amount, `Date`)
VALUES(2, 20.0, '2024-02-04');
INSERT INTO animalloverssociety.donations
(idDonor, Amount, `Date`)
VALUES(3, 30.0, '2024-01-05');
INSERT INTO animalloverssociety.donations
(idDonor, Amount, `Date`)
VALUES(4, 40.0, '2024-01-04');
INSERT INTO animalloverssociety.donations
(idDonor, Amount, `Date`)
VALUES(5, 50.0, '2024-02-03');

-- animalloverssociety.items definition - AP

CREATE TABLE `items` (
  `itemCode` int NOT NULL,
  `itemType` varchar(45) DEFAULT NULL,
  `salePrice` double DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `profit` double DEFAULT NULL,
  `inventory` int DEFAULT NULL,
  PRIMARY KEY (`itemCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO animalloverssociety.items
(itemCode, itemType, salePrice, cost, profit, inventory)
VALUES(1, 'book', 10.0, 2.0, 0.0, 50);
INSERT INTO animalloverssociety.items
(itemCode, itemType, salePrice, cost, profit, inventory)
VALUES(2, 'video', 5.0, 1.0, 0.0, 100);
INSERT INTO animalloverssociety.items
(itemCode, itemType, salePrice, cost, profit, inventory)
VALUES(3, 'tape', 7.0, 1.0, 0.0, 55);
INSERT INTO animalloverssociety.items
(itemCode, itemType, salePrice, cost, profit, inventory)
VALUES(4, 'shirt', 20.0, 5.0, 0.0, 45);
INSERT INTO animalloverssociety.items
(itemCode, itemType, salePrice, cost, profit, inventory)
VALUES(5, 'sculpture', 50.0, 30.0, 0.0, 20);


