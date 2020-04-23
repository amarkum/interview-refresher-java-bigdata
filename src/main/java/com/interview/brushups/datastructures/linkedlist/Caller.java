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
        System.out.println("Size of the List : " + linkedList.size());

        //prints the size of the linkedlist using recursion
        System.out.println("Size of the List using Recursion : " + linkedList.recursiveSize());

        //insert at end of the linkedlist
        linkedList.addAtEnd("15");
        linkedList.addAtEnd("9");
        linkedList.addAtEnd("23");
        linkedList.addAtEnd("2");

        //create and detect a loop in the linkedlist
        //linkedList.createLoop();
        System.out.println("Does LinkedList has Loop : " + linkedList.detectLoop());

        LinkedList<String> linkedListTwo = new LinkedList<>();
        linkedListTwo.addAtEnd("2");
        linkedListTwo.addAtEnd("4");
        linkedListTwo.addAtEnd("6");
        linkedListTwo.addAtEnd("7");
        linkedListTwo.addAtEnd("33");

        LinkedList<String> linkedListThree = new LinkedList<>();
        linkedListThree.addAtEnd("91");
        linkedListThree.addAtEnd("88");
        linkedListThree.addAtEnd("53");

        createIntersection(linkedListTwo.headNode, linkedListThree.headNode);
        linkedListThree.printAll();

        if (findIntersection(linkedListTwo.headNode, linkedListThree.headNode) != null) {
            System.out.println("Intersection "+findIntersection(linkedListTwo.headNode, linkedListThree.headNode).data);
        }
    }

    /**
     * method which accepts headNode of Two LinkedList and creates intersection
     * The 3rd Node points to the Second Node of the 2nd Node of First LinkedList as headNode
     *
     * @param headNodeOne
     * @param headNodeTwo
     */
    public static void createIntersection(LinkedList.Node headNodeOne, LinkedList.Node headNodeTwo) {
        headNodeTwo.nextNode.nextNode.nextNode = headNodeOne.nextNode.nextNode;
    }

    /**
     * Method which finds the intersection of the two node.
     * Video Explanation : https://www.youtube.com/watch?v=IpBfg9d4dmQ
     *
     * @param headNodeOne
     * @param headNodeTwo
     */
    public static LinkedList.Node findIntersection(LinkedList.Node headNodeOne, LinkedList.Node headNodeTwo) {
        LinkedList.Node pointerA = headNodeOne;
        LinkedList.Node pointerB = headNodeTwo;

        // If one of the head is null
        if (pointerA == null || pointerB == null)
            return null;

        // Continue until we find intersection node
        while ( pointerA != pointerB) {

            // If A pointer reaches to null, assign headNode of LinkedListTwo
            if (pointerA == null)
               pointerA = headNodeTwo;
            else {
                pointerA = pointerA.nextNode;
            }

            // If B pointer reaches to null, assign headNode of LinkedListOne
            if (pointerB == null)
                pointerB = headNodeOne;
            else {
                pointerB = pointerB.nextNode;
            }
        }

        return pointerA;
    }

}
