package org.example;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Validate4_BuildersFluentVaildation {

    @Test
    void BuildValidEmployee() {
        var result =
              BuilderEmployee.WithFirstName("Gaston").WithLastName("Gui").Build();

        // OBJECTIF : utiliser un truc comme     RuleFor(customer => customer.Surname).NotNull().NotEqual("foo");
        // inspiré de https://docs.fluentvalidation.net/en/latest/start.html

        assertThat( result.isPresent()).isTrue();
      //  assertThat(result).contains(new ErrorEmployee("Invalid Lastname", 1));
    }

    @Test
    void BuildInValidEmployee() {
        var result =
                BuilderEmployee.WithFirstName("").WithLastName("Gui").Build();

        assertThat(result.isEmpty()).isTrue();
    }

    @Test
    void BuildInValidEmployeeEmpttyLastName() {
        var result =
                BuilderEmployee.WithFirstName("DD").WithLastName("").Build();
        assertThat(result.isEmpty()).isTrue();
    }

    @Test
    void BuildInValidEmployee2ErrorsAndAList() {
        var result =
                BuilderEmployee.WithFirstName("").WithLastName("").Build();
        assertThat(result.isFail()).isTrue();
     //   assertThat(result.MatchLeft( err => assertThat(err).Count() == 2));
    }

}
