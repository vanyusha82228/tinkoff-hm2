package edu.hm6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Task2 {
    private Task2() {
    }

    public static void cloneFile(Path path) {
        try {
            Path originalFile = path.getFileName();
            Path parentDir = path.getParent();
            String fileName = originalFile.toString();
            String fileExtension = "";

            int dotIndex = fileName.lastIndexOf(".");
            if (dotIndex != -1) {
                fileExtension = fileName.substring(dotIndex);
                fileName = fileName.substring(0, dotIndex);
            }

            int copyNumber = 1;
            Path copyPath = parentDir.resolve(fileName + " — копия" + fileExtension);

            while (Files.exists(copyPath)) {
                copyNumber++;
                copyPath = parentDir.resolve(fileName + " — копия (" + copyNumber + ")" + fileExtension);
            }

            Files.copy(path, copyPath);

            log.info("Файл успешно скопирован: " + copyPath);
        } catch (IOException e) {
            log.error(e.getMessage());

        }
    }
}
