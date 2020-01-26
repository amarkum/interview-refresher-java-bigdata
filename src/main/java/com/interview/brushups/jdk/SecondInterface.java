package com.interview.brushups.jdk;

@FunctionalInterface
public interface SecondInterface {
    void hide();
    default void log(){
        System.out.println("Log method called out from SecondInterface");
    }
}
