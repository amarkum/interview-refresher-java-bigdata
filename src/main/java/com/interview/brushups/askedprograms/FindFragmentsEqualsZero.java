package com.interview.brushups.askedprograms;

/**
 * Write a Program that returns number of Fragments of a List whose Sum Equals to 0
 */
public class FindFragmentsEqualsZero {

    public static int findFragments(int[] arrayOfNumbers) {

        int zeroCounter = 0;
        int patternSequence = 0;
        int value;

        //get the length of the array
        int length = arrayOfNumbers.length;

        // If it has only one value, if it's not 0, return 0 directly.
        if (length == 1) {
            if (arrayOfNumbers[0] != 0) {
                return 0;
            }
        }
        // iterate through the list, if it has a zero, ++ the zeroCounter
        for (int i = 0; i < length; i++) {
            if (arrayOfNumbers[i] == 0) {
                zeroCounter++;
            }
            int sum = arrayOfNumbers[i];

            for (int j = i + 1; j < length; j++) {
                sum = sum + arrayOfNumbers[j];
                if (sum == 0) {
                    patternSequence++;
                }
            }
        }
        value = zeroCounter + patternSequence;
        return value;
    }

    public static void main(String[] args) {
        int[] arrayOfNumbers = {2, -2, 3, 0, 4, -7};
        System.out.println("\nNumber of Such Fragments : " + findFragments(arrayOfNumbers));
    }
}
