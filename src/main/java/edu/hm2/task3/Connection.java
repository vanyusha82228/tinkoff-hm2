package edu.hm2.task3;

public interface Connection extends java.lang.AutoCloseable {
    void execute(String command);

    @Override
    void close();

}
