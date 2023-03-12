/*Crea un PROCEDIMIENTO llamado p_blackFriday que reciba como parámetro la palabra “ON” o
la palabra “OFF” y actúe de esta manera:
ON: Para todas las consolas marcadas como “disponible” (tabla gaming):
• Hace una copia del campo precio al campo precio_copia
• Aumenta en un 15% el precio y las marca como estado = “en oferta”
• Imprime un listado de las consolas afectadas “en oferta”
OFF: Para todas las consolas marcadas como “en oferta” (tabla gaming):
• Hace una copia del campo precio_copia al campo precio
• Las marca como estado = “disponible”
• Imprime un listado de las todas consolas “disponibles”
Una vez lo tengas, ejecuta el procedimiento con ON y con OFF para ver los resultados.*/

USE bd_productos;

DROP PROCEDURE IF EXISTS p_blackFriday;
DELIMITER ##
CREATE PROCEDURE p_blackFriday(in bf varchar(3))
BEGIN
	if bf = 'OFF' THEN
		Update gaming SET precio=precio_copia, estado='disponible'
        where estado='en oferta';
		SELECT * FROM gaming where estado='disponible';
	elseif bf = 'ON' THEN
        update gaming set precio_copia=precio, estado='en oferta'
        where estado='disponible';
        update gaming set precio = precio * 1.15
        where estado='en oferta';
		SELECT * FROM gaming WHERE estado='en oferta';
	else 
		select 'Booleano erroneo' as ERROR;
	end if;
END##
delimiter ;
        
call p_blackFriday('OFF');
