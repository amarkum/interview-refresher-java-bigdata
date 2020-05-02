package com.interview.brushups.datastructures.queue;

/**
 *  Queue is another linear data structure that stores the elements in a sequential manner.
 *  Main between Stack and Queue is that instead of using the LIFO principle,
 *  Queue implements the FIFO method, which is short for First in First Out.
 *
 * @param <T>
 */
public class Queue<T> {
    T array[];
    int maxSize;
    int front;
    int back;
    int currentSize;

    Queue(int capacity) {
        array = (T[]) new Object[capacity];
        maxSize = capacity;
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void enqueue(T value) {
        if (isFull()) {
            System.out.println("Queue Full");
            return;
        }
        // Using the MOD operator, resets the position to 0, When there is room to enqueue
        back = (back + 1) % maxSize;
        array[back] = value;
        currentSize++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }
        T value = array[front];

        // Using the MOD operator, resets the position to 0, When there is room to dequeue
        front = (front + 1) % maxSize;
        currentSize--;
        return value;
    }
}
