filename=$1
eq="$2"
iter=0

while read -r word; do 
    if [ "$eq" == "$word" ]; then
        iter=$(($iter+1))
    fi
    echo "$iter":"$word"
done < $filename