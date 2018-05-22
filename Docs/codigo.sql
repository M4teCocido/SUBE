-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`DescuentoSUBE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DescuentoSUBE` (
  `idDescuento` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDescuento`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`DocumentoPersona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DocumentoPersona` (
  `idDocumento` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NOT NULL,
  `tipo` INT NOT NULL,
  PRIMARY KEY (`idDocumento`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `idDocumento` INT NOT NULL,
  `genero` INT NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `email` VARCHAR(45) NULL,
  `celular` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idPersona`),
  INDEX `idDocumento_idx` (`idDocumento` ASC),
  CONSTRAINT `idDocumento`
    FOREIGN KEY (`idDocumento`)
    REFERENCES `mydb`.`DocumentoPersona` (`idDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TarjetaSUBE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TarjetaSUBE` (
  `idTarjetaSube` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `idPropietario` INT NULL,
  `saldo` DECIMAL NOT NULL,
  `activa` TINYINT NOT NULL,
  PRIMARY KEY (`idTarjetaSube`),
  INDEX `idPropietario_idx` (`idPropietario` ASC),
  CONSTRAINT `idPropietario`
    FOREIGN KEY (`idPropietario`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DescuentoRedSUBE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DescuentoRedSUBE` (
  `idDescuento` INT NOT NULL,
  `idTarjetaSUBE` INT NOT NULL,
  PRIMARY KEY (`idDescuento`),
  INDEX `fk_DescuentoRedSUBE_TarjetaSUBE1_idx` (`idTarjetaSUBE` ASC),
  CONSTRAINT `idDescuento`
    FOREIGN KEY (`idDescuento`)
    REFERENCES `mydb`.`DescuentoSUBE` (`idDescuento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DescuentoRedSUBE_TarjetaSUBE1`
    FOREIGN KEY (`idTarjetaSUBE`)
    REFERENCES `mydb`.`TarjetaSUBE` (`idTarjetaSube`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LapsoDescuentoRedSUBE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LapsoDescuentoRedSUBE` (
  `idLapso` INT NOT NULL AUTO_INCREMENT,
  `fechaHoraVencimiento` DATE NOT NULL,
  `idDescuentoRedSube` INT NOT NULL,
  PRIMARY KEY (`idLapso`),
  INDEX `fk_LapsoDescuentoRedSUBE_DescuentoRedSUBE1_idx` (`idDescuentoRedSube` ASC),
  CONSTRAINT `fk_LapsoDescuentoRedSUBE_DescuentoRedSUBE1`
    FOREIGN KEY (`idDescuentoRedSube`)
    REFERENCES `mydb`.`DescuentoRedSUBE` (`idDescuento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Fichada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fichada` (
  `idFichada` INT NOT NULL AUTO_INCREMENT,
  `fechaHora` DATE NOT NULL,
  `idLapsoDescuentoRedSUBE` INT NULL,
  PRIMARY KEY (`idFichada`),
  INDEX `fk_Fichada_LapsoDescuentoRedSUBE1_idx` (`idLapsoDescuentoRedSUBE` ASC),
  CONSTRAINT `fk_Fichada_LapsoDescuentoRedSUBE1`
    FOREIGN KEY (`idLapsoDescuentoRedSUBE`)
    REFERENCES `mydb`.`LapsoDescuentoRedSUBE` (`idLapso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LineaTren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LineaTren` (
  `idLinea` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLinea`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EstacionTren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EstacionTren` (
  `idEstacion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idRecorrido` INT NOT NULL,
  `idLinea` INT NOT NULL,
  PRIMARY KEY (`idEstacion`),
  INDEX `fk_EstacionTren_LineaTren1_idx` (`idLinea` ASC),
  CONSTRAINT `fk_EstacionTren_LineaTren1`
    FOREIGN KEY (`idLinea`)
    REFERENCES `mydb`.`LineaTren` (`idLinea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FichadaTren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`FichadaTren` (
  `idFichada` INT NOT NULL,
  `idEstacion` INT NOT NULL,
  `idTipoFichada` INT NOT NULL,
  PRIMARY KEY (`idFichada`),
  INDEX `idEstacion_idx` (`idEstacion` ASC),
  CONSTRAINT `idFichada`
    FOREIGN KEY (`idFichada`)
    REFERENCES `mydb`.`Fichada` (`idFichada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idEstacion`
    FOREIGN KEY (`idEstacion`)
    REFERENCES `mydb`.`EstacionTren` (`idEstacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LineaColectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LineaColectivo` (
  `idLinea` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLinea`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RamalColectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RamalColectivo` (
  `idRamal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idLinea` INT NOT NULL,
  PRIMARY KEY (`idRamal`),
  INDEX `fk_RamalColectivo_LineaColectivo1_idx` (`idLinea` ASC),
  CONSTRAINT `fk_RamalColectivo_LineaColectivo1`
    FOREIGN KEY (`idLinea`)
    REFERENCES `mydb`.`LineaColectivo` (`idLinea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TramoColectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TramoColectivo` (
  `idTramo` INT NOT NULL AUTO_INCREMENT,
  `precio` DECIMAL NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `idRamal` INT NOT NULL,
  PRIMARY KEY (`idTramo`),
  INDEX `idRamal_idx` (`idRamal` ASC),
  CONSTRAINT `idRamal`
    FOREIGN KEY (`idRamal`)
    REFERENCES `mydb`.`RamalColectivo` (`idRamal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FichadaColectivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`FichadaColectivo` (
  `idFichada` INT NOT NULL,
  `idTramo` INT NOT NULL,
  INDEX `fk_FichadaColectivo_TramoColectivo1_idx` (`idTramo` ASC),
  PRIMARY KEY (`idFichada`),
  CONSTRAINT `fk_FichadaColectivo_TramoColectivo1`
    FOREIGN KEY (`idTramo`)
    REFERENCES `mydb`.`TramoColectivo` (`idTramo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FichadaColectivo_Fichada1`
    FOREIGN KEY (`idFichada`)
    REFERENCES `mydb`.`Fichada` (`idFichada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LineaSubte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LineaSubte` (
  `idLinea` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(1) NOT NULL,
  `precioViaje` DECIMAL NOT NULL,
  PRIMARY KEY (`idLinea`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EstacionSubte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EstacionSubte` (
  `idEstacion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idLinea` INT NOT NULL,
  PRIMARY KEY (`idEstacion`),
  INDEX `fk_EstacionSubte_LineaSubte1_idx` (`idLinea` ASC),
  CONSTRAINT `fk_EstacionSubte_LineaSubte1`
    FOREIGN KEY (`idLinea`)
    REFERENCES `mydb`.`LineaSubte` (`idLinea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FichadaSubte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`FichadaSubte` (
  `idFichada` INT NOT NULL,
  `idEstacion` INT NOT NULL,
  INDEX `fk_FichadaSubte_EstacionSubte1_idx` (`idEstacion` ASC),
  PRIMARY KEY (`idFichada`),
  CONSTRAINT `fk_FichadaSubte_EstacionSubte1`
    FOREIGN KEY (`idEstacion`)
    REFERENCES `mydb`.`EstacionSubte` (`idEstacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FichadaSubte_Fichada1`
    FOREIGN KEY (`idFichada`)
    REFERENCES `mydb`.`Fichada` (`idFichada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FichadaRecarga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`FichadaRecarga` (
  `monto` DECIMAL NOT NULL,
  `idFichada` INT NOT NULL,
  PRIMARY KEY (`idFichada`),
  CONSTRAINT `fk_FichadaRecarga_Fichada1`
    FOREIGN KEY (`idFichada`)
    REFERENCES `mydb`.`Fichada` (`idFichada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SeccionTren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SeccionTren` (
  `idSeccion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `importe` DECIMAL NOT NULL,
  `idRecorrido` INT NOT NULL,
  `idLinea` INT NOT NULL,
  PRIMARY KEY (`idSeccion`),
  INDEX `fk_SeccionTren_LineaTren1_idx` (`idLinea` ASC),
  CONSTRAINT `fk_SeccionTren_LineaTren1`
    FOREIGN KEY (`idLinea`)
    REFERENCES `mydb`.`LineaTren` (`idLinea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ViajeTren`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ViajeTren` (
  `idViaje` INT NOT NULL AUTO_INCREMENT,
  `idSeccion` INT NOT NULL,
  `idEstacionOrigen` INT NOT NULL,
  `idEstacionDestino` INT NOT NULL,
  `idLinea` INT NOT NULL,
  PRIMARY KEY (`idViaje`),
  INDEX `fk_ViajeTren_SeccionTren1_idx` (`idSeccion` ASC),
  INDEX `fk_ViajeTren_EstacionTren1_idx` (`idEstacionOrigen` ASC),
  INDEX `fk_ViajeTren_EstacionTren2_idx` (`idEstacionDestino` ASC),
  INDEX `fk_ViajeTren_LineaTren1_idx` (`idLinea` ASC),
  CONSTRAINT `fk_ViajeTren_SeccionTren1`
    FOREIGN KEY (`idSeccion`)
    REFERENCES `mydb`.`SeccionTren` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ViajeTren_EstacionTren1`
    FOREIGN KEY (`idEstacionOrigen`)
    REFERENCES `mydb`.`EstacionTren` (`idEstacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ViajeTren_EstacionTren2`
    FOREIGN KEY (`idEstacionDestino`)
    REFERENCES `mydb`.`EstacionTren` (`idEstacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ViajeTren_LineaTren1`
    FOREIGN KEY (`idLinea`)
    REFERENCES `mydb`.`LineaTren` (`idLinea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TransaccionSUBE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TransaccionSUBE` (
  `idTransaccion` INT NOT NULL AUTO_INCREMENT,
  `importe` DECIMAL NOT NULL,
  `idTarjetaSube` INT NOT NULL,
  `idFichada` INT NOT NULL,
  PRIMARY KEY (`idTransaccion`),
  INDEX `fk_TransaccionSUBE_TarjetaSUBE1_idx` (`idTarjetaSube` ASC),
  INDEX `fk_TransaccionSUBE_Fichada1_idx` (`idFichada` ASC),
  CONSTRAINT `fk_TransaccionSUBE_TarjetaSUBE1`
    FOREIGN KEY (`idTarjetaSube`)
    REFERENCES `mydb`.`TarjetaSUBE` (`idTarjetaSube`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TransaccionSUBE_Fichada1`
    FOREIGN KEY (`idFichada`)
    REFERENCES `mydb`.`Fichada` (`idFichada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DescuentoBoletoEstudiantil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DescuentoBoletoEstudiantil` (
  `idDescuento` INT NOT NULL,
  `descuento` DECIMAL NOT NULL,
  `viajesRestantes` INT NOT NULL,
  `tipoBoleto` INT NOT NULL,
  `idPersona` INT NOT NULL,
  INDEX `fk_DescuentoBoletoEstudiantil_Persona1_idx` (`idPersona` ASC),
  PRIMARY KEY (`idDescuento`),
  CONSTRAINT `fk_DescuentoBoletoEstudiantil_Persona1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DescuentoBoletoEstudiantil_DescuentoSUBE1`
    FOREIGN KEY (`idDescuento`)
    REFERENCES `mydb`.`DescuentoSUBE` (`idDescuento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DescuentoTarifaSocial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DescuentoTarifaSocial` (
  `idDescuento` INT NOT NULL,
  `descuento` DECIMAL NOT NULL,
  `idPersona` INT NOT NULL,
  INDEX `fk_DescuentoTarifaSocial_Persona1_idx` (`idPersona` ASC),
  PRIMARY KEY (`idDescuento`),
  CONSTRAINT `fk_DescuentoTarifaSocial_Persona1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DescuentoTarifaSocial_DescuentoSUBE1`
    FOREIGN KEY (`idDescuento`)
    REFERENCES `mydb`.`DescuentoSUBE` (`idDescuento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `idPersona` INT NULL,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `idPersona_idx` (`idPersona` ASC),
  CONSTRAINT `idPersona`
    FOREIGN KEY (`idPersona`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Permiso` (
  `idPermiso` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPermiso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PermisoPersona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PermisoPersona` (
  `Permiso_idPermiso` INT NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`Permiso_idPermiso`, `Usuario_idUsuario`),
  INDEX `fk_Permiso_has_Usuario_Usuario1_idx` (`Usuario_idUsuario` ASC),
  INDEX `fk_Permiso_has_Usuario_Permiso1_idx` (`Permiso_idPermiso` ASC),
  CONSTRAINT `fk_Permiso_has_Usuario_Permiso1`
    FOREIGN KEY (`Permiso_idPermiso`)
    REFERENCES `mydb`.`Permiso` (`idPermiso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Permiso_has_Usuario_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SELECT * FROM Permiso;