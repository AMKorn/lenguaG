val int begin = 0;
val int end = 5;
int[][][] intArray = 
    [
     [[5, 9, 4, 6, 5, 3, 9],
      [1, 2, 3, 4, 5, 6, 2]],
      
     [[5, 9, 4, 6, 5, 3, 9],
      [1, 2, 3, 4, 5, 6, 2]]
    ];
int a = intArray[end][begin][0];

// Function that sorts the given array
void quickSort (int[] array, int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(arr, begin, end);

        quickSort(array, begin, partitionIndex-1);
        quickSort(array, partitionIndex+1, end);
    }
}

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

main {
	quickSort(intArray, begin, end);
    out("El array ordenado es: ");
    out(intArray);
    out("\n");
}