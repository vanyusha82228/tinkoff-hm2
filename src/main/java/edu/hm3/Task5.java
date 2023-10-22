package edu.hm3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Task5 {
    private Task5() {
    }

    public static List<String> parseContacts(String[] names, String query) {
        if (names == null || names.length == 0) {
            return new ArrayList<>();
        }

        List<String> sortedContacts = new ArrayList<>();
        Collections.addAll(sortedContacts, names);

        Comparator<String> comparator = (c1, c2) -> {
            String lastName1 = getLastName(c1);
            String lastName2 = getLastName(c2);

            if (query.equals("ASC")) {
                return lastName1.compareTo(lastName2);
            } else if (query.equals("DESC")) {
                return lastName2.compareTo(lastName1);
            } else {
                log.info("Неправильный запрос сортировки");
                return 0;
            }

        };

        Collections.sort(sortedContacts, comparator);
        return sortedContacts;
    }

    private static String getLastName(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length > 1) {
            return parts[parts.length - 1];
        } else {
            return parts[0];
        }
    }
}
