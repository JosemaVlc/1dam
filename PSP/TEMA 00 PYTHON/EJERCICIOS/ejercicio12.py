n = int(input("Barras de pan vendidas del dia anterior: "))
precio = 3.49
desc = (precio*60)/100
print(f"""
      Precio sin barra sin descuento: {precio}€
      Descuento: {desc}€
      Numero de barras: {n}
    
      Coste final: {n * (precio - desc)}€
      """)