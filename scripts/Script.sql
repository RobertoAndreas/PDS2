-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

create database dbBicicleta;
use dbBicicleta;
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Table `mydb`.`tb_cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_cliente` ;

CREATE TABLE IF NOT EXISTS `tb_cliente` (
  `cd_cliente` INT NOT NULL AUTO_INCREMENT,
  `nm_cliente` VARCHAR(45) NOT NULL,
  `ds_endereco` VARCHAR(45) NOT NULL,
  `ds_cidade` VARCHAR(45) NOT NULL,
  `ds_cep` VARCHAR(45) NOT NULL,
  `ds_pais` VARCHAR(45) NOT NULL,
  `ds_telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cd_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_aluguel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_aluguel` ;

CREATE TABLE IF NOT EXISTS `tb_aluguel` (
  `cd_aluguel` INT NOT NULL AUTO_INCREMENT,
  `vl_diario` DOUBLE NOT NULL,
  `vl_mensal` DOUBLE NOT NULL,
  `vl_anual` VARCHAR(45) NOT NULL,
  `cd_cliente` INT NOT NULL,
  PRIMARY KEY (`cd_aluguel`),
  INDEX `fk_tb_aluguel_tb_cliente1_idx` (`cd_cliente` ASC),
  CONSTRAINT `fk_tb_aluguel_tb_cliente1`
    FOREIGN KEY (`cd_cliente`)
    REFERENCES `tb_cliente` (`cd_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_bicicleta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_bicicleta` ;

CREATE TABLE IF NOT EXISTS `tb_bicicleta` (
  `cd_bicicleta` INT NOT NULL AUTO_INCREMENT,
  `qt_disponivel` VARCHAR(45) NOT NULL,
  `ds_marca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cd_bicicleta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_item_aluguel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_item_aluguel` ;

CREATE TABLE IF NOT EXISTS `tb_item_aluguel` (
  `cd_bicicleta` INT NOT NULL,
  `cd_aluguel` INT NOT NULL,
  PRIMARY KEY (`cd_bicicleta`, `cd_aluguel`),
  INDEX `fk_tb_bicicleta_has_tb_aluguel_tb_aluguel1_idx` (`cd_aluguel` ASC),
  INDEX `fk_tb_bicicleta_has_tb_aluguel_tb_bicicleta_idx` (`cd_bicicleta` ASC),
  CONSTRAINT `fk_tb_bicicleta_has_tb_aluguel_tb_bicicleta`
    FOREIGN KEY (`cd_bicicleta`)
    REFERENCES `tb_bicicleta` (`cd_bicicleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_bicicleta_has_tb_aluguel_tb_aluguel1`
    FOREIGN KEY (`cd_aluguel`)
    REFERENCES `tb_aluguel` (`cd_aluguel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
