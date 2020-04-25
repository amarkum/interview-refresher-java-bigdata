package com.interview.brushups.algorithm.searching;

/**
 * Linear Search is the simplest of all search algorithm.
 * The time complexity of above algorithm is O(n).
 */
public class LinearSearch {

    public static void main(String args[]) {
        int[] array = {90, 23, 101, 45, 65, 23, 67, 89, 34, 23};

        for (int number : array) {
            System.out.print(number + " ");
        }
        int searchElement = 89;

        int index = linearSearch(array, searchElement);
        if (index != -1) {
            System.out.println("\nElement " + searchElement + " found at position: " + (index + 1));
            return;
        }
        System.out.println("\nElement " + searchElement + "Not Found");
    }

    public static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
