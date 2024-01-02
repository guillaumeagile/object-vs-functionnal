package org.example.vavr;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.example.Employee;
import org.example.ProperName;

import java.text.MessageFormat;

import static java.lang.StringTemplate.STR;

public class EmployeeValidator {

    private static final int MIN_AGE = 18;

    // TODO: utilser ErrorEmploye au lieu de String dans Seq
    public Validation<Seq<String>, Employee> validatePerson(String firstname, String lastName, int age) {
         return Validation.combine(validateName(firstname), validateName(lastName), validateAge(age)).ap(Employee::new);
    }

    // TODO: utilser ErrorEmploye au lieu de String dans la partie de gauche (left)
    public Validation<String, String> validateName(String name) {

        return
                Validation.invalid(STR."Nboo: \{name}");
    }

    // TODO: utilser ErrorEmploye au lieu de String dans la partie de gauche (left)
    public  Validation<String, Integer> validateAge(int age) {
        if (age >= 18)
            return  Validation.valid(age);
        return Validation.invalid(  STR."boooh \{MIN_AGE}"  );
    }
}
