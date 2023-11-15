package edu.hm7.task3;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class SynchronizedPersonDatabase implements PersonDatabase {
    private final Map<Integer, Person> idToPersonMap = new HashMap<>();
    private final Map<String, Person> adressToPersonMap = new HashMap<>();
    private final Map<String, Person> nameToPersonMap = new HashMap<>();
    private final Map<String, Person> phoneToPersonMap = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        idToPersonMap.put(person.id(), person);
        adressToPersonMap.put(person.address(), person);
        nameToPersonMap.put(person.name(), person);
        phoneToPersonMap.put(person.phoneNumber(), person);

    }

    @Override
    public synchronized void delete(int id) {
        Person person = idToPersonMap.get(id);
        if (person != null) {
            idToPersonMap.remove(id);
            adressToPersonMap.remove(person.address());
            nameToPersonMap.remove(person.name());
            phoneToPersonMap.remove(person.phoneNumber());
        }
    }

    @Override
    public synchronized @Nullable Person findByName(String name) {
        return nameToPersonMap.get(name);
    }

    @Override
    public synchronized @Nullable Person findByAddress(String address) {
        return adressToPersonMap.get(address);
    }

    @Override
    public synchronized @Nullable Person findByPhone(String phone) {
        return phoneToPersonMap.get(phone);
    }
}
