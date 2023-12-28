package edu.hw10.task1;

import edu.hw10.task1.annotation.Max;
import edu.hw10.task1.annotation.Min;
import edu.hw10.task1.annotation.NotNull;

public class MyClass {
    @NotNull
    private String name;
    @Min(1)
    @Max(100)
    private int value;

    public MyClass() {
    }

    public static MyClass create(String name, int value) {
        return new MyClass(name, value);
    }

    public MyClass(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override public String toString() {
        return "MyClass{"
            + "name='" + name + '\''
            + ", value=" + value
            + '}';
    }
}
