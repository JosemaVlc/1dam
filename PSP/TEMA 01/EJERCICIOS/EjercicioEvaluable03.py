import threading
import random
import time

lock = threading.Lock()

recaudacion_camiones = 0
recaudacion_turismos = 0

def peaje_camion(lock):
    
    global recaudacion_camiones
    tarifa_camiones = 8
    
    with lock:
        recaudacion_camiones += tarifa_camiones
    
    time.sleep(1)
    
    print("Ha pasado un camión")
          
    
def peaje_turismo(lock, j):
    
    global recaudacion_turismos
    tarifa_turismos = 4
    
    with lock:
        recaudacion_turismos += tarifa_turismos
    
    time.sleep(1)
    threading.current_thread().name = "turismo_"+str(j)
    nombre_hilo = threading.current_thread().name
    
    print(f"Ha pasado el turismo con nombre: {nombre_hilo}")
    
    
# Main
if __name__ == "__main__":
    
    # variables locales.
    hilos = []

    # Bucle que genera los 20 hilos que simulan los 20 vehiculos que van a recorrer la autopista.
    for j in range(20):    
        vehiculo_random = random.randint(0,1)
        if vehiculo_random == 0:
            hilo = threading.Thread(target=peaje_camion, args=(lock,))
        if vehiculo_random == 1:
            hilo = threading.Thread(target=peaje_turismo, args=(lock, j,))            
        hilos.append(hilo)
        hilo.start()
    
    # Espera a que todos los hilos terminen.
    for hilo in hilos:
        hilo.join()
        
    print(f"Durante el dia de hoy se ha recaudado {recaudacion_camiones}€ en paso de camiones y {recaudacion_turismos}€ en paso de turismos. Tenemos una recaudacion total de: {recaudacion_turismos+recaudacion_camiones}€")
    
