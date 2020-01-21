package com.interview.brushups.javacollection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapVsHashTable {

    public static void main(String[] args) {

        // HashMap
        System.out.println("HashMap");

        Map<Integer, String> hashMap = new HashMap<Integer, String>();

        hashMap.put(54561,"Amar Kumar");
        hashMap.put(53115,"Shailaja Kumari");
        hashMap.put(51234, "Sneha S");
        hashMap.put(55323,"Dixit");

        //HashMap Allow only null Key and Multiple NULL values
        hashMap.put(null,"Ramesh K");
        hashMap.put(null,"Suresh K");

        hashMap.put(65433,null);
        hashMap.put(77544,null);

        for(Map.Entry entry : hashMap.entrySet()){
            System.out.println("Employee ID : "+entry.getKey()+" | Name : "+entry.getValue());
        }

        // Hashtable
        System.out.println("Hashtable");

        Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
        /**
         * It will throw an exception, if we try to add a null key or value to HashTable
         * Exception in thread "main" java.lang.NullPointerException
         * 	at java.util.Hashtable.put(Hashtable.java:460)
         */
        // hashtable.put(null, Amar);
        // hashtable.put(1, null);

        hashtable.put(54561, "Amar");
        hashtable.put(51534017, "Kumar");

        for(Map.Entry entry : hashtable.entrySet()){
            System.out.println("Employee ID : "+entry.getKey()+" | Name : "+entry.getValue());
        }

    }

}
