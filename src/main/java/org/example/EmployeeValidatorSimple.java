package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.io.NotActiveException;

public class EmployeeValidatorSimple {
    private final Employee employee;

    public EmployeeValidatorSimple(Employee employee) {
        this.employee = employee;
    }

    public boolean validate0() throws  UnsupportedOperationException {
        String invalidCharsFirstName = employee.getFirstName().replaceAll("[a-zA-Z ]", "");
        String invalidCharsLastName = employee.getLastName().replaceAll("[a-zA-Z ]", "");
        return  (!employee.getFirstName().isEmpty()
                && !employee.getLastName().isEmpty()
                &&  invalidCharsFirstName.isEmpty()
                && invalidCharsLastName.isEmpty()) ;
    }

    public boolean validate() throws  UnsupportedOperationException {

        return  (
                 foo(employee.getFirstName())
                && foo(employee.getLastName())) ;
    }

    boolean foo(String s)
    {
        return s.replaceAll("[a-zA-Z ]", "").isEmpty() && !s.isEmpty();
    }


    // TODO: connaitre la liste des raisons pour lesquelles on est invalie
    // TODO: mauvais design sur l'age: année de naissance ?


}
