package com.interview.brushups.datastructures.array;

public class SmallestNumber {

    static int[] arr = {34, 36, 2, 9, 47, 7, 1};
    static int smallest = arr[0];

    public static void main(String args[]) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println(smallest);
    }
}