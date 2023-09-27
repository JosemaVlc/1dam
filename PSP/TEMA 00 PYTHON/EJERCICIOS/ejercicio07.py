peso = int(input("Introduce su peso KG: "))
estatura = int(input("Introduce su altura en CM: "))
imc = (peso/(estatura*estatura))*10000
print(f"Su indice de masa corporal es {imc}")