import subprocess
from pathlib import Path

def sumar(n1, n2):
    resultado = 0

    for i in range (n1, n2 + 1):
        resultado += i

    print(f"la suma de los numeros {n1} y {n2} es {resultado}")
    
    return resultado

if __name__ == "__main__":
    
    resultado = 0
    
    #para abrir el fichero que se encuentra en el mismo path que el programa python
    fichero_path = Path(__file__).parent
    try:
        f1 = open(fichero_path/"solucion.txt","w") # el argumento w crea el archivo si no existe o lo sobreescribe        
    except OSError as e:
        print("fichero: ", e)
    
    else:
        try:
            f2 = open(fichero_path/"valores.txt", "r") # la opcion r, es solo lectura
            
            for line in f2.readlines():
                n1, n2 = [int(x) for x in line.split((","))]
                resultado = sumar(n1,n2)
                print(f"La suma de los numeros entre {n1} y {n2} es: {resultado}", file=f1)
        except Exception as e:
            print("Fichero: ",e)
            
    