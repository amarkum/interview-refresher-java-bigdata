package com.interview.brushups.designpatterns.singleton;

public class ThreadSafeSingleton {

    /**
     *  private instance, so that it can be accessed by only by getInstance() method
     *
     */
    private static ThreadSafeSingleton threadSafeSingleton;

    private ThreadSafeSingleton() {
        System.out.println("threadSafeSingleton Initialized");
    }

    /**
     *  "synchronized" keyword prohibits simultaneous access of the method by threads
     */
    synchronized public static ThreadSafeSingleton getInstance() {
        if (threadSafeSingleton == null) {
            // if instance is null, initialize
            threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }

    public void show(){
        System.out.println(threadSafeSingleton);
    }
}
