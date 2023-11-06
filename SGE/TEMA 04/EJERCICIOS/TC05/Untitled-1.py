#!/E:\ASIGNATURAS\SGE\EjercicioClase
# -*- coding: utf-8 -*-
series = {}

numero_series = int(input("Ingresar numeros de series")) 
print(numero_series)

for _ in range(numero_series):
    serie = input()
    
    datos_serie = serie.split(',')
    
    codigo = datos_serie[0]
    
    datos =  tuple(int(dato) for dato in datos_serie[1:])
        
    series[codigo] = datos   