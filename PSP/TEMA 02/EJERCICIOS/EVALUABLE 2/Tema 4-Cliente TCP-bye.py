import socket
import sys

HOST = '127.0.0.1'  
PORT = 5000

def programa_cliente():
    try:
        socket_cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        print('Socket cliente creado')
    except socket.error:
        print('Fallo en la creación del socket ciente')
        sys.exit()
    
    socket_cliente.connect((HOST, PORT))
        
    mensaje = 'Conectado con el servidor' # El programa cliente nos pide que escribamos algo
  
    with socket_cliente:
        while mensaje != 'bye':
            socket_cliente.sendall(mensaje.encode()) #Codificamos el mensaje a bytes y le indicamos que lo envie todo
            #numBytes = s.sendall(mensaje.encode())
            #print (numBytes)
            data = socket_cliente.recv(1024) #línea bloqueante, esperamos que el servidor nos conteste
            print('Recibido del servidor:' + data.decode())
            mensaje = input('Escribe tu mensaje (Para finalizar ecribe: bye)--> ')
        socket_cliente.close()


if __name__ == '__main__':
    programa_cliente()