package edu.hw10.task1;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        RandomObjectGenerator rog = new RandomObjectGenerator();

        try {
            // Генерация объекта MyClass с использованием конструктора
            var myClass = rog.nextObject(MyClass.class, null);
            log.info("Generated MyClass: " + myClass);

            // Генерация объекта MyRecord с использованием конструктора
            var myRecord = rog.nextObject(MyRecord.class, null);
            log.info("Generated MyRecord: " + myRecord);

            // Генерация объекта MyClass с использованием фабричного метода create
            var myClassFromFactory = rog.nextObject(MyClass.class, "create");
            log.info("Generated MyClass from factory method: " + myClassFromFactory);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
