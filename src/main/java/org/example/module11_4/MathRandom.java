package org.example.module11_4;

import java.util.stream.Stream;

public class MathRandom {
    static long a = 25214903917L;
    static long c = 11L;
    static long m = (long) Math.pow(2, 48);

    public static Stream<Long> generate(long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m)
                .limit(10);
    }

}
