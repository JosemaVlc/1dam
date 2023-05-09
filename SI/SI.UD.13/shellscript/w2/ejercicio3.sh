total=0
while true; do
    echo Introduzca un numero para que lo sume al acumulativo
    read numero

    if [ $numero -lt 0 ]; then
        echo La suma es $total
        exit
    fi

    total=$(($numero+$total))
done
        