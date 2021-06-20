package com.interview.brushups.askedprograms;

/**
 * Interview Company - JP Morgan & Chase
 * In an array, find the minimum number required to add from the list to get the sum greater or equals to given number.
 */
import java.util.*;

public class FindMinPossibleNumberForSum {

    public static void main(String[] args) {
        Integer nums[] = {1, 3, 4, 2};
        int sum = 5;

        List<Integer> numbers = Arrays.asList(nums);
        Collections.sort(numbers);

        int numberCount = 0;
        int summation = 0;

        for (int i = numbers.size()-1; i >= 0; i--) {
                summation += numbers.get(i);
                numberCount++;
                if (summation >= sum) {
                    System.out.println(numberCount);
                    break;
                }
        }
    }
}
