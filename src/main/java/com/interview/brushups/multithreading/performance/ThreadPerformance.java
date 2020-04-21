package com.interview.brushups.multithreading.performance;

import java.util.HashMap;
import java.util.HashSet;

class ThreadPerformance {

    static long MAX_NUM = Integer.MAX_VALUE;

    public static void main(String args[]) throws InterruptedException {
        oneThread();
        twoThreads();
    }

    public static void twoThreads() throws InterruptedException {

        long start = System.currentTimeMillis();
        SumRange s1 = new SumRange(1, MAX_NUM / 2);
        SumRange s2 = new SumRange(1 + (MAX_NUM / 2), MAX_NUM);

        Thread t1 = new Thread(() -> {
            s1.add();
        });

        Thread t2 = new Thread(() -> {
            s2.add();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long finalCount = s1.getCounter() + s2.getCounter();
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
    }

    public static void oneThread() {

        long start = System.currentTimeMillis();
        SumRange s = new SumRange(1, MAX_NUM);
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.getCounter() + " took " + (end - start));
    }

}



