package com.interview.brushups.exceptions;

import java.util.Scanner;

public class Caller {
    public static void main(String[] args) {
        int value;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number");
        value = Integer.parseInt(scanner.nextLine());
        if (value % 2 == 0) {
            System.out.println("Even Number");
        } else {
            throw new OddNumberException("Odd Number Passed");
        }

    }
}
