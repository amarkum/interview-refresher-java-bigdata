package com.interview.brushups.askedprograms;

import java.util.ArrayList;
import java.util.List;

/**
 * Interview Company - 24/7
 * Given an array, find the greatest element to the right side of it at immediate
 */
public class FindNxtGreatest {
    public static void main(String[] args) {
        int numArray[] = {5, 41, 3, 7, 18};
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numArray.length; i++) {
            boolean isValueFound = false;
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[i] < numArray[j]) {
                    numbers.add(numArray[j]);
                    isValueFound = true;
                    break;
                }
            }
            if (!isValueFound) {
                numbers.add(-1);
            }
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
