package edu.hw9.task2;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class FileSearchTask extends RecursiveTask<List<File>> {

    private final File directory;
    private final int thresHold;
    private final String extension;
    private final long size;

    public FileSearchTask(File directory, int thresHold, String extension, long size) {
        this.directory = directory;
        this.thresHold = thresHold;
        this.extension = extension;
        this.size = size;
    }

    @Override
    protected List<File> compute() {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null && files.length > thresHold) {
                return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .flatMap(subtask -> subtask.join().stream())
                    .collect(Collectors.toList());
            } else {
                return processFiles(files);
            }
        } else {
            return processFiles(new File[] {directory});
        }
    }

    private List<File> processFiles(File[] files) {
        if (files == null) {
            return List.of();
        }

        return List.of(files)
            .parallelStream()
            .filter(file -> file.getName().endsWith(extension) && file.length() > size)
            .collect(Collectors.toList());
    }

    private List<FileSearchTask> createSubtasks() {
        return List.of(directory.listFiles())
            .parallelStream()
            .map(subdirectory -> new FileSearchTask(subdirectory, thresHold, extension, size))
            .collect(Collectors.toList());
    }
}
