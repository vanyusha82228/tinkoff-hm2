package edu.hw9;

import edu.hw9.task2.FileSearchTask;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {
    @Test
    void testFileSearchTask() {
        File testDirectory = new File("F:\\Tinkoff2\\src\\test\\java\\edu\\hw9\\testFile");

        int filesThreshold = 0;
        String fileExtension = ".txt";
        long fileSize = 0;

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FileSearchTask fileSearchTask = new FileSearchTask(testDirectory, filesThreshold, fileExtension, fileSize);
        List<File> result = forkJoinPool.invoke(fileSearchTask);


        assertEquals(0, result.size());

    }
}
