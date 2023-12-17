package edu.hm7.task3ReadWriteLock;

import edu.hm7.task3.Person;
import edu.hm7.task3.PersonDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.Nullable;

public class SynchronizedPersonDatabaseReadWriteLock implements PersonDatabase {

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Map<Integer, Person> idToPersonMap = new HashMap<>();
    private final Map<String, Person> adressToPersonMap = new HashMap<>();
    private final Map<String, Person> nameToPersonMap = new HashMap<>();
    private final Map<String, Person> phoneToPersonMap = new HashMap<>();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            idToPersonMap.put(person.id(), person);
            adressToPersonMap.put(person.address(), person);
            nameToPersonMap.put(person.name(), person);
            phoneToPersonMap.put(person.phoneNumber(), person);
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public synchronized void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = idToPersonMap.get(id);
            if (person != null) {
                idToPersonMap.remove(id);
                adressToPersonMap.remove(person.address());
                nameToPersonMap.remove(person.name());
                phoneToPersonMap.remove(person.phoneNumber());
            }
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public @Nullable Person findByName(String name) {
        lock.readLock().lock();
        try {
            return nameToPersonMap.get(name);
        } finally {
            lock.readLock().unlock();
        }

    }

    @Override
    public @Nullable Person findByAddress(String address) {
        lock.readLock().lock();
        try {
            return adressToPersonMap.get(address);
        } finally {
            lock.readLock().unlock();
        }

    }

    @Override
    public @Nullable Person findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return adressToPersonMap.get(phone);
        } finally {
            lock.readLock().unlock();
        }
    }
}
