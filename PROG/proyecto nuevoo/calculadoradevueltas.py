while True:
    cantidad=int(input("Introduce cantidad validad de Euros(multiples de 5€)"))
    if cantidad%5 == 0:
        break
a=0
b=0
c=0
d=0
e=0
f=0
g=0
resto=cantidad
a=int(resto/500)
resto=resto-(a*500)
b=int(resto/200)
resto=resto-(b*200)
c=int(resto/100)
resto=resto-(c*100)
d=int(resto/50)
resto=resto-(d*50)
e=int(resto/20)
resto=resto-(e*20)
f=int(resto/10)
resto=resto-(f*10)
g=int(resto/5)
resto=resto-(g*5)
if resto==0:
    print(f"Ha introducido {cantidad}€")
    print("La vuelta consiste en los siguientes billetes:")
    if a!=0:
        print(f"{a} billetes de 500€")
    if b!=0:
        print(f"{b} billetes de 200€")
    if c!=0:
        print(f"{c} billetes de 100€")
    if d!=0:
        print(f"{d} billetes de 50€")
    if e!=0:
        print(f"{e} billetes de 20€")
    if f!=0:
        print(f"{f} billetes de 10€")
    if g!=0:
        print(f"{g} billetes de 5€")
else:
    print("Error de calculo, mejor utilice una calculadora")    