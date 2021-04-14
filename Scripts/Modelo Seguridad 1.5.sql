-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema seguridad
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema seguridad
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `umg` DEFAULT CHARACTER SET utf8 ;
USE `umg` ;

CREATE TABLE IF NOT EXISTS `umg`.`tbl_login` (
  `PK_id_usuario` INT NOT NULL AUTO_INCREMENT,
  `username_login` VARCHAR(60) NOT NULL,
  `password_login` VARCHAR(25)NOT NULL,
  PRIMARY KEY (`PK_id_usuario`) )
ENGINE = InnoDB CHARACTER SET = latin1;
INSERT INTO `umg`.`tbl_login` (`PK_id_usuario`, `username_login`, `password_login`) VALUES ('1', 'admin', '12345');


-- -----------------------------------------------------
-- Table `umg`.`tbl_modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `umg`.`tbl_modulo` (
  `PK_id_Modulo` INT NOT NULL,
  `nombre_modulo` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion_modulo` VARCHAR(200) NULL DEFAULT NULL,
  `estado_modulo` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_Modulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `umg`.`tbl_modulo` (`PK_id_Modulo`, `nombre_modulo`, `descripcion_modulo`, `estado_modulo`) VALUES ('1', 'Modulo 1', 'Esta es una prueba de un módulo.', '1');


-- -----------------------------------------------------
-- Table `umg`.`tbl_aplicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `umg`.`tbl_aplicacion` (
  `PK_id_aplicacion` INT NOT NULL,
  `nombre_aplicacion` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion_aplicacion` VARCHAR(200) NULL DEFAULT NULL,
  `no_reporteAsociado` INT NULL DEFAULT NULL,
  `estado_aplicacion` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_aplicacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `umg`.`tbl_aplicacion` (`PK_id_aplicacion`, `nombre_aplicacion`, `descripcion_aplicacion`, `no_reporteAsociado`, `estado_aplicacion`) VALUES ('1', 'Contabilidad', 'Lleva el registro financiero de los ingresos y egresos de la empresa.', '1', '1');


-- -----------------------------------------------------
-- Table `umg`.`tbl_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `umg`.`tbl_usuario` (
  `PK_id_usuario` VARCHAR(25) NOT NULL,
  `nombre_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `apellido_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `username_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `password_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `correo_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `cambio_password` TINYINT NULL DEFAULT NULL,
  `estado_usuario` TINYINT NULL DEFAULT NULL,
  `ultima_conexion` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `umg`.`tbl_usuario` (`PK_id_usuario`, `nombre_usuario`, `apellido_usuario`, `username_usuario`, `password_usuario`, `correo_usuario`, `cambio_password`, `estado_usuario`, `ultima_conexion`) VALUES ('1', 'prueba1', 'prueba2', 'prueba', '12345', 'prueba@gmail.com', '1', '1', '2021-03-23 23:59:59');


-- -----------------------------------------------------
-- Table `umg`.`tbl_bitacora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `umg`.`tbl_bitacora` (
  `PK_id_bitacora` INT NOT NULL AUTO_INCREMENT,
  `PK_id_usuario` VARCHAR(25) NOT NULL,
  `fecha` VARCHAR(25) NULL DEFAULT NULL,
  `hora` VARCHAR(25) NULL DEFAULT NULL,
  `host1` VARCHAR(45) NULL DEFAULT NULL,
  `ip` VARCHAR(25) NULL DEFAULT NULL,
  `accion` VARCHAR(50) NULL DEFAULT NULL,
  `tabla` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_bitacora`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `umg`.`tbl_perfil_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `umg`.`tbl_perfil_encabezado` (
  `PK_id_perfil` INT NOT NULL,
  `nombre_perfil` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion_perfil` VARCHAR(200) NULL DEFAULT NULL,
  `estado_perfil` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_perfil`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `umg`.`tbl_perfil_encabezado` (`PK_id_perfil`, `nombre_perfil`, `descripcion_perfil`, `estado_perfil`) VALUES ('1', 'perfil1', 'prueba en el perfil 1', '1');


-- -----------------------------------------------------
-- Table `umg`.`tbl_perfil_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `umg`.`tbl_perfil_detalle` (
  `PK_id_perfil` INT NOT NULL,
  `PK_id_aplicacion` INT NOT NULL,
  `ingresar` TINYINT NULL DEFAULT NULL,
  `consultar` TINYINT NULL DEFAULT NULL,
  `modificar` TINYINT NULL DEFAULT NULL,
  `eliminar` TINYINT NULL DEFAULT NULL,
  `imprimir` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_perfil`, `PK_id_aplicacion`),
    CONSTRAINT `fk_Perfil_detalle_Aplicacion1`
    FOREIGN KEY (`PK_id_aplicacion`)
    REFERENCES `umg`.`tbl_aplicacion` (`PK_id_aplicacion`),
  CONSTRAINT `fk_Perfil_detalle_Perfil1`
    FOREIGN KEY (`PK_id_perfil`)
    REFERENCES `umg`.`tbl_perfil_encabezado` (`PK_id_perfil`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `umg`.`tbl_usuario_aplicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `umg`.`tbl_usuario_aplicacion` (
  `PK_id_usuario` VARCHAR(25) NOT NULL,
  `PK_id_aplicacion` INT NOT NULL,
  `ingresar` TINYINT NULL DEFAULT NULL,
  `consulta` TINYINT NULL DEFAULT NULL,
  `modificar` TINYINT NULL DEFAULT NULL,
  `eliminar` TINYINT NULL DEFAULT NULL,
  `imprimir` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_usuario`, `PK_id_aplicacion`),
    CONSTRAINT `fk_tbl_usuario_aplicacion_tbl_aplicacion1`
    FOREIGN KEY (`PK_id_aplicacion`)
    REFERENCES `umg`.`tbl_aplicacion` (`PK_id_aplicacion`),
  CONSTRAINT `fk_Usuario_aplicacion_Usuario1`
    FOREIGN KEY (`PK_id_usuario`)
    REFERENCES `umg`.`tbl_usuario` (`PK_id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `umg`.`tbl_usuario_perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `umg`.`tbl_usuario_perfil` (
  `PK_id_usuario` VARCHAR(25) NOT NULL,
  `PK_id_perfil` INT NOT NULL,
  PRIMARY KEY (`PK_id_usuario`, `PK_id_perfil`),
    CONSTRAINT `fk_Usuario_perfil_Perfil1`
    FOREIGN KEY (`PK_id_perfil`)
    REFERENCES `umg`.`tbl_perfil_encabezado` (`PK_id_perfil`),
  CONSTRAINT `fk_Usuario_perfil_Usuario1`
    FOREIGN KEY (`PK_id_usuario`)
    REFERENCES `umg`.`tbl_usuario` (`PK_id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `umg`.`tbl_aplicacion_a_modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `umg`.`tbl_aplicacion_a_modulos` (
  `PK_id_modulo` INT(25) NOT NULL,
`PK_id_aplicacion` INT NOT NULL,
  PRIMARY KEY (`PK_id_modulo`,`PK_id_aplicacion` ),
    CONSTRAINT `fk_tbl_aplicacion_a_modulos_aplicacion1`
    FOREIGN KEY (`PK_id_aplicacion`)
    REFERENCES `umg`.`tbl_aplicacion` (`PK_id_aplicacion`),
  CONSTRAINT `fk_tbl_aplicacion_a_modulos_modulo`
    FOREIGN KEY (`PK_id_modulo`)
    REFERENCES `umg`.`tbl_modulo` (`PK_id_Modulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;