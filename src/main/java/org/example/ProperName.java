package org.example;

public record ProperName(String name) {

    @Override
    public String toString() {
        return name;
    }

    public boolean validate() {
        return name.replaceAll("[a-zA-Z ]", "").isEmpty() && !name.isEmpty();
    }
}
