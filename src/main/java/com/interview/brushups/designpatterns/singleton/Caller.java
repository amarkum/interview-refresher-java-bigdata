package com.interview.brushups.designpatterns.singleton;

public class Caller {
    public static void main(String[] args) throws InterruptedException {
        //calling the getInstance() of Singleton class returns the same heap object.
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());

        //calling the getInstance() of LazySingleton class returns the same heap object.
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());

        //ThreadSafe Singleton has been called by two threads.
        //It results in returning only instance of the thread, because we have used synchronized block.
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ThreadSafeSingleton.getInstance());
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ThreadSafeSingleton.getInstance());
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}
