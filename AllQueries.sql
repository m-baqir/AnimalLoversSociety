drop table if exists `user`;
drop table if exists `usertype`;
drop table if exists `sales`;
drop table if exists `customers`;
drop table if exists `donors`;
drop table if exists `seminars`;
drop table if exists `donations`;
drop table if exists `items`;
drop table if exists `employees`;


CREATE TABLE if not exists `user` (
`UserName` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `Type` int NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE if not exists `usertype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
  );
CREATE TABLE if not exists `customers`(
  `CustomerID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `StreetAddress` varchar(100) NOT NULL,
  `City` varchar(100) NOT NULL,
  `Province` char(2) NOT NULL,
  `PostalCode` char(6) NOT NULL,
  PRIMARY KEY (`CustomerID`)
);

CREATE TABLE if not exists `sales` (
  `SaleID` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `Quantity` int NOT NULL,
  `CustomerID` int NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`SaleID`)
);
CREATE TABLE if not exists `seminars` (
  `SeminarID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Location` varchar(100) NOT NULL,
  `Capacity` int NOT NULL,
  PRIMARY KEY (`SeminarID`)
);
CREATE TABLE if not exists `donations` (
  `DonorID` int NOT NULL,
  `Amount` double DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`DonorID`)
);
CREATE TABLE if not exists `items`(
  `itemCode` int NOT NULL,
  `itemType` varchar(45) DEFAULT NULL,
  `salePrice` double DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `profit` double DEFAULT NULL,
  `inventory` int DEFAULT NULL,
  PRIMARY KEY (`itemCode`)
);
CREATE TABLE if not exists `employees`(
`employeeID` int NOT NULL AUTO_INCREMENT,
	`employeeName` varchar(50) NOT NULL,
	`title` varchar(40) NOT NULL,
	`salary` int NOT NULL,
	`department` varchar(40) NOT NULL,
	`supervisor` varchar(40) NOT NULL,
	`project` varchar(40) NOT NULL,
	PRIMARY KEY (`employeeID`)	
);
CREATE TABLE if not exists `donors` (
`name` VARCHAR(30),
	`address` VARCHAR(100),
	`gender` VARCHAR(10),
	`donation` INT,
	`name_change` VARCHAR(30),
	`member` VARCHAR(5),
	`donorID` int NOT null,
	PRIMARY KEY (`donorID`)	
);

-- user table data
INSERT INTO animalloverssociety.`user`
(UserName, Password, id, `Type`)
VALUES('sajjad', 'sajjadin', 1, 1);
INSERT INTO animalloverssociety.`user`
(UserName, Password, id, `Type`)
VALUES('alex', 'alexin', 2, 1);
INSERT INTO animalloverssociety.`user`
(UserName, Password, id, `Type`)
VALUES('employee1', 'employee1', 3, 2);
INSERT INTO animalloverssociety.`user`
(UserName, Password, id, `Type`)
VALUES('employee2', 'employee2', 4, 2);
INSERT INTO animalloverssociety.`user`
(UserName, Password, id, `Type`)
VALUES('donor1', 'donor1', 5, 3);
INSERT INTO animalloverssociety.`user`
(UserName, Password, id, `Type`)
VALUES('donor1', 'donor1', 6, 3);

-- usertype table data
INSERT INTO animalloverssociety.usertype
(id, `Type`)
VALUES(1, 'Management');
INSERT INTO animalloverssociety.usertype
(id, `Type`)
VALUES(2, 'Employee');
INSERT INTO animalloverssociety.usertype
(id, `Type`)
VALUES(3, 'Donor');

-- customers table data
INSERT INTO animalloverssociety.customers (CustomerID ,FirstName,LastName,StreetAddress,City,Province,PostalCode) VALUES
	 (1,'Joel','Miller','130 Yonge St','Toronto','ON','M4C1B5'),
	 (2,'Roman','Roy','2350 Dundas St','Toronto','ON','M4B2J8'),
	 (3,'Sydney','Adamu','1562 Granville St','Vancouver','BC','V6H3J1');
	
-- sales table data
INSERT INTO animalloverssociety.sales (SaleID, ProductID,Quantity,CustomerID,Date) VALUES
	 (1,1,1,2,'2024-01-16'),
	 (2,4,2,3,'2024-02-04'),
	 (3,3,1,1,'2024-01-25');
	
-- seminars table data
INSERT INTO animalloverssociety.seminars (Title,`Date`,`Time`,Location,Capacity) VALUES
	 ('Responsible small pet ownership','2024-06-15','10:00:00','Online',100),
	 ('Trap Neuter Return program','2024-05-25','14:00:00','Toronto Reference Library',50),
	 ('Behavioural enrichment for dogs','2024-05-18','15:00:00','Cecil Community Centre',30);
	
-- donations table data
INSERT INTO animalloverssociety.donations
(DonorID, Amount, `Date`)
VALUES(1, 10.0, '2024-02-05');
INSERT INTO animalloverssociety.donations
(DonorID, Amount, `Date`)
VALUES(2, 20.0, '2024-02-04');
INSERT INTO animalloverssociety.donations
(DonorID, Amount, `Date`)
VALUES(3, 30.0, '2024-01-05');
INSERT INTO animalloverssociety.donations
(DonorID, Amount, `Date`)
VALUES(4, 40.0, '2024-01-04');
INSERT INTO animalloverssociety.donations
(DonorID, Amount, `Date`)
VALUES(5, 50.0, '2024-02-03');

-- items table data
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

-- employees table data
INSERT INTO animalloverssociety.employees (employeeID ,employeeName, title, salary, department, supervisor, project) VALUES
	(1,'John Cater','Development Officer',120000, 'Production', 'Amy Wiseman', 'AGOC'),
	(2, 'Clement Guban', 'Digital Fundraising Coordinator', 80000, 'Marketing', 'Lori Hedge', 'DFAS'),
	(3, 'Rose Golding', 'Veterinarian', 220000, 'VA', 'Daniel Hugh', 'AGOC'),
	(4, 'Omar Hans', 'HR Coordinator', 65000, 'Talent Acquisition', 'Zeya Romans', 'OLNO');

-- donors table data
INSERT INTO Donors VALUES('Arsh', 'Brampton, Canada ON', 'Male', 5000, 'No', 'Yes', 1);
INSERT INTO Donors VALUES('Alexander', 'Toronto, Canada ON', 'Male', 10000, 'No', 'Yes', 2);
INSERT INTO Donors VALUES('Sajjad', 'Milton, Canada ON', 'Male', 8000, 'No', 'Yes', 3);
INSERT INTO Donors VALUES('Emily', 'Calagary, Canada', 'Female', 2000, 'No', 'Yes', 4);
INSERT INTO Donors VALUES('Jane', 'Washington, USA', 'Female', 50, 'No', 'No', 5);

-- add constraint
alter table `user` 
	add constraint `user_usertype_FK` foreign key (`Type`) references `usertype` (`id`);

alter table `sales`
	add constraint `sales_customers_FK` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`);

alter table `sales`
	add constraint `sales_items_FK` foreign key (`ProductID`) references `items` (`itemCode`);

alter table `donors`
	add constraint `donors_donations_FK` foreign key (`donorID`) references `donations` (`DonorID`);


