val int begin = 0;
int end = 6;
char c = 'c';
bool t = true;
int[] intArray = [5+end, 9, 4, 6, 5, 3, 9];
int[][] a = [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
             [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]];
// char[] string = "Esto es un string";

int partition(int[] array, int begin, int end) {
    int pivot = array[end];
    int i = (begin-1);

    for (int j = begin; j < end; j=j+1) {
        if (array[j] <= pivot) {
            i=i+1;

            array[i] <<>> array[j];
        }
    }

    array[i+1] <<>> array[end];

    return i+1;
}

// Function that sorts the given array
void quickSort (int[] array, int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(array, begin, end);

        quickSort(array, begin, partitionIndex-1);
        quickSort(array, partitionIndex+1, end);
    }
}

main {
    // intArray = [5, 9, 4, 6, 5, 3];
    // quickSort(intArray, begin, end);
    // out("El array ordenado es: ");
    // out(intArray);
    // out("\n");
}