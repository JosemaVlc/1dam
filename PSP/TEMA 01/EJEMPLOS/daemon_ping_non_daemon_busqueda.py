import threading
import time
import subprocess
from ping3 import ping, verbose_ping

def ping_google():
    while True:
        # Realiza ping a una pagina web
        result = ping("google.com")
        print(f"Ping a google.com {result} ms")

        # Dormir durante un intervalo de tiempo
        time.sleep(5)
        
def abrir_busqueda(thread_id):
    busqueda = input(f'Soy el hilo {thread_id}. Introduce la busqueda: ')
    time.sleep(3)
    try:
        subprocess.run(['C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe',f'https://www.google.es/search?q={busqueda}'])
    except Exception as e:
        print(e)
        
if __name__=="__main__":
    
    # Crear un hilo daemon para el ping
    ping_thread = threading.Thread(target=ping_google, daemon=True)
    
    hilos = []
    
    #Creamos 5 hilos que podian buscar algo en google, como el parametro por defecto es False, no lo indicamos
    for i in range(5):
        hilo_busqueda= threading.Thread(target=abrir_busqueda, args=(i,))
        hilos.append(hilo_busqueda)
        hilo_busqueda.start()
    
    # Iniciar tambien el hilo daemon
    ping_thread.start()
    
    # el programa principal puede continuar realizando otras tareas
    for _ in range(2):
        print("Programa principal realizando otras tareas...")
        time.sleep(4)
    
    # Esperar a que los hilos no daemon terminen
    for hilo in hilos:
        hilo.join()

    # El programa principal a que acaben los hilos no daempon e imprime mensaje final
    print("Programa principal terminado(el hilo de ping daemon continua en segundo plano)")