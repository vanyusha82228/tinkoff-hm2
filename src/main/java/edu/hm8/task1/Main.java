package edu.hm8.task1;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        new Thread(Task1::startServer).start();

        new Thread(QuoteClient::startClient).start();
        new Thread(QuoteClient::startClient).start();
        new Thread(QuoteClient::startClient).start();
    }
}

