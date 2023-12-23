package org.example;

import org.example.validator.ValidationResult;
import org.example.validator.Validator;

import java.util.function.Function;

public class EmployeeValidator {
    private final Employee employee;

    public EmployeeValidator(Employee employee) {
        this.employee = employee;
    }

    public boolean validate() throws UnsupportedOperationException {
        return employee.firstNameIsValid() && employee.lastNameIsValid();
    }


    public ListOfErrorEmployee validate2() {
        var result = new ListOfErrorEmployee();
        /* TODO: refactoring remove if */
        /* Guillaume => fonctions */
        /* Anthony => no boolean primitive obsession => polymorphisme */
        if (!employee.lastNameIsValid())
            result.add(new ErrorEmployee("Invalid Lastname", 1));
        if (!employee.firstNameIsValid())
            result.add(new ErrorEmployee("Invalid Firstname", 1));
        return result;
    }

    public ListOfErrorEmployee validate3() {
        var result = new ListOfErrorEmployee();
        result.add(employee.lastNameIsValid2());
        result.add(employee.firstNameIsValid2());
        return result;
    }

      public ListOfErrorEmployee validateFunctionnal_Step1() {
        var result = new ListOfErrorEmployee();

          // version brute:  lambda + apply
          Function<String, ValidationResult> emailValidator2= str -> {
              if (str != null && str.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                  return new ValidationResult(true, "");
              }
              return new ValidationResult(false, "Email is not valid");
          };

          var re0 = emailValidator2.apply(employee.getPlastName().name());

        return result;
    }

    Validator<String> emailValidator = str -> {
        if (str != null && str.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            return new ValidationResult(true, "");
        }
        return new ValidationResult(false, "Email is not valid");
    };

    public ListOfErrorEmployee validateFunctionnal_Step2() {
        var result = new ListOfErrorEmployee();

        // version avec FunctionalInterface
        var res = emailValidator.validate(employee.getPlastName().name());

        return result;
    }

}
