# Obtención del código HASH con SHA1 de un fichero

# Importar el módulo hashlib
import hashlib
from pathlib import Path

def fichero_hash_sha1(filename):
    # La función retorna el código HASH con SHA1 del fichero

   # Creamos el objeto HASH usando el algoritmo SHA1
   h = hashlib.sha1()
   #para abrir el fichero que se encuentra en el mismo path que el programa python
   fichero_path = Path(__file__).parent / filename

   # Abrimos el fichero en modo binario (rb)
   with open(fichero_path,'rb') as file:
       # Depende de lo grande que es el fichero, no lo podemos leer todo de golpe.
       # Vamos a crear un bule para leerlo trozo a trozo 
       linea = 0
       while linea != b'':
           # Leemos cada vez 1024 bytes. linea contiene lo leido
           linea = file.read(1024)
           #Acumulamos los datos en objeto hash y lo actualizamos
           h.update(linea)

   # Devuelve el HASH final tras haber leído todo el fichero
   return h.hexdigest()


def main():
    filename = input("Nombre de fichero: ")

    # El fichero tiene que estar en el mismo directorio que este programa python
    codigoHASH = fichero_hash_sha1(filename)
    print(codigoHASH)

if __name__=="__main__":
    main()