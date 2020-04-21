package com.interview.brushups.multithreading.waitnotify;

public class Caller {

    public static void main(String args[]) {
        final Customer c = new Customer();
        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();
        new Thread() {
            public void run() {
                c.deposit(5000);
            }
        }.start();
    }
}
