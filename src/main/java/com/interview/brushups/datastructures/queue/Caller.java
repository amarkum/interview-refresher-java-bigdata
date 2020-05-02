package com.interview.brushups.datastructures.queue;

public class Caller {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>(3);
        queue.enqueue("Football");
        queue.enqueue("Cricket");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Tennis");
        queue.dequeue();
        queue.enqueue("Rugby");
        queue.dequeue();
    }
}
