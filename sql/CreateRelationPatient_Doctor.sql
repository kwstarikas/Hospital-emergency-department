ALTER TABLE `Patient` ADD CONSTRAINT `doctor_patient_ID`
FOREIGN KEY (`PID`) REFERENCES `Doctor`(`PID`) 
ON DELETE NO ACTION ON UPDATE RESTRICT;