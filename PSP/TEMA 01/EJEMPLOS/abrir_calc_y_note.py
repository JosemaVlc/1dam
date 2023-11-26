import subprocess

# Se recomienda usar run
# pero otras funciones como Popen tambien sirven.

try:
    subprocess.run(['Notepad.exe']) 
    subprocess.Popen(['C:/Windows/System32/calc.exe'])
except FileNotFoundError:
    print("No encontrado en la ubicacion predeterminada")
except Exception as e:
    print("Se produjo un error", str(e))