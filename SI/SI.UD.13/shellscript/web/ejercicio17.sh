while true; do
    read n
    if [[ "$n"==":p" ]]; then
        exit 1
    fi
done