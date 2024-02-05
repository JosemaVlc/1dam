# Obtención de código con algoritmo de sustitución Cesar utilizando un
# alfabeto personalizado que incluye letras mayúsculas, el espacio en blanco y dígitos del
# 0 al 9. Este cifrado simple desplaza cada carácter del mensaje original un número fijo de
# posiciones hacia la derecha en el alfabeto personalizado.

# Alfabeto Personalizado: ' ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789'
alfabeto = ' ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789'

# Solicita al usuario que ingrese el mensaje que desea cifrar.
texto = input("Introduce un texto a cifrar: ")

# Pide al usuario que ingrese el número de posiciones que desea utilizar para el desplazamiento.
desplazamiento = int(input("Introduce numero de posiciones de desplazamiento: "))


textoDesplazado = ""

# Algoritmo de sustitución César utilizando el alfabeto personalizado proporcionado para cifrar el mensaje.
for letra in texto:
    if letra.upper() in alfabeto:
        indice = alfabeto.index(letra.upper())
        indiceDesplazado = indice + desplazamiento   
             
        # Controla si el desplazamiento se sale de rango.
        if indiceDesplazado > len(alfabeto)-1:
            indiceDesplazado = indiceDesplazado - len(alfabeto)
                        
        # Almacena la letra desplazada
        textoDesplazado += alfabeto[indiceDesplazado]        
    else:
        # Almacena la letra inexistente en el alfabeto personalizado
        textoDesplazado += letra
   
# Imprime el mensaje cifrado. 
print(textoDesplazado)
        