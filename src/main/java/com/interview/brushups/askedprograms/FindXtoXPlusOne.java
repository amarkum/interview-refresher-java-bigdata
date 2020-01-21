package com.interview.brushups.askedprograms;

import java.util.Scanner;

/**
 * Codility - given two integers A and B, returns the number of integers from the range [A..B]
 */
public class FindXtoXPlusOne {

        public static int solution(int A, int B) {
            int counter = 0;
            int value = 0;
            int x = 1;

            while(value < B){
                value = x * (x+1); //3 , 6, 12, 15, 20, 30
                x++;

                if(value >= A && value <= B){
                    System.out.println(x+" * "+(x+1)+" = "+value);
                    counter++;
                }
            }
            return counter;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Number 1");
            int numberA = scanner.nextInt();
            System.out.println("Enter Number 2");
            int numberB = scanner.nextInt();
           System.out.println("Total occurrence for X*(X+1) for range "+numberA+" & "+numberB+" is : "+solution(numberA,numberB));
        }
    }



