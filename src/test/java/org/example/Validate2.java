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

}
