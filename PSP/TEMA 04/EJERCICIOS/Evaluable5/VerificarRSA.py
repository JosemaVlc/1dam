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
    # Abrir la clave publica del usuario
    fichero_path = Path(__file__).parent / "publica_usuario_A.pem" 
    key = RSA.import_key(open(fichero_path, "rb").read())
    
    #Recuperar archivo a verificar
    filename = input("Nombre de fichero: ") #Leemos el fichero a firmar
    fichero_path = Path(__file__).parent / filename
    fichero = open(fichero_path,'rb')
    h = fichero_hash_sha256(fichero)
    # h = SHA256.new(fichero) // Utilizado para hacer el Hash directamente
    
    #Recuperar Firma de un mensaje
    filename = input("Nombre de fichero de la firma: ") #Leemos el fichero a firmar
    fichero_path = Path(__file__).parent / filename
    signature = open(fichero_path,'r').read()    
    signature_b = bytes.fromhex(signature)
        
    try:
        pss.new(key).verify(h,signature_b)
        print ("The signature is valid.")
    except (ValueError, TypeError):
        print ("The signature is not valid.")

if __name__=="__main__":
    main()