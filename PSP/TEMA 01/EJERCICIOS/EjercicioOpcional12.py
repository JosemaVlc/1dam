#Barreras:
#Vamos a simular el proceso de ensamblaje de un coche en una fábrica.
#Tenemos 4 trabajadores que tienen que coordinarse en 2 puntos de la fabricación, para juntar las piezas que han ido haciendo y montar así al final un coche.

#Primera parte:
#Los 4 hilos trabajan en la pieza, pon un random de tiempo. No todas las piezas tardan lo mismo. Indica si el trabajador se ha puesto a hacer la pieza.
#Una vez tienen las piezas imprime el mensaje: 1a fase hecha

#Segunda parte:
#Luego los 4 hilos necesitan trabajar por su cuenta: Indica en los hilos. "Soy el trabajador x (con un número) y estoy haciendo un trabajo de ensamblaje"

#Final:
#Cuando acaben los 4 hilos imprime un mensaje: "Se ha juntado la 1a fase con el trabajo de ensamblaje y ya tenemos el coche listo"
#Ten cuidado cuándo imprimes los mensajes (en qué lugar lo pones: antes o después de la barrara).

import threading
import time
import random

def fabricar_pieza(pieza_id, barrera_fabricacion):
    tiempo_fabricacion = random.randrange(1,5)
    print(f"El trabajador se ha puesto a fabricar la pieza{pieza_id}")
    time.sleep(tiempo_fabricacion)
    barrera_fabricacion.wait() #Espera que todas las piezas estén fabricadas
    
def ensamblar_pieza(trabajador_id, barrera_ensamblaje):
    tiempo_ensamblaje = random.randrange(1,5)
    print(f"Soy el trabajador {trabajador_id} y estoy haciendo un trabajo de ensamblaje")
    time.sleep(tiempo_ensamblaje)
    barrera_ensamblaje.wait() #espera que todas las piezas se ensamblen

if __name__ == "__main__":
    
    numero_piezas = 4
    
    # Crear barreras para sincronización
    barrera_fabricacion = threading.Barrier(numero_piezas+1)
    barrera_ensamblaje = threading.Barrier(numero_piezas)
    
    # Crear e iniciar hilos de piezas y trabajadores
    pieza = []
    trabajador =[]
    
    for i in range(numero_piezas):
        hilo = threading.Thread(target=fabricar_pieza, args= (i+1, barrera_fabricacion))
        pieza.append(hilo)
        hilo.start()
        
    # El programa principal tambien espera en la barrera
    barrera_fabricacion.wait()
    
    print("primera fase hecha!")
        
    for i in range(numero_piezas):
        hilo = threading.Thread(target=ensamblar_pieza, args=(i+1, barrera_ensamblaje))
        trabajador.append(hilo)
        hilo.start()
    
    # Hacemos el join() para esperar a que todos impriman el print que hay despues de la barrera
    for hilo in trabajador:
        hilo.join()
    
    print("Se ha juntado la 1a fase con el trabajo de ensamblaje y ya tenemos el coche listo")