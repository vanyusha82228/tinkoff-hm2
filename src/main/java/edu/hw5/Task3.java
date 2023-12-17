package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Task3 {
    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String dataTime) {
        Optional<LocalDate> result = Optional.empty();


        if (dataTime.equalsIgnoreCase("tomorrow")) {
            result = Optional.of(LocalDate.now().plusDays(1));
        } else if (dataTime.equalsIgnoreCase("today")) {
            result = Optional.of(LocalDate.now());
        } else if (dataTime.equalsIgnoreCase("yesterday")) {
            result = Optional.of(LocalDate.now().minusDays(1));
        } else if (dataTime.matches("\\d+ day(?:s)? ago")) {
            int daysAgo = Integer.parseInt(dataTime.split(" ")[0]);
            result = Optional.of(LocalDate.now().minusDays(daysAgo));
        } else if (dataTime.matches("\\d+ days? ago")) {
            int daysAgo = Integer.parseInt(dataTime.split(" ")[0]);
            result = Optional.of(LocalDate.now().minusDays(daysAgo));
        } else {
            DateTimeFormatter[] formatters = {
                DateTimeFormatter.ofPattern("yyyy-M-d"),
                DateTimeFormatter.ofPattern("M/d/yyyy"),
                DateTimeFormatter.ofPattern("M/d/yy"),
                DateTimeFormatter.ofPattern("yyyy-MM-d"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("d/MM/yyyy"),
                DateTimeFormatter.ofPattern("d/MM/yy"),
                DateTimeFormatter.ofPattern("MMMM d"),
                DateTimeFormatter.ofPattern("MMMM dd"),
                DateTimeFormatter.ofPattern("MMMM dd, yyyy"),
                DateTimeFormatter.ofPattern("d 'day' 'ago'")
            };

            for (DateTimeFormatter formatter : formatters) {
                try {
                    LocalDate date = LocalDate.parse(dataTime, formatter);
                    result = Optional.of(date);
                    break;
                } catch (Exception e) {

                }
            }
        }

        return result;
    }
}
