from threading import Timer

def tarea_programada():
    print("Tarea programada realizada!")
    
# Crear un Timer con un retraso de 5 segundo y la funcion a ejecutar
mi_timer = Timer(5, tarea_programada)

# Iniciar el Timer
mi_timer.start()

