import threading
import random
import time

cubiculo_de_estudio = threading.Semaphore(10)

def biblioteca(j):
    threading.current_thread().name = "Estudiante_"+str(j)
    nombre_hilo = threading.current_thread().name
    print(f"{nombre_hilo} pide la entrada a un cubículo de estudio")
    
    #bucle para que los que se queden esperando siguan probando a entrar al cubiculo despues de 5 segundos
    while True:
        #Tiempo en el que el estudiante estará en el cubiculo       
        tiempo = random.randrange(1,10)
        
        if cubiculo_de_estudio.acquire(blocking=False):   
            #estudiante entra en el cubiculo         
            print(f"{nombre_hilo} usa un cubiculo para estudiar")
            time.sleep(tiempo)    

            #estudiante sale del cubiculo
            print(f"{nombre_hilo} ha estado en el cubiculo {tiempo} tiempos de estudio y se va")
            cubiculo_de_estudio.release() 
            break
        else: 
            #Si no hay libre ningun cubiculo imprime el mensaje y espera 5 segundos para volver a probar
            print(f"{nombre_hilo} tiene que esperar")
            time.sleep(5) 
# Main
if __name__ == "__main__":
    
    # variables locales.
    hilos_estudiantes = []

    # Bucle que genera los 20 hilos que simulan los 20 estudiantes que entran en la biblioteca.
    for j in range(20):    
        hilo_estudiante = threading.Thread(target=biblioteca, args=(j,))          
        hilos_estudiantes.append(hilo_estudiante)
        hilo_estudiante.start()
    
    # Espera a que todos los hilos terminen.    
    for hilo_estudiante in hilos_estudiantes:
        hilo_estudiante.join()

    print("La sala de estudios cierra por hoy. Hasta mañana.")