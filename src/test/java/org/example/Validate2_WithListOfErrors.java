package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Validate2_WithListOfErrors {

    @Test
    void RuleValidEmployee() {
        var sut = new Employee("Gaston", "Lagaffe", 18);

        var validator = new EmployeeValidator(sut);
        assertThat( validator.validate2().isEmpty() ).isTrue();
    }

    @Test
    void RuleValidEmployee_V2() {
        var sut = new Employee("Gaston", "Lagaffe", 18);

        var validator = new EmployeeValidator(sut);
        assertThat( validator.validate2()).isEqualTo( new ListOfErrorEmployee());
    }

    @Test
    void RuleValidEmployee_V3() {
        var sut = new Employee("Gaston", "Lagaffe", 18);

        var validator = new EmployeeValidator(sut);
        assertThat( validator.validate2()).isEqualTo(  ListOfErrorEmployee.EmptyList());
    }

    @Test
    void SecondRule_Invalid() {
        var sut = new Employee("Anthony", "", 18);

        var validateur = new EmployeeValidator(sut);
        var result = validateur.validate2();

        assertThat( validateur.validate2().isEmpty()).isFalse();
        assertThat( result.contains(new ErrorEmployee("Invalid Lastname", 1))).isTrue();
    }

    @Test
    void FirstNameEmployee_Invalid() {
        var sut = new Employee("", "Lagaffe", 18);

        var validateur = new EmployeeValidator(sut);
        var result = validateur.validate2();

        assertThat( validateur.validate2().isEmpty()).isFalse();
        assertThat( result.contains(new ErrorEmployee("Invalid Firstname", 1))).isTrue();
    }

    @Test
    void FirstNameEmployee_Invalid_V3() {
        var sut = new Employee("", "Lagaffe", 18);

        var validateur = new EmployeeValidator(sut);
        var result = validateur.validate3();

        assertThat( result.isEmpty()).isFalse();
        assertThat(result).contains(new ErrorEmployee("Invalid Firstname", 1));

    }

    @Test
    void LastNameEmployee_Invalid_V3() {
        var sut = new Employee("gaston", "", 18);

        var validateur = new EmployeeValidator(sut);
        var result = validateur.validate3();

        assertThat( result.isEmpty()).isFalse();
        assertThat(result).contains(new ErrorEmployee("Invalid Lastname", 1));

    }

}
