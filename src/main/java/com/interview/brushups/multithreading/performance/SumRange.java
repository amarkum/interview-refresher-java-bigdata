package com.interview.brushups.multithreading.performance;

public class SumRange {

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    long startRange;
    long endRange;
    long counter = 0;

    public SumRange(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {
        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }
}
