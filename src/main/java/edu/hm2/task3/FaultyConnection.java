package edu.hm2.task3;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FaultyConnection implements Connection {
    @Override
    public void execute(String command) {
        try {
            log.info("Выаполняется проблемное соединение " + command);
        } catch (ConnectionException e) {
            log.error("Ошибочная execute команда: " + e.getMessage(), e);
        }
    }

    @Override
    public void close() {
        log.info("Закрытие проблемного соединения");
    }
}
