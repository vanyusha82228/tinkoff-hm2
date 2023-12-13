package edu.hw10.task2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Cache {
    boolean persist() default false; // Параметр для указания сохранения на диск
}
