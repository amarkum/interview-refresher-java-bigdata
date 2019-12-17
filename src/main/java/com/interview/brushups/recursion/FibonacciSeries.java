package com.interview.brushups.recursion;

import java.util.Scanner;

public class FibonacciSeries {

    static int previous = 0;
    static int next = 1;
    static int temp = 0;

    public static void fibonacci(int number) {

        if (number > 0) {
            System.out.print(previous + " ");
            temp = previous + next; // temp will sum up the two values
            previous = next; // previous now holds the next value
            next = temp; // next will hold the sum up values for next run.
            fibonacci(number-1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int upTONumber = scan.nextInt();
        fibonacci(upTONumber);
    }
}
