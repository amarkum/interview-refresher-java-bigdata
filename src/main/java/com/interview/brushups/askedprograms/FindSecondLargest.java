package com.interview.brushups.askedprograms;

/**
 * Program to Find Second Largest in an Array - Accolite
 */
public class FindSecondLargest {

    public static void main(String[] args) {
        int array[] = {1, 9, 5, 11, 34, 38};

        int result = secondLargest(array);
        System.out.println("Second Largest Value is : " + result);
    }

    /**
     * Method to print the second largest elements
     */
    public static int secondLargest(int array[]) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        int n = array.length;

        // There should be at-least two element in the array
        if (n < 2) {
            System.out.println("There should be at-least two elements in the array");
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {

            // If current element is greater than, first then update both first and second
            if (array[i] > first) {
                // store the previous max value to second variable
                second = first;
                first = array[i];
            }

            // If arr[i] is greater than second, and not equals to first, update second */
            else if (array[i] > second && array[i] != first)
                second = array[i];
        }
        if(second == Integer.MIN_VALUE){
            System.out.println("No Second Largest Element");
            System.exit(0);
        }
        return second;
    }
}