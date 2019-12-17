package com.interview.brushups.marker.serializable;

import java.io.*;

public class Caller {

    public static void main(String[] args) {
        Car car = new Car(234, "Mustang","Passcode**123");
        String filename = "serialized.txt";

        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(car);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }


        Car deserializeCar = null;

        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            deserializeCar = (Car) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been de-serialized ");
            System.out.println(deserializeCar);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}
