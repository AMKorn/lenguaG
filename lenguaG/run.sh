usage="Unexpected format. Expected format:
    "$0" [FLAGS] [input_file [output_file]]
        -f: jflex compilation
        -c: cup compilation
        -j: recompile java classes
        -i: input file. If not given, does not run the main program, 
            but will compile the other flags given. An output may also be
            given, otherwise the output will equal the input name.

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
    case "${flag}" in
        f) flex=1;;
        c) cup=1;;
        j) java=1;;
        i) input=1;
            input_file=$2;
            output_file=$3;;
    esac
done

# echo "flex: $flex"
# echo "cup: $cup"
# echo "input: $input $input_file $output_file"

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
    java -jar java-cup-11b.jar lenguaG.cup
    cd ../..
fi
if [[ $java == 1 ]]
then
    echo "
    **** Compiling java classes ****"
    javac -cp .:lenguag/syntactic/java-cup-11b-runtime.jar lenguag/*.java
    echo "
    Done!"
fi
if [[ $input == 1 ]]
then
    echo "
    **** Program output ****
    "
    java -cp .:lenguag/syntactic/java-cup-11b-runtime.jar lenguag.LenguaG ../$input_file $output_file
fi 
cd ..