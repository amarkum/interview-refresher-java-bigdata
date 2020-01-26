package com.interview.brushups.jdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JDK8InterfaceFeature implements FirstInterface,SecondInterface {

    public static void main(String[] args) {

        // 1. Functional Interface

        /**
         * If the interface has only single method, it can be instantiated right away
         */
        Executable e1 = new Executable() {
            @Override
            public void execute() {
                System.out.println("Regular Implementation of Function Interface");
            }
        };

        //call execute method, with e1 will call the method currently implemented.
        e1.execute();

        /**
         * The implementation is give out by Lambda Expression.
         */
        Executable e2 = () -> System.out.println("Lambda Expression implementation of Functional Interface");

        //Now the e2 has the implementation of execute() method, you can call it.
        e2.execute();


        // 2. forEach() method in Collection

        //creating a sample Collection - ArrayList
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<10; i++)
            myList.add(i);

        /**
         *  traversing using Iterator - before Java 1.8
         *  Though using iterator we can make changes to the ArrayList
         */
        Iterator<Integer> iterator = myList.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println(i);
        }

        /**
         *  traversing using forEach - Java 1.8 Onwards
         *  Though it creates an implicit iterator, it doesn't allow to perform or edit value of collection
         */
        myList.forEach(x -> System.out.println(x));


    }

    //3. Default and Static method

    @Override
    public void show() {
        System.out.println("Show");
    }

    @Override
    public void hide() {
        System.out.println("Hide");
    }

    /**
     * Apart from Implementing method, which needs to be which is present in Interface
     * We must provide implementation of default method which exists in both interface.
     *
     * Compiler Error - Which Stops from Diamond Problem.
     * com.interview.brushups.jdk.JDK8Feature inherits unrelated defaults for log() from
     * types com.interview.brushups.jdk.FirstInterface and com.interview.brushups.jdk.SecondInterface
     */
    @Override
    public void log() {
        System.out.println("Log");
    }
}





