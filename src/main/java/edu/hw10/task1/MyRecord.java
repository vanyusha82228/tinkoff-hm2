package edu.hw10.task1;

import edu.hw10.task1.annotation.Max;
import edu.hw10.task1.annotation.Min;
import edu.hw10.task1.annotation.NotNull;

public record MyRecord(@NotNull String name, @Min(1) @Max(100) int value) {
}
