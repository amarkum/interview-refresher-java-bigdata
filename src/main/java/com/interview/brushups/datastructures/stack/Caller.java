package com.interview.brushups.datastructures.stack;

public class Caller {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
    }
}
