package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    void testValidDateFormats() {
        String[] validDateStrings = {
            "2020-10-10",
            "2020-12-2",
            "1/3/1976",
            "1/3/20"
        };

        for (String dateString : validDateStrings) {
            Optional<LocalDate> result = Task3.parseDate(dateString);
            assertTrue(result.isPresent(), "Failed to parse valid date string: " + dateString);
        }
    }

    @Test
    void testSpecialCases() {
        String[] specialDateStrings = {
            "tomorrow",
            "today",
            "yesterday",
            "1 day ago",
            "2234 days ago"
        };

        for (String dateString : specialDateStrings) {
            Optional<LocalDate> result = Task3.parseDate(dateString);
            assertTrue(result.isPresent(), "Failed to parse special date string: " + dateString);
        }
    }

    @Test
    void testInvalidDateFormats() {
        String[] invalidDateStrings = {
            "invalid",
            "12-34-56",
            "not_a_date",
            "2020/10/10"
        };

        for (String dateString : invalidDateStrings) {
            Optional<LocalDate> result = Task3.parseDate(dateString);
            assertTrue(result.isEmpty(), "Unexpectedly parsed invalid date string: " + dateString);
        }
    }
}
