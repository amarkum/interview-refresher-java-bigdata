package com.interview.brushups.algorithm.sorting;

/**
 * Like, QuickSort Merge Sort also use Divide and Conquer algorithm for sorting the element
 * Video Explanation : https://www.youtube.com/watch?v=JSceec-wEyw
 * Approach - Divide and Conquer
 * Time Complexity - Time complexity of Merge Sort for all cases is nLogn
 */
public class MergerSort {

    public static void main(String args[]) {
        int[] array = {90, 23, 101, 45, 65, 23, 67, 89, 34, 23};
        mergeSort(array, 0, array.length - 1);

        for (int number : array) {
            System.out.println(number);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {

        int l = mid - start + 1;
        int r = end - mid;
        int i, j;

        int[] LeftArray = new int[l];
        int[] RightArray = new int[r];

        for (i = 0; i < l; ++i)
            LeftArray[i] = arr[start + i];

        for (j = 0; j < r; ++j)
            RightArray[j] = arr[mid + 1 + j];

        i = 0;
        j = 0;
        int k = start;
        while (i < l && j < r) {
            if (LeftArray[i] <= RightArray[j]) {
                arr[k] = LeftArray[i];
                i++;
            } else {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < r) {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] arr, int start, int end) {

        // if start is less than end, meaning the array has at least two element, do the operation.
        if (start < end) {

            //find the mid, by dividing by 2
            int mid = (start + end) / 2;

            //call to divide the array into sub-arrays and perform a merge by sorting the elements
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

}
