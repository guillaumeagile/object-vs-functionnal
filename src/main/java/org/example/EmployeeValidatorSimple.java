package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.io.NotActiveException;

public class EmployeeValidatorSimple {
    private final Employee employee;

    public EmployeeValidatorSimple(Employee employee) {
        this.employee = employee;
    }

    public boolean validate() throws  UnsupportedOperationException {
        return  (!employee.getFirstName().isEmpty());
    }
}
