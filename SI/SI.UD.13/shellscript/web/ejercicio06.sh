if [[ $# -eq 2 ]]; then
    echo La suma de $1 y $2 tiene como resultado $(($1 + $2))
else
    echo Error, $# parametros encotrados, son necesarios unicamente 2 parametros para realizar la suma
fi
