import socket
import sys

HOST = '127.0.0.1'  
PORT = 5000

def conexion_cliente():
    try:
        socket_cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        print('Socket cliente creado')
    except socket.error:
        print('Fallo en la creación del socket ciente')
        sys.exit()
    
    socket_cliente.connect((HOST, PORT))    
    
    return socket_cliente

def enviar_a_servidor(conexion, mensaje):
        conexion.sendall(str(mensaje).encode()) #Codificamos el mensaje a bytes y le indicamos que lo envie todo
        #numBytes = s.sendall(mensaje.encode())
        #print (numBytes)
        data = conexion.recv(1024) #línea bloqueante, esperamos que el servidor nos conteste
        print(data.decode())
            
def cerrar_conexion(conexion):
    conexion.close()

# Imprime el menú
def imprimir_menu(): 
    print ("****************** Selecciona una opción ******************\n1. Empezar partida\n2. Imprimir resultados\n\n0. Salir del juego")
    
# Retorna la entrada por teclado verificada
def entrada():
    opc_valida = False
    while not opc_valida:
        try:
            opc = int(input("Introduce opción: "))
            if opc >= 0 and opc < 3:
                opc_valida = True
            else:
                print("Opción no valida")
        except Exception as e:
            print(f"Opción no valida")
            
    return opc
if __name__ == '__main__':
    conexion = conexion_cliente()
    imprimir_menu()
    enviar_a_servidor(conexion, entrada()) 
    cerrar_conexion(conexion)