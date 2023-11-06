import threading
import random
import time

def tarea():
    cont = 0
    vocales = "aeiou"
    frase = input("introduce una frase: ")
    for i in frase:
        if i.lower() in vocales:
            cont += 1
    tiempo_espera = random.randint(1, 5)
    time.sleep(tiempo_espera)
    print(f"Tu frase tiene {cont} letras.")

if __name__ == "__main__":
    for i in range(5):
        hilo = threading.Thread(target=tarea)
        hilo.start()
    