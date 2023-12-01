package org.example;

public class EmployeeValidatorSimple {
    private final Employee employee;

    public EmployeeValidatorSimple(Employee employee) {
        this.employee = employee;
    }

    public boolean validate0() throws UnsupportedOperationException {
        String invalidCharsFirstName = employee.getFirstName().replaceAll("[a-zA-Z ]", "");
        String invalidCharsLastName = employee.getLastName().replaceAll("[a-zA-Z ]", "");
        return (!employee.getFirstName().isEmpty()
                && !employee.getLastName().isEmpty()
                && invalidCharsFirstName.isEmpty()
                && invalidCharsLastName.isEmpty());
    }

    public boolean validate() throws UnsupportedOperationException {
        return employee.firstNameIsValid() && employee.lastNameIsValid();
    }


    // TODO: connaitre la liste des raisons pour lesquelles on est invalie
    // TODO: mauvais design sur l'age: année de naissance ?


}
