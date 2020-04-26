package com.interview.brushups.marker.serializable;

import java.io.Serializable;


/**
 * 1. Serializable is a marker interface.
 * 2. Only non-static data members are saved via Serialization process.
 * 3. Static data members and transient data members are not saved via Serialization process.
 * So, if you don’t want to save value of a non-static data member then make it transient.
 * 4. Constructor of object is never called when an object is de-serialized.
 */
public class Car implements Serializable {

    static final long serialVersionUID = 234L;

    private int topSpeed ;
    private String name;

    /**
     * variable with transient keyword will not be serialized.
     * Such as password etc.
     */
    private transient String password;

    public Car(int topSpeed, String name, String password) {
        this.topSpeed = topSpeed;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Car{" +
                "topSpeed=" + topSpeed +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /*
     * While we deserialize, readResolve() method will be used to deserialize the object.
     * private Object readResolve()  {
     *      return new Car(23,"Ferrai", "f3r@rI'");
     *  }
     */
}
