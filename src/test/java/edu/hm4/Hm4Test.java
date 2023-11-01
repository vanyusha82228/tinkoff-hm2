package edu.hm4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Hm4Test {
    @Test
    public void testTask1() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true)
        );

        List<Animal> result = TaskClass.task1(animals);
        assertEquals(2, result.size());
        assertEquals("Dog", result.get(0).name());
        assertEquals("Cat", result.get(1).name());
    }

    @Test
    public void testTask2() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true)
        );

        List<Animal> result = TaskClass.task2(animals, 1);
        assertEquals(1, result.size());
        assertEquals("Dog", result.get(0).name());
    }

    @Test
    public void testTask3() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false)
        );

        Map<Animal.Type, Long> result = TaskClass.task3(animals);
        assertEquals(2, result.size());
        assertEquals(2L, result.get(Animal.Type.CAT));
        assertEquals(1L, result.get(Animal.Type.DOG));
    }

    @Test
    public void testTask4() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true)
        );

        Animal result = TaskClass.task4(animals);
        assertEquals("Big Dog", result.name());
    }

    @Test
    public void testTask5() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false)
        );

        Animal.Sex result = TaskClass.task5(animals);
        assertEquals(Animal.Sex.M, result);
    }

    @Test
    public void testTask6() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false)
        );

        Map<Animal.Type, Animal> result = TaskClass.task6(animals);
        assertEquals(2, result.size());
        assertEquals("Cat", result.get(Animal.Type.CAT).name());
        assertEquals("Dog", result.get(Animal.Type.DOG).name());
    }

    @Test
    public void testTask7() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false)
        );

        Animal result = TaskClass.task7(animals);
        assertEquals("Dog", result.name());
    }

    @Test
    public void testTask8() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 7, false)
        );

        Optional<Animal> result = TaskClass.task8(animals, 6);
        assertEquals("Cat", result);
    }

    @Test
    public void testTask9() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 7, false)
        );

        Integer result = TaskClass.task9(animals);
        assertEquals(12, result);
    }

    @Test
    public void testTask10() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 4, 10, 7, false)
        );

        List<Animal> result = TaskClass.task10(animals);
        assertEquals(1, result.size());
        assertEquals("Cat", result.get(0).name());
    }

    @Test
    public void testTask11() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 7, false)
        );

        List<Animal> result = TaskClass.task11(animals);
        assertEquals(0, result.size());
    }

    @Test
    public void testTask12() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 7, false)
        );

        Integer result = TaskClass.task12(animals);
        assertEquals(1, result);
    }

    @Test
    public void testTask13() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Big Nice Dog", Animal.Type.DOG, Animal.Sex.F, 3, 8, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 7, false)
        );

        List<Animal> result = TaskClass.task13(animals);
        assertEquals(1, result.size());
        assertEquals("Big Nice Dog", result.get(0).name());
    }

    @Test
    public void testTask14() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 10, 5, false),
            new Animal("Big Nice Dog", Animal.Type.DOG, Animal.Sex.F, 3, 12, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 7, false)
        );

        Boolean result = TaskClass.task14(animals, 10);
        assertTrue(result);
    }

    @Test
    public void testTask15() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 6, 10, 5, false),
            new Animal("Big Nice Dog", Animal.Type.DOG, Animal.Sex.F, 3, 12, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 7, false)
        );

        Map<Animal.Type, Integer> result = TaskClass.task15(animals, 2, 7);
        assertEquals(2, result.size());
        assertEquals(12, result.get(Animal.Type.CAT));
        assertEquals(12, result.get(Animal.Type.DOG));
    }

    @Test
    public void testTask16() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 6, 10, 5, false),
            new Animal("Big Nice Dog", Animal.Type.DOG, Animal.Sex.F, 3, 12, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 7, false)
        );

        List<Animal> result = TaskClass.task16(animals);
        assertEquals("Cat", result.get(0).name());
        assertEquals("Cat2", result.get(1).name());
        assertEquals("Big Nice Dog", result.get(2).name());

    }

    @Test
    public void testTask17() {
        List<Animal> animals = Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 6, 10, 5, false),
            new Animal("Big Nice Dog", Animal.Type.DOG, Animal.Sex.F, 3, 12, 12, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 10, 7, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 0, 0, true)
        );

        Boolean result = TaskClass.task17(animals);
        assertFalse(result);
    }

    @Test
    public void testTask18() {
        List<Animal> fishList1 = Arrays.asList(
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 5, 20, 1, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 4, 18, 2, false),
            new Animal("Fish3", Animal.Type.FISH, Animal.Sex.M, 3, 21, 3, false)
        );

        List<Animal> fishList2 = Arrays.asList(
            new Animal("Fish4", Animal.Type.FISH, Animal.Sex.M, 5, 19, 4, false),
            new Animal("Fish5", Animal.Type.FISH, Animal.Sex.F, 6, 17, 5, false)
        );

        List<List<Animal>> animalLists = Arrays.asList(fishList1, fishList2);

        Animal heaviestFish = TaskClass.task18(animalLists);

        assertEquals("Fish5", heaviestFish.name());

    }

    @Test
    public void testTask19() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, -5, -60, -30, false));
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 4, 40, 20, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, -1, 30, 25, false));
        animals.add(new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 1, 10, 5, false));

        Map<String, Set<ValidationError>> errorsMap = TaskClass.task19(animals);

        assertEquals(1, errorsMap.size());
        assertTrue(errorsMap.containsKey("Dog"));

        assertTrue(errorsMap.get("Dog").contains(ValidationError.AGE_NEGATIVE));
        assertTrue(errorsMap.get("Dog").contains(ValidationError.WEIGHT_NEGATIVE));
        assertTrue(errorsMap.get("Dog").contains(ValidationError.AGE_NEGATIVE));

    }

    @Test
    public void testTask20() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 5, 60, -30, false));
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 4, 40, 20, false));
        animals.add(new Animal("Fish", Animal.Type.FISH, Animal.Sex.F, 1, 10, 5, false));

        Map<String, String> errorMap = TaskClass.task20(animals);

        assertEquals(1, errorMap.size());
        assertTrue(errorMap.containsKey("Dog"));

        assertEquals("Weight is negative", errorMap.get("Dog"));

    }

}
