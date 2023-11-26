import threading
import time

# Funcion para simular la preparacion del equipo
def preparar_equipo(equipo_id, barrera_preparacion):
    print(f"Equipo {equipo_id} está preparando el coche")
    time.sleep(3) # Simulamos la preparacion
    barrera_preparacion.wait() # Se espera a que todos los coches estén en la parrilla de salida
    
# Funcion para simular la vuelta de formacion
def vuelta_de_formacion(piloto_id, barrera_formacion):
    print(f"El piloto {piloto_id} está preparado para hacer la vuelta de formación")
    time.sleep(2) # Simulamos la vuelta de formación
    barrera_formacion.wait() # Espera que todos los coches acaben la vuelta de formación
    print(f"El piloto {piloto_id} ha terminado de calentar sus frenos y neumaticos")
    
if __name__=="__main__":
    num_equipos = 5
    
    # Crear barreras para sincronización
    barrera_preparacion = threading.Barrier(num_equipos+1) # 5 equipos + el programa principal esperan la barrera
    barrara_formacion = threading.Barrier(num_equipos) # Conductores de los 4 equipos en la parrilla de salida
    
    # crear e iniciar hilos de quipos y pilotos
    equipos = []
    pilotos = []
    
    # Equipos a preparar los coches
    for i in range(num_equipos):
        hilo = threading.Thread(target=preparar_equipo, args=(i+1, barrera_preparacion,))
        equipos.append(hilo)
        hilo.start()
    
    # El programa principal tambien espera a la barrera
    barrera_preparacion.wait()
    
    print("Los equipos han acabado de preparar los coches")
    
    # Pilotos, podeis dar la vuelta de calentamiento
    for i in range(num_equipos):
        hilo = threading.Thread(target=vuelta_de_formacion, args=(i+1, barrara_formacion))
        pilotos.append(hilo)
        hilo.start()
    
    # Hacemos el join para esperar a que todos los hilos impriman que el piloto ha terminado de calentar
    for hilo in pilotos:
        hilo.join()
        
    print("La carrera ha comenzado")

    