package edu.hw10.task1;

import edu.hw10.task1.annotation.Max;
import edu.hw10.task1.annotation.Min;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Random;
import java.util.UUID;


public class RandomObjectGenerator {
    private Random random = new Random();

    public <T> T nextObject(Class<T> clazz, String factoryMethod) throws Exception {
        if (factoryMethod == null) {
            return generateObjectUsingConstructor(clazz);
        } else {
            return generateObjectUsingFactoryMethod(clazz, factoryMethod);
        }
    }

    private <T> T generateObjectUsingConstructor(Class<T> clazz) throws Exception {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length == 0) {
            throw new NoSuchMethodException("No constructors found for class: " + clazz.getName());
        }

        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);

        Field[] fields = clazz.getDeclaredFields();
        Object[] args = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            args[i] = generateValueForField(fields[i]);
        }

        return (T) constructor.newInstance(args);
    }

    private <T> T generateObjectUsingFactoryMethod(Class<T> clazz, String factoryMethod) throws Exception {
        Method method = clazz.getDeclaredMethod(factoryMethod, String.class, int.class);
        method.setAccessible(true);

        Field[] fields = clazz.getDeclaredFields();
        Object[] args = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            args[i] = generateValueForField(fields[i]);
        }

        Object instance =
            Modifier.isStatic(method.getModifiers()) ? null : clazz.getDeclaredConstructor().newInstance();

        return (T) method.invoke(instance, args);
    }

    private Object generateValueForField(Field field) {
        Class<?> type = field.getType();
        return generateValueForType(type, field);
    }

    private Object generateValueForType(Class<?> type, Field field) {
        if (type == int.class || type == Integer.class) {
            int minValue = getMinValue(field);
            int maxValue = getMaxValue(field);
            return generateIntValueInRange(minValue, maxValue);
        } else if (type == double.class || type == Double.class) {
            return random.nextDouble();
        } else if (type == String.class) {
            return UUID.randomUUID().toString();
        }
        return null;
    }

    private int generateIntValueInRange(int minValue, int maxValue) {
        return random.nextInt((maxValue - minValue) + 1) + minValue;
    }

    private int getMinValue(Field field) {
        Min minAnnotation = field.getAnnotation(Min.class);
        return minAnnotation != null ? minAnnotation.value() : Integer.MIN_VALUE;
    }

    private int getMaxValue(Field field) {
        Max maxAnnotation = field.getAnnotation(Max.class);
        return maxAnnotation != null ? maxAnnotation.value() : Integer.MAX_VALUE;
    }

}
