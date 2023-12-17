package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private static final int DAY_OF_MONTH_13 = 13;

    private Task2() {
    }

    public static List<LocalDate> findFriday13(int inputYear) {
        List<LocalDate> fridays13 = new ArrayList<>();
        LocalDate date = LocalDate.of(inputYear, Month.JANUARY, DAY_OF_MONTH_13);

        while (date.getYear() == inputYear) {
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays13.add(date);
            }
            date = date.plusMonths(1);
        }

        return fridays13;
    }

    public static LocalDate findNextFridayThe13th(LocalDate currentDate) {
        LocalDate nextFriday = currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        while (nextFriday.getDayOfMonth() != DAY_OF_MONTH_13) {
            nextFriday = nextFriday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        return nextFriday;

    }
}
