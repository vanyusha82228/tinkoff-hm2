package edu.hm2.task3;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StableConnection implements Connection {
    @Override
    public void execute(String command) {
        log.info("Выполняется сабильное подклчение " + command);
    }

    @Override
    public void close() {
        log.info("Закрываем стабильное соединение");
    }
}
