package com.interview.brushups.designpatterns.singleton;

public class LazySingleton {

    /**
     * It just creates the memory reference of the class.
     * The object is initialized and allocated heap space when it is required.
     */
    private static LazySingleton lazySingleton;

    /**
     * we must declare constructor as private to prohibit creating object of it.
     */
    private LazySingleton() {
    }

    //method to return instance of class
    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            // if instance is null, initialize
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
