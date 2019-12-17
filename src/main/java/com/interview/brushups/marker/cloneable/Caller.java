package com.interview.brushups.marker.cloneable;

public class Caller {

    /**
     *
     * We can use clone() method on HashMap, HashSet, TreeSet, HashTable, Stack, IdentityHashMap
     */
    public static void main(String args[]) {
        try {
            Student s1 = new Student(101, "amit");
            Student s2 = (Student) s1.clone();

            System.out.println(s1);
            System.out.println(s2);

            System.out.println(s1.getRoll() + " " + s1.getName());
            System.out.println(s2.getRoll() + " " + s2.getName());

        } catch (CloneNotSupportedException c) {
            System.out.println(c);
        }

    }
}
