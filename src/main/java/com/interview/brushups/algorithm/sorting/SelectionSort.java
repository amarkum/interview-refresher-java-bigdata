package com.interview.brushups.algorithm.sorting;

/**
 * Selection Sort is the most simplest of Sorting Algorithm
 */
public class SelectionSort {

    public static void main(String args[]) {
        int[] array = {34, 36, 2, 9, 47, 7, 1};
        selectionSort(array);

        for (int number : array) {
            System.out.println(number);
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {

            //store the minimum value as that index
            int min = array[i];

            //also store the index is being worked
            int minId = i;

            //run another loop and lookup an element skipping the current element
            for (int j = i + 1; j < array.length; j++) {

                // if the next element and forward element is shorter than the current minimum
                // capture the index of it, and store the index
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }

            // now we have the selected the shortest element, exchange it with the current index
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }
}
