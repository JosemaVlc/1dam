file=./hola.txt
read n

while [[ $n != :q ]]; do  
    echo $n >> $file
    echo Escribe otra palabra
    read n
done