package com.interview.brushups.marker.externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Caller {
    public static void main(String[] args)
    {
        Car car = new Car(10, "Ferrari", 1995);
        Car newcar = null;
        final String filename = "externalized.txt";

        // Serialize the car
        try {
            FileOutputStream fo = new FileOutputStream(filename);
            ObjectOutputStream so = new ObjectOutputStream(fo);
            so.writeObject(car);
            so.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        // De-serialize the car
        try {
            FileInputStream fi = new FileInputStream(filename);
            ObjectInputStream si = new ObjectInputStream(fi);
            newcar = (Car)si.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("The original car is:\n" + car);
        System.out.println("The new car is:\n" + newcar);
    }
}
