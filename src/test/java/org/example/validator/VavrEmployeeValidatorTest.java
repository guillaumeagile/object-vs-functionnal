package org.example.validator;

import org.example.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VavrEmployeeValidatorTest {

    @Test
    void CanWeConstructAnObjectThatIsInvalid() {
        var personValidator = new org.example.vavr.EmployeeValidator();

// Valid(Person(John Doe, 30))
        var valid = personValidator.validatePerson("John", "Doe", 30);
        assertThat( valid.isValid()).isTrue();
        assertThat(valid.getOrElse(  new Employee("a", "a", 0)))
                .isEqualTo(new Employee("John", "Doe", 30));


        var invalid = personValidator.validatePerson("John?", "Doe!4", -1);
        assertThat( invalid.isInvalid()).isTrue();
        assertThat( invalid.getError()).hasOnlyElementsOfType(String.class);
        assertThat( invalid.getError()).hasSize(3);
        assertThat( invalid.getError().last()).isEqualTo("Age must be at least 18");
        assertThat( invalid.getError().take(1).single()).isEqualTo("Name contains invalid characters: John?");
    }
}
