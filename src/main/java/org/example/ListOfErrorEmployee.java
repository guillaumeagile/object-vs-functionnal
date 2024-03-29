package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListOfErrorEmployee implements Iterable<IErrorEmployee> {

    private final ArrayList<IErrorEmployee> collectionError;

    public ListOfErrorEmployee(){
        collectionError = new ArrayList<IErrorEmployee>();
    }

    public static ListOfErrorEmployee EmptyList() {
        return new ListOfErrorEmployee();
    }

    public boolean add(IErrorEmployee err) {
        if ( err.equals(new EmptyErrorEmployee())) {
            return false;
        }
        return collectionError.add(err);
    }

    @Override
    public Iterator<IErrorEmployee> iterator() {
        return collectionError.iterator();
    }

    public boolean isEmpty() {
        return collectionError.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfErrorEmployee that = (ListOfErrorEmployee) o;
        return collectionError.equals(that.collectionError);
    }

    @Override
    public int hashCode() {
        return collectionError.hashCode();
    }

    public boolean contains(ErrorEmployee e) {
        return collectionError.contains(e);
    }

}
