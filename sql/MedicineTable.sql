CREATE TABLE `HospitalEmergencyDepartment`.`Medicine` 
( `Code` INT NOT NULL AUTO_INCREMENT , `Name` INT NOT NULL ,
 `Inclusiveness` DOUBLE NOT NULL , `Disease_med` INT NOT NULL , `Type` INT NOT NULL , 
PRIMARY KEY (`Code`), UNIQUE `medicine_name` (`Name`), UNIQUE `medicine_type` (`Type`)) 
ENGINE = InnoDB;
