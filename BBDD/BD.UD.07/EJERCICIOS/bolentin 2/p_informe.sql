/*Usando las funciones f_ranking_por_precio, f_ranking_por_coste y f_ranking_por_beneficio
crea un PROCEDIMIENTO llamado p_informe que imprima el nombre y el id de los primeros
productos por precio (mayor), coste (menor) y beneficio (mayor).*/

USE bd_productos;

DROP procedure IF EXISTS p_informe;
DELIMITER €€
CREATE procedure p_informe()
DETERMINISTIC
BEGIN
	select id, nombre as 'Producto de precio maximo', precio from productos order by f_ranking_por_precio(id) limit 1;
    select id, nombre as 'Producto de coste minimo', coste from productos order by f_ranking_por_coste(id) desc limit 1;
    select id, nombre as 'Producto de beneficio maximo', precio-coste from productos order by f_ranking_por_beneficio(id) limit 1;
end€€
DELIMITER ;

call p_informe();