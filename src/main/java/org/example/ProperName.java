package org.example;

public record ProperName(String name) {

    @Override
    public String toString() {
        return name;
    }

    public boolean validate() {
        return  (name!=null) && !name.isEmpty() && hasOnlyValidChars();
    }

    private boolean hasOnlyValidChars() {
       var r =  name.chars().mapToObj(c -> (char)c).filter(c -> !Character.isAlphabetic(c) );
       return r.findAny().isEmpty();
    }
}
