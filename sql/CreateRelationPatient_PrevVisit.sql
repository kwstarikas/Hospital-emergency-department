ALTER TABLE `Previous visit` ADD CONSTRAINT `patient's Previous visit` FOREIGN KEY (`AMKA`) REFERENCES `Patient`(`AMKA`) ON DELETE RESTRICT ON UPDATE RESTRICT;