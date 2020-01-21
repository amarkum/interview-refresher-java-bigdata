package com.interview.brushups.datastructures.linkedlist;

public class Caller {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAtHead("2");
        linkedList.addAtHead("4");
        linkedList.addAtHead("6");
        linkedList.addAtHead("7");
        linkedList.reverse();
        System.out.println(linkedList.size());
        linkedList.printAll();
        linkedList.addAtEnd("15");
        linkedList.addAtEnd("9");
        linkedList.addAtEnd("23");
        linkedList.addAtEnd("2");
        linkedList.createLoop();
        System.out.println(linkedList.detectLoop());


        LinkedListCustom<String> linkedListCustom = new LinkedListCustom<>();
        linkedListCustom.addAtEnd("2");
        linkedListCustom.addAtEnd("4");
        linkedListCustom.addAtEnd("6");
        linkedListCustom.addAtEnd("7");
        linkedListCustom.addAtEnd("17");
        linkedListCustom.addAtEnd("109");
        linkedListCustom.addAtEnd("121");
        linkedListCustom.insertAfter("45","2");
        linkedListCustom.deleteByValue("4");
        System.out.println("Size of List : "+linkedListCustom.size());
        //linkedListCustom.createLoop();
        System.out.println("LinkedList has Loop : "+linkedListCustom.detectLoop());
        System.out.println("Mid element : "+ linkedListCustom.midElement());
        linkedListCustom.printAll();
        System.out.println("Size of LinkedList using Recursion : "+linkedListCustom.lengthOfList(linkedListCustom.headNode));

    }
}
