import threading
import time
import random

# Variables Globales
BUF_SIZE = 10
buffer = [None]*BUF_SIZE

# Semáforos
semaforo_productor = threading.Semaphore(BUF_SIZE) # Controla la cantidad máxima dde productos del buffer
semaforo_consumidor = threading.Semaphore(0) # Inicialmente, el buffer esta vacio

# Hilo productor
class Productor(threading.Thread):
    def run(self):
        global BUF_SIZE, buffer
        global semaforo_productor, semaforo_consumidor
        indice_entrada = 0
        for i in range(20):
            time.sleep(random.uniform(0.1, 0.5)) # Simula la produccion de un elemento
            item = f"Item {i+1}" #Producido el elemento i
            semaforo_productor.acquire()
            buffer[indice_entrada] = item
            indice_entrada = (indice_entrada + 1)%BUF_SIZE
            print (f"El productor ha añadido el elemento {item}")
            semaforo_consumidor.release()
            
# Hilo consumidor
class Consumidor(threading.Thread):
    def run(self):
        global BUF_SIZE, buffer
        global semaforo_productor, semaforo_consumidor
        indice_salida = 0
        for i in range(20):
            time.sleep(random.uniform(0.1, 0.5))
            semaforo_consumidor.acquire()
            producto = buffer[indice_salida]
            indice_salida = (indice_salida +1)%BUF_SIZE
            print(f"El consumidor ha sacado el producto {producto}")
            semaforo_productor.release()
            
if __name__== "__main__":
    # Creamos hilos para el productor y el consumidor
    hilo_productor = Productor()
    hilo_consumidor = Consumidor()
    
    # Iniciamos los hilos
    hilo_productor.start()
    hilo_consumidor.start()
    
    # esperamos a que ambos terminen
    hilo_productor.join()
    hilo_consumidor.join()
    
    print("Todas las operaciones han terminado")