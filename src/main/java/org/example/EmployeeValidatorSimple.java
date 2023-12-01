package org.example;

import java.util.Enumeration;

public class EmployeeValidatorSimple {
    private final Employee employee;

    public EmployeeValidatorSimple(Employee employee) {
        this.employee = employee;
    }

    public boolean validate() throws UnsupportedOperationException {
        return employee.firstNameIsValid() && employee.lastNameIsValid();
    }


    public Enumeration<Boolean> validate2()  {
     return null;
    }
}
