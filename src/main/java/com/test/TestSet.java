package com.test;

public class TestSet<T> implements LimitedSet<T> {
    private final Entry<T>[] array;
    private static final int CAPACITY = 10;

    public TestSet() {
        array = new Entry[CAPACITY];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Entry<>();
        }
    }

    @Override
    public void add(T t) {
        int min = CAPACITY;
        int index = 0;
        boolean contains = false;

        for (int i = 0; i < array.length; i++) {
            if (t.equals(array[i].value)) {
                contains = true;
                break;
            } else if (min > array[i].counter) {
                min = array[i].counter;
                index = i;
            }
        }

        if (!contains) {
            array[index].value = t;
            array[index].counter = 0;
        }

    }

    @Override
    public boolean remove(T t) {
        for (int i = 0; i < array.length; i++) {
            if (t.equals(array[i].value)) {
                array[i] = new Entry<>();
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean contains(T t) {
        for (Entry<T> entry : array) {
            if (t.equals(entry.value)) {
                entry.counter++;
                return true;
            }
        }
        return false;

    }

    static class Entry<T> {
        T value;
        int counter = -1;
    }
}
