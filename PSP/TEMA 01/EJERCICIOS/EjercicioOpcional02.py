from pathlib import Path

class Sumador:
    def sumar(self, frase):
        resultado = 0
        for i in frase:
            if i in "aeiouAEIOUáéíóúÁÉÍÓÚ":
                resultado += 1
        return resultado
    
if __name__== "__main__":
    resultado = 0
    s = Sumador()
    resultados = []
    fichero_path = Path(__file__).parent
    try:
        file1 = open(fichero_path/"frases.txt","r")
        for line in file1.readlines():
            frase = line
            resultado = s.sumar(frase)
            resultados.append(resultado)       
    except OSError as e:
        print(f"fichero1: ",e)
    file1.close()
    
    try:
        file2 = open(fichero_path/"solucion.txt","w") 
        cont = 1
        for i in resultados:
            file2.write("La frase "+str(cont)+" tiene "+str(i)+" vocales\n")
            cont +=1            
    except OSError as e:
        print(f"fichero2: ",e)                   
    file2.close
   