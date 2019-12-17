package com.interview.brushups.javacollection.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Caller {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(4,"Amar",1995);
        Employee employee2 = new Employee(1,"Rakesh",1992);
        Employee employee3 = new Employee(3,"Suresh",1991);
        Employee employee4 = new Employee(2,"Amar Kumar",1995);

        /**
         * Added up all the employee information in the employees list
         */
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        /**
         * prints the unordered list of employees
         */
        System.out.println(employees);
        /**
         * sorts the collection object
         */
        Collections.sort(employees);
        /**
         * prints the employee details
         */
        System.out.println(employees);
    }
}
