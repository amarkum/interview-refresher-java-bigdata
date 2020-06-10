package com.interview.brushups.askedprograms;

import java.util.ArrayList;
import java.util.List;

/**
 * Accolite - Find all Missing character in order missing from the String
 */
public class FindPanagram {
    public static void main(String[] args) {
        String s = "The quick brown fox jumps";

        List<Character> asciiList = new ArrayList<Character>();

        for (int i = 97; i <= 122; i++) {
            asciiList.add((char) i);
        }

        for (int i = 0; i < s.length(); i++) {
            try {
                int index = asciiList.indexOf(s.charAt(i));
                asciiList.remove(index);
            } catch (Exception e) {
            }
        }

        for (char ch : asciiList) {
            System.out.print(ch);
        }
    }
}
