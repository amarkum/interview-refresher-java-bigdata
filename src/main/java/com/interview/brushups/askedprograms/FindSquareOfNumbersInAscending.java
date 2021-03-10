package com.interview.brushups.askedprograms;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Interview Company - 24/7
 * Find square of numbers in a ascending order of the number
 */
public class FindSquareOfNumbersInAscending {
    public static void main(String[] args) {
        int numArray[] = {-7, -5, 2, 5, 7, 8, 9};
        LinkedList<Integer> numbers = new LinkedList<>();

        for (int number : numArray) {
            numbers.add(Math.abs(number));
        }
        Collections.sort(numbers);
        for (int n : numbers) {
            System.out.println(Math.pow(n, 2));
        }
    }
}

