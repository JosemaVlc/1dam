/* SCRIPT 1: CREAR Y POBLAR LA BASE DE DATOS (2 PUNTOS) \n
Crea el script en javascript necesario para (1º) borrar la base de datos, (2º) crear la base de datos, \n
(3º) crear la colección indicada y (4º) insertar todos los datos, teniendo en cuenta que los campos \n
sin datos no deben aparecer en ese elemento de la colección y el tipo de datos debe ser el más \n
adecuado. Una vez insertados, deberás (5º) listar TODOS los campos de todos los registros, \n
ordenados por apellidos y nombre. */


db = db.getSiblingDB("acadjediMDB");
db.estudiantes.drop();
db.createCollection("estudiantes");

var estudiante01 = {
	_id:"es01", 
	nombre:"Qui-Gon", 
	apellidos:"Jinn", 
	curso:"Curso maestro Jedi",
	asignatura:[
		{
			asignatura:"Telequinesis", 
			maestro:"Yoda", 
			coste:1.25
		},
		{
			asignatura:"Lucha con sable láser", 
			maestro:"Yoda", 
			coste:4.35
		},
		{
			asignatura:"Idiomas", 
			maestro:"Kit Fisto", 
			coste:0.5
		}
	],
	notat:9.5,
	notap:10	
}

var estudiante02 = {
	_id:"es02", 
	nombre:"Obi-Wan", 
	apellidos:"Kenobi",
	curso:"Curso maestro Jedi",
	asignatura:[
		{
			asignatura:"Telequinesis",
			maestro:"Qui-Gon Jinn",
			coste:2
		},
		{
			asignatura:"Lucha con sable láser",
			maestro:"Qui-Gon Jinn",
			coste:5.87
		},
		{
			asignatura:"Idiomas",
			maestro:"Mace Windu",
			coste:0.74
		},
		{
			asignatura:"Control de la fuerza",
			maestro:"Yoda",
			coste:2.33
		}
	],
	notat:9.7,
	notap:9.8
}
	
var estudiante03 = {
	_id:"es03", 
	nombre:"Anakin", 
	apellidos:"Skywalker", 
	curso:"Curso básico padawan nivel 1",
	notat:10,
	notap:10	
}

var estudiante04 = {
	_id:"es04", 
	nombre:"Ahsoka", 
	apellidos:"Tano", 
	curso:"Curso avanzado padawan nivel 2",
	notat:9.75,
	notap:9.95
}

var estudiante05 = {
	_id:"es05", 
	nombre:"Luke", 
	apellidos:"Skywalker",
	curso:"Curso avanzado padawan nivel 2",
	asignatura:[
		{
			asignatura:"Telequinesis",
			maestro:"Yoda",
			coste:1.05
		},
		{
			asignatura:"Lucha con sable láser",
			maestro:"Obi-Wan Kenobi",
			coste:7.76
		}
	], 
	notat:9.5,
	notap:9.85	
}

var estudiante06 = {
	_id:"es06", 
	nombre:"Rey", 
	apellidos:"Skywalker", 
	curso:"Curso básico padawan nivel 1",
	asignatura:[
		{
			asignatura:"Fundamentos Jedi",
			maestro:"Luke Skywalker",
			coste:2.01
		},
		{
			asignatura:"Lucha con sable láser",
			maestro:"Luke Skywalker",
			coste:8.43
		}
	], 
	notat:4
}

var estudiante07 = {
	_id:"es07", 
	nombre:"Baby", 
	apellidos:"Yoda", 
	curso:"Curso básico padawan nivel 1",
	asignatura:[
		{
			asignatura:"Telequinesis",
			maestro:"Luke Skywalker",
			coste:4
		},
		{
			asignatura:"Control con la fuerza",
			maestro:"Luke Skywalker",
			coste:3
		}
	], 
	notat:8.5
}
	
var estudiante08 = {
	_id:"es08", 
	nombre:"Tallisibeth", 
	apellidos:"Enwandung-Esterhazy", 
	curso:"Curso avanzado padawan nivel 2",
	asignatura:[
		{
			asignatura:"Telequinesis",
			maestro:"Kit Fisto",
			coste:1.29
		},
		{
			asignatura:"Lucha con sable láser",
			maestro:"Kit Fisto",
			coste:4.05
		}
	], 
	notat:4.5,
	notap:9.85
}

var estudiante09 = {
	_id:"es09", 
	nombre:"Chirrut", 
	apellidos:"Îmwe", 
	curso:"Curso básico padawan nivel 2",
	asignatura:[
		{
			asignatura:"Adaptación Jedi",
			maestro:"Sta-Den Eekin",
			coste:2.57
		},
		{
			asignatura:"Lucha con palo Kendo",
			maestro:"Sta-Den Eekin",
			coste:9.65
		}
	], 
	notat:3,
	notap:4
}

var estudiante10 = {
	_id:"es10", 
	nombre:"Sta-Den", 
	apellidos:"Eekin", 
	curso:"Curso maestro Jedi",
	notat:9.95,
	notap:10
}

var estudiante11 = {
	_id:"es11", 
	nombre:"Kit", 
	apellidos:"Fisto", 
	curso:"Curso maestro Jedi",
	notat:9.9,
	notap:10
}

db.estudiantes.insertMany([estudiante01, estudiante02, estudiante03, estudiante04, 
	estudiante05, estudiante06, estudiante07, estudiante08, estudiante09, estudiante10, estudiante11]);
	
db.estudiantes.find().sort({ apellidos: 1, nombre: 1}).pretty();

/*SCRIPT 2: ACTUALIZAR LA INFORMACIÓN (2 PUNTOS)
Se requiere incluir un nuevo campo llamado “observaciones” para anotar comentarios sobre cada
alumno.
• Para los alumnos que tienen más de 5 tanto en la nota teórica (notat) como en la práctica
(notap) escribirá en el campo observaciones:
◦ “Aprobado”
• Para los alumnos a los que les falta alguna nota (de las dos notas) escribirá en
observaciones:
◦ “Faltan pruebas por evaluar”
• Para los alumnos con alguna nota suspendida (<5), escribirá en el campo observaciones:
◦ “Prueba/s suspendidas”
Crea el script en javascript necesario para (1º) actualizar el campo “categoria” en cada uno de los
casos indicados y (2º) listar SOLO apellidos, nombre y observaciones de TODOS los documentos
ordenados por apellidos y nombre. */


db.estudiantes.updateMany(
	{$and: [{notat:{$gte:5}}, {notap:{$gte:5}}]},
	{$set:{observaciones:"Aprobado"}}
);