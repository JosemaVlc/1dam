import threading
import time

def tarea_animal(nombre, patas, vuela):
       vuelo = "vuela" if vuela else "no vuela"
       informacion = f"{nombre} es un animal con {patas} patas y {vuelo}."
       print(informacion)

animales = ["Perro","Pájaro","Araña"]
patas = [4,2,8]
vuela = [False,True,False]

#lista con el metodo zip
lista = list(zip(animales, patas, vuela))

for i in range(len(lista)):
    # Crear e iniciar hilos para diferentes animales con patas y si vuelan
    hilo = threading.Thread(target=tarea_animal, args=lista[i])
    # Iniciar hilo
    hilo.start()
