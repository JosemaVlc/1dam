if [[ $# -eq 3 ]]; then
    case $2 in
        "+")
            echo $(( $1 + $3 ))
            ;;
        "-")
            echo $(( $1 - $3 ))
            ;;
        "x")
            echo $(( $1 * $3 ))
            ;;
        "/")
            echo $(( $1 / $3))
            ;;
        *)
            echo Expresion no encontrada
    esac
else
    echo Error, se han introducido $# parametros en vez de 3.
fi