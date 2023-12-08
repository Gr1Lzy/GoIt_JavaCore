package org.example.module12_2;

import java.util.Arrays;

public class FizzBuzzGame {
    private final String[] array;

    public FizzBuzzGame(int length) {
        array = new String[length];
    }

    synchronized void fizz(int index, int number) {
        if (number % 3 == 0 && number % 5 != 0) {
            array[index] = "fizz";
        }
    }

    synchronized void buzz(int index, int number) {
        if (number % 3 != 0 && number % 5 == 0) {
            array[index] = "buzz";
        }
    }

    synchronized void fizzbuzz(int index, int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            array[index] = "fizzbuzz";
        }
    }

    synchronized void number(int index, int number) {
        if (number % 3 != 0 && number % 5 != 0) {
            array[index] = String.valueOf(number);
        }
    }

    public String start() {
        Thread threadA = new Thread(() -> {
            for (int index = 0, number = 1; index < array.length; index++) {
                fizz(index, number++);
            }
        });

        Thread threadB = new Thread(() -> {
            for (int index = 0, number = 1; index < array.length; index++) {
                buzz(index, number++);
            }
        });

        Thread threadC = new Thread(() -> {
            for (int index = 0, number = 1; index < array.length; index++) {
                fizzbuzz(index, number++);
            }
        });

        Thread threadD = new Thread(() -> {
            for (int index = 0, number = 1; index < array.length; index++) {
                number(index, number++);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Arrays.toString(array);
    }
}
