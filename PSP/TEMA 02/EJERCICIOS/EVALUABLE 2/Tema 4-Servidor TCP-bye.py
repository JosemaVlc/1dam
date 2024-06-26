import socket
import sys
import threading

# Una vez aceptado el cliente, desde esta función gestionamos la recepciones y envios de los datos.
def cliente(socket_atiende, addr_cliente):            
    fin_mensaje = b''

    with socket_atiende:
        #print(f"Conexión exitosa con el cliente. IP ({addr[0]}) Puerto ({addr[1]})")
        print(f"Conexión exitosa con el cliente. {addr_cliente}")
        cerrar = False
        while not cerrar:
            data = socket_atiende.recv(1024) #El servidor queda bloqueado esperando el mensaje que le va a enviar el cliente
            if data==fin_mensaje:
                cerrar = True
            else:
                print(f'El cliente {addr_cliente} nos ha escrito: {data.decode()}') #Mensaje recibido, lo imprimimos
                socket_atiende.sendall(b"mensaje recibido")
        print("Fin de conversación con: ",addr_cliente)
        socket_atiende.close()

if __name__ == '__main__':
    #Decidimos la IP y el puerto del servidor
    HOST = '127.0.0.1'  # La IP del servidor es la loca de la máquina
    PORT = 5000        # El puerto tiene que ser superior a 1024, por debajo estan reservados

    try:
        socket_escucha = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        print('Socket servidor creado')
    except socket.error:
        print('Fallo en la creación del socket servidor')
        sys.exit()
    
    try:
        socket_escucha.bind((HOST, PORT)) # Definimosel punto de enlace del ervidor.
                                          # El servidor está preparado en la IP 127.0.0.1 y puerto 5000
    except socket.error as e:
        print('Error socket: %s' %e)
        sys.exit()
    
    socket_escucha.listen(5) # El servidor puede escuchar hasta 5 clientes.

    while True :
        socket_atiende, addr_cliente = socket_escucha.accept() #El Servidor queda bloquedo en esta línea 
                                                               # esperando a que un cliente se conecte a su IP y puerto
        # Si un cliente se conecta guardamos en socket_atiende el nuevo socket
        # y en addr_cliente la información del cliente (IP y puerto del cliente)
        hilo = threading.Thread(target=cliente, args=(socket_atiende, addr_cliente,))
        hilo.start()