package org.example.module11_1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddNames {
    public static String get(List<String> nameList) {
        return IntStream.range(0, nameList.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> (index) + ". " + nameList.get(index))
                .collect(Collectors.joining(", "));
    }
}
