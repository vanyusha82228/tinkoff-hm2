package edu.hm3;

import java.util.Iterator;
import java.util.List;

public class Task8<T> implements Iterator<T> {
    private List<T> collection;
    private int currentIndex = 0;

    public Task8(List<T> collection) {
        this.collection = collection;
        this.currentIndex = collection.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public T next() {
        if (hasNext()) {
            T element = collection.get(currentIndex);
            currentIndex--;
            return element;
        } else {
            return null;
        }
    }
}
