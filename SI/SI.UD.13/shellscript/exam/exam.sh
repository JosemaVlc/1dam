archivo=$1

while [[ -z "$archivo" ]]
do
    read -p "El nombre del archivo esta vacio, ingrese un nombre de archivo --> " archivo
done

if [[ "$archivo" != "**.sh" ]]
then
    archivo=$archivo".sh"
fi

cat "$0" > "$archivo"

if [[ ! -x $archivo ]]
then
    echo "El archivo $archivo no es ejecutable, cambiando permisos..."
    chmod 777 $archivo
fi

$0