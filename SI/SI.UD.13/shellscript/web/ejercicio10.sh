echo Introduce una ruta
read n

if [[ -e $n ]]; then
    if [[ -r $n ]]; then
        echo Tiene permisos de lectura
    else
        echo No tiene permisos de lectura
    fi
    if [[ -w $n ]]; then
        echo Tiene permisos de escritura
    else
        echo No tiene permisos de escritura
    fi
    if [[ -x $n ]]; then
        echo Tiene permisos de ejecucion
    else
        echo No tiene permisos de ejecucion
    fi
else
    echo La ruta no existe
fi
