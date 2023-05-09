if [[ $# -ne 2 ]]; then
 echo "Error: Expected two arguments."
 exit 1
fi
if [ $1 -gt $2 ]; then
 echo "Error: First argument must be less or equal to second argument."
 exit 1
fi
for ((i=$1; i<=$2; i++)); do
 echo $i
done
