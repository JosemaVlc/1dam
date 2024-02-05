import socket
import sys
import threading
import random

# Una vez aceptado el cliente, desde esta función gestionamos la logica del juego.
def cliente(socket_atiende, addr_cliente): 
    with socket_atiende:        
        print(f"Conexión exitosa con el cliente. {addr_cliente}")        
        control_menu(addr_cliente, socket_atiende)                     
        print("Fin de conversación con: ",addr_cliente)
        socket_atiende.close()
        
# Funcion para enviar información al servidor
def enviar_a_cliente(conexion, mensaje):
    conexion.sendall(str(mensaje).encode()) # Envia el mensaje en binario.

# Funcion para recibir información desde el servidor.        
def recibir_del_cliente(conexion):    
    # Bloquea y esperas que el servidor nos conteste
    data = conexion.recv(1024) 
    
    # Retorna la contestacion del servidor
    return data.decode()
        
# Lleva el menu del juego de la parte servidor
def control_menu(addr_cliente, socket_atiende):
    
    resultados = [] # Almacena las partidas de esta conexión
    control = True     # Variable de control
    
    while control:
        
        enviar_a_cliente(socket_atiende, menu()) # Envia al cliente el menú         
        
        opc = recibir_del_cliente(socket_atiende) # Esperando la opcion que elije el usuario en el cliente        
        print(f'El cliente {addr_cliente} ha elegido la opcion: {opc}') # Opción recibida, la imprime en terminal servidor

        if opc == "0":                                                 # Si la opción elegida por el usuario es 0,
            control = False                                                     # Cambia la variable de control a False
            enviar_a_cliente(socket_atiende, "Adios")                           # Envia a cliente mensaje de salida
            print("Usuario decidió dejar de jugar")                             # Imprime mensaje en terminal servidor

        elif opc == "1":                                               # Si la opción elegida por el usuario es 1, 
            instrucciones()                                                     # Envia al cliente las instrucciones             
            tapete = barajar_cartas(socket_atiende)                             # Baraja las cartas y retorna un tapete de juego
            resultado = partida(socket_atiende, addr_cliente, tapete)           # Lleva la partida y devuelve el resultado
            resultados.append(resultado)                                        # Añade resultado al listado de resultados
            
        elif opc == "2":                                               # Si la opción elegida por el usuario es 2,
            enviar_a_cliente(socket_atiende, imprimir_resultados(resultados))   # Envia al cliente los resultados de la sesión
            socket_atiende.recv(1024)                                           # Espera confirmación de recibo

# Retorna el menú al cliente
def menu():     
    return "****************** Selecciona una opción ******************\n1. Empezar partida\n2. Imprimir resultados\n\n0. Salir del juego"
            
# Envia las instrucciones del juego y espera confirmación de recibo
def instrucciones():
    enviar_a_cliente(socket_atiende, "\nBienvenido a memory.\n\nEste juego consiste en emparejar las cartas.\nHay 6 cartas, asi que, al encontrar las 3 parejas habras ganado la partida.\nEn cuantas rondas podras completar el reto?")
    recibir_del_cliente(socket_atiende)
    
# baraja las cartas y devuelve el tapete de juego   
def barajar_cartas(socket_atiende):
    cartas = ["GATO","GATO","LEON","LEON","ELEFANTE","ELEFANTE"]    # Inicializa lista de cartas
    random.shuffle(cartas)                                          # Realiza del random
    enviar_a_cliente(socket_atiende, "Se han barajado las cartas")  # Envia el mensaje de barajado de cartas
    recibir_del_cliente(socket_atiende)                                       # Espera confirmación de recibo
    
    return cartas

# Lleva la partida y retorna el resultado de la partida.
def partida(socket_atiende, addr_cliente, tapete):
    
    rondas = 0                      # Inicializa a 0 el numero de rondas
    parejas_encontradas = 0         # Inicializa a 0 el numero de parejas encontradas
    seguir_jugando = True           # Variable de control del while
    
    # Mientras seguir_jugando sea True y las parejas encontradas sean menor a 3 seguira el juego
    while seguir_jugando and parejas_encontradas < 3:
        
        elecciones_correctas = False # Variable de control de las cartas
        
        # Mientras elecciones_correctas sea False seguira preguntando que cartas quiere escoger el usuario
        while not elecciones_correctas:            
            # Eleccion de primera carta
            enviar_a_cliente(socket_atiende, "\nEs momento de elegir la primera carta") # Envia mensaje al cliente
            primera_carta = int(recibir_del_cliente(socket_atiende))                     # Espera respuesta y almacena en primera_carta
            
            # Imprime mensaje en el servidor para llevar el seguimiento.
            print(f"El jugador {addr_cliente} ha elegido como segunda carta la posición {primera_carta} que es {tapete[primera_carta-1]}")
            
            # Eleccion de segunda_carta    
            enviar_a_cliente(socket_atiende, "Ahora vamos a por la segunda carta")      # Envia mensaje al cliente
            segunda_carta = int(recibir_del_cliente(socket_atiende))                     # Espera respuesta y almacena en segunda_carta
            
            # Imprime mensaje en el servidor para llevar el seguimiento.
            print(f"El jugador {addr_cliente} ha elegido como segunda carta la posición {segunda_carta} que es {tapete[segunda_carta-1]}")
            
            # Verifica que las cartas son elegibles            
            if tapete[primera_carta-1] == "ABIERTA" or tapete[segunda_carta-1] == "ABIERTA":                        # Si primera_carta o segunda carta esta abierta anteriormente:
                enviar_a_cliente(socket_atiende, "False;Vaya, parece que una de esas cartas ya estaba levantada")   # Envia al cliente que es una de las dos no es elegible con False y separado por ; el mensaje a mostrar.
            elif primera_carta == segunda_carta:                                                                    # Si la primera y la segunda carta es la misma:
                enviar_a_cliente(socket_atiende, "False;Tienes que elegir dos cartas diferentes, listillo/a")       # Envia al cliente que no es elegible con el False y separado con ; el mensaje a mostrar.
            else:                                                                                                   # Sinó significara que son elegibles y:
                enviar_a_cliente(socket_atiende, "True;")                                                           # Envia al cliente un True; para llevar el control de envios y recibos de mensajes
                elecciones_correctas = True                                                                         # Pasa a True la variable de control para que termine el bucle
            recibir_del_cliente(socket_atiende)                                                                     # Espera confirmación de recibo del mensaje enviado segun si es o no elegible.
                     
        # Imprime resultado de la ronda  
        info_ronda = f"\nRONDA {rondas+1}:La primera carta es un {tapete[primera_carta-1]} y la segunda carta un {tapete[segunda_carta-1]}\n" # Inicializa variable con el mensaje
        rondas += 1 # Añade uno al numero de rondas jugadas.
        
        # Verifica si las cartas seleccionadas por el jugador son pareja
        if tapete[primera_carta-1] == tapete[segunda_carta-1]:                                  # Si lo son pareja:
            parejas_encontradas += 1                                                            # Suma 1 a parejas_encontradas            
            info_ronda += f"Muy bien, has encontrado {parejas_encontradas} pareja/s de 3\n"     # Añade a la variable info_ronda felicitación y cuantas parejas ha encontrado en la partida
            print(f"El jugador {addr_cliente} acertó")                                          # Imprime en el servidor que acertó para llevar el control de forma visual
            tapete[primera_carta-1] = "ABIERTA"                                                 # Setea ambas cartas a "ABIERTA" para saber que estan ya abiertas.
            tapete[segunda_carta-1] = "ABIERTA"               
            
        elif tapete[primera_carta-1] != tapete[segunda_carta-1]:                                # Si no son pareja:
                                                                                                # Añade a la variable info_ronda mensaje y cuantas parejas lleva en la partida
            info_ronda += f"Vaya, no son pareja! Se vuelven a tapar todas las cartas sin moverlas y empiezas una ronda nueva.\nHas encontrado {parejas_encontradas} pareja/s, recuerda las carta para esta siguiente ronda\n"
            print("El jugador falló")                                                           # Imprime en el servidor que falló para llevar el control de forma visual
            
        info_ronda += f";{str(parejas_encontradas)}"    # Añade a la variable info_ronda ; y parejas_encontradas
        enviar_a_cliente(socket_atiende, info_ronda)    # Envia info_ronda al cliente
        
        # Espera que se le devuelva si el jugador continua jugando
        if recibir_del_cliente(socket_atiende) == "False":        # Si el jugador devuelve que no quiere seguir jugando:
            seguir_jugando = False                               # Cambia la variable seguir_jugando a False para que el bucle pare.
    
    # Verifica si ha encontrado las 3 parejas        
    if parejas_encontradas == 3:                                                                                            # Si ha encontrado 3 parejas:
        info_partida = f"Enhorabuena!!!\nConseguiste las {parejas_encontradas} parejas en tan solo {rondas} rondas!!\n"     # Inicializa la variable con el mensaje de enhorabuena y el numero de parejas y rondas realizadas.
        resultado = f"Ganaste. Conseguiste las {parejas_encontradas} parejas en tan solo {rondas} rondas!!"                 # Inicializa la variable a retornar con que ganó la partida el numero de parejas y rondas realizadas.
        print("El jugador ganó la partida")                                                                                 # Imprime en servidor que el jugador ganó la partida

    else:                                                                                                                   # Si no ha encontrado 3 parejas:
        info_partida = f"Que mala suerte!!!\nTan solo has encontrado {parejas_encontradas} pareja/s en {rondas} ronda/s\n"  # Inicializa la variable con el mensaje de perdida y el numero de parejas encontradas y rondas realizadas.
        resultado = f"Perdiste. Tan solo has encontrado {parejas_encontradas} pareja/s en {rondas} ronda/s"                 # Inicializa la variable a retornar con que perdio la partida el numero de parejas y rondas realizadas.
        print("El jugador perdió la partida")                                                                               # Imprime en servidor que el jugador perdio la partida

    # Envia info_partida al cliente.
    enviar_a_cliente(socket_atiende, info_partida) 
    # Espera confirmación de recibo
    recibir_del_cliente(socket_atiende) 
    
    # Retorna el resultado de la partida.
    return resultado
    
# Retorna el listado de partidas
def imprimir_resultados(resultados):    
    lista_resultados=f"\n****************** Lista de partidas ******************"   # Inicializa variable con la cabecera del listado
    for i, resultado in enumerate(resultados):                                      # Itera indice i de la lista de resultados.
        lista_resultados += f"\nPartida{i+1}: {resultado}"                          # Añade a la variable una nueva linea con cada resultado de dentro de la variable resultados.
    lista_resultados += "\n(Fin de listado)\n"                                      # Añade una nueva linea informando del final del listado.
    
    # Retorna la variable lista para enviar al cliente.
    return lista_resultados
    
if __name__ == '__main__':
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
                                                                
        hilo = threading.Thread(target=cliente, args=(socket_atiende, addr_cliente,)) # Generamos un nuevo hilo con el nuevo socket y la info del cliente
        hilo.start() # Lanzamos el hilo