int begin;
int end;
int[] intArray;

// Function that sorts the array given
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

    for (int j = begin; j < end; j++) {
        if (array[j] <= pivot) {
            i++;

            array[i] <<>> array[j];
        }
    }

    array[i+1] <<>> array[end];

    return i+1;
}

main {
	intArray = [5, 9, 4, 6, 5, 3];
	begin = 0b010111;
	end = 0x24af;
	quickSort(intArray, begin, end);
}