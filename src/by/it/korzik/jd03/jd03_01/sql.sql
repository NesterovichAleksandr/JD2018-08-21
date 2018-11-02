-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema korzik
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `korzik` ;

-- -----------------------------------------------------
-- Schema korzik
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `korzik` DEFAULT CHARACTER SET utf8 ;
USE `korzik` ;

-- -----------------------------------------------------
-- Table `korzik`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzik`.`roles` ;

CREATE TABLE IF NOT EXISTS `korzik`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korzik`.`flights`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzik`.`flights` ;

CREATE TABLE IF NOT EXISTS `korzik`.`flights` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from` VARCHAR(45) NULL,
  `to` VARCHAR(45) NULL,
  `flightTime` TIME(2) NULL,
  `date` DATETIME NULL,
  `seats` INT NULL,
  `price` DECIMAL(15) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korzik`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzik`.`users` ;

CREATE TABLE IF NOT EXISTS `korzik`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  `flights_id` INT NOT NULL,
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  INDEX `fk_users_flights1_idx` (`flights_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `korzik`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_users_flights1`
    FOREIGN KEY (`flights_id`)
    REFERENCES `korzik`.`flights` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `korzik`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `korzik`;
INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'dispatcher');
INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'pilot');
INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'navigator');
INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'operator');
INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'stewardess');
INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'passenger');

COMMIT;


-- -----------------------------------------------------
-- Data for table `korzik`.`flights`
-- -----------------------------------------------------
START TRANSACTION;
USE `korzik`;
INSERT INTO `korzik`.`flights` (`id`, `from`, `to`, `flightTime`, `date`, `seats`, `price`) VALUES (DEFAULT, 'thisCity', 'otherCity', '01:15:00', '2018-10-20 15:00:00', 256, 100);

COMMIT;


-- -----------------------------------------------------
-- Data for table `korzik`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `korzik`;
INSERT INTO `korzik`.`users` (`id`, `login`, `Email`, `password`, `roles_id`, `flights_id`) VALUES (DEFAULT, 'dipatcher', 'dispatcher@gmail.com', 'disp', 1, 1);
INSERT INTO `korzik`.`users` (`id`, `login`, `Email`, `password`, `roles_id`, `flights_id`) VALUES (DEFAULT, 'pilot', 'pilot@gmai.com', 'pilot', 2, 1);
INSERT INTO `korzik`.`users` (`id`, `login`, `Email`, `password`, `roles_id`, `flights_id`) VALUES (DEFAULT, 'navigator', 'navigator@gmail.com', 'navigator', 3, 1);
INSERT INTO `korzik`.`users` (`id`, `login`, `Email`, `password`, `roles_id`, `flights_id`) VALUES (DEFAULT, 'operator', 'operator@gmail.com', 'operator', 4, 1);
INSERT INTO `korzik`.`users` (`id`, `login`, `Email`, `password`, `roles_id`, `flights_id`) VALUES (DEFAULT, 'stewardess', 'stewardess@gmail.com', 'stewardess', 5, 1);
INSERT INTO `korzik`.`users` (`id`, `login`, `Email`, `password`, `roles_id`, `flights_id`) VALUES (DEFAULT, 'passenger', 'passenger@gmail.com', 'passenger', 6, 1);

COMMIT;


