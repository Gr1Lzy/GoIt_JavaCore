package org.example;

import org.example.module12_2.FizzBuzzGame;

public class Main {
    public static void main(String[] args) {
        FizzBuzzGame fizzBuzzGame = new FizzBuzzGame(15);

        System.out.println(fizzBuzzGame.start());
    }
}