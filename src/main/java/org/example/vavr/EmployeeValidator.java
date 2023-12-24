package org.example.vavr;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.example.Employee;
import org.example.ProperName;

import java.text.MessageFormat;

import static java.lang.StringTemplate.STR;

public class EmployeeValidator {

    private static final int MIN_AGE = 18;

    public Validation<Seq<String>, Employee> validatePerson(String firstname, String lastName, int age) {
        return Validation.combine(validateName(firstname), validateName(lastName), validateAge(age)).ap(Employee::new);
    }

    private Validation<String, String> validateName(String name) {
        var properName = new ProperName(name);
        return properName.validate()
                ? Validation.valid(name)
                : Validation.invalid(STR."Name contains invalid characters: \{name}");
    }

    private Validation<String, Integer> validateAge(int age) {
        return age < MIN_AGE
                ? Validation.invalid(  STR."Age must be at least \{MIN_AGE}"  )
                : Validation.valid(age);
    }
}
