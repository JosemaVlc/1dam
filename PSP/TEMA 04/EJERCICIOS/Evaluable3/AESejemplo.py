from Crypto.Cipher import AES
import base64
import os


def formatear_multiplo_de_16(text):
    while(len(text)%16 != 0):
        text += b' ' # Le añado espacios en blanco al final para completar multiplo de 16,
                     # ya que AES es una cipher de 16, mientras que DES es de 8.
    return text


def encriptar(mensaje,key,iv):
    #instanciamos un nuevo objeto AES
    cipher = AES.new(key,AES.MODE_OFB,IV=iv)
    #ciframos los datos
    bytesCifrados =  cipher.encrypt(mensaje)
    print ("Bytes cifrados: ", bytesCifrados)

    return bytesCifrados

def desencriptar(mensaje,key,iv):
    #es necesario un nuevo objeto para descifrar
    cipher = AES.new(key, AES.MODE_OFB,IV=iv)
    mensajeDescifrado = cipher.decrypt(mensaje)

    return mensajeDescifrado

def main():
    Password = b'Mi pa$$ para P$P' # Los algoritmos AES se usa en diversas áreas 
                                   # como para encriptar ficheros, cifrar archivos comprimidos
                                   # y cifrar comunicaciones seguras. Mientras que DES era muy
                                   # utilizado para cifrar contraseñas.
    mensaje = formatear_multiplo_de_16(Password)
    print ("Mensaje original:", mensaje.decode())
    key = os.urandom(32) # Establecemos una clave de 16 bytes(128bits), 24 bytes(192bits), o 32 bytes(256 bits).
                         # Yo he usado la de 32(Clave de 256 bits)
                         # En DES la clave es de 8 bytes por lo que se ha quedado desfasada por ser tan corta.
    iv = os.urandom(AES.block_size) # generamos aleatoriamente un iv del tamaño del bloque AES. El bloque de DES
                                    # es fijo de 8 bytes(64 bits) mientras que el bloque de AES es tambien fijo 
                                    # pero este es de 16 bytes(128 bits)
    
    mensajeCifrado = encriptar(mensaje,key,iv)
    #para imprimir una mejor representación
    mensajeCifrado_decod = base64.b64encode(mensajeCifrado).decode("utf-8")
    print ("Mensaje Cifrado:", mensajeCifrado_decod)

    #desciframos usando la misma key e iv
    mensajeDescifrado = desencriptar(mensajeCifrado,key,iv)
    print ("Mensaje: ", mensajeDescifrado.decode("utf-8"))

if __name__=="__main__":
    main()