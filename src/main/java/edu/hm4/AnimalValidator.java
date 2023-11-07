package edu.hm4;

import java.util.HashSet;
import java.util.Set;

public class AnimalValidator {
    private AnimalValidator() {
    }

    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.name().isEmpty()) {
            errors.add(ValidationError.NAME_EMPTY);
        }
        if (animal.age() < 0) {
            errors.add(ValidationError.AGE_NEGATIVE);
        }
        if (animal.height() < 0) {
            errors.add(ValidationError.HEIGHT_NEGATIVE);
        }
        if (animal.weight() < 0) {
            errors.add(ValidationError.WEIGHT_NEGATIVE);
        }
        return errors;
    }
}
