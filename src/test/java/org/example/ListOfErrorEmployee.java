package org.example;

import java.util.ArrayList;

public class ListOfErrorEmployee {

    private final ArrayList<ErrorEmployee> collectionError;

    public ListOfErrorEmployee(){
        collectionError = new ArrayList<ErrorEmployee>();
    }
    public void add(ErrorEmployee err) {
        collectionError.add(err);
    }

    public boolean isEmpty() {
        return collectionError.isEmpty();
    }
}
