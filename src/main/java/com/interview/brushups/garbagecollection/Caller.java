package com.interview.brushups.garbagecollection;

import java.io.IOException;

public class Caller {
    public static void main(String[] args) throws IOException {

        /**
         * Runtime is a Singleton class, where instance of runtime is instantiated as a new JVM is created.
         * calling the getRuntime() method would return a static instance of runtime.
         */
        Runtime runtime =  Runtime.getRuntime();

        System.out.println(runtime.availableProcessors());
        for(int i=0;i<10000;i++){
            new Caller();
        }
        /**
         *Memory left after creation of 1000 Caller() object.
         */
        System.out.println(runtime.freeMemory());

        /**
         * Call the garbage collector using System.gc()
         */
        System.gc();

        /**
         * Check the free memory after garbage is collected.
         */
        System.out.println(runtime.freeMemory());
    }
}
