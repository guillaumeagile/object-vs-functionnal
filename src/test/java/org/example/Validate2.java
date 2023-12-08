package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Validate2 {

    @Test
    void RuleValidEmployee() {
        var sut = new Employee("Gaston", "Lagaffe", 18);

        var validator = new EmployeeValidatorSimple(sut);
        assertThat( validator.validate2().isEmpty() ).isTrue();
    }

    @Test
    void SecondRule_Invalid() {
        var sut = new Employee("Anthony", "", 18);

        var validateur = new EmployeeValidatorSimple(sut);
        var result = validateur.validate2();

        assertThat( validateur.validate2().isEmpty()).isFalse();
        assertThat( result.contains(new ErrorEmployee("Invalid Lastname", 1))).isTrue();
    }

    @Test

    void FirstNameEmployee_Invalid() {
        var sut = new Employee("", "Lagaffe", 18);

        var validateur = new EmployeeValidatorSimple(sut);
        var result = validateur.validate2();

        assertThat( validateur.validate2().isEmpty()).isFalse();
        assertThat( result.contains(new ErrorEmployee("Invalid Firstname", 1))).isTrue();
    }

}
