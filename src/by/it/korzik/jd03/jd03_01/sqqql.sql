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
-- Table `korzik`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzik`.`Users` ;

CREATE TABLE IF NOT EXISTS `korzik`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(50) NULL,
  `email` VARCHAR(60) NULL,
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
-- Table `korzik`.`menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzik`.`menu` ;

CREATE TABLE IF NOT EXISTS `korzik`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL,
  `ingridients` VARCHAR(200) NULL,
  `weight` FLOAT NULL,
  `price` FLOAT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korzik`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzik`.`orders` ;

CREATE TABLE IF NOT EXISTS `korzik`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Users_id` INT NOT NULL,
  `menu_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orders_Users1_idx` (`Users_id` ASC),
  INDEX `fk_orders_menu1_idx` (`menu_id` ASC),
  CONSTRAINT `fk_orders_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `korzik`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_orders_menu1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `korzik`.`menu` (`id`)
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
-- Data for table `korzik`.`Users`
-- -----------------------------------------------------
START TRANSACTION;
USE `korzik`;
INSERT INTO `korzik`.`Users` (`id`, `userName`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'administrator', 'admin', 'iamadministrator', 'admin@gmail.com', 1);
INSERT INTO `korzik`.`Users` (`id`, `userName`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'customer', 'customer', 'iamcustomer', 'customer@gmail.com', 3);
INSERT INTO `korzik`.`Users` (`id`, `userName`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'cook', 'cook', 'cook', 'cook@gmail.com', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `korzik`.`menu`
-- -----------------------------------------------------
START TRANSACTION;
USE `korzik`;
INSERT INTO `korzik`.`menu` (`id`, `name`, `ingridients`, `weight`, `price`) VALUES (DEFAULT, 'something', 'some ingridients', 150, 14);
INSERT INTO `korzik`.`menu` (`id`, `name`, `ingridients`, `weight`, `price`) VALUES (DEFAULT, 'anything', 'anything', 223, 12);

COMMIT;


-- -----------------------------------------------------
-- Data for table `korzik`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `korzik`;
INSERT INTO `korzik`.`orders` (`id`, `Users_id`, `menu_id`) VALUES (DEFAULT, 1, 1);
INSERT INTO `korzik`.`orders` (`id`, `Users_id`, `menu_id`) VALUES (DEFAULT, 2, 2);
INSERT INTO `korzik`.`orders` (`id`, `Users_id`, `menu_id`) VALUES (DEFAULT, 2, 1);

COMMIT;

