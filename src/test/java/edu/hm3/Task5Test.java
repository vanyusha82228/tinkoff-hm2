package edu.hm3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @Test
    public void testParseContactsASC(){
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        List<String> result = Task5.parseContacts(names,"ASC");
        List<String> expected = List.of("Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke");
        assertEquals(expected,result);
    }
    @Test
    public void testParseContactsDESC() {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        List<String> result = Task5.parseContacts(names, "DESC");
        List<String> expected = List.of("John Locke", "David Hume", "Rene Descartes", "Thomas Aquinas");
        assertEquals(expected, result);
    }
    @Test
    public void testParseContactsEmpty() {
        String[] names = {};
        List<String> result = Task5.parseContacts(names, "DESC");
        List<String> expected = List.of();
        assertEquals(expected, result);
    }
    @Test
    public void testParseContactsNull() {
        String[] names = null;
        List<String> result = Task5.parseContacts(names, "DESC");
        List<String> expected = List.of();
        assertEquals(expected, result);
    }
}
