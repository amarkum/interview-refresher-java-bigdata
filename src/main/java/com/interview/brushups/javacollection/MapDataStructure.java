package com.interview.brushups.javacollection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDataStructure {
    public static void main(String[] args) {

        /**
         * MAP -
         * A map contains values on the basis of key, i.e. key and value pair.
         * Each key and value pair is known as an entry.
         * A Map contains UNIQUE keys. (HashMap and LinkedHashMap allow null keys and values)
         * A Map is useful if you have to search, update or delete elements on the basis of a key.
         * A Map can't be traversed, so you need to convert it into Set using keySet() or entrySet() method.
         * entrySet() - method is used to store all the <K,V> pair as the set of <K,V>'s
         * entrySet() returns Set<Map.Entry>
         *
         */


        /**
         * 1. HashMap -	HashMap is the implementation of Map, but it doesn't maintain any order.
         * 2. LinkedHashMap - LinkedHashMap is implementation of Map which inherits HashMap class. It maintains insertion order.
         * 3. TreeMap - TreeMap is the implementation of Map and SortedMap. It maintains ascending order.
         */

        // 1. HashMap

        System.out.println("\nHashMap - No insertion order maintained.\n");
        /**
         * HashMap - It doesn't maintain insertion Order
         */
        Map<Integer,String> hashMap=new HashMap<Integer,String>();
        hashMap.put(54561,"Amar Kumar");
        hashMap.put(53115,"Shailaja Kumari");
        hashMap.put(51234,"Sneha S");
        hashMap.put(55323,"Dixit");

        for(Map.Entry entry : hashMap.entrySet()){
            System.out.println("Employee ID : "+entry.getKey()+" | Name : "+entry.getValue());
        }

        // 2. LinkedHashMap

        System.out.println("\nLinkedHashMap - Insertion Order retained.\n");
        /**
         * LinkedHashMap - LinkedHashMap is implementation of Map which inherits HashMap class.
         * It maintains insertion order.
         */
        Map<Integer,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put(54561,"Amar Kumar");
        linkedHashMap.put(53115,"Shailaja Kumari");
        linkedHashMap.put(51234, "Sneha S");
        linkedHashMap.put(55323,"Dixit");

        for(Map.Entry entry : linkedHashMap.entrySet()){
            System.out.println("Employee ID : "+entry.getKey()+" | Name : "+entry.getValue());
        }

        // 3. TreeMap

        System.out.println("\nTreeMap - Ascending Order based on the key.\n");
        /**
         * TreeMap - TreeMap is the implementation of Map and SortedMap. It maintains ascending order.
         */
        Map<Integer,String> treeMap=new TreeMap<Integer,String>();
        treeMap.put(54561,"Amar Kumar");
        treeMap.put(53115,"Shailaja Kumari");
        treeMap.put(51234,"Sneha S");
        treeMap.put(55323,"Dixit");
        for(Map.Entry entry : treeMap.entrySet()){
            System.out.println("Employee ID : "+entry.getKey()+" | Name : "+entry.getValue());
        }

    }
}
