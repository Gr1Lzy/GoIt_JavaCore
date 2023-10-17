package org.example;

import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class MyArrayList<T> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length + 5);
        }
        elements[size++] = value;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    public void clear() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return elements[index];
    }
}
