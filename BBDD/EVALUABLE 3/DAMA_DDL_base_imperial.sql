-------------
-- METADATOS
-------------

DROP DATABASE imperialbaseDB;
CREATE DATABASE imperialbaseDB CHARACTER SET utf8 COLLATE utf8_spanish_ci;

USE imperialbaseDB;

-- TABLA (1)
CREATE TABLE Base (
     codbase        VARCHAR(10),
     nombre         VARCHAR(100),
     fechaini       DATE,
     fechafin       DATE,
     CONSTRAINT bas_cod_pk PRIMARY KEY (codbase)
);

-- TABLA (2)
CREATE TABLE Hangar (
     nombre         VARCHAR(50),
     descripcion    VARCHAR(255),
     codbase        VARCHAR(10) NOT NULL,
     CONSTRAINT han_nom_pk PRIMARY KEY (nombre),
     CONSTRAINT han_bas_fk FOREIGN KEY (codbase) REFERENCES Base (codbase)
);

-- TABLA (3). Podemos suponer que cuando se crea está operativa (valor por defecto ‘S’)
CREATE TABLE Nave (
     matricula      VARCHAR(10),
     nombre         VARCHAR(50),
     operativa      VARCHAR(1) DEFAULT 'S',
     hangar         VARCHAR(50) NOT NULL,
     CONSTRAINT nav_mat_pk PRIMARY KEY (matricula),
     CONSTRAINT nav_han_fk FOREIGN KEY (hangar) REFERENCES Hangar (nombre)
);

-- TABLA (4)
CREATE TABLE Tiefighter (
     matricula      VARCHAR(10),
     biplaza        VARCHAR(1) DEFAULT 'N',
     CONSTRAINT tie_mat_pk PRIMARY KEY (matricula),
     CONSTRAINT tie_mat_fk FOREIGN KEY (matricula) REFERENCES Nave (matricula)
);
-- TABLA (5)
CREATE TABLE Armamento (
     matricula      VARCHAR(10),
     armamento      VARCHAR(30),
     CONSTRAINT arm_ma_pk PRIMARY KEY (matricula, armamento),
     CONSTRAINT arm_mat_fk FOREIGN KEY (matricula) REFERENCES Tiefighter (matricula)
);

-- TABLA (6). Suponemos que un piloto tiene nombre y apellidos (no puede tener valor nulo)
CREATE TABLE Piloto (
     licencia       VARCHAR(10),
     nombre         VARCHAR(30) NOT NULL,
     apellidos      VARCHAR(50) NOT NULL,
     fechalic       DATE,
     supervisor     VARCHAR(10),
     CONSTRAINT pil_lic_pk PRIMARY KEY (licencia),
     CONSTRAINT pil_sup_fk FOREIGN KEY (supervisor) REFERENCES Piloto (licencia)
);

-- TABLA (7)
CREATE TABLE Crucero (
     matricula      VARCHAR(10),
     carga          FLOAT,
     escudo         VARCHAR(1),
     licencia       VARCHAR(10) NOT NULL,
     CONSTRAINT cru_mat_pk PRIMARY KEY (matricula),
     CONSTRAINT cru_mat_fk FOREIGN KEY (matricula) REFERENCES Nave (matricula),
     CONSTRAINT cru_lic_fk FOREIGN KEY (licencia) REFERENCES Piloto (licencia)
);

-- TABLA (8)
CREATE TABLE Transporte (
     codigo    VARCHAR(10),
     objetivo  VARCHAR(255),
     CONSTRAINT tra_cod_pk PRIMARY KEY (codigo)
);

-- TABLA (9)
CREATE TABLE Realizar (
     codigo         VARCHAR(10),
     matricula      VARCHAR(10),
     fechaini       DATE,
     fechafin       DATE,
     exito          VARCHAR(1),
     CONSTRAINT rea_codmat_pk PRIMARY KEY (codigo, matricula),
     CONSTRAINT rea_cod_fk FOREIGN KEY (codigo) REFERENCES Transporte (codigo),
     CONSTRAINT rea_mat_fk FOREIGN KEY (matricula) REFERENCES Nave (matricula)
);

-- TABLA (10)
CREATE TABLE Coste (
     linea          INT,
     codigo         VARCHAR(10),
     concepto       VARCHAR(255) NOT NULL,
     importe        DOUBLE NOT NULL,
     CONSTRAINT cos_lincod_pk PRIMARY KEY (linea, codigo),
     CONSTRAINT cos_cod_fk FOREIGN KEY (codigo) REFERENCES Transporte (codigo) ON DELETE CASCADE
);

-------------
-- DATOS
-------------

-- Bases
INSERT INTO Base (codbase , nombre, fechaini, fechafin)
VALUES ('ANOAT', 'Base planeta Anoat', '1980-07-01', NULL);
INSERT INTO Base (codbase , nombre, fechaini, fechafin)
VALUES ('SULLUST', 'Base planeta Sullust', '1977-05-04', NULL);
INSERT INTO Base (codbase , nombre, fechaini, fechafin)
VALUES ('CORUSCANT', 'Base planeta Coruscant', '1977-05-04', NULL);
INSERT INTO Base (codbase , nombre, fechaini, fechafin)
VALUES ('EADU', 'Base planeta Eadu', '1970-09-01', NULL);
INSERT INTO Base (codbase , nombre, fechaini, fechafin)
VALUES ('EXEGOL', 'Base planeta Exegol', '1970-09-01', NULL);
INSERT INTO Base (codbase , nombre, fechaini, fechafin)
VALUES ('BASESK', 'Base planeta Starkiller', '1900-08-01', '2017-04-18');
INSERT INTO Base (codbase , nombre, fechaini, fechafin)
VALUES ('GEONOSIS', 'Base planeta Geonosis', '1900-09-01', NULL);
INSERT INTO Base (codbase , nombre, fechaini, fechafin)
VALUES ('SCARIF', 'Base planeta Scarif', '1977-05-04', NULL);

-- Hangares
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HANOAT01', 'Hangar Anoat 1', 'ANOAT');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HANOAT02', 'Hangar Anoat 2', 'ANOAT');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HSULLUST01', 'Hangar Sullust 1', 'SULLUST');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HSULLUST02', 'Hangar Sullust 2', 'SULLUST');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HCORUSCANT01', 'Hangar Coruscant 1', 'CORUSCANT');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HCORUSCANT02', 'Hangar Coruscant 2', 'CORUSCANT');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HCORUSCANT03', 'Hangar Coruscant 3', 'CORUSCANT');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HEADU01', 'Hangar Eadu 1', 'EADU');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HEADU02', 'Hangar Eadu 2', 'EADU');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HBASESK01', 'Hangar Starkiller 1', 'BASESK');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HGEONOSIS01', 'Hangar Geonosis 1', 'GEONOSIS');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HGEONOSIS02', 'Hangar Geonosis 2', 'GEONOSIS');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HSCARIF01', 'Hangar Scarif 1', 'SCARIF');
INSERT INTO Hangar (nombre, descripcion, codbase)
VALUES ('HSCARIF02', 'Hangar Scarif 2', 'SCARIF');

-- Pilotos
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI001', 'Lord', 'Darth Vader', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI002', 'Moff', 'Tarkin', '1960-09-01', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI003', 'Almirante', 'Thrawn', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI004', 'Biggs', 'Darklighter', '2012-10-07', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI005', 'Darth', 'Maul', '1999-06-30', 'LI001');
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI006', 'PT001', 'Piloto DS-61-1', '2015-11-12', 'LI004');
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI007', 'PT002', 'Piloto DS-61-2', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI008', 'Barón', 'Soontir Fel', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI009', 'Maarek', 'Stele', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI010', 'Mulchive', 'Wermis', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI011', 'Loka', 'Hask', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI012', 'Tycho', 'Celchu', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI013', 'PT003', 'Piloto DS-61-3', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI014', 'PT004', 'Piloto DS-61-4', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI015', 'PT005', 'Piloto DS-61-5', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI016', 'PT006', 'Piloto DS-61-6', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI017', 'PT007', 'Piloto DS-61-7', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI018', 'PT008', 'Piloto DS-61-8', '1977-05-04', NULL);
INSERT INTO Piloto (licencia, nombre, apellidos, fechalic, supervisor)
VALUES ('LI019', 'Kylo', 'Ren', '2015-07-01', NULL);

-- Naves
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI001', 'Crucero imperial nodriza', 'S', 'HANOAT01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI001', 30000, 'S', 'LI001');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CL002', 'Crucero logístico', 'S', 'HANOAT01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CL002', 15000, 'S', 'LI009');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI003', 'Crucero de ataque', 'S', 'HANOAT02');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI003', 12500, 'S', 'LI010');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI004', 'Crucero de ataque', 'S', 'HCORUSCANT01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI004', 12500, 'S', 'LI003');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CT005', 'Crucero de transporte', 'S', 'HCORUSCANT01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CT005', 35000, 'S', 'LI002');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CT006', 'Crucero de transporte', 'S', 'HCORUSCANT01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CT006', 25000, 'S', 'LI007');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI007', 'Crucero de ataque', 'S', 'HCORUSCANT02');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI007', 12500, 'S', 'LI011');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI008', 'Crucero de ataque', 'N', 'HCORUSCANT02');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI008', 12500, 'N', 'LI012');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI009', 'Crucero de ataque', 'N', 'HCORUSCANT02');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI009', 12500, 'N', 'LI013');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('TF001', 'Tiefighter escuadrón de ataque', 'S', 'HCORUSCANT03');
INSERT INTO Tiefighter (matricula, biplaza)
VALUES ('TF001', 'N');
INSERT INTO Armamento (matricula, armamento)
VALUES ('TF001', 'largo alcance');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('TF002', 'Tiefighter escuadrón de ataque', 'S', 'HCORUSCANT03');
INSERT INTO Tiefighter (matricula, biplaza)
VALUES ('TF002', 'S');
INSERT INTO Armamento (matricula, armamento)
VALUES ('TF002', 'largo alcance');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('TF003', 'Tiefighter escuadrón de ataque', 'S', 'HCORUSCANT03');
INSERT INTO Tiefighter (matricula, biplaza)
VALUES ('TF003', 'N');
INSERT INTO Armamento (matricula, armamento)
VALUES ('TF003', 'láser alta intensidad');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI010', 'Crucero de ataque', 'S', 'HSULLUST01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI010', 12500, 'S', 'LI014');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI011', 'Crucero de escolta', 'S', 'HSULLUST01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI011', 20000, 'N', 'LI015');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI012', 'Crucero de escolta', 'S', 'HSULLUST02');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI012', 20000, 'N', 'LI016');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI013', 'Crucero de escolta', 'N', 'HSULLUST02');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI013', 20000, 'N', 'LI017');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI014', 'Crucero de ataque', 'S', 'HSULLUST02');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI014', 12500, 'S', 'LI018');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI015', 'Crucero de ataque', 'N', 'HBASESK01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI015', 12500, 'S', 'LI019');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI016', 'Crucero de ataque', 'N', 'HBASESK01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI016', 12500, 'S', 'LI008');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('TF004', 'Tiefighter escuadrón de ataque', 'N', 'HBASESK01');
INSERT INTO Tiefighter (matricula, biplaza)
VALUES ('TF004', 'N');
INSERT INTO Armamento (matricula, armamento)
VALUES ('TF004', 'láser alta intensidad');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('NE001', 'Nave escolta', 'N', 'HBASESK01');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('NL001', 'Nave logística', 'N', 'HBASESK01');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI017', 'Crucero de ataque', 'S', 'HEADU01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI017', 12500, 'S', 'LI001');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI018', 'Crucero de ataque', 'S', 'HEADU01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI018', 12500, 'S', 'LI006');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('TF005', 'Tiefighter de escolta', 'S', 'HEADU02');
INSERT INTO Tiefighter (matricula, biplaza)
VALUES ('TF005', 'N');
INSERT INTO Armamento (matricula, armamento)
VALUES ('TF005', 'largo alcance');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('TF006', 'Tiefighter de escolta', 'S', 'HEADU02');
INSERT INTO Tiefighter (matricula, biplaza)
VALUES ('TF006', 'N');
INSERT INTO Armamento (matricula, armamento)
VALUES ('TF006', 'largo alcance');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI019', 'Crucero de ataque', 'S', 'HSCARIF01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI019', 12500, 'N', 'LI004');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI020', 'Crucero de ataque', 'S', 'HSCARIF01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI020', 12500, 'N', 'LI005');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('CI021', 'Crucero de ataque', 'S', 'HSCARIF01');
INSERT INTO Crucero (matricula, carga, escudo, licencia)
VALUES ('CI021', 12500, 'N', 'LI008');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('TF007', 'Tiefighter de escolta', 'S', 'HSCARIF02');
INSERT INTO Tiefighter (matricula, biplaza)
VALUES ('TF007', 'N');
INSERT INTO Armamento (matricula, armamento)
VALUES ('TF007', 'largo alcance');
INSERT INTO Nave (matricula, nombre, operativa, hangar)
VALUES ('TF008', 'Tiefighter escuadrón de ataque', 'S', 'HSCARIF02');
INSERT INTO Tiefighter (matricula, biplaza)
VALUES ('TF008', 'S');
INSERT INTO Armamento (matricula, armamento)
VALUES ('TF008', 'láser alta intensidad');

-- Transportes
INSERT INTO Transporte (codigo, objetivo)
VALUES ('MA001', 'Destrucción planeta Alderaan');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MA001', 'CI001', '1977-05-04', '1977-05-07', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MA001', 'CL002', '1977-05-04', '1977-05-07', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MA001', 'CI003', '1977-05-04', '1977-05-07', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MA001', 'CT006', '1977-05-04', '1977-05-07', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MA001', 'CI007', '1977-05-04', '1977-05-07', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MA001', 'CI008', '1977-05-04', '1977-05-07', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MA001', 'CI009', '1977-05-04', '1977-05-07', 'S');

INSERT INTO Transporte (codigo, objetivo)
VALUES ('MT002', 'Transporte coaxium base Coruscant');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MT002', 'CT005', '1983-02-01', '1983-02-05', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MT002', 'CT006', '1983-02-01', '1983-02-05', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MT002', 'CI004', '1983-02-01', '1983-02-05', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MT002', 'CI007', '1983-02-01', '1983-02-05', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MT002', 'TF004', '1983-02-01', '1983-02-05', 'S');

INSERT INTO Transporte (codigo, objetivo)
VALUES ('MI003', 'Incursión base rebelde Endor');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MI003', 'TF001', '2002-07-17', '1983-07-20', 'N');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MI003', 'TF002', '2002-07-17', '1983-07-20', 'N');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MI003', 'TF003', '2002-07-17', '1983-07-20', 'N');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MI003', 'TF004', '2002-07-17', '1983-07-20', 'N');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MI003', 'TF005', '2002-07-17', '1983-07-20', 'N');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MI003', 'TF006', '2002-07-17', '1983-07-20', 'N');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MI003', 'TF007', '2002-07-17', '1983-07-20', 'N');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MI003', 'TF008', '2002-07-17', '1983-07-20', 'N');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('MI003', 'CI017', '2002-07-17', '1983-07-20', 'N');

INSERT INTO Transporte (codigo, objetivo)
VALUES ('ME004', 'Localizar base Yavin 4');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('ME004', 'CI019', '2016-03-16', '2016-03-20', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('ME004', 'CI020', '2016-03-16', '2016-03-20', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('ME004', 'CI021', '2016-03-16', '2016-03-20', 'S');
INSERT INTO Realizar (codigo, matricula, fechaini, fechafin, exito)
VALUES ('ME004', 'NE001', '2016-03-16', '2016-03-20', 'S');

-- Costes
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (1, 'MA001', 'Dietas pilotos', 45);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (2, 'MA001', 'Reparaciones Tiefighter', 1433.79);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (3, 'MA001', 'Reparaciones escudos deflectores', 227.01);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (4, 'MA001', 'Combustible coaxium', 189.67);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (5, 'MA001', 'Desfile imperial', 93.75);

INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (1, 'MT002', 'Dietas pilotos', 30.06);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (2, 'MT002', 'Reparaciones de mantenimiento', 15.87);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (3, 'MT002', 'Tasas aeroportuarias', 10);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (4, 'MT002', 'Combustible coaxium', 81.99);

INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (1, 'MI003', 'Dietas pilotos', 50);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (2, 'MI003', 'Reparaciones Tiefighter', 2101.55);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (3, 'MI003', 'Reparaciones escudos deflectores', 408.35);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (4, 'MI003', 'Combustible coaxium', 223.92);

INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (1, 'ME004', 'Dietas pilotos', 20);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (2, 'ME004', 'Reparaciones Tiefighter', 899.91);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (3, 'ME004', 'Reparaciones escudos deflectores', 124.12);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (4, 'ME004', 'Combustible coaxium', 345.37);
INSERT INTO Coste (linea, codigo, concepto, importe)
VALUES (5, 'ME004', 'Reparaciones otras naves', 67.05);

