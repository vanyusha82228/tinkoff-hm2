package edu.hm8.task3;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class PasswordCracker {
    private Map<String, String> passwordDatabase;
    private static final int RADIX = 16;

    public PasswordCracker(Map<String, String> passwordDatabase) {
        this.passwordDatabase = passwordDatabase;
    }

    public Map<String, String> crackPasswords() {
        Map<String, String> foundPasswords = new HashMap<>();
        String password = "";
        while ((password = nextPassword(password)) != null) {
            String hash = md5(password);
            if (passwordDatabase.containsKey(hash)) {
                String username = passwordDatabase.get(hash);
                foundPasswords.put(username, password);
            }
        }
        return foundPasswords;
    }

    private static String nextPassword(String currentPassword) {
        if (currentPassword.isEmpty()) {
            return "a";
        } else {
            char lastChar = currentPassword.charAt(currentPassword.length() - 1);
            if (lastChar == 'z') {
                return currentPassword + "a";
            } else {
                return currentPassword.substring(0, currentPassword.length() - 1) + (char) (lastChar + 1);
            }
        }
    }

    private static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            return no.toString(RADIX);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
