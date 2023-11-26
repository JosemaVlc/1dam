import threading


def tarea_animal(nombre, patas, vuela):
    vuelo = "vuela" if vuela else "no vuela"
    informacion = f"{nombre} es un animal con {patas} patas y {vuelo}."
    print(informacion)
    
# Crear e iniciar hilos para diferentes animales con patas y si vuelan o no
hilo_perro = threading.Thread(target=tarea_animal, args=("Perro", 4, False))
hilo_pajaro = threading.Thread(target=tarea_animal, args=("Pajaro", 2, True))
hilo_araña = threading.Thread(target=tarea_animal, args=("Araña", 8, False))

# Inicia los hilos
hilo_perro.start()
hilo_pajaro.start()
hilo_araña.start()