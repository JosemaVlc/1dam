echo Introduce la ruta de un fichero o directorio
read n

if [[ -f $n ]]; then
    echo Es un fichero
elif [[ -d $n ]]; then
    echo Es un directorio
else 
    echo La ruta no existe
fi