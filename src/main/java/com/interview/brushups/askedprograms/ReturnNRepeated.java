package com.interview.brushups.askedprograms;

import java.util.HashMap;
import java.util.Map;

/**
 * In an array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 *
 * Return the element repeated N times.
 *
 * Input: [1,2,3,3]
 * Output: 3
 *
 * Input: [2,1,2,5,3,2]
 * Output: 2
 *
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 */
public class ReturnNRepeated {

    public static void main(String[] args) {

        int arrayofN[] = {5,1,5,2,5,3,5,4};
        int sizeOfArray = arrayofN.length;

        int nValue = sizeOfArray / 2;

        Map<Integer, Integer> countStore = new HashMap<>();

        for (int number : arrayofN) {
            if (!countStore.containsKey(number)) {
                countStore.put(number, 1);
            } else {
                int value = countStore.get(number);
                countStore.put(number, ++value);
            }
        }

        for (Map.Entry e : countStore.entrySet()) {
            if((Integer)e.getValue()==nValue){
                System.out.println(e.getKey());
                break;
            }
        }
    }
}
