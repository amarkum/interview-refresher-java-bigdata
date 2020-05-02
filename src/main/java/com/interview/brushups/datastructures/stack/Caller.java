package com.interview.brushups.datastructures.stack;

public class Caller {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

        stack.push("Stack");
        stack.push("Queue");

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(1%3);
    }
}
