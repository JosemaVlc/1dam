while true; do
    read n
    if [[ $n == :q ]]; then
        exit 1
    fi
done