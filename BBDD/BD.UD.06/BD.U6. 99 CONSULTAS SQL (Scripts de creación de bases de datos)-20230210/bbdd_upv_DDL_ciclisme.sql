drop database if exists ciclisme;
create database ciclisme;
use ciclisme;

drop table if exists equips;
create table equips
( nom VARCHAR (25) NOT NULL,
  director VARCHAR (30),
  PRIMARY KEY (nom)
) engine=innodb;

insert into equips values
 ( 'Amore Vita','Ricardo Padacci'), ( 'Artiach','Jose Perez'), ( 'Banesto','Miguel Echevarria'),
 ( 'Bresciali-Refin','Pietro Armani'), ( 'Carrera','Luigi Petroni'), ( 'Castorama','Jean Philip'),
 ( 'Euskadi','Pedro Txucaru'), ( 'Gatorade','Gian Luca Pacceli'), ( 'Gewiss','Moreno Argentin'),
 ( 'Jolly Club','Johan Richard'), ( 'Kelme','Alvaro Pino'), ( 'Lotus Festina','Suarez Cuevas'),
 ( 'Mapei-Clas','Juan Fernandez'), ( 'Mercatone Uno','Ettore Romano'), ( 'Motorola','John Fidwell'),
 ( 'Navigare','Lonrenzo Sciacci'), ( 'ONCE','Manuel Sainz'), ( 'PDM','Piet Van Der Kruis'),
 ( 'Seguros Amaya','Minguez'), ( 'Telecom','Morgan Reikcard'), ( 'TVM','Steveens Henk'),
 ( 'Wordperfect','Bill Gates');



drop table if exists ciclistes;
create table ciclistes
( dorsal INT (4) NOT NULL,
  nom VARCHAR (30) NOT NULL,
  edat INT (3),
  equip VARCHAR (25),
  PRIMARY KEY (dorsal),
 FOREIGN KEY (equip) references equips (nom)
) engine=innodb;

insert into ciclistes (dorsal,edat,nom,equip) values
(1,32,'Miguel Indurain','Banesto'),(2,35,'Pedro Delgado','Banesto'),(3,27,'Alex Zulle','ONCE'),
(4,30,'Tony Rominger','Mapei-Clas'),(5,32,'Gert-Jan Theunisse','TVM'),
(6,33,'Adriano Baffi','Mercatone Uno'),(7,30,'Massimiliano Lelli','Mercatone Uno'),
(8,33,'Jean Van Poppel','Lotus Festina'),
(9,34,'Massimo Podenzana','Navigare'),(10,28,'Mario Cipollini','Mercatone Uno'),
(11,31,'Flavio Giupponi','Bresciali-Refin'),(12,31,'Alessio Di Basco','Amore Vita'),
(13,28,'Lale Cubino','Seguros Amaya'),
(14,33,'Roberto Pagnin','Navigare'),(15,31,'Jesper Skibby','TVM'),(16,29,'Dimitri Konishev','Jolly Club'),
(17,37,'Bruno Leali','Bresciali-Refin'),(18,37,'Robert Millar','TVM'),(19,34,'Julian Gorospe','Banesto'),
(20,29,'Alfonso Gutierrez','Artiach'),(21,31,'Erwin Nijboer','Artiach'),(22,32,'Giorgio Furlan','Gewiss'),
(23,27,'Lance Armstrong','Motorola'),(24,29,'Claudio Chiappucci','Carrera'),
(25,32,'Gianni Bugno','Gatorade'),
(26,27,'Mikel Zarrabeitia','Banesto'),(27,28,'Laurent Jalabert','ONCE'),(28,33,'Jesus Montoya','Banesto'),
(29,28,'Angel Edo','Kelme'),(30,28,'Melchor Mauri','Banesto'),(31,30,'Vicente Aparicio','Banesto'),
(32,28,'Laurent Dufaux','ONCE'),(33,29,'Stefano della Santa','Mapei-Clas'),
(34,30,'Angel Yesid Camargo','Kelme'),
(35,28,'Erik Dekker','Wordperfect'),(36,32,'Gian Matteo Fagnini','Mercatone Uno'),
(37,29,'Scott Sunderland','TVM'),
(38,25,'Javier Palacin','Euskadi'),(39,30,'Rudy Verdonck','Lotus Festina'),
(40,32,'Viatceslav Ekimov','Wordperfect'),
(41,25,'Rolf Aldag','Telecom'),(42,29,'Davide Cassani','TVM'),
(43,28,'Francesco Casagrande','Mercatone Uno'),
(44,27,'Luca Gelfi','Gatorade'),(45,26,'Alberto Elli','Artiach'),(46,24,'Agustin Sagasti','Euskadi'),
(47,32,'Laurent Pillon','Gewiss'),(48,29,'Marco Saligari','Gewiss'),(49,23,'Eugeni Berzin','Gewiss'),
(50,27,'Fernando Escartin','Mapei-Clas'),(51,30,'Udo Bolts','Telecom'),(52,26,'Vladislav Bobrik','Gewiss'),
(53,28,'Michele Bartoli','Mercatone Uno'),(54,30,'Steffen Wesemann','Telecom'),
(55,28,'Nicola Minali','Gewiss'),
(56,29,'Andrew Hampsten','Banesto'),(57,28,'Stefano Zanini','Navigare'),(58,34,'Gerd Audehm','Telecom'),
(59,28,'Mariano Picolli','Mercatone Uno'),(60,28,'Giovanni Lombardi','Bresciali-Refin'),
(61,26,'Walte Castignola','Navigare'),(62,30,'Raul Alcala','Motorola'),(63,32,'Alvaro Mejia','Motorola'),
(64,28,'Giuseppe Petito','Mercatone Uno'),(65,29,'Pascal Lino','Amore Vita'),
(66,24,'Enrico Zaina','Gewiss'),
(67,28,'Armand de las Cuevas','Castorama'),(68,28,'Angel Citracca','Navigare'),
(69,27,'Eddy Seigneur','Castorama'),(70,29,'Sandro Heulot','Banesto'),
(71,27,'Prudencio Indurain','Banesto'),(72,28,'Stefano Colage','Bresciali-Refin'),
(73,35,'Laurent Fignon','Gatorade'),(74,36,'Claudio Chioccioli','Amore Vita'),
(75,32,'Juan Romero','Seguros Amaya'),(76,34,'Marco Giovannetti','Gatorade'),
(77,33,'Javier Mauleon','Mapei-Clas'),(78,35,'Antonio Esparza','Kelme'),
(79,33,'Johan Bruyneel','ONCE'),(80,37,'Federico Echave','Mapei-Clas'),(81,33,'Piotr Ugrumov','Gewiss'),
(82,30,'Edgar Corredor','Kelme'),(83,32,'Hernan Buenahora','Kelme'),(84,31,'Jon Unzaga','Mapei-Clas'),
(85,30,'Dimitri Abdoujaparov','Carrera'),(86,32,'Juan Martinez Oliver','Kelme'),
(87,32,'Fernando Mota','Artiach'),(88,28,'Angel Camarillo','Mapei-Clas'),
(89,36,'Stefan Roche','Carrera'),(90,27,'Ivan Ivanov','Artiach'),
(91,28,'Nestor Mora','Kelme'),(92,27,'Federico Garcia','Artiach'),(93,29,'Bo Hamburger','TVM'),
(94,30,'Marino Alonso','Banesto'),(95,31,'Manuel Guijarro','Lotus Festina'),
(96,29,'Tom Cordes','Wordperfect'),
(97,28,'Casimiro Moreda','ONCE'),(98,25,'Eleuterio Anguita','Artiach'),
(99,29,'Per Pedersen','Seguros Amaya'),(100,30,'William Palacios','Jolly Club');

drop table if exists etapes;
create table etapes
( numero INT (3) NOT NULL,
  kms INT (3),
  eixida VARCHAR (35),
  arribada VARCHAR (35),
  ciclista INT (4),
  PRIMARY KEY (numero),
 FOREIGN KEY (ciclista) references ciclistes (dorsal)
) engine=innodb;

insert into etapes values
( 1,9,'Valladolid','Valladolid',1), ( 2,180,'Valladolid','Salamanca',36), ( 3,240,'Salamanca','Caceres',12),
 ( 4,230,'Almendralejo','Cordoba',83), ( 5,170,'Cordoba','Granada',27), 
( 6,150,'Granada','Sierra Nevada',52), ( 7,250,'Baza','Alicante',22), ( 8,40,'Benidorm','Benidorm',1), 
( 9,150,'Benidorm','Valencia',35), ( 10,200,'Igualada','Andorra',2), 
( 11,195,'Andorra','Estacion de Cerler',65), ( 12,220,'Benasque','Zaragoza',12),
 ( 13,200,'Zaragoza','Pamplona',93), ( 14,172,'Pamplona','Alto de la Cruz de la Demanda',86),
 ( 15,207,'Santo Domingo de la Calzada','Santander',10), ( 16,160,'Santander','Lagos de Covadonga',5),
 ( 17,140,'Cangas de Onis','Alto del Naranco',4), ( 18,195,'Avila','Avila',8), 
( 19,190,'Avila','Destilerias Dyc',2), ( 20,52,'Segovia','Destilerias Dyc',2), 
( 21,170,'Destilerias Dyc','Madrid',27);

drop table if exists mallots;
create table mallots
( codi VARCHAR (3) NOT NULL,
  tipus VARCHAR (30),
  color VARCHAR (20),
  premi INT(10),
  PRIMARY KEY (codi)
) engine=innodb;

insert into mallots values
('MGE','General','groc',8000000),
('MMO','Muntanya','blanc i roig',2000000),
('MMS','Mes fort','estrelles morades',2000000),
('MMV','Metes volants','roig',2000000),
('MRE','Regularitat','verd',2000000),
('MSE','Sprints especials','rosa',2000000);

drop table if exists ports;
create table ports
(  nom VARCHAR (35) NOT NULL,
   altura INT(4),
   categoria VARCHAR (1),
   pendent REAL(3,2),
   etapa INT (3),
   ciclista INT (4),
   PRIMARY KEY (nom),
  FOREIGN KEY (ciclista) references ciclistes (dorsal),
  FOREIGN KEY (etapa) references etapes (numero)
) engine=innodb;

insert into ports values
('Alto del Naranco',510,'1',6.9,10,30),
('Arcalis',600,'E',6.5,10,4),
('Cerler-Circo de Ampriu',510,'E',5.87,11,9),
('Coll de la Comella',500,'1',8.07,10,2),
('Coll de Ordino',510,'E',5.3,10,7),
('Cruz de la Demanda',510,'E',7,11,20),
('Lagos de Covadonga',600,'E',6.86,16,42),
('Navacerrada',720,'1',7.5,19,2),
('Puerto de Alisas',940,'1',5.8,15,1),
('Puerto de la Morcuera',600,'2',6.5,19,2),
('Puerto de Mijares',820,'1',4.9,18,24),
('Puerto de Navalmoral',980,'2',4.3,18,2),
('Puerto de Pedro Bernardo',590,'1',4.2,18,25),
('Sierra Nevada',910,'E',6,2,26);


drop table if exists portar;
create table portar
( ciclista INT (4),
  etapa INT (3) NOT NULL,
  mallot VARCHAR (3) NOT NULL,
  PRIMARY KEY (etapa,mallot),
  FOREIGN KEY (ciclista) references ciclistes (dorsal),
  FOREIGN KEY (etapa) references etapes (numero),
  FOREIGN KEY (mallot) references mallots (codi)
) engine=innodb;

insert into portar values
 ( 1,2,'MGE'), ( 1,1,'MGE'), ( 1,4,'MGE'), (1,3,'MGE'), ( 1,16,'MGE'), ( 1,17,'MGE'), ( 1,1,'MSE'), 
( 1,18,'MGE'), ( 1,19,'MGE'), ( 1,1,'MRE'), ( 1,1,'MMO'), ( 1,21,'MGE'), ( 1,1,'MMV'), ( 1,20,'MGE'), 
( 2,7,'MGE'), ( 2,6,'MGE'), ( 2,5,'MGE'), ( 2,21,'MMO'), ( 3,12,'MGE'), ( 3,11,'MGE'), ( 4,8,'MGE'), 
( 8,2,'MSE'), ( 8,4,'MSE'), ( 10,18,'MSE'), ( 12,5,'MSE'), ( 12,3,'MSE'), ( 12,6,'MSE'), ( 16,2,'MMV'), 
( 16,6,'MMV'), ( 16,3,'MMV'), ( 16,5,'MMV'), ( 17,4,'MMV'), ( 20,17,'MRE'), ( 20,21,'MRE'), ( 20,19,'MRE'), 
( 20,11,'MRE'), ( 20,8,'MRE'), ( 20,18,'MMV'), ( 20,12,'MRE'), ( 20,9,'MRE'), ( 20,13,'MRE'), ( 20,6,'MRE'), 
( 20,20,'MRE'), ( 20,14,'MRE'), ( 20,10,'MRE'), ( 20,7,'MRE'), ( 20,16,'MRE'), ( 20,15,'MRE'), 
( 22,20,'MSE'), ( 22,16,'MSE'), ( 22,21,'MSE'), ( 22,15,'MSE'), ( 22,19,'MSE'), ( 22,14,'MSE'), 
( 22,17,'MSE'), ( 24,4,'MMO'), ( 25,5,'MMO'), ( 25,3,'MMO'), ( 25,2,'MMO'), ( 26,8,'MMO'),
 ( 26,10,'MGE'), ( 26,18,'MMO'), ( 26,7,'MMO'), ( 26,9,'MMO'), ( 26,9,'MGE'), ( 26,6,'MMO'), ( 27,5,'MRE'),
 ( 27,4,'MRE'), ( 27,3,'MRE'), ( 27,2,'MRE'), ( 27,18,'MRE'), ( 28,15,'MMO'), ( 28,16,'MMO'), ( 28,17,'MMO'),
 ( 28,19,'MMO'), ( 28,20,'MMO'), ( 28,14,'MMO'), ( 30,13,'MGE'), ( 30,15,'MGE'), ( 30,14,'MGE'),
 ( 30,13,'MMO'), ( 30,12,'MMO'), ( 30,11,'MMO'), ( 30,10,'MMO'), ( 33,8,'MMV'), ( 33,7,'MMV'), 
( 42,21,'MMV'), ( 42,20,'MMV'), ( 42,19,'MMV'), ( 42,17,'MMV'), ( 42,16,'MMV'), ( 42,15,'MMV'), 
( 42,14,'MMV'), ( 48,13,'MMV'), ( 48,12,'MMV'), ( 48,9,'MMV'), ( 48,11,'MMV'), ( 48,10,'MMV'), 
( 67,3,'MMS'), ( 67,1,'MMS'), ( 69,2,'MMS'), ( 69,4,'MMS'), ( 99,10,'MSE'), ( 99,8,'MSE'), ( 99,12,'MSE'), 
( 99,7,'MSE'), ( 99,11,'MSE'), ( 99,9,'MSE'), ( 99,13,'MSE');



