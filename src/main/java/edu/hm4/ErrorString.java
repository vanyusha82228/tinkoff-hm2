package edu.hm4;

public class ErrorString {
    private ErrorString() {
    }

    public static boolean hasErrors(Animal animal) {
        // Проверка наличия ошибок в данных животного
        return animal.age() < 0 || animal.height() < 0 || animal.weight() < 0;
    }

    public static String getErrorString(Animal animal) {
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
