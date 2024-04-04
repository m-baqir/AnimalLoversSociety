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
INSERT INTO `roles` (`name`) VALUES ('MEMBER');
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
  `product_type` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cost` double DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `inventory` bigint NOT NULL,
  `inventory_on_reorder` bigint DEFAULT NULL,
  `item_type` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `profit` double DEFAULT NULL,
  `replenish_arrival_date` datetime(6) DEFAULT NULL,
  `replenish_ordered_date` datetime(6) DEFAULT NULL,
  `sale_price` double NOT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `colour` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO animalloverssociety.items
(product_type, id, cost, image_url, inventory, inventory_on_reorder, item_type, name, profit, replenish_arrival_date, replenish_ordered_date, sale_price, height, weight, colour, `size`)
VALUES(0, 1, 16.0, 'https://m.media-amazon.com/images/I/71WUlaKVG-L._AC_UF1000,1000_QL80_.jpg', 300, 0, 'Book', 'The Animal Book', 4.0, NULL, '2024-04-02 21:36:34.315000', 20.0, NULL, NULL, NULL, NULL);
INSERT INTO animalloverssociety.items
(product_type, id, cost, image_url, inventory, inventory_on_reorder, item_type, name, profit, replenish_arrival_date, replenish_ordered_date, sale_price, height, weight, colour, `size`)
VALUES(0, 2, 12.0, 'https://t3.ftcdn.net/jpg/03/64/22/10/360_F_364221077_uNO8UQVdGdlRo0ibhT0ULoJrqEUHnoGY.jpg', 400, 0, 'Video', 'ALS''s Funny Dog Compilation', 3.0, NULL, '2024-04-02 21:36:34.383000', 15.0, NULL, NULL, NULL, NULL);
INSERT INTO animalloverssociety.items
(product_type, id, cost, image_url, inventory, inventory_on_reorder, item_type, name, profit, replenish_arrival_date, replenish_ordered_date, sale_price, height, weight, colour, `size`)
VALUES(1, 4, 12.0, 'https://m.media-amazon.com/images/I/A1-rkBsnj+L._CLa%7C2140%2C2000%7C61SUppDYcFL.png%7C0%2C0%2C2140%2C2000%2B0.0%2C0.0%2C2140.0%2C2000.0_AC_SL1500_.png', 75, 75, 'Shirt', 'I Love Dogs', 12.989999999999998, '2024-04-10 00:00:00', '2024-04-03 17:52:39.438000', 24.99, NULL, NULL, 'Blue', 'XS');
INSERT INTO animalloverssociety.items
(product_type, id, cost, image_url, inventory, inventory_on_reorder, item_type, name, profit, replenish_arrival_date, replenish_ordered_date, sale_price, height, weight, colour, `size`)
VALUES(1, 5, 12.0, 'https://m.media-amazon.com/images/I/A1-rkBsnj+L._CLa%7C2140%2C2000%7C61SUppDYcFL.png%7C0%2C0%2C2140%2C2000%2B0.0%2C0.0%2C2140.0%2C2000.0_AC_SL1500_.png', 50, 75, 'Shirt', 'I Love Dogs', 12.989999999999998, '2024-04-10 00:00:00', '2024-04-03 17:52:39.438000', 24.99, NULL, NULL, 'Blue', 'S');
INSERT INTO animalloverssociety.items
(product_type, id, cost, image_url, inventory, inventory_on_reorder, item_type, name, profit, replenish_arrival_date, replenish_ordered_date, sale_price, height, weight, colour, `size`)
VALUES(1, 6, 12.0, 'https://m.media-amazon.com/images/I/A1-rkBsnj+L._CLa%7C2140%2C2000%7C61SUppDYcFL.png%7C0%2C0%2C2140%2C2000%2B0.0%2C0.0%2C2140.0%2C2000.0_AC_SL1500_.png', 40, 75, 'Shirt', 'I Love Dogs', 12.989999999999998, '2024-04-10 00:00:00', '2024-04-03 17:52:39.438000', 24.99, NULL, NULL, 'Blue', 'M');
INSERT INTO animalloverssociety.items
(product_type, id, cost, image_url, inventory, inventory_on_reorder, item_type, name, profit, replenish_arrival_date, replenish_ordered_date, sale_price, height, weight, colour, `size`)
VALUES(1, 7, 12.0, 'https://m.media-amazon.com/images/I/A13usaonutL._CLa%7C2140%2C2000%7C61hBW6dmEUL.png%7C0%2C0%2C2140%2C2000%2B0.0%2C0.0%2C2140.0%2C2000.0_AC_UY1000_.png', 65, 75, 'Shirt', 'I Love Dogs', 12.989999999999998, '2024-04-10 00:00:00', '2024-04-03 17:52:39.438000', 24.99, NULL, NULL, 'Black', 'L');
INSERT INTO animalloverssociety.items
(product_type, id, cost, image_url, inventory, inventory_on_reorder, item_type, name, profit, replenish_arrival_date, replenish_ordered_date, sale_price, height, weight, colour, `size`)
VALUES(1, 8, 12.0, 'https://m.media-amazon.com/images/I/A13usaonutL._CLa%7C2140%2C2000%7C61hBW6dmEUL.png%7C0%2C0%2C2140%2C2000%2B0.0%2C0.0%2C2140.0%2C2000.0_AC_UY1000_.png', 80, 75, 'Shirt', 'I Love Dogs', 12.989999999999998, '2024-04-10 00:00:00', '2024-04-03 17:52:39.438000', 24.99, NULL, NULL, 'Black', 'XL');
INSERT INTO animalloverssociety.items
(product_type, id, cost, image_url, inventory, inventory_on_reorder, item_type, name, profit, replenish_arrival_date, replenish_ordered_date, sale_price, height, weight, colour, `size`)
VALUES(2, 9, 32.05, 'https://m.media-amazon.com/images/I/41JEqx3VrnS.jpg', 30, 0, 'Sculpture', 'Peein'' Frenchie', 27.93, NULL, '2024-04-03 18:45:28.445000', 59.98, 30.0, 20.0, NULL, NULL);
INSERT INTO animalloverssociety.items
(product_type, id, cost, image_url, inventory, inventory_on_reorder, item_type, name, profit, replenish_arrival_date, replenish_ordered_date, sale_price, height, weight, colour, `size`)
VALUES(0, 10, 2.59, 'https://i.ebayimg.com/images/g/8cQAAMXQVT9TDu5E/s-l1200.webp', 1000, 0, 'Bumper Sticker', 'Life Is Better With A Cat', 7.9, NULL, NULL, 10.49, NULL, NULL, NULL, NULL);


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
