package com.interview.brushups.multithreading.producerconsumer;

public class Caller {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q = new BlockingQueue<>(6);


        Thread t1 = new Thread(() -> {

            for (int i = 0; i<50; i++){
                try {
                    q.enqueue(new Integer(i));
                    System.out.println("Thread 1 enqueued <- " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<25; i++){
                try {
                    System.out.println("Thread 2 dequeued -> " + q.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            for(int i=0; i<25; i++){
                try {
                    System.out.println("Thread 3 dequeued ->  " + q.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        Thread.sleep(4000);
        t2.start();

//        t2.join();

        t3.start();
//        t1.join();
//        t3.join();
    }
}
