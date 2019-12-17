package com.interview.brushups.marker.cloneable;

public class Student implements Cloneable {

    private int roll;
    private String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}