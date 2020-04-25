package com.interview.brushups.algorithm.searching;

public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {1,2,7,9,9,32,34,36,47,};

        for (int number : array) {
            System.out.print(number + " ");
        }
        int searchElement = 89;

        binarySearch(array, 0, array.length-1 , searchElement);
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left sub-array
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right sub-array
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
