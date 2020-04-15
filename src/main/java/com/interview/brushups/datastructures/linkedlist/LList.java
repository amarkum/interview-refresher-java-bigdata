package com.interview.brushups.datastructures.linkedlist;

public class LList<T> {

    public int size;
    Node headNode;

    public LList() {
        size = 0;
        headNode = null;
    }

    public boolean isEmpty() {

        if (headNode == null) {
            return true;
        }
        return false;
    }

    public void addAtHead(T data) {
        Node tempNode = new Node();
        tempNode.data = data;
        tempNode.nextNode = headNode;
        headNode = tempNode;
        size++;
    }

    public void printAll() {
        System.out.println();
        Node tempNode = headNode;
        while (tempNode.nextNode != null) {
            System.out.print(tempNode.data+" ");
            tempNode = tempNode.nextNode;
        }
        System.out.print(tempNode.data);
    }

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

    public void midToLast() {

        Node lastNode = headNode;
        Node midNode = headNode;

        if (headNode != null)
        {
            while ( lastNode != null && lastNode.nextNode != null )
            {
                lastNode = lastNode.nextNode.nextNode;
                midNode = midNode.nextNode;
            }
        }

        while ( midNode.nextNode != null) {
            System.out.print(midNode.data);
            midNode = midNode.nextNode;
        }
        System.out.print(midNode.data);
    }
}
