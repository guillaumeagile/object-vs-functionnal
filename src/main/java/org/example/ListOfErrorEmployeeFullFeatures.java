package org.example;
import java.util.ArrayList;
import java.util.function.Function;

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

    // Calisthenics à fond, mais discutable
    public ListOfErrorEmployeeFullFeatures filter (Function<ErrorEmployee, Boolean> f){
        throw new RuntimeException();
        //return collectionError.stream().filter(f) ;
    }
}
