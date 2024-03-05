from Crypto.PublicKey import RSA
from Crypto.Random import get_random_bytes
from Crypto.Cipher import AES, PKCS1_OAEP
from pathlib import Path
import socket
import sys
import threading
import random

def cliente(socket_atiende, addr_cliente): 
    '''Una vez aceptado el cliente, desde esta función gestionamos la logica del juego.'''    
    
    with socket_atiende:        
        print(f"Conexión exitosa con el cliente. {addr_cliente}")        
         
        #leemos la clave publica del cliente
        fichero_path = Path(__file__).parent / "publica_usuario_A.pem"
        recipient_key = RSA.import_key(open(fichero_path).read()) 
        
        control_menu(addr_cliente, socket_atiende, recipient_key)                     
        print("Fin de conversación con: ",addr_cliente)        
    socket_atiende.close()
    
def enviar_a_cliente(conexion, recipient_key, mensaje):
    '''Funcion para enviar información al servidor'''    
    mensajeBin = mensaje.encode()           # Pasamos mensaje a binario
    
    session_key = get_random_bytes(16)      # Creamos clave simetrica aleatoria para cifrar mensaje
        
    #Cifrado Simétrico: Encriptar los datos con AES
    cipher_aes= AES.new(session_key, AES.MODE_EAX)
    cipher_text, tag = cipher_aes.encrypt_and_digest(mensajeBin)    # Devuelve el texto cifrado y el Hash del texto (el Hash se guada en tag)
        
    #Encriptar la Clave Asimétrica con la clave pública del usuario
    cipher_rsa = PKCS1_OAEP.new(recipient_key)                      #creamos un nuevo objeto con el algorismo de cifrado PKCS1_OAEP, pasándole la clave pública RSA
    enc_session_key = cipher_rsa.encrypt(session_key)
    
    conexion.sendall(enc_session_key + cipher_aes.nonce + tag + cipher_text) # Envia la clave Asimetrica cifrada + valor aleatorio nonce de la clave simatrica + hash de la llave simetrica + texto cifrado

def recibir_del_cliente(conexion):   
    '''Funcion para recibir información desde el servidor.'''
    # Bloquea y esperas que el servidor nos conteste
    data = conexion.recv(1024) 
        
    size_key = int(private_key.size_in_bytes())
    
    enc_session_key = data[:size_key]
    nonce = data[size_key:size_key+16]
    tag = data[size_key+16:size_key+32]
    cipherTexto = data[size_key+32:]

    # Desencriptar la sesión RSA con la clave privada del servidor
    cipher_rsa = PKCS1_OAEP.new(private_key) #Creamos un nuevo objeto con el algoritmo PKCS1_OAEP y la clave RSA
    session_key = cipher_rsa.decrypt(enc_session_key)
    
    #Desenecriptamos los datos que se habían encriptado con el algoritmo AES
    cipher_aes = AES.new(session_key, AES.MODE_EAX, nonce)
    data = cipher_aes.decrypt_and_verify(cipherTexto,tag) #Compara el Hash que opbtiene con el Hash que le pasamos para verifiar que los datos no se han modificado 
           
    # Retorna la contestacion del servidor
    return data.decode()
        
def control_menu(addr_cliente, socket_atiende, recipient_key):
    '''Lleva el menu del juego de la parte servidor'''    
    resultados = [] # Almacena las partidas de esta conexión
    control = True     # Variable de control
    
    while control:
        
        enviar_a_cliente(socket_atiende, recipient_key, menu()) # Envia al cliente el menú         
        
        opc = recibir_del_cliente(socket_atiende) # Esperando la opcion que elije el usuario en el cliente        
        print(f'El cliente {addr_cliente} ha elegido la opcion: {opc}') # Opción recibida, la imprime en terminal servidor

        if opc == "0":                                                 # Si la opción elegida por el usuario es 0,
            control = False                                                     # Cambia la variable de control a False
            enviar_a_cliente(socket_atiende, recipient_key, "Adios")                           # Envia a cliente mensaje de salida
            print("Usuario decidió dejar de jugar")                             # Imprime mensaje en terminal servidor

        elif opc == "1":                                               # Si la opción elegida por el usuario es 1, 
            instrucciones(socket_atiende, recipient_key)                                                     # Envia al cliente las instrucciones             
            tapete = barajar_cartas(socket_atiende, recipient_key)                             # Baraja las cartas y retorna un tapete de juego
            resultado = partida(socket_atiende, recipient_key, addr_cliente, tapete)           # Lleva la partida y devuelve el resultado
            resultados.append(resultado)                                        # Añade resultado al listado de resultados
            
        elif opc == "2":                                               # Si la opción elegida por el usuario es 2,
            enviar_a_cliente(socket_atiende, recipient_key, imprimir_resultados(resultados))   # Envia al cliente los resultados de la sesión
            recibir_del_cliente(socket_atiende)                                           # Espera confirmación de recibo

def menu():     
    '''Retorna el menú al cliente'''
    return "****************** Selecciona una opción ******************\n1. Empezar partida\n2. Imprimir resultados\n\n0. Salir del juego"
            
def instrucciones(socket_atiende, recipient_key):
    '''Envia las instrucciones del juego y espera confirmación de recibo'''
    enviar_a_cliente(socket_atiende, recipient_key, "\nBienvenido a memory.\n\nEste juego consiste en emparejar las cartas.\nHay 6 cartas, asi que, al encontrar las 3 parejas habras ganado la partida.\nEn cuantas rondas podras completar el reto?")
    recibir_del_cliente(socket_atiende)
    
# baraja las cartas y devuelve el tapete de juego   
def barajar_cartas(socket_atiende, recipient_key):
    cartas = ["GATO","GATO","LEON","LEON","ELEFANTE","ELEFANTE"]                    # Inicializa lista de cartas
    random.shuffle(cartas)                                                          # Realiza del random
    enviar_a_cliente(socket_atiende, recipient_key, "Se han barajado las cartas")   # Envia el mensaje de barajado de cartas
    recibir_del_cliente(socket_atiende)                                             # Espera confirmación de recibo
    
    return cartas

def unicode_animal(carta_tapete):
    '''Devuelve el animal en unicode'''
    
    animal=""
    if carta_tapete == "LEON":
        animal = "\U0001F981"
    elif carta_tapete == "GATO":
        animal = "\U0001F431"
    elif carta_tapete == "ELEFANTE":
        animal = "\U0001F418"
        
    return animal
    

def partida(socket_atiende, recipient_key, addr_cliente, tapete):
    '''Lleva la partida y retorna el resultado de la partida.'''
    
    rondas = 0                              # Inicializa a 0 el numero de rondas
    parejas_encontradas = 0                 # Inicializa a 0 el numero de parejas encontradas
    seguir_jugando = True                   # Variable de control del while
    tablero = ["\U0001f3b4","\U0001f3b4","\U0001f3b4","\U0001f3b4","\U0001f3b4","\U0001f3b4"]  # Inicializamos el tablero que ve el jugador
    
    # Mientras seguir_jugando sea True y las parejas encontradas sean menor a 3 seguira el juego
    while seguir_jugando and parejas_encontradas < 3:
        
        elecciones_correctas = False # Variable de control de las cartas
        
        # Mientras elecciones_correctas sea False seguira preguntando que cartas quiere escoger el usuario
        while not elecciones_correctas:            
            # Eleccion de primera carta
            enviar_a_cliente(socket_atiende, recipient_key, "\nEs momento de elegir la primera carta") # Envia mensaje al cliente
            primera_carta = int(recibir_del_cliente(socket_atiende))                     # Espera respuesta y almacena en primera_carta
            
            # Imprime mensaje en el servidor para llevar el seguimiento.
            print(f"El jugador {addr_cliente} ha elegido como segunda carta la posición {primera_carta} que es {tapete[primera_carta-1]}")
            
            # Eleccion de segunda_carta    
            enviar_a_cliente(socket_atiende, recipient_key, "Ahora vamos a por la segunda carta")      # Envia mensaje al cliente
            segunda_carta = int(recibir_del_cliente(socket_atiende))                     # Espera respuesta y almacena en segunda_carta
            
            # Imprime mensaje en el servidor para llevar el seguimiento.
            print(f"El jugador {addr_cliente} ha elegido como segunda carta la posición {segunda_carta} que es {tapete[segunda_carta-1]}")
            
            # Verifica que las cartas son elegibles            
            if tapete[primera_carta-1] == "ABIERTA" or tapete[segunda_carta-1] == "ABIERTA":                        # Si primera_carta o segunda carta esta abierta anteriormente:
                enviar_a_cliente(socket_atiende, recipient_key, "False;Vaya, parece que una de esas cartas ya estaba levantada")   # Envia al cliente que es una de las dos no es elegible con False y separado por ; el mensaje a mostrar.
            elif primera_carta == segunda_carta:                                                                    # Si la primera y la segunda carta es la misma:
                enviar_a_cliente(socket_atiende, recipient_key, "False;Tienes que elegir dos cartas diferentes, listillo/a")       # Envia al cliente que no es elegible con el False y separado con ; el mensaje a mostrar.
            else:                                                                                                   # Sinó significara que son elegibles y:
                enviar_a_cliente(socket_atiende, recipient_key, "True;")                                                           # Envia al cliente un True; para llevar el control de envios y recibos de mensajes
                elecciones_correctas = True                                                                         # Pasa a True la variable de control para que termine el bucle
            recibir_del_cliente(socket_atiende)                                                                     # Espera confirmación de recibo del mensaje enviado segun si es o no elegible.
                     
        # Imprime resultado de la ronda  
        info_ronda = f"\nRONDA {rondas+1}:La primera carta es un {tapete[primera_carta-1]} y la segunda carta un {tapete[segunda_carta-1]}\n" # Inicializa variable con el mensaje
        rondas += 1 # Añade uno al numero de rondas jugadas.
        
        #verificador_de_ronda
        win = False
        
        # Verifica si las cartas seleccionadas por el jugador son pareja
        if tapete[primera_carta-1] == tapete[segunda_carta-1]:                                  # Si son pareja:
            parejas_encontradas += 1                                                            # Suma 1 a parejas_encontradas            
            info_ronda += f"Muy bien, has encontrado {parejas_encontradas} pareja/s de 3\n"     # Añade a la variable info_ronda felicitación y cuantas parejas ha encontrado en la partida
            print(f"El jugador {addr_cliente} acertó")                                          # Imprime en el servidor que acertó para llevar el control de forma visual
            tablero[primera_carta-1] = unicode_animal(tapete[primera_carta-1])                  # Se setean las posiciones del tapete al tablero para que pueda verlo el usuario
            tablero[segunda_carta-1] = unicode_animal(tapete[segunda_carta-1])                                 
            tapete[primera_carta-1] = "ABIERTA"                                                 # Setea ambas cartas a "ABIERTA" para saber que estan ya abiertas.
            tapete[segunda_carta-1] = "ABIERTA"
            win = True
            
        elif tapete[primera_carta-1] != tapete[segunda_carta-1]:                                # Si no son pareja:
                                                                                                # Añade a la variable info_ronda mensaje y cuantas parejas lleva en la partida
            info_ronda += f"Vaya, no son pareja! Se vuelven a tapar todas las cartas sin moverlas y empiezas una ronda nueva.\nHas encontrado {parejas_encontradas} pareja/s, recuerda las carta para esta siguiente ronda\n"
            print("El jugador falló")                                                           # Imprime en el servidor que falló para llevar el control de forma visual
        
        info_ronda += f"\nEl tablero queda de la siguiente manera:\n{tablero};{str(parejas_encontradas)};{str(win)}"    # Añade a la variable info_ronda el tablero, ; y parejas_encontradas
            
        enviar_a_cliente(socket_atiende, recipient_key, info_ronda)    # Envia info_ronda al cliente        
        
        # Espera que se le devuelva si el jugador continua jugando
        if recibir_del_cliente(socket_atiende) == "False":       # Si el jugador devuelve que no quiere seguir jugando:
            seguir_jugando = False                               # Cambia la variable seguir_jugando a False para que el bucle pare.
    
    # Verifica si ha encontrado las 3 parejas        
    if parejas_encontradas == 3:                                                                                            # Si ha encontrado 3 parejas:
        info_partida = f"Enhorabuena!!!\nConseguiste las {parejas_encontradas} parejas en tan solo {rondas} rondas!!\n"     # Inicializa la variable con el mensaje de enhorabuena y el numero de parejas y rondas realizadas.
        resultado = f"Ganaste. Conseguiste las {parejas_encontradas} parejas en tan solo {rondas} rondas!!"                 # Inicializa la variable a retornar con que ganó la partida el numero de parejas y rondas realizadas.
        print("El jugador ganó la partida")                                                                                 # Imprime en servidor que el jugador ganó la partida

    else:                                                                                                                   # Si no ha encontrado 3 parejas:
        info_partida = f"Abandonaste!!!\nTan solo has encontrado {parejas_encontradas} pareja/s en {rondas} ronda/s\n"      # Inicializa la variable con el mensaje de perdida y el numero de parejas encontradas y rondas realizadas.
        resultado = f"Abandonate. Tan solo has encontrado {parejas_encontradas} pareja/s en {rondas} ronda/s"               # Inicializa la variable a retornar con que perdio la partida el numero de parejas y rondas realizadas.
        print("El jugador abandonó la partida")                                                                             # Imprime en servidor que el jugador perdio la partida

    # Envia info_partida al cliente.
    enviar_a_cliente(socket_atiende, recipient_key, info_partida) 
    # Espera confirmación de recibo
    recibir_del_cliente(socket_atiende) 
    
    # Retorna el resultado de la partida.
    return resultado
    
def imprimir_resultados(resultados):    
    '''Retorna el listado de partidas'''
    lista_resultados=f"\n****************** Lista de partidas ******************"   # Inicializa variable con la cabecera del listado
    for i, resultado in enumerate(resultados):                                      # Itera indice i de la lista de resultados.
        lista_resultados += f"\nPartida{i+1}: {resultado}"                          # Añade a la variable una nueva linea con cada resultado de dentro de la variable resultados.
    lista_resultados += "\n(Fin de listado)\n"                                      # Añade una nueva linea informando del final del listado.
    
    # Retorna la variable lista para enviar al cliente.
    return lista_resultados
    
if __name__ == '__main__':
    
    #leemos la clave privada del servidor
    fichero_path = Path(__file__).parent / "privada_servidor.pem"
    private_key = RSA.import_key(open(fichero_path).read())
    
    # IP y el puerto del servidor
    HOST = '127.0.0.1'  # La IP del servidor
    PORT = 5000         # El puerto superior a 1024

    try:
        socket_escucha = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
        print('Socket servidor creado')
    except socket.error:
        print('Fallo en la creación del socket servidor')
        sys.exit()
    
    try:
        socket_escucha.bind((HOST, PORT)) # Definimos el punto de enlace del ervidor.
                                          # El servidor está preparado en la IP 127.0.0.1 y puerto 5000
    except socket.error as e:
        print('Error socket: %s' %e)
        sys.exit()
    
    socket_escucha.listen(5) # El servidor puede escuchar hasta 5 clientes.

    while True :
        socket_atiende, addr_cliente = socket_escucha.accept()  # El Servidor queda bloquedo en esta línea 
                                                                # esperando a que un cliente se conecte a su IP y puerto
                                                                # Si un cliente se conecta guardamos en socket_atiende el nuevo socket
                                                                # y en addr_cliente la información del cliente (IP y puerto del cliente)
                                                                
        hilo = threading.Thread(target=cliente, args=(socket_atiende, addr_cliente)) # Generamos un nuevo hilo con el nuevo socket y la info del cliente
        hilo.start() # Lanzamos el hilo