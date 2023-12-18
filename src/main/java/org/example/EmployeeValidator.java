package org.example;

public class EmployeeValidator {
    private final Employee employee;

    public EmployeeValidator(Employee employee) {
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

    public ListOfErrorEmployee validate3() {
        var result = new ListOfErrorEmployee();

        result.add(employee.lastNameIsValid2());
        result.add(employee.firstNameIsValid2());
        return result;
    }
}
