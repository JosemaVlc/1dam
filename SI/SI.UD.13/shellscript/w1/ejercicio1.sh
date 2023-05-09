A_VAR="this   is a var"
echo $A_VAR
echo '"'$A_VAR'"'
echo "$A_VAR"
echo '"'"$A_VAR"'"'
echo The variable A_VAR has the value "$A_VAR"
echo The variable A_VAR has the value $A_VAR
echo The variable '$A_VAR' has the value $A_VAR
echo The variable '$A_VAR' has the value "$A_VAR"
echo Today is $(date +"%b %e") and the variable '$A_VAR' has the value "$A_VAR"