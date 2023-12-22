package org.example;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Validate4_BuildersFluentVaildation {

    @Test
    void RuleValidEmployee() {
        var result =
              BuilderEmployee.WithFirstName("Gaston").WithLastName("Gui").Build();

        // OBJECTIF : utiliser un truc comme     RuleFor(customer => customer.Surname).NotNull().NotEqual("foo");
        // inspiré de https://docs.fluentvalidation.net/en/latest/start.html

        assertThat( result.firstNameIsValid()).isTrue();
      //  assertThat(result).contains(new ErrorEmployee("Invalid Lastname", 1));
    }

}
