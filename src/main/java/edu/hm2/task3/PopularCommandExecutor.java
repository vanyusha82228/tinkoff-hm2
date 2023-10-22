package edu.hm2.task3;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        int attempts = 0;
        Exception lastException = new Exception();
        while (attempts < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
            } catch (ConnectionException e) {
                lastException = e;
                // Логируйте ошибку выполнения команды
                log.error("Failed to execute command '{}'. Attempt {}/{}.",
                    command, attempts + 1, maxAttempts
                );
            }
            attempts++;
        }

        if (lastException != null) {
            // Логирование, если команду не удалось выполнить после всех попыток
            log.error("Failed to execute command '{}' after {} attempts. Last exception: {}",
                command, maxAttempts, lastException.getMessage()
            );
        } else {
            log.error("Failed to execute command '{}' after {} attempts.", command, maxAttempts);
        }
    }
}


