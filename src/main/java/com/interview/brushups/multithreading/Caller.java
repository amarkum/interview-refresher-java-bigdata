package com.interview.brushups.multithreading;

public class Caller {
    public static void main(String[] args) {

        HelloThread threadOne = new HelloThread();
        HelloThread threadTwo = new HelloThread();
        HelloThread threadThree = new HelloThread();
        threadOne.setName(" #1");
        threadTwo.setName(" #2");
        threadThree.setName(" #3");
        threadOne.start();
        threadTwo.start();
        threadThree.start();

    }
}
