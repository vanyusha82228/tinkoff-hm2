//package edu.hw8;
//
//import edu.hm8.task1.QuoteClient;
//import edu.hm8.task1.Task1;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestTask1 {
//    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private static final PrintStream originalOut = System.out;
//
//    @BeforeAll
//    public static void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @AfterAll
//    public static void restoreStreams() {
//        System.setOut(originalOut);
//    }
//
//    @Test
//    public void testQuoteClient() {
//        // Подготовка входных данных для теста QuoteClient
//        String input = "ключевое слово\nexit\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        // Запуск QuoteClient
//        QuoteClient.startClient();
//
//        // Проверка вывода на консоль
//        assertEquals("Введите ключевое слово: Ответ от сервера: Неизвестный запрос\n", outContent.toString());
//    }
//
//    @Test
//    public void testTask1() {
//        // Создание сервера в отдельном потоке
//        new Thread(() -> Task1.startServer()).start();
//
//        // Подготовка входных данных для теста QuoteClient
//        String input = "личности\nexit\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        // Запуск QuoteClient
//        QuoteClient.startClient();
//
//        // Проверка вывода на консоль
//        assertEquals("Введите ключевое слово: Ответ от сервера: Не переходи на личности там, где их нет\n", outContent.toString());
//    }
//}
