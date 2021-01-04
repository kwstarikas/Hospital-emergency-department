CREATE TABLE `HospitalEmergencyDepartment`.`DOCTOR`
( `PID` INT NOT NULL AUTO_INCREMENT ,
`First_Name` VARCHAR(30) NOT NULL ,
`Last_Name` VARCHAR(30) NOT NULL ,
`Address` TEXT NOT NULL ,
`Birthdate` DATE NOT NULL ,
`Phone` VARCHAR NOT NULL ,
`Sex` VARCHAR NOT NULL ,
`Specialization` VARCHAR NOT NULL , PRIMARY KEY (`PID`), UNIQUE `phone_number` (`Phone`)) ENGINE = InnoDB;