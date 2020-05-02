package com.interview.brushups.datastructures.queue;

public class PrintNBinaryNumber {
    public static void main(String[] args) {

        int number = 6;
        String[] result = new String[number];

        /**
         * We Choose, capacity = number+1, because we will enqueue all new element in loop
         * Also, we will enqueue as starting element
         */
        Queue<Integer> queue = new Queue<Integer>(number + 1);

        queue.enqueue(1);

        for (int i = 0; i < number; i++) {

            // dequeue element from queue , append 0 and 1 and add it to array.
            result[i] = String.valueOf(queue.dequeue());

            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.enqueue(Integer.parseInt(s1));
            queue.enqueue(Integer.parseInt(s2));
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

