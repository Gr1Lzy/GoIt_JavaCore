package org.example;

import java.util.Objects;

public class MyLinkedList<T> {
    private int size = 0;
    static class Node<T> {
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }
    private Node<T> first;
    private Node<T> last;


    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prevNode = getNodeByIndex(index - 1);
            prevNode.next = prevNode.next.next;
            if (index == size - 1) {
                last = prevNode;
            }
        }
        size--;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }
    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).value;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
