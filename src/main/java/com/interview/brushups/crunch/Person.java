package com.interview.brushups.crunch;

public class Person {

    String name;
    String roll;
    String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person(String name, String roll, String city) {
        this.name = name;
        this.roll = roll;
        this.city = city;
    }
}
