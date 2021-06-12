package com.interview.brushups.askedprograms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Accolite, Tavant - Find first non-repeating character in a String
 */
public class NonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "abcadc";

        HashMap<Character, Integer> charMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!charMap.containsKey(s.charAt(i))) {
                charMap.put(s.charAt(i), 1);
            } else {
                int count = charMap.get(s.charAt(i));
                charMap.put(s.charAt(i), ++count);
            }
        }

        for (Map.Entry entry : charMap.entrySet()) {
            if ((Integer) entry.getValue() == 1) {
                System.out.println(entry.getKey());
                System.exit(0);
            }
        }
    }
}
