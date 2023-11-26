from threading import Timer

def tarea_con_argumentos(nombre, edad):
    print(f"Hola, soy {nombre} y tengo {edad} años")

if __name__ == "__main__":
    # Crea Timer con retraso de 3 segundo y envia argumentos
    mi_timer_args = Timer(3, tarea_con_argumentos,args=("Juan", 25,))
    
    # Inicia Timer
    mi_timer_args.start()
    
    # es posible cancelar timer antes de que se ejecute
    # mi_timer_args.cancel()