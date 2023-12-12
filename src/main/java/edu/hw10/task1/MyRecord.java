package edu.hw10.task1;

public record MyRecord(@NotNull String name, @Min(1) @Max(100) int value) {
}
