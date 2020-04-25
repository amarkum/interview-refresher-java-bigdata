package com.interview.brushups.algorithm.searching;

/**
 * Binary search works on the condition that array is sorted.
 * Binary Search has reduce time complexity to O(Log n).
 */
public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {1, 2, 7, 5, 9, 32, 34, 36, 47};

        for (int number : array) {
            System.out.print(number + " ");
        }
        int searchElement = 9;

        int index = binarySearch(array, 0, array.length - 1, searchElement);

        if (index != -1) {
            System.out.println("\nElement " + searchElement + " found at position: " + (index + 1));
            return;
        }
        System.out.println("\nElement " + searchElement + "Not Found");
    }

    static int binarySearch(int arr[], int low, int high, int x) {
        int mid = (low + high) / 2;

        // Only continue if there are more than two elements in the array
        if (low < high) {

            // If the searched element is exactly equal to mid, send the index
            if (x == arr[mid])
                return mid;

            // If the searched element is less than mid element, call binary search with, 0 to middle-1
            if (x < arr[mid])
                return binarySearch(arr, low, mid - 1, x);

            // Else search from middle+1 to last element
            return binarySearch(arr, mid + 1, high, x);
        }
        return -1;
    }
}
