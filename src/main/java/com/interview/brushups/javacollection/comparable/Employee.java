package com.interview.brushups.javacollection.comparable;

/**
 * Comparable is used for natural ordering of the Object.
 * In order to enable the ordering, we must implement Comparable Interface - compareTo() method.
 */
public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private int year;

    public Employee(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    /**
     * If this.vale is lesser than the passed it should return a negative value
     * If this.value is greater than the passed value it should return a positive value
     * If it's Equal should use Zero
     */

    @Override
    public int compareTo(Employee employee) {
        /**
         *  if you want to return a comparison between string, call out compareTo() method of String
         *  e.g return this.name.compareTo(employee.name);
         */
        if (this.getId() < employee.getId()) return -1;
        if (this.getId() > employee.getId()) return 1;
        else return 0;
    }
}
