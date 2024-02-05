from Crypto.PublicKey import RSA
from pathlib import Path

key = RSA.generate(2048) #creamos la llave privada RSA
private_key = key.exportKey() # codifica la clave en un formato
fichero_path = Path(__file__).parent / "privada_servidor.pem"

file_out = open(fichero_path, "wb")
file_out.write(private_key) # escribimos la clave formateada
file_out.close

public_key = key.publickey().exportKey() # generalmos la clave publica

fichero_path = Path(__file__).parent / "publica_servidor.pem"

file_out = open(fichero_path, "wb")
file_out.write(public_key) # escribimos la clave publica en otro archivo
file_out.close()
