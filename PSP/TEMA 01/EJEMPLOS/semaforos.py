import threading
import time

# Crear un semaforo con un contador inicial de asientos disponibles
semaforo_sala = threading.Semaphore(5) # Simula 10 asientos disponibles

def persona_entra(numero_persona):
    print(f"Persona {numero_persona} esperando a entrar a la sala.")
    
    # Intentar adquirir un asiento
    semaforo_sala.acquire()
    print(f" Persona {numero_persona} ha entrado en la sala")
    time.sleep(2)
    
    # Liberar el asiento al salir
    semaforo_sala.release()
    print(f"Persona {numero_persona} ha salido de la sala")

hilos_personas = []

# Crear hilos que representan personas que quieren entrar a la sala
for i in range(15):
    hilo_persona = threading.Thread(target=persona_entra, args=(i,))
    hilos_personas.append(hilo_persona)
    hilo_persona.start()
    
# Esperar a que todos los hilos terminen
for hilo_persona in hilos_personas:
    hilo_persona.join()

print("La sala está vacía. Programa principal terminado")