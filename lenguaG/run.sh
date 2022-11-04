if [ $# -eq 0 ]
then
    echo "Unexpected format. Expected format:"
    echo $0" [PARAMS] file"
    echo "  f: jflex compilation"
    echo "  c: cup compilation"
    exit 1
elif [ $# -eq 1 ]
then
    file=$1
    mode=0
elif [ $# -eq 2 ]
then
    file=$2
    mode=$1
fi

cd src/ 

if [[ $mode == *"f"* ]]
then
    echo "
    **** Running jflex ****
    "
    jflex lenguag/lexic/lenguaG.flex
fi
if [[ $mode == *"c"* ]]
then
    echo "
    **** Running cup ****
    "
    cd lenguag/syntactic/
    java -jar java-cup-11b.jar lenguaG.cup
    cd ../..
fi
javac -cp .:lenguag/syntactic/java-cup-11b-runtime.jar lenguag/*.java
echo "
    ***** Program output *****
"
java -cp .:lenguag/syntactic/java-cup-11b-runtime.jar lenguag.LenguaG ../$file
cd ..