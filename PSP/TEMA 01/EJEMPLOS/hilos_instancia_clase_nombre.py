import threading
import time

def funcion_hilo():
    nombre_hilo = threading.current_thread().name
    print(f"Soy el hilo con nombre {nombre_hilo}")

if __name__ == "__main__":
    # Crear una lista para almacenar los hilos
    hilos = []
    
    # Crear e iniciar 10 hilos
    for i in range(1,11):
        # Crear hilo
        nuevo_hilo=threading.Thread(target=funcion_hilo)
        
        # Cambio de nombre del hilo
        if i == 4:
            #ponemos un nombre especial al hilo 4
            nuevo_hilo.name = "Hilo cuatro"
        elif i != 6:
            #al resto de hilos excepto al 6 le ponemos el nopmbre del hilo seguido del iterador
            nuevo_hilo.name = "Hilo-"+str(i)
        
        # Almacenar hilo en la lista
        hilos.append(nuevo_hilo)
        
        # Iniciar los hilos
        nuevo_hilo.start()
    