import threading

# variable global que comparten tanto el hilo principal como los hilos secundarios
contador_compartido = 0

class ContadorThread(threading.Thread):
    def __init__(self, lock):
        super().__init__()
        self.lock = lock
        
    def run(self):
        global contador_compartido
        contador = 0
        for _ in range(1000):
            # Adquirir el bloqueo antes de modificar la variable compartida
            with self.lock:
                contador_compartido += 1
            # Las variables locales no hacen falta protegerlas
            contador += 1
        print(f"Soy el hilo: {threading.current_thread().name}. El valor de mi variable local es {contador}")
    
if __name__ == "__main__":
    
    # Lock para sincronizar todos los hilos
    lock = threading.Lock()
    
    hilos = []
    
    for i in range (1, 10):
        # Crear dos hilos que comparten variable
        # a los hilos se le pasa la misma referencia al mismo objeto lock
        hilo = ContadorThread(lock)
        hilos.append(hilo)
        hilo.name = "hilo-"+str(i)
        hilo.start()
        
    for hilo in hilos:
        hilo.join()
    
    print(f"Valor final del contador compartido es {contador_compartido}")