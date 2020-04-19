package com.interview.brushups.datastructures.linkedlist;

public class Caller {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAtEnd("2");
        linkedList.addAtEnd("4");
        linkedList.addAtEnd("6");
        linkedList.addAtEnd("7");

        //delete by value from linkedlist
        linkedList.deleteByValue("4");

        //print all elements of the linkedlist
        System.out.println("All Elements of LinkedList");
        linkedList.printAll();

        //print from middle to last
        System.out.println("Middle to Last of LinkedList");
        linkedList.midToLast();

        //reverse the linkedlist
        linkedList.reverse();
        System.out.println("LinkedList Reversed");

        //prints the size of the linkedlist
        System.out.println("Size of the List : "+linkedList.size());

        //prints the size of the linkedlist using recursion
        System.out.println("Size of the List using Recursion : "+linkedList.recursiveSize());

        //insert at end of the linkedlist
        linkedList.addAtEnd("15");
        linkedList.addAtEnd("9");
        linkedList.addAtEnd("23");
        linkedList.addAtEnd("2");

        //create and detect a loop in the linkedlist
        linkedList.createLoop();
        System.out.println("Does LinkedList has Loop : "+linkedList.detectLoop());
    }
}
