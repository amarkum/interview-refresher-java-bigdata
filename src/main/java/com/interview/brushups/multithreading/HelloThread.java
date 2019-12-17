package com.interview.brushups.multithreading;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello"+Thread.currentThread().getName());
    }
}
