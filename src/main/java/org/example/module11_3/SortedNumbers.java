package org.example.module11_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedNumbers {
    public static List<Integer> get(String[] numArray) {
        return Arrays.stream(numArray)
                .flatMap(numbers -> Arrays.stream(numbers.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}
