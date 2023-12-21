# import OpenIA
import os
import requests
from openai import OpenAI

# import weather
from urllib import request
import json


def openai(municipio, temperatura, cielos):
    """Envia prompt con municipio, temperatura, y como esta el cielo a chatGPT 
    y recibe la respuesta con que actividades puedes realizar"""

    os.environ["OPENAI_API_KEY"] = "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"
    contexto = "Eres el reputado presentador del tiempo en los informativo llamado Gepeto Tornado y debes recomendarnos en un parrafo que hacer segun el tiempo y el municipio que te proporcione"
    texto = f"¿Qué acividades puedo hacer en {municipio} con {temperatura} grados y {cielos}?"

    client = OpenAI()
    

    stream = client.chat.completions.create(
        model="gpt-3.5-turbo",
        messages=[
            {
                "role": "system", 
                "content": contexto
            },        
            {
                "role": "user",
                "content": texto
            }],
        stream=True,
        temperature=1
    )
    for chunk in stream:
        print(chunk.choices[0].delta.content or "", end="")

def openweathermap():
    """Utiliza el Api de OpenWeatherMap para optener el tiempo de un municipio en concreto"""

    municipio = "Burjassot"
    api_key = "83e5978c218757a762484859178514af"
    unidad = "metric"

    url = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=%s&appid=%s" % (municipio, unidad, api_key)

    #print (url)

    response = request.urlopen(url)
    http_body = response.readline().decode('utf-8')

    #print (http_body)

    #codificar la respuesta a json
    data = json.loads(http_body)
    #print (data)

    main = data ["main"]
    temperatura = main["temp"]

    cod = data["cod"]

    tiempo = data ["weather"][0]
    cielos = tiempo["description"]

    #print("\nLa temperatura de "+ municipio + " es: "+ str(temperatura) + " con cielos: " + cielos)

    return municipio, temperatura, cielos, cod

if __name__ == "__main__":
    
    municipio, temperatura, cielos, cod = openweathermap()
    
    if cod == 200:
        openai(municipio, temperatura, cielos)
