echo escribe un numero
read numero
verif=false
while read line; do
    for tlf in $line; do
        if [[ $numero == $tlf ]];then
            echo polla
            verif=true
        fi
    done
done < numeros.txt
if [[ $verif == true ]];then
    echo el numero se encuentra en el documento
else
    echo el numero no se encuentra en el documento
fi