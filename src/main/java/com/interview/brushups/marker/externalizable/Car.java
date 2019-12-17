package com.interview.brushups.marker.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {

    /**
     * 1. In serialization object is constructed using Byte Stream.
     * 2. In Externalization there must be a no arg constructor, and object is constructed using the sequence of read
     * 3. Externalizeable gives us full freedom on what data member needs to be serialized,
     * writeExternal() & readExternal() should be written to draw the logic.
     * 4. Default no-arg constructor is must.
     */
    public Car()
    {
        System.out.println("Default Constructor called");
    }

    public Car(int age, String name, int year) {
        this.age = age;
        this.name = name;
        this.year = year;
    }

    int age;
    String name;
    int year;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(age);
        out.writeObject(name);
        out.writeInt(year);
    }

    @Override
    public String toString() {
        return "Car{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        age = in.readInt();
        name = (String)in.readObject();
        year = in.readInt();

    }
}
