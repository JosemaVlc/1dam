use campanariosdb;

db.campanariosdb.drop();

use campanarios;



db.createCollection("Campanero");

var campanero01 = {
	Dni: "11111111A",
	Nombre: "Manolo",
	Apellidos: "El del bombo",
	Fecha_nac: 1962-12-03,
	Repiques: [
		{
			Campana: "MICALET",
			Fecha_ult: 2023-05-14
		},
		{
			Campana: "CATERINA",
			Fecha_ult: 2023-03-19
		}]
}

var campanero02 = {
	Dni: "22222222B",
	Nombre: "Paco",
	Apellidos: "Besteiro",
	Fecha_nac: 1971-07-17,
	Repiques: [
		{
			Campana: "XACOBEO"
		},
		{
			Campana: "OBRADOIRO"
		}]
}


db.campanariosdb.insertMany([campanero01, campanero02])
db.campanariosdb.find().sort({ Nombre: 1, Apellidos: 1 })