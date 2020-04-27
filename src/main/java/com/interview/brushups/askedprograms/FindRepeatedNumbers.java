package com.interview.brushups.askedprograms;

import java.util.HashSet;

/**
 * Find if a number is repeated in an integer array
 */
public class FindRepeatedNumbers {

    public static void main(String[] args) {
        int[] array = {23, 7, 23, 8, 84, 93, 7, 9, 9};

        HashSet < Integer > uniqueElement = new HashSet();
        HashSet < Integer > repeatedElement = new HashSet();

        for (int i = 0; i < array.length; i++) {
            if (uniqueElement.contains(array[i])) {
                repeatedElement.add(array[i]);
            } else {
                repeatedElement.add(array[i]);
            }
        }

        for (Integer number: uniqueElement) {
            System.out.println(number);
        }
    }
}