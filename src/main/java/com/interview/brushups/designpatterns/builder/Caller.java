package com.interview.brushups.designpatterns.builder;

public class Caller {

    public static void main(String[] args) {
        Person person = new Person.PersonBuilder(1, "Amar")
                .setPhone(910860000)
                .setAddress("BLR")
                .build();
        System.out.println(person.getName());
    }
}
