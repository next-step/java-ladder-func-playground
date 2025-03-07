package model;

import java.util.*;
import java.util.stream.*;

public class ReservedPositionGenerator {
    private static final Random RANDOM = new Random();

    public static List<Set<Integer>> generate(int width, int height) {
        List<Set<Integer>> reserved = IntStream.range(0, height)
                .mapToObj(i -> new HashSet<Integer>())
                .collect(Collectors.toList());

        IntStream.range(0, width)
                .forEach(i -> reserved.get(RANDOM.nextInt(height)).add(i));

        return reserved;
    }
}
