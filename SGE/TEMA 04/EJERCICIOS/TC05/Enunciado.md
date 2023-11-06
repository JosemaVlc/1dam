## Ejercicio TC05 (Python parte 1)

Se dispone de una colección de datos con varias series de números, de tal manera que:

* primero se indica el número de series
* el primer número de cada serie es un código alfanumerico (máx 10 caracteres)
* el resto es una cantidad indeterminada de números enteros

Un ejemplo de fichero sería:

```
2
A2345,45,6,7,6,4,5,7,4,3,32,57,3,4,7,4,3,67,6,36,2,18,74
A2441,48,6,23,98,43
```

El programa calcula y muestra estadísticas relacionadas con los números en las series, incluyendo la cantidad de números divisibles por 3 y la cantidad de números divisibles por 5.

Para ello solicita al usuario el código que identifica la serie y en caso de que exista muestre en pantalla una tabla del estilo

Se busca obtener una tabla del estilo

```
   Código   |   N3   |   N5     
------------------------------
 A2345      |     12 |      8  

Serie 3
[45, 6, 6, 3, 3, 3, 6, 36, 18]

Serie 5
[45]


TOTALES
-----------------------------

Serie 3
[45, 6, 6, 3, 3, 3, 6, 36, 18, 48,6]

Serie 5
[5]
```

Donde:
   * N3 es el número de cantidades para ese código que son divisible por 3
   * N5 es el número de cantidades para ese código que son divisible por 5

   * Serie 3 es la lista de números divisibles por 3 de ese código
   * Serie 5 es la lista de números divisibles por 5 de ese código

   * Totales. Serie 3 es la lista de números divisibles por 3 de todos los códigos
   * Totales. Serie 5 es la lista de números divisibles por 5 de todos los códigos
   

  

> Nota: 
> * Los datos deben almacenarse en memoria para poder ser modificado posteriormente en caso de que sea necesario
> * El programa debe mostrar un mensaje de error si se ingresa un código que no existe en las series procesadas.
> * Las estadísticas deben mostrarse alineadas correctamente, como se muestra en el ejemplo (cabecera centrada, codigo alienado a la izquierda, números a las derecha).
> * El programa continuará solcitando códigos hasta que se introduzca "fin" (sin comillas) 