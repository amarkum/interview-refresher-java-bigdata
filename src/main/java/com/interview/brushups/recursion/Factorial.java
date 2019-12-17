package com.interview.brushups.recursion;

public class Factorial {

    public static int factorial(int number){
        if(number == 1){
            return 1;
        }
        else {
            int value =  number * factorial(number - 1);
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));

    }
}
