package com.interview.brushups.datastructures.linkedlist;

/**
 * Commonly asked LinkedList Interview Question
 * 1. Reverse a linked list
 * 2. Detect loop in a linked list
 * 3. Return Nth node from the end in a linked list
 * 4. Remove duplicates from a linked list
 */
public class LinkedList<T> {

    // size should be public, as it needs to accessed easily
    public int size;
    // headNode is the node which points to all other node
    Node headNode;
    public LinkedList() {
        size = 0;
        headNode = null;
    }

    /**
     * @return true or false
     * Checks if the LinkedList is empty.
     */
    public boolean isEmpty() {
        if (headNode == null) {
            return true;
        }
        return false;
    }

    /**
     * Add a Node at the head.
     */
    public void addAtHead(T data) {
        //Create a tempNode, tempNode.data will refer to passed data
        Node tempNode = new Node();
        tempNode.data = data;

        //tempNode.nextNode will point to headNode
        tempNode.nextNode = headNode;

        //re-assign the headNode to tempNode
        headNode = tempNode;

        //increment the size to 1
        size++;
    }

    /**
     * Add elements at the end of the LinkedList
     *
     * @param data
     */
    public void addAtEnd(T data) {

        //If the list is empty add it using addAtHead()
        if (isEmpty()) {
            addAtHead(data);
            return;
        }

        //Create a temp node
        Node tempNode = new Node();
        tempNode.data = data;
        tempNode.nextNode = null;

        //Let the last node reference to headNode
        Node lastNode = headNode;

        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
        }

        lastNode.nextNode = tempNode;
        size++;
    }

    /**
     * print all the element of the linkedList.
     */
    public void printAll() {
        while (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node tempNode = headNode;
        while (tempNode != null) { // tempNode becomes null, will not enter in the loop.
            System.out.println(tempNode.data);
            tempNode = tempNode.nextNode;
        }
    }

    /**
     * Searches if a given data exists in the LinkedList.
     * returns true if yes or false if it does not.
     *
     * @param data
     * @return
     */
    public boolean searchNode(T data) {
        Node tempNode = headNode;
        while (tempNode != null) {
            if (tempNode.data.equals(data)) {
                return true;
            }
            tempNode = tempNode.nextNode;
        }
        return false;
    }

    /**
     * @param data
     * @param previous
     */
    public void insertAfter(T data, T previous) {

        Node addUpNode = new Node();
        addUpNode.data = data;

        Node searchedNode = headNode;
        while (searchedNode != null) {
            if (searchedNode.data.equals(previous)) {
                addUpNode.nextNode = searchedNode.nextNode;
                searchedNode.nextNode = addUpNode;
                size++;
                return;
            }
            searchedNode = searchedNode.nextNode;
        }
    }

    /**
     * Returns the size of the LinkedList.
     *
     * @return
     */
    public int size() {
        return size;
    }

    private void deleteAtHead() {
        if (isEmpty()) {
            return;
        }
        headNode = headNode.nextNode;
        size--;
    }

    /**
     * Deletes a node by value
     *
     * @param data
     */
    public void deleteByValue(T data) {

        if (isEmpty()) {
            return;
        }
        Node tempNode = headNode;
        Node prev = null;

        if (tempNode.data.equals(data)) {
            deleteAtHead();
            return;
        }

        while (tempNode != null) {
            if (tempNode.data.equals(data)) {
                prev.nextNode = tempNode.nextNode;
                size--;
            }
            //used to save the previous pointer, and then go to the another pointer.
            prev = tempNode;
            tempNode = tempNode.nextNode;
        }
    }

    /**
     * This will reverse the LinkedList
     */
    public void reverse() {

        //previous node, to keep track of the previous node, to set the pointer to previous node
        Node previous = null;
        //cuurentNode be the headNode
        Node current = headNode;
        //to save the state of the next node, as we assign the value of current.nextNode to precious node.
        Node next = null;

        while (current != null) {
            //save the upcoming node's address to next
            next = current.nextNode;
            //make the current node point to previous node, initially it would point to null, and gradually it will move one step ahead
            current.nextNode = previous;
            //make a move of the previous node to the current node.
            previous = current;
            //let the current node be, now to the nextNode of the current Node.
            current = next;
        }
        //after we have done all the traversing, set the headNode as the previous node.
        headNode = previous;

    }

    /**
     * Creates a loop in the LinkedList.
     */
    public void createLoop() {
        Node tempNode = headNode;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = headNode;
    }

    /**
     * detect a loop in the LinkedList.
     */
    public boolean detectLoop() {
        Node slow = headNode;
        Node fast = headNode;

        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method which can find the middle of the element.
     *
     * @param <T>
     * @return
     */
    public <T> Object midElement() {
        Node slow = headNode;
        Node fast = headNode;

        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return slow.data;
    }

    /* Returns count of nodes in linked list */
    public int lengthOfList(Node headNode) {
        // Base case
        if (headNode == null) {
            return 0;
        }
        // Recursive case
        else {
            return 1 + lengthOfList(headNode.nextNode);
        }
    }

    /**
     * Method which prints data from middle to  last.
     *
     * @param <T>
     * @return
     */
    public void midToLast() {

        Node lastNode = headNode;
        Node midNode = headNode;

        if (headNode != null) {
            while (lastNode != null && lastNode.nextNode != null) {
                lastNode = lastNode.nextNode.nextNode;
                midNode = midNode.nextNode;
            }
        }

        while (midNode.nextNode != null) {
            System.out.print(midNode.data);
            midNode = midNode.nextNode;
        }
        System.out.print(midNode.data);
    }

    /**
     * @param <T> All the class and attribute should be public.
     */
    public class Node<T> {
        public T data;
        public Node nextNode;
    }
}