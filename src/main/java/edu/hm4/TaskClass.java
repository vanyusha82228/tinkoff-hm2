package edu.hm4;

import java.util.Comparator;
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



    public static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::name,
                AnimalValidator::validateAnimal,
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
            .filter(ErrorString::hasErrors)
            .collect(Collectors.toMap(
                Animal::name,
                ErrorString::getErrorString
            ));
    }


}
