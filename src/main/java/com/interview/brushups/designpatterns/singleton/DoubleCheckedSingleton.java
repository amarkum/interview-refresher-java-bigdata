package com.interview.brushups.designpatterns.singleton;

public class DoubleCheckedSingleton {

    private DoubleCheckedSingleton() {
    }

    // we create the variable as volatile, as it tells the JVM to follow order of creating an object
    private static volatile DoubleCheckedSingleton doubleCheckedSingleton;

    public static DoubleCheckedSingleton getInstance() {

        /**
         * we don't want other thread to wait in multi-threaded environment.
         * if singleton instance is not null, give the thread object of the singleton, let the thread execute normally.
         * but if it's null, make the inner block as synchronized as two parallel threads don't create 2 different object.
         * check if the object is null and assign the reference a object in heap.
         */
        if (doubleCheckedSingleton == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (doubleCheckedSingleton == null) {
                    doubleCheckedSingleton = new DoubleCheckedSingleton();
                }
            }
        }
        return doubleCheckedSingleton;
    }
}
