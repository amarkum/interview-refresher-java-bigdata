package com.interview.brushups.recursion;

public class RecursionCounter {

    private static void printNum(int n) {
        // Base case
        if (n == 0) {
            return;
        }

        /**
         * If we call the method first which is recursive, it will put up all the method calls on the Stack.
         * when the base condition is met and a return call is made, it starts executing the methods.
         * Output : 1 2 3 4 5 6 7 8 9 10
         */
        printNum(n-1);
        System.out.println(n + " ");

        /**
         * If we have have business logic written, after which the call is made to recursive method.
         * It first executes the business logic, and the calls the method, 1 by 1.
         * Output : 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
         */
//         System.out.println(n + " ");
//         printNum(n-1);
    }

    public static void main( String args[] ) {
        // Recursive method called here
        printNum(10);
    }
}

