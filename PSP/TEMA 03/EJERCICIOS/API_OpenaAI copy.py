import os
import requests
from openai import OpenAI

os.environ["OPENAI_API_KEY"] = "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"

client = OpenAI()

text = "¿Qué acividades puedo hacer en Sagunto con 5 grados y cielo despejado?"

stream = client.chat.completions.create(
    model="gpt-3.5-turbo",
    messages=[
        {
            "role": "system", 
            "content": "eres un reputado presentador del tiempo en los informativo"
        },        
        {
            "role": "user",
            "content": text
        }],
    stream=True,
)
for chunk in stream:
    print(chunk.choices[0].delta.content or "", end="")