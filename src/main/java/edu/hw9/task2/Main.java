package edu.hw9.task2;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    private final static int FILES_THRESHOLD = 1000;
    private final static int FILE_SIZE = 1024;
    private final static String FILE_EXTENSION = ".txt";

    private Main() {
    }

    public static void main(String[] args) {
        File directory = new File("C:\\");
        try (ForkJoinPool forkJoinPool = new ForkJoinPool();) {
            List<File> directoriesWithManyFiles = forkJoinPool.invoke(new FileSearchTask(directory, FILES_THRESHOLD,
                "", 0
            ));
            List<File> filesMatchingPredicate = forkJoinPool.invoke(new FileSearchTask(directory,
                0, FILE_EXTENSION, FILE_SIZE
            ));

            log.info("Directories with more than 1000 files: " + directoriesWithManyFiles);
            log.info("Files matching the predicate: " + filesMatchingPredicate);
        }

    }
}
