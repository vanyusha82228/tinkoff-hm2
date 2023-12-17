package edu.hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Task1 {

    private Task1() {
    }

    private static final int MINUTES_IN_HOUR = 60;
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd, HH:mm";

    public static String timeCounter(String inputDate1, String inputDate2) {
        if (validDate(inputDate1, inputDate2)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
            LocalDateTime dateTime1 = LocalDateTime.parse(inputDate1, formatter);
            LocalDateTime dateTime2 = LocalDateTime.parse(inputDate2, formatter);
            Duration duration = Duration.between(dateTime1, dateTime2);
            long minutes = duration.toMinutes();
            long hours = minutes / MINUTES_IN_HOUR;
            long remainingMinutes = minutes % MINUTES_IN_HOUR;

            return hours + "ч " + remainingMinutes + "м";
        } else {
            return "Некорректная дата";
        }
    }

    private static boolean validDate(String inputDate1, String inputDate2) {

        String dateTimePattern = DATE_TIME_PATTERN;
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateTimePattern);
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(inputDate1);
            dateFormat.parse(inputDate2);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }
}
