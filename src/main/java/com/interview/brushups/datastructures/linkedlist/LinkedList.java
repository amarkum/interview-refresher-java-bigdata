package com.interview.brushups.datastructures.linkedlist;

public class LinkedList<T> {

    public LinkedList() {
        size = 0;
        headNode = null;
    }

    public int size;
    Node headNode;

    public class Node {
        public T data;
        public Node nextNode;
    }

    public boolean isEmpty() {
        if (headNode == null) {
            return true;
        }
        return false;
    }

    /**
     * adds the data to the head of the LinkedList
     * @param data input data to be added to the LinkedList
     */
    public void addAtHead(T data) {
        Node tempNode = new Node();
        tempNode.data = data;

        tempNode.nextNode = headNode;
        headNode = tempNode;
        size++;
    }

    /**
     * Print all the elements of the LinkedList
     */
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Empty LinkedList");
            return;
        }
        Node tempNode = headNode;
        while (tempNode.nextNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.nextNode;
        }
        System.out.println(tempNode.data);
    }

    /**
     * returns the size of the LinkedList
     * @return size of the LinkedList
     */
    public int size() {
        return this.size;
    }

    /**
     * adds the data to the end of the LinkedList
     * @param data input data
     */
    public void addAtEnd(T data) {
        if (isEmpty()) {
            addAtHead(data);
            return;
        }
        Node lastNode = headNode;
        Node tempNode = new Node();
        tempNode.data = data;
        tempNode.nextNode = null;
        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
        }
        lastNode.nextNode = tempNode;
        size++;
    }

    /**
     * Creates a loop in the LinkedList
     */
    public void createLoop() {
        Node tempNode = headNode;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = headNode;
    }

    /**
     *
     * @return returns true if LinkedList has a loop else returns false
     */
    public boolean detectLoop() {
        Node slow = headNode;
        Node fast = headNode;

        while(slow != null && fast !=null && fast.nextNode != null){
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * reverses a LinkedList
     */
    public void reverse(){
        Node previous = null; //To keep track of the previous element, will be used in swapping links
        Node current = headNode; //firstElement
        Node next = null;

        //While Traversing the list, swap links
        while (current != null) {
         next = current.nextNode; //stash the next element of the node
         current.nextNode = previous; //current node's nextNode points to Previous node
         previous = current; //previous reference takes current reference
         current = next; // make next node as current
        }
        //Linking Head Node with the new First Element
        headNode = previous;
    }
}
