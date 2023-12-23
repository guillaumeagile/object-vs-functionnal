package org.example;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Validate4_BuildersFluentVaildation {

    @Test
    void BuildValidEmployee() {
        var result =
              BuilderEmployee.WithFirstName("Gaston").WithLastName("Gui").Build();



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
                BuilderEmployee.WithFirstName("").WithLastName("GOOO").BuildEither();
        assertThat(result.isLeft()).isTrue();
        assertThat(result.getLeft() ).isEqualTo(new ErrorEmployee("Invalid Firstname", 1));
     //   assertThat(result.MatchLeft( err => assertThat(err).Count() == 2));
    }

    // TODO: avoir un flux de création d'employés avec des données invalides ou valides, ca fonctionne toujours bien
    // écrit sur une seulle ligne, fluent

    // TODO: ré écrire le validateur avec des Lambdas ou des FluentInterface
    // https://medium.com/walmartglobaltech/fluent-validation-with-chaining-methods-in-java-improving-code-readability-and-flexibility-beb8b040a2ee

    // TODO !!!!!!!!!! avant cela , il vaut mieux commencer par utiliser la monad Validation de VAVR !!!!!!!!!


}
