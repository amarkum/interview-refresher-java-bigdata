package com.interview.brushups.javacollection;

import java.util.LinkedList;

public class LinkedListAsStack {
    public static void main(String[] args) {

        // LinkedList Implements Queue, so it follow FIFO - First In First Out
        LinkedList<String> stack = new LinkedList<String>();

        // Add values to the LinkedList.
        stack.add("1");
        stack.add("2");

        // Add to the first of the LinkedList
        stack.addFirst("0");

        // Returns the first element of the LinkedList
        System.out.println(stack.getFirst());

        // Returns the last element of the LinkedList
        System.out.println(stack.getLast());

        // Add few More Elements
        stack.addLast("3");
        stack.addLast("4");

        System.out.println(stack); // 0, 1, 2, 3, 4

        // peek OR peekFirst - Returns the first element of the LinkedList, doesn't delete the element in LinkedList
        System.out.println(stack.peek()); // Returns 0

        // poll OR pollFirst - deletes element at the start of the LinkedList
        System.out.println(stack.poll()); // Returns 0 and Removes 0

        System.out.println(stack); // 1, 2, 3, 4

        // pollLast - Deletes the elements at the End of the LinkedList
        System.out.println(stack.pollLast()); // Removes 4

        System.out.println(stack);  // 1, 2, 3

        // offer -  Adds elements at last of the stack
        stack.offer("4");
        stack.offer("5");

        System.out.println(stack); // 1, 2, 3, 4, 5

        // peakLast - Returns the last element of the LinkedList, doesn't delete the element in LinkedList
        System.out.println(stack.peekLast()); // 5
    }
}
