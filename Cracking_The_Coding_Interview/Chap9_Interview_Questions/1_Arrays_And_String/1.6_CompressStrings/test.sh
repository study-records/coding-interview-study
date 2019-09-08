java SolJeon $1 > out1
diff -w out1 out2
if [[ $? == "0" ]]
then
  echo "The same"
else
  echo "Not the same"
fi
