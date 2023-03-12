/*Realiza un PROCEDIMIENTO llamado p_nota que reciba una nota numérica real (DECIMAL(10,2))
entre 0 y 10 y devuelva si es un suspenso, suficiente, bien, etc. 
Para el cuerpo de programa usa variables de usuario y, para la llamada, prueba con valores y
variables de usuario. Utiliza un CASE WHEN y ## como delimitador.*/

USE bd_productos;

DROP PROCEDURE IF EXISTS p_nota;
DELIMITER ##
CREATE PROCEDURE p_nota(in nota DECIMAL(10,2))
BEGIN
	CASE
		WHEN nota < 5 then select 'Suspenso' as 'nota';
        WHEN nota < 6 then select 'Suficiente' as 'nota';
        WHEN nota < 7 then select 'Bien' as 'nota';
		WHEN nota < 9 then select 'Notable' as 'nota';
        WHEN nota <= 10 then select 'Sobresaliente' as 'nota';
		ELSE select 'Valor erroneo' as 'Error';
	END CASE;
END##
DELIMITER ;

CALL p_nota(10)
