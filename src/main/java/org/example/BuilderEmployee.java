package org.example;

public record BuilderEmployee(String firstName , String lastName) {

    public static BuilderEmployee WithFirstName(String firstName) {
        return new BuilderEmployee(firstName, "");
    }
    public BuilderEmployee WithLastName(String lastName) {
        return new BuilderEmployee(this.firstName, lastName);
    }

    public Employee Build() {
        return new Employee(this.firstName, this.lastName, 18);
    }
}
