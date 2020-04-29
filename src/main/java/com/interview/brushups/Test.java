package com.interview.brushups;

public class Test {

    public static void main(String[] args) {

        int[] array = {14, 46, 47, 45, 92, 52, 48, 36, 66, 85};
        int result = findSecondLargest(array);

        System.out.println("Second Largest Element " + result);
    }

    static int findSecondLargest(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            if (array[i] > first) { //14
                second = first;
                first = array[i];
            }

            if (second < array[i] && first != array[i]) {
                second = array[i];
            }

        }
        if (second == Integer.MIN_VALUE) {
            System.out.println("No Second Largest Element was Found");
            System.exit(0);
        }
        return second;
    }
}







