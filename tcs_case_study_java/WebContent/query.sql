

  
  CREATE TABLE `customer` (
   `customerID` int(9) unsigned NOT NULL AUTO_INCREMENT,
   `customerSSNID` int(9) NOT NULL,
   `name` varchar(45) NOT NULL,
   `age` int(3) unsigned NOT NULL,
   `state` varchar(15) NOT NULL,
   `city` varchar(15) NOT NULL,
   `status` varchar(10) DEFAULT NULL,
   `lastUpdated` timestamp NULL DEFAULT NULL,
   `Message` varchar(45) DEFAULT NULL,
   `address` varchar(45) NOT NULL,
   PRIMARY KEY (`customerID`),
   UNIQUE KEY `customerID_UNIQUE` (`customerID`)
 ) 

ALTER TABLE account AUTO_INCREMENT=1000000000; 

CREATE TABLE `tcs`.`account` (
  `accountID` INT UNSIGNED NOT NULL  AUTO_INCREMENT,
  `customerID` INT NULL,
  `accountType` VARCHAR(10) NULL,
  `amount` INT UNSIGNED NULL,
  `status` VARCHAR(10) NULL,
  `message` VARCHAR(20) NULL,
  `lastUpdated` TIMESTAMP NULL);
  
 
ALTER TABLE account AUTO_INCREMENT=2000000000; 
  
  CREATE TABLE `tcs`.`transaction` (
  `transactionid` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `saccountID` INT NOT NULL,
  `daccountID` INT NULL,
  `description` VARCHAR(45) NULL,
  `date` DATE NULL,
  `amount` INT NULL,
  PRIMARY KEY (`transactionid`));

ALTER TABLE transaction AUTO_INCREMENT=3000000000;