/* BD.Evaluable3.1.DQL.DAM - JOSE MANUEL MORENO BOLIVAR - 52659570N */

/* CONSULTA 1B: CARTESIANO VS JOIN [2 puntos]
Mostrar el nombre completo (concatenando con comas los apellidos y el nombre) y la fecha de grado de los maestros Jedi que fueron antiguos alumnos y han impartido/imparten algún curso, ordenados por fecha de grado de más reciente a más antigua.
Resultado: 12 filas.*/

/* 1B.1) Sin JOIN */

SELECT DISTINCT CONCAT('Maestro: ', m.nombre, ' ', m.apellidos) AS 'Nombre Completo', m.fechagrado AS 'Fecha de grado'
FROM Maestro m, Curso c, Alumno a
WHERE concat(m.nombre, m.apellidos) = concat(a.nombre, a.apellidos) 
AND m.idmaestro = c.idmaestro;

/* 1B.2) Con JOIN */

SELECT DISTINCT CONCAT('Maestro: ', m.nombre, ' ', m.apellidos) AS 'Nombre Completo', m.fechagrado AS 'Fecha de grado'
FROM Maestro m 
JOIN Curso c 
JOIN Alumno a 
ON concat(m.nombre, m.apellidos) = concat(a.nombre, a.apellidos) 
AND m.idmaestro = c.idmaestro;



/* CONSULTA 2B: GROUP BY VS SUBCONSULTAS [2 puntos]
Obtener el concepto y la suma de todos los importes de los costes cuyos conceptos empiezan por 'Alquiler' o ‘Seguro’. Ordena los resultados de mayor a menor coste y alfabéticamente por concepto. 
Resultado: 4 filas. */

/* 2B.1) Con GROUP BY, sin SUBCONSULTA */

SELECT concepto, SUM(importe) AS importeTotal FROM coste
WHERE concepto LIKE 'Alquiler %'
OR concepto LIKE 'Seguro %'
GROUP BY concepto
ORDER BY importeTotal DESC, concepto;

/* 2B.2) Sin GROUP BY, con SUBCONSULTA */

SELECT DISTINCT c.concepto, (	SELECT SUM(importe) 
								FROM coste 
								WHERE concepto = c.concepto) AS importeTotal
FROM coste c
WHERE c.concepto LIKE 'Alquiler %' 
OR c.concepto LIKE 'Seguro %'
ORDER BY importeTotal DESC, c.concepto;



/* CONSULTA 3B: EXISTS VS IN [2 puntos]
Listar los apellidos y el nombre (concatenados por coma) de los alumnos que hayan sido Padawan y Senior, ordenados por orden alfabético inverso, es decir, ambos de la Z a la A.
Resultado: 4 filas. */

/* 3B.1) Sin IN, con EXISTS */

SELECT CONCAT(a.apellidos, ', ', a.nombre) AS alumno 
FROM alumno a
WHERE  EXISTS (	SELECT s.idalumno 
				FROM senior s 	
                WHERE s.idalumno = a.idalumno) 
AND EXISTS (SELECT p.idalumno
			FROM padawan p
			WHERE p.idalumno = a.idalumno)
ORDER BY a.apellidos DESC;

/* 3B.2) Con IN, sin EXISTS */

SELECT CONCAT(a.apellidos, ', ', a.nombre) AS alumno FROM alumno a
WHERE  idalumno IN (SELECT s.idalumno 
					FROM senior s)
AND idalumno IN (	SELECT p.idalumno 
					FROM padawan p)
ORDER BY a.apellidos DESC;



/* CONSULTA 4B: MÁXIMO DE UNA SUMA [2 puntos]
Indicar el nombre de la academia, los conceptos de gastos y el importe total de cada uno en todas las academias Jedi. Ordena los resultados por academia en orden alfabético, por importe de mayor a menor y por concepto. */

/* 4B.1) Muestra todos
Resultado: 26 filas. */

SELECT a.nombre, c.concepto, SUM(c.importe) AS Total
FROM academia a, coste c
WHERE c.codacad = a.codacad
GROUP BY a.nombre, c.concepto
ORDER BY Total;

/* 4B.2) Muestra solo el MÁXIMO COSTE de todos (sin usar LIMIT ni TOP)
Resultado: 1 fila. */

SELECT a.nombre, c.concepto, c.importe
FROM academia a, coste c
WHERE c.codacad = a.codacad
AND c.importe = (	SELECT MAX(c.importe) 
					FROM coste c);



/* CONSULTA 5B: CREAR UNA VISTA Y USARLA [2 puntos]
Crea una vista (Cursos_con_alumnos) para obtener los cursos con alumnos. Del curso nos interesa el nombre y descripción, del alumno su código y de ofertar la fecha de inicio y fecha de fin. Los datos deben ordenarse por nombre y descripción. Una vez creada, realiza una consulta sobre esa vista para obtener solo el nombre, descripción y número de alumnos de los cursos que se hayan ofertado entre el 1/09/2022 y el 30/06/2023 y tengan más de 1 alumno.*/

/* 5B.1) Crea la vista y lista todos sus elementos
Resultado: 9 filas. */

DROP VIEW IF EXISTS Cursos_con_alumnos;

CREATE VIEW 
Cursos_con_alumnos AS 
SELECT c.nombre,  c.descripcion, a.idalumno, o.fechaini, o.fechafin
FROM curso c, ofertar o, alumno a
WHERE a.codcurso = c.codcurso
AND c.codcurso = o.codcurso
AND a.codacad = c.codacad
AND c.codacad = o.codacad
ORDER BY c.nombre, c.descripcion;

/* 5B.2) Crea una consulta sobre esa vista
Resultado: 2 filas. */

SELECT nombre, descripcion, COUNT(*) AS n_alumnos
FROM Cursos_con_alumnos
WHERE fechaini 	BETWEEN '2022-09-01' 
				AND '2023-06-30'
GROUP BY nombre, descripcion
HAVING n_alumnos > 1;