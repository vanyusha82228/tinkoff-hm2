package edu.hm6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {

    int MAGIC_BYTE_MASK = 0xFF;

    default AbstractFilter and(AbstractFilter other) {
        return path -> this.accept(path) && other.accept(path);
    }

    AbstractFilter REGULAR_FILE = Files::isRegularFile;
    AbstractFilter IS_READABLE = Files::isReadable;

    static AbstractFilter largerThan(long size) {
        return path -> {
            try {
                return Files.size(path) > size;
            } catch (IOException e) {
                logError(e);
                return false;
            }
        };
    }

    static AbstractFilter magicNumber(int... magicBytes) {
        return path -> {
            try {
                byte[] fileBytes = Files.readAllBytes(path);
                if (fileBytes.length >= magicBytes.length) {
                    for (int i = 0; i < magicBytes.length; i++) {
                        if ((fileBytes[i] & MAGIC_BYTE_MASK) != magicBytes[i]) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (IOException e) {
                logError(e);
            }
            return false;
        };
    }

    static AbstractFilter globMatches(String glob) {
        return path -> path.getFileName().toString().matches(glob);
    }

    static AbstractFilter regexContains(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return path -> pattern.matcher(path.getFileName().toString()).find();
    }

    @Override
    boolean accept(Path entry);

    static void logError(IOException e) {
        Logger logger = Logger.getLogger(AbstractFilter.class.getName());
        logger.log(Level.SEVERE, "Error occurred:", e);
    }
}
