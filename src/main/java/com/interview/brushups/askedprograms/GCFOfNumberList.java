package com.interview.brushups.askedprograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Interview Company - OLA Cabs
 * Find GCF of list of numbers
 */
public class GCFOfNumberList {

    public static void main(String[] args) {
        Integer number[] = {6, 12, 9};
        List<Integer> numberList = Arrays.asList(number);

        int maximum = Collections.min(numberList);
        for (int i = maximum; i > 0; i--) {

            boolean result = isListDivisible(numberList, i);
            if (result) {
                System.out.println("GCF for the Number : " + i);
                break;
            }
        }
    }

    public static boolean isModZero(int number, int max) {
        if ((number % max) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isListDivisible(List<Integer> list, int max) {
        boolean isModeZeroForAll = true;
        for (Integer number : list) {
            if (!isModZero(number, max)) {
                isModeZeroForAll = false;
            }
        }
        return isModeZeroForAll;
    }
}
