package org.example;

import java.util.Objects;
import java.util.Optional;

public class Employee {
    private  ProperName plastName;
    private ProperName pfirstName;

    private int age;

    public Employee(String firstName,
                          String lastName, int age) {
        System.out.format("firstName: %s, lastName: %s, age: %d",
                firstName, lastName, age);

        this.pfirstName = new ProperName(firstName);

        this.plastName = new ProperName(lastName);

        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var employee = (Employee) o;
        return Objects.equals(pfirstName, employee.pfirstName) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(age, employee.age);
    }



    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pfirstName, plastName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Welcome {");
        sb.append("firstName='").append(pfirstName).append('\'');
        sb.append(", lastName='").append(plastName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public boolean firstNameIsValid() {
       return  pfirstName.validate();
    }

    public boolean lastNameIsValid() {
        return plastName.validate();
    }
}