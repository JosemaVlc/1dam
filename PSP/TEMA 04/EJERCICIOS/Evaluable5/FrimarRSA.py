from Crypto.PublicKey import RSA
from Crypto.Signature import pss
from Crypto.Hash import SHA256
from pathlib import Path


def fichero_hash_sha256(file):
    """La función retorna el código HASH con SHA256 del fichero"""

    # Creamos el objeto HASH usando el algoritmo SHA256
    h = SHA256.new()

    # Abrimos el fichero en modo binario (rb)
    linea = 0
    while linea != b'':
        # Leemos cada vez 1024 bytes. linea contiene lo leido
        linea = file.read(1024)
        #Acumulamos los datos en objeto hash y lo actualizamos
        h.update(linea)

    # Devuelve el HASH final tras haber leído todo el fichero
    return h

def main():

    #Pedir la clave privada del usuario
    fichero_path = Path(__file__).parent / "privada_usuario_A.pem"
    private_key = RSA.import_key(open(fichero_path, "rb").read()) #leemos la clave privada del usuario_A

    #Firmar el Hash de un mensaje
    filename = input("Nombre de fichero: ") #Leemos el fichero a firmar
    fichero_path = Path(__file__).parent / filename
    fichero = open(fichero_path,'rb')
    #codigoHASH = SHA256.new(fichero) // Utilizado para hacer el Hash directamente
    codigoHASH = fichero_hash_sha256(fichero)
    signature = pss.new(private_key).sign(codigoHASH)
    #fichero.close()

    print(signature)

    #Creamos un fichero dónde guardamos la signatura
    fichero_path = Path(__file__).parent / "SignaturaFichero.txt"
    fichero = open(fichero_path,'w')
    fichero.write(signature.hex()) #lo codificamos a hexadecimal para poder guardarlo en un fichero.txt
    fichero.close()

if __name__=="__main__":
    main()