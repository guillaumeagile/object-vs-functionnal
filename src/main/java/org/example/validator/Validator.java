package org.example.validator;

@FunctionalInterface
public interface Validator<T> {
// https://www.baeldung.com/java-8-functional-interfaces
    ValidationResult validate(T t);

    default Validator<T> and(Validator<? super T> other) {
        return obj -> {
            ValidationResult result = this.validate(obj);
            return !result.isValid() ? result : other.validate(obj);
        };
    }
}