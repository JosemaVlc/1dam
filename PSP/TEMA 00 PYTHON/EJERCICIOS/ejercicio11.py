c = int(input("Cantidad depositada: "))
i = 4
uno = (c*4/100)+c
dos = (uno*4/100)+uno
tres = (dos*4/100)+dos
print(f"""
      Ahorros primer año:   {uno}€
      Ahorros segundo año:  {dos}€
      Ahorros tercer año:   {tres}€
      """)