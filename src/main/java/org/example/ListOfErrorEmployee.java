package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListOfErrorEmployee implements Iterable<ErrorEmployee> {

    private final ArrayList<ErrorEmployee> collectionError;

    public ListOfErrorEmployee(){
        collectionError = new ArrayList<ErrorEmployee>();
    }
    public boolean add(ErrorEmployee err) {
        return collectionError.add(err);
    }

    @Override
    public Iterator<ErrorEmployee> iterator() {
        return collectionError.iterator();
    }

    public boolean isEmpty() {
        return collectionError.isEmpty();
    }
}
