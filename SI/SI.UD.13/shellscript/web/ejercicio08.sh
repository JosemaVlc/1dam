echo Introduce la ruta de un fichero
read n

if [[ -e $n ]]; then
    echo El fichero $n existe
fi