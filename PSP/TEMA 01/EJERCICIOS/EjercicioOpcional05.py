import threading

# La función dividirá el número que les llegue por el argumento entre 5 e imprimirá info”
def dividir(numero):
    resultado = numero / 5
    nombre = threading.current_thread().name
    id = threading.current_thread().ident
    print(f"Soy el thread con nombre {nombre}. Mi identificador es: {id} y el resultado del número dividido es: {resultado}")

# A los threads de la función multiplicar se les cambiará el nombre: HiloMulti[n]. Multiplicarán el número por 5 e imprimirán info
def multiplicar(numero, repeticiones):
    resultado = numero * 5
    threading.current_thread().name = "HiloMulti"+str(repeticiones)
    nombre = threading.current_thread().name
    id = threading.current_thread().ident
    print(f"Soy el thread {nombre}. Mi identificador es: {id} y el resultado de la multiplicacion es: {resultado}")

numero = int(input("Introduce un numero: "))

for i in range(10):
    # Los 5 primeros hilos son divisiones
    if i < 5:
        hilo = threading.Thread(target=dividir, args=(numero, ))
        hilo.start()
    # Los restantes hasta 10 son multiplicaciones, se pasa i+1 para posteriormente poner el numero de hilo al nombre
    else:
        hilo = threading.Thread(target=multiplicar, args=(numero, i+1, ))
        hilo.start()
