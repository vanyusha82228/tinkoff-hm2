package edu.hw6;

import edu.hm6.Task4;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Task4Test {
    private static final String TEST_FILE_PATH = "testFile.txt";
    private static final String TEST_TEXT = "Programming is learned by writing programs. ― Brian Kernighan";

    @BeforeEach
    void setUp() {
        try {
            Files.deleteIfExists(Path.of(TEST_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(Path.of(TEST_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void createAndWriteToFile_Success() {
        try {
            Task4.createAndWriteToFile(TEST_FILE_PATH, TEST_TEXT);

            assertTrue(Files.exists(Path.of(TEST_FILE_PATH)));
            assertEquals(TEST_TEXT, readFromFile(TEST_FILE_PATH));
        } catch (IOException e) {
            fail("Unexpected IOException");
        }
    }

    @Test
    void createAndWriteToFile_FileAlreadyExists_OverwritesContent() {
        try {
            Files.writeString(Path.of(TEST_FILE_PATH), "Previous content", StandardOpenOption.CREATE);
        } catch (IOException e) {
            fail("Unexpected IOException");
        }

        try {
            Task4.createAndWriteToFile(TEST_FILE_PATH, TEST_TEXT);

            assertEquals(TEST_TEXT, readFromFile(TEST_FILE_PATH));
        } catch (IOException e) {
            fail("Unexpected IOException");
        }
    }

    private String readFromFile(String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
