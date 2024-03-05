import socket
import sys
import threading
import time
#import weather

from urllib import request
import json

from random import randint
import API_OpenaAI_copy

def hilo_servidor(socket,addr_cliente):
    time.sleep(randint(5,15))
    
    with socket:
        print(f"conexión exitosa con el cliente. {addr_cliente}")
        data = socket.recv(1024).decode()
        
        if data == 'lista':
            base_url = "https://jsonplaceholder.typicode.com/users"
                    
            response = request.urlopen(base_url)
            http_body = response.read().decode('utf-8')

            #print (http_body)

            #codificar la respuesta a json
            data = json.loads(http_body)
            #print (data)
            username = ""
            for user_data in data:
                username += user_data['username'] + "\n"
            
            socket.sendall(username.encode())
            print(f"Mensaje Users enviado a cliente. {addr_cliente}")
            socket.close()
            print(f"Cliente desconectado {addr_cliente}")               
        else:                                
            municipio, temperatura, velocidad_viento, cielos, cod = API_OpenaAI_copy.openweathermap(data)
            
            if cod == 200:
                response = API_OpenaAI_copy.openai(municipio, temperatura, velocidad_viento, cielos)
                
            socket.sendall(response.encode())
            print(f"Mensaje OpenIA enviado a cliente. {addr_cliente}")
            socket.close()
            print(f"Cliente desconectado {addr_cliente}")             

if __name__ == '__main__':
    HOST = '127.0.0.1'  # IP del servidor
    PORT = 5000         # Puerto por el que conectar al servidor
    
    
    '''Funcion para conectar el cliente con el servidor'''
    try:
        socket_escucha = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # Crea socket cliente
        print('Socket servidor creado')
    except socket.error:
        print('Fallo en la creación del socket servidor')
        sys.exit()
        
    try:
        socket_escucha.bind((HOST, PORT))
    except socket.error as e:
        print('Error socket: %s' %e)
        sys.exit()
    
    socket_escucha.listen(100)
    
    while True:
        socket_atiende, addr_cliente = socket_escucha.accept()        
        hilo_atiende_cliente = threading.Thread(target=hilo_servidor, args=(socket_atiende,addr_cliente))
        hilo_atiende_cliente.start()