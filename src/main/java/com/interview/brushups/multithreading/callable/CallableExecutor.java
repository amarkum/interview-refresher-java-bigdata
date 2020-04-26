package com.interview.brushups.multithreading.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.concurrent.ExecutionException;

/**
 * execute(Runnable) does not return anything.
 * However, submit(Callable<T>) returns a Future object
 * Future Objects - allows a way for you to programmatically cancel the running thread later.
 * It returns as get the V (Generics) that is returned when the Callable completes.
 */
public class CallableExecutor {

    public static void main(String args[]) {
        Callable<String> callable = () -> "Return a String in Future Object<V>";

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Completion of Callable object will return Future Object of Type <V> defined earlier
        Future<String> future = executorService.submit(callable);

        // Check if Execution is done, using isDone() method
        if (future.isDone()) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
