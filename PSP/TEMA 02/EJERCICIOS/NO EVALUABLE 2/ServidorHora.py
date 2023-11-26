import socket
import struct
import time

def get_ntp_time(socket,ntp_server,ntp_port):
    """ Función que dado un socket comunica con servidor NTP para recibir la hora actual."""
    
    # Preparar el mensaje NTP (protocolo SNTP) que se enviará al servidor
    ntp_request = b'\x1b' + 47 * b'\0'

    try:
        # El cliente enviá un mensaje de solicitud al servidor NTP
        socket.sendto(ntp_request, (ntp_server, ntp_port))

        # El cliente recibe la respuesta del servidor
        ntp_response, server_address = socket.recvfrom(1024)

    except socket.error as e:
        print(f"Error al conectar al servidor NTP: {e}")
        return None
    finally:
        # El cliente cierra el socket (el servidor progablemente ya
        # ha cerrado su parte de la comunicación)
        client_socket.close()

    # Gestionamos la respuesta del servidor
    unpacked_response = struct.unpack('!12I', ntp_response)
    ntp_seconds = unpacked_response[10] - 2208988800  # Epoch time (1900-1970)

    # Convertir a formato imprimible
    tiempo_servidor = time.strftime('%Y-%m-%d %H:%M:%S', time.gmtime(ntp_seconds))

    return tiempo_servidor

if __name__ == "__main__":
    # Obtener y mostrar la hora del servidor NTP    
    
    try:
        # Servidor NTP de google
        host = 'time.google.com'
        
        # Coger la ip a la que vamos a conectarnos
        ntp_server = socket.gethostbyname(host)
        ntp_port = 123
        
        print("IP de %s: %s" %(host,ntp_server))        

        # Crear el socket del cliente
        try:
            client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

        except socket.error as e:
            print(f"Error al crear el socket UDP: {e}")

        ntp_hora = get_ntp_time(client_socket, ntp_server,ntp_port)

        if ntp_hora:
            print(f"Hora del servidor NTP: {ntp_hora}")
        else:
            print("No se pudo obtener la hora del servidor NTP.")
        
    except socket.error as e:
        print("%s: %s" %(host, e))
