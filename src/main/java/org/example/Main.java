package org.example;

import org.example.module11_1.OddNames;
import org.example.module11_2.UpperCaseSortedNames;
import org.example.module11_3.SortedNumbers;
import org.example.module11_4.MathRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Ivan");
        names.add("John");
        names.add("Andrey");
        names.add("Peter");

        System.out.println(OddNames.get(names));                                        //#1

        System.out.println(UpperCaseSortedNames.get(names));                            //#2


        String[] numbers = {"1, 2, 0", "4, 5"};

        System.out.println(SortedNumbers.get(numbers));                                 //#3


        long seed = System.currentTimeMillis();

        System.out.println(MathRandom.generate(seed).toList());                         //#4
    }
}