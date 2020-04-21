package com.interview.brushups.multithreading.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        /**
         * This will create a Thread Pool of 5
         * Any work will be handled 5 this set of 5 thread only
         * pass the thread to the ExecutorService instance for Execution
         * Threads will be re-used and will perform the task.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 20; i++) {
            Runnable worker = new WorkerThread("Task #"+i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {   }

        System.out.println("All Task has been completed");
    }
}