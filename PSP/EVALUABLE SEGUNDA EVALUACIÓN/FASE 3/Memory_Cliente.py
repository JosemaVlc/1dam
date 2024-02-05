import socket
import sys
from Crypto.PublicKey import RSA
from Crypto.Random import get_random_bytes
from Crypto.Cipher import AES, PKCS1_OAEP
from pathlib import Path

HOST = '127.0.0.1'  # IP del servidor
PORT = 5000         # Puerto por el que conectar al servidor

def conexion_cliente():
    '''Funcion para conectar el cliente con el servidor'''
    try:
        socket_cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # Crea socket cliente
        print('Socket cliente creado')
    except socket.error:
        print('Fallo en la creación del socket ciente')
        sys.exit()
    
    socket_cliente.connect((HOST, PORT)) # Conecta a la Ip y el puerto de las variables globales.
    
    # Retorna el socket del cliente
    return socket_cliente

def enviar_a_servidor(conexion, mensaje):
    '''Funcion para enviar información al servidor'''
    mensajeBin = mensaje.encode()           # Pasamos mensaje a binario
    
    session_key = get_random_bytes(16)      # Creamos clave simetrica aleatoria para cifrar mensaje
        
    #Cifrado Simétrico: Encriptar los datos con AES
    cipher_aes= AES.new(session_key, AES.MODE_EAX)
    cipher_text, tag = cipher_aes.encrypt_and_digest(mensajeBin)    # Devuelve el texto cifrado y el Hash del texto (el Hash se guada en tag)    
        
    #Encriptar la Clave Asimétrica con la clave pública del servidor
    cipher_rsa = PKCS1_OAEP.new(recipient_key)                      #creamos un nuevo objeto con el algorismo de cifrado PKCS1_OAEP, pasándole la clave pública RSA
    enc_session_key = cipher_rsa.encrypt(session_key)
    
    conexion.sendall(enc_session_key + cipher_aes.nonce + tag + cipher_text) # Envia la clave Asimetrica cifrada + valor aleatorio nonce de la clave simatrica + hash de la llave simetrica + texto cifrado

def recibir_del_servidor(conexion): 
    '''Funcion para recibir información desde el servidor.'''
    # Bloquea y esperas que el servidor nos conteste
    data = conexion.recv(1024) 
    
    size_key = int(private_key.size_in_bytes())
    
    enc_session_key = data[:size_key]
    nonce = data[size_key:size_key+16]
    tag = data[size_key+16:size_key+32]
    cipherTexto = data[size_key+32:]
    
    # Desencriptar la sesión RSA con la clave privada del usuario
    cipher_rsa = PKCS1_OAEP.new(private_key) #Creamos un nuevo objeto con el algoritmo PKCS1_OAEP y la clave RSA
    session_key = cipher_rsa.decrypt(enc_session_key)
    
    #Desenecriptamos los datos que se habían encriptado con el algoritmo AES
    cipher_aes = AES.new(session_key, AES.MODE_EAX, nonce)
    data = cipher_aes.decrypt_and_verify(cipherTexto,tag) #Compara el Hash que opbtiene con el Hash que le pasamos para verifiar que los datos no se han modificado 
           
    # Retorna la contestacion del servidor
    return data.decode()

def cerrar_conexion(conexion):
    '''Funcion para cerrar la conexion con el servidor'''
    conexion.close()
    
def entrada():
    '''Retorna la entrada por teclado verificada.'''
    opc_valida = False # Variable de verificacion
    
    # Bucle para verificar la selección del usuario
    while not opc_valida:
        try:
            # Pide al jugador que opcion quiere y la almacena a opc
            opc = int(input("Introduce opción: ")) 
            
            # Verifica opc
            if opc >= 0 and opc < 3:        # Si opc es mayor o igual a 0 y menor a 3
                opc_valida = True           # opc_valida pasa True
                
            else:                           # Sinó opc no será valida
                print("Opción no valida")   # Muestra que no es opcion valida.
                
        except Exception as e:
            print(f"Opción no valida")
            
    # Retorna opc listo para enviar al servidor         
    return opc

def eleccion_carta():
    '''Da a elegir la posición de la carta y la retorna verificada.'''
    verificacion = False # Variable de verificación
    
    # Bucle para verificar la selección del usuario
    while not verificacion:
        try:
            # Pide la carta al usuario
            carta_usuario = int(input("Elige la posición de la carta que deseas seleccionar(del 1 al 6): "))
            
            # Verifica carta_usuario
            if carta_usuario > 0 and carta_usuario < 7: # Si carta_usuario es mayor a 0 y menor a 7
                verificacion = True                     # verificacion pasa True
                
            else:                                       # Sinó carta_usuario no será valida
                print("Ingresa posición valida")        # Muestra que la opcion no es valida.
                
        except Exception as e:
            print("Ingresa posición valida")
    
    # Retorna la carta_usuario lista para enviar al servidor        
    return carta_usuario  


def continuar():        
    '''Da a elegir si el usuario quiere continuar la partida y la retorna verificada.'''
    
    verif = False       # Variable de verificación
    
    # Bucle para verificar selección de usuario
    while not verif:    # Mientras no sea correcta no se retornará la variable continuar
        try:
            opc = input("Quieres seguir jugando? S/N: ")    # Pregunta y almacena selección del usuario
            
            # Revisa que ha seleccionado el usuario
            if opc.upper() == "N":          # Si opc es N
                continuar = False           # La variable continuar se inicializa en False
                verif = True                # Y verif pasa a ser True para parar el bucle
                
            elif opc.upper() == "S":        # Si opc es S
                continuar = True            # La variable continuar se inicializa en True
                verif = True                # Y verif pasa a ser True para parar el bucle
                
            else:                           # Si opc no es ninguna de esas dos opciones
                print("Opción no valida")   # Imprime mensaje de opcion no valida
                
        except Exception as e:
            print(f"Opción no valida")
    
    # Retorna si el jugador quiere continuar listo para enviar al servidor.
    return continuar

if __name__ == '__main__':
    
    #Cifrado Asimétrico
    fichero_path = Path(__file__).parent / "publica_servidor.pem"
    recipient_key = RSA.import_key(open(fichero_path).read())       #leemos el fichero con la clave pública
    
    #leemos la clave privada del usuario_A
    fichero_path = Path(__file__).parent / "privada_usuario_A.pem"
    private_key = RSA.import_key(open(fichero_path).read()) 
    
    #leemos la clave publica del usuario_A
    fichero_path = Path(__file__).parent / "privada_usuario_A.pem"
    public_key = RSA.import_key(open(fichero_path, 'rb').read()) 
    
    conexion = conexion_cliente() # Conecta al cliente con el servidor.
    conexion.sendall(public_key.export_key()) # Envia clave publica del usuario al servidor.
    
    menu = True # Variable de control
    
    # Mientras menu sea True seguirá el bucle.
    while menu:
        
        # Recibe e imprime el menú
        print(recibir_del_servidor(conexion))
        
        # Envia la opcion del menú seleccionada
        opc = entrada() 
        enviar_a_servidor(conexion, str(opc)) 
        
        # Si opc es 0, es que el jugador quiere salir
        if opc == 0:            
            # La variable de control pasa a False
            menu = False                         
            # Imprime mensaje de despedida   
            print(recibir_del_servidor(conexion))
        
        # Si opc es 1, es que el jugador quiere jugar partida   
        elif opc == 1:            
            # Recibe las instrucciones
            print(recibir_del_servidor(conexion))
            # Envia recibí
            enviar_a_servidor(conexion, "recibí") 
            
            # Recibe cuando baraja
            print(recibir_del_servidor(conexion))
            # Envia recibí
            enviar_a_servidor(conexion, "recibí") 
            
            seguir_jugando = True
            while seguir_jugando:
                # Recibe pregunta de carta 1,de la ronda
                print(recibir_del_servidor(conexion))
                # Envia seleccion usuario de carta 1, de la ronda 
                enviar_a_servidor(conexion, str(eleccion_carta()))
                # Recibe pregunta de carta 2,de la ronda
                print(recibir_del_servidor(conexion))
                # Envia seleccion usuario de carta 2, de la ronda
                enviar_a_servidor(conexion, str(eleccion_carta()))
                
                # Recibe verificacion de las cartas seleccionadas y mensaje
                select = recibir_del_servidor(conexion).split(";")
                # Envia recibí                
                enviar_a_servidor(conexion, "recibí") 
                
                # Si las posiciones no son seleccionables.
                if select[0] == "False":
                    print(select[1]) # Imprime mensaje
                else:
                    # Recibe la info de la ronda
                    info_ronda= recibir_del_servidor(conexion).split(";")
                    print(info_ronda[0])
                    
                    # Si el jugador acierta pasa a la siguente ronda
                    if info_ronda[2] == "True" and int(info_ronda[1]) < 3:
                        seguir_jugando = "True"
                    else:                        
                        # Recibe parejas encontrada
                        if int(info_ronda[1]) < 3:
                            seguir_jugando = continuar()
                        else:
                            seguir_jugando = False  
                                  
                    enviar_a_servidor(conexion, str(seguir_jugando))
                
            # Recibe info final de partida
            print(recibir_del_servidor(conexion))
            # Envia recibí
            enviar_a_servidor(conexion, "recibí")  
            
        # Si opc es 2, es que el juegador quiere saber los resultados de las partidas de la sesión        
        elif opc == 2:
            # Recibe e imprime los resultados de la sesión
            print(recibir_del_servidor(conexion))   
            # Envia recibí
            enviar_a_servidor(conexion, "recibido") 
            
    # Cierra conexion con el servidor         
    cerrar_conexion(conexion)