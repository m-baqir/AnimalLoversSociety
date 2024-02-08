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

-- animalloverssociety.customers definition

CREATE TABLE `customers` (
  `CustomerID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `StreetAddress` varchar(100) NOT NULL,
  `City` varchar(100) NOT NULL,
  `Province` char(2) NOT NULL,
  `PostalCode` char(6) NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO animalloverssociety.customers (FirstName,LastName,StreetAddress,City,Province,PostalCode) VALUES
	 ('Joel','Miller','130 Yonge St','Toronto','ON','M4C1B5'),
	 ('Roman','Roy','2350 Dundas St','Toronto','ON','M4B2J8'),
	 ('Sydney','Adamu','1562 Granville St','Vancouver','BC','V6H3J1');

-- animalloverssociety.sales definition

CREATE TABLE `sales` (
  `SaleID` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `Quantity` int NOT NULL,
  `CustomerID` int NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`SaleID`),
  KEY `sales_customers_FK` (`CustomerID`),
  CONSTRAINT `sales_customers_FK` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO animalloverssociety.sales (ProductID,Quantity,CustomerID,`Date`) VALUES
	 (1,1,2,'2024-01-16'),
	 (4,2,3,'2024-02-04'),
	 (3,1,1,'2024-01-25');

-- animalloverssociety.seminars definition

CREATE TABLE `seminars` (
  `SeminarID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Location` varchar(100) NOT NULL,
  `Capacity` int NOT NULL,
  PRIMARY KEY (`SeminarID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO animalloverssociety.seminars (Title,`Date`,`Time`,Location,Capacity) VALUES
	 ('Responsible small pet ownership','2024-06-15','10:00:00','Online',100),
	 ('Trap Neuter Return program','2024-05-25','14:00:00','Toronto Reference Library',50),
	 ('Behavioural enrichment for dogs','2024-05-18','15:00:00','Cecil Community Centre',30);
