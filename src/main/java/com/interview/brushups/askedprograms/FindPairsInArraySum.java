package com.interview.brushups.askedprograms;

import java.util.HashSet;

/**
 * Find Pairs in an array, whose sum is X
 * Complexity - O(n), since we traverse the array only once
 */
public class FindPairsInArraySum {

    static void findPairs(int arr[], int sum) {
        HashSet<Integer> set = new HashSet();

        for(int i=0; i < arr.length; i++){

            // calculate the required number which will form the sum in set
            int required = sum - arr[i];

            // if the required number is present in set, current & required number will be a pair
            if(set.contains(required)){
                System.out.println("["+required+", "+arr[i]+"]");
            }

            // if required number is not present, add the current number to set.
            else {
                set.add(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8, 8, 7, 12};
        int n = 16;
        findPairs(A, n);
    }
}

