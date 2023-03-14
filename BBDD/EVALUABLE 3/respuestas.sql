/* EJERCICIO 1B1 */

SELECT DISTINCT CONCAT('Maestro: ', m.nombre, ' ', m.apellidos) AS 'Nombre Completo', m.fechagrado AS 'Fecha de grado'
FROM Maestro m, Curso c, Alumno a
WHERE concat(m.nombre, m.apellidos) = concat(a.nombre, a.apellidos) 
AND m.idmaestro = c.idmaestro;

/* EJERCICIO BB2 */

SELECT DISTINCT CONCAT('Maestro: ', m.nombre, ' ', m.apellidos) AS 'Nombre Completo', m.fechagrado AS 'Fecha de grado'
FROM Maestro m JOIN Curso c JOIN Alumno a 
ON concat(m.nombre, m.apellidos) = concat(a.nombre, a.apellidos) 
AND m.idmaestro = c.idmaestro;

/* EJERCICIO 2B1 */

SELECT concepto, SUM(importe) as importeTotal FROM coste
WHERE concepto like 'Alquiler %'
OR concepto like 'Seguro %'
GROUP BY concepto
ORDER BY importeTotal DESC, concepto;

/* EJERCICIO 2B2 */

SELECT c.concepto, (select SUM(importe) from coste where c.concepto = concepto) as importeTotal 
FROM (select distinct concepto from coste WHERE concepto like 'Alquiler %' OR concepto like 'Seguro %') as c
ORDER BY importeTotal DESC, concepto;

/* EJERCICIO 3B1 */

SELECT CONCAT(a.apellidos, ', ', a.nombre) AS alumno FROM alumno a
WHERE  EXISTS (	SELECT s.idalumno 
				FROM senior s 	
                WHERE s.idalumno = a.idalumno AND EXISTS (SELECT p.idalumno
								FROM padawan p
								WHERE p.idalumno = a.idalumno))
ORDER BY a.apellidos DESC;

/* EJERCICIO 3B2 */

SELECT CONCAT(a.apellidos, ', ', a.nombre) AS alumno FROM alumno a
WHERE  idalumno IN (	SELECT s.idalumno 
				FROM senior s 	
                WHERE idalumno IN (SELECT p.idalumno
								FROM padawan p))
ORDER BY a.apellidos DESC;

/* EJERCICIO 4B1 */

SELECT a.nombre, c.concepto, SUM(c.importe) as Total
FROM academia a, coste c
WHERE c.codacad = a.codacad
GROUP BY a.nombre, c.concepto
ORDER BY Total;

/* EJERCICIO 4B2 */

SELECT a.nombre, c.concepto, c.importe
FROM academia a, coste c
WHERE c.codacad = a.codacad AND c.importe >= ALL(select importe from coste);

/* EJERCICIO 5B1 */

DROP VIEW IF EXISTS todo;

CREATE VIEW 
Cursos_con_alumnos AS 
SELECT  c.nombre, c.descripcion, a.idalumno, o.fechaini, o.fechafin
FROM curso c, alumno a, ofertar o
WHERE  o.codcurso = a.codcurso 
and o.codcurso = c.codcurso 
and c.codcurso in (select distinct c.codcurso from curso c, alumno a where c.codcurso = a.codcurso)
ORDER BY c.nombre, c.descripcion;

SELECT nombre, descripcion, idalumno
FROM Cursos_con_alumnos
WHERE fechaini between 2022-09-01 and 2023-06-30;

select * from Cursos_con_alumnos;


SELECT distinct c.codcurso
FROM curso c;

