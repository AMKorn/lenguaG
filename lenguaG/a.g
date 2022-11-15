int begin;
int end;
int[] intArray;

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
	intArray = [5, 9, 4, 6, 5, 3];
	begin = -1;
	end = -0xF;
	quickSort(intArray, begin, end);
}