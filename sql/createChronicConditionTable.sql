CREATE TABLE `HospitalEmergencyDepartment`.`ChronicCondition` 
( `AMKA` INT NOT NULL , `Diagnosis_date` INT NOT NULL , `Name` VARCHAR(50) NOT NULL ,
 UNIQUE `chronic_condition_diagnosis_date` (`Diagnosis_date`)) 
 ENGINE = InnoDB;
