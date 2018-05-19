-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema imarket
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema imarket
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `imarket` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `imarket` ;

-- -----------------------------------------------------
-- Table `imarket`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imarket`.`user` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `address` VARCHAR(90) NULL DEFAULT NULL,
  `city` VARCHAR(30) NULL DEFAULT NULL,
  `phone` INT(11) NULL DEFAULT NULL,
  `registration_date` DATETIME NULL DEFAULT NULL,
  `login` VARCHAR(30) NULL DEFAULT NULL,
  `role` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `id_user_UNIQUE` (`id_user` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `imarket`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imarket`.`order` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `order_date` DATETIME NULL DEFAULT NULL,
  `id_user` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE INDEX `id_order_UNIQUE` (`id_order` ASC),
  INDEX `id_user_idx` (`id_user` ASC),
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `imarket`.`user` (`id_user`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `imarket`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imarket`.`product_category` (
  `product_category_id` INT(11) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(500) NULL DEFAULT NULL,
  `appearance_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`product_category_id`),
  UNIQUE INDEX `product_category_id_UNIQUE` (`product_category_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 102
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `imarket`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imarket`.`product` (
  `id_product` INT(11) NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NULL DEFAULT NULL,
  `product_price` DOUBLE NULL DEFAULT NULL,
  `product_image` BLOB NULL DEFAULT NULL,
  `product_description` VARCHAR(500) NULL DEFAULT NULL,
  `appearance_date` DATETIME NULL DEFAULT NULL,
  `available_amount` INT(11) NULL DEFAULT NULL,
  `last_modified` DATETIME NULL DEFAULT NULL,
  `id_product_category` INT(11) NOT NULL,
  PRIMARY KEY (`id_product`, `id_product_category`),
  UNIQUE INDEX `id_product_UNIQUE` (`id_product` ASC),
  INDEX `fk_product_product_category1_idx` (`id_product_category` ASC),
  CONSTRAINT `fk_product_product_category1`
    FOREIGN KEY (`id_product_category`)
    REFERENCES `imarket`.`product_category` (`product_category_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `imarket`.`bucket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imarket`.`bucket` (
  `id_bucket` INT(11) NOT NULL AUTO_INCREMENT,
  `id_order` INT(11) NOT NULL,
  `id_product` INT(11) NOT NULL,
  PRIMARY KEY (`id_bucket`, `id_order`, `id_product`),
  UNIQUE INDEX `id_bucket_UNIQUE` (`id_bucket` ASC),
  INDEX `fk_bucket_order1_idx` (`id_order` ASC),
  INDEX `fk_bucket_product1_idx` (`id_product` ASC),
  CONSTRAINT `fk_bucket_order1`
    FOREIGN KEY (`id_order`)
    REFERENCES `imarket`.`order` (`id_order`),
  CONSTRAINT `fk_bucket_product1`
    FOREIGN KEY (`id_product`)
    REFERENCES `imarket`.`product` (`id_product`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `imarket`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imarket`.`comment` (
  `id_comment` INT(11) NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(150) NULL DEFAULT NULL,
  `created_date` DATETIME NULL DEFAULT NULL,
  `id_user` INT(11) NOT NULL,
  `id_product` INT(11) NOT NULL,
  PRIMARY KEY (`id_comment`, `id_user`, `id_product`),
  UNIQUE INDEX `id_comment_UNIQUE` (`id_comment` ASC),
  INDEX `fk_comment_user1_idx` (`id_user` ASC),
  INDEX `fk_comment_product1_idx` (`id_product` ASC),
  CONSTRAINT `fk_comment_product1`
    FOREIGN KEY (`id_product`)
    REFERENCES `imarket`.`product` (`id_product`),
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`id_user`)
    REFERENCES `imarket`.`user` (`id_user`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
