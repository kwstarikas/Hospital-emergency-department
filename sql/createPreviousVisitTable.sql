CREATE TABLE `HospitalEmergencyDepartment`.`Previous visit` ( `AMKA` INT NOT NULL , `ExaminationID` INT NOT NULL , `Date` DATE NOT NULL , `Diagnosis` VARCHAR(50) NOT NULL , `Examination` TEXT NOT NULL , `Cure` VARCHAR(50) NOT NULL ,
 UNIQUE `previous_visit_date` (`Date`), UNIQUE `examination_id` (`ExaminationID`), 
 UNIQUE `previous_visit_cure` (`Cure`)) 
 ENGINE = InnoDB;