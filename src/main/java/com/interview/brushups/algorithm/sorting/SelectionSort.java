package com.interview.brushups.algorithm.sorting;

/**
 * Selection Sort is the most simplest of Sorting Algorithm
 */
public class SelectionSort {

    public static void main(String args[]) {
        int[] array = {34, 36, 2, 9, 47, 7, 1};
        selectionSort(array);

        for(int number : array){
            System.out.println(number);
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i+1; j <= array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // swapping
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }
}
