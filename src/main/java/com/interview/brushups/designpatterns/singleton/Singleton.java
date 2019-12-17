package com.interview.brushups.designpatterns.singleton;

public class Singleton {

    /**
     * Generic Singleton implementation.
     * This creates a new Instance of Singleton object, when the JVM is run.
     * static and final makes it immutable.
     */
    private static final Singleton singleton = new Singleton();

    /**
     * creating constructor as private makes prohibits creating new object of the class.
     */
    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }

    /**
     * prints the object's hex value.
     */
    public void show(){
        System.out.println(singleton);
    }

}
