package org.example;

import java.util.ArrayList;

public class ListOfErrorEmployeeFullFeatures  {

    private final ArrayList<ErrorEmployee> collectionError;

    public ListOfErrorEmployeeFullFeatures(){
        collectionError = new ArrayList<ErrorEmployee>();
    }
    public void add(ErrorEmployee err) {
        collectionError.add(err);
    }

    public boolean isEmpty() {
        return collectionError.isEmpty();
    }
}
