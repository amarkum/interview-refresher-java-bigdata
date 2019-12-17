package com.interview.brushups.javarefresher.immutable;

final class Employee{
    /**
     * To make the Class as immutable, make all the fields as private and final.
     * Let the constructor set the value of it as once, and it can't be modified.
     */
    private final String empName;
    private final int age;
    private final Address address;

    public Employee(String name, int age, Address address) {
        super();
        this.empName = name;
        this.age = age;
        this.address = address;
    }

    public String getEmpName() {
        return empName;
    }
    public int getAge() {
        return age;
    }
    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }
}