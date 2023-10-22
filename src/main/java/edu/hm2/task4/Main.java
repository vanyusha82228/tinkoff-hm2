package edu.hm2.task4;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        CallingInfo info = CallerInfo.callingInfo();
        log.info("Вызывающий класс: " + info.className());
        log.info("Вызывающий метод: " + info.methodName());
    }
}
