import threading
import time

def daemon_thread():
    while True:
        print("Hilo daemon ejecutandose...")
        time.sleep(1)

def non_daemon_thread():
    for i in range(5):
        print(f"Hilo no daemon ejecutandose ({i+1}/5)")
        time.sleep(2)

# Crear un hilo daemon
daemon_thread = threading.Thread(target=daemon_thread, daemon=True)

# Crear unhilo no daemon
non_daemon_thread = threading.Thread(target=non_daemon_thread, daemon=False)

# iniciar los hilos
daemon_thread.start()
non_daemon_thread.start()

# Esperar a que el hilo no daemon termine antes de salir
non_daemon_thread.join()

print("Fin del programa")