package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListOfErrorsEmployeeTest {

    @Test
    void instanciate_errror_collection() {
        var err = new ErrorEmployee("fool", 0);
        var collectionError = new ArrayList<ErrorEmployee>();
        collectionError.add(err);

        Iterable<ErrorEmployee> collectionEnumerable = collectionError;
        assertThat(collectionEnumerable).isNotEmpty();
    }

    @Test
    void instanciate_errors_collection_calisthenics() {
        var err = new ErrorEmployee("fool", 0);
        var collectionError = new ListOfErrorEmployee(); // new ArrayList<ErrorEmployee>();
        collectionError.add(err);
        assertEquals(collectionError.isEmpty(), false);

        // *** ces 2 lignes dessous ne peuvent compiler
        //   collectionError.stream().toArray();
        // assertThat(collectionError).isNotEmpty();
    }

    @Test
    void instanciate_errror_collection_calisthenics_vide() {

        var collectionError = new ListOfErrorEmployee();

        assertEquals(collectionError.isEmpty(), true);
    }

    @Test
    void confirmationTest_equalityValuesInLists() {

        var collectionError1 = new ArrayList<Integer>();
        collectionError1.add(42);
        var collectionError2 = new ArrayList<Integer>();
        collectionError2.add(42);

        assertEquals(collectionError1, collectionError2);
    }

    @Test
    void confirmationTest_equalityValueObjectsInLists() {

        var collectionError1 = new ArrayList<ErrorEmployee>();
        collectionError1.add(new ErrorEmployee("foo", 42));
        var collectionError2 = new ArrayList<ErrorEmployee>();
        collectionError2.add(new ErrorEmployee("foo", 42));

        assertEquals(collectionError1, collectionError2);
    }

    @Test
    void listOfEmployees_equality() {

        var collectionError1 = new ListOfErrorEmployee();
        collectionError1.add(new ErrorEmployee("foo", 42));
        var collectionError2 = new ListOfErrorEmployee();
        collectionError2.add(new ErrorEmployee("foo", 42));

        assertEquals(collectionError1, collectionError2);
    }

}
