import threading

def tarea_hilo(id):
    #instruccion del hilo
    print(f"Hola desde el hilo {id}!")
    
if __name__=="__main__":
    
    # Crea una instancia de la clase Thread
    mi_hilo1 = threading.Thread(target=tarea_hilo, args=(1,))
    mi_hilo2 = threading.Thread(target=tarea_hilo, args=(2,))
    mi_hilo3 = threading.Thread(target=tarea_hilo, args=(3,))
    mi_hilo4 = threading.Thread(target=tarea_hilo, args=(4,))
    mi_hilo5 = threading.Thread(target=tarea_hilo, args=(5,))
    
    # Inicia la ejecucion del hilo
    mi_hilo1.start()
    mi_hilo2.start()
    mi_hilo3.start()
    mi_hilo4.start()
    mi_hilo5.start()