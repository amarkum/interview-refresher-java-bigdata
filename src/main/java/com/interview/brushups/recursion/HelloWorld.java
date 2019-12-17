package com.interview.brushups.recursion;

public class HelloWorld {

    static int counter = 0;

    static void print() {
        counter++;//print method will increment the counter.
        if (counter <= 5) {
            System.out.println("Hello World " + counter);
            print(); //call the print() method, if the value is <= 5.
        }
    }

    public static void main(String[] args) {
        print();
    }
}
