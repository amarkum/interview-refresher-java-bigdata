package com.interview.brushups.javarefresher.immutable;

public class Caller {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp = new Employee("Amar Kumar", 27, new Address("Home", "Crystal Dew Apartments", "Bangalore"));
        Address address = emp.getAddress();
        System.out.println(address);
        address.setAddressType("Office");
        address.setAddress("EGL Tech Park");
        address.setCity("Hyderabad");
        System.out.println(emp.getAddress());
    }
}
