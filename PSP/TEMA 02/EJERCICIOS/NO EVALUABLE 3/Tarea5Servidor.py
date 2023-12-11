import socket
import sys
import time

if __name__ == '__main__':
    #Decidimos la IP y el puerto del servidor
    HOST = '127.0.0.1'  # La IP del servidor es la loca de la máquina
    PORT = 4500         # El puerto tiene que ser superior a 1024, por debajo estan reservados

    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        print('Socket servidor creado')
        s.bind((HOST, PORT))    # Definimos el punto de enlace del ervidor.
                                # El servidor está preparado en la IP 127.0.0.1 y puerto 4500
        s.listen()  # Se queda a la escucha
        socket_atiende, addr = s.accept()
        
        mensaje = time.ctime()    
        socket_atiende.sendall(str(mensaje).encode())
        
    except socket.error as e:
        print('Error socket: %s' %e)
        sys.exit()
    finally:
        s.close()
    