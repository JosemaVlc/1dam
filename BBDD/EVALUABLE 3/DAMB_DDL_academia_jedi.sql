-------------
-- METADATOS
-------------

DROP DATABASE acadjediDB;
CREATE DATABASE acadjediDB CHARACTER SET utf8 COLLATE utf8_spanish_ci;

USE acadjediDB;

-- TABLA (1)
CREATE TABLE Academia (
     codacad        VARCHAR(10),
     nombre         VARCHAR(100),
     fechaini       DATE,
     fechafin       DATE,
     CONSTRAINT aca_cod_pk PRIMARY KEY (codacad)
);

-- TABLA (2)
CREATE TABLE Maestro (
     idmaestro      VARCHAR(8),
     nombre         VARCHAR(30) NOT NULL,
     apellidos      VARCHAR(60) NOT NULL,
     fechagrado     DATE,
     CONSTRAINT mae_idm_pk PRIMARY KEY (idmaestro)
);

-- TABLA (3)
CREATE TABLE Curso (
     codcurso       VARCHAR(10),
     codacad        VARCHAR(10),
     nombre         VARCHAR(50),
     descripcion    VARCHAR(255),
     idmaestro      VARCHAR(8) NOT NULL,
     CONSTRAINT cur_ccu_pk PRIMARY KEY (codcurso, codacad),
     CONSTRAINT cur_cac_fk FOREIGN KEY (codacad) REFERENCES Academia (codacad),
     CONSTRAINT cur_idm_fk FOREIGN KEY (idmaestro) REFERENCES Maestro (idmaestro)
);

-- TABLA (4)
CREATE TABLE Ofertar (
     codcurso       VARCHAR(10),
     codacad        VARCHAR(10),
     fechaini       DATE NOT NULL,
     fechafin       DATE NOT NULL,
     CONSTRAINT ofe_cod_pk PRIMARY KEY (codcurso, codacad),
     CONSTRAINT ofe_cod_fk FOREIGN KEY (codcurso, codacad) REFERENCES Curso (codcurso, codacad)
);

-- TABLA (5)
CREATE TABLE Alumno (
     idalumno       VARCHAR(8),
     nombre         VARCHAR(30) NOT NULL,
     apellidos      VARCHAR(60) NOT NULL,
     fechaini       DATE,
     fechafin       DATE,
     ayudante       VARCHAR(8),
     codcurso       VARCHAR(10) NOT NULL,
     codacad        VARCHAR(10) NOT NULL,
     CONSTRAINT alu_ida_pk PRIMARY KEY (idalumno),
     CONSTRAINT alu_ayu_fk FOREIGN KEY (ayudante) REFERENCES Alumno (idalumno),
     CONSTRAINT alu_cod_fk FOREIGN KEY (codcurso, codacad) REFERENCES Curso (codcurso, codacad)
);

-- TABLA (6)
CREATE TABLE Nivelesmidi (
     idalumno       VARCHAR(8),
     midiclorianos  INT,
     CONSTRAINT niv_idm_pk PRIMARY KEY (idalumno, midiclorianos),
     CONSTRAINT niv_ida_fk FOREIGN KEY (idalumno) REFERENCES Alumno (idalumno)
);

-- TABLA (7)
CREATE TABLE Padawan (
     idalumno       VARCHAR(8),
     fechaentrada   DATE,
     CONSTRAINT pad_ida_pk PRIMARY KEY (idalumno),
     CONSTRAINT pad_ida_fk FOREIGN KEY (idalumno) REFERENCES Alumno (idalumno)
);

-- TABLA (8)
CREATE TABLE Senior (
     idalumno       VARCHAR(8),
     especialidad   VARCHAR(50),
     fechanivel     DATE,
     CONSTRAINT sen_ida_pk PRIMARY KEY (idalumno),
     CONSTRAINT sen_ida_fk FOREIGN KEY (idalumno) REFERENCES Alumno (idalumno)
);

-- TABLA (9)
CREATE TABLE Coste (
     linea          INT,
     codcurso       VARCHAR(10),
     codacad        VARCHAR(10),
     concepto       VARCHAR(255) NOT NULL,
     importe        FLOAT NOT NULL,
     CONSTRAINT cos_lic_pk PRIMARY KEY (linea, codcurso, codacad),
     CONSTRAINT cos_cod_fk FOREIGN KEY (codcurso, codacad) REFERENCES Curso (codcurso, codacad) ON DELETE CASCADE
);

-------------
-- DATOS
-------------

-- Academias
INSERT INTO Academia (codacad , nombre, fechaini, fechafin)
VALUES ('ENDOR', 'Academia planeta Endor', '1980-07-01', NULL);
INSERT INTO Academia (codacad , nombre, fechaini, fechafin)
VALUES ('AHCH-TO', 'Academia planeta Ahch-To', '1970-09-01', NULL);
INSERT INTO Academia (codacad , nombre, fechaini, fechafin)
VALUES ('HOTH', 'Academia planeta Hoth', '1970-09-01', NULL);
INSERT INTO Academia (codacad , nombre, fechaini, fechafin)
VALUES ('CRAIT', 'Academia planeta Crait', '1900-08-01', '2017-04-18');
INSERT INTO Academia (codacad , nombre, fechaini, fechafin)
VALUES ('DEVARON', 'Academia planeta Devaron', '1500-09-01', NULL);
INSERT INTO Academia (codacad , nombre, fechaini, fechafin)
VALUES ('GLEE', 'Academia planeta Glee Anselm', '1900-09-01', NULL);
INSERT INTO Academia (codacad , nombre, fechaini, fechafin)
VALUES ('DANT', 'Academia planeta Dantooine', '1977-05-04', NULL);

-- Maestros
INSERT INTO Maestro (idmaestro, nombre, apellidos, fechagrado)
VALUES ('YOD', 'Yoda', 'Gran Maestro Orden Jedi', '1200-05-04');
INSERT INTO Maestro (idmaestro, nombre, apellidos, fechagrado)
VALUES ('LUK', 'Luke', 'Skywalker', '1983-02-27');
INSERT INTO Maestro (idmaestro, nombre, apellidos, fechagrado)
VALUES ('MAW', 'Mace', 'Windu', '1977-05-04');
INSERT INTO Maestro (idmaestro, nombre, apellidos, fechagrado)
VALUES ('SHA', 'Shaak', 'Ti', '1977-05-04');
INSERT INTO Maestro (idmaestro, nombre, apellidos, fechagrado)
VALUES ('QUI', 'Qui-Gon', 'Jinn', '1977-05-04');
INSERT INTO Maestro (idmaestro, nombre, apellidos, fechagrado)
VALUES ('KIT', 'Kit', 'Fisto', '1977-05-04');
INSERT INTO Maestro (idmaestro, nombre, apellidos, fechagrado)
VALUES ('OBW', 'Obi-Wan', 'Kenobi', '1977-05-04');
INSERT INTO Maestro (idmaestro, nombre, apellidos, fechagrado)
VALUES ('STA', 'Sta-Den', 'Eekin', '1977-05-04');
INSERT INTO Maestro (idmaestro, nombre, apellidos, fechagrado)
VALUES ('FUM', 'Fumanchú', 'Kung-fu', '2007-05-04');

-- Cursos
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('7050', 'ENDOR', 'CAPAD2', 'Curso avanzado padawan nivel 2', 'LUK');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('5050', 'ENDOR', 'CBPAD1', 'Curso básico padawan nivel 1', 'LUK');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('6050', 'ENDOR', 'CBPAD2', 'Curso básico padawan nivel 2', 'LUK');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('8050', 'DEVARON', 'CMJ', 'Curso maestro Jedi', 'YOD');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('7050', 'DEVARON', 'CAPAD2', 'Curso avanzado padawan nivel 2', 'OBW');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('6050', 'DEVARON', 'CBPAD2', 'Curso básico padawan nivel 2', 'OBW');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('5050', 'DEVARON', 'CBPAD1', 'Curso básico padawan nivel 1', 'OBW');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('8050', 'CRAIT', 'CMJ', 'Curso maestro Jedi', 'YOD');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('5050', 'CRAIT', 'CBPAD1', 'Curso básico padawan nivel 1', 'OBW');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('8050', 'AHCH-TO', 'CMJ', 'Curso maestro Jedi', 'YOD');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('7050', 'AHCH-TO', 'CAPAD2', 'Curso avanzado padawan nivel 2', 'MAW');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('6050', 'AHCH-TO', 'CBPAD2', 'Curso básico padawan nivel 2', 'MAW');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('5050', 'AHCH-TO', 'CBPAD1', 'Curso básico padawan nivel 1', 'MAW');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('7050', 'HOTH', 'CBPAD2', 'Curso avanzado padawan nivel 2', 'SHA');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('5050', 'HOTH', 'CBPAD1', 'Curso básico padawan nivel 1', 'OBW');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('5050', 'GLEE', 'CBPAD1', 'Curso básico padawan nivel 1', 'KIT');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('6050', 'GLEE', 'CBPAD2', 'Curso básico padawan nivel 2', 'KIT');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('7050', 'GLEE', 'CAPAD2', 'Curso avanzado padawan nivel 2', 'KIT');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('5050', 'DANT', 'CBPAD1', 'Curso básico padawan nivel 1', 'STA');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('6050', 'DANT', 'CBPAD2', 'Curso básico padawan nivel 2', 'STA');
INSERT INTO Curso (codcurso, codacad, nombre, descripcion, idmaestro)
VALUES ('7050', 'DANT', 'CAPAD2', 'Curso avanzado padawan nivel 2', 'STA');

-- Oferta de cursos
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('7050', 'ENDOR', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('6050', 'ENDOR', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('5050', 'ENDOR', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('8050', 'AHCH-TO', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('7050', 'AHCH-TO', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('6050', 'AHCH-TO', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('5050', 'AHCH-TO', '2021-09-01', '2022-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('7050', 'HOTH', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('5050', 'HOTH', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('8050', 'DEVARON', '1970-09-01', '1971-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('7050', 'DEVARON', '1970-09-01', '1971-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('5050', 'DEVARON', '2006-09-01', '2007-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('8050', 'CRAIT', '1900-09-01', '1901-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('5050', 'CRAIT', '1973-09-01', '1974-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('7050', 'GLEE', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('5050', 'GLEE', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('6050', 'GLEE', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('7050', 'DANT', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('5050', 'DANT', '2022-09-01', '2023-06-30');
INSERT INTO Ofertar (codcurso, codacad, fechaini, fechafin)
VALUES ('6050', 'DANT', '2022-09-01', '2023-06-30');

-- Alumnos
INSERT INTO Alumno (idalumno, nombre, apellidos, fechaini, fechafin, ayudante, codcurso, codacad)
VALUES ('ALU001', 'Qui-Gon', 'Jinn', '1960-09-01', '1961-06-30', NULL, '8050', 'DEVARON');
INSERT INTO Nivelesmidi (idalumno, midiclorianos)
VALUES ('ALU001', 18500);

INSERT INTO Alumno (idalumno, nombre, apellidos, fechaini, fechafin, ayudante, codcurso, codacad)
VALUES ('ALU002', 'Obi-Wan', 'Kenobi', '1970-09-01', '1971-06-30', 'ALU001', '8050', 'DEVARON');
INSERT INTO Nivelesmidi (idalumno, midiclorianos)
VALUES ('ALU002', 18000);

INSERT INTO Alumno (idalumno, nombre, apellidos, fechaini, fechafin, ayudante, codcurso, codacad)
VALUES ('ALU003', 'Anakin', 'Skywalker', '1970-09-01', '1971-06-30', 'ALU002', '7050', 'DEVARON');
INSERT INTO Padawan (idalumno, fechaentrada)
VALUES ('ALU003', '1970-09-01');
INSERT INTO Senior (idalumno, especialidad, fechanivel)
VALUES ('ALU003', 'técnicas lado oscuro', '1971-07-01');
INSERT INTO Nivelesmidi (idalumno, midiclorianos)
VALUES ('ALU003', 19000);

INSERT INTO Alumno (idalumno, nombre, apellidos, fechaini, fechafin, ayudante, codcurso, codacad)
VALUES ('ALU004', 'Ahsoka', 'Tano', '1973-09-01', '1974-06-30', 'ALU003', '5050', 'CRAIT');
INSERT INTO Padawan (idalumno, fechaentrada)
VALUES ('ALU004', '1973-09-01');
INSERT INTO Senior (idalumno, especialidad, fechanivel)
VALUES ('ALU004', 'sable láser', '1976-07-01');
INSERT INTO Nivelesmidi (idalumno, midiclorianos)
VALUES ('ALU004', 17200);

INSERT INTO Alumno (idalumno, nombre, apellidos, fechaini, fechafin, ayudante, codcurso, codacad)
VALUES ('ALU005', 'Luke', 'Skywalker', '1977-09-01', '1978-06-30', 'ALU002', '5050', 'HOTH');
INSERT INTO Padawan (idalumno, fechaentrada)
VALUES ('ALU005', '1977-09-01');
INSERT INTO Senior (idalumno, especialidad, fechanivel)
VALUES ('ALU005', 'sable láser', '1978-07-01');
INSERT INTO Nivelesmidi (idalumno, midiclorianos)
VALUES ('ALU005', 19500);

INSERT INTO Alumno (idalumno, nombre, apellidos, fechaini, fechafin, ayudante, codcurso, codacad)
VALUES ('ALU006', 'Rey', 'Skywalker', '2022-09-01', '2023-06-30', NULL, '7050', 'ENDOR');
INSERT INTO Senior (idalumno, especialidad, fechanivel)
VALUES ('ALU006', 'sable láser', '2022-07-01');
INSERT INTO Nivelesmidi (idalumno, midiclorianos)
VALUES ('ALU006', 15000);

INSERT INTO Alumno (idalumno, nombre, apellidos, fechaini, fechafin, ayudante, codcurso, codacad)
VALUES ('ALU007', 'Baby', 'Yoda', '2022-09-01', '2023-06-30', NULL, '6050', 'AHCH-TO');
INSERT INTO Padawan (idalumno, fechaentrada)
VALUES ('ALU007', '2021-07-31');
INSERT INTO Senior (idalumno, especialidad, fechanivel)
VALUES ('ALU007', 'telequinesis', '2022-07-01');
INSERT INTO Nivelesmidi (idalumno, midiclorianos)
VALUES ('ALU007', 20000);

INSERT INTO Alumno (idalumno, nombre, apellidos, fechaini, fechafin, ayudante, codcurso, codacad)
VALUES ('ALU008', 'Tallisibeth', 'Enwandung-Esterhazy', '2022-09-01', '2023-06-30', NULL, '7050', 'GLEE');
INSERT INTO Senior (idalumno, especialidad, fechanivel)
VALUES ('ALU008', 'sable láser', '2022-07-01');
INSERT INTO Nivelesmidi (idalumno, midiclorianos)
VALUES ('ALU008', 14500);

INSERT INTO Alumno (idalumno, nombre, apellidos, fechaini, fechafin, ayudante, codcurso, codacad)
VALUES ('ALU009', 'Chirrut', 'Îmwe', '2022-09-01', '2023-06-30', NULL, '6050', 'GLEE');
INSERT INTO Padawan (idalumno, fechaentrada)
VALUES ('ALU009', '2022-09-01');

-- Costes
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (1, '6050', 'GLEE', 'Alquiler de sables de bambú', 2.5);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (2, '6050', 'GLEE', 'Seguro galáctico', 1.05);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (3, '6050', 'GLEE', 'Uniformes', 3.29);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (4, '6050', 'GLEE', 'Libros electrónicos Jedi', 5.86);

INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (1, '8050', 'DEVARON', 'Alquiler de sables láser', 5.5);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (2, '8050', 'DEVARON', 'Simulador Jedi', 10.15);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (3, '8050', 'DEVARON', 'Prácticas en escenarios reales', 22.99);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (4, '8050', 'DEVARON', 'Tasas título maestro Jedi', 0.55);

INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (1, '5050', 'ENDOR', 'Seguro instalaciones', 25.5);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (2, '5050', 'ENDOR', 'Simulador Jedi', 4.45);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (3, '5050', 'ENDOR', 'Prácticas en escenarios reales', 7.89);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (1, '6050', 'ENDOR', 'Seguro instalaciones', 30.5);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (2, '6050', 'ENDOR', 'Simulador Jedi', 10.17);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (3, '6050', 'ENDOR', 'Prácticas en escenarios reales', 12.27);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (1, '7050', 'ENDOR', 'Alquiler de sables láser', 5.5);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (2, '7050', 'ENDOR', 'Simulador Jedi', 10.15);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (3, '7050', 'ENDOR', 'Prácticas en escenarios reales', 22.99);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (4, '7050', 'ENDOR', 'Seguro instalaciones', 33.5);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (5, '7050', 'ENDOR', 'Técnicas de defensa lado oscuro (II)', 11.43);

INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (1, '6050', 'AHCH-TO', 'Seguro instalaciones', 20.5);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (2, '6050', 'AHCH-TO', 'Visitas maestro Yoda', 34.99);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (3, '6050', 'AHCH-TO', 'Prácticas en escenarios reales', 22.99);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (4, '6050', 'AHCH-TO', 'Técnicas de telequinesis inversa', 15.27);

INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (1, '5050', 'HOTH', 'Anulación de matrícula', 0.89);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (2, '5050', 'HOTH', 'Alquiler de sables láser', 5.5);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (3, '5050', 'HOTH', 'Simulador Jedi', 10.15);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (4, '5050', 'HOTH', 'Prácticas en escenarios reales', 22.99);

INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (1, '5050', 'CRAIT', 'Seguro instalaciones', 40.79);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (2, '5050', 'CRAIT', 'Visitas maestro Yoda y Mace Windu', 25.37);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (3, '5050', 'CRAIT', 'Prácticas en escenarios reales', 22.99);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (4, '5050', 'CRAIT', 'Técnicas de defensa lado oscuro', 11.21);

INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (1, '5050', 'DANT', 'Seguro instalaciones', 19.85);
INSERT INTO Coste (linea, codcurso, codacad, concepto, importe)
VALUES (2, '6050', 'DANT', 'Seguro instalaciones', 21.85);

