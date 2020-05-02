package com.interview.brushups.datastructures.stack;

/**
 * Stack is a container, in which we can add items and remove them.
 * Only the top of this container is open, so the item we put in first will be taken out last,
 * The items we put in last will be taken out first. This is called the last in first out (LIFO) ordering.
 *
 * @param <T>
 */
public class Stack<T> {
    int top;
    int maxSize;
    T arr[];

    Stack(int capacity) {
        maxSize = capacity;
        top = -1;
        arr = (T[]) new Object[maxSize];
    }

    public int getCapacity() {
        return maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull(){
        if(top == maxSize){
            return true;
        }
        return false;
    }

    public T getTop() {
        if (isEmpty()) {
            return null;
        }
        return arr[top];
    }
}
