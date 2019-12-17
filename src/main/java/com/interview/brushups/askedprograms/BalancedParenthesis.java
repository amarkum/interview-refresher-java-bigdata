package com.interview.brushups.askedprograms;

import java.util.*;

public class BalancedParenthesis
{
    public static int findBalanced ()
    {
        Scanner scan = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Parenthesis Matching Test\n");

        System.out.println("Enter expression");
        String exp = scan.next();
        int len = exp.length();

        for (int i = 0; i < len; i++)
        {
            char character = exp.charAt(i);
            if (character == '(')
                stack.push(i);
            else if (character == ')')
            {
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return -1;
        }
        return 1;
    }

    public static void main(String args[]){
        System.out.println(findBalanced());
    }
}