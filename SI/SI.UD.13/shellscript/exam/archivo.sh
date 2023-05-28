#! /usr/bin/env bash


echo "The password should be at least 8 characters long, contains at least one uppercase letter, one lowercase letter"
while [[ $stringLength < 8 ]]
do
    read -p "Input the password -> " password
    stringLength=${#password}
    if [[ $stringLength > 7 ]]
    then
        echo "Password is valid"
    else
        echo "Password should be at least 8 characters long"
        read -p "try again (y/n)" again
        if [[ "$again" == "n" ]]
        then
            exit
        fi
    fi  
done




