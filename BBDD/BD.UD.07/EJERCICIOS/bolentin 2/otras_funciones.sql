/*
a. Escribe una función que reciba un número entero de entrada y devuelva TRUE si el número
es par o FALSE en caso contrario.
b. Escribe una función que reciba como parámetro de entrada un valor numérico que
represente un día de la semana y que devuelva una cadena de caracteres con el nombre del
día de la semana correspondiente. Por ejemplo, para el valor de entrada 1 debería devolver
la cadena lunes.
c. Escribe una función que reciba tres números reales como parámetros de entrada y devuelva
el mayor de los tres.
d. Escribe una función que reciba una cadena de entrada y devuelva la misma cadena pero sin
tildes. La función tendrá que reemplazar todas las vocales que tengan acento por la misma
vocal pero sin acento. Por ejemplo, si la función recibe como parámetro de entrada la
cadena María la función debe devolver la cadena Maria.*/

USE bd_productos;

DROP FUNCTION IF EXISTS par_impar;
DELIMITER €€
CREATE FUNCTION par_impar(numero INT)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
	DECLARE Par boolean default false;
	IF mod(numero,2) = 0 then
		set Par=true;
	else
		set Par=false;
	end if;
    return Par;
end €€
delimiter ;


drop function if exists diaSemana;
delimiter €€
create function diaSemana(numero int)
returns varchar(20)
deterministic
begin
	declare dia varchar(20);
	case
		when numero = 1 then set dia = 'lunes';
		when numero = 2 then set dia = 'martes';
		when numero = 3 then set dia = 'miercoles';
		when numero = 4 then set dia = 'jueves';
		when numero = 5 then set dia = 'viernes';
		when numero = 6 then set dia = 'sabado';
		when numero = 7 then set dia = 'domingo';
        else set dia = 'valor erroneo'; 
	end case;
    return dia;
end€€
delimiter ;


drop function if exists maximo;
delimiter €€
create function maximo(n1 int, n2 int, n3 int)
returns varchar(20)
deterministic
begin
	declare max int default 0;
    if (n1 > n2 and n1 > n3) then
		set max = n1;
	elseif (n2 > n1 and n2 > n3) then
		set max = n2;
	elseif (n3 > n1 and n3 > n2) then
		set max = n3;
	end if;
	return max;
end€€
delimiter ;


drop function if exists acentuacion;
delimiter €€
create function acentuacion(frase varchar(255))
returns varchar(255)
deterministic
begin
	Set frase = REPLACE(frase, 'á', 'a');
    Set frase = REPLACE(frase, 'é', 'e');
    Set frase = REPLACE(frase, 'í', 'i');
    Set frase = REPLACE(frase, 'ó', 'o');
    Set frase = REPLACE(frase, 'ú', 'u');
	Set frase = REPLACE(frase, 'Á', 'A');
    Set frase = REPLACE(frase, 'É', 'E');
    Set frase = REPLACE(frase, 'Í', 'I');
    Set frase = REPLACE(frase, 'Ó', 'O');
    Set frase = REPLACE(frase, 'Ú', 'U');    
    return frase;
end €€
delimiter ;

select par_impar(2);
select diaSemana(5);
select maximo(15, 8, 3) as 'Maximo';
select acentuacion('Menuda María estás hecha, áááÁHh') as 'Sin acentuacion';
    
