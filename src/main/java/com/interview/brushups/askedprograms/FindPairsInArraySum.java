package com.interview.brushups.askedprograms;

import java.util.HashSet;

/**
 * Find Pairs in an array, whose sum is X
 */
public class FindPairsInArraySum {

    static void findPairs(int arr[], int sum) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];

            if (set.contains(temp)) {
                System.out.println(" [" + arr[i] + ", " + temp + "]");
            }
            set.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8, 8, 12};
        int n = 16;
        findPairs(A, n);
    }
}

