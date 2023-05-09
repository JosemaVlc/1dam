filename=$1

first_word=$(awk -F' ' 'NR==1{print $2}' "$filename")

echo "La primera palabra de $filename es: $first_word"

