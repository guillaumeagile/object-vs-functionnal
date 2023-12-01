package org.example;

import java.util.Objects;
import java.util.Optional;

public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    public Employee(String firstName,
                          String lastName, int age) {
        System.out.format("firstName: %s, lastName: %s, age: %d",
                firstName, lastName, age);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = null;
        this.age = age;
    }

    public Employee(String firstName, String middleName,
                          String lastName, int age) {
        System.out.format("firstName: %s, lastName: %s, age: %d",
                firstName, lastName, age);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(age, employee.age);
    }

    public String getFirstName() {
        return firstName;
    }

    public Optional<String> getMiddleName() {
        return Optional.ofNullable(middleName);
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Welcome {");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getFullName() {
        return firstName + " " +
                getMiddleName().map(x -> x + " ").orElse("") + lastName;
    }

    boolean validateProperName(String name)
    {
        return name.replaceAll("[a-zA-Z ]", "").isEmpty() && !name.isEmpty();
    }

    public boolean firstNameIsValid() {
       return  validateProperName(firstName);
    }

    public boolean lastNameIsValid() {
        return  validateProperName(lastName);
    }
}