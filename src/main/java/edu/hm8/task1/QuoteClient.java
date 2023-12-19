package edu.hm8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class QuoteClient {

    private static final int PORT = 5555;

    private QuoteClient() {
    }

    public static void startClient() {
        try (Socket socket = new Socket("localhost", PORT);
             OutputStream outputStream = socket.getOutputStream();
             InputStream inputStream = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            Scanner scanner = new Scanner(System.in);

            while (true) {
                log.info("Введите ключевое слово: ");
                String keyword = scanner.nextLine();

                if (keyword.equalsIgnoreCase("exit")) {
                    break;
                }

                outputStream.write((keyword + "\n").getBytes());

                String response = reader.readLine();
                log.info("Ответ от сервера: " + response);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
