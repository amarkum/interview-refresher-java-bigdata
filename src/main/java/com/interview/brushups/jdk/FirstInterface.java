package com.interview.brushups.jdk;

@FunctionalInterface
public interface FirstInterface {
    void show();

    default void log() {
        System.out.println("Log method called out from FirstInterface");
    }
}
