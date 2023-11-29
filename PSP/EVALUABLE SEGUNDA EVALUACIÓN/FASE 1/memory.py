import time
import random
import os

resultados = []

def menu():
    seguir = True
    while seguir:    
        print ("""
****************** Selecciona una opción ******************
1. Empezar partida

0. Salir del juego
""")
        try:
            opc = int(input("Introduce opción: "))
            if opc == 1:
                partida()
            elif opc == 0:
                seguir = False
                print("(Programa terminado)")
        except Exception as e:
            print(f"Ingresa opción valida{e}")
        finally:
            clear()

def partida():
    print("Bienvenido a memory, Intenta encontrar sus parejas")
    
    tablero = barajar_cartas()
    
    print("Primero has de elegir la primera carta")    
    primera_carta = eleccion_carta()
    print("Ahora vamos a por la segunda carta")
    segunda_carta = eleccion_carta()
    
    print(f"La primera carta es un {tablero[primera_carta-1]} y la segunda carta un {tablero[segunda_carta-1]}")
    if tablero[primera_carta-1] == tablero[segunda_carta-1]:
        print("Has encontrado una de las parejas")
    if tablero[primera_carta-1] != tablero[segunda_carta-1]:
        print("Sigue intentandolo")
    
    
    
    
    
def barajar_cartas():
    cartas = ["GATO","GATO","LEON","LEON","ELEFANTE","ELEFANTE"]
    random.shuffle(cartas)
    
    return cartas

def eleccion_carta():
    verificacion = True
    while verificacion:
        try:
            carta_usuario = int(input("Elige del 1 al 6"))
            return carta_usuario
        except Exception as e:
            print("Ingresa opción valida")
            verificacion = False
            
    
            
def clear():    
    time.sleep(1)
    
    if os.name == "nt":
        os.system('cls')
    else: 
        os.system('clear')
            
if __name__ == "__main__":
    menu()
    