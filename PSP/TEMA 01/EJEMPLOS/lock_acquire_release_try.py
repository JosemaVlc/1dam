import threading
# Variable global que comparten tanto el hilo principal como los hilos secundarios
contador_compartido = 0

# Lock para sincornización
lock = threading.Lock()

def tarea():
    global contador_compartido
    contador = 0
    for _ in range(1000000):
        # Adquirir el bloqueo antes de modificar la variable compartida
        try:
            lock.acquire()
            contador_compartido += 1
        except Exception as e:
            print(f"Error al incrementar el contador: {e}")
        finally:
            # Siempre liberar el bloqueo en el bloque finally
            lock.release()
        # Las variables locales no hace falta protegerlas
        contador += 1
    print(f"Soy el hilo: {threading.current_thread().name}. El valor de mi contador es: {contador}")
    

if __name__ == "__main__":
    hilos = []
    
    for i in range(10):
        # Crear dos  hilos que comparten la variable global
        hilo = threading.Thread(target=tarea)
        hilos.append(hilo)
        hilo.name = "Hilo-"+str(i)
        hilo.start()
    
    for hilo in hilos:
        hilo.join()
    
    print(f"Valor final del contador: {contador_compartido}")
        