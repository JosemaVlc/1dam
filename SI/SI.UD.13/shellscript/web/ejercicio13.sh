if [[ $# -eq 1 ]];then
    for (( i=0; i<$1; i++));do
        echo hola
    done
else
    echo Error, $# argumentos de 1 necesario.
fi