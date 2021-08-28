package com.interview.brushups.askedprograms;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Interview Company - CRISIL
 * Find the minimum number from permutations
 */
public class MinimumDifferencePermutations {

    public static void main(String[] args) {
        int arr[] = {7, 3, 2, 4, 12, 56};
        int students = 3;
        Set<List<Integer>> allPermutations = Collections.singleton(getAllPermutations(students));
        System.out.println(findMinDifference(arr,allPermutations));
    }

    public static int findMinDifference(int arr[], Set<List<Integer>> allPermutations ) {
        int minValue = Integer.MAX_VALUE;
        for(List<Integer> currentSet : allPermutations)
        {
            int min  = Collections.min(currentSet);
            int max = Collections.max(currentSet);
            int result = max-min;
            if(result< minValue){
                minValue = result;
            }
        }
        return minValue;
    }

    public static List<Integer> getAllPermutations(int students){
        return null;
    }


}