package com.interview.brushups.askedprograms;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Interview Company - Walmart
 * Given a array, and a target number
 * Output true or false, if the repeated number, with difference with base Index is equal to target number
 *
 */
class FindDifferenceEqualsTarget {
    public static void main(String[] args) {
        int numbers[] = {2, 3, 2, 4, 5, 7};
        int target = 2;
        System.out.println(isIndexDiffSame(numbers, target));
    }

    public static boolean isIndexDiffSame(int[] numbers, int target) {
        Map<Integer, Integer> numMap = new LinkedHashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!numMap.containsKey(numbers[i])) {
                numMap.put(numbers[i], i);
            } else {
                int prevIndex = numMap.get(numbers[i]);
                int resultant = i - prevIndex;
                if (resultant == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
