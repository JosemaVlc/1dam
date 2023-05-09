if [[ $# -eq 1 ]];then
    n=$1
    suma=0
    for (( i=0; i<=n; i++)) do
        echo $suma '+' $i '=' $(($suma+$i))
        suma=$(($suma+$i))
    done
else
    echo Error, $# argumentos encontrados, necesario un unico argumento
fi