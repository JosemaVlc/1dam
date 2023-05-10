fichero=./hola.txt
echo > $fichero
echo Escribe una palabra
read palabra
while [[ $palabra != :q ]]; do
    echo $palabra >> $fichero
    sort -o $fichero $fichero
    echo Escribe otra palabra
    read palabra
done
