package com.interview.brushups.javacollection;

import java.util.*;

public class CollectionDataStructure {
    public static void main(String[] args) {

        /**
         * List, Queue, Set - implements <Collection> interface - which implements <Iterable> interface
         * List - ArrayList, LinkedList, Vector, Stack
         * Queue - PriorityQueue, ArrayDeque implements Deque
         * Set - HashSet, LinkedHashSet , TreeSet implements SortedSet
         */

        /**
         * Popular Method of Collection Interface
         *
         *  iterator()
         *  size()
         *  add()
         *  remove
         *  toArray()
         *  stream()
         *
         */

        //  List

        //1. LinkedList
        System.out.println("\nList - ArrayList \n");
        /**
         * ArrayList -
         * The ArrayList class implements the List interface.
         * It uses a dynamic array to store the duplicate element of different data types.
         * The ArrayList class maintains the insertion order and is non-synchronized.
         * The elements stored in the ArrayList class can be randomly accessed
         */
        ArrayList<String> gameList = new ArrayList<String>();//Creating arrayList
        gameList.add("Cricket");
        gameList.add("FootBall");
        gameList.add("Rugby");
        gameList.add("Tennis");

        Iterator arrayListIterator = gameList.iterator();
        while (arrayListIterator.hasNext()) {
            System.out.println(arrayListIterator.next());
        }

        //2. LinkedList
        System.out.println("\nList - LinkedList \n");
        /**
         * LinkedList -
         * LinkedList implements the Collection interface.It uses a doubly linked list internally to store the elements.
         * It can store the duplicate elements. It maintains the insertion order and is not synchronized.
         * In LinkedList, the manipulation is fast because no shifting is required.
         */
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Table");
        linkedList.add("Fan");
        linkedList.add("Lamp");
        linkedList.add("Bed");

        Iterator<String> linkedListIterator = linkedList.iterator();
        while (linkedListIterator.hasNext()) {
            System.out.println(linkedListIterator.next());
        }

        //3. Vector
        System.out.println("\nList - Vector \n");
        /**
         * Vector -
         * Vector uses a dynamic array to store the data elements. It is similar to ArrayList.
         * However, It is synchronized and contains many methods that are not the part of Collection framework.
         */
        Vector<String> vector = new Vector<String>();
        vector.add("Amar");
        vector.add("Sneha");
        vector.add("Shailaja");
        vector.add("Sooraj");
        Iterator<String> vectorIterator = vector.iterator();
        while (vectorIterator.hasNext()) {
            System.out.println(vectorIterator.next());
        }

        //4. Stack
        System.out.println("\nList - Stack \n");
        /**
         * Stack -
         * The stack is the subclass of Vector. It implements the last-in-first-out data structure, i.e., Stack.
         * The stack contains all of the methods of Vector class.
         * It also provides methods e.g  push(), peek(), push(object o), which defines its properties.
         */
        Stack<String> stack = new Stack<String>();
        stack.push("IQIVIA");
        stack.push("Epsilon");
        stack.push("Cerner");
        stack.push("OpenText");
        stack.pop();
        Iterator<String> stackIterator = stack.iterator();
        while (stackIterator.hasNext()) {
            System.out.println(stackIterator.next());
        }

        // QUEUE

        //1. Priority Queue
        System.out.println("\nQUEUE - Priority Queue \n");
        /**
         * Priority Queue -
         * The PriorityQueue class implements the Queue interface.
         * It holds the elements or objects which are to be processed by their priorities.
         * PriorityQueue doesn't allow null values to be stored in the queue.
         */
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        priorityQueue.add("Amar Kumar");
        priorityQueue.add("Sooraj Jain");
        priorityQueue.add("V Sushma");
        priorityQueue.add("Vedanth");
        priorityQueue.add("Richie V");
        priorityQueue.add("Abhishek Singh");

        /**
         * The element() -  method of Queue Interface returns the element at the front the container.
         * It does not deletes the element in the container. This method returns the head of the queue.
         * This method differs from peek() only in that it throws an Exception if this queue is empty
         */
        System.out.println("head:" + priorityQueue.element());

        /**
         * The peek() -  method of Queue Interface returns the element at the front the container.
         * It does not deletes the element in the container. This method returns the head of the queue.
         * The method does not throws an exception when the Queue is empty, it returns null instead.
         */
        System.out.println("head:" + priorityQueue.peek());
        System.out.println("\nIterating the queue elements:");

        Iterator queueIterator = priorityQueue.iterator();
        while (queueIterator.hasNext()) {
            System.out.println(queueIterator.next());
        }

        /**
         * The remove() - method of Queue Interface returns and removes the element at the front the container.
         * It deletes the head of the container. The method throws an NoSuchElementException when the Queue is empty.
         */
        priorityQueue.remove();
        System.out.println("\nAfter removing one element:");
        Iterator<String> queueIterator1 = priorityQueue.iterator();
        while (queueIterator1.hasNext()) {
            System.out.println(queueIterator1.next());
        }

        /**
         * The poll() method of Queue Interface returns and removes the element at the front the container.
         * It deletes the element in the container.
         * The method does not throws an exception when the Queue is empty, it returns null instead.
         */
        priorityQueue.poll();
        System.out.println("\nAfter removing one element:");
        Iterator<String> queueIterator2 = priorityQueue.iterator();
        while (queueIterator2.hasNext()) {
            System.out.println(queueIterator2.next());
        }

        //2. Array Dequeue implements Deque implements Queue
        System.out.println("\nQUEUE - Array Dequeue implements Deque\n");
        /**
         * Array Dequeue -
         * ArrayDeque class implements the Deque interface. It facilitates us to use the Deque.
         * Unlike queue, we can add or delete the elements from both the ends.
         * ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions..
         */
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Gautam");
        deque.add("Karan");
        deque.add("Ajay");

        for (String name : deque) {
            System.out.println(name);
        }

        // SET

        //1. HashSet
        System.out.println("\nSET - HashSet \n");

        /** HashSet -
         * HashSet class implements Set Interface. It represents the collection that uses a hash table for storage.
         * Hashing is used to store the elements in the HashSet. It contains unique items.
         */
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Amar");
        hashSet.add("Shailaja");
        hashSet.add("Amar");
        hashSet.add("Puja");
        hashSet.add("Sneha");
        hashSet.add("Sooraj");
        hashSet.add("Dixit");

        Iterator<String> hashSetIterator = hashSet.iterator();
        while (hashSetIterator.hasNext()) {
            System.out.println(hashSetIterator.next());
        }

        //2. LinkedHashSet
        System.out.println("\nSET - LinkedHashSet \n");

        /** LinkedHashSet -
         * LinkedHashSet class represents the LinkedList implementation of Set Interface.
         * It extends the HashSet class and implements Set interface. Like HashSet, It also contains unique elements.
         * It maintains the insertion order and permits null elements.
         */
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("Amar");
        linkedHashSet.add("Shailaja");
        linkedHashSet.add("Amar");
        linkedHashSet.add("Puja");
        linkedHashSet.add(null);
        linkedHashSet.add("Sneha");
        linkedHashSet.add("Sooraj");
        linkedHashSet.add("Dixit");
        Iterator<String> linkedHashSetIterator = linkedHashSet.iterator();
        while (linkedHashSetIterator.hasNext()) {
            System.out.println(linkedHashSetIterator.next());
        }

        //2. TreeSet
        System.out.println("\nSET - TreeSet \n");

        /** TreeSet -
         *  TreeSet class implements the SortedSet implement Set interface that uses a tree for storage.
         *  Like HashSet, TreeSet also contains unique elements.
         *  However, the access and retrieval time of TreeSet is quite fast.
         *  The elements in TreeSet stored in ascending order.
         */
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("Ravi");
        treeSet.add("Vijay");
        treeSet.add("Ravi");
        treeSet.add("Ajay");
        treeSet.add("Sneha");
        treeSet.add("Sooraj");
        treeSet.add("Dixit");

        Iterator<String> treeSetIterator = treeSet.iterator();
        while (treeSetIterator.hasNext()) {
            System.out.println(treeSetIterator.next());
        }
    }
}
