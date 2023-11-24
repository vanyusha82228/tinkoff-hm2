package edu.hm8.task1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Task1 {
    private Task1() {
    }

    private static final int MAX_CONNECTION = 3;
    private static final Semaphore SEMAPHORE = new Semaphore(MAX_CONNECTION);
    private static final int PORT = 5555;

    public static void startServer() {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTION);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            log.info("Сервер запущен. Ожидание соединений...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(() -> handClient(clientSocket));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }

    private static void handClient(Socket clientSocket) {
        try {
            SEMAPHORE.acquire();
            try (InputStream inputStream = clientSocket.getInputStream();
                 OutputStream outputStream = clientSocket.getOutputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                log.info("Клиент подключен");

                String request;

                while ((request = reader.readLine()) != null) {

                    log.info("Получен запрос от клиента: {}", request);
                    String response = getResponse(request);
                    log.info("Отправлен ответ клиенту: {}", response);
                    outputStream.write((response + "\n").getBytes());
                    outputStream.flush();
                }

            } finally {
                clientSocket.close();
                SEMAPHORE.release();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    private static String getResponse(String request) {
        return switch (request.toLowerCase()) {
            case "личности" -> "Не переходи на личности там, где их нет";
            case "оскорбления" -> "Если твои противники перешли на личные оскорбления, будь уверена — "
                + "твоя победа не за горами";
            case "глупый" -> "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... "
                + "Ты просто бог идиотизма.";
            case "интеллект" -> "Чем ниже интеллект, тем громче оскорбления";
            default -> "Неизвестный запрос";
        };
    }
}
