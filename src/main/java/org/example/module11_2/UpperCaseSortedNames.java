package org.example.module11_2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseSortedNames {
    public static String get(List<String> nameList) {
        return nameList.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
    }
}

