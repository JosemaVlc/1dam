import threading
import random

#variables globales
votos_candidato_a = 0
votos_candidato_b = 0

# Lock para sincronizacion
lock = threading.Lock()

# Funcion encargada de realizar una votación aleatoria.
def votacion(votante):
    
    #variables globales
    global votos_candidato_a
    global votos_candidato_b
    
    #variables locales
    voto=""
    
    #genera el aleatorio
    aleatorio = random.randint(0,1)
    
    # Le suma 1 voto a quien corresponda y genera el string de a quien ha ido el voto
    if aleatorio == 0:
        try:
            lock.acquire()
            votos_candidato_a += 1
        except Exception as e:
            print(f"Error al incrementar el contador: {e}")
        finally:
            lock.release()
        voto = "A"
    else:
        try:
            lock.acquire()
            votos_candidato_b += 1
        except Exception as e:
            print(f"Error al incrementar el contador: {e}")
        finally:
            lock.release()
        voto = "B"
        
    # Imprime el string encargado de dar la información del voto
    print(f"Soy el votante {votante+1} y he votado {voto}")

# Main
if __name__ == "__main__":
    
    # variables locales.
    numero_personas = 0
    hilos = []

    # Bucle que genera los 10 hilos que simulan las 10 votaciones.
    for i in range(10):
        numero_personas += 1
        hilo = threading.Thread(target=votacion, args=(i, ))
        hilos.append(hilo)
        hilo.start()
    
    # Bucle para realizar el Join de los hilos creados anteriormente.
    for hilo in hilos:
        hilo.join()

    # Print que esperará a que terminen todos los hilos que hay en el Join.
    print(f"""
Han votado {numero_personas} personas
El total de votos para A es: {votos_candidato_a}
El total de votos para B es: {votos_candidato_b}""")