import threading

# Variable global que comparten tanto el hilo principal como los hilos secundarios
contador_compartido = 0

def tarea():
    global contador_compartido
    contador = 0
    for _ in range(1000000):
        contador_compartido += 1
        contador += 1
    print(f"soy el hilo: {threading.current_thread().name}. El valor de mi contador es:{contador}")

if __name__ == "__main__":
    
    hilos = []
    
    for i in range(500):
        # Crear dos hilos que comparten la variable global
        hilo = threading.Thread(target=tarea)
        hilos.append(hilo)
        hilo.name = "Hilo-"+str(i+1)
        hilo.start()
    
    for hilo in hilos:
        hilo.join()
    
    print(f"Valor final del contador compartido: {contador_compartido}")

