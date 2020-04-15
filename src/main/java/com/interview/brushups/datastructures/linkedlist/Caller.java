package com.interview.brushups.datastructures.linkedlist;

public class Caller {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAtHead("2");
        linkedList.addAtHead("4");
        linkedList.addAtHead("6");
        linkedList.addAtHead("7");

        //delete by value from linkedlist
        linkedList.deleteByValue("4");

        //print from middle to last
        linkedList.midToLast();

        //reverse the linkedlist
        linkedList.reverse();

        //prints the size of the linkedlist
        System.out.println(linkedList.size());

        //print all elements of the linkedlist
        linkedList.printAll();

        //insert at end of the linkedlist
        linkedList.addAtEnd("15");
        linkedList.addAtEnd("9");
        linkedList.addAtEnd("23");
        linkedList.addAtEnd("2");

        //create and detect a loop in the linkedlist
        linkedList.createLoop();
        System.out.println(linkedList.detectLoop());
    }
}
