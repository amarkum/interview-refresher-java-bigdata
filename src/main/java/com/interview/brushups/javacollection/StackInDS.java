package com.interview.brushups.javacollection;

import java.util.Stack;

public class StackInDS {

    public static void main(String[] args) {

        // Stack works on LIFO - Last In First Out
        Stack<String> stack = new Stack<>();

        // push - is used to add elements to the stack
        stack.push("1");
        stack.push("2");

        System.out.println(stack);

        // peek - It returns the last elements of the stack. This does not delete the element in the stack
        System.out.println(stack.peek());

        // pop - It returns the last elements of the stack. This also deletes the element in the stack
        System.out.println(stack.pop());

        System.out.println(stack);

        // Remove the last left elements
        stack.pop();

        // Returns True if stack is Empty
        System.out.println(stack.isEmpty());
    }
}
