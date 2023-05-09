for ((i=1; i <= $1 ; i++)); do
    echo ""
    for ((j=0; j < i; j++)); do
        echo -n "*"
    done
done