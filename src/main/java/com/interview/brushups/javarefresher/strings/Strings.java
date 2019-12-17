package com.interview.brushups.javarefresher.strings;

/**
 * Java program to demonstrate difference between String, StringBuilder and StringBuffer
 */

public class Strings {

    /**
     * The static block is executed first.
     */
    static {
        System.out.println("Hello");
    }

    // Concatenates to String
    public static void concat1(String s1) {
        //even though we store the s1 with new value.
        //it won't change
        s1 = s1 + "+Append";
    }

    // Concatenates to StringBuilder
    public static void concat2(StringBuilder s2) {
        s2.append("+Append");
    }

    // Concatenates to StringBuffer
    public static void concat3(StringBuffer s3) {
        s3.append("+Append");
    }

    public static void main(String[] args) {

        String string1 = new String("abc");
        String string2 = new String("abc");
        System.out.println(string1 == string2);

        System.out.println(System.identityHashCode(string1));
        System.out.println(System.identityHashCode(string2));


        String s1 = "TestString";
        concat1(s1);  // s1 is not changed, as a copy of it is passed to method
        System.out.println("String: " + s1);

        StringBuilder s2 = new StringBuilder("TestString");
        concat2(s2); // s2 is changed
        System.out.println("StringBuilder: " + s2);

        StringBuffer s3 = new StringBuffer("TestString");
        concat3(s3); // s3 is changed
        System.out.println("StringBuffer: " + s3);
    }
}


