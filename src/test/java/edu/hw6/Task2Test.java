package edu.hw6;

import edu.hm6.Task2;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {
    @Test
    public void testCloneFile() {
        // Укажите путь к существующему файлу для тестирования
        Path originalFilePath = Paths.get("F:\\Tinkoff2\\src\\main\\java\\edu\\hm6\\txtFile" +
            "\\Tinkoff Bank Biggest Secret.txt");
        Task2.cloneFile(originalFilePath);

        // Проверим, что файл и его копия(и) действительно существуют
        assertTrue(Files.exists(originalFilePath));
        assertTrue(Files.exists(originalFilePath.resolveSibling("F:\\Tinkoff2\\src\\main\\java\\edu\\hm6" +
            "\\txtFile\\Tinkoff Bank Biggest Secret — копия.txt")));
    }
}
