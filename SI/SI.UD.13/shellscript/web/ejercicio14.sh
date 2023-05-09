if [[ $# -eq 1 ]];then
    n=$1
    for (( i=0; i<=n; i++)) do
        echo $i
    done
else
    echo Error, $# argumentos encontrados, necesario un unico argumento
fi