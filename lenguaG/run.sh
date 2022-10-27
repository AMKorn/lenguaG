if [ $# -eq 0 ]
then
    echo "Unexpected format. Expected format:"
    echo $0" [--jflex] file"
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
    # TODO cup command
fi
javac lenguag/*.java
echo "
    ***** Program output *****
"
java lenguag.LenguaG ../$file
cd ..