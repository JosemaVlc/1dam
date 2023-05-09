while true; do
    echo Escriba su contraseña
    read password
if [ "$password" == "password123" ]; then
    echo contraseña correcta, puede pasar!
    exit 1
else
    echo Contraseña incorrecta
fi
done