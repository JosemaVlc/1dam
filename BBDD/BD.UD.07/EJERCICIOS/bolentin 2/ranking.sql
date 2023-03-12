/*
Usando el tipo de variables y de delimitadores que prefieras, crea una FUNCIÓN
(f_ranking_por_precio) que cuente el número de productos que hay más caros que el
proporcionado y crea una vista llamada vi_ranking que use esa función para devolver este resultado
de manera ordenada por ese mismo ranking:
*/

USE bd_productos;
DROP FUNCTION IF EXISTS f_ranking_por_precio;
DELIMITER €€
CREATE FUNCTION f_ranking_por_precio(producto INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE contador INT DEFAULT 0;
    SELECT count(*) INTO contador 
    FROM productos
    WHERE precio > (SELECT precio FROM productos WHERE id = producto);
	RETURN contador+1;
END €€
DELIMITER ;

DROP VIEW IF EXISTS vi_ranking;
CREATE VIEW vi_ranking 

AS SELECT id, nombre, precio, f_ranking_por_precio(id) AS ranking
FROM productos
ORDER BY Precio DESC;

SELECT * FROM vi_ranking;