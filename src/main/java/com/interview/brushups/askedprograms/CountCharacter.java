package com.interview.brushups.askedprograms;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharacter {

    /**
     * Interview Company - Nokia
     * Given a String which has character in repeated sequence.
     * Output a String which contains how many times a character has been repeated.
     * @param args
     */
    public static void main(String[] args) {

        String word = "aazzzBBB";
        String output = "";

        Map < Character, Integer > map = new LinkedHashMap < > ();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (map.containsKey(c)) {
                int cnt = map.get(c);
                map.put(c, ++cnt);
            } else {
                map.put(c, 1);
            }
        }

        for (Map.Entry entry: map.entrySet()) {
            output = output + entry.getKey() + entry.getValue();
        }
        System.out.println(output);
    }
}