# El objetivo de este ejercicio es programar el algoritmo de sustitución César utilizando las
# tablas de código ASCII. El cifrado César es una técnica de sustitución en la que cada
# letra en el texto original es desplazada un número fijo de posiciones hacia la derecha en
# el alfabeto. En este caso, implementaremos el cifrado utilizando las tablas de código ASCII.

# Solicita al usuario que ingrese el mensaje que desea cifrar.
texto = input("Ingrese el mensaje que desea cifrar: ")

# Pide al usuario que ingrese el número de posiciones que desea utilizar para el desplazamiento.
desplazamiento = int(input("Ingrese el número de posiciones que desea utilizar para el desplazamiento: "))

# Implementa el algoritmo de sustitución César utilizando las tablas de código ASCII para cifrar el mensaje.
textoDesplazado = ""

for letra in texto:
    if ord(letra) >= 65 and ord(letra) <= 90:
        indice = ord(letra)
        indiceDesplazado = indice + desplazamiento
        
        # Controla si el desplazamiento se sale de rango.
        if indiceDesplazado > 90:
            indiceDesplazado -= 26
            
        # Almacena la letra desplazada
        textoDesplazado += chr(indiceDesplazado)
    elif ord(letra) >= 97 and ord(letra) <= 122:
        indice = ord(letra)
        indiceDesplazado = indice + desplazamiento
        
        # Controla si el desplazamiento se sale de rango.
        if indiceDesplazado > 122:
            indiceDesplazado -= 26
            
        # Almacena la letra desplazada
        textoDesplazado += chr(indiceDesplazado)        
    else:
        # Almacena la letra inexistente en el alfabeto personalizado
        textoDesplazado += letra
   
# Imprime el mensaje cifrado. 
print(textoDesplazado)