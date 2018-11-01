-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hr
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hr` ;

-- -----------------------------------------------------
-- Schema hr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hr` DEFAULT CHARACTER SET utf8 ;
USE `hr` ;

-- -----------------------------------------------------
-- Table `hr`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`roles` ;

CREATE TABLE IF NOT EXISTS `hr`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_UNIQUE` (`role` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hr`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`users` ;

CREATE TABLE IF NOT EXISTS `hr`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `hr`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hr`.`resumes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`resumes` ;

CREATE TABLE IF NOT EXISTS `hr`.`resumes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL,
  `dob` TIMESTAMP(6) NULL,
  `country` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `education` VARCHAR(45) NULL,
  `degree` VARCHAR(45) NULL,
  `graduate_year` INT NULL,
  `experience` VARCHAR(45) NULL,
  `post` VARCHAR(45) NULL,
  `worktime` INT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_resumes_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_resumes_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `hr`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hr`.`companies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`companies` ;

CREATE TABLE IF NOT EXISTS `hr`.`companies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(45) NULL,
  `start_year` VARCHAR(45) NULL,
  `about` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_companies_roles1_idx` (`roles_id` ASC),
  CONSTRAINT `fk_companies_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `hr`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hr`.`requests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`requests` ;

CREATE TABLE IF NOT EXISTS `hr`.`requests` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` MEDIUMTEXT NULL,
  `companies_id` INT NOT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_requests_companies1_idx` (`companies_id` ASC),
  INDEX `fk_requests_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_requests_companies1`
    FOREIGN KEY (`companies_id`)
    REFERENCES `hr`.`companies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_requests_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `hr`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `hr`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `hr`;
INSERT INTO `hr`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');
INSERT INTO `hr`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `hr`.`roles` (`id`, `role`) VALUES (DEFAULT, 'company');
INSERT INTO `hr`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;

