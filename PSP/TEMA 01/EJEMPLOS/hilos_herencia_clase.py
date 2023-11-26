import threading
import time

class MiHilo(threading.Thread):
    def __init__(self, nombre, contador, intervalo):
        super().__init__(name=nombre)
        self.contador = contador
        self.intervalo = intervalo
        
    def run(self):
        print(f"{self.name} iniciado")
        for i in range(1, self.contador + 1):
            print(f"{self.name}: contador {i}")
            time.sleep(self.intervalo)
        print(f"{self.name} completado")
    
if __name__ == "__main__":
    # Crear instancias de la clase hija (MiHiloMejorado)
    hilo1 = MiHilo(nombre="hilo-1", contador=3, intervalo=1)
    hilo2 = MiHilo(nombre="hilo-2", contador=5, intervalo=0.5)
    
    # Iniciar los hilos
    hilo1.start()
    hilo2.start()
    
    # Esperar a que ambos hilos terminen
    hilo1.join()
    hilo2.join()
    
    print("programa principal terminado")
    
    