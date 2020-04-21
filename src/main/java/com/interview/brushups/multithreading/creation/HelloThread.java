package com.interview.brushups.multithreading.creation;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello"+Thread.currentThread().getName());
    }
}
