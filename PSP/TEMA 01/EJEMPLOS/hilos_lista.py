import threading

def tarea_hilo(id):
    #instruccion del hilo
    print(f"Hilo {id} ejecutando...")
    
if __name__=="__main__":
    # Lista para almacenar hilos
    hilos = []
    
    # Crea e inicializa varios hilos
    for i in range(10):            
        # Crea una instancia de la clase Thread
        mi_hilo = threading.Thread(target=tarea_hilo, args=(i,))
        # Almacena el hilo en la lista
        hilos.append
        # Inicia la ejecucion del hilo
        mi_hilo.start()
    print("hilo principal")