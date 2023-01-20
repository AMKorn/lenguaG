usage="Unexpected format. Expected format:
    "$0" [FLAGS] [input_file [output_file]]
        -f: Jflex compilation
        -c: CUP compilation
        -j: Recompile java classes
        -i: Input expected. Will try to run the compilation process.
            Requires input file.
        -r: Compile machine code and run it. Requires input file.
        -d: Debug machine code using gdb. Does nothing if r is not set.

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
run=0
debug=0

while getopts fcjird flag
do
    flagged=1;
    case "${flag}" in
        f) flex=1;;
        c) cup=1;;
        j) java=1;;
        i) input=1;
            input_file=$2;
            output_file=$3;;
        r) run=1;
            input_file=$2;
            output_file=$3;;
        d) debug=1;;
    esac
done

if [[ ! -n $flagged ]]
then
    input_file=$1
    output_file=$2
fi

if [[ -n $input_file ]] && [[ ! -n $output_file ]]
then
    output_file=$input_file
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
    **** Compiling java classes ****
    "
    javac -cp .:lenguag/syntactic/java-cup-11b-runtime.jar */*.java
    javac -cp .:lenguag/syntactic/java-cup-11b-runtime.jar */*/*.java
    javac -cp .:lenguag/syntactic/java-cup-11b-runtime.jar */*/*/*.java
    echo "Done!"
fi
if [[ -n $input_file ]]
then
    if [[ $input == 0 ]] && [[ $run == 0 ]]
    then
        input=1
    fi
    if [[ $input == 1 ]]
    then
        echo "
    **** Compiler output ****
        "
        java -cp .:lenguag/syntactic/java-cup-11b-runtime.jar lenguag.LenguaG ../$input_file $output_file
    fi
    if [[ $run == 1 ]]
    then
        echo "
    **** Running program ****
        "
        # Currently in /src
        cd ../output/
        file=${output_file##*/}
        cd $file

        file=${file%%.*}

        nasm -f elf64 -l $file.lst -g machineCode.asm
        gcc -no-pie -g -o $file machineCode.o
        if [[ $debug == 0 ]]
        then
            ./$file
        else 
            gdb $file
        fi
        
        cd ../../src
    fi
elif [[ $input == 1 ]] || [[ $run == 1 ]]
then
    echo "$usage" | grep -B 1 'input file'
fi

cd ..