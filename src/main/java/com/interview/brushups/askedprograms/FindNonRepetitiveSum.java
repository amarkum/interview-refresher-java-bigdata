package com.interview.brushups.askedprograms;

import java.util.*;

/**
 * Interview Company - GlobalLogic
 * Find sum of non-repeating (distinct) elements in an array
 */
public class FindNonRepetitiveSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4, 4);
        //output : 6

        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                int value = map.get(number);
                map.put(number, ++value);
            }
        }
        int sum = 0;
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == 1) {
                sum += (int) entry.getKey();
            }
        }
        System.out.println("Sum of Distinct is :" + sum);
    }
}
