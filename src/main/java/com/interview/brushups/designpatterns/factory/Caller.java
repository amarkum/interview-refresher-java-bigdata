package com.interview.brushups.designpatterns.factory;

public class Caller {
    public static void main(String[] args) {
        /**
         * Create a new Instance of CarFactory, and pass the type of the object you want.
         * The instance would return an object type of implemented =type.
         */
        CarFactory carFactory  = new CarFactory();

        /**
         * getInstance() is a public method, which returns an object of Car Type
         */
        Car car = carFactory.getInstance("heavy");

        /**
         * type() is a method in the interface, which is implemented in Class of Car Type
         */
        car.type();
    }
}
