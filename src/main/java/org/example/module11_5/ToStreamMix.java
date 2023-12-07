package org.example.module11_5;

import java.util.List;
import java.util.stream.Stream;

public class ToStreamMix {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        List<T> firstList = first.toList();
        List<T> secondList = second.toList();

        return Stream.iterate(0, i -> i + 1)
                .limit(Math.min(firstList.size(), secondList.size()))
                .flatMap(i -> Stream.of(firstList.get(i), secondList.get(i)));
    }
}

