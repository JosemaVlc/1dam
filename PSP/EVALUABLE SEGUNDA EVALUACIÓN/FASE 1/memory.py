import random

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

# baraja las cartas    
def barajar_cartas():
    cartas = ["GATO","GATO","LEON","LEON","ELEFANTE","ELEFANTE"]
    random.shuffle(cartas)
    
    print("Se han barajado las cartas!")
    
    return cartas

# Imprime la explicación del juego
def instrucciones():
    print("\nBienvenido a memory.\n\nEste juego consiste en emparejar las cartas.\nHay 6 cartas, así que, al encontrar las 3 parejas habras ganado la partida.\nEn cuantas rondas podras completar el reto?\n")

# Lleva la partida
def partida(tapete):
    
    rondas = 0
    parejas_encontradas = 0
    seguir_jugando = True
    
    while seguir_jugando and parejas_encontradas < 3:
        
        elecciones_correctas = False
        while not elecciones_correctas:            
            # Introduce eleccion de cartas
            print("Es momento de elegir la primera carta")    
            primera_carta = eleccion_carta()
            
            print("Ahora vamos a por la segunda carta")
            segunda_carta = eleccion_carta()
            
            #Verifica que las cartas no esten levantadas
            if tapete[primera_carta-1] == "ABIERTA" and tapete[segunda_carta-1] == "ABIERTA":    
                print(f"Vaya, parece que una de esas cartas ya estaba levantada")
            else:
                elecciones_correctas = True
                
        # Imprime resultado de la ronda  
        rondas += 1      
        print(f"RONDA {rondas}:La primera carta es un {tapete[primera_carta-1]} y la segunda carta un {tapete[segunda_carta-1]}")
        if tapete[primera_carta-1] == tapete[segunda_carta-1]:
            print("Bien, has encontrado una pareja!") 
            
            # Setea ambas cartas a estado "ABIERTA" si son pareja
            tapete[primera_carta-1] = "ABIERTA"
            tapete[segunda_carta-1] = "ABIERTA"    
            
            # Suma 1 pareja a las encontradas
            parejas_encontradas += 1
            
        elif tapete[primera_carta-1] != tapete[segunda_carta-1]:
            print("Vaya, no son pareja!") 
            
        if parejas_encontradas < 3:   
            seguir_jugando = continuar()  
        else:
            seguir_jugando = False
            
    if parejas_encontradas == 3:
        return f"Conseguiste las {parejas_encontradas} parejas en tan solo {rondas} rondas!!"
    else:
        return f"Tan solo has encontrado {parejas_encontradas} pareja/s en {rondas} ronda/s"    
    
# Da a elegir la posición de la carta y la retorna verificada.
def eleccion_carta():
    verificacion = False
    while not verificacion:
        try:
            carta_usuario = int(input("Elige la posición de la carta que deseas seleccionar(del 1 al 6): "))
            if carta_usuario > 0 and carta_usuario < 7:
                verificacion = True
            else:
                print("Ingresa posición valida")
        except Exception as e:
            print("Ingresa posición valida")
            
    return carta_usuario   
    
# Verifica y devuelve si el usuario quiere continuar la partida.
def continuar():        
    verif = False
    while not verif:
        try:
            opc = input("Quieres seguir jugando? S/N: ") 
            if opc.upper() == "N":            
                continuar = False
                verif = True
            elif opc.upper() == "S":
                continuar = True
                verif = True
            else:
                print("Opción no valida")
        except Exception as e:
            print(f"Opción no valida")
    
    return continuar

# Imprimer por pantalla el listado de partidas
def imprimir_resultados(resultados):    
    lista_resultados=f"****************** Lista de partidas ******************"
    for i, resultado in enumerate(resultados):
        lista_resultados += f"\nPartida{i+1}: {resultado}"
    lista_resultados += "\n(Fin de listado)"
    return lista_resultados
            
if __name__ == "__main__":  
    resultados = []
    opc = 1
    
    while opc != 0:  
        imprimir_menu()
        opc = entrada()
        if opc == 1:
            instrucciones()
            tapete = barajar_cartas()
            resultado = partida(tapete)
            resultados.append(resultado)
            print(resultado)
        elif opc == 2:
            print(imprimir_resultados(resultados))
    
    print("(Programa terminado)")