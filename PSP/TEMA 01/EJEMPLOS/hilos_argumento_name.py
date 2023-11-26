import threading
import time

def funcion_hilo(color):
    nombre_hilo = threading.current_thread().name
    print(f"Soy el hilo con nombre {nombre_hilo}. Mi color preferido es el: {color}.")
    time.sleep(2)
    print(f"Hilo {nombre_hilo} completado.")

# Crear e inicializar hilos con nombres personalizados
hilo1 = threading.Thread(target=funcion_hilo, args=("azul",))
hilo2 = threading.Thread(target=funcion_hilo, args=("rojo",), name="Hilo-B")
hilo3 = threading.Thread(target=funcion_hilo, args=("verde",), name="Hilo-C")

# Iniciar lo hilos
hilo1.start()
hilo2.start()
hilo3.start()
