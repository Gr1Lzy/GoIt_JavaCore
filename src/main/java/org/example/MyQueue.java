package org.example;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class MyQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    public MyQueue() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length + 5);
        }
        elements[size++] = value;
    }

    public void clear() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return elements[0];
    }

    public T poll() {
        T temp = peek();
        System.arraycopy(elements, 1, elements, 0, size - 1);
        elements[--size] = null;
        return temp;
    }
}
