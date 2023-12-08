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


    public ListOfErrorEmployee validate2() {
        var result = new ListOfErrorEmployee();
        /* TODO: refactoring remove if */
        /* Guillaume => fonctions */
        /* Anthony => no boolean primitive obsession => polymorphisme */
        if (!employee.lastNameIsValid())
            result.add(new ErrorEmployee("Invalid Lastname", 1));
        if (!employee.firstNameIsValid())
            result.add(new ErrorEmployee("Invalid Firstname", 1));
        return result;
    }
}
