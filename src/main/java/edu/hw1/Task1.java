package edu.hw1;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Task1 {
    @SuppressWarnings("unused")
    private Task1() {
    }

    private static final int SECOND_IN_MIN = 60;
    private static final String INCORRECT_TIME_MESSAGE = "Некоректное время";

    public static int getVideoLength(String videoLength) {
        String[] dividedTime = videoLength.split(":");
        int minutes = 0;
        int seconds = 0;
        if (dividedTime.length == 2) {
            minutes = Integer.parseInt(dividedTime[0]);
            seconds = Integer.parseInt(dividedTime[1]);
        } else {
            log.info(INCORRECT_TIME_MESSAGE);
            return -1;
        }

        boolean checkMinAndSec = minutes >= Integer.MAX_VALUE - SECOND_IN_MIN || minutes < 0 || seconds < 0;

        if (checkMinAndSec) {
            log.info(INCORRECT_TIME_MESSAGE);
            return -1;
        }

        if (seconds >= SECOND_IN_MIN) {
            return -1;
        } else {
            return minutes * SECOND_IN_MIN + seconds;
        }
    }
}
