package com.interview.brushups.algorithm.sorting;

/**
 * Quick Sort is the most effective in average case of Sorting Algorithm
 * Video Explanation : https://www.youtube.com/watch?v=PgBzjlCcFvc
 */
public class QuickSort {

    public static void main(String args[]) {
        int[] array = {34, 36, 2, 9, 9, 32, 47, 7, 1};
        quickSort(array, 0, array.length - 1);

        for (int number : array) {
            System.out.println(number);
        }
    }

    /**
     *
     * The partition does shifts operations,
     * all the lesser element of the pivot to left side and greater element to right side
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    static int getPartition(int[] array, int low, int high) {
        int pivot = array[high];

        //set it to -1 for 1st pass
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // if the value are less than pivot keep swapping the elements
            if (array[j] < pivot) {
                i++; // increment the i
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //put the pivot at the correct place by swapping,
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // i+1 returns the location of correctly place pivot element
        return i + 1;
    }

    static void quickSort(int[] array, int low, int high) {
        {
            if (low < high) {
                //get the index of pivot element
                int pi = getPartition(array, low, high);

                //call the recursive function
                quickSort(array, low, pi - 1);
                quickSort(array, pi + 1, high);
            }
        }
    }
}
