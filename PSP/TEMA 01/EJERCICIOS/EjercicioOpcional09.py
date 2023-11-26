#Dado el código del ejercicio anterior, protege la zona crítica con lock().
#Debes capturar las excepciones con with
#El objeto Lock debe estar en el constructor del la clase Thread.
#Cuando ejecute Thread debe hacer lo que antes hacia la función votación.

import threading
import random

#variables globales
votos_candidato_a = 0
votos_candidato_b = 0
 
# Clase encargada de realizar una votación aleatoria.
class VotacionThread(threading.Thread):    
    def __init__(self, lock):
        super().__init__()
        self.lock = lock
        
    def run(self):
        #variables globales
        global votos_candidato_a
        global votos_candidato_b
    
        #variables locales
        voto=""
        
        #genera el aleatorio
        aleatorio = random.randint(0,1)
    
        # Le suma 1 voto a quien corresponda y genera el string de a quien ha ido el voto
        # Segun el enunciado quieres que capturemos una excepcion con el with, no se si lo he conseguido solamente con los with o tengo que poner un try/except englobando todo el if
        if aleatorio == 0:
            # Si se hace el lock justo antes de la variable global ya queda protegida
            with self.lock:
                votos_candidato_a += 1
            voto = "A"
        else:
            # Si se hace el lock justo antes de la variable global ya queda protegida
            with self.lock:
                votos_candidato_b += 1
            voto = "B"
            
        # Imprime el string encargado de dar la información del voto
        print(f"Soy el votante {int(threading.current_thread().name)+1} y he votado {voto}")

# Main
if __name__ == "__main__":
    
    # Lock para sincronizacion
    lock = threading.Lock()
    
    # variables locales.
    numero_personas = 0
    hilos = []

    # Bucle que genera los 10 hilos que simulan las 10 votaciones.
    for i in range(10):
        numero_personas += 1
        hilo = VotacionThread(lock)
        hilos.append(hilo)
        hilo.name = i
        hilo.start()
    
    # Bucle para realizar el Join de los hilos creados anteriormente.
    for hilo in hilos:
        hilo.join()

    # Print que esperará a que terminen todos los hilos que hay en el Join.
    print(f"""
Han votado {numero_personas} personas
El total de votos para A es: {votos_candidato_a}
El total de votos para B es: {votos_candidato_b}""")