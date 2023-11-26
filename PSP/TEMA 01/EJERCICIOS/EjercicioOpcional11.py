#Productor - Consumidor:

#Basándote en el ejercicio de la teoría amplía el programa de esta forma:

#Pon 2 productores:

#Productor 1: Añade frutas (está especializado en fruta)
#Productor 2: Añade verduras
#Tienes 2 consumidores que irás sacando frutas o verduras, no hace falta controlar esto.

#Ve mostrando por pantalla que van haciendo:

#Productor 1 introdujo una fruta (si puedes poner el nombre de una fruta mejor)
#Productor 2 introdujo una verdura (si puedes poner el nombre de una verdura mejor)

#Consumidor 1: Ha sacado de la cesta (pon si es fruta o verdura o el nombre) producto
#Consumidor 2: Ha sacado de la cesta (pon si es fruta o verdura o el nombre) producto

#Si te apetece pensar un extra (sin obligación de nada), podrías al final indicar que se ha llevado cada consumidor (cuantas frutas y cuantas verduras)

import threading
import time
import random

# Variables globales
BUF_SIZE = 10
buffer = [None]*BUF_SIZE
venta_fruta = 0
venta_verdura = 0
lock = threading.Lock()


# Semáforos
semaforo_productor = threading.Semaphore(BUF_SIZE) # Controla la cantidad máxima de productos en el buffer
semaforo_consumidor = threading.Semaphore(0) # Inicialmente, el buffer está vacío

# Hilo productor
class Productor(threading.Thread):
    def __init__(self, producto):
        super().__init__()
        self.producto = producto
        
    def run(self):
        global BUF_SIZE, buffer
        global semaforo_productor, semaforo_consumidor
        
        indice_entrada = 0
        
        for i in range(10):
            producto = self.producto
            time.sleep(random.uniform(0.1, 0.5)) # Simula la producción de un elemento            
            item = f"{producto} {i+1}" #Producido el elemento i
            semaforo_productor.acquire()
            buffer[indice_entrada] = item
            indice_entrada = (indice_entrada +1)%BUF_SIZE
            print(f"El producto ha añadido {item}")
            semaforo_consumidor.release()
    
# Hilo consumidos
class Consumidor(threading.Thread):
    def __init__(self, lock):
        super().__init__()
        self.lock = lock
    def run(self):
        global BUF_SIZE, buffer
        global semaforo_productor, semaforo_consumidor
        global venta_verdura, venta_fruta
                
        indice_salida = 0
        
        for i in range(10):
            time.sleep(random.uniform(0.1, 0.5)) # Simula el tiempo de procesamiento
            semaforo_consumidor.acquire()
            producto = buffer[indice_salida]
            indice_salida = (indice_salida +1)%BUF_SIZE
            print(f"El consumidor ha comprado {producto}")
            if "Verdura" in producto:
                with self.lock:
                    venta_verdura+=1
            else:                
                with self.lock:
                    venta_fruta+=1                    
            semaforo_productor.release()
    
if __name__ == "__main__":
    
    # Creamos hilos para el productor y el consumidor
    hilo_productor1 = Productor("Fruta")
    hilo_productor2 = Productor("Verdura")
    hilo_consumidor1 = Consumidor(lock)    
    hilo_consumidor2 = Consumidor(lock)
    # Iniciamos los hilos
    hilo_productor1.start()
    hilo_consumidor1.start()
    hilo_productor2.start()
    hilo_consumidor2.start()
    
    # Esperamos a que ambos hilos terminen
    hilo_productor1.join()
    hilo_consumidor1.join()
    hilo_productor2.join()
    hilo_consumidor2.join()
    print(f"El dia de hoy vendimos {venta_fruta} frutas y {venta_verdura} verduras")