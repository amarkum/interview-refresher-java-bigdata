package com.interview.brushups.designpatterns.factory;

/**
 * Car Factory which returns an instance of respective carType using the string value of getInstance method
 */
public class CarFactory {

    /**
     * the getInstance() is a public method returns a new object of car type.
     * @param carType
     * @return an object car Type
     */
    public Car getInstance(String carType) {
        if (carType.equalsIgnoreCase("Small")) {
            return new HatchBack();

        } else if (carType.equalsIgnoreCase("Big")) {
            return new Sedan();

        } else if (carType.equalsIgnoreCase("Heavy")) {
            return new SUV();

        } else
            return null;
    }
}
