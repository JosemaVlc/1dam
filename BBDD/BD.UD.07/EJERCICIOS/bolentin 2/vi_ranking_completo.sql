/*Crea dos funciones prácticamente idénticas a la función del ejercicio 1.1. llamadas
f_ranking_por_coste y f_ranking_por_beneficio que devuelvan, respectivamente, la posición de
ese producto en un listado ordenado por coste y por beneficio, siendo el beneficio la diferencia
entre precio y coste.
Una vez tengas las tres funciones, crea una vista llamada vi_ranking_completo que muestre,
para cada producto, su precio con su ranking, su coste con su ranking y su beneficio con su ranking,
usando la función CONCAT y ordenado por beneficio descendente*/

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

DROP FUNCTION IF EXISTS f_ranking_por_coste;
DELIMITER €€
CREATE FUNCTION f_ranking_por_coste(producto INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE contador INT DEFAULT 0;
    SELECT count(*) INTO contador 
    FROM productos
    WHERE coste > (SELECT coste FROM productos WHERE id = producto);
	RETURN contador+1;
END €€
DELIMITER ;

DROP FUNCTION IF EXISTS f_ranking_por_beneficio;
DELIMITER €€
CREATE FUNCTION f_ranking_por_beneficio(producto INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE contador INT DEFAULT 0;
    SELECT count(*) INTO contador 
    FROM productos
    WHERE precio-coste > (SELECT precio-coste FROM productos WHERE id = producto);
	RETURN contador+1;
END €€
DELIMITER ;

DROP VIEW IF EXISTS vi_ranking_completo;
CREATE VIEW vi_ranking_completo 
AS SELECT id, nombre, concat(precio, ' (ranking: ',f_ranking_por_precio(id),')') as precio, concat(coste,' (ranking: ', f_ranking_por_coste(id),')') as coste, concat(precio-coste,' (ranking: ',f_ranking_por_beneficio(id),')') as beneficio
FROM productos
ORDER BY f_ranking_por_beneficio(id);

SELECT * FROM vi_ranking_completo;