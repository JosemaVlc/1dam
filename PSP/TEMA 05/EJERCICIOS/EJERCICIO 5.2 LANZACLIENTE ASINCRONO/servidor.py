import socket
import sys
import httpx
#import weather
import asyncio
import json

from random import randint
import API_OpenaAI_copy

async def main():    
    HOST = '127.0.0.1'  # IP del servidor
    PORT = 5000         # Puerto por el que conectar al servidor
    
    try:
        servidor = await asyncio.start_server(corrutina_servidor, HOST, PORT, backlog=100, reuse_address=True, family=socket.AF_INET, flags=socket.SOCK_STREAM) 
        print('Socket servidor creado')       
    except socket.error as e:
        print('Error servidor: %s' %e)
        sys.exit()
        
    await servidor.serve_forever()
        
async def corrutina_servidor(stream_reader, stream_writer):    
    await asyncio.sleep(randint(5,15))
    
    print(f"conexión exitosa con el cliente. {socket.gethostname()}")
    data = (await stream_reader.read(1024)).decode()
    
    if data == 'lista':
        base_url = "https://jsonplaceholder.typicode.com/users"
                
        async with httpx.AsyncClient() as client:
            response = await client.get(base_url)
            data = json.loads(response.text)
            
        username = ""
        for user_data in data:
            username += user_data['username'] + "\n"
        
        stream_writer.write(username.encode())
        await stream_writer.drain()            
        
        print(f"Mensaje Users enviado a cliente. {socket.gethostname()}")
        print(f"Cliente desconectado {socket.gethostname()}")               
    else:                                
        municipio, temperatura, velocidad_viento, cielos, cod = await asyncio.to_thread(API_OpenaAI_copy.openweathermap, data)
        
        if cod == 200:
            response = await asyncio.to_thread(API_OpenaAI_copy.openai, municipio, temperatura, velocidad_viento, cielos)
            stream_writer.write(response.encode())
            await stream_writer.drain()              
        
        print(f"Mensaje OpenIA enviado a cliente. {socket.gethostname()}")
        print(f"Cliente desconectado {socket.gethostname()}")             

    stream_writer.close()
    await stream_writer.wait_closed()
        
if __name__ == '__main__':    
    asyncio.run(main())
    