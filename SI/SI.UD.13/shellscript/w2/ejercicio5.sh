filename=$1
eq="$2"
iter=0

while read line; do 
    for word in $line; do
        if [[ "$word" == *"$eq"* ]]; then
            iter=$(($iter + 1)) 
        fi
    done
    echo $iter ' : ' $line 
    iter=0
done < $filename