package com.interview.brushups.multithreading.executorservice;

class WorkerThread implements Runnable {
    private String taskName;
    public WorkerThread(String number){
        this.taskName=number;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+taskName+" Started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+taskName+" Ended");
    }

}