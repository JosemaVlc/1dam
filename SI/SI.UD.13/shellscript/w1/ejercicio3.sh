echo "- Press I for increment
- Press S for subtraction
- Press D for division
Enter your option"

read VAR_NAME

echo Enter a number
read VAR_NUMBER

if [ "$VAR_NAME" == "I" -o "$VAR_NAME" == "i" ]; then
    VAR_NUMBER=$(($VAR_NUMBER+1))
elif [ "$VAR_NAME" == "S" -o "$VAR_NAME" == "s" ]; then
    echo Enter a second number
    read VAR_NUMBER1
    VAR_NUMBER=$(($VAR_NUMBER-$VAR_NUMBER1))
elif [ "$VAR_NAME" == "D" -o "$VAR_NAME" == "d" ]; then
    echo Enter a second number
    read VAR_NUMBER1
    VAR_NUMBER=$(($VAR_NUMBER/$VAR_NUMBER1))
else
    echo Error, error, error.
    exit 1
fi

echo "$VAR_NUMBER"