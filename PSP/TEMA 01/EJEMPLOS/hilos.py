import threading

def tarea_hilo():
    #instruccion del hilo
    print("Hola desde el hilo!")
    
if __name__=="__main__":
    # Crewa una instancia de la clase Thread
    mi_hilo = threading.Thread(target=tarea_hilo)

    # Inicia la ejecucion del hilo
    mi_hilo.start()