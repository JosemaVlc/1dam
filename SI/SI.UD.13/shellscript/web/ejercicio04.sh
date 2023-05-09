echo Introduce un numero:
read num

if [[ $num -gt 0 ]]; then
    echo Introducido un numero positivo
elif [[ $num -lt 0 ]]; then
    echo Introducido un numero negativo
elif [[ $num -eq 0 ]]; then
    echo Introducido un cero
fi