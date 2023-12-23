package org.example;

import java.util.Objects;

public class Employee {
    private  ProperName plastName;
    private ProperName pfirstName;

    private int age;

    public Employee(String firstName,
                          String lastName, int age) {
        this.pfirstName = new ProperName(firstName);
        this.plastName = new ProperName(lastName);
        this.age = age;    // TODO: mauvais design sur l'age: année de naissance ?
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var employee = (Employee) o;
        return Objects.equals(pfirstName, employee.pfirstName) &&
                Objects.equals(getPlastName(), employee.getPlastName())  &&
                Objects.equals(age, employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pfirstName, getPlastName());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Welcome {");
        sb.append("firstName='").append(pfirstName).append('\'');
        sb.append(", lastName='").append(getPlastName()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public boolean firstNameIsValid() {
       return  pfirstName.validate();
    }

    public boolean lastNameIsValid() {
        return getPlastName().validate();
    }

    public IErrorEmployee lastNameIsValid2() {
        if (getPlastName().validate())
            return new EmptyErrorEmployee();
        return new ErrorEmployee("Invalid Lastname", 1);
    }

    public IErrorEmployee firstNameIsValid2() {
        if (pfirstName.validate())
            return new EmptyErrorEmployee();
        return new ErrorEmployee("Invalid Firstname", 1);
    }

    public ProperName getPlastName() {
        return plastName;
    }
}