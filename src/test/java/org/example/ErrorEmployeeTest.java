package org.example;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ErrorEmployeeTest {

    @Test
    void instanciate_errror_collection() {
        var err = new ErrorEmployee("fool", 0);
       var collectionError =  new ArrayList<ErrorEmployee>();
        collectionError.add(err);

        Iterable<ErrorEmployee>  collectionEnumerable = collectionError;
        assertThat(collectionEnumerable).isNotEmpty();
    }

    @Test
    void instanciate_errror_collection_calisthenics()  {
        var err = new ErrorEmployee("fool", 0);
        var collectionError = new ListOfErrorEmployee(); // new ArrayList<ErrorEmployee>();
        collectionError.add(err);
        assertEquals(collectionError.isEmpty(),   false);
       // assertThat(collectionError).isNotEmpty();
    }

    @Test
    void instanciate_errror_collection_calisthenics_vide()  {

        var collectionError = new ListOfErrorEmployee(); // new ArrayList<ErrorEmployee>();

        assertEquals(collectionError.isEmpty(),   true);
        // assertThat(collectionError).isNotEmpty();
    }


    //	assertThat(collectErrors.nextElement()).isInstanceOfAny(ErrorEmployee);
/*
    @Test
    void LastNameINvalidWrongCaracter_V2() {
        var sut = new Employee("Anthony", "C1ss", 18);

        var validateur = new EmployeeValidatorSimple(sut);

        assertThat( validateur.validate2()).contains(new InvalidLastName());
    }

    @Test
    void LastNameINvalidWrongCaracterTwice_V2() {
        var sut = new Employee("Ant&hony", "C1ss", 18);

        var validateur = new EmployeeValidatorSimple(sut);

        assertThat( validateur.validate2()).contains( new InvalidLastName());
        assertThat( validateur.validate2()).contains( new InvalidFirstName());
    }
*/
}
