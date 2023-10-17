package org.example;

import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class MyStack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    public MyStack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T value) {
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

    public T peek() {
        if (size == 0) {
            return null;
        }
        return elements[size - 1];
    }

    public T pop() {
        if (size == 0) {
            return null;
        }
        return elements[size--] = null;
    }
}
