package edu.hm8.task3;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    private final static int NUM_THREADS = 4;

    private Main() {
    }

    public static void main(String[] args) {

        // База данных паролей
        Map<String, String> passwordDatabase = new HashMap<>();
        passwordDatabase.put("e10adc3949ba59abbe56e057f20f883e", "a.v.petrov");
        passwordDatabase.put("d8578edf8458ce06fbc5bb76a58c5ca4", "v.v.belov");
        passwordDatabase.put("482c811da5d5b4bc6d497ffa98491e38", "a.s.ivanov");
        passwordDatabase.put("5f4dcc3b5aa765d61d8327deb882cf99", "k.p.maslov");

        PasswordCracker passwordCracker = new PasswordCracker(passwordDatabase);
        Map<String, String> foundPasswords = passwordCracker.crackPasswords();

        // Вывод найденных паролей
         log.info("Найденные пароли:");
        for (Map.Entry<String, String> entry : foundPasswords.entrySet()) {
             log.info("Пользователь: " + entry.getKey() + ", Пароль: " + entry.getValue());
        }

        // Многопоточный перебор паролей

    }
}

