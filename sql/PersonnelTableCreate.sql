CREATE TABLE `HospitalEmergencyDepartment`.`Personnel` 
( `PID` INT NOT NULL AUTO_INCREMENT , `First_Name` VARCHAR(30) NOT NULL , `Last_Name` VARCHAR(30) NOT NULL ,
 `Address` TEXT NOT NULL , `Birthdate` DATE NOT NULL , `Phone` VARCHAR(13) NOT NULL ,
  `Sex` VARCHAR(10) NOT NULL , PRIMARY KEY (`PID`)) 
ENGINE = InnoDB;