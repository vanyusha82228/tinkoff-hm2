package edu.hw8;

import edu.hm8.task1.QuoteClient;
import edu.hm8.task1.Task1;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.CountDownLatch;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testClientAndServerInteraction() throws IOException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            Task1.startServer();
            latch.countDown();
        }).start();

        waitForServerToStart();

        String input = "личности\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        new Thread(() -> {
            QuoteClient.startClient();
            latch.countDown();
        }).start();

        latch.await();

        // Check the output
        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("Введите ключевое слово: Клиент подключен\n");
        expectedOutput.append("Получен запрос от клиента: личности\n");
        expectedOutput.append("Отправлен ответ клиенту: Не переходи на личности там, где их нет\n");
        expectedOutput.append("Введите ключевое слово: ");

        assertEquals(expectedOutput.toString(), outContent.toString().replaceAll("\r", ""));
    }

    private void waitForServerToStart() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
