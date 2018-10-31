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
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korzik`.`Persons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzik`.`Persons` ;

CREATE TABLE IF NOT EXISTS `korzik`.`Persons` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `secondName` VARCHAR(45) NULL,
  `age` INT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Person_roles1_idx` (`roles_id` ASC),
  CONSTRAINT `fk_Person_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `korzik`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korzik`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzik`.`order` ;

CREATE TABLE IF NOT EXISTS `korzik`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL,
  `ingridients` VARCHAR(200) NULL,
  `weight` FLOAT NULL,
  `price` FLOAT NULL,
  `Person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_Person1_idx` (`Person_id` ASC),
  CONSTRAINT `fk_order_Person1`
    FOREIGN KEY (`Person_id`)
    REFERENCES `korzik`.`Persons` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `korzik`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `korzik`;
INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');
INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'cook');
INSERT INTO `korzik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'customer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `korzik`.`Persons`
-- -----------------------------------------------------
START TRANSACTION;
USE `korzik`;
INSERT INTO `korzik`.`Persons` (`id`, `name`, `secondName`, `age`, `roles_id`) VALUES (DEFAULT, 'admini', 'strator', 23, 1);
INSERT INTO `korzik`.`Persons` (`id`, `name`, `secondName`, `age`, `roles_id`) VALUES (DEFAULT, 'custo', 'mer', 22, 3);
INSERT INTO `korzik`.`Persons` (`id`, `name`, `secondName`, `age`, `roles_id`) VALUES (DEFAULT, 'cook', 'cook', 34, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `korzik`.`order`
-- -----------------------------------------------------
START TRANSACTION;
USE `korzik`;
INSERT INTO `korzik`.`order` (`id`, `name`, `ingridients`, `weight`, `price`, `Person_id`) VALUES (DEFAULT, 'something', 'some ingridients', 150, 14, 2);
INSERT INTO `korzik`.`order` (`id`, `name`, `ingridients`, `weight`, `price`, `Person_id`) VALUES (DEFAULT, 'anything', 'anything', 223, 12, 2);

COMMIT;

