val int begin = 2;
val int end = 5+begin;
char[] frase = "a";
int[] intArray = [5, 9, 4, 6, 5, 3];

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
	begin = 0;
	end = 5;
	quickSort(intArray, begin, end);
    our("El array ordenado es: ");
    out(intArray);
    out("\n");
}