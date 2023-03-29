USE acabjedidb;

/**

SCRIPT 1B: ACADEMIAS Y CURSOS POR COSTES ASOCIADOS (2 PUNTOS)
Crea una función para obtener, dado el código de academia y código de curso, el número de costes
asociados y una segunda función para obtener, también dado un código de academia y código de
curso, los euros totales que ha costado. Usando las dos funciones, lista los 2 cursos que más costes
asociados tienen y otro listado para los 2 cursos que más dinero han costado. 
Se pide:
• Crea la función fNumcostesAcadCurso
• Crea la función fTotalCostesAcadCurso

**/

DROP FUNCTION IF EXISTS fNumcostesAcadCurso;
DELIMITER $$
CREATE FUNCTION fNumcostesAcadCurso(codcurso VARCHAR(10), codacad VARCHAR(10))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE nCostes INT;
	SET nCostes = (SELECT COUNT(*)from coste c WHERE codcurso = c.codcurso AND codacad = c.codacad);
    RETURN nCostes;
END$$
DELIMITER ;

DROP FUNCTION IF EXISTS fTotalCostesAcadCurso;
DELIMITER $$
CREATE FUNCTION fTotalCostesAcadCurso(codcurso VARCHAR(10), codacad VARCHAR(10))
RETURNS FLOAT
DETERMINISTIC
BEGIN
	DECLARE costesTotales INT;
	SET costesTotales = (SELECT SUM(c.importe)FROM coste c WHERE codcurso = c.codcurso AND codacad = c.codacad GROUP BY c.codcurso, c.codacad);
    RETURN costesTotales;
END$$
DELIMITER ;

SELECT distinct codcurso, codacad, fNumcostesAcadCurso(codcurso, codacad) AS Coste_Total FROM coste ORDER BY Coste_Total desc limit 2;
SELECT distinct codcurso, codacad, fTotalCostesAcadCurso(codcurso, codacad) AS Coste_Total FROM coste ORDER BY Coste_Total desc limit 2;

/**
SCRIPT 2B: LISTAR ALUMNOS POR LETRA Y TIPO (2 PUNTOS)
Crea un procedimiento almacenado para obtener el nombre completo y la descripción del curso en
que se encuentran matriculados los alumnos cuyo nombre comienza por la letra pasada como
parámetro (de entrada) y son del tipo pasado como parámetro (de entrada) (P para Padawan y S
para Senior) y devuelve el número de resultados en un tercer parámetro (de salida). Ordena los
resultados por el nombre completo.
Se pide:
• Crea el procedimiento pListarAlumnos_porLetrayTipo
• Muestra un mensaje de error si no se recibe una ‘P’ o una ‘S’ como 2º parámetro.
• Para el nombre completo usa la función CONCAT.
**/

DROP PROCEDURE IF EXISTS pListarAlumnos_porLetrayTipo;
DELIMITER $$
CREATE PROCEDURE pListarAlumnos_porLetrayTipo(
	IN letra CHAR,
	IN tipo CHAR,
    OUT resultados INT)
BEGIN
	CASE 
		WHEN tipo = 'P' THEN
            SELECT COUNT(c.codcurso) INTO resultados from curso c, alumno a, padawan p
            WHERE a.nombre like concat(letra, '%')
            AND a.idalumno = p.idalumno
            AND c.codcurso = a.codcurso
            AND c.codacad = a.codacad;
            
            SELECT c.nombre, c.descripcion from curso c, alumno a, padawan p
            WHERE a.nombre like concat(letra, '%')
            AND a.idalumno = p.idalumno
            AND c.codcurso = a.codcurso
            AND c.codacad = a.codacad
            ORDER BY c.nombre;

        WHEN tipo = 'S' THEN
            SELECT COUNT(c.codcurso) INTO resultados from curso c, alumno a, senior s
            WHERE a.nombre like concat(letra, '%')
            AND a.idalumno = s.idalumno
            AND c.codcurso = a.codcurso
            AND c.codacad = a.codacad;
            
            SELECT c.nombre, c.descripcion from curso c, alumno a, senior s
            WHERE a.nombre like concat(letra, '%')
            AND a.idalumno = s.idalumno
            AND c.codcurso = a.codcurso
            AND c.codacad = a.codacad
            ORDER BY c.nombre;        
        
        ELSE SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tipo erróneo';
	END CASE;
END$$
DELIMITER ;

CALL pListarAlumnos_porLetrayTipo('A','P',@resultados);
SELECT @resultados As 'numero de resultado';

select * from senior;
select * from padawan;
select * from alumno;