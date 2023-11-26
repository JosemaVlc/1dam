import subprocess
busqueda = input('Introduce la busqueda: ')
try:
    subprocess.run(['C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe',f'https://www.google.es/search?q={busqueda}'])
except Exception as e:
    print(e)