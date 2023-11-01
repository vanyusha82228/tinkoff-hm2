package edu.hm4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskClass {

    private static final int MAX_HEIGHT = 100;

    private TaskClass() {
    }

    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    public static List<Animal> task2(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    public static Map<Animal.Type, Long> task3(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::getType, Collectors.counting()));
    }

    public static Animal task4(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }

    public static Animal.Sex task5(List<Animal> animals) {
        Map<Animal.Sex, Long> sexCount = animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));

        long maleCount = sexCount.getOrDefault(Animal.Sex.M, 0L);
        long femaleCount = sexCount.getOrDefault(Animal.Sex.F, 0L);

        return maleCount > femaleCount ? Animal.Sex.M : Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                animal -> animal,
                (existing, replacement) -> existing.weight() >= replacement.weight() ? existing : replacement
            ));
    }

    public static Animal task7(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(Animal::age))
            .orElse(null);
    }

    public static Optional<Animal> task8(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer task9(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> task10(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .collect(Collectors.toList());
    }

    public static List<Animal> task11(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > MAX_HEIGHT)
            .collect(Collectors.toList());
    }

    public static Integer task12(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .collect(Collectors.toList());
    }

    public static Boolean task14(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    public static Boolean task17(List<Animal> animals) {
        long bitingSpidersCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .count();

        long bitingDogCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .count();

        return bitingSpidersCount > bitingDogCount;
    }

    public static Animal task18(List<List<Animal>> animalLists) {
        return animalLists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    private static Set<ValidationError> validateAnimal(Animal animal) {
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

    public static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::name,
                animal -> validateAnimal(animal),
                (existingError, newError) -> {
                    existingError.addAll(newError);
                    return existingError;
                }
            ))
            .entrySet().stream()
            .filter(entry -> !entry.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, String> task20(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> hasErrors(animal))
            .collect(Collectors.toMap(
                Animal::name,
                animal -> getErrorString(animal)
            ));
    }

    private static boolean hasErrors(Animal animal) {
        // Проверка наличия ошибок в данных животного
        return animal.age() < 0 || animal.height() < 0 || animal.weight() < 0;
    }

    private static String getErrorString(Animal animal) {
        // Создание строки с перечислением ошибок
        StringBuilder errorBuilder = new StringBuilder();
        if (animal.age() < 0) {
            errorBuilder.append("Age is negative, ");
        }
        if (animal.height() < 0) {
            errorBuilder.append("Height is negative, ");
        }
        if (animal.weight() < 0) {
            errorBuilder.append("Weight is negative, ");
        }
        // Удалите последнюю запятую и пробел, если они есть
        if (errorBuilder.length() > 0) {
            errorBuilder.delete(errorBuilder.length() - 2, errorBuilder.length());
        }
        return errorBuilder.toString();
    }

}
