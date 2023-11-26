import threading
import time
import random

semaforo_muelles = threading.Semaphore(10)
lock = threading.Lock()

# Simula un camion
def camion():
    global productos, productos_metidos_almacen, RelojAlmacen
    nombre_camion = threading.Thread().name
    # cantidad de material que deja en el almacen
    random_cantidad = random.randrange(1, 10)
    semaforo_muelles.acquire()
    while True:
        if productos > 80:
            time.sleep(0.2)
            RelojAlmacen -= 10
        else:    
            with lock:
                productos += random_cantidad
                productos_metidos_almacen += random_cantidad
            semaforo_muelles.release()        
            break
    print(f"El camión con nombre {nombre_camion}, ha metido {random_cantidad} productos")

def operario():
    global cajas_movidas_almacen, productos
    nombre_operario = threading.Thread().name
    jornada = 240
    cajas_movidas_operario = 0
    while jornada > 0:
        if productos > 3:
            # Si hay mas de 3 productos, se lleva 3 a la tienda
            with lock:
                productos -= 3
            random_sleep = random.uniform(0.3, 0.7)
            time.sleep(random_sleep)
            cajas_movidas_operario += 3
            jornada -= 10*random_sleep
            print(f"El operario {nombre_operario} ha movido 3 cajas")
        else: 
            time.sleep(0.2)
            jornada -= 5
            print(f"El operario con PID: {nombre_operario} está esperando")
                   
    cajas_movidas_almacen += cajas_movidas_operario
    print(f"El operario {nombre_operario} ha movido {cajas_movidas_operario} cajas en su jornada laboral")

if __name__ == "__main__":
    cajas_movidas_almacen = 0
    productos_metidos_almacen = 0
    productos = 20
    
    operarios = []
    camiones = []
    
    # Recrea los 6 operarios entrando a trabajar
    for i in range(6):
        hilo_operario = threading.Thread(target=operario)
        hilo_operario.name = "Operario-"+str(i)
        operarios.append(hilo_operario)
        hilo_operario.start()
        
    RelojAlmacen = 240
    Cantidad_camiones = 30
    
    while RelojAlmacen > 0:
        tiempo_gestion = random.uniform(0.1, 0.3)
        time.sleep(tiempo_gestion)
        RelojAlmacen -= 20*tiempo_gestion
        if len(camiones)<=30:
            hilo_camion = threading.Thread(target=camion)
            hilo_camion.name = "Camion-"+str(i)
            camiones.append(hilo_camion)
            hilo_camion.start()
            
    for operario in operarios:
        operario.join()
        
    for camion in camiones:
        camion.join()
        
        
        
    print(f"En el almacen hay un total de {productos} productos.")
    print(f"Los operarios han sacado {cajas_movidas_almacen} productos.")
    print(f"Los camiones han metido {productos_metidos_almacen} productos.")