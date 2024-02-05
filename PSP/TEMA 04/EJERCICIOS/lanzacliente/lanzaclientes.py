import socket
import sys
import threading
from pathlib import Path
from random import randint

HOST = '127.0.0.1'  # IP del servidor
PORT = 5000         # Puerto por el que conectar al servidor

def conexion_ciudad(city):
    '''Funcion para conectar el cliente con el servidor'''
    try:
        socket_cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # Crea socket cliente
        print('Socket cliente creado')
    except socket.error:
        print('Fallo en la creación del socket ciente')
        sys.exit()
    
    socket_cliente.connect((HOST, PORT)) # Conecta a la Ip y el puerto de las variables globales.
    
    socket_cliente.sendall(city.encode())
    
    response = socket_cliente.recv(1024)
    print(response.decode())
    
    socket_cliente.close()

def conexion_lista(palabra_clave):
    '''Funcion para conectar el cliente con el servidor'''
    try:
        socket_cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # Crea socket cliente
        print('Socket cliente creado')
    except socket.error:
        print('Fallo en la creación del socket ciente')
        sys.exit()
    
    socket_cliente.connect((HOST, PORT)) # Conecta a la Ip y el puerto de las variables globales.
    
    socket_cliente.sendall(palabra_clave.encode())
    
    response = socket_cliente.recv(1024)
    print(response.decode())
    
    socket_cliente.close()

if __name__ == '__main__':
    
    hilos = []
    cities = ["Paterna","Valencia","Burjassot","Alfafar","Sagunto","Godella","Rocafort"]
    palabra_clave = "lista" 
      
    
    # Bucle que genera los 3 hilos.
    for i in range(3):
        city = cities[randint(0,len(cities)-1)]
        hilo = threading.Thread(target=conexion_ciudad, args=(city,))
        hilos.append(hilo)
        hilo.name = f"ciudad_{i}"
        hilo.start()       
         
    # Bucle que genera los 4 hilos.
    for i in range(4):
        hilo = threading.Thread(target=conexion_lista, args=(palabra_clave,))
        hilos.append(hilo)
        hilo.name = f"lista_{i}"
        hilo.start()
        
    # Bucle para realizar el Join de los hilos creados anteriormente.
    for hilo in hilos:
        hilo.join()
        