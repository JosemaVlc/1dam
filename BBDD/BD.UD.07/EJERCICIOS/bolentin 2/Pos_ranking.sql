/*Sin usar ni la función ni la vista del ejercicio anterior y recurriendo al tipo de variables y de
delimitadores que prefieras, crea un PROCEDIMIENTO (p_ranking_por_precio) que reciba como
parámetro el nombre de un producto e imprima el ranking en la lista de más vendidos.
Si no existe ningún producto con ese nombre o existe más de uno, el procedimiento debe
mostrar sendos mensajes de error como vemos en esta traza:*/

USE bd_productos;

DROP PROCEDURE IF EXISTS p_ranking_por_precio;
DELIMITER €€
CREATE PROCEDURE p_ranking_por_precio(in producto varchar(50))
begin 
	if (select count(nombre) from productos where nombre = producto) > 1 then
		select 'Error, el producto tiene mas de una referencia' as 'Error';
    elseif  (select count(nombre) from productos where nombre = producto) < 1 then
		select 'Error, el producto no tiene referencias' as 'Error';
        /**SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'NO SE ENCUENTRA PRODUCTO';**/
	else
		select producto, count(*)+1 as posicion_por_precio from productos
		where precio > (select precio from productos where nombre = producto);
    end if;
end€€
DELIMITER ;

CALL p_ranking_por_precio('Fress');

