usage="Unexpected format. Expected format:
    "$0" [FLAGS] [input_file [output_file]]
        -f: Jflex compilation
        -c: CUP compilation
        -j: Recompile java classes
        -i: Input expected. Will try to run the program.
            Requires input file.

"

if [ $# -eq 0 ]
then
    printf "$usage"
    exit 1
fi

flex=0
cup=0
java=0
input=0

while getopts fcji flag
do
    flagged=1;
    case "${flag}" in
        f) flex=1;;
        c) cup=1;;
        j) java=1;;
        i) input=1;
            input_file=$2;
            output_file=$3;;
    esac
done

if [[ ! -n $flagged ]]
then
    input_file=$1
    output_file=$2
fi

cd src/

if [[ $flex == 1 ]]
then
    echo "
    **** Running jflex ****
    "
    jflex lenguag/lexic/lenguaG.flex
fi
if [[ $cup == 1 ]]
then
    echo "
    **** Running CUP ****
    "
    cd lenguag/syntactic/
    java -jar java-cup-11b.jar -locations lenguaG.cup
    cd ../..
fi
if [[ $java == 1 ]]
then
    echo "
    **** Compiling java classes ****"
    javac -cp .:lenguag/syntactic/java-cup-11b-runtime.jar **/*.java
    echo "
    Done!"
fi
if [[ -n $input_file ]]
then
    echo "
    **** Program output ****
    "
    java -cp .:lenguag/syntactic/java-cup-11b-runtime.jar lenguag.LenguaG ../$input_file $output_file
elif [[ $input == 1 ]]
then
    echo "$usage" | grep -B 1 'input file'
fi
cd ..