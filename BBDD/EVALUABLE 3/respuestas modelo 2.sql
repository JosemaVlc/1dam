USE acadjedidb;

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
	SET nCostes = (SELECT COUNT(*)
					FROM coste c 
					WHERE codcurso = c.codcurso 
					AND codacad = c.codacad);
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
	SET costesTotales = (SELECT SUM(c.importe)
						FROM coste c 
                        WHERE codcurso = c.codcurso 
                        AND codacad = c.codacad 
                        GROUP BY c.codcurso, c.codacad);
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
            SELECT COUNT(c.codcurso) INTO resultados 
            FROM curso c, alumno a, padawan p
            WHERE a.nombre LIKE CONCAT(letra, '%')
            AND a.idalumno = p.idalumno
            AND c.codcurso = a.codcurso
            AND c.codacad = a.codacad;
            
            SELECT c.nombre, c.descripcion, concat(a.nombre, ' ', a.apellidos) AS alumnos  
            FROM curso c, alumno a, padawan p
            WHERE a.nombre LIKE CONCAT(letra, '%')
            AND a.idalumno = p.idalumno
            AND c.codcurso = a.codcurso
            AND c.codacad = a.codacad
            ORDER BY c.nombre;

        WHEN tipo = 'S' THEN
            SELECT COUNT(c.codcurso) INTO resultados 
            FROM curso c, alumno a, senior s
            WHERE a.nombre LIKE CONCAT(letra, '%')
            AND a.idalumno = s.idalumno
            AND c.codcurso = a.codcurso
            AND c.codacad = a.codacad;
            
            SELECT c.nombre, c.descripcion, CONCAT(a.nombre, ' ', a.apellidos) AS alumnos  
            FROM curso c, alumno a, senior s
            WHERE a.nombre LIKE concat(letra, '%')
            AND a.idalumno = s.idalumno
            AND c.codcurso = a.codcurso
            AND c.codacad = a.codacad
            ORDER BY c.nombre;        
        
        ELSE SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tipo erróneo';
	END CASE;
END$$
DELIMITER ;

CALL pListarAlumnos_porLetrayTipo('A','S',@resultados);
SELECT @resultados AS 'Numero de resultados';

/**
SCRIPT 3B: PÉRDIDA SEMÁNTICA EN ALUMNOS (T+D) (2 PUNTOS)
Al traducir del diseño conceptual al modelo relacional, existía una pérdida semántica en las
especializaciones que no eran Parcial+Solapada (PS), quedándose como una restricción de
integridad que dijimos que “ya resolveríamos más adelante”.
Pues bien, mediante triggers podemos traducir cualquier especialización (TS, TD o PD) y superar así
esa pérdida semántica, aunque no de manera sencilla. Solo las disjuntas tienen una solución con
triggers más o menos sencilla.
Te proponemos crear los triggers necesarios para asegurar la especialización DISJUNTA de los
ALUMNOS en PADAWAN y SENIOR durante las inserciones, ignorando las actualizaciones y los
borrados por su complejidad. (Los datos del script DDL pueden no cumplir estas restricciones, pero
el trigger servirá a partir de ahora)
Se pide:
• Crea el trigger necesario para prevenir inserciones incorrectas en PADAWAN
• Crea el trigger necesario para prevenir inserciones incorrectas en SENIOR
**/

DROP TRIGGER IF EXISTS insercionDisjuntaPadawan;
DELIMITER $$
CREATE TRIGGER insercionDisjuntaPadawan
BEFORE INSERT ON padawan
FOR EACH ROW
BEGIN	
	IF (
		(SELECT s.idalumno 
         FROM senior s 
         WHERE NEW.idalumno = s.idalumno) > 0 )
    THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede insertar un Padawan que tenga una especialización Senior';
	END IF;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS insercionDisjuntaSenior;
DELIMITER $$
CREATE TRIGGER insercionDisjuntaSenior
BEFORE INSERT ON senior
FOR EACH ROW
BEGIN	
	IF (
		(SELECT p.idalumno 
         FROM padawan p 
         WHERE NEW.idalumno = p.idalumno) > 0 )
    THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se puede insertar un Senior que tenga una especialización Padawan';
	END IF;
END$$
DELIMITER ;
    


