class Sumador:
    def sumar(self, frase):
        print("Dada la frase, la funcion retorna el numero de vocales")
        resultado = 0
        for i in frase:
            if i in "aeiouAEIOUáéíóúÁÉÍÓÚ":
                resultado += 1
        return resultado
    
if __name__== "__main__":
    s = Sumador()
    print("este programa suma todos los numeros comprendidos entre dos valores.")
    frase = input("Introduce una frase: ")
    resultado = s.sumar(frase)
    print("El numero de vocales que hay en la frase: *", frase,"* es: ",resultado)
    