from threading import Timer
import time

def tarea_periodica():
    print("Tarea periodica realizada!")
    
# Crea timer que ejecuta la tarea periodica despues de 2 segundos
mi_timer = Timer(2, tarea_periodica)

# inicia timer
mi_timer.start()

# realiza otras operaciones mientra se temporiza la cuenta regresiva
print("Realizando otras operaciones mientras se espera...")

# espera a que el temporizador complete su cuenta regresiva
mi_timer.join()

# crea un timer que ejecutara la tarea periodica despues de 5 segundos
mi_timer_periodico = Timer(5, tarea_periodica)

# inicia el timer
mi_timer_periodico.start()

# Realiza otras operaciones mientra el temporizador periodico esta en ejecucion
for _ in range(3):
    print("Realizando operaciones mientras se espera la proxima ejecucion...")
 
time.sleep(15)    
# Cancela el timer periodico despues de 15 segundos
mi_timer_periodico.cancel()

print("Programa principal terminado")
