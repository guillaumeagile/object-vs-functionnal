package org.example;

import java.util.Optional;

public record BuilderEmployee(ProperName firstName , ProperName lastName) {

    public static BuilderEmployee WithFirstName(String firstName) {
        return new BuilderEmployee(new ProperName( firstName), new ProperName( ""));
    }
    public BuilderEmployee WithLastName(String lastName) {
        return new BuilderEmployee( this.firstName, new ProperName( lastName) );
    }

    public Optional<Employee> Build() {
        if (this.firstName().validate() && this.lastName.validate())
            return Optional.of( new Employee(this.firstName.name(), this.lastName.name(), 18));
        return Optional.empty();
    }
}
