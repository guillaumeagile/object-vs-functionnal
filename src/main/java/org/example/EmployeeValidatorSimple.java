package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.io.NotActiveException;

public class EmployeeValidatorSimple {
    private final Employee employee;

    public EmployeeValidatorSimple(Employee employee) {
        this.employee = employee;
    }

    public boolean validate() throws  UnsupportedOperationException {
        return  (!employee.getFirstName().isEmpty() && !employee.getLastName().isEmpty()) ;
    }
    // TODO: connaitre la liste des raisons pour lesquelles on est invalie
    // TODO: mauvais design sur l'age: année de naissance ?


}
