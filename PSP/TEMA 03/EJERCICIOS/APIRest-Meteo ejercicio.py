from urllib import request
import json

ciudad = "Sagunto"
api_key = "83e5978c218757a762484859178514af"
unidad = "metric"

url = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=%s&appid=%s" % (ciudad, unidad, api_key)

#print (url)

response = request.urlopen(url)
http_body = response.readline().decode('utf-8')

#print (http_body)

#codificar la respuesta a json
data = json.loads(http_body)
print (data)

main = data ["main"]
viento = data ["wind"]

temperatura = main["temp"]
tempmin = main["temp_min"]
tempmax = main["temp_max"]
velocidad_viento = viento["speed"]



print("\nLa temperatura de "+ ciudad + " es: "+ str(temperatura))
print("La temperatura mínima es de: "+ str(tempmin) +" y la máxima de: "+ str(tempmax))
print("La velocidad del viento es de: " + str(velocidad_viento))