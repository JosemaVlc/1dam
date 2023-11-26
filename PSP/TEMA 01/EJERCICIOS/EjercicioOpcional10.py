#Semáforos:

#Crea un programa que controla la entrada a una frutería.
#Dentro de la frutería sólo caben 4 personas.
#Crea 10 threads que quieren comprar fruta.

#Muestra por pantalla los mensajes a medida que entran las personas:
#– Está esperando la persona (pon el número)
#– Está atendida a la persona (pon el número)
#– Sale de la frutería la persona (pon el número)

import threading
import time

tendero = threading.Semaphore(4)

class FruteriaThread(threading.Thread):
    def __init__(self):
        super().__init__()
    
    def run(self):      
        # variable con el numero de hilo  
        nombre_hilo = int(threading.current_thread().name)+1
        
        # si queda el valor de tendero es 0 muestra el mensaje de espera
        if tendero._value == 0:
            print(f"Está esperando la persona {nombre_hilo}")
            
        # utiliza semaforo para los clientes
        if tendero.acquire():
            print(f"Estan atendiendo a la persona {nombre_hilo}")
            time.sleep(2)    
            # desbloquea al tendero
            tendero.release()
        print(f"Sale de la frutería la persona {nombre_hilo}")
    
# Main
if __name__ == "__main__":
    
    # variables locales.
    numero_personas = 0
    hilos = []

    # Bucle que genera los 10 hilos que simulan las 10 votaciones.
    for i in range(10):
        numero_personas += 1
        hilo = FruteriaThread()
        hilos.append(hilo)
        hilo.name = i
        hilo.start()
    
    # Bucle para realizar el Join de los hilos creados anteriormente.
    for hilo in hilos:
        hilo.join()