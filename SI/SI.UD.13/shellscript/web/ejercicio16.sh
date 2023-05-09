if [[ $# -eq 2 ]];then
    echo Antes
    echo '$1='$1
    echo '$2='$2
    set $2 $1    
    echo Despues
    echo '$1='$1
    echo '$2='$2
else
    echo Error, $# argumentos encontrados, necesario dos argumentos
fi