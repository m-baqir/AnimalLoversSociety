CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);
 
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
);
 
CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

INSERT INTO `roles` (`name`) VALUES ('EMPLOYEE');
INSERT INTO `roles` (`name`) VALUES ('DONOR');
INSERT INTO `roles` (`name`) VALUES ('MANAGEMENT');
INSERT INTO `roles` (`name`) VALUES ('ADMIN');


INSERT INTO `users` (`username`,`full_name`, `password`, `enabled`) VALUES ('patrick','patrick smith', '$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.', '1');
INSERT INTO `users` (`username`,`full_name`, `password`, `enabled`) VALUES ('alex','alex smith', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu', '1');
INSERT INTO `users` (`username`,`full_name`, `password`, `enabled`) VALUES ('john','john smith', '$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea', '1');
INSERT INTO `users` (`username`,`full_name`, `password`, `enabled`) VALUES ('namhm','namhm smith', '$2a$10$GQT8bfLMaLYwlyUysnGwDu6HMB5G.tin5MKT/uduv2Nez0.DmhnOq', '1');
INSERT INTO `users` (`username`,`full_name`, `password`, `enabled`) VALUES ('admin','admin smith', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', '1');

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3, 3);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (4, 2);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (4, 3);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (5, 4);

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

INSERT INTO animalloverssociety.customers (CustomerID,FirstName,LastName,StreetAddress,City,Province,PostalCode) VALUES
	 (1,'Joel','Miller','130 Yonge St','Toronto','ON','M4C1B5'),
	 (2,'Roman','Roy','2350 Dundas St','Toronto','ON','M4B2J8'),
	 (3,'Sydney','Adamu','1562 Granville St','Vancouver','BC','V6H3J1');

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


-- animalloverssociety.sales definition

CREATE TABLE `sales` (
  `SaleID` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `Quantity` int NOT NULL,
  `CustomerID` int NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`SaleID`),
  KEY `sales_customers_FK` (`CustomerID`),
  CONSTRAINT `sales_customers_FK` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`),
  KEY `sales_items_FK` (`ProductID`),
  CONSTRAINT `sales_items_FK` FOREIGN KEY (`ProductID`) REFERENCES `items` (`itemCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO animalloverssociety.sales (SaleID,ProductID,Quantity,CustomerID,Date) VALUES
	 (1,1,1,2,'2024-01-16'),
	 (2,4,2,3,'2024-02-04'),
	 (3,3,1,1,'2024-01-25');

-- animalloverssociety.seminars definition

CREATE TABLE `seminars` (
  `SeminarID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Location` varchar(100) NOT NULL,
  `Capacity` int NOT NULL,
  `Enrolled` int NOT NULL,
  PRIMARY KEY (`SeminarID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO animalloverssociety.seminars (Title,`Date`,`Time`,Location,Capacity,Enrolled) VALUES
	 ('Responsible small pet ownership','2024-06-15','10:00:00','Online',100,0),
	 ('Trap Neuter Return program','2024-05-25','14:00:00','Toronto Reference Library',50,0),
	 ('Behavioural enrichment for dogs','2024-05-18','15:00:00','Cecil Community Centre',30,0);

-- animalloverssociety.employees definition

CREATE TABLE `employees` (
	`employeeData` int NOT NULL AUTO_INCREMENT,
	`employeeID` int NOT NULL,
	`employeeName` varchar(50) NOT NULL,
	`title` varchar(40) NOT NULL,
	`salary` int NOT NULL,
	`department` varchar(40) NOT NULL,
	`supervisor` varchar(40) NOT NULL,
	`project` varchar(40) NOT NULL,
	PRIMARY KEY (`employeeData`)	
)	ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO animalloverssociety.employees (employeeData, employeeID ,employeeName, title, salary, department, supervisor, project) VALUES
	(1, 1,'John Cater','Development Officer',120000, 'Production', 'Amy Wiseman', 'AGOC'),
	(2, 2, 'Clement Guban', 'Digital Fundraising Coordinator', 80000, 'Marketing', 'Lori Hedge', 'DFAS'),
	(3, 3, 'Rose Golding', 'Veterinarian', 220000, 'VA', 'Daniel Hugh', 'AGOC'),
	(4, 4, 'Omar Hans', 'HR Coordinator', 65000, 'Talent Acquisition', 'Zeya Romans', 'OLNO'),
    (5, 5, 'Amy Wiseman', 'Project Manager', 150000, 'Production', 'Zeina Fallsman', 'AGOC'),
    (6, 5, 'Amy Wiseman', 'Project Manager', 150000, 'Production', 'Zeina Fallsman', 'DFAS'),
    (7, 5, 'Amy Wiseman', 'Project Manager', 150000, 'Production', 'Zeina Fallsman', 'OLNO'),
    (8, 4, 'Omar Hans', 'HR Coordinator', 65000, 'Talent Acquisition', 'Zeya Romans', 'AGOC');

-- Donors --
CREATE TABLE `donors`(
	`donorID` int NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30),
	`address` VARCHAR(100),
	`gender` VARCHAR(10),
	`donation` INT,
	`name_change` VARCHAR(30),
	`member` VARCHAR(5),
	PRIMARY KEY (`donorID`)
)	ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO Donors VALUES(1, 'Arsh', 'Brampton, Canada ON', 'Male', 5000, 'No', 'Yes');
INSERT INTO Donors VALUES(2, 'Alexander', 'Toronto, Canada ON', 'Male', 10000, 'No', 'Yes');
INSERT INTO Donors VALUES(3, 'Sajjad', 'Milton, Canada ON', 'Male', 8000, 'No', 'Yes');
INSERT INTO Donors VALUES(4, 'Emily', 'Calgary, Canada', 'Female', 2000, 'No', 'Yes');
INSERT INTO Donors VALUES(5, 'Jane', 'Washington, USA', 'Female', 50, 'No', 'No');

-- animalloverssociety.donations definition - AP

CREATE TABLE `donations` (
  `idDonation` int NOT NULL,
  `idDonor` int NOT NULL,
  `Amount` double DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`idDonor`),
  KEY `donations_Donors_FK` (`idDonor`),
  CONSTRAINT `donations_Donors_FK` FOREIGN KEY (`idDonor`) REFERENCES `Donors` (`donorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO animalloverssociety.donations
(idDonation, idDonor, Amount, `Date`)
VALUES(1, 1, 10.0, '2024-02-05');
INSERT INTO animalloverssociety.donations
(idDonation, idDonor, Amount, `Date`)
VALUES(2, 2, 20.0, '2024-02-04');
INSERT INTO animalloverssociety.donations
(idDonation, idDonor, Amount, `Date`)
VALUES(3, 3, 30.0, '2024-01-05');
INSERT INTO animalloverssociety.donations
(idDonation, idDonor, Amount, `Date`)
VALUES(4, 4, 40.0, '2024-01-04');
INSERT INTO animalloverssociety.donations
(idDonation, idDonor, Amount, `Date`)
VALUES(5, 5, 50.0, '2024-02-03');
