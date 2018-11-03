-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema kisielev
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `kisielev` ;

-- -----------------------------------------------------
-- Schema kisielev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kisielev` DEFAULT CHARACTER SET utf8 ;
USE `kisielev` ;

-- -----------------------------------------------------
-- Table `kisielev`.`companis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kisielev`.`companis` ;

CREATE TABLE IF NOT EXISTS `kisielev`.`companis` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kisielev`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kisielev`.`users` ;

CREATE TABLE IF NOT EXISTS `kisielev`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `companis_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_companis_idx` (`companis_id` ASC),
  CONSTRAINT `fk_users_companis`
    FOREIGN KEY (`companis_id`)
    REFERENCES `kisielev`.`companis` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kisielev`.`aircrafts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kisielev`.`aircrafts` ;

CREATE TABLE IF NOT EXISTS `kisielev`.`aircrafts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `aircraft` VARCHAR(45) NULL,
  `place` INT NULL,
  `prace` INT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_aircrafts_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_aircrafts_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `kisielev`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `kisielev`.`companis`
-- -----------------------------------------------------
START TRANSACTION;
USE `kisielev`;
INSERT INTO `kisielev`.`companis` (`id`, `role`) VALUES (DEFAULT, 'Admin');
INSERT INTO `kisielev`.`companis` (`id`, `role`) VALUES (DEFAULT, 'User');

COMMIT;


-- -----------------------------------------------------
-- Data for table `kisielev`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `kisielev`;
INSERT INTO `kisielev`.`users` (`id`, `login`, `password`, `companis_id`) VALUES (DEFAULT, 'Admin', 'Admonpass', 1);
INSERT INTO `kisielev`.`users` (`id`, `login`, `password`, `companis_id`) VALUES (DEFAULT, 'User', 'Userpass', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `kisielev`.`aircrafts`
-- -----------------------------------------------------
START TRANSACTION;
USE `kisielev`;
INSERT INTO `kisielev`.`aircrafts` (`id`, `aircraft`, `place`, `prace`, `users_id`) VALUES (DEFAULT, 'Ty-100', 100, 100, 2);

COMMIT;

