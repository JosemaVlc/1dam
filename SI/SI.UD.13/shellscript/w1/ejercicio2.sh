#! /usr/bin/env bash
FILENAME=./ejercicio4.sh

if [ -e $FILENAME ]; then
    if [ -s $FILENAME ]; then
        echo El fichero existe y no está vacío
    else
        echo El fichero existe pero esta vacio
    fi
elif [ -e "$FILENAME"_alternativa ]; then
    echo Existe una alternativa
else 
    echo El fichero no existe
fi

